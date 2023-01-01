package net.tonimatasdev.krystalcraft.integration.jei;

//import mezz.jei.api.IModPlugin;
//import mezz.jei.api.JeiPlugin;
//import mezz.jei.api.recipe.RecipeType;
//import mezz.jei.api.registration.IRecipeCategoryRegistration;
//import mezz.jei.api.registration.IRecipeRegistration;
//import net.minecraft.client.Minecraft;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.crafting.RecipeManager;
//import net.tonimatasdev.krystalcraft.KrystalCraft;
//import net.tonimatasdev.krystalcraft.recipe.CoalCombinerRecipe;
//import net.tonimatasdev.krystalcraft.recipe.CoalCrusherRecipe;
//import net.tonimatasdev.krystalcraft.recipe.GemCuttingStationRecipe;
//import org.jetbrains.annotations.NotNull;
//
//import java.util.List;
//import java.util.Objects;
//
//@JeiPlugin
//public class JEIKrystalCraftModPlugin implements IModPlugin {
//    public static RecipeType<GemCuttingStationRecipe> GEM_CUTTING = new RecipeType<>(GemCuttingStationRecipeCategory.UID, GemCuttingStationRecipe.class);
//    public static RecipeType<CoalCrusherRecipe> COAL_CRUSHER = new RecipeType<>(CoalCrusherRecipeCategory.UID, CoalCrusherRecipe.class);
//    public static RecipeType<CoalCombinerRecipe> COAL_COMBINER = new RecipeType<>(CoalCombinerRecipeCategory.UID, CoalCombinerRecipe.class);
//
//    @Override
//    public @NotNull ResourceLocation getPluginUid() {
//        return new ResourceLocation(KrystalCraft.MOD_ID, "jei_plugin");
//    }
//
//    @Override
//    public void registerCategories(IRecipeCategoryRegistration registration) {
//        registration.addRecipeCategories(new GemCuttingStationRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
//        registration.addRecipeCategories(new CoalCrusherRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
//        registration.addRecipeCategories(new CoalCombinerRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
//    }
//
//    @Override
//    public void registerRecipes(IRecipeRegistration registration) {
//        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
//
//        List<GemCuttingStationRecipe> recipesInfusing = rm.getAllRecipesFor(GemCuttingStationRecipe.Type.INSTANCE);
//        registration.addRecipes(GEM_CUTTING, recipesInfusing);
//
//        List<CoalCrusherRecipe> recipeCrushing = rm.getAllRecipesFor(CoalCrusherRecipe.Type.INSTANCE);
//        registration.addRecipes(COAL_CRUSHER, recipeCrushing);
//
//        List<CoalCombinerRecipe> recipeCombining = rm.getAllRecipesFor(CoalCombinerRecipe.Type.INSTANCE);
//        registration.addRecipes(COAL_COMBINER, recipeCombining);
//    }
//}