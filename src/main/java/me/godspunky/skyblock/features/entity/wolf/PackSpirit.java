package me.godspunky.skyblock.features.entity.wolf;

import me.godspunky.skyblock.features.entity.EntityDrop;
import me.godspunky.skyblock.features.entity.EntityDropType;
import me.godspunky.skyblock.features.item.SMaterial;

import java.util.Arrays;
import java.util.List;

public class PackSpirit extends BaseWolf {
    @Override
    public String getEntityName() {
        return "Pack Spirit";
    }

    @Override
    public double getEntityMaxHealth() {
        return 6000.0;
    }

    @Override
    public double getDamageDealt() {
        return 270.0;
    }

    @Override
    public List<EntityDrop> drops() {
        return Arrays.asList(new EntityDrop(SMaterial.BONE, EntityDropType.COMMON, 0.5),
                new EntityDrop(SMaterial.OAK_WOOD, EntityDropType.COMMON, 0.1),
                new EntityDrop(SMaterial.BIRCH_WOOD, EntityDropType.COMMON, 0.1));
    }

    public double getXPDropped() {
        return 15.0;
    }

    @Override
    public boolean isAngry() {
        return true;
    }
}