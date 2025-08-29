package dev.tonimatas.krystalcraft.registry;

import com.teamresourceful.resourcefullib.common.recipe.CodecRecipeSerializer;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import dev.tonimatas.krystalcraft.recipe.CombiningRecipe;
import dev.tonimatas.krystalcraft.recipe.CrushingRecipe;
import dev.tonimatas.krystalcraft.recipe.CuttingRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ModRecipeSerializers {
    public static final ResourcefulRegistry<RecipeSerializer<?>> RECIPE_SERIALIZERS = ResourcefulRegistries.create(BuiltInRegistries.RECIPE_SERIALIZER, KrystalCraft.MOD_ID);

    public static final RegistryEntry<CodecRecipeSerializer<CuttingRecipe>> CUTTING_SERIALIZER = RECIPE_SERIALIZERS.register("cutting", () ->
            new CodecRecipeSerializer<>(ModRecipes.CUTTING.get(), CuttingRecipe.CODEC, CuttingRecipe.NETWORK_CODEC));
    public static final RegistryEntry<CodecRecipeSerializer<CrushingRecipe>> CRUSHING_SERIALIZER = RECIPE_SERIALIZERS.register("crushing", () ->
            new CodecRecipeSerializer<>(ModRecipes.CRUSHING.get(), CrushingRecipe.CODEC, CrushingRecipe.NETWORK_CODEC));
    public static final RegistryEntry<CodecRecipeSerializer<CombiningRecipe>> COMBINING_SERIALIZER = RECIPE_SERIALIZERS.register("combining", () ->
            new CodecRecipeSerializer<>(ModRecipes.COMBINING.get(), CombiningRecipe.CODEC, CombiningRecipe.NETWORK_CODEC));
}
