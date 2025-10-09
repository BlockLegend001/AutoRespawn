package com.blocklegend001.autorespawn;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;

public class ModConfigs {
    public static final ForgeConfigSpec.Builder mycfg = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.IntValue RespawnDelay = mycfg
            .comment("Delay (in milliseconds) before respawn | Set to '0' for instant respawn | Default 2000")
            .defineInRange("RespawnDelay", 2000, 0, Integer.MAX_VALUE);

    public static ForgeConfigSpec SPEC = mycfg.build();

    public static int respawnDelay;

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        final CommentedFileConfig config = CommentedFileConfig.builder(path).sync().autoreload().build();
        config.load();
        spec.setConfig(config);

        respawnDelay = RespawnDelay.get();
    }
}
