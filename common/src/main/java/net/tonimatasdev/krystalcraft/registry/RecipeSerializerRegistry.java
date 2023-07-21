package net.tonimatasdev.krystalcraft.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.recipe.CoalCombinerRecipe;
import net.tonimatasdev.krystalcraft.recipe.CoalCrusherRecipe;
import net.tonimatasdev.krystalcraft.recipe.GemCuttingStationRecipe;

import java.util.function.Supplier;

public class RecipeSerializerRegistry {
    private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(KrystalCraft.MOD_ID, Registries.RECIPE_SERIALIZER);
    public static final RegistrySupplier<RecipeSerializer<GemCuttingStationRecipe>> GEM_CUTTING_SERIALIZER = create("gem_cutting", GemCuttingStationRecipe.Serializer::new);
    public static final RegistrySupplier<RecipeSerializer<CoalCrusherRecipe>> COAL_CRUSHER_SERIALIZER = create("coal_crusher", CoalCrusherRecipe.Serializer::new);
    public static final RegistrySupplier<RecipeSerializer<CoalCombinerRecipe>> COAL_COMBINER_SERIALIZER = create("coal_combiner", CoalCombinerRecipe.Serializer::new);


    private static <T extends Recipe<?>> RegistrySupplier<RecipeSerializer<T>> create(String name, Supplier<RecipeSerializer<T>> serializer) {
        return RECIPE_SERIALIZERS.register(name, serializer);
    }

    public static void init() {
        RECIPE_SERIALIZERS.register();
    }
}
