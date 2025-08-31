package dev.tonimatas.krystalcraft.compat.jei;


import dev.tonimatas.krystalcraft.KrystalCraft;
import dev.tonimatas.krystalcraft.recipe.CombiningRecipe;
import dev.tonimatas.krystalcraft.recipe.CrushingRecipe;
import dev.tonimatas.krystalcraft.recipe.CuttingRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class JEIKrystalCraftPlugin implements IModPlugin {
    public static RecipeType<CuttingRecipe> CUTTING = RecipeType.create(KrystalCraft.MOD_ID,"cutting", CuttingRecipe.class);
    public static RecipeType<CrushingRecipe> CRUSHING = RecipeType.create(KrystalCraft.MOD_ID, "crushing", CrushingRecipe.class);
    public static RecipeType<CombiningRecipe> COMBINING = RecipeType.create(KrystalCraft.MOD_ID, "combining", CombiningRecipe.class);


    @Override
    public @NotNull Identifier getPluginUid() {
        return Identifier.of(KrystalCraft.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CuttingStationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new CrushingStationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new CombiningStationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        //ClientWorld world = Objects.requireNonNull(MinecraftClient.getInstance().world);
        //RecipeManager recipeManager = world.getRecipeManager();
//
        //registration.addRecipes(CUTTING, recipeManager.listAllOfType(ModRecipes.CUTTING_RECIPE_TYPE).stream().map(RecipeEntry::value).toList());
        //registration.addRecipes(CRUSHING, recipeManager.listAllOfType(ModRecipes.CRUSHING_RECIPE_TYPE).stream().map(RecipeEntry::value).toList());
        //registration.addRecipes(COMBINING, recipeManager.listAllOfType(ModRecipes.COMBINING_RECIPE_TYPE).stream().map(RecipeEntry::value).toList());
    }
}
