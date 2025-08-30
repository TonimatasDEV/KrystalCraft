package dev.tonimatas.krystalcraft.registry;

import dev.tonimatas.krystalcraft.KrystalCraft;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModTabs {
    public static final ItemGroup KRYSTALCRAFT = Registry.register(Registries.ITEM_GROUP, Identifier.of(KrystalCraft.MOD_ID, "krystalcraft"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.JADE))
                    .displayName(Text.translatable("itemGroup.krystalcraft"))
                    .entries((displayContext, entries) -> {
                        Registries.ITEM.getKeys().forEach(key -> {
                            // Add one by one to keep it tidy
                            if (key.getValue().getNamespace().equalsIgnoreCase(KrystalCraft.MOD_ID)) {
                                entries.add(Registries.ITEM.get(key));
                            }
                        });
                    }).build());

    public static void initialize() {
        // Initialize the class
    }
}
