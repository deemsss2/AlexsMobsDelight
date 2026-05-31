package io.github.rcneg.alexsmobsdelight.items;

import com.github.alexthe666.alexsmobs.config.AMConfig;
import com.github.alexthe666.alexsmobs.entity.EntityRaccoon;
import com.github.alexthe666.alexsmobs.misc.AMAdvancementTriggerRegistry;
import io.github.rcneg.alexsmobsdelight.helper.ItemHelper;
import io.github.rcneg.alexsmobsdelight.init.ItemRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class SeagullWand extends HoeItem {
    public SeagullWand(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext p_41341_) {
        return InteractionResult.PASS;
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity p_40669_, int p_40670_) {
        int tick = this.getUseDuration(stack) - p_40670_;
        if (p_40669_ instanceof Player player && tick > 20) {
            AABB box = new AABB(player.getBoundingBox().getCenter().add(player.getViewVector(1f)), player.getBoundingBox().getCenter().add(player.getViewVector(1))).inflate(1);
            List<Entity> hits = level.getEntities(player, box, e -> e instanceof LivingEntity && e != player);
            if (!hits.isEmpty()) {
                LivingEntity target = (LivingEntity) hits.get(0);
                List<ItemStack> itemStacks = new ArrayList<>();
                ItemStack foodStack = ItemStack.EMPTY;
                if(target instanceof Player targetPlayer){
                    //seagull loot players
                    for(int i = 0; i < 9; ++i) {
                        ItemStack stackIn = targetPlayer.getInventory().items.get(i);
                        if (isStealableFood(stackIn)) {
                            itemStacks.add(stackIn);
                        }
                    }
                } if(target instanceof AbstractVillager villager){
                    //loot villagers
                    MerchantOffers originalOffers = villager.getOffers();
                    MerchantOffers offers = new MerchantOffers();
                    if (!originalOffers.isEmpty()) {
                        for(MerchantOffer o : originalOffers){
                            if(!o.isOutOfStock() && (o.getResult().isEdible() || o.getBaseCostA().isEdible())){
                                offers.add(o);
                            }
                        }
                        if(!offers.isEmpty()){
                            MerchantOffer offer = offers.get(offers.size() == 1 ? 0 : player.getRandom().nextInt(offers.size() - 1));
                            if (offer != null) {
                                ItemStack stealStack = offer.getResult().getItem() == Items.EMERALD ? offer.getBaseCostA() : offer.getResult();
                                if (!stealStack.isEmpty() && !offer.isOutOfStock()) {
                                    for(int i = 1; i <= offer.getMaxUses(); i++){
                                        offer.increaseUses();
                                    }
                                    ItemStack copy = stealStack.copy();
                                    copy.setCount(1);
                                    itemStacks.add(copy);
                                }
                            }
                        }
                    }
                }
                else {
                    if(isStealableFood(target.getItemInHand(InteractionHand.MAIN_HAND))){
                        itemStacks.add(target.getItemInHand(InteractionHand.MAIN_HAND));
                    }
                    if(isStealableFood(target.getItemInHand(InteractionHand.OFF_HAND)) && itemStacks.isEmpty()){
                        itemStacks.add(target.getItemInHand(InteractionHand.OFF_HAND));
                    }
                }
                if (!itemStacks.isEmpty()) {
                    foodStack = itemStacks.get(itemStacks.size() == 1 ? 0 : player.getRandom().nextInt(itemStacks.size() - 1));
                }
                if (!foodStack.isEmpty()) {
                    ItemStack copy = foodStack.copy();
                    foodStack.shrink(1);
                    copy.setCount(1);
                    if (!player.getInventory().add(copy)) {
                        player.drop(copy, false);
                    }
                    if (target instanceof ServerPlayer) {
                        AMAdvancementTriggerRegistry.SEAGULL_STEAL.trigger((ServerPlayer)target);
                    }
                }
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level p_40672_, Player p_40673_, InteractionHand p_40674_) {
        ItemStack itemstack = p_40673_.getItemInHand(p_40674_);
        p_40673_.startUsingItem(p_40674_);
        return InteractionResultHolder.success(itemstack);
    }

    public boolean isStealableFood(ItemStack stack){
        boolean blackListed = false;
        ResourceLocation loc = ForgeRegistries.ITEMS.getKey(stack.getItem());
        if (loc != null) {
            for (String str : AMConfig.seagullStealingBlacklist) {
                if (loc.toString().equals(str)) {
                    blackListed = true;
                }
            }
        }
        return stack.isEdible() && !blackListed && !stack.is(ItemRegistry.KIVIAK.get());
    }

    @Override
    public int getUseDuration(ItemStack p_40680_) {
        return 72000;
    }

    @Override
    public boolean canContinueUsing(ItemStack oldStack, ItemStack newStack) {
        return oldStack.getItem() == newStack.getItem();
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged || newStack.getItem() != oldStack.getItem();
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_40678_) {
        return UseAnim.BOW;
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn)
    {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(ItemHelper.customColor(Component.translatable("tooltip.alexsmobsdelight.seagull_wand"), 251, 198, 69));
        tooltip.add(ItemHelper.customColor(Component.translatable("tooltip.alexsmobsdelight.seagull_wand_1"), 251, 198, 69));
    }
}
