package io.github.rcneg.alexsmobsdelight.events;


import io.github.rcneg.alexsmobsdelight.AlexsMobsDelight;
import io.github.rcneg.alexsmobsdelight.init.NetworkRegistry;
import io.github.rcneg.alexsmobsdelight.packet.WingBoostC2S;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AlexsMobsDelight.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientForgeEvents {

    private static boolean lastBoostPressed = false;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Minecraft mc = Minecraft.getInstance();
            LocalPlayer player = mc.player;

            if (player != null){

                boolean boost = mc.options.keyJump.isDown();
                if(player.isFallFlying()){
                    if(boost && !lastBoostPressed){
                        NetworkRegistry.sendToServer(new WingBoostC2S());
                    }
                }
                lastBoostPressed = boost;
            }
        }
    }
}
