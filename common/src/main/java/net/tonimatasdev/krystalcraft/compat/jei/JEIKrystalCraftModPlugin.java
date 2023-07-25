package net.tonimatasdev.krystalcraft.compat.jei;

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
import net.tonimatasdev.krystalcraft.recipe.CombiningStationRecipe;
import net.tonimatasdev.krystalcraft.recipe.CrushingStationRecipe;
import net.tonimatasdev.krystalcraft.recipe.CuttingStationRecipe;
import net.tonimatasdev.krystalcraft.registry.ModRecipes;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@JeiPlugin
public class JEIKrystalCraftModPlugin implements IModPlugin {
    public static RecipeType<CuttingStationRecipe> CUTTING_STATION = RecipeType.create(KrystalCraft.MOD_ID,"cutting_station", CuttingStationRecipe.class);
    public static RecipeType<CrushingStationRecipe> CRUSHING_STATION = RecipeType.create(KrystalCraft.MOD_ID, "crushing_station", CrushingStationRecipe.class);
    public static RecipeType<CombiningStationRecipe> COMBINING_STATION = RecipeType.create(KrystalCraft.MOD_ID, "combining_station", CombiningStationRecipe.class);

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

        registration.addRecipes(CUTTING_STATION, manager.getAllRecipesFor(ModRecipes.CUTTING_STATION.get()));
        registration.addRecipes(CRUSHING_STATION, manager.getAllRecipesFor(ModRecipes.CRUSHING_STATION.get()));
        registration.addRecipes(COMBINING_STATION, manager.getAllRecipesFor(ModRecipes.COMBINING_STATION.get()));
    }
}
*/