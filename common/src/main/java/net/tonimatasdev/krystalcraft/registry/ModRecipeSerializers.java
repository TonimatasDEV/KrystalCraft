package net.tonimatasdev.krystalcraft.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.plorix.registry.PlorixRegistries;
import net.tonimatasdev.krystalcraft.plorix.registry.PlorixRegistry;
import net.tonimatasdev.krystalcraft.plorix.registry.RegistryEntry;
import net.tonimatasdev.krystalcraft.recipe.CombiningRecipe;
import net.tonimatasdev.krystalcraft.recipe.CrushingRecipe;
import net.tonimatasdev.krystalcraft.recipe.CuttingRecipe;

import java.util.function.Supplier;

public class ModRecipeSerializers {
    public static final PlorixRegistry<RecipeSerializer<?>> RECIPE_SERIALIZERS = PlorixRegistries.create(BuiltInRegistries.RECIPE_SERIALIZER, KrystalCraft.MOD_ID);

    public static final RegistryEntry<RecipeSerializer<CuttingRecipe>> CUTTING_SERIALIZER = create("cutting", CuttingRecipe.Serializer::new);
    public static final RegistryEntry<RecipeSerializer<CrushingRecipe>> CRUSHING_SERIALIZER = create("crushing", CrushingRecipe.Serializer::new);
    public static final RegistryEntry<RecipeSerializer<CombiningRecipe>> COMBINING_SERIALIZER = create("combining", CombiningRecipe.Serializer::new);

    private static <T extends Recipe<?>> RegistryEntry<RecipeSerializer<T>> create(String name, Supplier<RecipeSerializer<T>> serializer) {
        return RECIPE_SERIALIZERS.register(name, serializer);
    }
}
