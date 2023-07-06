package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;
import org.bukkit.entity.Player;

public class GiantSword implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Giant's Sword";
    }

    @Override
    public int getBaseDamage() {
        return 500;
    }

    @Override
    public int getManaCost() {
        return 100;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 600;
    }

    @Override
    public String getAbilityName() {
        return "Giant's Slam";
    }

    @Override
    public String getAbilityDescription() {
        return "Slam your sword into the ground dealing 100,000 damage to nearby enemies.";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public void onAbilityUse(Player player, SItem sItem) {

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