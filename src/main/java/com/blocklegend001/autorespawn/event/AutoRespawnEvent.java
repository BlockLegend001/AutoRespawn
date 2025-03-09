package com.blocklegend001.autorespawn.event;

import com.blocklegend001.autorespawn.AutoRespawn;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AutoRespawn.MODID, value = Dist.CLIENT)
public class AutoRespawnEvent {
    private static long deathTime = 0;
    private static boolean wasDead = false;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        Minecraft client = Minecraft.getInstance();
        if (client.player != null && client.player.isDeadOrDying()) {
            handleRespawn(client);
        } else {
            resetDeathState();
        }
    }

    private static void handleRespawn(Minecraft client) {
        if (!wasDead) {
            deathTime = System.currentTimeMillis();
            wasDead = true;
        }

        if (System.currentTimeMillis() - deathTime >= 2000) {
            if (client.player != null) {
                client.player.respawn();
                client.setScreen(null);
                resetDeathState();
            }
        }
    }

    private static void resetDeathState() {
        deathTime = 0;
        wasDead = false;
    }
}