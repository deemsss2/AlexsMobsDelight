package io.github.rcneg.alexsmobsdelight.events;

import com.github.alexthe666.alexsmobs.effect.AMEffectRegistry;
import com.github.alexthe666.alexsmobs.entity.EntityTarantulaHawk;
import com.github.alexthe666.alexsmobs.misc.AMSoundRegistry;
import io.github.rcneg.alexsmobsdelight.accessor.IEntitySeagullData;
import io.github.rcneg.alexsmobsdelight.config.Config;
import io.github.rcneg.alexsmobsdelight.init.EffectRegistry;
import io.github.rcneg.alexsmobsdelight.init.ItemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class AttackEvents {

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event){
        LivingEntity entity = event.getEntity();
        RandomSource random = entity.getRandom();
        if (event.getEntity().level() instanceof ServerLevel level && event.getSource().getEntity() instanceof LivingEntity attacker) {
            float lootHP = (float) (Config.CROCODILE_KNIFE_HEALTH.get() * 1.0f);
            if(attacker.getMainHandItem().is(ItemRegistry.CROCODILE_KNIFE.get())
                    && !Config.LOOTING_BLACKLIST.contains(entity.getType())){
                if(lootHP * 2.0f * attacker.getMaxHealth() > entity.getMaxHealth()){
                    float p = Mth.clamp((((lootHP * 2.0f * attacker.getMaxHealth()) - entity.getMaxHealth()) / (lootHP * attacker.getMaxHealth())), 0, 1);
                    if(attacker instanceof Player player && p < 1){
                        player.displayClientMessage(Component.translatable("message.alexsmobsdelight.crocodile_knife_1").withStyle(ChatFormatting.GOLD), true);
                    }
                    if(random.nextInt(100) <= (float)Config.CROCODILE_KNIFE_LOOT.get() * p){
                        ResourceLocation lootId = entity.getLootTable();
                        LootParams ctx = new LootParams.Builder(level)
                                .withParameter(LootContextParams.THIS_ENTITY, entity)
                                .withParameter(LootContextParams.ORIGIN, entity.position())
                                .withParameter(LootContextParams.DAMAGE_SOURCE, event.getSource())
                                .withOptionalParameter(LootContextParams.KILLER_ENTITY, attacker)
                                .create(LootContextParamSets.ENTITY);
                        List<ItemStack> drops = level.getServer().getLootData().getLootTable(lootId).getRandomItems(ctx);
                        if (!drops.isEmpty()) {
                            if(!Config.CROCODILE_KNIFE_FULL_DROP.get()){
                                ItemStack drop = drops.get(attacker.getRandom().nextInt(drops.size())).copy();
                                drop.setCount(1);
                                entity.spawnAtLocation(drop);
                            }else{
                                for(ItemStack drop : drops){
                                    entity.spawnAtLocation(drop);
                                }
                            }
                        }
                        //Objects.requireNonNull(level.getServer()).getLootData().getLootTable(lootId).getRandomItems(ctx, s -> entity.spawnAtLocation(s, 1.0F));
                        level.playSound((Player)null, entity.getOnPos(), AMSoundRegistry.CROCODILE_HURT.get(), SoundSource.PLAYERS);
                    }
                }else{
                    if(attacker instanceof Player player){
                        player.displayClientMessage(Component.translatable("message.alexsmobsdelight.crocodile_knife").withStyle(ChatFormatting.RED), true);
                    }
                }

            }
            if(attacker.getMainHandItem().is(ItemTags.create(new ResourceLocation("alexsmobsdelight:tools/mantis_shrimp_tools")))){
                entity.setSecondsOnFire(20);
                level.playSound((Player)null, entity.getOnPos(), AMSoundRegistry.MANTIS_SHRIMP_SNAP.get(), SoundSource.PLAYERS);
            }
            if(attacker instanceof Player player && player.hasEffect(EffectRegistry.CROCODILE_DEATH_ROLL.get()) && player.getFoodData().getFoodLevel() > 0){
                player.startAutoSpinAttack(20);
                level.playSound((Player)null, entity.getOnPos(), AMSoundRegistry.CROCODILE_BITE.get(), SoundSource.PLAYERS);
            }
            if(attacker.hasEffect(EffectRegistry.CROCODILE_SHARPNESS.get())){
                int amp = attacker.getEffect(EffectRegistry.CROCODILE_SHARPNESS.get()).getAmplifier();
                entity.addEffect(new MobEffectInstance(AMEffectRegistry.EXSANGUINATION.get(), 100, amp));
            }

            if(attacker.hasEffect(EffectRegistry.POISON_FANGS.get())){
                int amp = attacker.getEffect(EffectRegistry.POISON_FANGS.get()).getAmplifier();
                entity.addEffect(new MobEffectInstance(MobEffects.POISON, 100 * amp, 1));
            }
        }
    }
    @SubscribeEvent
    public static void onEntityLoot(LivingDropsEvent event) {
        if (!event.getEntity().level().isClientSide()) {
            LivingEntity entity = event.getEntity();
            if (entity instanceof IEntitySeagullData seagull){
                if(!seagull.amd$getEffects().isEmpty()){
                    ItemStack meat = seagull.amd$getConsumedEternalFood() ? new ItemStack(ItemRegistry.ENCHANTED_ETERNAL_COOKED_SEAGULL.get()) : new ItemStack(ItemRegistry.ENCHANTED_COOKED_SEAGULL.get());
                    CompoundTag tag = meat.getOrCreateTag();
                    ListTag listtag = new ListTag();
                    for (MobEffectInstance mobeffectinstance : seagull.amd$getEffects().values()) {
                        listtag.add(mobeffectinstance.save(new CompoundTag()));
                    }
                    tag.put("AmdConsumedFoodEffects", listtag);
                    addEntityDrops(event, meat);
                }else if(seagull.amd$getConsumedEternalFood()){
                    addEntityDrops(event, new ItemStack(ItemRegistry.ETERNAL_COOKED_SEAGULL.get()));
                }
            }

            if (entity instanceof EntityTarantulaHawk hawk){
                if(hawk.isBaby()){
                    if(hawk.isOnFire()){
                        addEntityDrops(event, new ItemStack(ItemRegistry.COOKED_TARANTULA_HAWK_LARVA.get()));
                    }else {
                        addEntityDrops(event, new ItemStack(ItemRegistry.RAW_TARANTULA_HAWK_LARVA.get()));
                    }
                }
            }

            if (event.getEntity().level() instanceof ServerLevel level && event.getSource().getEntity() instanceof LivingEntity attacker) {
                if(attacker.getMainHandItem().is(ItemRegistry.DIMENSIONAL_SLICER.get())){
                    ResourceLocation lootId = entity.getLootTable();
                    LootTable lootTable = level.getServer().getLootData().getLootTable(lootId);
                    List<ItemStack> allDrops = new ArrayList<>();
                    List<Item> actualDrops = new ArrayList<>();
                    LootContext ctx = new LootContext.Builder(
                            new LootParams.Builder(level)
                                    .withParameter(LootContextParams.THIS_ENTITY, entity)
                                    .withParameter(LootContextParams.ORIGIN, entity.position())
                                    .withParameter(LootContextParams.DAMAGE_SOURCE, event.getSource())
                                    .withOptionalParameter(LootContextParams.KILLER_ENTITY, attacker)
                                    .create(LootContextParamSets.ENTITY)
                    ).create(null);
                    for (LootPool pool : lootTable.pools) {
                        for (LootPoolEntryContainer entry : pool.entries) {
                            if (entry instanceof LootPoolSingletonContainer singleton) {
                                if(singleton instanceof LootItem lootItem){
                                    ItemStack baseStack = new ItemStack(lootItem.item);
                                    for (LootItemFunction function : singleton.functions) {
                                        baseStack = function.apply(baseStack, ctx);
                                    }
                                    if (baseStack.getCount() <= 0) {
                                        baseStack.setCount(1);
                                    }
                                    allDrops.add(baseStack.copy());
                                }

                            }
                        }
                    }
                    for(ItemEntity actualDrop : event.getDrops()){
                        actualDrops.add(actualDrop.getItem().getItem());
                    }
                    for(ItemStack drop : allDrops){
                        drop.setCount(1);
                        if(!actualDrops.contains(drop.getItem())){
                            addEntityDrops(event, drop);
                        }
                    }
                }
            }
        }
    }

    public static void addEntityDrops(LivingDropsEvent event, ItemStack itemStack) {
        ItemEntity itemEntity = new ItemEntity(event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), itemStack);
        itemEntity.setPickUpDelay(10);
        event.getDrops().add(itemEntity);
    }
}
