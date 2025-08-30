package dev.tonimatas.krystalcraft.recipe;
/*
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

public record CuttingRecipe(Ingredient ingredient, ItemStack result) implements CodecRecipe<Container> {
    public static final Codec<CuttingRecipe> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                    Ingredient.CODEC.fieldOf("ingredient").forGetter(CuttingRecipe::ingredient),
                    ItemStackCodec.CODEC.fieldOf("result").forGetter(CuttingRecipe::result)
            ).apply(instance, CuttingRecipe::new));

    public static final ByteCodec<CuttingRecipe> NETWORK_CODEC = ObjectByteCodec.create(
            ExtraByteCodecs.INGREDIENT.fieldOf(CuttingRecipe::ingredient),
            ExtraByteCodecs.ITEM_STACK.fieldOf(CuttingRecipe::result),
            CuttingRecipe::new
    );

    @Override
    public boolean matches(Container container, Level level) {
        return ingredient.test(container.getItem(0));
    }

    @Override
    public CodecRecipeSerializer<? extends CodecRecipe<Container>> serializer() {
        return ModRecipeSerializers.CUTTING_SERIALIZER.get();
    }

    @Override
    public @NotNull RecipeType<?> getType() {
        return ModRecipes.CUTTING.get();
    }
}*/