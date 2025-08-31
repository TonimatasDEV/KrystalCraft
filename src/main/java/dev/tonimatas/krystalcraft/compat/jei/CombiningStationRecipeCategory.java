package dev.tonimatas.krystalcraft.compat.jei;


import dev.tonimatas.krystalcraft.KrystalCraft;
import dev.tonimatas.krystalcraft.recipe.CombiningRecipe;
import dev.tonimatas.krystalcraft.registry.ModBlocks;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;


public class CombiningStationRecipeCategory implements IRecipeCategory<CombiningRecipe> {
    public final static Identifier TEXTURE = Identifier.of(KrystalCraft.MOD_ID, "textures/gui/combining_station.png");
    private final IDrawable background;
    private final IDrawable icon;

    public CombiningStationRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 91);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.COMBINING_STATION));
    }

    @Override
    public @NotNull RecipeType<CombiningRecipe> getRecipeType() {
        return JEIKrystalCraftPlugin.COMBINING;
    }

    @Override
    public @NotNull Text getTitle() {
        return Text.literal("Combining");
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
    public void setRecipe(IRecipeLayoutBuilder builder, CombiningRecipe recipe, IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 70, 15).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 88, 15).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 48).addIngredients(Ingredient.ofItems(Items.COAL));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 70).addItemStack(recipe.result());
    }
}
