package me.godspunky.skyblock.features.item.armor.ender;

import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialStatistics;
import me.godspunky.skyblock.features.item.PlayerBoostStatistics;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class EnderSet implements ArmorSet {
    @Override
    public String getName() {
        return "Ender Set";
    }

    @Override
    public String getDescription() {
        return "All stats of this armor piece are doubled while on the End Island!";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return EnderArmorHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return EnderArmorChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return EnderArmorLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return EnderArmorBoots.class;
    }

    @Override
    public PlayerBoostStatistics whileHasFullSet(Player player) {
//        Region region = Region.getRegionOfEntity(player);
//        if (region != null && region.getType().equals(RegionType.THE_END)){
            return new PlayerBoostStatistics() {
                @Override
                public String getDisplayName() {
                    return null;
                }

                @Override
                public Rarity getRarity() {
                    return Rarity.RARE;
                }

                @Override
                public GenericItemType getType() {
                    return GenericItemType.ARMOR;
                }

            };
        }
    }
