package com.blocklegend001.autorespawn;

import com.blocklegend001.autorespawn.ModConfigs;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

@Mod(AutoRespawn.MODID)
public class AutoRespawn {
    public static final String MODID = "autorespawn";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AutoRespawn(IEventBus modEventBus, ModContainer modContainer) {
        LOGGER.info("AutoRespawn Loaded!");
        modContainer.registerConfig(ModConfig.Type.COMMON, ModConfigs.SPEC);
    }
}
