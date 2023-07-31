package me.godspunky.skyblock.features.entity.dungeon.minibosses;

import me.godspunky.skyblock.features.entity.EntityFunction;
import me.godspunky.skyblock.features.entity.EntityStatistics;
import me.godspunky.skyblock.features.entity.SEntityEquipment;
import me.godspunky.skyblock.features.entity.ZombieStatistics;
import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;

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
