package me.adarsh.godspunkycore.features.entity.zombie;

import java.util.Collections;
import java.util.List;

import me.adarsh.godspunkycore.features.entity.EntityDrop;
import me.adarsh.godspunkycore.features.entity.EntityDropType;
import me.adarsh.godspunkycore.features.entity.SEntityEquipment;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
public class AtonedChampion extends BaseZombie {
    public String getEntityName() {
        return "Atoned Champion";
    }

    public double getEntityMaxHealth() {
        return 600000.0D;
    }

    public double getDamageDealt() {
        return 3500.0D;
    }

    public double getXPDropped() {
        return 900.0D;
    }

    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(
                SUtil.enchant(new ItemStack(Material.IRON_SWORD)), null,

                SUtil.enchant(new ItemStack(Material.IRON_CHESTPLATE)),
                SUtil.enchant(SUtil.applyColorToLeatherArmor(new ItemStack(Material.LEATHER_LEGGINGS), Color.fromRGB(16777215))),
                SUtil.enchant(SUtil.applyColorToLeatherArmor(new ItemStack(Material.LEATHER_BOOTS), Color.fromRGB(16777215))));
    }

    public List<EntityDrop> drops() {
        return Collections.singletonList(new EntityDrop(SUtil.setStackAmount(SItem.of(SMaterial.REVENANT_FLESH).getStack(), 5), EntityDropType.GUARANTEED, 1.0D));
    }
}
