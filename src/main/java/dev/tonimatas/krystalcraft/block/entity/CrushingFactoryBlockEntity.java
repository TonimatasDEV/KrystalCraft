package dev.tonimatas.krystalcraft.block.entity;

import dev.tonimatas.krystalcraft.recipe.CrushingRecipe;
import dev.tonimatas.krystalcraft.recipe.input.SimpleRecipeInput;
import dev.tonimatas.krystalcraft.registry.ModBlockEntities;
import dev.tonimatas.krystalcraft.registry.ModRecipes;
import dev.tonimatas.krystalcraft.screen.CrushingFactoryScreenHandler;
import dev.tonimatas.krystalcraft.util.EnergyUtils;
import dev.tonimatas.krystalcraft.util.ImplementedInventory;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.Optional;

public class CrushingFactoryBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory<BlockPos> {
    private static final int INPUT_SLOT = 0;
    private static final int RESULT_SLOT = 1;
    private static final int BATTERY_SLOT = 2;
    private static final int UPGRADE1_SLOT = 3;
    private static final int UPGRADE2_SLOT = 4;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    protected int progress;
    protected int maxProgress = 100;

    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(30000, 50, 50) {
        @Override
        protected void onFinalCommit() {
            markDirty();
            getWorld().updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
    };

    public CrushingFactoryBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CRUSHING_FACTORY_BLOCK_ENTITY, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> CrushingFactoryBlockEntity.this.progress;
                    case 1 -> CrushingFactoryBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: CrushingFactoryBlockEntity.this.progress = value;
                    case 1: CrushingFactoryBlockEntity.this.maxProgress  = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("crushing_factory.progress", progress);
        nbt.putLong("crushing_factory.energy", energyStorage.amount);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("crushing_factory.progress");
        energyStorage.amount = nbt.getLong("crushing_factory.energy");
        super.readNbt(nbt, registryLookup);
    }

    @Override
    public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.krystalcraft.crushing_factory");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CrushingFactoryScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
    
    public void tick(World world, BlockPos pos, BlockState state) {
        EnergyUtils.moveFromItem(this, energyStorage, BATTERY_SLOT);
        
        if (hasRecipe()) {
            if (energyStorage.amount >= 5 && EnergyUtils.extractInternal(energyStorage, 5) == 5) {
                progress++;
            }
            
            if (this.progress >= this.maxProgress) {
                craftItem();
                this.progress = 0;
            }
        } else {
            this.progress = 0;
        }
    }
    
    private boolean hasRecipe() {
        Optional<RecipeEntry<CrushingRecipe>> recipe = getCurrentRecipe();
        
        if (recipe.isEmpty()) {
            return false;
        }
        
        ItemStack output = recipe.get().value().result();
        
        return canInsertItemStack(output);
    }

    private Optional<RecipeEntry<CrushingRecipe>> getCurrentRecipe() {
        return this.getWorld().getRecipeManager().getFirstMatch(ModRecipes.CRUSHING_RECIPE_TYPE, new SimpleRecipeInput(inventory.get(INPUT_SLOT)), this.getWorld());
    }

    private void craftItem() {
        Optional<RecipeEntry<CrushingRecipe>> recipe = getCurrentRecipe();
        
        ItemStack output = recipe.get().value().result();
        this.removeStack(INPUT_SLOT, 1);
        this.setStack(RESULT_SLOT, new ItemStack(output.getItem(), this.getStack(RESULT_SLOT).getCount() + output.getCount()));
    }
    
    private boolean canInsertItemStack(ItemStack newStack) {
        ItemStack stack = this.getStack(RESULT_SLOT);
        int maxCount = stack.isEmpty() ? 64 : stack.getMaxCount();
        int currentCount = stack.getCount();

        return maxCount >= currentCount + newStack.getCount() && (stack.isOf(newStack.getItem()) || stack.isEmpty());
    }
}
