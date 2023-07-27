package net.tonimatasdev.krystalcraft.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.recipe.CombiningRecipe;
import net.tonimatasdev.krystalcraft.recipe.CrushingRecipe;
import net.tonimatasdev.krystalcraft.recipe.CuttingRecipe;

import java.util.function.Supplier;

public class ModRecipes {
    public static final ResourcefulRegistry<RecipeType<?>> RECIPE_TYPES = ResourcefulRegistries.create(BuiltInRegistries.RECIPE_TYPE, KrystalCraft.MOD_ID);

    public static final RegistryEntry<RecipeType<CombiningRecipe>> COMBINING = create("combining");
    public static final RegistryEntry<RecipeType<CrushingRecipe>> CRUSHING = create("crushing_");
    public static final RegistryEntry<RecipeType<CuttingRecipe>> CUTTING = create("cutting");


    private static <T extends Recipe<?>> RegistryEntry<RecipeType<T>> create(String name) {
        Supplier<RecipeType<T>> type = () -> new RecipeType<>() {
            @Override
            public String toString() {
                return name;
            }
        };
        return RECIPE_TYPES.register(name, type);
    }
}
