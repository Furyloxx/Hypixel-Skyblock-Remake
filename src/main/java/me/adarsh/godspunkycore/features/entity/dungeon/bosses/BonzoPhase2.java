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
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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

        if (!killed.getWorld().getName().startsWith("Dungeon_")) return;

        User user = User.getUser(player.getUniqueId());

        int x = Skyblock.getPlugin().getConfig().getInt("dhub.x");
        int y = Skyblock.getPlugin().getConfig().getInt("dhub.y");
        int z = Skyblock.getPlugin().getConfig().getInt("dhub.z");
        int yaw = Skyblock.getPlugin().getConfig().getInt("dhub.yaw");
        int pitch = Skyblock.getPlugin().getConfig().getInt("dhub.pitch");
        World dhub = Bukkit.getWorld(Skyblock.getPlugin().getConfig().getString("dhub.world"));

        SUtil.delay( () -> player.teleport(new Location(dhub, x, y, z, yaw, pitch)) , 200);
        DungeonGenerator generator = new DungeonGenerator();
        generator.deleteDungeon(player);
    }

}

