package me.adarsh.godspunkycore.features.entity.dungeon.bosses;

import me.adarsh.godspunkycore.features.Dungeon.DungeonGenerator;
import me.adarsh.godspunkycore.features.entity.*;
import me.adarsh.godspunkycore.features.entity.dungeon.Abilities.BonzoBossAbility;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.features.item.weapon.Abilites.bonzo.BonzoStaffProjectile;
import me.adarsh.godspunkycore.user.User;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.EntityZombie;
import net.minecraft.server.v1_8_R3.PathfinderGoalAvoidTarget;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class Bonzo extends EntityZombie implements ZombieStatistics ,EntityStatistics, EntityFunction {
    public Bonzo(World world) {
        super(world);
    }

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
    public void onSpawn(LivingEntity entity, SEntity sEntity) {
        initPathfinder();
    }

    @Override
    public void onDeath(SEntity sEntity, Entity killed, Entity damager) {
        if (!killed.getWorld().getName().startsWith("Dungeon_")) return;
        Player player = (Player) damager;
        User user = User.getUser(player.getUniqueId());
        player.teleport(new Location(Bukkit.getWorld("islands"), user.getIslandX() , 100 , user.getIslandZ()));
        DungeonGenerator generator = new DungeonGenerator();
        generator.deleteDungeon(player);
        player.sendMessage("Dungeon Finished");
    }

    public void initPathfinder() {
        this.goalSelector.a(0, new PathfinderGoalAvoidTarget<EntityPlayer>(this, EntityPlayer.class, 45, 1.0D, 1.0D));
    }



}

