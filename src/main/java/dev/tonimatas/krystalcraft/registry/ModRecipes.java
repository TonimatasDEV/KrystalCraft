package dev.tonimatas.krystalcraft.registry;

import dev.tonimatas.krystalcraft.KrystalCraft;
import dev.tonimatas.krystalcraft.recipe.CombiningRecipe;
import dev.tonimatas.krystalcraft.recipe.CrushingRecipe;
import dev.tonimatas.krystalcraft.recipe.CuttingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static final RecipeSerializer<CombiningRecipe> COMBINING_RECIPE_SERIALIZER = registerSerializer("combining", new CombiningRecipe.Serializer());
    public static final RecipeType<CombiningRecipe> COMBINING_RECIPE_TYPE = registerType("combining", new RecipeType<>() {
        @Override
        public String toString() {
            return "combining";
        }
    });
    public static final RecipeSerializer<CrushingRecipe> CRUSHING_RECIPE_SERIALIZER = registerSerializer("crushing", new CrushingRecipe.Serializer());
    public static final RecipeType<CrushingRecipe> CRUSHING_RECIPE_TYPE = registerType("crushing", new RecipeType<>() {
        @Override
        public String toString() {
            return "crushing";
        }
    });
    public static final RecipeSerializer<CuttingRecipe> CUTTING_RECIPE_SERIALIZER = registerSerializer("cutting", new CuttingRecipe.Serializer());
    public static final RecipeType<CuttingRecipe> CUTTING_RECIPE_TYPE = registerType("cutting", new RecipeType<>() {
        @Override
        public String toString() {
            return "cutting";
        }
    });
    
    public static <T extends Recipe<?>> RecipeSerializer<T> registerSerializer(String name, RecipeSerializer<T> recipeSerializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(KrystalCraft.MOD_ID, name), recipeSerializer);
    }

    public static <T extends Recipe<?>> RecipeType<T> registerType(String name, RecipeType<T> recipeType) {
        return Registry.register(Registries.RECIPE_TYPE, Identifier.of(KrystalCraft.MOD_ID, name), recipeType);
    }

    public static void initialize() {
        // Initialize the class
    }
}
