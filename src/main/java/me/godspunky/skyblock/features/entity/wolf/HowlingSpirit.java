package me.godspunky.skyblock.features.entity.wolf;

import me.godspunky.skyblock.features.entity.EntityDrop;
import me.godspunky.skyblock.features.entity.EntityDropType;
import me.godspunky.skyblock.features.item.SMaterial;

import java.util.Arrays;
import java.util.List;

public class HowlingSpirit extends BaseWolf {
    @Override
    public String getEntityName() {
        return "Howling Spirit";
    }

    @Override
    public double getEntityMaxHealth() {
        return 7000.0;
    }

    @Override
    public double getDamageDealt() {
        return 450.0;
    }

    @Override
    public List<EntityDrop> drops() {
        return Arrays.asList(new EntityDrop(SMaterial.SPRUCE_WOOD, EntityDropType.COMMON, 0.25),
                new EntityDrop(SMaterial.DARK_OAK_WOOD, EntityDropType.COMMON, 0.25),
                new EntityDrop(SMaterial.ACACIA_WOOD, EntityDropType.COMMON, 0.25));
    }

    public double getXPDropped() {
        return 15.0;
    }

    @Override
    public boolean isAngry() {
        return true;
    }
}