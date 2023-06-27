package me.adarsh.godspunkycore.features.entity.caverns;

import me.adarsh.godspunkycore.features.enchantment.Enchantment;
import me.adarsh.godspunkycore.features.enchantment.EnchantmentType;
import me.adarsh.godspunkycore.features.entity.*;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class EnchantedDiamondSkeleton implements EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "Skeleton";
    }

    @Override
    public double getEntityMaxHealth() {
        return 300.0;
    }

    @Override
    public double getDamageDealt() {
        return 190.0;
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(SUtil.enchant(new ItemStack(Material.BOW)),
                SUtil.enchant(new ItemStack(Material.DIAMOND_BLOCK)),
                SUtil.enchant(new ItemStack(Material.DIAMOND_CHESTPLATE)),
                SUtil.enchant(new ItemStack(Material.DIAMOND_LEGGINGS)),
                SUtil.enchant(new ItemStack(Material.DIAMOND_BOOTS)));
    }

    @Override
    public List<EntityDrop> drops() {
        return Arrays.asList(new EntityDrop(new ItemStack(Material.BONE, 4), EntityDropType.GUARANTEED, 1.0),
                new EntityDrop(SUtil.enchant(SItem.of(SMaterial.MINER_HELMET),
                        new Enchantment(EnchantmentType.PROTECTION, 5)).getStack(), EntityDropType.RARE, 0.05),
                new EntityDrop(SUtil.enchant(SItem.of(SMaterial.MINER_CHESTPLATE),
                        new Enchantment(EnchantmentType.PROTECTION, 5)).getStack(), EntityDropType.RARE, 0.05),
                new EntityDrop(SUtil.enchant(SItem.of(SMaterial.MINER_LEGGINGS),
                        new Enchantment(EnchantmentType.PROTECTION, 5)).getStack(), EntityDropType.RARE, 0.05),
                new EntityDrop(SUtil.enchant(SItem.of(SMaterial.MINER_BOOTS),
                        new Enchantment(EnchantmentType.PROTECTION, 5)).getStack(), EntityDropType.RARE, 0.05)
        );
    }

    @Override
    public double getXPDropped() {
        return 24.0;
    }
}