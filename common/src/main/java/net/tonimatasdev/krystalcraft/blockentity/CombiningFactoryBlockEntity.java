package net.tonimatasdev.krystalcraft.blockentity;

import dev.tonimatas.mythlib.energy.impl.InsertOnlyEnergyContainer;
import dev.tonimatas.mythlib.energy.impl.WrappedBlockEnergyContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.blockentity.util.EnergyProcessingBlockEntity;
import net.tonimatasdev.krystalcraft.menu.CombiningFactoryMenu;
import net.tonimatasdev.krystalcraft.recipe.CombiningRecipe;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;
import net.tonimatasdev.krystalcraft.registry.ModRecipes;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class CombiningFactoryBlockEntity extends EnergyProcessingBlockEntity {
    protected final int INPUT1_SLOT = 0;
    protected final int INPUT2_SLOT = 1;
    protected final int RESULT_SLOT = 2;
    protected final int BATTERY_SLOT = 3;
    protected final int UPGRADE1_SLOT = 4;
    protected final int UPGRADE2_SLOT = 5;

    public CombiningFactoryBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.COMBINING_FACTORY_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Override
    public @NotNull AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
        return new CombiningFactoryMenu(syncId, inventory, this);
    }

    @Override
    public int getInventorySize() {
        return 6;
    }

    @Override
    public WrappedBlockEnergyContainer getEnergyStorage() {
        return energyContainer == null ? energyContainer = new WrappedBlockEnergyContainer(this, new InsertOnlyEnergyContainer(15000)) : energyContainer;
    }

    @Override
    public void tick() {
        if (level == null) return;
        if (level.isClientSide) return;

        energyExtractFromEnergySlot(BATTERY_SLOT, 10);

        // TODO: Logic for upgrades (Slot 4, 5)

        if (hasRecipe(level) && energyAmount() > 0) {
            progress++;
            energyExtract(5);

            if (progress >= getMaxProgress()) {
                craft(level);
                progress = 0;
            }
        } else {
            progress = 0;
        }
    }

    private boolean hasRecipe(Level level) {
        Optional<CombiningRecipe> match = level.getRecipeManager().getRecipeFor(ModRecipes.COMBINING.get(), this, level);
        if (match.isEmpty()) return false;

        ItemStack resultItem = match.get().getResultItem(level.registryAccess());
        return (resultItem.is(resultItem.getItem()) || resultItem.isEmpty()) && (resultItem.getCount() + getItem(RESULT_SLOT).getCount()) <= 64;
    }

    private void craft(Level level) {
        Optional<CombiningRecipe> match = level.getRecipeManager().getRecipeFor(ModRecipes.COMBINING.get(), this, level);

        if (match.isPresent()) {
            removeItem(INPUT1_SLOT, 1);
            removeItem(INPUT2_SLOT, 1);
            ItemStack result = match.get().getResultItem(level.registryAccess());
            setItem(RESULT_SLOT, new ItemStack(result.getItem(), getItem(RESULT_SLOT).getCount() + result.getCount()));
        }
    }
}
