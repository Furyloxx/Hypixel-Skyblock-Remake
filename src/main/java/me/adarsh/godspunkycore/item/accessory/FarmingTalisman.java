package me.adarsh.godspunkycore.item.accessory;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.item.SItem;
import me.adarsh.godspunkycore.region.Region;
import me.adarsh.godspunkycore.region.RegionType;
import me.adarsh.godspunkycore.user.PlayerUtils;
import org.bukkit.entity.Player;

public class FarmingTalisman implements AccessoryStatistics, AccessoryFunction
{
    @Override
    public String getDisplayName()
    {
        return "Farming Talisman";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.COMMON;
    }

    @Override
    public String getURL()
    {
        return "9af328c87b068509aca9834eface197705fe5d4f0871731b7b21cd99b9fddc";
    }

    @Override
    public void update(SItem instance, Player player, int accessorySlot)
    {
        Region region = Region.getQuickRegionOfEntity(player);
        if (region == null) return;
        if (region.getType() != RegionType.THE_BARN && region.getType() != RegionType.MUSHROOM_DESERT) return;
        PlayerUtils.addBoostStatistics(PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId()), accessorySlot, new PlayerBoostStatistics()
        {
            @Override
            public String getDisplayName()
            {
                return null;
            }
            @Override
            public Rarity getRarity()
            {
                return null;
            }
            @Override
            public GenericItemType getType()
            {
                return null;
            }
            @Override
            public double getBaseSpeed()
            {
                return 0.1;
            }
        });
    }
}