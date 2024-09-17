package me.godspunky.skyblock.features.item.accessory;

import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public class CruxHeirloom implements AccessoryStatistics, MaterialFunction {
    @Override
    public String getURL() {
        return "21f5074db86b669376e71dd8fe70716f73e0e84f955879a4682ef5fa1ea82d2d";
    }

    @Override
    public String getDisplayName() {
        return "Crux Heirloom";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.MYTHIC;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ACCESSORY;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.ACCESSORY;
    }

    @Override
    public List<String> getListLore() {
        return Arrays.asList("§7Defeat crux mobs to gain §a+5ф Rift",
    "§aTime §7and §6+5 Crux Fortune §7per",
    "§7kill milestone.",
    "§7§8Crux Fortune boosts the chance",
    "§8for bonus crux drops.",
    "",
    "§7Total Bonuses",
    "§a+§k10§aф Rift Time",
    "§6+§k10§6 Crux Fortune",
    "",
    "§7Kill Milestones",
    "  §2§kII§2 Shy§7: §e§k25§7/§a§k50§7 kill");
    }
    
    @Override
    public double getBaseIntelligence() {
        return 15;
    }
    
    @Override
    public double getBaseSpeed() {
        return 1;
    }
}