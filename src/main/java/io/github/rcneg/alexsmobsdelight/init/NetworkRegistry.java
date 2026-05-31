package io.github.rcneg.alexsmobsdelight.init;

import io.github.rcneg.alexsmobsdelight.AlexsMobsDelight;
import io.github.rcneg.alexsmobsdelight.packet.WingBoostC2S;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.simple.SimpleChannel;

public class NetworkRegistry {
    private static final String PROTOCOL_VERSION = "1";

    public static final SimpleChannel CHANNEL = net.minecraftforge.network.NetworkRegistry.newSimpleChannel(
            new ResourceLocation(AlexsMobsDelight.MODID, "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    private static int id = 0;

    public static void register() {
        CHANNEL.messageBuilder(WingBoostC2S.class, id++)
                .encoder(WingBoostC2S::encode)
                .decoder(WingBoostC2S::decode)
                .consumerMainThread(WingBoostC2S::handle)
                .add();
    }

    public static void sendTotemActivate(ServerPlayer player, ItemStack stack) {
    }

    public static void sendToServer(Object msg) {
        CHANNEL.sendToServer(msg);
    }
}