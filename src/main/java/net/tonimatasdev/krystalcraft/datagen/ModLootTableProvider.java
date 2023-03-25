package net.tonimatasdev.krystalcraft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModLootTableProvider extends LootTableProvider {

    public ModLootTableProvider(PackOutput packOutput, Set<ResourceLocation> resourceLocations, List<SubProviderEntry> subProviderEntries) {
        super(packOutput, resourceLocations, subProviderEntries);
    }

    @Override
    public @NotNull List<SubProviderEntry> getTables() {
        return super.getTables();
    }

    @Override
    protected void validate(@NotNull Map<ResourceLocation, LootTable> map, @NotNull ValidationContext validationcontext) {
        super.validate(map, validationcontext);
    }
}
