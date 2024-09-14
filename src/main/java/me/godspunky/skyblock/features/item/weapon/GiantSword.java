package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.item.*;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.EnumSet;
import java.util.Set;

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
        return "Slam your sword into the ground dealing" + ChatColor.RED + " 100,000 " + ChatColor.GRAY + "damage to nearby enemies.";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public void onAbilityUse(Player p, SItem sItem) {
        // Use EnumSet to specify the blocks that can be targeted (in this case, none are ignored)
        Set<Material> ignoredBlocks = EnumSet.noneOf(Material.class);
        Location loc = p.getTargetBlock(ignoredBlocks, 100).getLocation();

        // Create a sword for the giant to hold
        ItemStack sword = new ItemStack(Material.IRON_SWORD);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);

        // Adjust the spawn location to account for the giant's height
        loc.setY(loc.getY() - 2);

        // Spawn an invisible, damage-resistant giant holding the sword
        Giant giant = loc.getWorld().spawn(loc, Giant.class);
        giant.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 999));
        giant.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 999));
        giant.setCustomName("Dinnerbone");
        giant.setCustomNameVisible(false);
        giant.getEquipment().setItemInHand(sword);
        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 10.0f, 0.0f);
        p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, 0.9f, 0.35f);

        // Spawn an armor stand to hold the giant
        ArmorStand holder = loc.getWorld().spawn(loc, ArmorStand.class);
        holder.setGravity(true);
        holder.setVisible(false);
        holder.setCustomName(" ");
        holder.setCustomNameVisible(false);
        holder.setPassenger(giant);

        // Deal damage to nearby entities (radius 5)
        AbilityDamage.DamageNearByEntity(p, 5);

        // Schedule the removal of the giant and armor stand after 4 seconds (80 ticks)
        new BukkitRunnable() {
            @Override
            public void run() {
                Location killLoc = loc;
                killLoc.setY(0); // Move the location to the ground
                holder.teleport(killLoc);
                giant.teleport(killLoc);
                holder.remove();
                giant.remove();
            }
        }.runTaskLater(Skyblock.getPlugin(), 80);
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
