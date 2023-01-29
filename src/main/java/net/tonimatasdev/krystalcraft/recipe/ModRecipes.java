package net.tonimatasdev.krystalcraft.recipe;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.tonimatasdev.krystalcraft.KrystalCraft;

@SuppressWarnings("unused")
public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, KrystalCraft.MOD_ID);

    public static final RegistryObject<RecipeSerializer<GemCuttingStationRecipe>> GEM_CUTTING_SERIALIZER = SERIALIZERS.register("gem_cutting", () -> GemCuttingStationRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<CoalCrusherRecipe>> COAL_CRUSHER_SERIALIZER = SERIALIZERS.register("coal_crusher", () -> CoalCrusherRecipe.Serializer.INSTANCE);
    public static final RegistryObject<RecipeSerializer<CoalCombinerRecipe>> COAL_COMBINER_SERIALIZER = SERIALIZERS.register("coal_combiner", () -> CoalCombinerRecipe.Serializer.INSTANCE);
}
