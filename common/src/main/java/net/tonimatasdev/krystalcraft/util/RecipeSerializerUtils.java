package net.tonimatasdev.krystalcraft.util;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

public class RecipeSerializerUtils {

    public static void toNetwork(FriendlyByteBuf buf, Recipe<SimpleContainer> recipe, ItemStack output) {
        buf.writeInt(recipe.getIngredients().size());

        for (Ingredient ing : recipe.getIngredients()) {
            ing.toNetwork(buf);
        }

        buf.writeItemStack(output.copy(), false);
    }
}
