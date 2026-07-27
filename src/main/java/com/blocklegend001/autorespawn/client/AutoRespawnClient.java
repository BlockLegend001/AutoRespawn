package com.blocklegend001.autorespawn.client;

import com.blocklegend001.autorespawn.config.ModConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.Minecraft;

public class AutoRespawnClient implements ClientModInitializer {
    private long deathTime = 0;
    private boolean wasDead = false;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null && client.player.isDeadOrDying()) {
                handleRespawn(client);
            } else {
                resetDeathState();
            }
        });
    }

    private void handleRespawn(Minecraft client) {
        if (!wasDead) {
            deathTime = System.currentTimeMillis();
            wasDead = true;
        }

        if (System.currentTimeMillis() - deathTime >= ModConfig.RespawnDelay) {
            if (client.player != null) {
                client.player.respawn();
                client.gui.setScreen(null);
                resetDeathState();
            }
        }
    }

    private void resetDeathState() {
        deathTime = 0;
        wasDead = false;
    }
}