package me.adarsh.godspunkycore.entity.caverns;

import me.adarsh.godspunkycore.entity.EntityFunction;
import me.adarsh.godspunkycore.entity.SEntity;
import me.adarsh.godspunkycore.event.CreeperIgniteEvent;

public interface CreeperFunction extends EntityFunction
{
    default void onCreeperIgnite(CreeperIgniteEvent e, SEntity sEntity) {}
}