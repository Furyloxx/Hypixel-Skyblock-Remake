package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public class RaiderAxe implements ToolStatistics, MaterialFunction {

    @Override
    public int getBaseDamage() {
        return 115;
    }

    @Override
    public double getBaseStrength() {
        return 150;
    }

    @Override
    public String getDisplayName() {
        return "Raider Axe";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
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
    public List<String> getListLore() {
        return Arrays.asList(ChatColor.GRAY+"Earn "+ChatColor.GOLD+"+20 coins"+ChatColor.GRAY+" from killing monsters",
                "",
                ChatColor.RED+"+1 Damage "+ChatColor.GRAY+"per "+ChatColor.GRAY+"500 kills.",
                ChatColor.DARK_GRAY+"Max +35.",
                "",
                ChatColor.RED+"+1 ❁ Strength "+ChatColor.GRAY+"per "+ChatColor.YELLOW+"500 "+ChatColor.GRAY+"wood",
                ChatColor.DARK_GRAY+"Max +100");
    }
}

