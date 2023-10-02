package net.tonimatasdev.krystalcraft.plorix.util.fabric;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidHolder;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.fabric.FabricFluidHolder;
import net.tonimatasdev.krystalcraft.plorix.menu.ExtraDataMenuProvider;
import net.tonimatasdev.krystalcraft.plorix.menu.ExtraDataMenuProviderWrapper;

@SuppressWarnings("UnstableApiUsage")
public class HooksImpl {
    public static int getBurnTime(ItemStack burnable) {
        Integer burnTime = FuelRegistry.INSTANCE.get(burnable.getItem());
        return burnTime == null ? 0 : burnTime;
    }

    public static TextureAtlasSprite getFluidSprite(FluidHolder fluid) {
        return FluidVariantRendering.getSprite(FabricFluidHolder.of(fluid).toVariant());
    }

    public static int getFluidColor(FluidHolder fluid) {
        return FluidVariantRendering.getColor(FabricFluidHolder.of(fluid).toVariant());
    }

    public static void openMenu(ServerPlayer player, ExtraDataMenuProvider provider) {
        player.openMenu(new ExtraDataMenuProviderWrapper(provider));
    }
}
