package dev.tonimatas.krystalcraft.util;

import dev.tonimatas.krystalcraft.KrystalCraft;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import team.reborn.energy.api.EnergyStorage;

import java.awt.*;

public class GuiUtils {
    public static final int ENERGY_WIDTH = 13;
    public static final int ENERGY_HEIGHT = 46;
    public static final int FIRE_WIDTH = 13;
    public static final int FIRE_HEIGHT = 13;
    public static final int LOADER_WIDTH = 6;
    public static final int LOADER_HEIGHT = 13;

    public static final Identifier ENERGY_TEXTURE = Identifier.of(KrystalCraft.MOD_ID, "textures/gui/overlay/energy_full.png");
    public static final Identifier FIRE_TEXTURE = Identifier.of(KrystalCraft.MOD_ID, "textures/gui/overlay/fire.png");
    public static final Identifier LOADER_TEXTURE = Identifier.of(KrystalCraft.MOD_ID, "textures/gui/overlay/loader.png");

    public static boolean isHovering(Rectangle bounds, double x, double y) {
        double left = bounds.getX();
        double right = left + bounds.getWidth();
        double top = bounds.getY();
        double bottom = top + bounds.getHeight();
        return left <= x && x < right && top <= y && y < bottom;
    }

    public static void drawEnergy(DrawContext context, int x, int y, EnergyStorage energyStorage) {
        double ratio = energyStorage.getCapacity() > 0 ? (energyStorage.getAmount() / (float) energyStorage.getCapacity()) : 0;
        drawVertical(context, x, y, ENERGY_WIDTH, ENERGY_HEIGHT, ENERGY_TEXTURE, ratio);
    }
    
    public static void drawLoaderProgress(DrawContext context, int x, int y, int scaledProgress) {
        context.drawTexture(LOADER_TEXTURE, x, y, 0, 0, LOADER_WIDTH, scaledProgress, LOADER_WIDTH, LOADER_HEIGHT);
    }

    public static void drawFire(DrawContext context, int x, int y, int burnTime, int totalBurnTime) {
        double ratio = totalBurnTime > 0 ? (burnTime / (float) totalBurnTime) : 0;
        drawVertical(context, x, y, FIRE_WIDTH, FIRE_HEIGHT, FIRE_TEXTURE, ratio);
    }

    public static void drawVertical(DrawContext context, int x, int y, int width, int height, Identifier identifier, double ratio) {
        int ratioHeight = (int) Math.ceil(height * ratio);
        int remainHeight = height - ratioHeight;
        context.drawTexture(identifier, x, y + remainHeight, 0, remainHeight, width, ratioHeight, width, height);
    }

    public static void drawEnergyTooltip(DrawContext context, EnergyStorage energyStorage, int mouseX, int mouseY) {
        context.drawTooltip(MinecraftClient.getInstance().textRenderer, Text.literal(energyStorage.getAmount() + "/" + energyStorage.getCapacity() + " FE").setStyle(Style.EMPTY.withColor(Formatting.GOLD)), mouseX, mouseY);
    }

    public static Rectangle getEnergyBounds(int x, int y) {
        return new Rectangle(x, y, ENERGY_WIDTH, ENERGY_HEIGHT);
    }
}
