package net.tonimatasdev.krystalcraft.util;

import com.google.gson.JsonArray;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class GeneralUtil {
    public static NonNullList<Ingredient> deserializeIngredients(JsonArray json) {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        for (int i = 0; i < json.size(); i++) {
            Ingredient ingredient = Ingredient.fromJson(json.get(i));
            if (!ingredient.isEmpty()) {
                ingredients.add(ingredient);
            }
        }
        return ingredients;
    }

    public static boolean matchesRecipe(Container inventory, NonNullList<Ingredient> recipe, int startIndex, int endIndex) {
        final List<ItemStack> validStacks = new ArrayList<>();
        for (int i = startIndex; i <= endIndex; i++) {
            final ItemStack stackInSlot = inventory.getItem(i);
            if (!stackInSlot.isEmpty())
                validStacks.add(stackInSlot);
        }
        for (Ingredient entry : recipe) {
            boolean matches = false;
            for (ItemStack item : validStacks) {
                if (entry.test(item)) {
                    matches = true;
                    validStacks.remove(item);
                    break;
                }
            }
            if (!matches) {
                return false;
            }
        }
        return true;
    }

}
