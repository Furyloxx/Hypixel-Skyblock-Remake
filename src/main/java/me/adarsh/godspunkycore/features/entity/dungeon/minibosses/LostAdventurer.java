package me.adarsh.godspunkycore.features.entity.dungeon.minibosses;

import me.adarsh.godspunkycore.features.entity.*;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

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
        SEntityType type = SEntityType.SHADOW_ASSASSIN;
        World world = damager.getWorld();// and now finding something to do ;-;
        Location loc = new Location(world, 111,69,142);
        sEntity = new SEntity(loc , type);
    }
}
