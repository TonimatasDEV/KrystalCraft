package net.tonimatasdev.krystalcraft.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.recipe.CombiningStationRecipe;
import net.tonimatasdev.krystalcraft.recipe.CrushingStationRecipe;
import net.tonimatasdev.krystalcraft.recipe.CuttingStationRecipe;

import java.util.function.Supplier;

public class RecipeTypeRegistry {
    private static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(KrystalCraft.MOD_ID, Registries.RECIPE_TYPE);

    public static final RegistrySupplier<RecipeType<CombiningStationRecipe>> COMBINING_STATION = create("combining_station");
    public static final RegistrySupplier<RecipeType<CrushingStationRecipe>> CRUSHING_STATION = create("crushing_station");
    public static final RegistrySupplier<RecipeType<CuttingStationRecipe>> CUTTING_STATION = create("cutting_station");


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
