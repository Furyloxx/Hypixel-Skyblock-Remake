package me.godspunky.skyblock.features.entity.caverns;

import me.godspunky.skyblock.features.enchantment.Enchantment;
import me.godspunky.skyblock.features.enchantment.EnchantmentType;
import me.godspunky.skyblock.features.entity.EntityDrop;
import me.godspunky.skyblock.features.entity.EntityDropType;
import me.godspunky.skyblock.features.entity.SEntityEquipment;
import me.godspunky.skyblock.features.entity.zombie.BaseZombie;
import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;
import me.godspunky.skyblock.util.SUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class EnchantedDiamondZombie extends BaseZombie {
    @Override
    public String getEntityName() {
        return "Zombie";
    }

    @Override
    public double getEntityMaxHealth() {
        return 300.0;
    }

    @Override
    public double getDamageDealt() {
        return 275.0;
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(SUtil.enchant(new ItemStack(Material.DIAMOND_SWORD)),
                SUtil.enchant(new ItemStack(Material.DIAMOND_BLOCK)),
                SUtil.enchant(new ItemStack(Material.DIAMOND_CHESTPLATE)),
                SUtil.enchant(new ItemStack(Material.DIAMOND_LEGGINGS)),
                SUtil.enchant(new ItemStack(Material.DIAMOND_BOOTS)));
    }

    @Override
    public List<EntityDrop> drops() {
        return Arrays.asList(new EntityDrop(SMaterial.ROTTEN_FLESH, EntityDropType.GUARANTEED, 1.0),
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
    public boolean isBaby() {
        return false;
    }

    @Override
    public boolean isVillager() {
        return false;
    }

    @Override
    public double getXPDropped() {
        return 24.0;
    }
}