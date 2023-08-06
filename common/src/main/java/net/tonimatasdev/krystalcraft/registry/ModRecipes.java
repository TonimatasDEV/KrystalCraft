package net.tonimatasdev.krystalcraft.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.recipe.CombiningRecipe;
import net.tonimatasdev.krystalcraft.recipe.CrushingRecipe;
import net.tonimatasdev.krystalcraft.recipe.CuttingRecipe;

import java.util.function.Supplier;

public class ModRecipes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(KrystalCraft.MOD_ID, Registries.RECIPE_TYPE);

    public static final RegistrySupplier<RecipeType<CombiningRecipe>> COMBINING = create("combining");
    public static final RegistrySupplier<RecipeType<CrushingRecipe>> CRUSHING = create("crushing");
    public static final RegistrySupplier<RecipeType<CuttingRecipe>> CUTTING = create("cutting");

    private static <T extends Recipe<?>> RegistrySupplier<RecipeType<T>> create(String name) {
        Supplier<RecipeType<T>> type = () -> new RecipeType<>() {
            @Override
            public String toString() {
                return name;
            }
        };
        return RECIPE_TYPES.register(name, type);
    }
}
