package dev.tonimatas.krystalcraft.client.screen;

import dev.tonimatas.krystalcraft.client.utils.GuiUtil;
import dev.tonimatas.krystalcraft.menu.CuttingFactoryMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class CuttingFactoryScreen extends BaseScreen<CuttingFactoryMenu> {
    public CuttingFactoryScreen(CuttingFactoryMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle, "cutting_factory");
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int j) {
        super.renderBg(guiGraphics, f, i, j);
        GuiUtil.drawEnergy(guiGraphics, this.leftPos + 152, this.topPos + 8, this.menu.energy.get(), this.menu.getEnergyMaxCapacity());
        GuiUtil.drawProgress(guiGraphics, this.leftPos + 85, this.topPos + 29, this.menu.progress.get(), this.menu.getMaxProgress());
        GuiUtil.drawFluidTank(guiGraphics, this.leftPos + 29, this.topPos + 8, this.menu.getFluidHolder(), this.menu.getTankCapacity(), this.menu.tankAmount.get());
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);

        if (GuiUtil.isHovering(GuiUtil.getEnergyBounds(this.leftPos + 152, this.topPos + 8), mouseX, mouseY)) {
            GuiUtil.drawEnergyTooltip(guiGraphics, this.menu.energy.get(), this.menu.getEnergyMaxCapacity(), mouseX, mouseY);
        }

        if (GuiUtil.isHovering(GuiUtil.getFluidTankBounds(this.leftPos + 29, this.topPos + 8), mouseX, mouseY)) {
            GuiUtil.drawTankTooltip(guiGraphics, this.menu.tankAmount.get(), this.menu.getTankCapacity(), mouseX, mouseY);
        }
    }
}
