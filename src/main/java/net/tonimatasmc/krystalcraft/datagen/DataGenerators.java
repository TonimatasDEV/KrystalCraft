package net.tonimatasmc.krystalcraft.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.tonimatasmc.krystalcraft.KrystalCraft;

@Mod.EventBusSubscriber(modid = KrystalCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generators = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(generators, existingFileHelper);

        //generators.addProvider(new ModRecipeProvider(generators));
        generators.addProvider(new ModLootTableProvider(generators));
        generators.addProvider(new ModItemModelProvider(generators, existingFileHelper));
        generators.addProvider(new ModBlocksStateProvider(generators, existingFileHelper));
        generators.addProvider(blockTagsProvider);
        generators.addProvider(new ModItemTagsProvider(generators, blockTagsProvider, existingFileHelper));
    }
}
