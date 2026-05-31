package io.github.rcneg.alexsmobsdelight.init;

import io.github.rcneg.alexsmobsdelight.AlexsMobsDelight;
import io.github.rcneg.alexsmobsdelight.effects.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EffectRegistry {

    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AlexsMobsDelight.MODID);
    public static final DeferredRegister<Potion> POTION = DeferredRegister.create(ForgeRegistries.POTIONS, AlexsMobsDelight.MODID);
    public static final RegistryObject<MobEffect> CROCODILE_CRUSH = MOB_EFFECTS.register("crocodile_crush", () -> new AMDMobEffect(MobEffectCategory.BENEFICIAL, -9999028).addAttributeModifier(Attributes.ATTACK_DAMAGE, "90185901-376B-4498-935B-2F7F79060635", 0.1, AttributeModifier.Operation.MULTIPLY_TOTAL));
    public static final RegistryObject<MobEffect> CROCODILE_TOUGHNESS = MOB_EFFECTS.register("crocodile_toughness", () -> new AMDMobEffect(MobEffectCategory.BENEFICIAL, -9999028).addAttributeModifier(Attributes.ARMOR_TOUGHNESS, "90185901-1310-4498-935B-2F7F79060635", 0.2, AttributeModifier.Operation.MULTIPLY_TOTAL));
    public static final RegistryObject<MobEffect> CROCODILE_SHARPNESS = MOB_EFFECTS.register("crocodile_sharpness", () -> new CrocodileSharpnessEffect(MobEffectCategory.BENEFICIAL, -9999028));
    public static final RegistryObject<MobEffect> CROCODILE_HACKSAW = MOB_EFFECTS.register("crocodile_hacksaw", () -> new AMDMobEffect(MobEffectCategory.BENEFICIAL, -9999028).addAttributeModifier(Attributes.ATTACK_SPEED, "90185901-3461-4498-935B-2F7F79060635", 0.15, AttributeModifier.Operation.MULTIPLY_TOTAL));
    public static final RegistryObject<MobEffect> CROCODILE_DEATH_ROLL = MOB_EFFECTS.register("crocodile_death_roll", () -> new CrocodileDeathRollEffect(MobEffectCategory.BENEFICIAL, -9999028));
    public static final RegistryObject<MobEffect> SEAGULL_ANOREXIA = MOB_EFFECTS.register("seagull_anorexia", () -> new SeagullAnorexiaEffect(MobEffectCategory.BENEFICIAL, -3910904));
    public static final RegistryObject<MobEffect> CRYSTALLIZE_WALKER = MOB_EFFECTS.register("crystallize_walker", () -> new CrystallizeWalkerEffect(MobEffectCategory.BENEFICIAL, -4184));
    public static final RegistryObject<MobEffect> POISON_FANGS = MOB_EFFECTS.register("poison_fangs", () -> new AMDMobEffect(MobEffectCategory.BENEFICIAL, -9999028));
    public static final RegistryObject<MobEffect> FLUTTERING = MOB_EFFECTS.register("fluttering", () -> new AMDMobEffect(MobEffectCategory.BENEFICIAL, -9999028));

    public static final RegistryObject<MobEffect> EXTENDED_TOUCH = MOB_EFFECTS.register("extended_touch", () -> new AMDMobEffect(MobEffectCategory.BENEFICIAL, -4184).addAttributeModifier(ForgeMod.BLOCK_REACH.get(), "93018673-1364-4498-6341-634563113235", 1, AttributeModifier.Operation.ADDITION));
    public static final RegistryObject<MobEffect> EXTENDED_SCARE = MOB_EFFECTS.register("extended_scare", () -> new AMDMobEffect(MobEffectCategory.BENEFICIAL, -4184).addAttributeModifier(ForgeMod.ENTITY_REACH.get(), "93018673-1364-4498-6341-902490321540", 1, AttributeModifier.Operation.ADDITION));

}
