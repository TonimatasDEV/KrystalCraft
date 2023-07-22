package net.tonimatasdev.krystalcraft.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.recipe.CombiningStationRecipe;
import net.tonimatasdev.krystalcraft.recipe.CrushingStationRecipe;
import net.tonimatasdev.krystalcraft.recipe.CuttingStationRecipe;

import java.util.function.Supplier;

public class ModRecipeSerializers {
    public static final ResourcefulRegistry<RecipeSerializer<?>> RECIPE_SERIALIZERS = ResourcefulRegistries.create(BuiltInRegistries.RECIPE_SERIALIZER, KrystalCraft.MOD_ID);
    public static final RegistryEntry<RecipeSerializer<CuttingStationRecipe>> CUTTING_STATION_SERIALIZER = create("cutting_station", CuttingStationRecipe.Serializer::new);
    public static final RegistryEntry<RecipeSerializer<CrushingStationRecipe>> CRUSHING_STATION_SERIALIZER = create("crushing_station", CrushingStationRecipe.Serializer::new);
    public static final RegistryEntry<RecipeSerializer<CombiningStationRecipe>> COMBINING_STATION_SERIALIZER = create("combining_station", CombiningStationRecipe.Serializer::new);


    private static <T extends Recipe<?>> RegistryEntry<RecipeSerializer<T>> create(String name, Supplier<RecipeSerializer<T>> serializer) {
        return RECIPE_SERIALIZERS.register(name, serializer);
    }
}
