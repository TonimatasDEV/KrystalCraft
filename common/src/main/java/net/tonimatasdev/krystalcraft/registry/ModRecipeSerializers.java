package net.tonimatasdev.krystalcraft.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.recipe.CombiningRecipe;
import net.tonimatasdev.krystalcraft.recipe.CrushingRecipe;
import net.tonimatasdev.krystalcraft.recipe.CuttingRecipe;

import java.util.function.Supplier;

public class ModRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(KrystalCraft.MOD_ID, Registries.RECIPE_SERIALIZER);

    public static final RegistrySupplier<RecipeSerializer<CuttingRecipe>> CUTTING_SERIALIZER = create("cutting", CuttingRecipe.Serializer::new);
    public static final RegistrySupplier<RecipeSerializer<CrushingRecipe>> CRUSHING_SERIALIZER = create("crushing", CrushingRecipe.Serializer::new);
    public static final RegistrySupplier<RecipeSerializer<CombiningRecipe>> COMBINING_SERIALIZER = create("combining", CombiningRecipe.Serializer::new);

    private static <T extends Recipe<?>> RegistrySupplier<RecipeSerializer<T>> create(String name, Supplier<RecipeSerializer<T>> serializer) {
        return RECIPE_SERIALIZERS.register(name, serializer);
    }
}
