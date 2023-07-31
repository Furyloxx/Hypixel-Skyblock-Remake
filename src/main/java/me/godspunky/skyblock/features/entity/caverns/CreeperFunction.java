package me.godspunky.skyblock.features.entity.caverns;

import me.godspunky.skyblock.features.entity.EntityFunction;
import me.godspunky.skyblock.features.entity.SEntity;
import me.godspunky.skyblock.features.event.CreeperIgniteEvent;

public interface CreeperFunction extends EntityFunction {
    default void onCreeperIgnite(CreeperIgniteEvent e, SEntity sEntity) {
    }
}