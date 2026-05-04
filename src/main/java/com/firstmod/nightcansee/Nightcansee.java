package com.firstmod.nightcansee;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.fml.common.Mod;

import java.util.function.Supplier;

// 此处的值应与 META-INF/neoforge.mods.toml 文件中的条目匹配
@Mod(Nightcansee.MODID)
public class Nightcansee {
    // 在公共位置定义 mod id 以供所有内容参考
    public static final String MODID = "nightcansee";
    // 直接引用 slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    //首先注册一个物品
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Nightcansee.MODID);

    public static final Supplier<Item> MAGIC_BOOK = ITEMS.register(
            "magic_book",
            () -> new ArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.HELMET,
                    (new Item.Properties()).durability(ArmorItem.Type.HELMET.getDurability(5)))
    );


    //然后再添加一个创造物品栏
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(
                    Registries.CREATIVE_MODE_TAB,
                    Nightcansee.MODID);

    public static final Supplier<CreativeModeTab> MY_TAB =
            CREATIVE_MODE_TABS.register("my_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Nightcansee.MAGIC_BOOK.get()))
                    .title(Component.translatable("itemGroup.my_tab"))
                    .displayItems((params, output) -> {
                        output.accept(Nightcansee.MAGIC_BOOK.get());
                    }).build());
}