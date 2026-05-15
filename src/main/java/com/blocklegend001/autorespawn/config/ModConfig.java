package com.blocklegend001.autorespawn.config;

import com.blocklegend001.autorespawn.AutoRespawn;
import com.mojang.datafixers.util.Pair;

public class ModConfig {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static int RespawnDelay;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(AutoRespawn.MOD_ID).provider(configs).request();
        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("RespawnDelay", 2000), "Delay (in milliseconds) before respawn | Set to '0' for instant respawn");
    }

    private static void assignConfigs() {
        RespawnDelay = CONFIG.getOrDefault("RespawnDelay", 2000);
        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}
