package me.adarsh.godspunkycore.features.entity.dungeon;

import me.adarsh.godspunkycore.features.entity.*;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;

import java.util.List;

public class Undead implements ZombieStatistics, EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "Crypt Undead";
    }

    @Override
    public boolean isBaby() {
        return false;
    }

    @Override
    public boolean isVillager() {
        return false;
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(SItem.of(SMaterial.BONE).getStack(),
                null,
                null,
                null,
                null);
    }

    @Override
    public double getEntityMaxHealth() {
        return 45000;
    }

    @Override
    public double getDamageDealt() {
        return 1040.0;
    }

    @Override
    public double getXPDropped() {
        return 30.0;
    }
}
