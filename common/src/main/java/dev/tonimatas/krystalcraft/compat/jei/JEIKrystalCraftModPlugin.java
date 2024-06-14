package dev.tonimatas.krystalcraft.compat.jei;

/*
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import dev.tonimatas.krystalcraft.KrystalCraft;
import dev.tonimatas.krystalcraft.recipe.CombiningRecipe;
import dev.tonimatas.krystalcraft.recipe.CrushingRecipe;
import dev.tonimatas.krystalcraft.recipe.CuttingRecipe;
import dev.tonimatas.krystalcraft.registry.ModRecipes;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

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
        ClientLevel level = Objects.requireNonNull(Minecraft.getInstance().level);

        registration.addRecipes(CUTTING, level.getRecipeManager().getAllRecipesFor(ModRecipes.CUTTING.get()).stream().map(RecipeHolder::value).toList());
        registration.addRecipes(CRUSHING, level.getRecipeManager().getAllRecipesFor(ModRecipes.CRUSHING.get()).stream().map(RecipeHolder::value).toList());
        registration.addRecipes(COMBINING, level.getRecipeManager().getAllRecipesFor(ModRecipes.COMBINING.get()).stream().map(RecipeHolder::value).toList());
    }
}
*/