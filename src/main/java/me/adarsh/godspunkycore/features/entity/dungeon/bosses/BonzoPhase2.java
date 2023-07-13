package me.adarsh.godspunkycore.features.entity.dungeon.bosses;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.Dungeon.DungeonGenerator;
import me.adarsh.godspunkycore.features.entity.*;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;


public class BonzoPhase2 implements ZombieStatistics ,EntityStatistics, EntityFunction {


    @Override
    public String getEntityName() {
        return "✪ Bonzo ✪";
    }

    @Override
    public double getEntityMaxHealth() {
        return 250000.0;
    }

    @Override
    public double getDamageDealt() {
        return 1000.0;
    }

    @Override
    public List<EntityDrop> drops() {
        return Arrays.asList(new EntityDrop(SMaterial.BONZO_STAFF, EntityDropType.EXTRAORDINARILY_RARE, 0.02),
        new EntityDrop(SMaterial.BONZO_MASK, EntityDropType.EXTRAORDINARILY_RARE, 0.01));
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(SItem.of(SMaterial.BONZO_STAFF).getStack(),
                null,
                null,
                null,
                null);
    }

    @Override
    public double getXPDropped() {
        return 75.0;
    }
    @Override
    public double getMovementSpeed() {
        return 0.4;
    }

    @Override
    public void onDeath(SEntity sEntity, Entity killed, Entity damager) {
        Player player = (Player) damager;

        SUtil.delay( () -> player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&4[BOSS] &cBonzo: &fAlright, maybe I'm just weak after all..")) , 20);
        SUtil.delay( () -> player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&4[BOSS] &cBonzo: &fBut my masters are a lot stronger..")) , 40);
        SUtil.delay( () -> player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&4[BOSS] &cBonzo: &fJust you wait...")) , 60);

        if (player.getWorld().getName().startsWith("Dungeon_")) {
            // activate portal
            World f1 = player.getWorld();
            SUtil.setBlocks(new Location(f1,23,103,-7.5),new Location(f1,21,107,-7.5), Material.PORTAL, false);
        }

        if (!killed.getWorld().getName().startsWith("Dungeon_")) return;

    }
}

