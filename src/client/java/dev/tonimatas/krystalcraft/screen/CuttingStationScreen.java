package dev.tonimatas.krystalcraft.screen;

import dev.tonimatas.krystalcraft.KrystalCraft;
import dev.tonimatas.krystalcraft.util.GuiUtils;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class CuttingStationScreen extends HandledScreen<CuttingStationScreenHandler> {
    public static final Identifier TEXTURE = Identifier.of(KrystalCraft.MOD_ID, "textures/gui/cutting_station.png");

    public CuttingStationScreen(CuttingStationScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.backgroundHeight = this.backgroundHeight + 14;
        this.playerInventoryTitleY = this.playerInventoryTitleY + 14;
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        GuiUtils.setDefaultRender(TEXTURE);

        context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

        if (handler.isCrafting()) {
            GuiUtils.drawLoaderProgress(context, x + 85, y + 45, handler.getScaledLoader());
        }

        GuiUtils.drawFire(context, x + 130, y + 45, handler.getBurnTime(), handler.getBurnTimeTotal());
        GuiUtils.drawFluid(context, handler.blockEntity.fluidStorage, x + 29, y + 25);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);

        if (GuiUtils.isHovering(GuiUtils.getFluidTankBounds(x + 29, y + 25), mouseX, mouseY)) {
            GuiUtils.drawTankTooltip(context, this.handler.blockEntity.fluidStorage, mouseX, mouseY);
        }
    }
}
