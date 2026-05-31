package io.github.rcneg.alexsmobsdelight.mixin;

import com.github.alexthe666.alexsmobs.entity.EntitySeagull;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import io.github.rcneg.alexsmobsdelight.accessor.IEntitySeagullData;
import io.github.rcneg.alexsmobsdelight.config.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Mixin(EntitySeagull.class)
public class EntitySeagullMixin implements IEntitySeagullData {

    @Unique
    private boolean amd$consumedEternalFood;
    @Unique
    private Map<MobEffect, MobEffectInstance> amd$consumedFoodEffects = Maps.newHashMap();

    @Override
    public boolean amd$getConsumedEternalFood() {
        return amd$consumedEternalFood;
    }

    @Override
    public void amd$setConsumedEternalFood(boolean flag) {
        amd$consumedEternalFood = flag;
    }

    @Override
    public Map<MobEffect, MobEffectInstance> amd$getEffects() {
        return amd$consumedFoodEffects;
    }

    @Override
    public void amd$setEffectMap(Map<MobEffect, MobEffectInstance> map) {
        amd$consumedFoodEffects = map;
    }

    @Inject(
            method = "eatItemEffect",
            at = @At("HEAD"),
            remap = false
    )
    private void amd$ApplyEternalTag(ItemStack heldItem, CallbackInfo ci) {
        if (heldItem != null){
            if(Config.ETERNAL_FOODS_ITEMS.contains(heldItem.getItem())){
                EntitySeagull seagull = (EntitySeagull) (Object) this;
                if(seagull instanceof IEntitySeagullData data){
                    data.amd$setConsumedEternalFood(true);
                }
            }
            FoodProperties food = heldItem.getItem().getFoodProperties(heldItem, null);
            if (food != null){
                EntitySeagull seagull = (EntitySeagull) (Object) this;
                Map<MobEffect, MobEffectInstance> foodEffects = Maps.newHashMap();
                if(!food.getEffects().isEmpty() && !Config.ENCHANTED_SEAGULL_BLACKLIST_ITEMS.contains(heldItem.getItem())) {
                    //获取食物效果
                    List<Pair<MobEffectInstance, Float>> foodEffectsWithChance = food.getEffects();

                    for(Pair<MobEffectInstance, Float> effectPair : foodEffectsWithChance){
                        if(seagull.getRandom().nextFloat() <= effectPair.getSecond()){
                            MobEffectInstance effectIns = effectPair.getFirst();
                            foodEffects.put(effectIns.getEffect(), effectIns);
                        }
                    }
                }
                if(heldItem.getTag() != null){
                    //获取不了就获取NBT（比如附魔海鸥）
                    CompoundTag tag = heldItem.getTag();
                    Set<String> tagName = tag.getAllKeys();
                    for(String string : tagName){
                        ListTag listtag = tag.getList(string, 10);
                        for(int i = 0; i < listtag.size(); i++){
                            CompoundTag compoundtag = listtag.getCompound(i);
                            MobEffectInstance mei = MobEffectInstance.load(compoundtag);
                            if (mei != null) {
                                if(foodEffects.containsKey(mei.getEffect())){
                                    MobEffect me = mei.getEffect();
                                    MobEffectInstance mei1 = new MobEffectInstance(me,
                                            Math.max(mei.getDuration(), foodEffects.get(me).getDuration()),
                                            Math.max(mei.getAmplifier(), foodEffects.get(me).getAmplifier()));
                                    foodEffects.put(me, mei1);
                                } else {
                                    foodEffects.put(mei.getEffect(), mei);
                                }
                            }
                        }
                    }
                }
                if(seagull instanceof IEntitySeagullData data){
                    data.amd$setEffectMap(foodEffects);
                }
            }
            if(amd$shouldSpawnSuperSeagull()){

            }
        }
    }

    @Unique
    public boolean amd$shouldSpawnSuperSeagull(){
        int a = 0;
        for(MobEffectInstance effects : amd$consumedFoodEffects.values()){
            a += effects.getAmplifier() + 1;
        }
        return amd$getConsumedEternalFood() && a >= 8;
    }

