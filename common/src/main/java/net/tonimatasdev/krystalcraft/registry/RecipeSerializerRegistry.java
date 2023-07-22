package net.tonimatasdev.krystalcraft.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.recipe.CombiningStationRecipe;
import net.tonimatasdev.krystalcraft.recipe.CrushingStationRecipe;
import net.tonimatasdev.krystalcraft.recipe.CuttingStationRecipe;

import java.util.function.Supplier;

public class RecipeSerializerRegistry {
    private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(KrystalCraft.MOD_ID, Registries.RECIPE_SERIALIZER);
    public static final RegistrySupplier<RecipeSerializer<CuttingStationRecipe>> CUTTING_STATION_SERIALIZER = create("cutting_station", CuttingStationRecipe.Serializer::new);
    public static final RegistrySupplier<RecipeSerializer<CrushingStationRecipe>> CRUSHING_STATION_SERIALIZER = create("crushing_station", CrushingStationRecipe.Serializer::new);
    public static final RegistrySupplier<RecipeSerializer<CombiningStationRecipe>> COMBINING_STATION_SERIALIZER = create("combining_station", CombiningStationRecipe.Serializer::new);


    private static <T extends Recipe<?>> RegistrySupplier<RecipeSerializer<T>> create(String name, Supplier<RecipeSerializer<T>> serializer) {
        return RECIPE_SERIALIZERS.register(name, serializer);
    }

    public static void init() {
        RECIPE_SERIALIZERS.register();
    }
}
