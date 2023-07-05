package me.adarsh.godspunkycore.features.entity.dungeon.minibosses;

import me.adarsh.godspunkycore.features.entity.EntityFunction;
import me.adarsh.godspunkycore.features.entity.EntityStatistics;
import me.adarsh.godspunkycore.features.entity.SEntityEquipment;
import me.adarsh.godspunkycore.features.entity.ZombieStatistics;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;

public class AngryArchaeologist implements ZombieStatistics, EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "Angry Archaeologist";
    }

    @Override
    public double getEntityMaxHealth() {
        return 9500;
    }

    @Override
    public double getDamageDealt() {
        return 320;
    }

    @Override
    public double getXPDropped() {
        return 100;
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(SItem.of(SMaterial.ASPECT_OF_THE_DRAGONS).getStack(),
                SItem.of(SMaterial.HARDENED_DIAMOND_HELMET).getStack(),
                SItem.of(SMaterial.HARDENED_DIAMOND_CHESTPLATE).getStack(),
                SItem.of(SMaterial.HARDENED_DIAMOND_LEGGINGS).getStack(),
                SItem.of(SMaterial.HARDENED_DIAMOND_BOOTS).getStack()
        );
    }

    @Override
    public double getMovementSpeed() {
        return 0.4;
    }
}
