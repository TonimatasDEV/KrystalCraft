package dev.tonimatas.krystalcraft.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import dev.tonimatas.krystalcraft.client.utils.GuiUtil;
import dev.tonimatas.krystalcraft.menu.CuttingStationMenu;
import org.jetbrains.annotations.NotNull;

public class CuttingStationScreen extends BaseScreen<CuttingStationMenu> {
    public CuttingStationScreen(CuttingStationMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle, "cutting_station");
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int j) {
        super.renderBg(guiGraphics, f, i, j);
        GuiUtil.drawProgress(guiGraphics, this.leftPos + 85, this.topPos + 28, this.menu.progress.get(), this.menu.getMaxProgress());
        GuiUtil.drawFluidTank(guiGraphics, this.leftPos + 29, this.topPos + 8, this.menu.getFluidHolder(), this.menu.getTankCapacity(), this.menu.tankAmount.get());
        GuiUtil.drawFire(guiGraphics, this.leftPos + 130, this.topPos + 28, this.menu.burnTime.get(), this.menu.burnTimeTotal.get());
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);

        if (GuiUtil.isHovering(GuiUtil.getFluidTankBounds(this.leftPos + 29, this.topPos + 8), mouseX, mouseY)) {
            GuiUtil.drawTankTooltip(guiGraphics, this.menu.tankAmount.get(), this.menu.getTankCapacity(), mouseX, mouseY);
        }
    }
}
