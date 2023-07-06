package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.item.*;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class MidasStaff implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Midas's Staff";
    }

    @Override
    public int getBaseDamage() {
        return 130;
    }

    @Override
    public double getBaseStrength() {
        return 150;
    }

    @Override
    public double getBaseIntelligence() {
        return 50;
    }

    @Override
    public int getManaCost() {
        return 500;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 20;
    }

    @Override
    public String getAbilityName() {
        return "Molten Wave";
    }

    @Override
    public String getAbilityDescription() {
        return "Cast a wave of molten gold in the direction you are facing! Deals up to 6,000 - 32,000 damage.";
    }

    @Override
    public void onAbilityUse(Player p, SItem sItem) {
        Location loc = p.getLocation();
        World w = p.getWorld();
        loc.setY(loc.getY() + 3);
        new BukkitRunnable() {
            int i = 9;
            @Override
            public void run() {
                if (i > 0) {
                    Vector v = p.getLocation().getDirection().normalize();
                    double x = v.getX();
                    double z = v.getZ();
                    x = x * -1;
                    Vector newvec = new Vector(z, 0, x);
                    newvec.normalize().multiply(1);
                    v.normalize().multiply(1);
                    loc.add(v);
                    w.playEffect(loc, Effect.MOBSPAWNER_FLAMES, 0);
                    FallingBlock block = w.spawnFallingBlock(loc, Material.GOLD_BLOCK, (byte) 0);
                    ((CraftEntity) block).getHandle().noclip = true;
                    loc.add(newvec);
                    w.playEffect(loc, Effect.MOBSPAWNER_FLAMES, 0);
                    FallingBlock block2 = w.spawnFallingBlock(loc, Material.GOLD_BLOCK, (byte) 0);
                    ((CraftEntity) block2).getHandle().noclip = true;
                    loc.add(newvec.multiply(-2));
                    w.playEffect(loc, Effect.MOBSPAWNER_FLAMES, 0);
                    FallingBlock block3 = w.spawnFallingBlock(loc, Material.GOLD_BLOCK, (byte) 0);
                    ((CraftEntity) block3).getHandle().noclip = true;
                    loc.add(newvec.multiply(-0.5));
                      AbilityDamage.DamageNearByEntity(p , 1.5 , loc);
                } else {
                    cancel();
                }
                i-=1;
            }
        }.runTaskTimer(Skyblock.getPlugin(), 0, 2);
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