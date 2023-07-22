package net.tonimatasdev.krystalcraft.mixins;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(AxeItem.class)
public interface AxeItemAccessor {
    @Invoker("<init>")
    static AxeItem createAxeItem(Tier tier, float f, float g, Item.Properties properties) {
        throw new UnsupportedOperationException();
    }
}
