package me.adarsh.godspunkycore.features.item.accessory;

import me.adarsh.godspunkycore.features.item.*;
import me.adarsh.godspunkycore.features.region.Region;
import me.adarsh.godspunkycore.features.region.RegionType;
import me.adarsh.godspunkycore.user.PlayerUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MineAffinity implements AccessoryStatistics, MaterialFunction,AccessoryFunction {
    @Override
    public String getURL() {
        return "3e0aa3a9525d8646f06b12a54a19770eaf320057c98ebf63e663fde2d9d9b131";
    }

    @Override
    public String getDisplayName() {
        return "Mine Affinity Talisman";
    }

    @Override
    public String getLore(){
        return ChatColor.GRAY+"Increases your ✦ Speed by"+
                ChatColor.GREEN+"+10 "+ChatColor.GRAY+"while held in the "+ChatColor.AQUA+"Coal"+
                ChatColor.AQUA+"Mine,"+ChatColor.GOLD+"Gold Mine,"+ChatColor.AQUA+"Deep"+
                ChatColor.AQUA+"Caverns.";
    }

    @Override
    public void update(SItem instance, Player player, int accessorySlot) {
        Region region = Region.getQuickRegionOfEntity(player);
        if (region == null) return;
        if (region.getType() != RegionType.COAL_MINE && region.getType() != RegionType.GOLD_MINE && region.getType() != RegionType.DEEP_CAVERN) return;
        PlayerUtils.addBoostStatistics(PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId()), accessorySlot, new PlayerBoostStatistics() {
            @Override
            public String getDisplayName() {
                return null;
            }

            @Override
            public Rarity getRarity() {
                return null;
            }

            @Override
            public GenericItemType getType() {
                return null;
            }

            @Override
            public double getBaseSpeed() {
                return 0.1;
            }
        });
    }
    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ACCESSORY;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.ACCESSORY;
    }
}

