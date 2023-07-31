package me.godspunky.skyblock.features.entity.zombie;

import me.godspunky.skyblock.features.entity.EntityDrop;
import me.godspunky.skyblock.features.entity.EntityDropType;
import me.godspunky.skyblock.features.entity.SEntityEquipment;
import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;
import me.godspunky.skyblock.util.SUtil;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;
import java.util.List;

public class DeformedRevenant extends BaseZombie {
    @Override
    public String getEntityName() {
        return "Deformed Revenant";
    }

    @Override
    public double getEntityMaxHealth() {
        return 360000;
    }

    @Override
    public double getDamageDealt() {
        return 4400.0;
    }

    @Override
    public double getXPDropped() {
        return 1200.0;
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(SUtil.enchant(new ItemStack(Material.GOLD_SWORD)),
                SUtil.enchant(SUtil.applyColorToLeatherArmor(new ItemStack(Material.LEATHER_HELMET), Color.fromRGB(0xE83333))),
                SUtil.enchant(new ItemStack(Material.DIAMOND_CHESTPLATE)),
                SUtil.enchant(SUtil.applyColorToLeatherArmor(new ItemStack(Material.LEATHER_LEGGINGS), Color.fromRGB(0xE83333))),
                new ItemStack(Material.IRON_BOOTS));
    }

    @Override
    public List<EntityDrop> drops() {
        return Collections.singletonList(new EntityDrop(SUtil.setStackAmount(SItem.of(SMaterial.REVENANT_FLESH).getStack(), 5), EntityDropType.GUARANTEED, 1.0));
    }
}