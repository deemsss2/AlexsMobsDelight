package io.github.rcneg.alexsmobsdelight.init;

import io.github.rcneg.alexsmobsdelight.AlexsMobsDelight;
import io.github.rcneg.alexsmobsdelight.blocks.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.PieBlock;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AlexsMobsDelight.MODID);

    public static final RegistryObject<Block> HONEY_GLAZED_BEAR_MEAT_WITH_SALMON = BLOCKS.register("honey_glazed_bear_meat_with_salmon", () -> {
        return new HoneyGlazedBearMeatWithSalmonBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ItemRegistry.BOWL_OF_HONEY_GLAZED_BEAR_MEAT_WITH_SALMON, true);
    });
    public static final RegistryObject<Block> MOOSE_SAUSAGE_WITH_SALMON = BLOCKS.register("moose_sausage_with_salmon", () -> {
        return new MooseSausageWithSalmonBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).sound(SoundType.BONE_BLOCK), ItemRegistry.BOWL_OF_MOOSE_SAUSAGE_WITH_SALMON, true);
    });
    public static final RegistryObject<Block> MOOSE_PIE_BLOCK = BLOCKS.register("moose_pie", () -> {
        return new PieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ItemRegistry.MOOSE_PIE_SLICE);
    });
    public static final RegistryObject<Block> WILD_STEW = BLOCKS.register("wild_stew", () -> {
        return new WildStewBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).sound(SoundType.LANTERN), ItemRegistry.BOWL_OF_WILD_STEW, true);
    });
    public static final RegistryObject<Block> ALEXS_RICE_ROLL_MEDLEY = BLOCKS.register("alexs_rice_roll_medley", () -> {
        return new AlexsRiceRollMedleyBlock(BlockBehaviour.Properties.copy(Blocks.CAKE));
    });
    public static final RegistryObject<Block> LOBSTER_ROLL_MEDLEY = BLOCKS.register("lobster_roll_medley", () -> {
        return new LobsterRollMedleyBlock(BlockBehaviour.Properties.copy(Blocks.CAKE));
    });
    public static final RegistryObject<Block> STEAMED_STUFFED_CROCODILE = BLOCKS.register("steamed_stuffed_crocodile", () -> {
        return new SteamedStuffedCrocodileBlock(BlockBehaviour.Properties.copy(Blocks.CAKE));
    });
    public static final RegistryObject<Block> WHALE_MEAT_STEWED_WITH_PORK = BLOCKS.register("whale_meat_stewed_with_pork", () -> {
        return new WhalePorkStewBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).sound(SoundType.DECORATED_POT), ItemRegistry.POT_OF_WHALE_MEAT_STEWED_WITH_PORK, true);
    });
    public static final RegistryObject<Block> FRIED_TARANTULA_HAWK = BLOCKS.register("fried_tarantula_hawk", () -> {
        return new FriedTarantulaHawkBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ItemRegistry.SERVE_OF_FRIED_TARANTULA_HAWK, true);
    });
    public static final RegistryObject<Block> MUSHROOMS_BRAISED_WITH_CENTIPEDE = BLOCKS.register("mushrooms_braised_with_centipede", () -> {
        return new MushroomsBraisedWithCentipedeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).sound(SoundType.COPPER), ItemRegistry.PLATE_OF_MUSHROOMS_BRAISED_WITH_CENTIPEDE, true);
    });
    public static final RegistryObject<Block> BANANA_BLOCK = BLOCKS.register("banana_block", () -> {
        return new BananaBlock(BlockBehaviour.Properties.copy(Blocks.COCOA).sound(SoundType.BIG_DRIPLEAF).noCollission());
    });
    public static final RegistryObject<Block> COASTAL_KIVIAK = BLOCKS.register("coastal_kiviak", () -> {
        return new KiviakBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_WART_BLOCK));
    });
    public static final RegistryObject<Block> POLAR_KIVIAK = BLOCKS.register("polar_kiviak", () -> {
        return new KiviakBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_WART_BLOCK));
    });
    public static final RegistryObject<Block> ACACIA_BLOSSOM_BLOCK = BLOCKS.register("acacia_blossom_block", () -> {
        return new AcaciaBlossomBlock(BlockBehaviour.Properties.copy(Blocks.COCOA).sound(SoundType.GRASS).noCollission());
    });
    public static final RegistryObject<Block> SEAL_FUR_CARPET_BROWN = BLOCKS.register("seal_fur_carpet_brown", () -> {
        return new SealCarpet(BlockBehaviour.Properties.copy(Blocks.BROWN_CARPET));
    });
    public static final RegistryObject<Block> SEAL_FUR_CARPET_GRAY = BLOCKS.register("seal_fur_carpet_gray", () -> {
        return new SealCarpet(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CARPET));
    });
}
