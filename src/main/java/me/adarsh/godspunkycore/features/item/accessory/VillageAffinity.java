package me.adarsh.godspunkycore.features.item.accessory;

import me.adarsh.godspunkycore.features.item.*;
import me.adarsh.godspunkycore.features.region.Region;
import me.adarsh.godspunkycore.features.region.RegionType;
import me.adarsh.godspunkycore.user.PlayerUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class VillageAffinity implements AccessoryStatistics, MaterialFunction,AccessoryFunction {
    @Override
    public String getURL() {
        return "9c11d6c79b8a1f18902d783cdda4bdfb9d47337b73791028a126a6e6cf101def";
    }

    @Override
    public String getDisplayName() {
        return "Village Affinity Talisman";
    }

    @Override
    public String getLore(){
        return ChatColor.GRAY+"Increases your ✦ Speed by"+
                ChatColor.GREEN+"+10 "+ChatColor.GRAY+"while held in the "+ChatColor.AQUA+"Village.";
    }

    @Override
    public void update(SItem instance, Player player, int accessorySlot) {
        Region region = Region.getQuickRegionOfEntity(player);
        if (region == null) return;
        if (region.getType() != RegionType.VILLAGE ) return;
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
