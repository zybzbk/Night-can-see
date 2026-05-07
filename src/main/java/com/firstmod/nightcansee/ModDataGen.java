package com.firstmod.nightcansee;

import com.firstmod.nightcansee.datagen.ModBlockStates;
import com.firstmod.nightcansee.datagen.ModModels;
import com.firstmod.nightcansee.datagen.ModZhCnLang;
import com.firstmod.nightcansee.datagen.Modrecipe;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Nightcansee.MODID)
public class ModDataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupproviner = event.getLookupProvider();

        gen.addProvider(event.includeClient(), new ModModels(packOutput, existingFileHelper));
        gen.addProvider(event.includeClient(), new ModZhCnLang(packOutput));
        gen.addProvider(event.includeClient(),new Modrecipe(packOutput,lookupproviner));
        gen.addProvider(event.includeClient(), new ModBlockStates(packOutput, existingFileHelper));
    }
}
