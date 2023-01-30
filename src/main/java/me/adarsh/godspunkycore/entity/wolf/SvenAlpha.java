package me.adarsh.godspunkycore.entity.wolf;

import me.adarsh.godspunkycore.entity.EntityDrop;
import me.adarsh.godspunkycore.entity.EntityDropType;
import me.adarsh.godspunkycore.item.SItem;
import me.adarsh.godspunkycore.item.SMaterial;
import me.adarsh.godspunkycore.util.SUtil;

import java.util.Collections;
import java.util.List;

public class SvenAlpha extends BaseWolf
{
    @Override
    public String getEntityName()
    {
        return "Sven Alpha";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 480000.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 1300.0;
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Collections.singletonList(new EntityDrop(SUtil.setStackAmount(SItem.of(SMaterial.WOLF_TOOTH).getStack(), 5), EntityDropType.GUARANTEED, 1.0));
    }

    public double getXPDropped()
    {
        return 500.0;
    }

    @Override
    public boolean isAngry()
    {
        return true;
    }
}