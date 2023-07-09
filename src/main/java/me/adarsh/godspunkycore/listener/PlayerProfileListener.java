package me.adarsh.godspunkycore.listener;


import me.adarsh.godspunkycore.gui.GUIType;
import me.adarsh.godspunkycore.user.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerProfileListener implements Listener {
    public String name;
    public Player rightClickedPlayer;

    @EventHandler
    public void RightClick(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();

        if (event.getRightClicked() instanceof Player) {
            Player rightClickedPlayer = (Player) event.getRightClicked();

            User user = User.getUser(rightClickedPlayer.getUniqueId());

            GUIType.OTHERPLAYER_PROFILE.getGUI().open(player);
            GUIType.OTHERPLAYER_PROFILE.getGUI().setTitle(name);

            rightClickedPlayer = rightClickedPlayer;

            // TODO: Update Gui with Listener
        }
    }
}
