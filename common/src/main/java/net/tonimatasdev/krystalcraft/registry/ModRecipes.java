package net.tonimatasdev.krystalcraft.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.plorix.registry.PlorixRegistries;
import net.tonimatasdev.krystalcraft.plorix.registry.PlorixRegistry;
import net.tonimatasdev.krystalcraft.plorix.registry.RegistryEntry;
import net.tonimatasdev.krystalcraft.recipe.CombiningRecipe;
import net.tonimatasdev.krystalcraft.recipe.CrushingRecipe;
import net.tonimatasdev.krystalcraft.recipe.CuttingRecipe;

import java.util.function.Supplier;

public class ModRecipes {
    public static final PlorixRegistry<RecipeType<?>> RECIPE_TYPES = PlorixRegistries.create(BuiltInRegistries.RECIPE_TYPE, KrystalCraft.MOD_ID);

    public static final RegistryEntry<RecipeType<CombiningRecipe>> COMBINING = create("combining");
    public static final RegistryEntry<RecipeType<CrushingRecipe>> CRUSHING = create("crushing");
    public static final RegistryEntry<RecipeType<CuttingRecipe>> CUTTING = create("cutting");

    private static <T extends Recipe<?>> RegistryEntry<RecipeType<T>> create(String name) {
        Supplier<RecipeType<T>> type = () -> new RecipeType<>() {
            @Override
            public String toString() {
                return name;
            }
        };
        return RECIPE_TYPES.register(name, type);
    }
}
