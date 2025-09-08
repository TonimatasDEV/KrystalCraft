package dev.tonimatas.krystalcraft.util;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.tonimatas.krystalcraft.KrystalCraft;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.storage.base.SingleVariantStorage;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.Fluids;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import team.reborn.energy.api.EnergyStorage;

import java.awt.*;

public class GuiUtils {
    public static final int FLUID_TANK_WIDTH = 13;
    public static final int FLUID_TANK_HEIGHT = 46;
    public static final int ENERGY_WIDTH = 13;
    public static final int ENERGY_HEIGHT = 46;
    public static final int FIRE_WIDTH = 13;
    public static final int FIRE_HEIGHT = 13;
    public static final int LOADER_WIDTH = 6;
    public static final int LOADER_HEIGHT = 13;

    public static final Identifier ENERGY_TEXTURE = Identifier.of(KrystalCraft.MOD_ID, "textures/gui/overlay/energy_full.png");
    public static final Identifier FIRE_TEXTURE = Identifier.of(KrystalCraft.MOD_ID, "textures/gui/overlay/fire.png");
    public static final Identifier LOADER_TEXTURE = Identifier.of(KrystalCraft.MOD_ID, "textures/gui/overlay/loader.png");
    public static final Identifier FLUID_TANK_TEXTURE = Identifier.of(KrystalCraft.MOD_ID, "textures/gui/overlay/fluid_tank.png");

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

    /*
     * METHOD FROM https://github.com/TechReborn/TechReborn
     * UNDER MIT LICENSE: https://github.com/TechReborn/TechReborn/blob/1.19/LICENSE.md
     */
    public static void drawFluid(DrawContext context, SingleVariantStorage<FluidVariant> fluidStorage, int x, int y) {
        if (fluidStorage.variant.getFluid() == Fluids.EMPTY) {
            return;
        }

        RenderSystem.setShaderTexture(0, PlayerScreenHandler.BLOCK_ATLAS_TEXTURE);
        y += FLUID_TANK_HEIGHT;
        final Sprite sprite = FluidVariantRendering.getSprite(fluidStorage.variant);
        int color = FluidVariantRendering.getColor(fluidStorage.variant);

        final int drawHeight = (int) Math.ceil((fluidStorage.amount / (fluidStorage.getCapacity() * 1F) * FLUID_TANK_HEIGHT));
        final int iconHeight = sprite.getY();
        int offsetHeight = drawHeight;

        RenderSystem.setShaderColor((color >> 16 & 255) / 255.0F, (float) (color >> 8 & 255) / 255.0F, (float) (color & 255) / 255.0F, 1F);

        int iteration = 0;
        while (offsetHeight != 0) {
            final int curHeight = Math.min(offsetHeight, iconHeight);

            context.drawSprite(x, y - offsetHeight, 0, FLUID_TANK_WIDTH, curHeight, sprite);
            offsetHeight -= curHeight;
            iteration++;
            if (iteration > 50) {
                break;
            }
        }

        RenderSystem.setShaderColor(1F, 1F, 1F, 1F);

        FluidRenderHandler handler = FluidRenderHandlerRegistry.INSTANCE.get(fluidStorage.variant.getFluid());

        if (handler != null) {
            RenderSystem.setShaderTexture(0, handler.getFluidSprites(MinecraftClient.getInstance().world, null, fluidStorage.variant.getFluid().getDefaultState())[0].getAtlasId());
        }

        drawVertical(context, x, y - FLUID_TANK_HEIGHT, FLUID_TANK_WIDTH, FLUID_TANK_HEIGHT, FLUID_TANK_TEXTURE, 1.0);
    }

    public static void drawVertical(DrawContext context, int x, int y, int width, int height, Identifier identifier, double ratio) {
        int ratioHeight = (int) Math.ceil(height * ratio);
        int remainHeight = height - ratioHeight;
        context.drawTexture(identifier, x, y + remainHeight, 0, remainHeight, width, ratioHeight, width, height);
    }

    public static void drawEnergyTooltip(DrawContext context, EnergyStorage energyStorage, int mouseX, int mouseY) {
        context.drawTooltip(MinecraftClient.getInstance().textRenderer, Text.literal(energyStorage.getAmount() + "/" + energyStorage.getCapacity() + " FE").setStyle(Style.EMPTY.withColor(Formatting.GOLD)), mouseX, mouseY);
    }

    public static void drawTankTooltip(DrawContext context, SingleVariantStorage<FluidVariant> fluidStorage, int mouseX, int mouseY) {
        context.drawTooltip(MinecraftClient.getInstance().textRenderer, Text.literal(fluidStorage.getAmount() + "/" + fluidStorage.getCapacity() + " mB ").setStyle(Style.EMPTY.withColor(Formatting.GOLD)), mouseX, mouseY);
    }

    public static Rectangle getFluidTankBounds(int x, int y) {
        return new Rectangle(x, y, FLUID_TANK_WIDTH, FLUID_TANK_HEIGHT);
    }

    public static Rectangle getFireBounds(int x, int y) {
        return new Rectangle(x, y, FIRE_WIDTH, FIRE_HEIGHT);
    }

    public static Rectangle getEnergyBounds(int x, int y) {
        return new Rectangle(x, y, ENERGY_WIDTH, ENERGY_HEIGHT);
    }
    
    public static void setDefaultRender(Identifier texture) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, texture);
    }
}
