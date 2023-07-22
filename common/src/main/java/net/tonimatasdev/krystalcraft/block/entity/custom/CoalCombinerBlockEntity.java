package net.tonimatasdev.krystalcraft.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.recipe.CoalCombinerRecipe;
import net.tonimatasdev.krystalcraft.registry.BlockEntityRegistry;
import net.tonimatasdev.krystalcraft.registry.RecipeTypeRegistry;
import net.tonimatasdev.krystalcraft.client.handler.CoalCombinerMenuHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class CoalCombinerBlockEntity extends KrystalCraftFuelBlockEntity implements BlockEntityTicker<CoalCombinerBlockEntity> {
    public CoalCombinerBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityRegistry.COAL_COMBINER_BLOCK_ENTITY.get(), blockPos, blockState, 4);
    }

    @Override
    public void tick(Level world, BlockPos pos, BlockState state, CoalCombinerBlockEntity blockEntity) {
        if (world.isClientSide) return;
        boolean dirty = false;
        final var recipeType = world.getRecipeManager()
                .getRecipeFor(RecipeTypeRegistry.COAL_COMBINER_TYPE.get(), blockEntity, world)
                .orElse(null);
        RegistryAccess access = level.registryAccess();
        if (canCraft(recipeType, access)) {
            this.progress++;
            if (this.progress >= this.maxProgress) {
                progress = 0;
                craft(recipeType, access);
                dirty = true;
            }
        } else {
            this.progress = 0;
        }
        if (dirty) {
            setChanged();
        }

    }

    private boolean canCraft(CoalCombinerRecipe recipe, RegistryAccess access) {
        if (recipe == null || recipe.getResultItem(access).isEmpty()) {
            return false;
        } else if (areInputsEmpty()) {
            return false;
        }
        ItemStack itemStack = this.getItem(3);
        return itemStack.isEmpty() || itemStack == recipe.getResultItem(access);
    }


    private boolean areInputsEmpty() {
        int emptyStacks = 0;
        for (int i = 1; i <= 2; i++) {
            if (this.getItem(i).isEmpty()) emptyStacks++;
        }
        return emptyStacks == 2;
    }

    private void craft(CoalCombinerRecipe recipe, RegistryAccess access) {
        if (!canCraft(recipe, access)) {
            return;
        }
        final ItemStack recipeOutput = recipe.getResultItem(access);
        final ItemStack outputSlotStack = this.getItem(3);
        if (outputSlotStack.isEmpty()) {
            ItemStack output = recipeOutput.copy();
            setItem(3, output);
        }
        for (Ingredient entry : recipe.getIngredients()) {
            if (entry.test(this.getItem(1))) {
                removeItem(1, 1);
            }
            if (entry.test(this.getItem(2))) {
                removeItem(2, 1);
            }
        }
    }


    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("block.krystalcraft.coal_combiner");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        return new CoalCombinerMenuHandler(syncId, inventory, this, data);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, this.inventory);
        tag.putInt("coal_combiner.progress", progress);
        tag.putInt("coal_combiner.fuel", fuel);
    }

    @Override
    public void load(@Nullable CompoundTag nbt) {
        super.load(Objects.requireNonNull(nbt));
        this.inventory = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(nbt, this.inventory);
        progress = nbt.getInt("coal_combiner.progress");
        progress = nbt.getInt("coal_combiner.fuel");
    }
}