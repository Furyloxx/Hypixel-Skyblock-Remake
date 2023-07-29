package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;
import me.adarsh.godspunkycore.user.PlayerUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class RogueSword implements ToolStatistics, MaterialFunction, Ability {
    @Override
    public String getAbilityName() {
        return "Speed Boost";
    }

    @Override
    public String getAbilityDescription() {
        return "Grant "+ ChatColor.WHITE +"+100✦ Speed"+ChatColor.GRAY+" for"+ChatColor.GREEN+" 30"+ChatColor.GRAY+" seconds.";
    }

    @Override
    public void onAbilityUse(Player player, SItem sItem) {
        PlayerUtils.boostPlayer(PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId()), new PlayerBoostStatistics() {
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
                return 1.0;
            }
        }, 20 * 30);
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 0;
    }

    @Override
    public int getManaCost() {
        return 50;
    }

    @Override
    public String getDisplayName() {
        return "Rogue Sword";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.SWORD;
    }

    @Override
    public int getBaseDamage() {
        return 20;
    }
}