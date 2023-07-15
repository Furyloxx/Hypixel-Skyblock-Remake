package me.adarsh.godspunkycore.features.gui;

import org.bukkit.entity.Player;

import java.util.UUID;

public interface GUISignItem extends GUIClickableItem
{
    GUI onSignClose(final String p0, final Player p1);

    UUID inti();
}
