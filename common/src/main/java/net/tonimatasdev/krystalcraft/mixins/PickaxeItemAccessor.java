package net.tonimatasdev.krystalcraft.mixins;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PickaxeItem.class)
public interface PickaxeItemAccessor {
    @Invoker("<init>")
    static PickaxeItem createPickaxeItem(Tier tier, int i, float f, Item.Properties properties) {
        throw new UnsupportedOperationException();
    }
}
