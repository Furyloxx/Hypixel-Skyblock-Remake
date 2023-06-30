package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.user.PlayerUtils;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class FastTravelGUI extends GUI{
    private Skyblock plugin;
    public FastTravelGUI() {
        super("Fast Travel", 54);
    }

    @Override
    public void onOpen(GUIOpenEvent e) {
        fill(BLACK_STAINED_GLASS_PANE);
        Player player = e.getPlayer();
        User user = User.getUser(e.getPlayer().getUniqueId());

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                PlayerUtils.sendToIsland(player);
            }

            @Override
            public int getSlot() {
                return 10;
            }

            @Override
            public ItemStack getItem(){
                return SUtil.getSkullURLStack(ChatColor.AQUA + "Private Island", "c9c8881e42915a9d29bb61a16fb26d059913204d265df5b439b3d792acd56", 1,
                        ChatColor.DARK_GRAY + "/warp home",
                        " ",
                        ChatColor.GRAY + "Your very own chunk of SkyBlock.",
                        ChatColor.GRAY + "Nice housing for your minions.",
                        " ",
                        ChatColor.YELLOW + "Click to warp!");
            }
        });

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                World hub = Bukkit.getWorld(!plugin.config.getString("hub_world").isEmpty() ? plugin.config.getString("hub_world") : "hub");
                player.teleport(new Location(hub, -3 , 70 , -68));
            }

            @Override
            public int getSlot() {
                return 11;
            }

            @Override
            public ItemStack getItem(){
                return SUtil.getSkullURLStack(ChatColor.AQUA + "Skyblock Hub", "cf40942f364f6cbceffcf1151796410286a48b1aeba77243e218026c09cd1", 1,
                        ChatColor.DARK_GRAY + "/warp hub",
                        " ",
                        ChatColor.GRAY + "Where everything happens and",
                        ChatColor.GRAY + "anything is possible.",
                        " ",
                        ChatColor.YELLOW + "Click to warp!");
            }

        });
    }
}
