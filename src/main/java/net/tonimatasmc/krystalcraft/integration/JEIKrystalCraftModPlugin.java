package net.tonimatasmc.krystalcraft.integration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.tonimatasmc.krystalcraft.KrystalCraft;
import net.tonimatasmc.krystalcraft.recipe.GemCuttingStationRecipe;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("unused")
@JeiPlugin
public class JEIKrystalCraftModPlugin implements IModPlugin {
    @Override
    @Nonnull
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(KrystalCraft.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new
                GemCuttingStationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<GemCuttingStationRecipe> recipes = rm.getAllRecipesFor(GemCuttingStationRecipe.Type.INSTANCE);
        registration.addRecipes(new RecipeType<>(GemCuttingStationRecipeCategory.UID, GemCuttingStationRecipe.class), recipes);
    }
}