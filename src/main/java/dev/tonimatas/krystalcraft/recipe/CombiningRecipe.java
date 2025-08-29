package dev.tonimatas.krystalcraft.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamresourceful.bytecodecs.base.ByteCodec;
import com.teamresourceful.bytecodecs.base.object.ObjectByteCodec;
import com.teamresourceful.resourcefullib.common.bytecodecs.ExtraByteCodecs;
import com.teamresourceful.resourcefullib.common.codecs.recipes.ItemStackCodec;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipe;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipeSerializer;
import dev.tonimatas.krystalcraft.registry.ModRecipeSerializers;
import dev.tonimatas.krystalcraft.registry.ModRecipes;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public record CombiningRecipe(List<Ingredient> ingredients, ItemStack result) implements CodecRecipe<Container> {
    public static final Codec<CombiningRecipe> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                    Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter(CombiningRecipe::ingredients),
                    ItemStackCodec.CODEC.fieldOf("result").forGetter(CombiningRecipe::result)
            ).apply(instance, CombiningRecipe::new));

    public static final ByteCodec<CombiningRecipe> NETWORK_CODEC = ObjectByteCodec.create(
            ExtraByteCodecs.INGREDIENT.listOf().fieldOf(CombiningRecipe::ingredients),
            ExtraByteCodecs.ITEM_STACK.fieldOf(CombiningRecipe::result),
            CombiningRecipe::new
    );

    @Override
    public boolean matches(Container container, Level level) {
        boolean firstIngredient = ingredients.get(0).test(container.getItem(0)) || ingredients.get(1).test(container.getItem(0));
        boolean secondIngredient = ingredients.get(0).test(container.getItem(1)) || ingredients.get(1).test(container.getItem(1));
        return firstIngredient && secondIngredient;
    }

    @Override
    public CodecRecipeSerializer<? extends CodecRecipe<Container>> serializer() {
        return ModRecipeSerializers.COMBINING_SERIALIZER.get();
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return ModRecipes.COMBINING.get();
    }
}