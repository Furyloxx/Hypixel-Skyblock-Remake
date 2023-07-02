package me.adarsh.godspunkycore.features.entity.dungeon;

import me.adarsh.godspunkycore.features.entity.EntityFunction;
import me.adarsh.godspunkycore.features.entity.EntityStatistics;
import me.adarsh.godspunkycore.features.entity.SEntityEquipment;
import me.adarsh.godspunkycore.features.entity.ZombieStatistics;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;

public class TheProfessor implements ZombieStatistics, EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "✪ The Professor ✪";
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
    public double getEntityMaxHealth() {
        return 3000000.0;
    }

    @Override
    public double getDamageDealt() {
        return 6640.0;
    }


    @Override
    public double getXPDropped() {
        return 150.0;
    }
}

