package io.github.rcneg.alexsmobsdelight.init;

import com.github.alexthe666.alexsmobs.client.render.RenderCrimsonMosquito;
import io.github.rcneg.alexsmobsdelight.client.renderer.SuperSeagullRenderer;
import io.github.rcneg.alexsmobsdelight.client.renderer.ThrownDartRenderer;
import io.github.rcneg.alexsmobsdelight.client.renderer.ThrownPointedItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RendererRegistry {

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityTypeRegistry.THROWN_DART.get(), ThrownDartRenderer::new);
        event.registerEntityRenderer(EntityTypeRegistry.THROWN_BANANA.get(), ThrownPointedItemRenderer::new);
        event.registerEntityRenderer(EntityTypeRegistry.SUPER_SEAGULL.get(), SuperSeagullRenderer::new);
        event.registerEntityRenderer(EntityTypeRegistry.SUPER_MOSQUITO.get(), RenderCrimsonMosquito::new);

    }

}