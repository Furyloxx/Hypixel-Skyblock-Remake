package me.adarsh.godspunkycore.features.entity.dungeon.minibosses;

import me.adarsh.godspunkycore.features.entity.EntityFunction;
import me.adarsh.godspunkycore.features.entity.EntityStatistics;
import me.adarsh.godspunkycore.features.entity.SEntityEquipment;
import me.adarsh.godspunkycore.features.entity.ZombieStatistics;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;

public class ShadowAssassin implements ZombieStatistics, EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "Shadow Assassin";
    }

    @Override
    public double getEntityMaxHealth() {
        return 500000;
    }

    @Override
    public double getDamageDealt() {
        return 3280;
    }

    @Override
    public double getXPDropped() {
        return 115;
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(SItem.of(SMaterial.STONE_SWORD).getStack(),
                null,
                null,
                null,
                SItem.of(SMaterial.SHADOW_ASSASSIN_BOOTS).getStack()
        );
    }

    @Override
    public double getMovementSpeed() {
        return 0.4;
    }
}