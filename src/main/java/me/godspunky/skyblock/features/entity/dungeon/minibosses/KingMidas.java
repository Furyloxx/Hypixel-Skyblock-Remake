package me.godspunky.skyblock.features.entity.dungeon.minibosses;

import me.godspunky.skyblock.features.entity.EntityFunction;
import me.godspunky.skyblock.features.entity.EntityStatistics;
import me.godspunky.skyblock.features.entity.SEntityEquipment;
import me.godspunky.skyblock.features.entity.ZombieStatistics;
import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;

public class KingMidas implements ZombieStatistics, EntityStatistics, EntityFunction {
    @Override
    public String getEntityName() {
        return "King Midas";
    }

    @Override
    public double getEntityMaxHealth() {
        return 300000;
    }

    @Override
    public double getDamageDealt() {
        return 3760;
    }

    @Override
    public double getXPDropped() {
        return 125;
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(SItem.of(SMaterial.GOLD_SWORD).getStack(),
                SItem.of(SMaterial.GOLDEN_HELMET).getStack(),
                SItem.of(SMaterial.GOLDEN_CHESTPLATE).getStack(),
                SItem.of(SMaterial.GOLDEN_LEGGINGS).getStack(),
                SItem.of(SMaterial.GOLDEN_BOOTS).getStack()
        );
    }

    @Override
    public double getMovementSpeed() {
        return 0.4;
    }
}