package com.firstmod.nightcansee;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLLoadCompleteEvent;

@EventBusSubscriber
public class Log {
    @SubscribeEvent
    public static void MODLoadCompleteEvent(FMLLoadCompleteEvent event) {
        Nightcansee.LOGGER.info("欢迎使用我的模组，祝你一天身体健康");
    }



}
