package me.adarsh.godspunkycore.listener;

import me.adarsh.godspunkycore.gui.GUIType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerProfileListener implements Listener {
    @EventHandler
    public void RightClick(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();

        if (event.getRightClicked() instanceof Player) {
            Player rightClickedPlayer = (Player) event.getRightClicked();

            GUIType.OTHERPLAYER_PROFILE.getGUI().open(player);

            String name = rightClickedPlayer.getName().toString();
        }
    }
}
