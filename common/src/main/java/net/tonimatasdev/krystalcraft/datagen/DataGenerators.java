package net.tonimatasdev.krystalcraft.datagen;

import net.minecraft.Util;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tonimatasdev.krystalcraft.KrystalCraft;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = KrystalCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> completablefuture = CompletableFuture.supplyAsync(VanillaRegistries::createLookup, Util.backgroundExecutor());

        generator.addProvider(true, new ModRecipeProvider(packOutput));
        generator.addProvider(true, ModLootTableProvider.create(packOutput));
        generator.addProvider(true, new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(true, new ModBlocksStateProvider(packOutput, existingFileHelper));
        ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(packOutput, completablefuture, existingFileHelper);
        generator.addProvider(true, blockTagsProvider);
        generator.addProvider(true, new ModItemTagsProvider(packOutput, completablefuture, blockTagsProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new ModWorldGenProvider(packOutput, completablefuture));
    }
}
