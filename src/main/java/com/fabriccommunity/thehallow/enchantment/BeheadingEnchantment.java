package com.fabriccommunity.thehallow.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;

import com.fabriccommunity.thehallow.registry.HallowedEnchantments;
import com.fabriccommunity.thehallow.registry.HallowedItems;

import com.google.common.collect.ImmutableList;

public class BeheadingEnchantment extends Enchantment {
	protected static final ImmutableList<Integer> BEHEAD_CHANCE = ImmutableList.of(5, 7, 10, 12, 15);
	
	public BeheadingEnchantment(Enchantment.Weight weight, EnchantmentTarget target, EquipmentSlot[] slots) {
		super(weight, target, slots);
	}
	
	public static boolean hasBeheading(LivingEntity livingEntity) {
		return EnchantmentHelper.getEquipmentLevel(HallowedEnchantments.BEHEADING, livingEntity) > 0;
	}
	
	public static boolean getHead(DamageSource damageSource) {
		if (damageSource.getSource() instanceof LivingEntity && hasBeheading((LivingEntity) damageSource.getSource())) {
			LivingEntity attacker = (LivingEntity) damageSource.getSource();
			int enchantmentLevel = EnchantmentHelper.getEquipmentLevel(HallowedEnchantments.BEHEADING, attacker);
			int scytheMultiplier = attacker.getActiveItem().getItem() == HallowedItems.REAPERS_SCYTHE ? 2 : 1;
			return attacker.world.random.nextInt(100) <= BEHEAD_CHANCE.get(enchantmentLevel - 1) * scytheMultiplier;
		} else {
			return false;
		}
	}
	
	public int getMaximumLevel() {
		return 5;
	}
}
