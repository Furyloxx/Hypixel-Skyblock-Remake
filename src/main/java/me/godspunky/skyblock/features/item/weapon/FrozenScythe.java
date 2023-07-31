package me.godspunky.skyblock.features.item.weapon;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.features.item.weapon.Abilites.FrozenScythe.FrozenScytheAbility;
import org.bukkit.ChatColor;
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
        return ChatColor.GRAY +"Shoots"+ChatColor.GREEN+" 1 "+ChatColor.GRAY+"Ice Bolt that deals"+ChatColor.RED+" 1000 "+ChatColor.GRAY+"Ability Damage and slows enemies hit for"+ChatColor.GREEN+" 5 "+ChatColor.GRAY+"seconds!";
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

