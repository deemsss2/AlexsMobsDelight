package io.github.rcneg.alexsmobsdelight.init;

import io.github.rcneg.alexsmobsdelight.AlexsMobsDelight;
import io.github.rcneg.alexsmobsdelight.items.*;
import io.github.rcneg.alexsmobsdelight.tier.ItemTier;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.KnifeItem;
import vectorwing.farmersdelight.common.item.PopsicleItem;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AlexsMobsDelight.MODID);
    //食材
    public static final RegistryObject<Item> RAW_BEAR_MEAT = ITEMS.register("raw_bear_meat", () -> new Item(foodBuilder(AMDFoodValues.RAW_BEAR_MEAT)));
    public static final RegistryObject<Item> RAW_BEAR_MEAT_SLICE = ITEMS.register("raw_bear_meat_slice", () -> new Item(foodBuilder(AMDFoodValues.RAW_BEAR_MEAT_SLICE)));
    public static final RegistryObject<Item> COOKED_BEAR_MEAT = ITEMS.register("cooked_bear_meat", () -> new Item(foodBuilder(AMDFoodValues.COOKED_BEAR_MEAT)));
    public static final RegistryObject<Item> COOKED_BEAR_MEAT_SLICE = ITEMS.register("cooked_bear_meat_slice", () -> new Item(foodBuilder(AMDFoodValues.COOKED_BEAR_MEAT_SLICE)));
    public static final RegistryObject<Item> RAW_BISON_MEAT = ITEMS.register("raw_bison_meat", () -> new Item(foodBuilder(AMDFoodValues.RAW_BISON_MEAT)));
    public static final RegistryObject<Item> RAW_BISON_MEAT_CUBES = ITEMS.register("raw_bison_meat_cubes", () -> new Item(foodBuilder(AMDFoodValues.RAW_BISON_MEAT_CUBES)));
    public static final RegistryObject<Item> COOKED_BISON_MEAT = ITEMS.register("cooked_bison_meat", () -> new Item(foodBuilder(AMDFoodValues.COOKED_BISON_MEAT)));
    public static final RegistryObject<Item> COOKED_BISON_MEAT_CUBES = ITEMS.register("cooked_bison_meat_cubes", () -> new Item(foodBuilder(AMDFoodValues.COOKED_BISON_MEAT_CUBES)));
    public static final RegistryObject<Item> RAW_KANGAROO_MEAT_SLICE = ITEMS.register("raw_kangaroo_meat_slice", () -> new Item(foodBuilder(AMDFoodValues.RAW_KANGAROO_MEAT_SLICE)));
    public static final RegistryObject<Item> COOKED_KANGAROO_MEAT_SLICE = ITEMS.register("cooked_kangaroo_meat_slice", () -> new Item(foodBuilder(AMDFoodValues.COOKED_KANGAROO_MEAT_SLICE)));
    public static final RegistryObject<Item> RAW_MOOSE_RIB_PIECE = ITEMS.register("raw_moose_rib_piece", () -> new Item(foodBuilder(AMDFoodValues.RAW_MOOSE_RIB_PIECE)));
    public static final RegistryObject<Item> COOKED_MOOSE_RIB_PIECE = ITEMS.register("cooked_moose_rib_piece", () -> new Item(foodBuilder(AMDFoodValues.COOKED_MOOSE_RIB_PIECE)));
    public static final RegistryObject<Item> RAW_SEAGULL = ITEMS.register("raw_seagull", () -> new Item(foodBuilder(AMDFoodValues.RAW_SEAGULL)));
    public static final RegistryObject<Item> COOKED_SEAGULL = ITEMS.register("cooked_seagull", () -> new Item(foodBuilder(AMDFoodValues.COOKED_SEAGULL)));
    public static final RegistryObject<Item> MANTIS_SHRIMP_TAIL_RED = ITEMS.register("mantis_shrimp_tail_red", () -> new Item(foodBuilder(AMDFoodValues.MANTIS_SHRIMP_TAIL)));
    public static final RegistryObject<Item> MANTIS_SHRIMP_TAIL_GREEN = ITEMS.register("mantis_shrimp_tail_green", () -> new Item(foodBuilder(AMDFoodValues.MANTIS_SHRIMP_TAIL)));
    public static final RegistryObject<Item> MANTIS_SHRIMP_TAIL_LIME = ITEMS.register("mantis_shrimp_tail_lime", () -> new Item(foodBuilder(AMDFoodValues.MANTIS_SHRIMP_TAIL)));
    public static final RegistryObject<Item> MANTIS_SHRIMP_TAIL_WHITE = ITEMS.register("mantis_shrimp_tail_white", () -> new Item(foodBuilder(AMDFoodValues.MANTIS_SHRIMP_TAIL)));
    public static final RegistryObject<Item> COOKED_MANTIS_SHRIMP_TAIL = ITEMS.register("cooked_mantis_shrimp_tail", () -> new Item(foodBuilder(AMDFoodValues.COOKED_MANTIS_SHRIMP_TAIL)));
    public static final RegistryObject<Item> RAW_TUSKLIN_MEAT = ITEMS.register("raw_tusklin_meat", () -> new Item(foodBuilder(AMDFoodValues.RAW_TUSKLIN_MEAT)));
    public static final RegistryObject<Item> RAW_TUSKLIN_MEAT_PIECE = ITEMS.register("raw_tusklin_meat_piece", () -> new Item(foodBuilder(AMDFoodValues.RAW_TUSKLIN_MEAT_PIECE)));
    public static final RegistryObject<Item> COOKED_TUSKLIN_MEAT = ITEMS.register("cooked_tusklin_meat", () -> new Item(foodBuilder(AMDFoodValues.COOKED_TUSKLIN_MEAT)));
    public static final RegistryObject<Item> COOKED_TUSKLIN_MEAT_PIECE = ITEMS.register("cooked_tusklin_meat_piece", () -> new Item(foodBuilder(AMDFoodValues.COOKED_TUSKLIN_MEAT_PIECE)));
    public static final RegistryObject<Item> RAW_DEVILS_HOLE_PUPFISH = ITEMS.register("raw_devils_hole_pupfish", () -> new Item(foodBuilder(Foods.COD)));
    public static final RegistryObject<Item> RAW_DEVILS_HOLE_PUPFISH_SLICE = ITEMS.register("raw_devils_hole_pupfish_slice", () -> new Item(foodBuilder(FoodValues.COD_SLICE)));
    public static final RegistryObject<Item> COOKED_DEVILS_HOLE_PUPFISH = ITEMS.register("cooked_devils_hole_pupfish", () -> new Item(foodBuilder(Foods.COOKED_COD)));
    public static final RegistryObject<Item> COOKED_DEVILS_HOLE_PUPFISH_SLICE = ITEMS.register("cooked_devils_hole_pupfish_slice", () -> new Item(foodBuilder(FoodValues.COOKED_COD_SLICE)));
    public static final RegistryObject<Item> RAW_CATFISH_SLICE = ITEMS.register("raw_catfish_slice", () -> new Item(foodBuilder(FoodValues.COD_SLICE)));
    public static final RegistryObject<Item> COOKED_CATFISH_SLICE = ITEMS.register("cooked_catfish_slice", () -> new Item(foodBuilder(FoodValues.COOKED_COD_SLICE)));
    public static final RegistryObject<Item> RAW_FLYING_FISH_SLICE = ITEMS.register("raw_flying_fish_slice", () -> new Item(foodBuilder(FoodValues.COD_SLICE)));
    public static final RegistryObject<Item> COOKED_FLYING_FISH = ITEMS.register("cooked_flying_fish", () -> new Item(foodBuilder(Foods.COOKED_COD)));
    public static final RegistryObject<Item> COOKED_FLYING_FISH_SLICE = ITEMS.register("cooked_flying_fish_slice", () -> new Item(foodBuilder(FoodValues.COOKED_COD_SLICE)));
    public static final RegistryObject<Item> RAW_MUDSKIPPER = ITEMS.register("raw_mudskipper", () -> new Item(foodBuilder(Foods.COD)));
    public static final RegistryObject<Item> RAW_MUDSKIPPER_SLICE = ITEMS.register("raw_mudskipper_slice", () -> new Item(foodBuilder(FoodValues.COD_SLICE)));
    public static final RegistryObject<Item> COOKED_MUDSKIPPER = ITEMS.register("cooked_mudskipper", () -> new Item(foodBuilder(Foods.COOKED_COD)));
    public static final RegistryObject<Item> COOKED_MUDSKIPPER_SLICE = ITEMS.register("cooked_mudskipper_slice", () -> new Item(foodBuilder(FoodValues.COOKED_COD_SLICE)));
    public static final RegistryObject<Item> BANANA_SLICE = ITEMS.register("banana_slice", () -> new Item(foodBuilder(AMDFoodValues.BANANA_SLICE)));
    public static final RegistryObject<Item> RAW_CROCODILE_CLAW = ITEMS.register("raw_crocodile_claw", () -> new Item(foodBuilder(AMDFoodValues.RAW_CROCODILE_CLAW)));
    public static final RegistryObject<Item> RAW_CROCODILE_TAIL = ITEMS.register("raw_crocodile_tail", () -> new Item(foodBuilder(AMDFoodValues.RAW_CROCODILE_TAIL)));
    public static final RegistryObject<Item> RAW_CROCODILE_MEAT = ITEMS.register("raw_crocodile_meat", () -> new Item(foodBuilder(AMDFoodValues.RAW_CROCODILE_MEAT)));
    public static final RegistryObject<Item> COOKED_CROCODILE_CLAW = ITEMS.register("cooked_crocodile_claw", () -> new Item(foodBuilder(AMDFoodValues.COOKED_CROCODILE_CLAW)));
    public static final RegistryObject<Item> COOKED_CROCODILE_TAIL = ITEMS.register("cooked_crocodile_tail", () -> new Item(foodBuilder(AMDFoodValues.COOKED_CROCODILE_TAIL)));
    public static final RegistryObject<Item> COOKED_CROCODILE_MEAT = ITEMS.register("cooked_crocodile_meat", () -> new Item(foodBuilder(AMDFoodValues.COOKED_CROCODILE_MEAT)));
    public static final RegistryObject<Item> RAW_WHOLE_CROCODILE = ITEMS.register("raw_whole_crocodile", () -> new Item(defaultBuilder()));
    public static final RegistryObject<Item> MIMIC_OCTOPUS_TENTACLE = ITEMS.register("mimic_octopus_tentacle", () -> new Item(foodBuilder(AMDFoodValues.RAW_TENTACLE)));
    public static final RegistryObject<Item> COOKED_OCTOPUS_TENTACLE = ITEMS.register("cooked_octopus_tentacle", () -> new Item(foodBuilder(AMDFoodValues.COOKED_TENTACLE)));
    public static final RegistryObject<Item> WHALE_MEAT = ITEMS.register("whale_meat", () -> new Item(foodBuilder(AMDFoodValues.WHALE_MEAT)));
    public static final RegistryObject<Item> COOKED_WHALE_MEAT = ITEMS.register("cooked_whale_meat", () -> new Item(foodBuilder(AMDFoodValues.COOKED_WHALE_MEAT)));
    public static final RegistryObject<Item> COOKED_LOST_TENTACLE = ITEMS.register("cooked_lost_tentacle", () -> new Item(foodBuilder(AMDFoodValues.COOKED_LOST_TENTACLE)));
    public static final RegistryObject<Item> DRIED_SHREDDED_SQUID = ITEMS.register("dried_shredded_squid", () -> new Item(foodBuilder(AMDFoodValues.COOKED_LOST_TENTACLE_CUT)));
    public static final RegistryObject<Item> SEAL_MEAT = ITEMS.register("seal_meat", () -> new ConsumableItem(foodBuilder(AMDFoodValues.SEAL_MEAT), false, true));
    public static final RegistryObject<Item> COOKED_SEAL_MEAT = ITEMS.register("cooked_seal_meat", () -> new Item(foodBuilder(AMDFoodValues.COOKED_SEAL_MEAT)));
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese", () -> new CheeseItem(foodBuilder(AMDFoodValues.CHEESE),false, true));

    public static final RegistryObject<Item> RAW_CENTIPEDE_BODY = ITEMS.register("raw_centipede_body", () -> new ConsumableItem(foodBuilder(AMDFoodValues.CENTIPEDE_MEAT),true));
    public static final RegistryObject<Item> COOKED_CENTIPEDE_BODY = ITEMS.register("cooked_centipede_body", () -> new Item(foodBuilder(AMDFoodValues.COOKED_CENTIPEDE_MEAT)));
    public static final RegistryObject<Item> COOKED_CENTIPEDE_LEG = ITEMS.register("cooked_centipede_leg", () -> new Item(foodBuilder(AMDFoodValues.COOKED_CENTIPEDE_LEG)));
    public static final RegistryObject<Item> COOKED_MAGGOT = ITEMS.register("cooked_maggot", () -> new Item(foodBuilder(AMDFoodValues.COOKED_MAGGOT)));
    public static final RegistryObject<Item> RAW_TARANTULA_HAWK_ABDOMEN = ITEMS.register("raw_tarantula_hawk_abdomen", () -> new ConsumableItem(foodBuilder(AMDFoodValues.TARANTULA_HAWK_ABDOMEN), true));
    public static final RegistryObject<Item> COOKED_TARANTULA_HAWK_ABDOMEN = ITEMS.register("cooked_tarantula_hawk_abdomen", () -> new Item(foodBuilder(AMDFoodValues.COOKED_TARANTULA_HAWK_ABDOMEN)));
    public static final RegistryObject<Item> RAW_TARANTULA_HAWK_LARVA = ITEMS.register("raw_tarantula_hawk_larva", () -> new Item(foodBuilder(AMDFoodValues.TARANTULA_HAWK_LARVA)));
    public static final RegistryObject<Item> COOKED_TARANTULA_HAWK_LARVA = ITEMS.register("cooked_tarantula_hawk_larva", () -> new Item(foodBuilder(AMDFoodValues.COOKED_TARANTULA_HAWK_LARVA)));
    public static final RegistryObject<Item> COCKROACH = ITEMS.register("cockroach", () -> new ConsumableItem(foodBuilder(AMDFoodValues.COCKROACH), true));
    public static final RegistryObject<Item> LEAFCUTTER_ANT = ITEMS.register("leafcutter_ant", () -> new ConsumableItem(foodBuilder(AMDFoodValues.ANT), true));

    //材料
    public static final RegistryObject<Item> CROCODILE_TOOTH = ITEMS.register("crocodile_tooth", () -> new Item(defaultBuilder()));
    public static final RegistryObject<Item> LOBSTER_HEAD = ITEMS.register("lobster_head", () -> new Item(defaultBuilder()));
    public static final RegistryObject<Item> SEAL_LEATHER_BROWN = ITEMS.register("seal_leather_brown", () -> new Item(defaultBuilder()));
    public static final RegistryObject<Item> SEAL_LEATHER_GRAY = ITEMS.register("seal_leather_gray", () -> new Item(defaultBuilder()));

    //工具？
    public static final RegistryObject<Item> MANTIS_SHRIMP_SCYTHE = ITEMS.register("mantis_shrimp_scythe", () -> new MantisShrimpKnife(ItemTier.SHRIMP, 3, -2.4F, defaultBuilder()));
    public static final RegistryObject<Item> MANTIS_SHRIMP_SHOVEL = ITEMS.register("mantis_shrimp_shovel", () -> new MantisShrimpShovel(ItemTier.SHRIMP, 1.5F, -3.0F, defaultBuilder()));
    public static final RegistryObject<Item> MANTIS_SHRIMP_HAMMER = ITEMS.register("mantis_shrimp_hammer", () -> new MantisShrimpHammer(ItemTier.SHRIMP, 1, -2.8F, defaultBuilder()));
    public static final RegistryObject<Item> MANTIS_SHRIMP_AXE = ITEMS.register("mantis_shrimp_axe", () -> new MantisShrimpAxe(ItemTier.SHRIMP, 6.0F, -3.1F, defaultBuilder()));
    public static final RegistryObject<Item> LOBSTER_KNIFE = ITEMS.register("lobster_knife", () -> new LobsterKnife(ItemTier.SHRIMP, 0, -2F, defaultBuilder()));
    public static final RegistryObject<Item> LOBSTER_DART = ITEMS.register("lobster_dart", () -> new LobsterDartItem(defaultBuilder().durability(64)));
    public static final RegistryObject<Item> CROCODILE_KNIFE = ITEMS.register("crocodile_knife", () -> new CrocodileKnife(ItemTier.CROCODILE, -1, -2F, defaultBuilder()));
    public static final RegistryObject<Item> CROCODILE_SCUTE_SWORD = ITEMS.register("crocodile_scute_sword", () -> new CrocodileSword(ItemTier.CROCODILE_SCUTE, 3, -2.4F, defaultBuilder()));
    public static final RegistryObject<Item> BANANA_BOW = ITEMS.register("banana_bow", () -> new BananaBowItem(defaultBuilder().durability(64)));
    public static final RegistryObject<Item> WHALE_TOOTH_PICKAXE = ITEMS.register("whale_tooth_pickaxe", () -> new WhaleToothPickaxe(ItemTier.WHALE_TOOTH, 1, -2.8F, defaultBuilder()));
    public static final RegistryObject<Item> SEAGULL_WAND = ITEMS.register("seagull_wand", () -> new SeagullWand(Tiers.WOOD, 3, -2.8F, defaultBuilder().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> DIMENSIONAL_SLICER = ITEMS.register("dimensional_slicer", () -> new DimensionalKnife(Tiers.NETHERITE, 3, -2F, defaultBuilder()));

    //无容器食物
    public static final RegistryObject<Item> RAW_TUSKLIN_SAUSAGE = ITEMS.register("raw_tusklin_sausage", () -> new Item(foodBuilder(AMDFoodValues.RAW_TUSKLIN_SAUSAGE)));
    public static final RegistryObject<Item> SMOKED_TUSKLIN_SAUSAGE = ITEMS.register("smoked_tusklin_sausage", () -> new Item(foodBuilder(AMDFoodValues.SMOKED_TUSKLIN_SAUSAGE)));
    public static final RegistryObject<Item> SLICE_OF_SMOKED_TUSKLIN_SAUSAGE = ITEMS.register("slice_of_smoked_tusklin_sausage", () -> new Item(foodBuilder(AMDFoodValues.SLICE_OF_SMOKED_TUSKLIN_SAUSAGE)));
    public static final RegistryObject<Item> MANTIS_SHRIMP_TEMPURA = ITEMS.register("mantis_shrimp_tempura", () -> new ConsumableItem(foodBuilder(AMDFoodValues.MANTIS_SHRIMP_TEMPURA), true));
    public static final RegistryObject<Item> SHRIMP_FRIED_EGG = ITEMS.register("shrimp_fried_egg", () -> new Item(foodBuilder(AMDFoodValues.SHRIMP_FRIED_EGG)));
    public static final RegistryObject<Item> SHRIMP_POKE_BOWL = ITEMS.register("shrimp_poke_bowl", () -> new ConsumableItem(foodBuilder(AMDFoodValues.SHRIMP_POKE_BOWL), true));
    public static final RegistryObject<Item> FRIED_TUSKLIN_MEAT = ITEMS.register("fried_tusklin_meat", () -> new Item(foodBuilder(AMDFoodValues.FRIED_TUSKLIN_MEAT)));
    public static final RegistryObject<Item> CROCODILE_RICE = ITEMS.register("crocodile_rice", () -> new ConsumableItem(foodBuilder(FoodValues.COOKED_RICE), true));
    public static final RegistryObject<Item> TAKOYAKI = ITEMS.register("takoyaki", () -> new ConsumableItem(foodBuilder(AMDFoodValues.TAKOYAKI), true));
    public static final RegistryObject<Item> TEMPURA = ITEMS.register("tempura", () -> new Item(foodBuilder(AMDFoodValues.TEMPURA)));

    public static final RegistryObject<Item> ANT_COOKIE = ITEMS.register("ant_cookie", () -> new Item(foodBuilder(AMDFoodValues.ANT_COOKIE)));
    public static final RegistryObject<Item> PROTEIN_BLOCK = ITEMS.register("protein_block", () -> new ConsumableItem(foodBuilder(AMDFoodValues.PROTEIN_BLOCK), true));
    public static final RegistryObject<Item> STUFFED_TARANTULA_HAWK = ITEMS.register("stuffed_tarantula_hawk", () -> new SlowEatConsumableItem(foodBuilder(AMDFoodValues.STUFFED_TARANTULA_HAWK), true));

    //寿司
    public static final RegistryObject<Item> CATFISH_ROLL = ITEMS.register("catfish_roll", () -> new Item(foodBuilder(FoodValues.COD_ROLL)));
    public static final RegistryObject<Item> DEVILS_HOLE_PUPFISH_ROLL = ITEMS.register("devils_hole_pupfish_roll", () -> new Item(foodBuilder(FoodValues.COD_ROLL)));
    public static final RegistryObject<Item> FLYING_FISH_ROLL = ITEMS.register("flying_fish_roll", () -> new Item(foodBuilder(FoodValues.COD_ROLL)));
    public static final RegistryObject<Item> MUDSKIPPER_ROLL = ITEMS.register("mudskipper_roll", () -> new Item(foodBuilder(FoodValues.COD_ROLL)));
    public static final RegistryObject<Item> BANANA_ROLL = ITEMS.register("banana_roll", () -> new SlowEatConsumableItem(foodBuilder(AMDFoodValues.BANANA_ROLL)));
    public static final RegistryObject<Item> BANANA_ROLL_SLICE = ITEMS.register("banana_roll_slice", () -> new Item(foodBuilder(AMDFoodValues.BANANA_ROLL_SLICE)));
    public static final RegistryObject<Item> TRIOPS_EGGS_ROLL = ITEMS.register("triops_eggs_roll", () -> new Item(foodBuilder(FoodValues.COD_ROLL)));
    public static final RegistryObject<Item> LOBSTER_ROLL = ITEMS.register("lobster_roll", () -> new Item(foodBuilder(AMDFoodValues.LOBSTER_ROLL)));
    public static final RegistryObject<Item> DRIED_KELP_ROLLED_TARANTULA_HAWK_LARVA = ITEMS.register("dried_kelp_rolled_tarantula_hawk_larva", () -> new ConsumableItem(foodBuilder(AMDFoodValues.LARVA_ROLL), true));

    //烤串
    public static final RegistryObject<Item> CROCODILE_BARBECUE_STICK = ITEMS.register("crocodile_barbecue_stick", () -> new Item(foodBuilder(AMDFoodValues.CROCODILE_BARBECUE_STICK)));
    public static final RegistryObject<Item> FRIED_TENTACLES_STICK = ITEMS.register("fried_tentacles_stick", () -> new ConsumableItem(foodBuilder(AMDFoodValues.TENTACLE_STICK), true));
    public static final RegistryObject<Item> CHEESE_SEAL_STICK = ITEMS.register("cheese_seal_stick", () -> new ConsumableItem(foodBuilder(AMDFoodValues.SEAL_STICK), true));
    public static final RegistryObject<Item> CENTIPEDE_LEG_WITH_CARROT_STICK = ITEMS.register("centipede_leg_with_carrot_stick", () -> new ConsumableItem(foodBuilder(AMDFoodValues.CENTIPEDE_LEG_STICK), true));
    public static final RegistryObject<Item> COOKED_MAGGOT_STICK = ITEMS.register("cooked_maggot_stick", () -> new Item(foodBuilder(AMDFoodValues.COOKED_MAGGOT_STICK)));

    //汉堡三明治
    public static final RegistryObject<Item> BIG_MAC = ITEMS.register("big_mac", () -> new SlowEatConsumableItem(foodBuilder(AMDFoodValues.BIG_MAC), true));
    public static final RegistryObject<Item> TUSKLIN_HOT_DOG = ITEMS.register("tusklin_hot_dog", () -> new SlowEatConsumableItem(foodBuilder(AMDFoodValues.TUSKLIN_HOTDOG), true));
    public static final RegistryObject<Item> WHALE_BURGER = ITEMS.register("whale_burger", () -> new SlowEatConsumableItem(foodBuilder(AMDFoodValues.WHALE_BURGER), true));
    public static final RegistryObject<Item> CHEESE_SEAL_BURGER = ITEMS.register("cheese_seal_burger", () -> new ConsumableItem(foodBuilder(AMDFoodValues.CHEESE_SEAL_BURGER), true));
    public static final RegistryObject<Item> SMOKED_TUSKLIN_SANDWICH = ITEMS.register("smoked_tusklin_sandwich", () -> new Item(foodBuilder(AMDFoodValues.SMOKED_TUSKLIN_SANDWICH)));
    public static final RegistryObject<Item> TENTACLE_SANDWICH = ITEMS.register("tentacle_sandwich", () -> new Item(foodBuilder(AMDFoodValues.TENTACLE_SANDWICH)));
    public static final RegistryObject<Item> DRIED_KELP_TENTACLES_SANDWICH = ITEMS.register("dried_kelp_tentacles_sandwich", () -> new Item(foodBuilder(AMDFoodValues.DRIED_KELP_TENTACLE_SANDWICH)));
    public static final RegistryObject<Item> SEAL_SANDWICH = ITEMS.register("seal_sandwich", () -> new Item(foodBuilder(AMDFoodValues.SEAL_SANDWICH)));

    //派
    public static final RegistryObject<Item> MOOSE_PIE = ITEMS.register("moose_pie", () -> new BlockItem(BlockRegistry.MOOSE_PIE_BLOCK.get(), defaultBuilder().stacksTo(1)));
    public static final RegistryObject<Item> MOOSE_PIE_SLICE = ITEMS.register("slice_of_moose_pie", () -> new Item(foodBuilder(AMDFoodValues.MOOSE_PIE)));

    //特殊
    public static final RegistryObject<Item> ENCHANTED_COOKED_SEAGULL = ITEMS.register("enchanted_cooked_seagull", () -> new EnchantedSeagullItem(foodBuilder(AMDFoodValues.ALWAYS_EAT_COOKED_SEAGULL).rarity(Rarity.RARE)));
    public static final RegistryObject<Item> ETERNAL_COOKED_SEAGULL = ITEMS.register("eternal_cooked_seagull", () -> new EternalFoodItem(foodBuilder(AMDFoodValues.COOKED_SEAGULL).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> ENCHANTED_ETERNAL_COOKED_SEAGULL = ITEMS.register("enchanted_eternal_cooked_seagull", () -> new EnchantedEternalSeagullItem(foodBuilder(AMDFoodValues.ALWAYS_EAT_COOKED_SEAGULL).rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> RAINBOW_CUSTARD = ITEMS.register("rainbow_custard", () -> new RainbowConsumableItem(foodBuilder(FoodValues.GLOW_BERRY_CUSTARD).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> RAINBOW_POPSICLE = ITEMS.register("rainbow_popsicle", () -> new RainbowPopsicleItem(foodBuilder(FoodValues.POPSICLE)));
    public static final RegistryObject<Item> BANANA_SLUG_CUSTARD = ITEMS.register("banana_slug_slime_custard", () -> new ConsumableItem(foodBuilder(AMDFoodValues.BANANA_CUSTARD).craftRemainder(Items.GLASS_BOTTLE), true));
    public static final RegistryObject<Item> BANANA_SLUG_POPSICLE = ITEMS.register("banana_slug_slime_popsicle", () -> new BananaPopsicleItem(foodBuilder(FoodValues.POPSICLE)));
    public static final RegistryObject<Item> KIVIAK = ITEMS.register("kiviak", () -> new KiviakItem(foodBuilder(AMDFoodValues.KIVIAK), true));
    public static final RegistryObject<Item> ORCAS_LEAP_SOUP = ITEMS.register("orcas_leap_soup", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.WHALE_SOUP), true, true));
    public static final RegistryObject<Item> SURFLYGFISK = ITEMS.register("surflygfisk", () -> new FlyingFishCan(defaultBuilder().stacksTo(1)));
    public static final RegistryObject<Item> OPENED_SURFLYGFISK = ITEMS.register("surflygfisk_open", () -> new FlyingFishCanOpened(bucketFoodBuilder(AMDFoodValues.FLYING_FISH_CAN), true));

    public static final RegistryObject<Item> DETOXIFY_JELLY = ITEMS.register("detoxify_jelly", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.DETOXIFY_JELLY), true));
    public static final RegistryObject<Item> DETOXIFY_SOUP = ITEMS.register("detoxify_soup", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.DETOXIFY_SOUP), true));
    public static final RegistryObject<Item> DETOXIFY_SOUP_CUP = ITEMS.register("detoxify_soup_cup", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.DETOXIFY_SOUP), true));
    public static final RegistryObject<Item> DETOXIFY_TEA = ITEMS.register("detoxify_tea", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.DETOXIFY_TEA), true));

    public static final RegistryObject<Item> DIMENSIONAL_FOOD = ITEMS.register("dimensional_food", () -> new DimensionalFoods(defaultBuilder().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> MIMICANDY = ITEMS.register("mimicandy", () -> new ConsumableItem(foodBuilder(AMDFoodValues.MIMICANDY), false, true));

    //汤
    public static final RegistryObject<Item> BOWL_OF_WILD_STEW = ITEMS.register("bowl_of_wild_stew", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.BOWL_OF_WILD_STEW), true));
    public static final RegistryObject<Item> FRONTIER_SOUP = ITEMS.register("frontier_soup", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.FRONTIER_SOUP), true));
    public static final RegistryObject<Item> KANGAROO_MEAT_STEW = ITEMS.register("kangaroo_meat_stew", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.KANGAROO_MEAT_STEW), true));
    public static final RegistryObject<Item> MOOSE_STEW = ITEMS.register("moose_stew", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.MOOSE_STEW), true));
    public static final RegistryObject<Item> SEA_BEAR_STEW = ITEMS.register("sea_bear_stew", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.SEA_BEAR_STEW), true, true));
    public static final RegistryObject<Item> SEAGULL_SOUP = ITEMS.register("seagull_soup", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.SEAGULL_SOUP), true));
    public static final RegistryObject<Item> CATFISH_STEW = ITEMS.register("catfish_stew", () -> new ConsumableItem(bowlFoodBuilder(FoodValues.FISH_STEW), true));
    public static final RegistryObject<Item> DEVILS_HOLE_PUPFISH_STEW = ITEMS.register("devils_hole_pupfish_stew", () -> new ConsumableItem(bowlFoodBuilder(FoodValues.FISH_STEW), true));
    public static final RegistryObject<Item> FLYING_FISH_STEW = ITEMS.register("flying_fish_stew", () -> new ConsumableItem(bowlFoodBuilder(FoodValues.FISH_STEW), true));
    public static final RegistryObject<Item> MUDSKIPPER_STEW = ITEMS.register("mudskipper_stew", () -> new ConsumableItem(bowlFoodBuilder(FoodValues.FISH_STEW), true));
    public static final RegistryObject<Item> SEAL_STEW = ITEMS.register("seal_stew", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.SEAL_STEW), true));
    public static final RegistryObject<Item> CROCODILE_STEW_WITH_CATFISH = ITEMS.register("crocodile_stewed_with_catfish", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.CROCODILE_STEW_WITH_CATFISH), true));
    public static final RegistryObject<Item> WHALE_SKIN_STEW = ITEMS.register("whale_skin_stew", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.WHALE_SKIN_STEW), true));

    public static final RegistryObject<Item> CAVE_CENTIPEDE_SOUP = ITEMS.register("cave_centipede_soup", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.CENTIPEDE_SOUP), true));
    public static final RegistryObject<Item> COCKROACH_PROTEIN_SOUP = ITEMS.register("cockroach_protein_soup", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.PROTEIN_SOUP), true));
    public static final RegistryObject<Item> MAGGOT_CREAM_SOUP = ITEMS.register("maggot_cream_soup", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.MAGGOT_SOUP), true));

    public static final RegistryObject<Item> CAVE_CENTIPEDE_SOUP_CUP = ITEMS.register("cave_centipede_soup_cup", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.WHALE_SKIN_STEW), true));
    public static final RegistryObject<Item> COCKROACH_PROTEIN_SOUP_CUP = ITEMS.register("cockroach_protein_soup_cup", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.WHALE_SKIN_STEW), true));
    public static final RegistryObject<Item> MOSQUITO_REPELLENT_STEW_CUP = ITEMS.register("mosquito_repellent_stew_cup", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.WHALE_SKIN_STEW), true));
    public static final RegistryObject<Item> SOPA_DE_MACACO_CUP = ITEMS.register("sopa_de_macaco_cup", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.WHALE_SKIN_STEW), true));

    //碗装食物
    public static final RegistryObject<Item> BISON_TARTARE = ITEMS.register("bison_tartare", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.BISON_TARTARE), true));
    public static final RegistryObject<Item> BOWL_OF_HONEY_GLAZED_BEAR_MEAT_WITH_SALMON = ITEMS.register("bowl_of_honey_glazed_bear_meat_with_salmon", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.BOWL_OF_HONEY_GLAZED_BEAR_MEAT_WITH_SALMON), true));
    public static final RegistryObject<Item> BRAISED_KANGAROO_MEATBALLS = ITEMS.register("braised_kangaroo_meatballs", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.BREASTED_KANGAROO_MEATBALLS), true));
    public static final RegistryObject<Item> GRAVY_KANGAROO_MEAT = ITEMS.register("gravy_kangaroo_meat", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.GRAVY_KANGAROO_MEAT), true));
    public static final RegistryObject<Item> HONEY_GLAZED_MOOSE_RIBS = ITEMS.register("honey_glazed_moose_ribs", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.HONEY_GLAZED_MOOSE_RIBS), true));
    public static final RegistryObject<Item> ROAST_SEAGULL = ITEMS.register("roast_seagull", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.ROAST_SEAGULL), true));
    public static final RegistryObject<Item> CANNED_BEAR_MEAT = ITEMS.register("canned_bear_meat", () -> new SlowEatConsumableItem(bucketFoodBuilder(AMDFoodValues.CANNED_BEAR_MEAT), true));
    public static final RegistryObject<Item> FRIED_SEAGULL_WITH_FRIES = ITEMS.register("fried_seagull_with_fries", () -> new ConsumableItem(bucketFoodBuilder(AMDFoodValues.FRIED_SEAGULL_WITH_FRIES), true));
    public static final RegistryObject<Item> KATSUDON = ITEMS.register("katsudon", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.KATSUDON), true));
    public static final RegistryObject<Item> BOWL_OF_MOOSE_SAUSAGE_WITH_SALMON = ITEMS.register("bowl_of_moose_sausage_with_salmon", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.BOWL_OF_MOOSE_SAUSAGE_WITH_SALMON), true));
    public static final RegistryObject<Item> BOWL_OF_STUFFED_CROCODILE_HEAD = ITEMS.register("bowl_of_stuffed_crocodile_head", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.STUFFED_CROCODILE_HEAD), true));
    public static final RegistryObject<Item> BOWL_OF_STUFFED_CROCODILE_TAIL = ITEMS.register("bowl_of_stuffed_crocodile_tail", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.STUFFED_CROCODILE_TAIL), true));
    public static final RegistryObject<Item> BOWL_OF_STUFFED_CROCODILE_LEG = ITEMS.register("bowl_of_stuffed_crocodile_leg", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.STUFFED_CROCODILE_CLAW), true));
    public static final RegistryObject<Item> BOWL_OF_STUFFED_CROCODILE = ITEMS.register("bowl_of_stuffed_crocodile", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.STUFFED_CROCODILE), true));
    public static final RegistryObject<Item> TENTACLE_MEDLEY = ITEMS.register("tentacle_medley", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.TENTACLE_MEDLEY), false));
    public static final RegistryObject<Item> CTHULHUS_BREAKFAST = ITEMS.register("cthulhus_breakfast", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.CTHULHUS_BREAKFAST), true));
    public static final RegistryObject<Item> LOBSTER_HEAD_STEW = ITEMS.register("lobster_head_stew", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.LOBSTER_HEAD_STEW), true));
    public static final RegistryObject<Item> LOBSTER_PASTA = ITEMS.register("lobster_pasta", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.LOBSTER_PASTA), true));
    public static final RegistryObject<Item> ACACIA_BLOSSOM_TENTACLE_SALAD = ITEMS.register("acacia_blossom_tentacle_salad", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.TENTACLE_SALAD), true));
    public static final RegistryObject<Item> WHALE_MEAT_WITH_TENTACLES = ITEMS.register("whale_meat_with_tentacles", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.WHALE_TENTACLE), true));
    public static final RegistryObject<Item> POT_OF_WHALE_MEAT_STEWED_WITH_PORK = ITEMS.register("pot_of_whale_meat_stewed_with_pork", () -> new ConsumableItem(customContainerFoodBuilder(AMDFoodValues.WHALE_PORK_STEW, Items.FLOWER_POT), true));

    public static final RegistryObject<Item> ANTS_CLIMBING_A_TREE = ITEMS.register("ants_climbing_a_tree", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.ANTS_CLIMBING_A_TREE), true));
    public static final RegistryObject<Item> BRAISED_TARANTULA_HAWK_LARVA = ITEMS.register("braised_tarantula_hawk_larva", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.BRAISED_TARANTULA_HAWK_LARVA), true));
    public static final RegistryObject<Item> CRISPY_COCKROACH_WING = ITEMS.register("crispy_cockroach_wing", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.CRISPY_COCKROACH_WING), true));
    public static final RegistryObject<Item> CRISPY_TARANTULA_HAWK_WING = ITEMS.register("crispy_tarantula_hawk_wing", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.CRISPY_TARANTULA_HAWK_WING), true));
    public static final RegistryObject<Item> FRIED_ANTS = ITEMS.register("fried_ants", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.FRIED_ANTS), true));
    public static final RegistryObject<Item> FRIED_CENTIPEDE_MEAT = ITEMS.register("fried_centipede_meat", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.FRIED_CENTIPEDE_MEAT), true));
    public static final RegistryObject<Item> SERVE_OF_FRIED_TARANTULA_HAWK = ITEMS.register("serve_of_fried_tarantula_hawk", () -> new ConsumableItem(foodBuilder(AMDFoodValues.FRIED_TARANTULA_HAWK), true));
    public static final RegistryObject<Item> GAZING_INTO_THE_ABYSS = ITEMS.register("gazing_into_the_abyss", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.GAZING_INTO_THE_ABYSS), true));
    public static final RegistryObject<Item> MAGGOT_SALAD = ITEMS.register("maggot_salad", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.MAGGOT_SALAD), true));
    public static final RegistryObject<Item> PICKLED_MAGGOTS = ITEMS.register("pickled_maggots", () -> new ConsumableItem(foodBuilder(AMDFoodValues.PICKLED_MAGGOTS).craftRemainder(Items.GLASS_BOTTLE), true));
    public static final RegistryObject<Item> PLATE_OF_MUSHROOMS_BRAISED_WITH_CENTIPEDE = ITEMS.register("plate_of_mushrooms_braised_with_centipede", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.MUSHROOMS_BRAISED_WITH_CENTIPEDE), true));
    public static final RegistryObject<Item> TARANTULA_HAWK_SASHIMI = ITEMS.register("tarantula_hawk_sashimi", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.TARANTULA_HAWK_SASHIMI), true));
    public static final RegistryObject<Item> TRUE_ANTS_CLIMBING_A_TREE = ITEMS.register("true_ants_climbing_a_tree", () -> new ConsumableItem(bowlFoodBuilder(AMDFoodValues.TRUE_ANTS_CLIMBING_A_TREE), true));

    //大菜
    public static final RegistryObject<Item> MOOSE_SAUSAGE_WITH_SALMON = ITEMS.register("moose_sausage_with_salmon", () -> new BlockItem(BlockRegistry.MOOSE_SAUSAGE_WITH_SALMON.get(), defaultBuilder().stacksTo(1)));
    public static final RegistryObject<Item> HONEY_GLAZED_BEAR_MEAT_WITH_SALMON = ITEMS.register("honey_glazed_bear_meat_with_salmon", () -> new BlockItem(BlockRegistry.HONEY_GLAZED_BEAR_MEAT_WITH_SALMON.get(), defaultBuilder().stacksTo(1)));
    public static final RegistryObject<Item> WILD_STEW = ITEMS.register("wild_stew", () -> new BlockItem(BlockRegistry.WILD_STEW.get(), defaultBuilder().stacksTo(1)));
    public static final RegistryObject<Item> ALEXS_RICE_ROLL_MEDLEY = ITEMS.register("alexs_rice_roll_medley", () -> new PlaceOnWaterBlockItem(BlockRegistry.ALEXS_RICE_ROLL_MEDLEY.get(), defaultBuilder().stacksTo(1)));
    public static final RegistryObject<Item> STEAMED_STUFFED_CROCODILE = ITEMS.register("steamed_stuffed_crocodile", () -> new BlockItem(BlockRegistry.STEAMED_STUFFED_CROCODILE.get(), defaultBuilder().stacksTo(1)));
    public static final RegistryObject<Item> LOBSTER_ROLL_MEDLEY = ITEMS.register("lobster_roll_medley", () -> new BlockItem(BlockRegistry.LOBSTER_ROLL_MEDLEY.get(), defaultBuilder().stacksTo(1)));
    public static final RegistryObject<Item> WHALE_MEAT_STEWED_WITH_PORK = ITEMS.register("whale_meat_stewed_with_pork", () -> new BlockItem(BlockRegistry.WHALE_MEAT_STEWED_WITH_PORK.get(), defaultBuilder().stacksTo(1)));
    public static final RegistryObject<Item> FRIED_TARANTULA_HAWK = ITEMS.register("fried_tarantula_hawk", () -> new BlockItem(BlockRegistry.FRIED_TARANTULA_HAWK.get(), defaultBuilder().stacksTo(1)));
    public static final RegistryObject<Item> MUSHROOMS_BRAISED_WITH_CENTIPEDE = ITEMS.register("mushrooms_braised_with_centipede", () -> new BlockItem(BlockRegistry.MUSHROOMS_BRAISED_WITH_CENTIPEDE.get(), defaultBuilder().stacksTo(1)));

    //方块
    public static final RegistryObject<Item> COASTAL_KIVIAK = ITEMS.register("coastal_kiviak", () -> new BlockItem(BlockRegistry.COASTAL_KIVIAK.get(), defaultBuilder().stacksTo(1)));
    public static final RegistryObject<Item> POLAR_KIVIAK = ITEMS.register("polar_kiviak", () -> new BlockItem(BlockRegistry.POLAR_KIVIAK.get(), defaultBuilder().stacksTo(1)));
    public static final RegistryObject<Item> SEAL_FUR_CARPET_BROWN = ITEMS.register("seal_fur_carpet_brown", () -> new BlockItem(BlockRegistry.SEAL_FUR_CARPET_BROWN.get(), defaultBuilder()));
    public static final RegistryObject<Item> SEAL_FUR_CARPET_GRAY = ITEMS.register("seal_fur_carpet_gray", () -> new BlockItem(BlockRegistry.SEAL_FUR_CARPET_GRAY.get(), defaultBuilder()));


    private static Item.Properties defaultBuilder() {
        return new Item.Properties();
    }

    public static Item.Properties foodBuilder(FoodProperties food) {
        return defaultBuilder().food(food);
    }

    private static Item.Properties bowlFoodBuilder(FoodProperties food) {
        return defaultBuilder().craftRemainder(Items.BOWL).stacksTo(16).food(food);
    }

    private static Item.Properties bucketFoodBuilder(FoodProperties food) {
        return defaultBuilder().craftRemainder(Items.BUCKET).stacksTo(1).food(food);
    }

    private static Item.Properties customContainerFoodBuilder(FoodProperties food, Item item) {
        return defaultBuilder().craftRemainder(item).stacksTo(16).food(food);
    }
}
