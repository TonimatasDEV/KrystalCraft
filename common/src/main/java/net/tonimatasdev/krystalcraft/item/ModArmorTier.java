package net.tonimatasdev.krystalcraft.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.tonimatasdev.krystalcraft.KrystalCraft;
import net.tonimatasdev.krystalcraft.registry.ItemRegistry;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum ModArmorTier implements ArmorMaterial {

    JADE("jade", new int[]{3, 5, 6, 2}, new int[]{275, 365, 315, 240}, 16, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0f, 0.0f, () -> Ingredient.of(ItemRegistry.JADE.get())),
    TOPAZ("topaz", new int[]{3, 4, 7, 1}, new int[]{285, 375, 325, 250}, 8, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.2f, 0.0f, () -> Ingredient.of(ItemRegistry.TOPAZ.get())),
    SILVER("silver", new int[]{2, 5, 7, 2}, new int[]{235, 295, 280, 240}, 7, SoundEvents.ARMOR_EQUIP_IRON, 0.5f, 0.0F, () -> Ingredient.of(ItemRegistry.SILVER_INGOT.get())),
    LEAD("lead", new int[]{3, 6, 8, 3}, new int[]{390, 460, 420, 350}, 6, SoundEvents.ARMOR_EQUIP_IRON, 1.5f, 0.0f, () -> Ingredient.of(ItemRegistry.LEAD_INGOT.get())),
    TIN("tin", new int[]{2, 4, 5, 1}, new int[]{190, 250, 220, 210}, 8, SoundEvents.ARMOR_EQUIP_IRON, 0.0f, 0.0f, () -> Ingredient.of(ItemRegistry.TIN_INGOT.get())),
    PLATINUM("platinum", new int[]{3, 5, 6, 2}, new int[]{480, 570, 510, 400}, 8, SoundEvents.ARMOR_EQUIP_IRON, 2.0f, 1.0f, () -> Ingredient.of(ItemRegistry.PLATINUM_INGOT.get())),
    COPPER("copper", new int[]{2, 4, 5, 1}, new int[]{190, 250, 220, 210}, 8, SoundEvents.ARMOR_EQUIP_IRON, 0.2f, 0.0f, () -> Ingredient.of(Items.COPPER_INGOT)),
    SAPPHIRE("sapphire", new int[]{3, 4, 7, 1}, new int[]{305, 395, 345, 270}, 28, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.3f, 0.0f, () -> Ingredient.of(ItemRegistry.SAPPHIRE.get())),
    RUBY("ruby", new int[]{2, 3, 6, 2}, new int[]{305, 395, 345, 270}, 28, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0f, 0.0f, () -> Ingredient.of(ItemRegistry.RUBY.get())),
    BRONZE("bronze", new int[]{2, 4, 6, 2}, new int[]{215, 275, 240, 220}, 7, SoundEvents.ARMOR_EQUIP_IRON, 0.3f, 0.0F, () -> Ingredient.of(ItemRegistry.BRONZE_INGOT.get()));

    private final int[] MAX_DAMAGE_ARRAY;
    private final String name;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairMaterial;

    ModArmorTier(String name, int[] damageReductionAmountArray, int[] MAX_DAMAGE_ARRAY, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) {
        this.MAX_DAMAGE_ARRAY = MAX_DAMAGE_ARRAY;
        this.name = name;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return this.MAX_DAMAGE_ARRAY[type.getSlot().getIndex()];
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.damageReductionAmountArray[type.getSlot().getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Override
    public @NotNull String getName() {
        return KrystalCraft.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}