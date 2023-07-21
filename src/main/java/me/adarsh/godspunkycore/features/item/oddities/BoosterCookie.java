package me.adarsh.godspunkycore.features.item.oddities;

import me.adarsh.godspunkycore.features.item.*;
import me.adarsh.godspunkycore.features.gui.CookieConfirmGUI;
import me.adarsh.godspunkycore.util.Sputnik;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class BoosterCookie implements MaterialStatistics, MaterialFunction, Ability, Untradeable
{
    @Override
    public String getDisplayName() {
        return "Booster Cookie";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }

    @Override
    public String getAbilityName() {
        return "Drink!";
    }

    @Override
    public String getAbilityDescription() {
        return Sputnik.trans("&7Consume to gain the &dCookie Buff &7for &b2 &7days:");
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 8;
    }

    @Override
    public boolean displayCooldown() {
        return false;
    }

    @Override
    public int getManaCost() {
        return 0;
    }

    @Override
    public boolean isEnchanted() {
        return true;
    }

    @Override
    public boolean displayUsage() {
        return false;
    }

    @Override
    public boolean isStackable() {
        return false;
    }

    @Override
    public void onAbilityUse(final Player player, final SItem sItem) {
        new CookieConfirmGUI(player.getInventory().getHeldItemSlot(), player.getInventory().getItemInHand()).open(player);
    }
}

