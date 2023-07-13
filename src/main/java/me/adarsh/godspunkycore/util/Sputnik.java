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

    public static String trans(String content) {
        return ChatColor.translateAlternateColorCodes('&', content);
    }
}
