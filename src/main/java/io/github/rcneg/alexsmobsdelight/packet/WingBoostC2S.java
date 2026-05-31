package io.github.rcneg.alexsmobsdelight.packet;

import com.github.alexthe666.alexsmobs.misc.AMSoundRegistry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class WingBoostC2S {

    public static void encode(WingBoostC2S msg, FriendlyByteBuf buf) {}
    public static WingBoostC2S decode(FriendlyByteBuf buf) { return new WingBoostC2S(); }

    public static void handle(WingBoostC2S msg, Supplier<NetworkEvent.Context> ctxSup) {
        NetworkEvent.Context ctx = ctxSup.get();
        ServerPlayer player = ctx.getSender();
        if (player == null) return;

        ctx.enqueueWork(() -> {
            if(player.getFallFlyingTicks() > 10 && player.getFoodData().getFoodLevel() > 6){
                player.setDeltaMovement(player.getLookAngle().x() * 1.5F, player.getLookAngle().y() * 1.5F, player.getLookAngle().z() * 1.5F);
                player.hurtMarked = true;
                if(!player.getAbilities().instabuild){
                    player.getFoodData().addExhaustion(4.0f);
                }
                player.level().playSound(null, player, AMSoundRegistry.TARANTULA_HAWK_WING.get(), SoundSource.PLAYERS, 1.0F, 1.0F);
            }
        });

        ctx.setPacketHandled(true);
    }
}