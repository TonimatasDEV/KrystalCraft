package net.tonimatasmc.krystalcraft.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.tonimatasmc.krystalcraft.KrystalCraft;
import net.tonimatasmc.krystalcraft.block.ModBlocks;

import java.util.function.Function;

public class ModBlocksStateProvider extends BlockStateProvider {
    public ModBlocksStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, KrystalCraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.BRONZE_BLOCK.get());
        simpleBlock(ModBlocks.DEEPSLATE_EXPERIENCE_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_JADE_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_LEAD_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_PLATINUM_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_RUBY_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_SILVER_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_TIN_ORE.get());
        simpleBlock(ModBlocks.DEEPSLATE_TOPAZ_ORE.get());
        simpleBlock(ModBlocks.EXPERIENCE_ORE.get());
        simpleBlock(ModBlocks.JADE_BLOCK.get());
        simpleBlock(ModBlocks.JADE_ORE.get());
        simpleBlock(ModBlocks.LEAD_BLOCK.get());
        simpleBlock(ModBlocks.LEAD_ORE.get());
        simpleBlock(ModBlocks.PLATINUM_BLOCK.get());
        simpleBlock(ModBlocks.PLATINUM_ORE.get());
        simpleBlock(ModBlocks.RUBY_BLOCK.get());
        simpleBlock(ModBlocks.RUBY_ORE.get());
        simpleBlock(ModBlocks.SAPPHIRE_BLOCK.get());
        simpleBlock(ModBlocks.SAPPHIRE_ORE.get());
        simpleBlock(ModBlocks.SILVER_BLOCK.get());
        simpleBlock(ModBlocks.SILVER_ORE.get());
        simpleBlock(ModBlocks.TIN_BLOCK.get());
        simpleBlock(ModBlocks.TIN_ORE.get());
        simpleBlock(ModBlocks.TOPAZ_BLOCK.get());
        simpleBlock(ModBlocks.TOPAZ_ORE.get());
    }

    public ModelFile flowerPotCross(String name) {
        return models().withExistingParent(name, "flower_pot_cross");
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(block.getAgeProperty()),
                new ResourceLocation(KrystalCraft.MOD_ID, "block/" + textureName + state.getValue(block.getAgeProperty()))));

        return models;
    }
}
