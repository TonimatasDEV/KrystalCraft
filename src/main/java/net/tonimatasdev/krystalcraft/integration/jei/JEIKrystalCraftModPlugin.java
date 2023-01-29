package net.tonimatasdev.krystalcraft.integration.jei;

/*
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.recipe.CoalCombinerRecipe;
import net.tonimatasdev.krystalcraft.recipe.CoalCrusherRecipe;
import net.tonimatasdev.krystalcraft.recipe.GemCuttingStationRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@JeiPlugin
public class JEIKrystalCraftModPlugin implements IModPlugin {
    public static RecipeType<GemCuttingStationRecipe> GEM_CUTTING = RecipeType.create(KrystalCraft.MOD_ID,"gem_cutting", GemCuttingStationRecipe.class);
    public static RecipeType<CoalCrusherRecipe> COAL_CRUSHER = RecipeType.create(KrystalCraft.MOD_ID, "coal_crusher", CoalCrusherRecipe.class);
    public static RecipeType<CoalCombinerRecipe> COAL_COMBINER = RecipeType.create(KrystalCraft.MOD_ID, "coal_combiner", CoalCombinerRecipe.class);

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return new ResourceLocation(KrystalCraft.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new GemCuttingStationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new CoalCrusherRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new CoalCombinerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager manager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();

        registration.addRecipes(GEM_CUTTING, manager.getAllRecipesFor(GemCuttingStationRecipe.Type.INSTANCE));
        registration.addRecipes(COAL_CRUSHER, manager.getAllRecipesFor(CoalCrusherRecipe.Type.INSTANCE));
        registration.addRecipes(COAL_COMBINER, manager.getAllRecipesFor(CoalCombinerRecipe.Type.INSTANCE));
    }
}*/