package io.github.rcneg.alexsmobsdelight.events;

import com.github.alexthe666.alexsmobs.entity.AMEntityRegistry;
import com.github.alexthe666.alexsmobs.entity.EntityGrizzlyBear;
import com.github.alexthe666.alexsmobs.entity.EntityOrca;
import com.github.alexthe666.alexsmobs.entity.EntitySeaBear;
import com.github.alexthe666.alexsmobs.item.AMItemRegistry;
import com.github.alexthe666.alexsmobs.misc.AMSoundRegistry;
import io.github.rcneg.alexsmobsdelight.config.Config;
import io.github.rcneg.alexsmobsdelight.helper.ItemHelper;
import io.github.rcneg.alexsmobsdelight.init.BlockRegistry;
import io.github.rcneg.alexsmobsdelight.init.ItemRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SculkShriekerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class InteractEvents {
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        if (!(event.getLevel() instanceof ServerLevel level)) return;

        var player = event.getPlayer();
        ItemStack tool = player.getMainHandItem();

        if (!tool.is(ItemRegistry.MANTIS_SHRIMP_HAMMER.get()) && !tool.is(ItemRegistry.MANTIS_SHRIMP_SCYTHE.get()) && !tool.is(ItemRegistry.MANTIS_SHRIMP_SHOVEL.get()) && !tool.is(ItemRegistry.MANTIS_SHRIMP_AXE.get())) return;

        BlockPos pos = event.getPos();
        List<ItemStack> drops = ItemHelper.getBlockDrops(level, pos, player, tool);
        List<ItemStack> newDrops = new ArrayList<>();
        for (ItemStack in : drops) {
            if (ItemHelper.itemHasSmeltResult(in, level)) {
                ItemStack out = ItemHelper.getItemSmeltResult(in, level);
                if (!out.isEmpty()) {
                    out = out.copy();
                    out.setCount(out.getCount() * in.getCount());
                    newDrops.add(out);
                    continue;
                }
            }
            newDrops.add(in);
        }
        level.removeBlock(pos, false);

        for (ItemStack stack : newDrops) {
            Containers.dropItemStack(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, stack
            );
        }
        level.playSound((Player)null, pos, AMSoundRegistry.MANTIS_SHRIMP_SNAP.get(), SoundSource.BLOCKS);
    }

    @SubscribeEvent
    public static void onPlayerRightClickEntity(PlayerInteractEvent.EntityInteract event) {
        if(!event.getLevel().isClientSide){
            if(event.getEntity().getMainHandItem().is(ItemRegistry.SEA_BEAR_STEW.get()) && event.getTarget() instanceof EntityGrizzlyBear bear && bear.isInWater()){
                EntitySeaBear seabear = (EntitySeaBear)((EntityType)AMEntityRegistry.SEA_BEAR.get()).create(event.getLevel());
                seabear.moveTo(bear.getX(), bear.getY(), bear.getZ());
                if(event.getLevel() instanceof ServerLevel serverLevel){
                    serverLevel.sendParticles(ParticleTypes.CLOUD, bear.getX(), bear.getY(), bear.getZ(), 200, 1.0D, 1.0D, 1.0D, 0.0D);
                }
                seabear.playSound(SoundEvents.ZOMBIE_CONVERTED_TO_DROWNED, 1, 1);
                event.getLevel().addFreshEntity(seabear);
                bear.discard();
                if (!event.getEntity().getAbilities().instabuild) {
                    event.getEntity().getMainHandItem().shrink(1);
                }
            }
            if(event.getEntity().getMainHandItem().is(ItemRegistry.SEAL_MEAT.get()) && event.getTarget() instanceof EntityOrca orca){
                if(event.getLevel() instanceof ServerLevel serverLevel){
                    serverLevel.sendParticles(ParticleTypes.HAPPY_VILLAGER, orca.getX(), orca.getY(), orca.getZ(), 30, 1.5D, 1.0D, 1.5D, 3.0D);
                }
                orca.playSound(SoundEvents.GENERIC_EAT, 1, 0.5f);
                if(orca.getRandom().nextInt(100) <= Config.ORCA_GIFT_CHANCE.get()){
                    ItemStack drop = new ItemStack(ItemRegistry.ORCAS_LEAP_SOUP.get());
                    orca.spawnAtLocation(drop);
                }
                if (!event.getEntity().getAbilities().instabuild) {
                    event.getEntity().getMainHandItem().shrink(1);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (event.getHand() != InteractionHand.MAIN_HAND) return;

        Level level = event.getLevel();
        if (!level.isClientSide()){
            Player player = event.getEntity();
            ItemStack stack = event.getItemStack();
            Direction face = event.getFace();
            BlockPos clickedPos = event.getPos();
            BlockPos placePos = clickedPos.relative(face);
            BlockState target = level.getBlockState(placePos);
            boolean placed = false;
            if (face == Direction.DOWN || face == Direction.UP || !level.mayInteract(player, placePos) || !player.mayUseItemAt(placePos, face, stack) || !target.canBeReplaced()) return;
            if (stack.is(AMItemRegistry.ACACIA_BLOSSOM.get()) && level.getBlockState(clickedPos).is(BlockTags.ACACIA_LOGS)) {
                BlockState placeState = BlockRegistry.ACACIA_BLOSSOM_BLOCK.get().defaultBlockState();
                int flags = Block.UPDATE_ALL;
                placed = level.setBlock(placePos, placeState.setValue(HorizontalDirectionalBlock.FACING, event.getFace().getOpposite()), flags);
            }
            if (stack.is(AMItemRegistry.BANANA.get()) && level.getBlockState(clickedPos).is(BlockTags.JUNGLE_LOGS)) {
                BlockState placeState = BlockRegistry.BANANA_BLOCK.get().defaultBlockState();
                int flags = Block.UPDATE_ALL;
                placed = level.setBlock(placePos, placeState.setValue(HorizontalDirectionalBlock.FACING, event.getFace().getOpposite()), flags);
            }
            if (placed){
                level.playSound(null, placePos, SoundEvents.GRASS_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
                event.setCancellationResult(InteractionResult.SUCCESS);
                event.setCanceled(true);
            }
        }

    }

    @SubscribeEvent
    public static void modifyUnderwaterBreakSpeed(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();
        float speed = event.getNewSpeed();

        ItemStack tool = player.getMainHandItem();
        if (tool.is(ItemRegistry.WHALE_TOOTH_PICKAXE.get())) {
            if (player.isEyeInFluid(FluidTags.WATER) && !EnchantmentHelper.hasAquaAffinity(player)) {
                speed *= 5.0F;
            }
        }

        event.setNewSpeed(speed);
    }
}
