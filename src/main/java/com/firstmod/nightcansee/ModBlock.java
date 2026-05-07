package com.firstmod.nightcansee;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlock {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Nightcansee.MODID);

    public static Supplier<Block> YE_SHI_BLOCK = registerBlocks(
            "ye_shi_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(1.0F,0.5F))
    );

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        Nightcansee.ITEMS.register(name,() -> new BlockItem(block.get(), new Item.Properties()));
    }
    private static <T extends Block> DeferredBlock<T>  registerBlocks(String name, Supplier<T>block) {
        DeferredBlock<T> blocks = BLOCKS.register(name, block);
        registerBlockItem(name, blocks);
        return blocks;
    }
}
