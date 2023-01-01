package net.tonimatasdev.krystalcraft.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.tonimatasdev.krystalcraft.datagen.loot.ModBlockLootTables;

import java.util.List;

public class ModLootTableProvider {
    public static LootTableProvider create(DataGenerator generator) {
        return new LootTableProvider(generator.getPackOutput(), BuiltInLootTables.all(), List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)));
    }
}
