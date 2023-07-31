package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class LeapingSword implements ToolStatistics, MaterialFunction, Ability {
    @Override
    public int getBaseDamage() {
        return 150;
    }

    @Override
    public double getBaseStrength() {
        return 100;
    }

    @Override
    public double getBaseCritDamage() {
        return 0.25;
    }

    @Override
    public String getDisplayName() {
        return "Leaping Sword";
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
    public String getAbilityName() {
        return "Leap";
    }

    @Override
    public String getAbilityDescription() {
        return ChatColor.GRAY +"Jump into the air and deal "+ChatColor.RED+"350"+ChatColor.GRAY+" damage to nearby enemies upon landing on the ground. Damaged enemies will also be frozen for"+ChatColor.GREEN+" 1.0 "+ChatColor.GRAY+"second.";
    }

    @Override
    public void onAbilityUse(Player player, SItem sItem) {
        player.setVelocity(player.getLocation().getDirection().multiply(3).setY(2));
        new BukkitRunnable() {
            @Override
            public void run() {
                if (player.getLocation().subtract(0, 0.5, 0).getBlock().getType() == Material.AIR) return;
                player.getWorld().playSound(player.getLocation(), Sound.EXPLODE, 2f, 1f);
                player.playEffect(player.getLocation(), Effect.EXPLOSION_LARGE, Effect.EXPLOSION_LARGE.getData());
                //for (Entity entity : player.getNearbyEntities(5, 5, 5))
                //    entity.
                this.cancel();
            }
        }.runTaskTimer(Skyblock.getPlugin(), 10, 2);
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 20;
    }

    @Override
    public int getManaCost() {
        return 50;
    }
}