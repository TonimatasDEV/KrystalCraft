package dev.tonimatas.krystalcraft.utils;

import dev.tonimatas.krystalcraft.KrystalCraft;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.util.Identifier;

public class GuiUtils {
    public static final int FIRE_WIDTH = 13;
    public static final int FIRE_HEIGHT = 13;
    public static final int LOADER_WIDTH = 6;
    public static final int LOADER_HEIGHT = 13;

    public static final Identifier FIRE_TEXTURE = Identifier.of(KrystalCraft.MOD_ID, "textures/gui/overlay/fire.png");
    public static final Identifier LOADER_TEXTURE = Identifier.of(KrystalCraft.MOD_ID, "textures/gui/overlay/loader.png");
    
    public static void drawLoaderProgress(DrawContext context, int x, int y, int scaledProgress) {
        context.drawTexture(LOADER_TEXTURE, x, y, 0, 0, LOADER_WIDTH, scaledProgress, LOADER_WIDTH, LOADER_HEIGHT);
    }

    public static void drawFire(DrawContext graphics, int x, int y, int burnTime, int totalBurnTime) {
        double ratio = totalBurnTime > 0 ? (burnTime / (float) totalBurnTime) : 0;
        drawVertical(graphics, x, y, FIRE_WIDTH, FIRE_HEIGHT, FIRE_TEXTURE, ratio);
    }

    public static void drawVertical(DrawContext graphics, int x, int y, int width, int height, Identifier resource, double ratio) {
        int ratioHeight = (int) Math.ceil(height * ratio);
        int remainHeight = height - ratioHeight;
        graphics.drawTexture(resource, x, y + remainHeight, 0, remainHeight, width, ratioHeight, width, height);
    }
}
