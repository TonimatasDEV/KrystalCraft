package net.tonimatasmc.krystalcraft.integration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.tonimatasmc.krystalcraft.KrystalCraft;
import net.tonimatasmc.krystalcraft.block.ModBlocks;
import net.tonimatasmc.krystalcraft.item.ModItems;
import net.tonimatasmc.krystalcraft.recipe.CoalCrusherRecipe;

import javax.annotation.Nonnull;

@SuppressWarnings("removal")
public class CoalCrusherRecipeCategory implements IRecipeCategory<CoalCrusherRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(KrystalCraft.MOD_ID, "coal_crusher");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(KrystalCraft.MOD_ID, "textures/gui/coal_crusher_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public CoalCrusherRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 82);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM, new ItemStack(ModBlocks.COAL_CRUSHER.get()));
    }

    @Override
    @Nonnull
    public ResourceLocation getUid() {
        return UID;
    }

    @Override
    @Nonnull
    public Class<? extends CoalCrusherRecipe> getRecipeClass() {
        return CoalCrusherRecipe.class;
    }

    @Override
    @Nonnull
    public Component getTitle() {
        return new TextComponent("Coal Crusher");
    }

    @Override
    @Nonnull
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    @Nonnull
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(@Nonnull IRecipeLayoutBuilder builder, @Nonnull CoalCrusherRecipe recipe, @Nonnull IFocusGroup focusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 25, 21).addIngredients(Ingredient.of(ModItems.SET_WATER_BOTTLES.get()));
        builder.addSlot(RecipeIngredientRole.INPUT, 79, 21).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 54, 51).addIngredients(Ingredient.of());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 133, 21).addItemStack(recipe.getResultItem());
    }
}