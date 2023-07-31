package me.godspunky.skyblock.features.entity.dungeon.bosses;

import me.godspunky.skyblock.features.entity.*;
import me.godspunky.skyblock.features.item.SMaterial;

import java.util.Arrays;
import java.util.List;

public class Livid implements ZombieStatistics, EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "✪ Livid ✪";
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
    public List<EntityDrop> drops() {
        return Arrays.asList(new EntityDrop(SMaterial.SHADOW_ASSASSIN_HELMET, EntityDropType.EXTRAORDINARILY_RARE, 0.87),
                new EntityDrop(SMaterial.SHADOW_ASSASSIN_CHESTPLATE, EntityDropType.EXTRAORDINARILY_RARE, 0.87),
                new EntityDrop(SMaterial.SHADOW_ASSASSIN_LEGGINGS, EntityDropType.EXTRAORDINARILY_RARE, 0.87),
                new EntityDrop(SMaterial.SHADOW_ASSASSIN_BOOTS, EntityDropType.EXTRAORDINARILY_RARE, 0.87));
    }

    @Override
    public double getEntityMaxHealth() {
        return 7000000.0;
    }

    @Override
    public double getDamageDealt() {
        return 10400.0;
    }


    @Override
    public double getXPDropped() {
        return 100.0;
    }
    @Override
    public double getMovementSpeed() {
        return 0.4;
    }
}


