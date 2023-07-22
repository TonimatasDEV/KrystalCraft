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
import net.tonimatasdev.krystalcraft.client.handler.CombiningStationMenuHandler;
import net.tonimatasdev.krystalcraft.recipe.CombiningStationRecipe;
import net.tonimatasdev.krystalcraft.registry.BlockEntityRegistry;
import net.tonimatasdev.krystalcraft.registry.RecipeTypeRegistry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class CombiningStationBlockEntity extends KrystalCraftFuelBlockEntity implements BlockEntityTicker<CombiningStationBlockEntity> {
    public CombiningStationBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityRegistry.COMBINING_STATION_BLOCK_ENTITY.get(), blockPos, blockState, 4);
    }

    @Override
    public void tick(Level world, BlockPos pos, BlockState state, CombiningStationBlockEntity blockEntity) {
        if (world.isClientSide) return;
        boolean dirty = false;
        final var recipeType = world.getRecipeManager()
                .getRecipeFor(RecipeTypeRegistry.COMBINING_STATION.get(), blockEntity, world)
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

    private boolean canCraft(CombiningStationRecipe recipe, RegistryAccess access) {
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

    private void craft(CombiningStationRecipe recipe, RegistryAccess access) {
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
        return Component.translatable("block.krystalcraft.combining_station");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        return new CombiningStationMenuHandler(syncId, inventory, this, data);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        ContainerHelper.saveAllItems(tag, this.inventory);
        tag.putInt("combining_station.progress", progress);
        tag.putInt("combining_station.fuel", fuel);
    }

    @Override
    public void load(@Nullable CompoundTag nbt) {
        super.load(Objects.requireNonNull(nbt));
        this.inventory = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(nbt, this.inventory);
        progress = nbt.getInt("combining_station.progress");
        progress = nbt.getInt("combining_station.fuel");
    }
}