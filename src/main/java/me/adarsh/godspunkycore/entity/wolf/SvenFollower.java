package me.adarsh.godspunkycore.entity.wolf;

import me.adarsh.godspunkycore.entity.EntityDrop;
import me.adarsh.godspunkycore.entity.EntityDropType;
import me.adarsh.godspunkycore.item.SItem;
import me.adarsh.godspunkycore.item.SMaterial;
import me.adarsh.godspunkycore.util.SUtil;

import java.util.Collections;
import java.util.List;

public class SvenFollower extends BaseWolf
{
    @Override
    public String getEntityName()
    {
        return "Pack Enforcer";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 120000.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 1100.0;
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Collections.singletonList(new EntityDrop(SUtil.setStackAmount(SItem.of(SMaterial.WOLF_TOOTH).getStack(), 2), EntityDropType.GUARANTEED, 1.0));
    }

    public double getXPDropped()
    {
        return 250.0;
    }

    @Override
    public boolean isAngry()
    {
        return true;
    }
}