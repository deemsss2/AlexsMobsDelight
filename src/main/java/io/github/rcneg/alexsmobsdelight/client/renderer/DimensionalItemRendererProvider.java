package io.github.rcneg.alexsmobsdelight.client.renderer;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

@OnlyIn(Dist.CLIENT)
public class DimensionalItemRendererProvider implements IClientItemExtensions {

    private BlockEntityWithoutLevelRenderer BEWLR;

    @Override
    public BlockEntityWithoutLevelRenderer getCustomRenderer() {
        if (BEWLR == null) {
            BEWLR = new AMDItemstackRenderer();
        }
        return BEWLR;
    }
}