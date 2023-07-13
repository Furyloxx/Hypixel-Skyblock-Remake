package me.adarsh.godspunkycore.features.item;

import org.bukkit.entity.Player;

public interface Ability {
    String getAbilityName();

    String getAbilityDescription();

    default void onAbilityUse(Player player, SItem sItem) {
    }
    default boolean requirementsUse(final Player player, final SItem sItem) {
        return false;
    }
    default String getAbilityReq() {
        return "";
    }

    int getAbilityCooldownTicks();

    int getManaCost();

    default AbilityActivation getAbilityActivation() {
        return AbilityActivation.RIGHT_CLICK;
    }

    default boolean displayUsage() {
        return true;
    }
    default boolean displayCooldown() {
        return true;
    }
}