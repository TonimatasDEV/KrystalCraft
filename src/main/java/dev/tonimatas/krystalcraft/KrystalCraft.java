package dev.tonimatas.krystalcraft;

import com.mojang.logging.LogUtils;
import dev.tonimatas.krystalcraft.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;

public class KrystalCraft implements ModInitializer {
    public static final String MOD_ID = "krystalcraft";
    
    @Override
    public void onInitialize() {
        ModBlocks.BLOCKS.init();
        ModItems.initialize();
        ModBlockEntities.BLOCK_ENTITIES.init();
        ModMenus.MENUS.init();
        ModRecipeSerializers.RECIPE_SERIALIZERS.init();
        ModRecipes.RECIPE_TYPES.init();
        ModEnchants.ENCHANTMENTS.init();
        ModTabs.initialize();

        addOre("experience_ore");
        addOre("jade_ore");
        addOre("lead_ore");
        addOre("platinum_ore");
        addOre("ruby_ore");
        addOre("sapphire_ore");
        addOre("silver_ore");
        addOre("tin_ore");
        addOre("topaz_ore");

        LogUtils.getLogger().info("KystalCraft started successfully.");
    }

    private void addOre(String name) {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, name)));
    }
}