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
import net.tonimatasdev.krystalcraft.menu.CombiningFactoryMenu;
import net.tonimatasdev.krystalcraft.recipe.CombiningRecipe;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;
import net.tonimatasdev.krystalcraft.registry.ModRecipes;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CombiningFactoryBlockEntity extends FactoryBlockEntity {
    private final int INPUT1_SLOT = 0;
    private final int INPUT2_SLOT = 1;
    private final int RESULT_SLOT = 2;
    private final int BATTERY_SLOT = 3;
    private final int UPGRADE1_SLOT = 4;
    private final int UPGRADE2_SLOT = 5;



    public CombiningFactoryBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.COMBINING_FACTORY_BLOCK_ENTITY.get(), blockPos, blockState);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
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

        insertEnergyFromBattery(BATTERY_SLOT);

        // TODO: Logic for upgrades (Slot 4, 5)

        if (hasRecipe(level) && getEnergyStorage().getStoredEnergy() > 0) {
            progress++;
            getEnergyStorage().internalExtract(6, true);
            getEnergyStorage().internalExtract(6, false);

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
        ItemStack resultItem = getItem(RESULT_SLOT);
        return match.isPresent() && (match.get().getResultItem(level.registryAccess()).is(resultItem.getItem()) || resultItem.isEmpty()) && resultItem.getCount() != 64;
    }

    private void craft(Level level) {
        Optional<CombiningRecipe> match = level.getRecipeManager().getRecipeFor(ModRecipes.COMBINING.get(), this, level);

        if (match.isPresent()) {
            removeItem(INPUT1_SLOT, 1);
            removeItem(INPUT2_SLOT, 1);
            setItem(RESULT_SLOT, new ItemStack(match.get().getResultItem(level.registryAccess()).getItem(), getItem(RESULT_SLOT).getCount() + 1));
        }
    }
}
