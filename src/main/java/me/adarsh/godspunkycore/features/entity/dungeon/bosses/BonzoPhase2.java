package me.adarsh.godspunkycore.features.entity.dungeon.bosses;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.Dungeon.DungeonGenerator;
import me.adarsh.godspunkycore.features.entity.*;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.user.PlayerUtils;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.CC;
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
        SUtil.delay( () -> player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&4[BOSS] &cBonzo: &fJust you wait...")) , 10);

        if (player.getWorld().getName().startsWith("Dungeon_")) {
            // activate portal
            World f1 = player.getWorld();
            SUtil.setBlocks(new Location(f1,23,103,-7.5),new Location(f1,21,107,-7.5), Material.PORTAL, false);
        }

        World world = player.getWorld();

        DungeonGenerator.sendReMsg(true, world, player);

        player.sendMessage(CC.translate("&e"));
        player.sendMessage(CC.translate("&aThis demo floor currently in development so you can't respawn or get reward yet, sorry! We will update later on, leave rating of this boss on #server-rating, thank you."));
        player.sendMessage(CC.translate("&e"));
        SUtil.delay(() -> player.sendMessage(CC.translate("&c[Warning] &eThis dungeon will close in &c5s")), 200L);
        SUtil.delay(() -> player.sendMessage(CC.translate("&c[Warning] &eThis dungeon will close in &c4s")), 220L);
        SUtil.delay(() -> player.sendMessage(CC.translate("&c[Warning] &eThis dungeon will close in &c3s")), 240L);
        SUtil.delay(() -> player.sendMessage(CC.translate("&c[Warning] &eThis dungeon will close in &c2s")), 260L);
        SUtil.delay(() -> player.sendMessage(CC.translate("&c[Warning] &eThis dungeon will close in &c1s")), 280L);
        SUtil.delay(() -> player.sendMessage(CC.translate("&c[Warning] &eWarping you back to the Hub")), 300L);

        if (!killed.getWorld().getName().startsWith("Dungeon_")) return;

        SUtil.delay( () -> player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&4[BOSS] &cBonzo: &fI will come back once again")) , 200);
        DungeonGenerator.deleteDungeon(player);

    }
}

