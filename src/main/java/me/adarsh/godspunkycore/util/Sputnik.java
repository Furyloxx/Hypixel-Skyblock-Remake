package me.adarsh.godspunkycore.util;

import com.google.common.util.concurrent.AtomicDouble;
import me.adarsh.godspunkycore.user.PlayerUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Sputnik {

    public static Object[] calculateDamage(final Player player, final Player damager, final ItemStack weapon, final LivingEntity damaged, final boolean isBow) {
        final PlayerUtils.DamageResult result = PlayerUtils.getDamageDealt(weapon, player, (Entity)damaged, isBow);
        float displayDmg = new AtomicDouble(result.getFinalDamage()).floatValue();

        return new Object[] { new AtomicDouble(result.getFinalDamage()).floatValue(), result.didCritDamage(), displayDmg };
    }

    private static int getExpAtLevel(final Player player) {
        return getExpAtLevel(player.getLevel());
    }

    public static int getExpAtLevel(final int level) {
        if (level > 29) {
            return 62 + (level - 30) * 7;
        }
        if (level > 15) {
            return 17 + (level - 15) * 3;
        }
        return 17;
    }

    public static int getExpToLevel(final int level) {
        int currentLevel = 0;
        int exp = 0;
        while (currentLevel < level) {
            exp += getExpAtLevel(currentLevel);
            ++currentLevel;
        }
        if (exp < 0) {
            exp = Integer.MAX_VALUE;
        }
        return exp;
    }

    public static int getTotalExperience(final Player player) {
        int exp = Math.round(getExpAtLevel(player) * player.getExp());
        for (int currentLevel = player.getLevel(); currentLevel > 0; --currentLevel, exp += getExpAtLevel(currentLevel)) {}
        if (exp < 0) {
            exp = Integer.MAX_VALUE;
        }
        return exp;
    }

    public static int getExpUntilNextLevel(final Player player) {
        final int exp = Math.round(getExpAtLevel(player) * player.getExp());
        final int nextLevel = player.getLevel();
        return getExpAtLevel(nextLevel) - exp;
    }

    public static void setTotalExperience(final Player player, final int exp) {
        if (exp < 0) {
            throw new IllegalArgumentException("Experience is negative!");
        }
        player.setExp(0.0f);
        player.setLevel(0);
        player.setTotalExperience(0);
        int amount = exp;
        while (amount > 0) {
            final int expToLevel = getExpAtLevel(player);
            amount -= expToLevel;
            if (amount >= 0) {
                player.giveExp(expToLevel);
            }
            else {
                amount += expToLevel;
                player.giveExp(amount);
                amount = 0;
            }
        }
    }

    public static String trans(String content) {
        return ChatColor.translateAlternateColorCodes('&', content);
    }
}
