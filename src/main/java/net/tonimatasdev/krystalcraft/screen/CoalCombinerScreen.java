package net.tonimatasdev.krystalcraft.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CoalCombinerScreen extends AbstractContainerScreen<CoalCombinerMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(KrystalCraft.MOD_ID, "textures/gui/coal_combiner_gui.png");

    public CoalCombinerScreen(CoalCombinerMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void renderBg(@NotNull GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2 + 8;

        guiGraphics.blit(TEXTURE, x, y, 0, -8, imageWidth, imageHeight + 16);
        guiGraphics.blit(TEXTURE, x + 81, y + 41, 176, 0, 14, menu.getFuelScaledProgress());

        if (menu.isCrafting()) {
            //Future crafting animation with menu.getScaledProgress()
        }
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(Objects.requireNonNull(guiGraphics));
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
