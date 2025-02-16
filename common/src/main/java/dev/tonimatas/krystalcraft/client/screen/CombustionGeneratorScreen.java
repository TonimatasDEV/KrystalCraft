package dev.tonimatas.krystalcraft.client.screen;

import dev.tonimatas.krystalcraft.client.utils.GuiUtil;
import dev.tonimatas.krystalcraft.menu.CombustionGeneratorMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

public class CombustionGeneratorScreen extends BaseScreen<CombustionGeneratorMenu> {
    public CombustionGeneratorScreen(CombustionGeneratorMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle, "combustion_generator");
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int j) {
        super.renderBg(guiGraphics, f, i, j);
        GuiUtil.drawEnergy(guiGraphics, this.leftPos + 152, this.topPos + 8, this.menu.energyAmount.get(), this.menu.getMaxEnergyCapacity());
        GuiUtil.drawProgress(guiGraphics, this.leftPos + 85, this.topPos + 29, this.menu.burnTime.get(), this.menu.totalBurnTime.get());
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);

        if (GuiUtil.isHovering(GuiUtil.getEnergyBounds(this.leftPos + 152, this.topPos + 8), mouseX, mouseY)) {
            GuiUtil.drawEnergyTooltip(guiGraphics, this.menu.energyAmount.get(), this.menu.getMaxEnergyCapacity(), mouseX, mouseY);
        }
    }
}

