package net.tonimatasdev.krystalcraft.compat.jei;


import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.recipe.CombiningRecipe;
import net.tonimatasdev.krystalcraft.recipe.CrushingRecipe;
import net.tonimatasdev.krystalcraft.recipe.CuttingRecipe;
import net.tonimatasdev.krystalcraft.registry.ModRecipes;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.stream.Collectors;

@JeiPlugin
public class JEIKrystalCraftModPlugin implements IModPlugin {
    public static RecipeType<CuttingRecipe> CUTTING = RecipeType.create(KrystalCraft.MOD_ID,"cutting", CuttingRecipe.class);
    public static RecipeType<CrushingRecipe> CRUSHING = RecipeType.create(KrystalCraft.MOD_ID, "crushing", CrushingRecipe.class);
    public static RecipeType<CombiningRecipe> COMBINING = RecipeType.create(KrystalCraft.MOD_ID, "combining", CombiningRecipe.class);

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(KrystalCraft.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CuttingStationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new CrushingStationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new CombiningStationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager manager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        registration.addRecipes(CUTTING, manager.getAllRecipesFor(ModRecipes.CUTTING.get()).stream().map(RecipeHolder::value).collect(Collectors.toList()));
        registration.addRecipes(CRUSHING, manager.getAllRecipesFor(ModRecipes.CRUSHING.get()).stream().map(RecipeHolder::value).collect(Collectors.toList()));
        registration.addRecipes(COMBINING, manager.getAllRecipesFor(ModRecipes.COMBINING.get()).stream().map(RecipeHolder::value).collect(Collectors.toList()));
    }
}
