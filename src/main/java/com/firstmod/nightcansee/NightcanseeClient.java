package com.firstmod.nightcansee;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;

// 该类在专用服务器上无法正常加载。不过，从这里访问客户端代码是安全的。
@Mod(value = Nightcansee.MODID, dist = Dist.CLIENT)
// 可以使用EventBusSubscriber自动注册@SubscribeEvent注解的类中的所有静态方法
@EventBusSubscriber(modid = Nightcansee.MODID, value = Dist.CLIENT)
public class NightcanseeClient {
    public NightcanseeClient(IEventBus eventBus) {
        Nightcansee.ITEMS.register(eventBus);
        Nightcansee.CREATIVE_MODE_TABS.register(eventBus);//把物品和物品栏弄到主线程注册

    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
        if (helmet.getItem() == Nightcansee.MAGIC_BOOK.get()) {
            //检测是否带上该物品，若为真则带上则基于一个无限的夜视效果，否则去除
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, -1, 0,true, false));
        }else {
            player.removeEffect(MobEffects.NIGHT_VISION);
        }
    }

}
