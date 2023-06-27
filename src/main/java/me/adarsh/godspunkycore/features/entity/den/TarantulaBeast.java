package me.adarsh.godspunkycore.features.entity.den;

import me.adarsh.godspunkycore.features.entity.EntityDrop;
import me.adarsh.godspunkycore.features.entity.EntityDropType;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.util.SUtil;

import java.util.Collections;
import java.util.List;

public class TarantulaBeast extends BaseSpider {
    @Override
    public String getEntityName() {
        return "Tarantula Beast";
    }

    @Override
    public double getEntityMaxHealth() {
        return 144000;
    }

    @Override
    public double getDamageDealt() {
        return 2500.0;
    }

    @Override
    public double getXPDropped() {
        return 300.0;
    }

    @Override
    public List<EntityDrop> drops() {
        return Collections.singletonList(new EntityDrop(SUtil.setStackAmount(SItem.of(SMaterial.TARANTULA_WEB).getStack(), 2), EntityDropType.GUARANTEED, 1.0));
    }
}