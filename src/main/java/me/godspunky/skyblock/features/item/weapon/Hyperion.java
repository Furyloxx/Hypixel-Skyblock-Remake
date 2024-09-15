package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.item.*;
import net.minecraft.server.v1_8_R3.EntityHuman;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftHumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;

public class Hyperion implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public int getBaseDamage() {
        return 260;
    }

    @Override
    public double getBaseStrength() {
        return 150;
    }

    @Override
    public String getDisplayName() {
        return "Hyperion";
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
        return "";
    }

    @Override
    public double getBaseIntelligence() {
        return 350;
    }

    @Override
    public String getAbilityName() {
        return "wither impact";
    }

    @Override
    public String getAbilityDescription() {
        return ChatColor.GRAY+"Deals"+ChatColor.GREEN+" +50% "+ChatColor.GRAY+"damage to withers. Grants "+ChatColor.RED+"+1 damage "+ChatColor.GRAY+"and"+ChatColor.GREEN+" +2 "+ChatColor.AQUA+"intelligence"+ChatColor.GRAY+" per "+ChatColor.RED+"Catacombs"+ChatColor.GRAY+" level.";
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 0;
    }

    @Override
    public void onAbilityUse(Player p, SItem sItem) {
        Location loc = p.getLocation();
        HashSet<Byte> hashSet = new HashSet<>();
        hashSet.add((byte) 0);
        Block block = p.getTargetBlock(hashSet, 8);
        Location playerLocation = p.getLocation();
        Location teleportLocation = new Location(block.getWorld(), block.getX(), block.getY(), block.getZ(), playerLocation.getYaw(), playerLocation.getPitch());
          p.getWorld().playSound(p.getLocation Sound.EXPLODE, 0.4f, 1.2f);
        if (teleportLocation.getBlock().getType() != Material.AIR) {
            teleportLocation.setY(teleportLocation.getY() + 1.0D);
        }

        if (new Location(teleportLocation.getWorld(), teleportLocation.getX(), teleportLocation.getY() + 1.0D, teleportLocation.getZ()).getBlock().getType() == Material.AIR && p.getLocation().add(p.getLocation().getDirection()).getBlock().getType() == Material.AIR) {
            teleportLocation.setX(teleportLocation.getX() - 0.5D);
            teleportLocation.setZ(teleportLocation.getZ() - 0.5D);
        } else {
            teleportLocation.setX(teleportLocation.getX() + 0.5D);
            teleportLocation.setZ(teleportLocation.getZ() + 0.5D);
        }
        p.teleport(teleportLocation);
        EntityHuman human = ((CraftHumanEntity) p).getHandle();
        human.setAbsorptionHearts(10);


        AbilityDamage.DamageNearByEntity(p , 5 , teleportLocation);
        new BukkitRunnable() {
            @Override
            public void run() {
                human.setAbsorptionHearts(0);
            }
        }.runTaskLater(Skyblock.getPlugin(), 100);
    }



    @Override
    public int getManaCost() {
        return 100;
    }
}
