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
import net.tonimatasdev.krystalcraft.menu.CrushingFactoryMenu;
import net.tonimatasdev.krystalcraft.recipe.CombiningRecipe;
import net.tonimatasdev.krystalcraft.recipe.CrushingRecipe;
import net.tonimatasdev.krystalcraft.registry.ModBlockEntities;
import net.tonimatasdev.krystalcraft.registry.ModRecipes;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;

public class CrushingFactoryBlockEntity extends FactoryBlockEntity {
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
        return 2;
    }

    @Override
    public WrappedBlockEnergyContainer getEnergyStorage() {
        return energyContainer == null ? energyContainer = new WrappedBlockEnergyContainer(this, new InsertOnlyEnergyContainer(15000)) : this.energyContainer;
    }

    @Override
    public void tick() {
        if (level == null) return;
        if (level.isClientSide) return;

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
        Optional<CrushingRecipe> match = Objects.requireNonNull(level).getRecipeManager().getRecipeFor(ModRecipes.CRUSHING.get(), this, level);
        ItemStack resultItem = getItem(1);
        return match.isPresent() && (match.get().getResultItem(access).is(resultItem.getItem()) || resultItem.isEmpty()) && resultItem.getCount() != 64;
    }

    private void craft(RegistryAccess access) {
        Optional<CrushingRecipe> match = Objects.requireNonNull(level).getRecipeManager().getRecipeFor(ModRecipes.CRUSHING.get(), this, level);

        if (match.isPresent()) {
            removeItem(0, 1);
            setItem(1, new ItemStack(match.get().getResultItem(access).getItem(), getItem(1).getCount() + 1));
        }
    }
}
