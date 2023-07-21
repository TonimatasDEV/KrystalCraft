package net.tonimatasdev.krystalcraft.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.recipe.CoalCombinerRecipe;
import net.tonimatasdev.krystalcraft.recipe.CoalCrusherRecipe;
import net.tonimatasdev.krystalcraft.recipe.GemCuttingRecipe;

import java.util.function.Supplier;

public class RecipeTypeRegistry {
    private static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(KrystalCraft.MOD_ID, Registries.RECIPE_TYPE);

    public static final RegistrySupplier<RecipeType<CoalCombinerRecipe>> COAL_COMBINER_TYPE = create("coal_combiner");
    public static final RegistrySupplier<RecipeType<CoalCrusherRecipe>> COAL_CRUSHER_TYPE = create("coal_crusher");
    public static final RegistrySupplier<RecipeType<GemCuttingRecipe>> GEM_CUTTING_TYPE = create("gem_cutting_station");


    private static <T extends Recipe<?>> RegistrySupplier<RecipeType<T>> create(String name) {
        Supplier<RecipeType<T>> type = () -> new RecipeType<>() {
            @Override
            public String toString() {
                return name;
            }
        };
        return RECIPE_TYPES.register(name, type);
    }

    public static void init() {
        RECIPE_TYPES.register();
    }
}
