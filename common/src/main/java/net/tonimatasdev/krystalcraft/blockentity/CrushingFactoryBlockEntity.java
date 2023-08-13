package net.tonimatasdev.krystalcraft.blockentity;

import earth.terrarium.botarium.common.energy.impl.InsertOnlyEnergyContainer;
import earth.terrarium.botarium.common.energy.impl.WrappedBlockEnergyContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.blockentity.util.EnergyProcessingBlockEntity;
import net.tonimatasdev.krystalcraft.menu.CrushingFactoryMenu;
import net.tonimatasdev.krystalcraft.recipe.CrushingRecipe;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;
import net.tonimatasdev.krystalcraft.registry.ModRecipes;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CrushingFactoryBlockEntity extends EnergyProcessingBlockEntity {
    private final int INPUT_SLOT = 0;
    private final int RESULT_SLOT = 1;
    private final int BATTERY_SLOT = 2;
    private final int UPGRADE1_SLOT = 3;
    private final int UPGRADE2_SLOT = 4;

    public CrushingFactoryBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CRUSHING_FACTORY_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        return new CrushingFactoryMenu(syncId, inventory, this);
    }

    @Override
    public int getInventorySize() {
        return 5;
    }

    @Override
    public WrappedBlockEnergyContainer getEnergyStorage() {
        return energyContainer == null ? energyContainer = new WrappedBlockEnergyContainer(this, new InsertOnlyEnergyContainer(15000)) : energyContainer;
    }

    @Override
    public void tick() {
        if (level == null) return;
        if (level.isClientSide) return;

        energyExtractFromEnergyOutputSlot(BATTERY_SLOT, 10);

        // TODO: Logic for upgrades (Slot 3, 4)

        if (hasRecipe(level) && energyAmount() > 0) {
            progress++;
            energyInternalExtract(5);

            if (progress >= getMaxProgress()) {
                craft(level);
                progress = 0;
            }
        } else {
            progress = 0;
        }
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
