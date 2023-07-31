package me.godspunky.skyblock.features.entity.dungeon;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.entity.EntityFunction;
import me.godspunky.skyblock.features.entity.EntityStatistics;
import me.godspunky.skyblock.features.entity.SEntity;
import me.godspunky.skyblock.features.entity.SEntityEquipment;
import me.godspunky.skyblock.util.EntityManager;
import me.godspunky.skyblock.util.SUtil;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TankZombie implements EntityFunction, EntityStatistics {
    public String getEntityName() {
        return "Tank Zombie";
    }

    public double getEntityMaxHealth() {
        return 5.0E7D;
    }

    public double getDamageDealt() {
        return 1300500.0D;
    }

    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(new ItemStack(Material.AIR),

                SUtil.applyColorToLeatherArmor(new ItemStack(Material.LEATHER_HELMET), Color.fromRGB(15132390)),
                SUtil.applyColorToLeatherArmor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.fromRGB(5923940)),
                SUtil.applyColorToLeatherArmor(new ItemStack(Material.LEATHER_LEGGINGS), Color.fromRGB(5923940)),
                SUtil.applyColorToLeatherArmor(new ItemStack(Material.LEATHER_BOOTS), Color.fromRGB(15132390)));
    }

    public void onSpawn(LivingEntity entity, SEntity sEntity) {
        entity.setMetadata("SlayerBoss", (MetadataValue)new FixedMetadataValue((Plugin) Skyblock.getPlugin(), Boolean.valueOf(true)));
        EntityManager.DEFENSE_PERCENTAGE.put(entity, Integer.valueOf(95));
        entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000000, 1));
    }

    public double getXPDropped() {
        return 400.0D;
    }
}
