package ru.college.leaflight;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block LUMINOUS_LEAVES = registerBlock("luminous_leaves",
            new Block(AbstractBlock.Settings.create()
                    .strength(3.0f, 6.0f) // Прочность и сопротивление (как у камня)
                    .sounds(BlockSoundGroup.GRASS) // Звуки как у травы/листвы
                    .luminance(state -> 12)// Уровень свечения (12 из 15)
                    .nonOpaque()
            ));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK,
                Identifier.of(LuminousLeaves.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM,
                Identifier.of(LuminousLeaves.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(LUMINOUS_LEAVES);
        });
    }
}