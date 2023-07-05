package me.adarsh.godspunkycore.features.entity.dungeon.minibosses;

import me.adarsh.godspunkycore.features.entity.EntityFunction;
import me.adarsh.godspunkycore.features.entity.EntityStatistics;
import me.adarsh.godspunkycore.features.entity.SEntityEquipment;
import me.adarsh.godspunkycore.features.entity.ZombieStatistics;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;

public class LostAdventurer implements ZombieStatistics, EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "Lost Adventurer";
    }

    @Override
    public double getEntityMaxHealth() {
        return 60000;
    }

    @Override
    public double getDamageDealt() {
        return 360;
    }

    @Override
    public double getXPDropped() {
        return 100;
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(SItem.of(SMaterial.ASPECT_OF_THE_DRAGONS).getStack(),
                SItem.of(SMaterial.SUPERIOR_DRAGON_HELMET).getStack(),
                SItem.of(SMaterial.SUPERIOR_DRAGON_CHESTPLATE).getStack(),
                SItem.of(SMaterial.SUPERIOR_DRAGON_LEGGINGS).getStack(),
                SItem.of(SMaterial.SUPERIOR_DRAGON_BOOTS).getStack()
        );
    }

    @Override
    public double getMovementSpeed() {
        return 0.4;
    }
}
