package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.*;
import org.bukkit.scheduler.BukkitRunnable;

public class GolemSword implements ToolStatistics, MaterialFunction, Ability, PlayerBoostStatistics {
    @Override
    public String getAbilityName() {
        return "Iron Punch";
    }

    @Override
    public String getAbilityDescription() {
        return "Punch the ground, damaging enemies in a hexagon around you for"+ChatColor.GREEN+" 460 "+ ChatColor.GRAY +"base Magic Damage.";
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 3;
    }

    @Override
    public int getManaCost() {
        return 70;
    }

    @Override
    public String getDisplayName() {
        return "Golem Sword";
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
    public int getBaseDamage() {
        return 80;
    }

    @Override
    public double getBaseStrength() {
        return 125;
    }

    @Override
    public double getBaseDefense() {
        return 25;
    }

    @Override
    public void onAbilityUse(Player p, SItem sItem) {
        Location loc = p.getLocation();
        Location Block1loc = new Location(loc.getWorld(), loc.getX() + 4, loc.getY() + 10, loc.getZ());
        Location Block2loc = new Location(loc.getWorld(), loc.getX() + 4, loc.getY() + 10, loc.getZ() - 1);
        Location Block3loc = new Location(loc.getWorld(), loc.getX() + 4, loc.getY() + 10, loc.getZ() + 1);
        Location Block4loc = new Location(loc.getWorld(), loc.getX() + 2, loc.getY() + 10, loc.getZ() + 3);
        Location Block5loc = new Location(loc.getWorld(), loc.getX(), loc.getY() + 10, loc.getZ() + 4);
        Location Block6loc = new Location(loc.getWorld(), loc.getX() - 2, loc.getY() + 10, loc.getZ() + 3);
        Location Block7loc = new Location(loc.getWorld(), loc.getX() - 4, loc.getY() + 10, loc.getZ() + 1);
        Location Block8loc = new Location(loc.getWorld(), loc.getX() - 4, loc.getY() + 10, loc.getZ());
        Location Block9loc = new Location(loc.getWorld(), loc.getX() - 4, loc.getY() + 10, loc.getZ() - 1);
        Location Block10loc = new Location(loc.getWorld(), loc.getX() - 2, loc.getY() + 10, loc.getZ() - 3);
        Location Block11loc = new Location(loc.getWorld(), loc.getX(), loc.getY() + 10, loc.getZ() - 4);
        Location Block12loc = new Location(loc.getWorld(), loc.getX() + 2, loc.getY() + 10, loc.getZ() - 3);


        FallingBlock Block1 = p.getWorld().spawnFallingBlock(Block1loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block2 = p.getWorld().spawnFallingBlock(Block2loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block3 = p.getWorld().spawnFallingBlock(Block3loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block4 = p.getWorld().spawnFallingBlock(Block4loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block5 = p.getWorld().spawnFallingBlock(Block5loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block6 = p.getWorld().spawnFallingBlock(Block6loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block7 = p.getWorld().spawnFallingBlock(Block7loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block8 = p.getWorld().spawnFallingBlock(Block8loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block9 = p.getWorld().spawnFallingBlock(Block9loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block10 = p.getWorld().spawnFallingBlock(Block10loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block11 = p.getWorld().spawnFallingBlock(Block11loc, Material.IRON_BLOCK, (byte) 0);
        FallingBlock Block12 = p.getWorld().spawnFallingBlock(Block12loc, Material.IRON_BLOCK, (byte) 0);
        ((CraftEntity) Block1).getHandle().noclip = true;
        ((CraftEntity) Block2).getHandle().noclip = true;
        ((CraftEntity) Block3).getHandle().noclip = true;
        ((CraftEntity) Block4).getHandle().noclip = true;
        ((CraftEntity) Block5).getHandle().noclip = true;
        ((CraftEntity) Block6).getHandle().noclip = true;
        ((CraftEntity) Block7).getHandle().noclip = true;
        ((CraftEntity) Block8).getHandle().noclip = true;
        ((CraftEntity) Block9).getHandle().noclip = true;
        ((CraftEntity) Block10).getHandle().noclip = true;
        ((CraftEntity) Block11).getHandle().noclip = true;
        ((CraftEntity) Block12).getHandle().noclip = true;

        for (Entity entity : p.getWorld().getNearbyEntities(p.getLocation().add(p.getLocation().getDirection().multiply(3.0)), 3.0, 3.0, 3.0)) {
            if (!(entity instanceof LivingEntity)) continue;
            if (entity instanceof Player || entity instanceof EnderDragon || entity instanceof EnderDragonPart)
                continue;
            User user = User.getUser(p.getUniqueId());
            user.damageEntity((LivingEntity) entity, 255.0);
        }

        new BukkitRunnable() {
            @Override
            public void run() {
                Block1.remove();
                Block2.remove();
                Block3.remove();
                Block4.remove();
                Block5.remove();
                Block6.remove();
                Block7.remove();
                Block8.remove();
                Block9.remove();
                Block10.remove();
                Block11.remove();
                Block12.remove();
                Block1loc.setY(Block1loc.getY() - 9.5);
                Block2loc.setY(Block2loc.getY() - 9.5);
                Block3loc.setY(Block3loc.getY() - 9.5);
                Block4loc.setY(Block4loc.getY() - 9.5);
                Block5loc.setY(Block5loc.getY() - 9.5);
                Block6loc.setY(Block6loc.getY() - 9.5);
                Block7loc.setY(Block7loc.getY() - 9.5);
                Block8loc.setY(Block8loc.getY() - 9.5);
                Block9loc.setY(Block9loc.getY() - 9.5);
                Block10loc.setY(Block10loc.getY() - 9.5);
                Block11loc.setY(Block11loc.getY() - 9.5);
                Block12loc.setY(Block12loc.getY() - 9.5);


            }
        }.runTaskLater(Skyblock.getPlugin(), 25);
    }
}
