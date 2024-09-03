package me.godspunky.skyblock.features.entity.dungeon.bosses;

import me.godspunky.skyblock.features.entity.EntityFunction;
import me.godspunky.skyblock.features.entity.EntityStatistics;
import me.godspunky.skyblock.features.entity.SEntityEquipment;
import me.godspunky.skyblock.features.entity.ZombieStatistics;
import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;

public class Scarf implements ZombieStatistics, EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "&cScarf";
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

