package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;

public class NecromancerSword implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Necromancer Sword";
    }

    @Override
    public int getBaseDamage() {
        return 250;
    }

    @Override
    public double getBaseStrength() {
        return 125;
    }

    @Override
    public int getManaCost() {
        return 0;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 20;
    }

    @Override
    public String getAbilityName() {
        return "Raise Souls";
    }

    @Override
    public String getAbilityDescription() {
        return "Monsters you kill using this item will drop their soul. You can click on their souls on the ground using this item to absorb them and then spawn them to fight by your side.✎ Mana Cost is based on the power of the monsters you summon.";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.SWORD;
    }

    @Override
    public String getLore() {
        return null;
    }
}
