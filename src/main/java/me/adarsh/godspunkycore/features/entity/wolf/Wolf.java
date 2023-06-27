package me.adarsh.godspunkycore.features.entity.wolf;

import me.adarsh.godspunkycore.features.entity.EntityDrop;
import me.adarsh.godspunkycore.features.entity.EntityDropType;
import me.adarsh.godspunkycore.features.item.SMaterial;

import java.util.Collections;
import java.util.List;

public class Wolf extends BaseWolf {
    @Override
    public String getEntityName() {
        return "Wolf";
    }

    @Override
    public double getEntityMaxHealth() {
        return 250.0;
    }

    @Override
    public double getDamageDealt() {
        return 80.0;
    }

    @Override
    public List<EntityDrop> drops() {
        return Collections.singletonList(new EntityDrop(SMaterial.BONE, EntityDropType.GUARANTEED, 1.0));
    }

    public double getXPDropped() {
        return 10.0;
    }

    @Override
    public boolean isAngry() {
        return true;
    }
}