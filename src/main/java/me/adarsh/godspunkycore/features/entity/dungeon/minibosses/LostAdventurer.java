package me.adarsh.godspunkycore.features.entity.dungeon.minibosses;

import me.adarsh.godspunkycore.features.Dungeon.DungeonGenerator;
import me.adarsh.godspunkycore.features.entity.*;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.user.User;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class LostAdventurer implements ZombieStatistics, EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "Lost Adventurer";
    }

    @Override
    public double getEntityMaxHealth() {
        return 60000;
    }

    @Override
    public double getDamageDealt() {
        return 360;
    }

    @Override
    public double getXPDropped() {
        return 100;
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(SItem.of(SMaterial.ASPECT_OF_THE_DRAGONS).getStack(),
                SItem.of(SMaterial.SUPERIOR_DRAGON_HELMET).getStack(),
                SItem.of(SMaterial.SUPERIOR_DRAGON_CHESTPLATE).getStack(),
                SItem.of(SMaterial.SUPERIOR_DRAGON_LEGGINGS).getStack(),
                SItem.of(SMaterial.SUPERIOR_DRAGON_BOOTS).getStack()
        );
    }

    @Override
    public double getMovementSpeed() {
        return 0.4;
    }

    @Override
    public void onDeath(SEntity sEntity, Entity killed, Entity damager) {
        SEntityType type = SEntityType.BONZO_PHASE_1;
        World world = damager.getWorld();
        Location loc = new Location(world, 5,67,13);
        sEntity = new SEntity(loc , type);
        damager.sendMessage(ChatColor.translateAlternateColorCodes('&',"&4[BOSS] &cBonzo: &fYou little brat!!"));
    }
}
