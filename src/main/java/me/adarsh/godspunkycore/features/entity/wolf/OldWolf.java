package me.adarsh.godspunkycore.features.entity.wolf;

import me.adarsh.godspunkycore.features.entity.EntityDrop;
import me.adarsh.godspunkycore.features.entity.EntityDropType;
import me.adarsh.godspunkycore.features.item.SMaterial;

import java.util.Collections;
import java.util.List;

public class OldWolf extends BaseWolf {
    @Override
    public String getEntityName() {
        return "Old Wolf";
    }

    @Override
    public double getEntityMaxHealth() {
        return 15000.0;
    }

    @Override
    public double getDamageDealt() {
        return 720.0;
    }

    @Override
    public List<EntityDrop> drops() {
        return Collections.singletonList(new EntityDrop(SMaterial.BONE, EntityDropType.GUARANTEED, 1.0));
    }

    public double getXPDropped() {
        return 40.0;
    }

    @Override
    public boolean isAngry() {
        return true;
    }
}