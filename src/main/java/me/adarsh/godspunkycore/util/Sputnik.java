package me.adarsh.godspunkycore.util;

import com.google.common.util.concurrent.AtomicDouble;
import com.sk89q.worldedit.*;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.extent.Extent;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.function.operation.Operation;
import com.sk89q.worldedit.function.operation.Operations;
import com.sk89q.worldedit.session.ClipboardHolder;
import com.sk89q.worldedit.world.registry.WorldData;
import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.command.AccessTimedCommand;
import me.adarsh.godspunkycore.features.gui.TradeMenu;
import me.adarsh.godspunkycore.user.PlayerUtils;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.user.UserStash;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.UUID;

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

    public static String formatFull(float value) {
        final String[] arr = { "", "k", "M", "B", "T", "P", "E" };
        int index = 0;
        final float realvalue = value;
        while (value / 1000.0f >= 1.0f) {
            value /= 1000.0f;
            ++index;
        }
        final DecimalFormat decimalFormat = new DecimalFormat("#.#");
        final String finalr = String.format("%s%s", decimalFormat.format(value), arr[index]);
        String fin = finalr.replaceAll(",", ".");
        if (realvalue <= 1000.0f && realvalue > 0.0f) {
            fin = SUtil.commaify(Math.round(realvalue));
        }
        return fin;
    }

    public static String formatTime(int z) {
        int seconds = z, p1 = seconds % 60, p2 = seconds / 60, p3 = p2 % 60;
        p2 /= 60;
        String a = String.valueOf(p1), b = String.valueOf(p2), c = String.valueOf(p3);
        if (p1 < 10)
            a = "0" + String.valueOf(p1);
        if (p2 < 10)
            b = "0" + String.valueOf(p2);
        if (p3 < 10)
            c = "0" + String.valueOf(p3);
        return (p2 == 0) ? (c + "m " + a + "s") : (b + "h " + c + "m " + a + "s");
    }

    public static void smartGiveItem(final ItemStack item, final Player p) {
        if (p.getInventory().firstEmpty() != -1) {
            p.getInventory().addItem(new ItemStack[] { item });
        }
        else if (User.getUser(p.getUniqueId()) != null) {
            final UserStash us = UserStash.getStash(p.getUniqueId());
            us.addItemInStash(item);
        }
    }

    public static boolean isFullInv(final Player p) {
        return p.getInventory().firstEmpty() == -1;
    }

    public static void tradeIntitize(final Player target, final Player p) {
        if (Skyblock.getPlugin() != null && !Skyblock.getPlugin().getConfig().getBoolean("enableTrade")) {
            p.sendMessage(trans("&cTrading has been temporary disabled!"));
            return;
        }
        if (p == target) {
            p.sendMessage(trans("&cYou cannot trade with yourself!"));
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
            return;
        }
        final UUID uuid = UUID.randomUUID();
        if (!target.isOnline()) {
            p.sendMessage(trans("&cCannot find player with that name, maybe they've gone offline?"));
            p.playSound(p.getLocation(), Sound.VILLAGER_IDLE, 1.0f, 1.0f);
            return;
        }
        if (!p.getWorld().equals(target.getWorld())) {
            p.sendMessage(net.md_5.bungee.api.ChatColor.RED + "You can't trade with that player!");
            p.playSound(p.getLocation(), Sound.VILLAGER_IDLE, 1.0f, 1.0f);
            return;
        }
        if (p.getLocation().distance(target.getLocation()) > 5.0) {
            p.sendMessage(net.md_5.bungee.api.ChatColor.RED + "You are too far away to trade with that player!");
            p.playSound(p.getLocation(), Sound.VILLAGER_IDLE, 1.0f, 1.0f);
            return;
        }
        if (TradeUtil.hasRequest(target, p)) {
            p.sendMessage(net.md_5.bungee.api.ChatColor.RED + "Woah there! You already have an /trade request");
            p.playSound(p.getLocation(), Sound.VILLAGER_IDLE, 1.0f, 1.0f);
            return;
        }
        new BukkitRunnable() {
            int t = 0;

            public void run() {
                ++this.t;
                if (TradeUtil.isTrading(p) || TradeUtil.isTrading(target)) {
                    this.cancel();
                    return;
                }
                if (this.t >= 200 && !TradeUtil.hasRequest(p, target) && !TradeUtil.isTrading(p) && !TradeUtil.isTrading(target)) {
                    this.cancel();
                    p.sendMessage(Sputnik.trans("&cThe /trade request to " + target.getDisplayName() + " &cexpired!"));
                    target.sendMessage(Sputnik.trans("&cThe /trade request from " + p.getDisplayName() + " &cexpired!"));
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
                    target.playSound(target.getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
                    TradeUtil.resetTrade(p);
                    TradeUtil.resetTrade(target);
                }
            }
        }.runTaskTimer((Plugin)Skyblock.getPlugin(), 0L, 1L);
        if (TradeUtil.hasRequest(p, target)) {
            p.playSound(p.getLocation(), Sound.VILLAGER_HAGGLE, 1.0f, 1.0f);
            target.playSound(target.getLocation(), Sound.VILLAGER_HAGGLE, 1.0f, 1.0f);
            new TradeMenu(p, target, uuid).open();
            return;
        }
        p.playSound(p.getLocation(), Sound.VILLAGER_HAGGLE, 1.0f, 1.0f);
        target.playSound(target.getLocation(), Sound.VILLAGER_HAGGLE, 1.0f, 1.0f);
        p.sendMessage(trans("&aYou have sent a trade request to &b" + target.getDisplayName() + "&a."));
        final TextComponent message = new TextComponent(trans("&b" + p.getName() + " &ahas sent you a trade request. &bClick here &ato accept."));
        final UUID accessKey = UUID.randomUUID();
        AccessTimedCommand.KEYS.add(accessKey);
        SUtil.delay(() -> AccessTimedCommand.KEYS.remove(accessKey), 200L);
        message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (BaseComponent[])new TextComponent[] { new TextComponent(net.md_5.bungee.api.ChatColor.GOLD + "Click to trade!") }));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/attc " + accessKey + " " + p.getName()));
        target.spigot().sendMessage((BaseComponent)message);
        TradeUtil.requestTrade(p, target);
    }
}
