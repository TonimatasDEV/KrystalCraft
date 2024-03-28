package dev.tonimatas.krystalcraft.blockentity;

import earth.terrarium.botarium.common.energy.impl.InsertOnlyEnergyContainer;
import earth.terrarium.botarium.common.energy.impl.WrappedBlockEnergyContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import dev.tonimatas.krystalcraft.blockentity.util.FactoryBlockEntity;
import dev.tonimatas.krystalcraft.menu.CombiningFactoryMenu;
import dev.tonimatas.krystalcraft.recipe.CombiningRecipe;
import dev.tonimatas.krystalcraft.registry.ModBlockEntities;
import dev.tonimatas.krystalcraft.registry.ModRecipes;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class CombiningFactoryBlockEntity extends FactoryBlockEntity {
    protected final int INPUT1_SLOT = 0;
    protected final int INPUT2_SLOT = 1;
    protected final int RESULT_SLOT = 2;
    protected final int BATTERY_SLOT = 3;
    protected final int UPGRADE1_SLOT = 4;
    protected final int UPGRADE2_SLOT = 5;

    public CombiningFactoryBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.COMBINING_FACTORY_BLOCK_ENTITY.get(), blockPos, blockState);
        this.energyContainer = new WrappedBlockEnergyContainer(this, new InsertOnlyEnergyContainer(15000));
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
    public void tick() {
        if (level == null) return;
        if (level.isClientSide) return;

        energyExtractFromEnergySlot(BATTERY_SLOT, 10);

        // TODO: Logic for upgrades (Slot 4, 5)

        if (hasRecipe(level) && energyContainer.getStoredEnergy() > 0) {
            progress++;
            energyContainer.internalExtract(5, false);

            if (progress >= getMaxProgress()) {
                craft(level);
                progress = 0;
            }
        } else {
            progress = 0;
        }
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
