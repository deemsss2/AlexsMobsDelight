package io.github.rcneg.alexsmobsdelight.items;

import io.github.rcneg.alexsmobsdelight.client.renderer.DimensionalItemRendererProvider;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class DimensionalFoods extends Item{

    public DimensionalFoods(Properties p_41383_) {
        super(p_41383_);
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new DimensionalItemRendererProvider());
    }
}
