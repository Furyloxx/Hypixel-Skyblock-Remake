package me.adarsh.godspunkycore.entity.wolf;

import me.adarsh.godspunkycore.entity.EntityDrop;
import me.adarsh.godspunkycore.entity.EntityDropType;
import me.adarsh.godspunkycore.item.SMaterial;

import java.util.Collections;
import java.util.List;

public class PackEnforcer extends BaseWolf
{
    @Override
    public String getEntityName()
    {
        return "Pack Enforcer";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 45000.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 900.0;
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Collections.singletonList(new EntityDrop(SMaterial.WOLF_TOOTH, EntityDropType.GUARANTEED, 1.0));
    }

    public double getXPDropped()
    {
        return 150.0;
    }

    @Override
    public boolean isAngry()
    {
        return true;
    }
}