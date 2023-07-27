package net.tonimatasdev.krystalcraft.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.recipe.CombiningRecipe;
import net.tonimatasdev.krystalcraft.recipe.CrushingRecipe;
import net.tonimatasdev.krystalcraft.recipe.CuttingRecipe;

import java.util.function.Supplier;

public class ModRecipeSerializers {
    public static final ResourcefulRegistry<RecipeSerializer<?>> RECIPE_SERIALIZERS = ResourcefulRegistries.create(BuiltInRegistries.RECIPE_SERIALIZER, KrystalCraft.MOD_ID);
    public static final RegistryEntry<RecipeSerializer<CuttingRecipe>> CUTTING_SERIALIZER = create("cutting", CuttingRecipe.Serializer::new);
    public static final RegistryEntry<RecipeSerializer<CrushingRecipe>> CRUSHING_SERIALIZER = create("crushing", CrushingRecipe.Serializer::new);
    public static final RegistryEntry<RecipeSerializer<CombiningRecipe>> COMBINING_SERIALIZER = create("combining", CombiningRecipe.Serializer::new);


    private static <T extends Recipe<?>> RegistryEntry<RecipeSerializer<T>> create(String name, Supplier<RecipeSerializer<T>> serializer) {
        return RECIPE_SERIALIZERS.register(name, serializer);
    }
}
