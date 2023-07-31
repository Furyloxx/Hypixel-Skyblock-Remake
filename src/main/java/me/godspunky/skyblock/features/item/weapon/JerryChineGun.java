package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.weapon.Abilites.jerry.JerryChineGunProjectile;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class JerryChineGun implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Jerry Chine Gun";
    }

    @Override
    public int getBaseDamage() {
        return 80;
    }

    @Override
    public double getBaseIntelligence() {
        return 200;
    }

    @Override
    public int getManaCost() {
        return 30;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 0;
    }

    @Override
    public String getAbilityName() {
        return "Rapid-fire";
    }

    @Override
    public String getAbilityDescription() {
        return "Shoots a Jerry bullet, dealing "+ChatColor.RED+"500+ "+ ChatColor.GRAY +"damage on impact and knocking you back.";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
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

    @Override
    public void onAbilityUse(Player player, SItem sItem) {
        JerryChineGunProjectile projectile = new JerryChineGunProjectile(player);
    }
}