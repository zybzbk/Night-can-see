package com.firstmod.nightcansee.datagen;

import com.firstmod.nightcansee.Nightcansee;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModModels extends ItemModelProvider {

    public ModModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output,Nightcansee.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(Nightcansee.MAGIC_BOOK.get());
    }
}
