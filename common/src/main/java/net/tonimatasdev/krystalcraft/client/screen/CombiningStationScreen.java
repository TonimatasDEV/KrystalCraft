package net.tonimatasdev.krystalcraft.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.client.utils.GuiUtil;
import net.tonimatasdev.krystalcraft.menu.CombiningStationMenu;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CombiningStationScreen extends AbstractContainerScreen<CombiningStationMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(KrystalCraft.MOD_ID, "textures/gui/combining_station.png");

    public CombiningStationScreen(CombiningStationMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void renderBg(@NotNull GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);

        int x = (width - 176) / 2;
        int y = (height - 180) / 2 - 10;

        guiGraphics.blit(TEXTURE, x, y, 0, 0, 176, 180);
        GuiUtil.drawProgress(guiGraphics, this.leftPos + 85, this.topPos + 33, this.menu.getProgress(), this.menu.getMaxProgress());
        GuiUtil.drawFire(guiGraphics, this.leftPos + 130, this.topPos + 37, this.menu.getBurnTime(), this.menu.getBurnTimeTotal());
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(Objects.requireNonNull(guiGraphics));
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
