package me.godspunky.skyblock.features.item.bow;

import com.google.common.util.concurrent.AtomicDouble;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.SItem;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityShootBowEvent;

public interface BowFunction extends MaterialFunction {
    default void onBowShoot(SItem bow, EntityShootBowEvent e) {
    }

    default void onBowHit(Entity hit, Player shooter, Arrow arrow, SItem weapon, AtomicDouble damage) {
    }
}