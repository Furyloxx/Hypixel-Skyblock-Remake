package me.adarsh.godspunkycore.features.entity.caverns;

import me.adarsh.godspunkycore.features.entity.EntityFunction;
import me.adarsh.godspunkycore.features.entity.SEntity;
import me.adarsh.godspunkycore.features.event.CreeperIgniteEvent;

public interface CreeperFunction extends EntityFunction {
    default void onCreeperIgnite(CreeperIgniteEvent e, SEntity sEntity) {
    }
}