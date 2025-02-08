package dev.tonimatas.krystalcraft.neoforge.datagen;

import dev.tonimatas.krystalcraft.KrystalCraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = KrystalCraft.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class KrystalCraftDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // Server TODO
        //generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput, lookupProvider));
        //generator.addProvider(event.includeServer(), new ModLootTableProvider(packOutput, lookupProvider));

        // Client TODO
        //generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        //generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
    }
}
