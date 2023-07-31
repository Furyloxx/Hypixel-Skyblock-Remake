package me.godspunky.skyblock.features.item;

import org.bukkit.event.player.PlayerFishEvent;

public interface FishingRodFunction extends MaterialFunction {
    void onFish(SItem instance, PlayerFishEvent e);
}
