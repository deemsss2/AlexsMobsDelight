package io.github.rcneg.alexsmobsdelight.config;

import io.github.rcneg.alexsmobsdelight.AlexsMobsDelight;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@Mod.EventBusSubscriber(modid = AlexsMobsDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    public static ForgeConfigSpec COMMON_CONFIG;
    // COMMON
    public static ForgeConfigSpec.IntValue ETERNAL_SEAGULL_COOLDOWN;
    public static ForgeConfigSpec.IntValue CROCODILE_KNIFE_LOOT;
    public static ForgeConfigSpec.DoubleValue CROCODILE_KNIFE_HEALTH;
    public static ForgeConfigSpec.BooleanValue CROCODILE_KNIFE_FULL_DROP;
    public static ForgeConfigSpec.IntValue ORCA_GIFT_CHANCE;
    public static ForgeConfigSpec.BooleanValue STACKABLE_SOUP_ITEMS;
    public static ForgeConfigSpec.BooleanValue PUPFISH_BREAK;

    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> ETERNAL_FOODS;
    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> ENCHANTED_SEAGULL_BLACKLIST;
    private static final ForgeConfigSpec.ConfigValue<List<? extends String>> LOOTING_ENTITIES_BLACKLIST;
    public static List<Item> ETERNAL_FOODS_ITEMS;
    public static List<Item> ENCHANTED_SEAGULL_BLACKLIST_ITEMS;
    public static List<? extends EntityType<?>> LOOTING_BLACKLIST;
    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        COMMON_BUILDER.push("Eternal Seagull");
        ETERNAL_SEAGULL_COOLDOWN = COMMON_BUILDER.comment("Define the cooldown of Eternal Cooked Seagull in tick.")
                .defineInRange("EatCooldown", 160, 0, Integer.MAX_VALUE);

        ETERNAL_FOODS = COMMON_BUILDER
                .comment("A list of eternal foods which can be used to convert to the Eternal Cooked Seagull.")
                .defineListAllowEmpty("EternalFoodItems",
                        List.of("alexsmobsdelight:eternal_cooked_seagull",
                                "alexsmobsdelight:enchanted_eternal_cooked_seagull",
                                "artifacts:eternal_steak",
                                "artifacts:everlasting_beef"
                        ), Config::validateItemName);
        ENCHANTED_SEAGULL_BLACKLIST = COMMON_BUILDER
                .comment("A list of foods which can not be absorbed by seagull to convert to the Enchanted Seagull.")
                .defineListAllowEmpty("EnchantedSeagullBlacklist",
                        List.of("someassemblyrequired:sandwich"
                        ), Config::validateItemName);
        COMMON_BUILDER.pop();
        COMMON_BUILDER.push("Crocodile Karambit");
        CROCODILE_KNIFE_LOOT = COMMON_BUILDER.comment("Define the chance of looting when you attack by Crocodile Karambit.")
                .defineInRange("LootingChance", 20, 0, 100);
        CROCODILE_KNIFE_HEALTH = COMMON_BUILDER.comment("Crocodile Karambit will start decrease the chance of looting when lootingHealth * yourMaxHealth < targetsMaxHealth.")
                .comment("When lootingHealth * yourMaxHealth * 2 < targetsMaxHealth, you won't have chance to loot.")
                .defineInRange("LootingHealth", 2.0, 0, 20.0);
        CROCODILE_KNIFE_FULL_DROP = COMMON_BUILDER.comment("If it's true, Crocodile Karambit will loot all items instead of only one random item.")
                .define("LootingAllItems", false);
        LOOTING_ENTITIES_BLACKLIST = COMMON_BUILDER
                .comment("A list of entities which can never be looted by Crocodile Karambit.")
                .defineListAllowEmpty("LootingEntitiesBlacklist",
                        List.of("alexsmobs:void_worm"
                        ), Config::validateEntityTypeName);
        COMMON_BUILDER.pop();
        COMMON_BUILDER.push("Orca‘s Leap Stew");
        ORCA_GIFT_CHANCE = COMMON_BUILDER.comment("Define the chance of obtaining Orca's Leap Stew after you feed orca by seal meat.")
                .defineInRange("GiveChance", 30, 0, 100);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.push("Misc");
        STACKABLE_SOUP_ITEMS = COMMON_BUILDER.comment("Should BowlFoodItems in the Alex's Mobs become stackable to 16?")
                .define("StackableSoupItems", true);
        PUPFISH_BREAK = COMMON_BUILDER.comment("This mod enable Devil's Hole Pupfish in the Alex's Mobs breaks pupfish food blocks when breeding, should this feature active?")
                .define("PupfishBreakFoodBlocks", true);
        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }

    private static boolean validateItemName(final Object obj)
    {
        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
    }
    private static boolean validateEntityTypeName(final Object obj)
    {
        return obj instanceof final String entityName && ForgeRegistries.ENTITY_TYPES.containsKey(new ResourceLocation(entityName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        ETERNAL_FOODS_ITEMS = ETERNAL_FOODS.get().stream().map(name -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(name))).toList();
        ENCHANTED_SEAGULL_BLACKLIST_ITEMS = ENCHANTED_SEAGULL_BLACKLIST.get().stream().map(name -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(name))).toList();

        LOOTING_BLACKLIST = LOOTING_ENTITIES_BLACKLIST.get().stream().map(name -> ForgeRegistries.ENTITY_TYPES.getValue(new ResourceLocation(name))).toList();
    }
}