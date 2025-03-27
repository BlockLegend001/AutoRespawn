package com.blocklegend001.autorespawn.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class AutoRespawnClient implements ClientModInitializer {
    private long deathTime = 0;
    private boolean wasDead = false;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null && client.player.isDead()) {
                handleRespawn(client);
            } else {
                resetDeathState();
            }
        });
    }

    private void handleRespawn(MinecraftClient client) {
        if (!wasDead) {
            deathTime = System.currentTimeMillis();
            wasDead = true;
        }

        if (System.currentTimeMillis() - deathTime >= 2000) {
            if (client.player != null) {
                client.player.requestRespawn();
                client.setScreen(null);
                resetDeathState();
            }
        }
    }

    private void resetDeathState() {
        deathTime = 0;
        wasDead = false;
    }
}