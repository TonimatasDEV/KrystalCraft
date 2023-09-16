package net.tonimatasdev.krystalcraft.blockentity;

import earth.terrarium.botarium.util.CommonHooks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.blockentity.util.BurnProcessingBlockEntity;
import net.tonimatasdev.krystalcraft.menu.CrushingStationMenu;
import net.tonimatasdev.krystalcraft.recipe.CrushingRecipe;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;
import net.tonimatasdev.krystalcraft.registry.ModRecipes;

import java.util.Optional;

public class CrushingStationBlockEntity extends BurnProcessingBlockEntity {
    protected final int INPUT_SLOT = 0;
    protected final int RESULT_SLOT = 1;
    protected final int COMBUSTION_SLOT = 2;


    public CrushingStationBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CRUSHING_STATION_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        return new CrushingStationMenu(syncId, inventory, this);
    }

    @Override
    public int getInventorySize() {
        return 3;
    }

    @Override
    public void tick() {
        if (level == null) return;
        if (level.isClientSide) return;

        if (hasRecipe(level)) {
            if (burnTime <= 0) {
                burnTime = CommonHooks.getBurnTime(getItem(COMBUSTION_SLOT));
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
        Optional<CrushingRecipe> match = level.getRecipeManager().getRecipeFor(ModRecipes.CRUSHING.get(), this, level);
        if (match.isEmpty()) return false;

        ItemStack resultItem = match.get().getResultItem(level.registryAccess());
        return (resultItem.is(resultItem.getItem()) || resultItem.isEmpty()) && (resultItem.getCount() + getItem(RESULT_SLOT).getCount()) <= 64;
    }

    private void craft(Level level) {
        Optional<CrushingRecipe> match = level.getRecipeManager().getRecipeFor(ModRecipes.CRUSHING.get(), this, level);

        if (match.isPresent()) {
            removeItem(INPUT_SLOT, 1);
            setItem(RESULT_SLOT, new ItemStack(match.get().getResultItem(level.registryAccess()).getItem(), getItem(RESULT_SLOT).getCount() + 1));
        }
    }
}