package net.tonimatasdev.krystalcraft.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.teamresourceful.resourcefullib.client.utils.RenderUtils;
import earth.terrarium.botarium.common.fluid.base.FluidHolder;
import earth.terrarium.botarium.common.fluid.utils.ClientFluidHooks;
import earth.terrarium.botarium.common.fluid.utils.FluidHooks;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.material.Fluids;
import net.tonimatasdev.krystalcraft.KrystalCraft;

import java.awt.*;

public class GuiUtil {
    public static final int ENERGY_WIDTH = 13;
    public static final int ENERGY_HEIGHT = 46;
    public static final int FLUID_TANK_WIDTH = 14;
    public static final int FLUID_TANK_HEIGHT = 48;
    public static final int FACTORY_LOADER_WIDTH = 6;
    public static final int FACTORY_LOADER_HEIGHT = 13;

    public static final ResourceLocation ENERGY_TEXTURE = new ResourceLocation(KrystalCraft.MOD_ID, "textures/gui/overlay/energy_full.png");
    public static final ResourceLocation FLUID_TANK_TEXTURE = new ResourceLocation(KrystalCraft.MOD_ID, "textures/gui/overlay/fluid_tank.png");
    public static final ResourceLocation FACTORY_LOADER_TEXTURE = new ResourceLocation(KrystalCraft.MOD_ID, "textures/gui/overlay/loader.png");

    public static boolean isHovering(Rectangle bounds, double x, double y) {
        double left = bounds.getX();
        double right = left + bounds.getWidth();
        double top = bounds.getY();
        double bottom = top + bounds.getHeight();
        return left <= x && x < right && top <= y && y < bottom;
    }

    public static void drawProgress(GuiGraphics graphics, int x, int y, float progress, float maxProgress) {
        double ratio = maxProgress > 0 ? (progress / maxProgress) : 0;
        drawVertical(graphics, x, y, FACTORY_LOADER_WIDTH, FACTORY_LOADER_HEIGHT, FACTORY_LOADER_TEXTURE, ratio);
    }

    public static void drawEnergy(GuiGraphics graphics, int x, int y, long energy, long maxEnergy) {
        double ratio = maxEnergy > 0 ? (energy / (float) maxEnergy) : 0;
        drawVertical(graphics, x, y, ENERGY_WIDTH, ENERGY_HEIGHT, ENERGY_TEXTURE, ratio);
    }

    public static void drawFluidTank(GuiGraphics graphics, int x, int y, long fluidCapacity, FluidHolder fluid) {
        double ratio = fluidCapacity > 0 ? (fluid.getFluidAmount() / (float) fluidCapacity) : 0;
        drawFluidTank(graphics, x, y, ratio, fluid);
    }

    public static void drawFluidTank(GuiGraphics graphics, int x, int y, double ratio, FluidHolder fluid) {
        // Draw the fluid
        drawFluid(graphics, x, y, ratio, fluid);
        // Draw the fluid tank
        RenderSystem.enableBlend();
        drawVertical(graphics, x, y, FLUID_TANK_WIDTH, FLUID_TANK_HEIGHT, FLUID_TANK_TEXTURE, 1.0);
        RenderSystem.disableBlend();
    }

    private static void drawFluid(GuiGraphics graphics, int x, int y, double ratio, FluidHolder fluid) {

        if (fluid.isEmpty()) {
            return;
        }

        TextureAtlasSprite sprite = ClientFluidHooks.getFluidSprite(fluid);
        int colour = ClientFluidHooks.getFluidColor(fluid);
        int spriteHeight = sprite.contents().height();

        RenderSystem.setShaderColor((colour >> 16 & 255) / 255.0f, (float) (colour >> 8 & 255) / 255.0f, (float) (colour & 255) / 255.0f, 1.0f);
        RenderSystem.setShaderTexture(0, InventoryMenu.BLOCK_ATLAS);

        int calcHeight = (int) ((FLUID_TANK_HEIGHT + 1) * ratio);
        try (var ignored = RenderUtils.createScissorBox(Minecraft.getInstance(), graphics.pose(), x, y + FLUID_TANK_HEIGHT - calcHeight, FLUID_TANK_WIDTH, calcHeight)) {
            for (int i = 1; i < 4; i++) {
                graphics.blit(x + 1, FLUID_TANK_HEIGHT + y - (spriteHeight * i), 0, FLUID_TANK_WIDTH - 2, spriteHeight, sprite);
            }
        }
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public static void drawVertical(GuiGraphics graphics, int x, int y, int width, int height, ResourceLocation resource, double ratio) {
        int ratioHeight = (int) Math.ceil(height * ratio);
        int remainHeight = height - ratioHeight;
        graphics.blit(resource, x, y + remainHeight, 0, remainHeight, width, ratioHeight, width, height);
    }

    public static void drawEnergyTooltip(GuiGraphics graphics, long energy, long energyCapacity, int mouseX, int mouseY) {
        graphics.renderTooltip(Minecraft.getInstance().font, Component.literal(energy + "/" + energyCapacity + " FE").setStyle(Style.EMPTY.withColor(ChatFormatting.GOLD)), mouseX, mouseY);
    }

    public static void drawTankTooltip(GuiGraphics graphics, FluidHolder tank, long capacity, int mouseX, int mouseY) {
        graphics.renderTooltip(Minecraft.getInstance().font, Component.literal(FluidHooks.toMillibuckets(tank.getFluidAmount()) + "/" + FluidHooks.toMillibuckets(capacity)).setStyle(Style.EMPTY.withColor(ChatFormatting.GOLD)), mouseX, mouseY);
    }

    public static Rectangle getFluidTankBounds(int x, int y) {
        return new Rectangle(x, y, FLUID_TANK_WIDTH, FLUID_TANK_HEIGHT);
    }

    public static Rectangle getEnergyBounds(int x, int y) {
        return new Rectangle(x, y, ENERGY_WIDTH, ENERGY_HEIGHT);
    }
}
