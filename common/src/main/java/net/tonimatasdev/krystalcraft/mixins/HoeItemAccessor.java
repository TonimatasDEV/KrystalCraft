package net.tonimatasdev.krystalcraft.mixins;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(HoeItem.class)
public interface HoeItemAccessor {
    @Invoker("<init>")
    static HoeItem createHoeItem(Tier tier, int i, float f, Item.Properties properties) {
        throw new UnsupportedOperationException();
    }
}
