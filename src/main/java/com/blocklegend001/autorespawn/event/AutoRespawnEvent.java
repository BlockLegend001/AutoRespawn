package com.blocklegend001.autorespawn.event;

import com.blocklegend001.autorespawn.AutoRespawn;
import com.blocklegend001.autorespawn.ModConfigs;
import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;

@EventBusSubscriber(modid = AutoRespawn.MODID)
public class AutoRespawnEvent {
    private static long deathTime = 0;
    private static boolean wasDead = false;

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
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

        if (System.currentTimeMillis() - deathTime >= ModConfigs.respawnDelay) {
            if (client.player != null) {
                client.player.respawn();
                client.gui.setScreen(null);
                resetDeathState();
            }
        }
    }

    private static void resetDeathState() {
        deathTime = 0;
        wasDead = false;
    }
}