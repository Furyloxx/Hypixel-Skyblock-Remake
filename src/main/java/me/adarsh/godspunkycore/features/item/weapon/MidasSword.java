package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;
import org.bukkit.ChatColor;

public class MidasSword implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Mida's Sword";
    }

    @Override
    public int getBaseDamage() {
        return 150;
    }

    @Override
    public int getManaCost() {
        return 0;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 0;
    }

    @Override
    public String getAbilityName() {
        return "Greed";
    }

    @Override
    public String getAbilityDescription() {
        return ChatColor.GRAY+"The Strength and damage bonus of this item is dependent on the price paid for it at the "+ ChatColor.DARK_PURPLE +"Dark Auction!\n"+ChatColor.GRAY+" The maximum bonus of this item is "+ChatColor.RED+"120"+ChatColor.GRAY+" if the bid was "+ChatColor.GOLD+"50,000,000 coins "+ChatColor.GRAY+"or higher!";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
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
    public String getLore() {
        return null;
    }
}
