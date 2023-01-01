package net.tonimatasdev.krystalcraft.datagen;

import net.minecraft.Util;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.world.feature.ModFeatures;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = KrystalCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> completablefuture = CompletableFuture.supplyAsync(VanillaRegistries::createLookup, Util.backgroundExecutor());
        ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(generator, completablefuture, existingFileHelper);

        generator.addProvider(true, new ModRecipeProvider(generator));
        //generator.addProvider(true, ModLootTableProvider.create(generator));
        generator.addProvider(true, new ModItemModelProvider(generator, existingFileHelper));
        generator.addProvider(true, new ModBlocksStateProvider(generator, existingFileHelper));
        generator.addProvider(true, blockTagsProvider);
        generator.addProvider(true, new ModItemTagsProvider(generator, completablefuture, blockTagsProvider, existingFileHelper));
        generator.addProvider(true, new DatapackBuiltinEntriesProvider(generator.getPackOutput(), ModFeatures.BUILDER));
    }
}
