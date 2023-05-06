package net.tonimatasdev.krystalcraft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.block.ModBlocks;

public class ModBlocksStateProvider extends BlockStateProvider {
    public ModBlocksStateProvider(PackOutput packOutput, ExistingFileHelper exFileHelper) {
        super(packOutput, KrystalCraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (RegistryObject<Block> block : ModBlocks.BLOCKS.getEntries()) {
            simpleBlock(block.get());
            itemModels().withExistingParent(block.getId().getPath(), new ResourceLocation(KrystalCraft.MOD_ID, "block/" + block.getId().getPath()));
        }

        for (RegistryObject<Block> block : ModBlocks.BLOCK_ENTITIES.getEntries()) {
            itemModels().withExistingParent(block.getId().getPath(), new ResourceLocation(KrystalCraft.MOD_ID, "block/" + block.getId().getPath()));
        }
    }
}
