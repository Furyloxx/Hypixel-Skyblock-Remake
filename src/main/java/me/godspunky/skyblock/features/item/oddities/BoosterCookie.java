package me.godspunky.skyblock.features.item.oddities;

import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public class BoosterCookie implements MaterialStatistics, MaterialFunction {
    @Override
    public String getDisplayName() {
        return ChatColor.GOLD+"Booster Cookie";
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
    public List<String> getListLore() {
        return Arrays.asList(ChatColor.GOLD + "Booster Cookie " + ChatColor.DARK_GRAY + "x1",
                ChatColor.translateAlternateColorCodes('&',"&7Consume to gain the &dCookie Buff"),
                ChatColor.translateAlternateColorCodes('&',"&7for &b5 &7days:"),
                " ",
                ChatColor.translateAlternateColorCodes('&',"&8► &7Ability to gain &bBis&7!"),
                ChatColor.translateAlternateColorCodes('&',"&8► &b+20% &7 Skill XP"),
                ChatColor.translateAlternateColorCodes('&',"&8► &b+15 &7Magic Find"),
                ChatColor.translateAlternateColorCodes('&',"&8► &7Keep &6coins &7and &beffects &7on death"),
                ChatColor.translateAlternateColorCodes('&',"&8► &ePermafly &7 on private islands"),
                ChatColor.translateAlternateColorCodes('&',"&8► &7Access &6/ah &7and &6/bazaar &7 anywhere"),
                ChatColor.translateAlternateColorCodes('&',"&8► &7Sell items directly to the trades menu"),
                ChatColor.translateAlternateColorCodes('&',"&8► &7AFK &aimmunity &7on your island"),
                ChatColor.translateAlternateColorCodes('&',"&8► &7Toggle specific &dpotion effects"),
                ChatColor.translateAlternateColorCodes('&',"&8► &7Access to &6/anvil &7and &6/etable"));
    }

    @Override
    public boolean isEnchanted(){return true;}
}