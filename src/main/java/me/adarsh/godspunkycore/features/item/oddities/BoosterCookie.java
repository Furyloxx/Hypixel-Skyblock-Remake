package me.adarsh.godspunkycore.features.item.oddities;

import me.adarsh.godspunkycore.features.item.*;
import me.adarsh.godspunkycore.gui.CookieConfirmGUI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class BoosterCookie implements MaterialStatistics, MaterialFunction, Ability {
    public String getDisplayName() {
        return "Booster Cookie";
    }

    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }

    public String getAbilityName() {
        return "Drink!";
    }

    public String getAbilityDescription() {
        return ChatColor.translateAlternateColorCodes('&',"&7Consume to gain the &dCookie Buff &7for &b2 &7days:");
    }

    public int getAbilityCooldownTicks() {
        return 8;
    }

    public boolean displayCooldown() {
        return false;
    }

    public int getManaCost() {
        return 0;
    }

    public boolean isEnchanted() {
        return true;
    }

    public boolean displayUsage() {
        return false;
    }

    public boolean isStackable() {
        return false;
    }

    public void onAbilityUse(Player player, SItem sItem) {
        (new CookieConfirmGUI(player.getInventory().getHeldItemSlot(), player.getInventory().getItemInHand())).open(player);
    }
}
