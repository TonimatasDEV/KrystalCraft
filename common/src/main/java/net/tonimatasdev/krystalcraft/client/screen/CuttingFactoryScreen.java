package net.tonimatasdev.krystalcraft.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.menu.CuttingFactoryMenu;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CuttingFactoryScreen extends AbstractContainerScreen<CuttingFactoryMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(KrystalCraft.MOD_ID, "textures/gui/cutting_factory.png");

    public CuttingFactoryScreen(CuttingFactoryMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
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
        GuiUtil.drawEnergy(guiGraphics, this.leftPos + 152, this.topPos + 8, this.menu.getEnergyAmount(), this.menu.getEnergyMaxCapacity());
        GuiUtil.drawProgress(guiGraphics, this.leftPos + 85, this.topPos + 29, this.menu.getProgress(), this.menu.getMaxProgress());
        GuiUtil.drawFluidTank(guiGraphics, this.leftPos + 29, this.topPos + 8, this.menu.getFluidContainer().getTankCapacity(0), this.menu.getFluids().get(0));
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(Objects.requireNonNull(guiGraphics));
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);

        if (GuiUtil.isHovering(GuiUtil.getEnergyBounds(this.leftPos + 152, this.topPos + 8), mouseX, mouseY)) {
            GuiUtil.drawEnergyTooltip(guiGraphics, this.menu.getEnergyAmount(), this.menu.getEnergyMaxCapacity(), mouseX, mouseY);
        }

        if (GuiUtil.isHovering(GuiUtil.getFluidTankBounds(this.leftPos + 29, this.topPos + 8), mouseX, mouseY)) {
            GuiUtil.drawTankTooltip(guiGraphics, this.menu.getFluids().get(0), this.menu.getFluidContainer().getTankCapacity(0), mouseX, mouseY);
        }
    }
}
