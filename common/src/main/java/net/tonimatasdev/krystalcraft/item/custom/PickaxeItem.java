package net.tonimatasdev.krystalcraft.item.custom;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;

public class PickaxeItem extends DiggerItem {
    protected PickaxeItem(Tier tier, int i, float f, Item.Properties properties) {
        super((float)i, f, tier, BlockTags.MINEABLE_WITH_PICKAXE, properties);
    }
}

