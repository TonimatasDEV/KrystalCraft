package dev.tonimatas.krystalcraft.blockentity;

import dev.tonimatas.krystalcraft.blockentity.util.BurnBlockEntity;
import dev.tonimatas.krystalcraft.energy.Energy;
import dev.tonimatas.krystalcraft.menu.CombiningStationMenu;
import dev.tonimatas.krystalcraft.recipe.CombiningRecipe;
import dev.tonimatas.krystalcraft.registry.ModBlockEntities;
import dev.tonimatas.krystalcraft.registry.ModRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class CombiningStationBlockEntity extends BurnBlockEntity {
    protected final int INPUT1_SLOT = 0;
    protected final int INPUT2_SLOT = 1;
    protected final int RESULT_SLOT = 2;
    protected final int COMBUSTION_SLOT = 3;

    public CombiningStationBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.COMBINING_STATION_BLOCK_ENTITY.get(), blockPos, blockState);
    }



    @Override
    public @NotNull AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        return new CombiningStationMenu(syncId, inventory, this);
    }

    @Override
    public int getInventorySize() {
        return 4;
    }

    @Override
    public void tick() {
        if (level == null) return;
        if (level.isClientSide) return;

        if (hasRecipe(level)) {
            if (burnTime == 0) {
                burnTime = Energy.getBurnTime(getItem(COMBUSTION_SLOT));
                burnTimeTotal = burnTime;
                removeItem(COMBUSTION_SLOT, 1);
            }

            if (burnTime > 0) progress++;

            if (progress >= getMaxProgress()) {
                craft(level);
                progress = 0;
            }
        } else {
            progress = 0;
        }

        if (burnTime > 0) burnTime--;
    }

    private boolean hasRecipe(Level level) {
        Optional<RecipeHolder<CombiningRecipe>> match = level.getRecipeManager().getRecipeFor(ModRecipes.COMBINING.get(), this, level);
        if (match.isEmpty()) return false;

        ItemStack resultItem = match.get().value().result();
        return (resultItem.is(resultItem.getItem()) || resultItem.isEmpty()) && (resultItem.getCount() + getItem(RESULT_SLOT).getCount()) <= 64;
    }

    private void craft(Level level) {
        Optional<RecipeHolder<CombiningRecipe>> match = level.getRecipeManager().getRecipeFor(ModRecipes.COMBINING.get(), this, level);

        if (match.isPresent()) {
            removeItem(INPUT1_SLOT, 1);
            removeItem(INPUT2_SLOT, 1);
            ItemStack result = match.get().value().result();
            setItem(RESULT_SLOT, new ItemStack(result.getItem(), getItem(RESULT_SLOT).getCount() + result.getCount()));
        }
    }
}