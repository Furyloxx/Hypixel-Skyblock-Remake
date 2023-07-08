package me.adarsh.godspunkycore.features.entity.dungeon.bosses;

import com.google.common.util.concurrent.AtomicDouble;
import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.entity.*;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class BonzoPhase1 implements ZombieStatistics, EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "Bonzo";
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
    public double getXPDropped() {
        return 75.0;
    }
    @Override
    public double getMovementSpeed() {
        return 0.3;
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
            player.playEffect(damager.getLocation(),Effect.EXPLOSION_HUGE,2);
            sEntity = new SEntity(damager.getLocation() , type);
        }
    }


    @Override
    public void onDeath(SEntity sEntity, Entity killed, Entity damager) {
        Player player = (Player) damager;

        SUtil.delay( () -> player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&4[BOSS] &cBonzo: &fOh I'm dead!")) , 10);
        SUtil.delay( () -> player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&4[BOSS] &cBonzo: &fSike!")) , 40);

        SEntityType type = SEntityType.BONZO_PHASE_2;
        player.playEffect(damager.getLocation(),Effect.EXPLOSION_HUGE,2);

        // TODO: ADD SOME WAIT TIME HERE FOR BONZO PHASE 2 TO SPAWN
        new BukkitRunnable(){
            @Override
            public void run() {
                SEntity sEntity = new SEntity(damager.getLocation() , type);
                cancel();
            }
        }.runTaskLater(Skyblock.getPlugin(), 100L);

    }

}
