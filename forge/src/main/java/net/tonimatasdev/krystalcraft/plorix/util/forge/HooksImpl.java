package net.tonimatasdev.krystalcraft.plorix.util.forge;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.network.NetworkHooks;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.FluidHolder;
import net.tonimatasdev.krystalcraft.plorix.fluid.base.forge.ForgeFluidHolder;
import net.tonimatasdev.krystalcraft.plorix.menu.ExtraDataMenuProvider;

public class HooksImpl {
    public static int getBurnTime(ItemStack stack) {
        return ForgeHooks.getBurnTime(stack, null);
    }

    public static TextureAtlasSprite getFluidSprite(FluidHolder fluid) {
        IClientFluidTypeExtensions extension = IClientFluidTypeExtensions.of(fluid.getFluid());
        ResourceLocation resourceLocation = extension.getStillTexture(ForgeFluidHolder.toStack(fluid));
        return Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(resourceLocation);
    }

    public static int getFluidColor(FluidHolder fluid) {
        IClientFluidTypeExtensions extension = IClientFluidTypeExtensions.of(fluid.getFluid());
        return extension.getTintColor(ForgeFluidHolder.toStack(fluid));
    }

    public static void openMenu(ServerPlayer player, ExtraDataMenuProvider provider) {
        NetworkHooks.openScreen(player, provider, (data) -> provider.writeExtraData(player, data));
    }
}
