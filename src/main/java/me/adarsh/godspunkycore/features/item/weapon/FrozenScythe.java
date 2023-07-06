package me.adarsh.godspunkycore.features.item.weapon;

import me.adarsh.godspunkycore.features.item.*;
import me.adarsh.godspunkycore.features.item.weapon.Abilites.FrozenScythe.FrozenScytheAbility;
import org.bukkit.entity.Player;

public class FrozenScythe implements ToolStatistics, MaterialFunction, Ability {
    @Override
    public int getBaseDamage() {
        return 80;
    }

    @Override
    public String getDisplayName() {
        return "Frozen Scythe";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.RARE;
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
    public String getAbilityName() {
        return "Ice Bolt";
    }

    @Override
    public String getAbilityDescription() {
        return "Shoots 1 Ice Bolt that deals 1000 ๑ Ability Damage and slows enemies hit!";
    }

    @Override
    public void onAbilityUse(Player player, SItem sItem) {
        FrozenScytheAbility.Throw(player);
    }
    @Override
    public int getAbilityCooldownTicks() {
        return 100;
    }

    @Override
    public int getManaCost() {
        return 60;
    }

}

