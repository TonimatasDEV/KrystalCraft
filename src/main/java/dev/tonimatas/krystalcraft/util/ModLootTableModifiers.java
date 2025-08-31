package dev.tonimatas.krystalcraft.util;

import dev.tonimatas.krystalcraft.registry.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.ExplosionDecayLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.EnchantmentsPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.predicate.item.ItemSubPredicateTypes;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModLootTableModifiers {
    private static final Identifier DIAMOND_ORE = Identifier.ofVanilla("blocks/diamond_ore");
    private static final Identifier DEEPSLATE_DIAMOND_ORE = Identifier.ofVanilla("blocks/deepslate_diamond_ore");
    private static final Identifier EMERALD_ORE = Identifier.ofVanilla("blocks/emerald_ore");
    private static final Identifier DEEPSLATE_EMERALD_ORE = Identifier.ofVanilla("blocks/deepslate_emerald_ore");
    private static final Identifier LAPIS_ORE = Identifier.ofVanilla("blocks/lapis_ore");
    private static final Identifier DEEPSLATE_LAPIS_ORE = Identifier.ofVanilla("blocks/deepslate_lapis_ore");
    private static final Identifier REDSTONE_ORE = Identifier.ofVanilla("blocks/redstone_ore");
    private static final Identifier DEEPSLATE_REDSTONE_ORE = Identifier.ofVanilla("blocks/deepslate_redstone_ore");
    
    public static void initialize() {
        LootTableEvents.REPLACE.register((registryKey, lootTable, lootTableSource, wrapperLookup) -> {
            if (registryKey.getValue().equals(DIAMOND_ORE)) {
                return oreDrop(wrapperLookup, Blocks.DIAMOND_ORE, ModItems.RAW_DIAMOND).build();
            }

            if (registryKey.getValue().equals(DEEPSLATE_DIAMOND_ORE)) {
                return oreDrop(wrapperLookup, Blocks.DEEPSLATE_DIAMOND_ORE, ModItems.RAW_DIAMOND).build();
            }

            if (registryKey.getValue().equals(EMERALD_ORE)) {
                return oreDrop(wrapperLookup, Blocks.EMERALD_ORE, ModItems.RAW_EMERALD).build();
            }

            if (registryKey.getValue().equals(DEEPSLATE_EMERALD_ORE)) {
                return oreDrop(wrapperLookup, Blocks.DEEPSLATE_EMERALD_ORE, ModItems.RAW_EMERALD).build();
            }

            if (registryKey.getValue().equals(LAPIS_ORE)) {
                return multipleOreDrop(wrapperLookup, Blocks.LAPIS_ORE, ModItems.RAW_LAPIS, 4.0F, 9.0F).build();
            }

            if (registryKey.getValue().equals(DEEPSLATE_LAPIS_ORE)) {
                return multipleOreDrop(wrapperLookup, Blocks.DEEPSLATE_LAPIS_ORE, ModItems.RAW_LAPIS, 4.0F, 9.0F).build();
            }

            if (registryKey.getValue().equals(REDSTONE_ORE)) {
                return multipleOreDrop(wrapperLookup, Blocks.REDSTONE_ORE, ModItems.RAW_REDSTONE, 4.0F, 5.0F).build();
            }

            if (registryKey.getValue().equals(DEEPSLATE_REDSTONE_ORE)) {
                return multipleOreDrop(wrapperLookup, Blocks.DEEPSLATE_REDSTONE_ORE, ModItems.RAW_REDSTONE, 4.0F, 5.0F).build();
            }
            
            
            return lootTable;
        });
    }

    public static LootTable.Builder multipleOreDrop(RegistryWrapper.WrapperLookup registryLookup, Block withSilkTouch, Item withoutSilkTouch, float min, float max) {
        RegistryWrapper.Impl<Enchantment> impl = registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return BlockLootTableGenerator.drops(withSilkTouch, MatchToolLootCondition.builder(ItemPredicate.Builder.create()
                        .subPredicate(ItemSubPredicateTypes.ENCHANTMENTS, EnchantmentsPredicate.enchantments(
                                List.of(new EnchantmentPredicate(impl.getOrThrow(Enchantments.SILK_TOUCH), NumberRange.IntRange.atLeast(1)))))),
                ItemEntry.builder(withoutSilkTouch)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(min, max)))
                        .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                        .apply(ExplosionDecayLootFunction.builder()));
    }
    
    public static LootTable.Builder oreDrop(RegistryWrapper.WrapperLookup registryLookup, Block withSilkTouch, Item withoutSilkTouch) {
        RegistryWrapper.Impl<Enchantment> impl = registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return BlockLootTableGenerator.drops(withSilkTouch, MatchToolLootCondition.builder(ItemPredicate.Builder.create()
                .subPredicate(ItemSubPredicateTypes.ENCHANTMENTS, EnchantmentsPredicate.enchantments(
                        List.of(new EnchantmentPredicate(impl.getOrThrow(Enchantments.SILK_TOUCH), NumberRange.IntRange.atLeast(1)))))), 
                ItemEntry.builder(withoutSilkTouch)
                        .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                        .apply(ExplosionDecayLootFunction.builder()));
    }
}
