package io.github.rcneg.alexsmobsdelight;

import com.github.alexthe666.alexsmobs.item.AMItemRegistry;
import io.github.rcneg.alexsmobsdelight.config.Config;
import io.github.rcneg.alexsmobsdelight.init.*;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;

import java.util.List;

@Mod(AlexsMobsDelight.MODID)
public class AlexsMobsDelight
{
    public static final String MODID = "alexsmobsdelight";

    public AlexsMobsDelight()
    {
        CriticalTriggerRegistry.init();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CONFIG);
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        ItemRegistry.ITEMS.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        RecipeRegistry.DEF_REG.register(modEventBus);
        EffectRegistry.MOB_EFFECTS.register(modEventBus);
        EntityTypeRegistry.ENTITY_TYPES.register(modEventBus);
        LootModifierRegistry.LOOT_MODIFIER.register(modEventBus);
        TabRegistry.CREATIVE_MODE_TABS.register(modEventBus);
        NetworkRegistry.register();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            registerStackSizeOverrides();
        });
    }

    public static void registerStackSizeOverrides() {
        if (!Config.STACKABLE_SOUP_ITEMS.get()) return;
        List<Item> soupItems = List.of(AMItemRegistry.MOSQUITO_REPELLENT_STEW.get(), AMItemRegistry.SOPA_DE_MACACO.get());
        soupItems.forEach((item) -> {
            if (item instanceof BowlFoodItem) {
                ObfuscationReflectionHelper.setPrivateValue(Item.class, item, 16, "f_41370_");
            }
        });
    }

    private void clientSetup(FMLClientSetupEvent event) {
    }
}
