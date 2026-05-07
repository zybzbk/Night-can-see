package com.firstmod.nightcansee.datagen;


import com.firstmod.nightcansee.ModBlock;
import com.firstmod.nightcansee.Nightcansee;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStates extends BlockStateProvider {

    public ModBlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Nightcansee.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlock.YE_SHI_BLOCK.get(), cubeAll(ModBlock.YE_SHI_BLOCK.get()));
    }
}
