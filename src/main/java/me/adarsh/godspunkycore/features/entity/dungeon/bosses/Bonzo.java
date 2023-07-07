package me.adarsh.godspunkycore.features.entity.dungeon.bosses;

import com.google.common.util.concurrent.AtomicDouble;
import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.Dungeon.DungeonGenerator;
import me.adarsh.godspunkycore.features.entity.*;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Bonzo implements ZombieStatistics ,EntityStatistics, EntityFunction {
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
    public void onDamage(SEntity sEntity, Entity damager, EntityDamageByEntityEvent e, AtomicDouble damage) {
        Player player = (Player) damager;

        Random random = new Random();
        double probability = 0.15;
        if (random.nextDouble() <= probability) {
            SUtil.delay(() -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[BOSS] &cBonzo: &fYou're not funny.")), 10);
        }
        Random random1 = new Random();
        double probability1 = 0.14;
        if (random.nextDouble() <= probability1) {
            SUtil.delay(() -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[BOSS] &cBonzo: &fStop.")), 20);
        }

        Random random2 = new Random();
        double probability2 = 0.13;
        if (random.nextDouble() <= probability2) {
            SUtil.delay(() -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[BOSS] &cBonzo: &fGive me 1 sec...")), 30);
        }

        Random random3 = new Random();
        double probability3 = 0.12;
        if (random.nextDouble() <= probability3) {
            SUtil.delay(() -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[BOSS] &cBonzo: &fNot fair!")), 40);
        }

        Random random4 = new Random();
        double probability4 = 0.1;
        if (random.nextDouble() <= probability4) {
            SUtil.delay(() -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[BOSS] &cBonzo: &fWhy are you running?")), 50);
        }

        Random random5 = new Random();
        double probability5 = 0.11;
        if (random5.nextDouble() <= probability5){
            SUtil.delay(() -> player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4[BOSS] &cBonzo: &fFight my Undeads instead.")), 60);
            SEntityType type = SEntityType.UNDEAD;
            sEntity = new SEntity(damager.getLocation() , type);
        }
    }

    @Override
    public void onDeath(SEntity sEntity, Entity killed, Entity damager) {
        Player player = (Player) damager;

        SUtil.delay( () -> player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&4[BOSS] &cBonzo: &fAlright, maybe I'm just weak after all..")) , 20);
        SUtil.delay( () -> player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&4[BOSS] &cBonzo: &fBut my masters are a lot stronger..")) , 40);
        SUtil.delay( () -> player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&4[BOSS] &cBonzo: &fJust you wait...")) , 60);

        if (!killed.getWorld().getName().startsWith("Dungeon_")) return;

        User user = User.getUser(player.getUniqueId());
        SUtil.delay( () -> player.teleport(new Location(Bukkit.getWorld("islands"), user.getIslandX() , 100 , user.getIslandZ())) , 200);
        DungeonGenerator generator = new DungeonGenerator();
        generator.deleteDungeon(player);
    }

}

