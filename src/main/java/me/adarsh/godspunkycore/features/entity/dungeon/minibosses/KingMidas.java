package me.adarsh.godspunkycore.features.entity.dungeon.minibosses;

import me.adarsh.godspunkycore.features.entity.EntityFunction;
import me.adarsh.godspunkycore.features.entity.EntityStatistics;
import me.adarsh.godspunkycore.features.entity.SEntityEquipment;
import me.adarsh.godspunkycore.features.entity.ZombieStatistics;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;

public class KingMidas implements ZombieStatistics, EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "King Midas";
    }

    @Override
    public double getEntityMaxHealth() {
        return 300000;
    }

    @Override
    public double getDamageDealt() {
        return 3760;
    }

    @Override
    public double getXPDropped() {
        return 125;
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(SItem.of(SMaterial.GOLD_SWORD).getStack(),
                SItem.of(SMaterial.GOLDEN_HELMET).getStack(),
                SItem.of(SMaterial.GOLDEN_CHESTPLATE).getStack(),
                SItem.of(SMaterial.GOLDEN_LEGGINGS).getStack(),
                SItem.of(SMaterial.GOLDEN_BOOTS).getStack()
        );
    }

    @Override
    public double getMovementSpeed() {
        return 0.4;
    }
}