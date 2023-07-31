package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class EmberRod implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public int getAbilityCooldownTicks() {
        return 600;
    }

    @Override
    public int getManaCost() {
        return 150;
    }

    @Override
    public String getAbilityName() {
        return "Fire Blast";
    }

    @Override
    public String getAbilityDescription() {
        return ChatColor.GRAY+"Shoot 3 Fireballs which deal"+ ChatColor.RED +" 30 "+ChatColor.GRAY+"damage in rapid succession in front of you!";
    }

    @Override
    public void onAbilityUse(Player player, SItem sItem) {
        Vector direction = player.getLocation().getDirection();
        for (int i = 0; i < 4; i++) {
            Fireball fireball = player.getWorld().spawn(player.getEyeLocation().add(direction), Fireball.class);
            fireball.setVelocity(direction.multiply(0.2));
        }
    }

    @Override
    public int getBaseDamage() {
        return 80;
    }

    @Override
    public double getBaseStrength() {
        return 35;
    }

    @Override
    public String getDisplayName() {
        return "Ember Rod";
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
    public double getBaseIntelligence() {
        return 50;
    }
}