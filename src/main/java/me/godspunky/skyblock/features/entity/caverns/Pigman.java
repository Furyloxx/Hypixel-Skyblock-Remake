package me.godspunky.skyblock.features.entity.caverns;

import me.godspunky.skyblock.features.entity.*;
import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;
import me.godspunky.skyblock.util.SUtil;
import me.godspunky.skyblock.features.entity.*;

import java.util.Collections;
import java.util.List;

public class Pigman implements EntityFunction, EntityStatistics {
    @Override
    public String getEntityName() {
        return "Pigman";
    }

    @Override
    public double getEntityMaxHealth() {
        return 250.0;
    }

    @Override
    public double getDamageDealt() {
        return 75.0;
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(SItem.of(SMaterial.GOLD_SWORD).getStack(), null, null, null, null);
    }

    @Override
    public List<EntityDrop> drops() {
        return Collections.singletonList(new EntityDrop(SUtil.setStackAmount(SItem.of(SMaterial.GOLD_NUGGET).getStack(), SUtil.random(1, 2)), EntityDropType.GUARANTEED, 1.0));
    }

    @Override
    public double getXPDropped() {
        return 20.0;
    }
}