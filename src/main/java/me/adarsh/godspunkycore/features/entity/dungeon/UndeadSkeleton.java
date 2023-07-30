package me.adarsh.godspunkycore.features.entity.dungeon;

import java.util.Arrays;
import java.util.List;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.entity.*;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.util.EntityManager;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

public class UndeadSkeleton implements EntityFunction, EntityStatistics {
    public String getEntityName() {
        return "Undead Skeleton";
    }

    public double getEntityMaxHealth() {
        return 1.0E8D;
    }

    public double getDamageDealt() {
        return 800000.0D;
    }

    public double getXPDropped() {
        return 40.0D;
    }

    public void onSpawn(LivingEntity entity, SEntity sEntity) {
        entity.setMetadata("DungeonMobs", (MetadataValue)new FixedMetadataValue((Plugin) Skyblock.getPlugin(), Boolean.valueOf(true)));
        entity.setMetadata("SlayerBoss", (MetadataValue)new FixedMetadataValue((Plugin)Skyblock.getPlugin(), Boolean.valueOf(true)));
        EntityManager.DEFENSE_PERCENTAGE.put(entity, Integer.valueOf(65));
    }

    public List<EntityDrop> drops() {
        return Arrays.asList(new EntityDrop(new ItemStack(Material.ARROW,
                SUtil.random(2, 4)), EntityDropType.GUARANTEED, 1.0D), new EntityDrop(SMaterial.ENCHANTED_BONE, EntityDropType.RARE, 0.05D));
    }

    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(new ItemStack(Material.BOW), null, null, null, null);
    }
}
