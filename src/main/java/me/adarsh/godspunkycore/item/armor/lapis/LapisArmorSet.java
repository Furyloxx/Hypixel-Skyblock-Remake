package me.adarsh.godspunkycore.item.armor.lapis;

import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialStatistics;
import me.adarsh.godspunkycore.item.PlayerBoostStatistics;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class LapisArmorSet implements ArmorSet
{
    @Override
    public String getName()
    {
        return "Health";
    }

    @Override
    public String getDescription()
    {
        return "Increases the wearer's maximum Health by 60.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet()
    {
        return LapisArmorHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate()
    {
        return LapisArmorChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings()
    {
        return LapisArmorLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots()
    {
        return LapisArmorBoots.class;
    }

    @Override
    public PlayerBoostStatistics whileHasFullSet(Player player)
    {
        return new PlayerBoostStatistics()
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
            public double getBaseHealth()
            {
                return 60;
            }
        };
    }
}
