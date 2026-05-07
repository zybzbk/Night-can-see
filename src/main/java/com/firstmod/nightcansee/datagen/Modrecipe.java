package com.firstmod.nightcansee.datagen;

import com.firstmod.nightcansee.ModBlock;
import com.firstmod.nightcansee.Nightcansee;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class Modrecipe extends RecipeProvider implements IConditionBuilder {
    public Modrecipe(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Nightcansee.MAGIC_BOOK.get())
                .pattern("###")
                .pattern("X#X")
                .pattern("###")
                .define('#',Nightcansee.YE_SHI.get())
                .define('X',Items.GREEN_STAINED_GLASS_PANE)
                .unlockedBy(getHasName(Nightcansee.YE_SHI.get()), has(Nightcansee.YE_SHI.get()))
                .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlock.YE_SHI_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#',Nightcansee.YE_SHI.get())
                .unlockedBy(getHasName(ModBlock.YE_SHI_BLOCK.get()), has(ModBlock.YE_SHI_BLOCK.get()))
                .save(recipeOutput);

    }

}
