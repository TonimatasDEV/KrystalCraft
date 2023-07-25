package net.tonimatasdev.krystalcraft.compat.jei;

/*
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.recipe.CombiningStationRecipe;
import net.tonimatasdev.krystalcraft.registry.ModBlocks;
import org.jetbrains.annotations.NotNull;


public class CombiningStationRecipeCategory implements IRecipeCategory<CombiningStationRecipe> {
    public final static ResourceLocation TEXTURE = new ResourceLocation(KrystalCraft.MOD_ID, "textures/gui/coal_combiner_gui.png");
    private final IDrawable background;
    private final IDrawable icon;

    public CombiningStationRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 91);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.COMBINING_STATION.get()));
    }

    @Override
    public @NotNull RecipeType<CombiningStationRecipe> getRecipeType() {
        return JEIKrystalCraftModPlugin.COMBINING_STATION;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.literal("Coal Combiner");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CombiningStationRecipe recipe, IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 70, 15).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 88, 15).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 48).addIngredients(Ingredient.of(Items.COAL));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 70).addItemStack(recipe.getOutput());
    }
}
*/