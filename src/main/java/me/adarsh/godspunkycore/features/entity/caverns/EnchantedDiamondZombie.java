package me.adarsh.godspunkycore.features.entity.caverns;

import me.adarsh.godspunkycore.features.enchantment.Enchantment;
import me.adarsh.godspunkycore.features.enchantment.EnchantmentType;
import me.adarsh.godspunkycore.features.entity.EntityDrop;
import me.adarsh.godspunkycore.features.entity.EntityDropType;
import me.adarsh.godspunkycore.features.entity.SEntityEquipment;
import me.adarsh.godspunkycore.features.entity.zombie.BaseZombie;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.util.SUtil;
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