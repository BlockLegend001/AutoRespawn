package com.blocklegend001.autorespawn;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(AutoRespawn.MODID)
public class AutoRespawn {
    public static final String MODID = "autorespawn";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AutoRespawn(IEventBus modEventBus) {
        LOGGER.info("AutoRespawn Loaded!");
    }
}
