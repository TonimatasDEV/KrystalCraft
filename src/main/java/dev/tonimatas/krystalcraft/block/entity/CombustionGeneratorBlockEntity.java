package dev.tonimatas.krystalcraft.block.entity;

import dev.tonimatas.krystalcraft.registry.ModBlockEntities;
import dev.tonimatas.krystalcraft.screen.CombustionGeneratorScreenHandler;
import dev.tonimatas.krystalcraft.util.EnergyUtils;
import dev.tonimatas.krystalcraft.util.FabricUtils;
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

public class CombustionGeneratorBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory<BlockPos> {
    protected static final int INPUT_SLOT = 0;
    protected static final int BATTERY_SLOT = 1;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);
    protected final PropertyDelegate propertyDelegate;
    protected int burnTime;
    protected int totalBurnTime;

    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(30000, 50, 50) {
        @Override
        protected void onFinalCommit() {
            markDirty();
            getWorld().updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
    };

    public CombustionGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.COMBUSTION_GENERATOR_BLOCK_ENTITY, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> CombustionGeneratorBlockEntity.this.burnTime;
                    case 1 -> CombustionGeneratorBlockEntity.this.totalBurnTime;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: CombustionGeneratorBlockEntity.this.burnTime = value;
                    case 1: CombustionGeneratorBlockEntity.this.totalBurnTime  = value;
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
        return Text.translatable("block.krystalcraft.combustion_generator");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CombustionGeneratorScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("combustion_generator.burn_time", burnTime);
        nbt.putInt("combustion_generator.total_burn_time", totalBurnTime);
        nbt.putLong("combustion_generator.energy", energyStorage.amount);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.readNbt(nbt, inventory, registryLookup);
        burnTime = nbt.getInt("combustion_generator.burn_time");
        totalBurnTime = nbt.getInt("combustion_generator.total_burn_time");
        energyStorage.amount = nbt.getLong("combustion_generator.energy");
        super.readNbt(nbt, registryLookup);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        EnergyUtils.moveToItem(this, energyStorage, BATTERY_SLOT);

        if (burnTime <= 0) {
            if (energyStorage.getAmount() < energyStorage.getCapacity()) {
                int newBurnTime = FabricUtils.getBurnTime(getStack(INPUT_SLOT));

                if (newBurnTime != 0) {
                    removeStack(INPUT_SLOT, 1);
                    totalBurnTime = newBurnTime;
                    burnTime = newBurnTime;
                }
            }
        } else {
            EnergyUtils.insertInternal(energyStorage, 10);
            burnTime--;
        }

        EnergyUtils.distributeEnergyNearby(this.energyStorage, world, pos);
    }
}
