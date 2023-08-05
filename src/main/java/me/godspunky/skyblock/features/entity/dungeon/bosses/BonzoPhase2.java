package me.godspunky.skyblock.features.entity.dungeon.bosses;

import me.godspunky.skyblock.features.Dungeon.DungeonGenerator;
import me.godspunky.skyblock.features.entity.*;
import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;
import me.godspunky.skyblock.util.SUtil;
import me.godspunky.skyblock.util.SkullMaker;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;


public class BonzoPhase2 implements ZombieStatistics, EntityStatistics, EntityFunction {


    @Override
    public String getEntityName() {
        return "✪ Bonzo ✪";
    }

    @Override
    public double getEntityMaxHealth() {
        return 750000.0;
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

        World w = player.getWorld();

        SUtil.delay( () -> SUtil.broadcastWorld(ChatColor.translateAlternateColorCodes('&',"&4[BOSS] &cBonzo: &fAlright, maybe I'm just weak after all.."),  w) , 20);
        SUtil.delay( () -> SUtil.broadcastWorld(ChatColor.translateAlternateColorCodes('&',"&4[BOSS] &cBonzo: &fBut my masters are a lot stronger.."),  w) , 40);
        SUtil.delay( () -> SUtil.broadcastWorld(ChatColor.translateAlternateColorCodes('&',"&4[BOSS] &cBonzo: &fJust you wait..."),  w) , 60);


        if (player.getWorld().getName().startsWith("f1_")) {
            // activate portal
            World f1 = player.getWorld();
            SUtil.setBlocks(new Location(f1,112,81,243), new Location(f1,110,85,243), Material.PORTAL, false);
        }

        SUtil.delay(() -> DungeonGenerator.sendReMsg(true, killed.getWorld()), 30L);
        SUtil.delay(() -> damager.sendMessage(ChatColor.YELLOW+"Dungeon will be closed in"+ChatColor.GREEN+ " 60s!"), 40L);
        SUtil.delay(() -> DungeonGenerator.endRoom2(killed.getWorld()), 1240L);
    }
}

