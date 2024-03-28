package dev.tonimatas.krystalcraft.client.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import dev.tonimatas.krystalcraft.client.utils.GuiUtil;
import dev.tonimatas.krystalcraft.menu.CrushingStationMenu;
import org.jetbrains.annotations.NotNull;

public class CrushingStationScreen extends BaseScreen<CrushingStationMenu> {
    public CrushingStationScreen(CrushingStationMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle, "crushing_station");
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int j) {
        super.renderBg(guiGraphics, f, i, j);
        GuiUtil.drawProgress(guiGraphics, this.leftPos + 85, this.topPos + 28, this.menu.progress.get(), this.menu.getMaxProgress());
        GuiUtil.drawFire(guiGraphics, this.leftPos + 130, this.topPos + 28, this.menu.burnTime.get(), this.menu.burnTimeTotal.get());
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}
