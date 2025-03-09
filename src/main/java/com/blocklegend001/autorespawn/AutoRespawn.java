package com.blocklegend001.autorespawn;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(AutoRespawn.MODID)
public class AutoRespawn {

    public static final String MODID = "autorespawn";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AutoRespawn() {
        LOGGER.info("AutoRespawn Loaded!");
        MinecraftForge.EVENT_BUS.register(this);
    }
}
