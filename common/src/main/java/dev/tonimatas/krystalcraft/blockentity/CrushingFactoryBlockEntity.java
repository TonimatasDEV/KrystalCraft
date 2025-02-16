package dev.tonimatas.krystalcraft.blockentity;

import dev.tonimatas.krystalcraft.blockentity.util.FactoryBlockEntity;
import dev.tonimatas.krystalcraft.energy.Energy;
import dev.tonimatas.krystalcraft.menu.CrushingFactoryMenu;
import dev.tonimatas.krystalcraft.recipe.CrushingRecipe;
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
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CrushingFactoryBlockEntity extends FactoryBlockEntity {
    private final int INPUT_SLOT = 0;
    private final int RESULT_SLOT = 1;
    private final int BATTERY_SLOT = 2;
    private final int UPGRADE1_SLOT = 3;
    private final int UPGRADE2_SLOT = 4;

    public CrushingFactoryBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.CRUSHING_FACTORY_BLOCK_ENTITY.get(), blockPos, blockState);
        this.energyContainer = Energy.createInsertEnergyStorage(15000, 100);
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
    public void tick() {
        if (level == null) return;
        if (level.isClientSide) return;

        energyExtractFromEnergySlot(BATTERY_SLOT, 10);

        // TODO: Logic for upgrades (Slot 3, 4)

        if (hasRecipe(level) && energyContainer.getStoredEnergy() > 0) {
            progress++;
            energyContainer.extract(5, false);

            if (progress >= getMaxProgress()) {
                craft(level);
                progress = 0;
            }
        } else {
            progress = 0;
        }
    }

    private boolean hasRecipe(Level level) {
        Optional<RecipeHolder<CrushingRecipe>> match = level.getRecipeManager().getRecipeFor(ModRecipes.CRUSHING.get(), this, level);
        if (match.isEmpty()) return false;

        ItemStack resultItem = match.get().value().result();
        return (resultItem.is(resultItem.getItem()) || resultItem.isEmpty()) && (resultItem.getCount() + getItem(RESULT_SLOT).getCount()) <= 64;
    }

    private void craft(Level level) {
        Optional<RecipeHolder<CrushingRecipe>> match = level.getRecipeManager().getRecipeFor(ModRecipes.CRUSHING.get(), this, level);

        if (match.isPresent()) {
            removeItem(INPUT_SLOT, 1);
            setItem(RESULT_SLOT, new ItemStack(match.get().value().result().getItem(), getItem(RESULT_SLOT).getCount() + 1));
        }
    }
}
