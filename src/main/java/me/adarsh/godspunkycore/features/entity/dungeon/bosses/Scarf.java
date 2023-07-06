package me.adarsh.godspunkycore.features.entity.dungeon.bosses;

import me.adarsh.godspunkycore.features.entity.EntityFunction;
import me.adarsh.godspunkycore.features.entity.EntityStatistics;
import me.adarsh.godspunkycore.features.entity.SEntityEquipment;
import me.adarsh.godspunkycore.features.entity.ZombieStatistics;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;

public class Scarf implements ZombieStatistics, EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "✪ Scarf ✪";
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
        return 1000000.0;
    }

    @Override
    public double getDamageDealt() {
        return 3840.0;
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(SItem.of(SMaterial.NETHER_STAR).getStack(),
                null,
                null,
                null,
                null);
    }

    @Override
    public double getXPDropped() {
        return 125.0;
    }
    @Override
    public double getMovementSpeed() {
        return 0.4;
    }
}

