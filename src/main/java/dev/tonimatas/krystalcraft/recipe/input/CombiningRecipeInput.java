package dev.tonimatas.krystalcraft.recipe.input;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record CombiningRecipeInput(ItemStack input, ItemStack input2) implements RecipeInput {
    @Override
    public ItemStack getStackInSlot(int slot) {
        return switch (slot) {
            case 0 -> input;
            case 1 -> input2;
            default -> ItemStack.EMPTY;
        };
    }

    @Override
    public int getSize() {
        return 1;
    }
}