    @Inject(method = "setTreasurePos", at = @At("TAIL"), remap = false)
    private void amd$setTreasureSand(BlockPos pos, CallbackInfo ci) {
        EntitySeagull seagull = (EntitySeagull) (Object) this;
        Level level = seagull.level();
        for(int i = 0; i < 128; ++i) {
            BlockPos pos1 = new BlockPos(pos.getX(), i, pos.getZ());
            if (level.getBlockState(pos1).getBlock() instanceof ChestBlock
                    && (level.getBlockState(pos1.below()).is(Blocks.SAND)
                    || level.getBlockState(pos1.below()).is(Blocks.GRAVEL)
                    || level.getBlockState(pos1.below()).is(Blocks.STONE)
                    || level.getBlockState(pos1.below()).is(Blocks.SANDSTONE))) {
                boolean flag = true;
                for(Direction d : Direction.values()){
                    if(!level.getBlockState(pos1.relative(d)).isSolid()){
                        flag = false;
                    }
                }
                if(flag){
                    BlockState treasureSand = level.getBlockState(pos1.below()).is(Blocks.GRAVEL) || level.getBlockState(pos1.below()).is(Blocks.STONE) ? Blocks.SUSPICIOUS_GRAVEL.defaultBlockState() : Blocks.SUSPICIOUS_SAND.defaultBlockState();
                    CompoundTag tag = level.getBlockEntity(pos1).saveWithoutMetadata();
                    if(level.getBlockEntity(pos1) instanceof RandomizableContainerBlockEntity chestEntity && tag != null && tag.contains("LootTable", 8)){
                        if(level.setBlock(pos1.below(), treasureSand, 3)){
                            BlockEntity entity = level.getBlockEntity(pos1.below());
                            Player player = level.getPlayerByUUID(seagull.feederUUID);
                            if(entity instanceof BrushableBlockEntity brushable && player != null){
                                chestEntity.unpackLootTable(player);
                                brushable.setLootTable(new ResourceLocation("alexsmobsdelight:gameplay/seagull_treasure_sand"), tag.getLong("LootTableSeed"));
                                brushable.setChanged();
                                level.sendBlockUpdated(pos1.below(), treasureSand, treasureSand, Block.UPDATE_CLIENTS);
                            }
                        }
                        break;
                    }
                }
            }
        }

    }

    @Inject(method = "addAdditionalSaveData", at = @At("TAIL"))
    private void amd$save(CompoundTag tag, CallbackInfo ci) {
        tag.putBoolean("AmdConsumedEternalFood", this.amd$consumedEternalFood);
        if (!this.amd$consumedFoodEffects.isEmpty()) {
            ListTag listtag = new ListTag();
            for (MobEffectInstance mobeffectinstance : this.amd$consumedFoodEffects.values()) {
                listtag.add(mobeffectinstance.save(new CompoundTag()));
            }
            tag.put("AmdConsumedFoodEffects", listtag);
        }
    }

    @Inject(method = "readAdditionalSaveData", at = @At("TAIL"))
    private void amd$load(CompoundTag tag, CallbackInfo ci) {
        if (tag.contains("AmdConsumedEternalFood")){
            this.amd$consumedEternalFood = tag.getBoolean("AmdConsumedEternalFood");
        }
        if (tag.contains("AmdConsumedFoodEffects", 9)) {
            ListTag listtag = tag.getList("AmdConsumedFoodEffects", 10);

            for(int i = 0; i < listtag.size(); ++i) {
                CompoundTag compoundtag = listtag.getCompound(i);
                MobEffectInstance mobeffectinstance = MobEffectInstance.load(compoundtag);
                if (mobeffectinstance != null) {
                    this.amd$consumedFoodEffects.put(mobeffectinstance.getEffect(), mobeffectinstance);
                }
            }
        }
    }
}
