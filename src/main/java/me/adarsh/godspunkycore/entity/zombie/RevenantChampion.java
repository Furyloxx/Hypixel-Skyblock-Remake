package me.adarsh.godspunkycore.entity.zombie;

import me.adarsh.godspunkycore.entity.EntityDrop;
import me.adarsh.godspunkycore.entity.EntityDropType;
import me.adarsh.godspunkycore.entity.SEntityEquipment;
import me.adarsh.godspunkycore.item.SItem;
import me.adarsh.godspunkycore.item.SMaterial;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;
import java.util.List;

public class RevenantChampion extends BaseZombie {
    @Override
    public String getEntityName() {
        return "Revenant Champion";
    }

    @Override
    public double getEntityMaxHealth() {
        return 90000;
    }

    @Override
    public double getDamageDealt() {
        return 2200.0;
    }

    @Override
    public double getXPDropped() {
        return 600.0;
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(SUtil.enchant(new ItemStack(Material.DIAMOND_SWORD)), null,
                SUtil.enchant(new ItemStack(Material.DIAMOND_CHESTPLATE)), SUtil.enchant(new ItemStack(Material.CHAINMAIL_LEGGINGS)),
                new ItemStack(Material.IRON_BOOTS));
    }

    @Override
    public List<EntityDrop> drops() {
        return Collections.singletonList(new EntityDrop(SUtil.setStackAmount(SItem.of(SMaterial.REVENANT_FLESH).getStack(), 2), EntityDropType.GUARANTEED, 1.0));
    }
}