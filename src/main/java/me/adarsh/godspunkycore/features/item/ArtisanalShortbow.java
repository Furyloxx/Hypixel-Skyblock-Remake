package me.adarsh.godspunkycore.features.item.bow;

import me.adarsh.godspunkycore.features.item.*;

public class ArtisanalShortbow implements ToolStatistics, MaterialFunction, Ability {

    @Override
    public String getDisplayName() {
        return "Artisanal Shortbow";
    }

    @Override
    public int getBaseDamage() {
        return 40;
    }

    @Override
    public String getAbilityName() {
        return null;
    }

    @Override
    public String getAbilityDescription() {
        return null;
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 0;
    }

    @Override
    public int getManaCost() {
        return 0;
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.RANGED_WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.BOW;
    }
}