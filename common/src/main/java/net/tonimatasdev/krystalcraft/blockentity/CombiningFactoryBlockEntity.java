package net.tonimatasdev.krystalcraft.blockentity;

import earth.terrarium.botarium.common.energy.impl.InsertOnlyEnergyContainer;
import earth.terrarium.botarium.common.energy.impl.WrappedBlockEnergyContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.tonimatasdev.krystalcraft.menu.CombiningFactoryMenu;
import net.tonimatasdev.krystalcraft.recipe.CombiningRecipe;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;
import net.tonimatasdev.krystalcraft.registry.ModRecipes;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

public class CombiningFactoryBlockEntity extends FactoryBlockEntity {
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
        return energyContainer == null ? energyContainer = new WrappedBlockEnergyContainer(this, new InsertOnlyEnergyContainer(15000)) : this.energyContainer;
    }

    @Override
    public void tick() {
        if (level == null) return;
        if (level.isClientSide) return;

        insertEnergyFromBattery(3);

        // TODO: Logic for upgrades (Slot 4, 5)

        if (hasRecipe(level.registryAccess()) && getEnergyStorage().getStoredEnergy() > 0) {
            progress++;
            getEnergyStorage().internalExtract(6, true);
            getEnergyStorage().internalExtract(6, false);

            if (progress >= getMaxProgress()) {
                craft(level.registryAccess());
                progress = 0;
            }
        } else {
            progress = 0;
        }
    }

    private boolean hasRecipe(RegistryAccess access) {
        Optional<CombiningRecipe> match = Objects.requireNonNull(level).getRecipeManager().getRecipeFor(ModRecipes.COMBINING.get(), this, level);
        ItemStack resultItem = getItem(2);
        return match.isPresent() && (match.get().getResultItem(access).is(resultItem.getItem()) || resultItem.isEmpty()) && resultItem.getCount() != 64;
    }

    private void craft(RegistryAccess access) {
        Optional<CombiningRecipe> match = Objects.requireNonNull(level).getRecipeManager().getRecipeFor(ModRecipes.COMBINING.get(), this, level);

        if (match.isPresent()) {
            removeItem(0, 1);
            removeItem(1, 1);
            setItem(2, new ItemStack(match.get().getResultItem(access).getItem(), getItem(2).getCount() + 1));
        }
    }
}
