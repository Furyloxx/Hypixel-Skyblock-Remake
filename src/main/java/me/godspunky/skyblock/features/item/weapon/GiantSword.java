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
        return "Slam your sword into the ground dealing"+ChatColor.RED+" 100,000 "+ChatColor.GRAY+"damage to nearby enemies.";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public void onAbilityUse(Player p, SItem sItem) {
        Location loc = player.getTargetBlock((Set)null, 6).getLocation();
        ItemStack sword = new ItemStack(Material.IRON_SWORD);
        sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
        loc.setY(loc.getY() - 2);
        Giant giant = loc.getWorld().spawn(loc, Giant.class);
        giant.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 2147483647, 999));
        giant.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2147483647, 999));
        giant.setCustomName("Dinnerbone");
        giant.setCustomNameVisible(false);
        giant.getEquipment().setItemInHand(sword);
        ArmorStand holder = loc.getWorld().spawn(loc, ArmorStand.class);
        holder.setGravity(true);
        holder.setVisible(false);
        holder.setCustomName(" ");
        holder.setCustomNameVisible(false);
        holder.setPassenger(giant);
        AbilityDamage.DamageNearByEntity(p , 5);
        new BukkitRunnable() {
            @Override
            public void run() {
                Location killloc = loc;
                killloc.setY(0);
                holder.teleport(loc);
                giant.teleport(loc);
                holder.remove();
                giant.remove();
        getPlayer.playSound(player.getLocation(), Sound.ANVIL_LAND, 10.0f, 0.0f);
        getPlayer.playSound(player.getLocation(), Sound.AMBIENCE_THUNDER, 0.9f, 0.35f);
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