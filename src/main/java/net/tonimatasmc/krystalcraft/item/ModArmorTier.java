package net.tonimatasmc.krystalcraft.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.tonimatasmc.krystalcraft.KrystalCraft;

import java.util.function.Supplier;

@SuppressWarnings({"NullableProblems", "deprecation"})
public enum ModArmorTier implements ArmorMaterial {

    JADE("jade", new int[] {3, 5, 6, 2}, new int[] {275, 365, 315, 240}, 16, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0f, 0.0f, () ->
            Ingredient.of(ModItems.JADE.get())),

    TOPAZ("topaz", new int[] {3, 4, 7, 1}, new int[] {285, 375, 325, 250}, 8, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.2f, 0.0f, () ->
            Ingredient.of(ModItems.TOPAZ.get())),

    SILVER("silver", new int[]{2, 5, 7, 2}, new int[] {235, 295, 280, 240}, 7, SoundEvents.ARMOR_EQUIP_IRON, 0.5F, 0.0F, () ->
            Ingredient.of(ModItems.SILVER_INGOT.get())),

    LEAD("lead", new int[] {3, 6, 8, 3}, new int[] {390, 460, 420, 350}, 6, SoundEvents.ARMOR_EQUIP_IRON, 1.5F, 0, () ->
            Ingredient.of(ModItems.LEAD_INGOT.get())),

    TIN("tin", new int[] {2, 4, 5, 1}, new int[] {190, 250, 220, 210}, 8, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0,() ->
            Ingredient.of(ModItems.TIN_INGOT.get())),

    PLATINUM("platinum", new int[] {3, 5, 6, 2}, new int[] {480, 570, 510, 400}, 8, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0, () ->
            Ingredient.of(ModItems.PLATINUM_INGOT.get())),

    COPPER("copper", new int[] {2, 4, 5, 1}, new int[] {190, 250, 220, 210}, 8, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0, () ->
            Ingredient.of(Items.COPPER_INGOT));


    private final int[] MAX_DAMAGE_ARRAY;
    private final String name;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairMaterial;

    ModArmorTier(String name, int[] damageReductionAmountArray, int[] MAX_DAMAGE_ARRAY, int enchantability,
                 SoundEvent soundEvent, float toughness, float knockbackResistance,
                             Supplier<Ingredient> repairMaterial) {
        this.MAX_DAMAGE_ARRAY = MAX_DAMAGE_ARRAY;
        this.name = name;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = new LazyLoadedValue<>(repairMaterial);
    }

    public int getDurabilityForSlot(EquipmentSlot slot) {
        return this.MAX_DAMAGE_ARRAY[slot.getIndex()];
    }

    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.damageReductionAmountArray[slot.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return KrystalCraft.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}