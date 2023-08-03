package net.tonimatasdev.krystalcraft.client.screen;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.tonimatasdev.krystalcraft.KrystalCraft;

import java.awt.*;

public class GuiUtil {
    public static final int ENERGY_WIDTH = 13;
    public static final int ENERGY_HEIGHT = 46;
    public static final int FACTORY_LOADER_WIDTH = 6;
    public static final int FACTORY_LOADER_HEIGHT = 13;

    public static final ResourceLocation ENERGY_TEXTURE = new ResourceLocation(KrystalCraft.MOD_ID, "textures/gui/overlay/energy_full.png");
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

    public static void drawVertical(GuiGraphics graphics, int x, int y, int width, int height, ResourceLocation resource, double ratio) {
        int ratioHeight = (int) Math.ceil(height * ratio);
        int remainHeight = height - ratioHeight;
        graphics.blit(resource, x, y + remainHeight, 0, remainHeight, width, ratioHeight, width, height);
    }

    public static void drawEnergyTooltip(GuiGraphics graphics, long energy, long energyCapacity, int mouseX, int mouseY) {
        graphics.renderTooltip(Minecraft.getInstance().font, Component.literal(energy + "/" + energyCapacity).setStyle(Style.EMPTY.withColor(ChatFormatting.GOLD)), mouseX, mouseY);
    }

    public static Rectangle getEnergyBounds(int x, int y) {
        return new Rectangle(x, y, ENERGY_WIDTH, ENERGY_HEIGHT);
    }
}
