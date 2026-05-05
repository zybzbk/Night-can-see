package com.firstmod.nightcansee.datagen;

import com.firstmod.nightcansee.Nightcansee;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModZhCnLang extends LanguageProvider {
    public ModZhCnLang(PackOutput output) {
        super(output, Nightcansee.MODID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        add(Nightcansee.MAGIC_BOOK.get(), "夜视仪");
        add(Nightcansee.YE_SHI.get(), "ye shi");

        add("itemGroup.my_tab","夜视模组");
    }
}
