package com.blocklegend001.autorespawn;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoRespawn implements ModInitializer {
    public static final String MOD_ID = "autorespawn";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("AutoRespawn Loaded!");
    }
}