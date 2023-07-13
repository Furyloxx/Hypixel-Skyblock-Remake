package me.adarsh.godspunkycore.features.gui;

import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SettingGUI extends GUI{
    public SettingGUI() {
        super("Settings", 54);
    }

    @Override
    public void onOpen(GUIOpenEvent e) {
        fill(BLACK_STAINED_GLASS_PANE);
        Player player = e.getPlayer();
        User user = User.getUser(e.getPlayer().getUniqueId());
        set(GUIClickableItem.getCloseItem(49));

        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.SKYBLOCK_MENU.getGUI().open(player);
            }

            @Override
            public int getSlot() {
                return 48;
            }

            @Override
            public ItemStack getItem(){
                return SUtil.getStack(ChatColor.GREEN + "Go Back", Material.ARROW, (short) 0, 1,
                        ChatColor.GRAY + "To SkyBlock Menu");
            }
        });

        // Personal
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {

            }

            @Override
            public int getSlot() {
                return 11;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullStack(ChatColor.GREEN + "Personal", player.getName(), 1,
                        ChatColor.GRAY + "General settings related to your",
                        ChatColor.GRAY + "experience.",
                        " ",
                        ChatColor.GRAY + "Includes:",
                        ChatColor.GREEN + "✔ " + ChatColor.GRAY + "Player Trading",
                        ChatColor.GREEN + "✔ " + ChatColor.GRAY + "Skill Numerals",
                        ChatColor.GREEN + "✔ " + ChatColor.GRAY + "Play Music",
                        ChatColor.GREEN + "✔ " + ChatColor.GRAY + "Rare Drop Sound",
                        ChatColor.GREEN + "✔ " + ChatColor.GRAY + "Inventory Full Notification",
                        ChatColor.GREEN + "✔ " + ChatColor.GRAY + "Pickup Arrow with Full Quiver",
                        ChatColor.GREEN + "✔ " + ChatColor.GRAY + "Ferocity SFX",
                        ChatColor.GREEN + "✔ " + ChatColor.GRAY + "Player List Info",
                        " ",
                        ChatColor.YELLOW + "Click for settings!");
            }
        });

        // Comms
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {

            }

            @Override
            public int getSlot() {
                return 13;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Comms", Material.SIGN ,(short) 0,1,
                        ChatColor.GRAY + "Tweak notifications and invites",
                        ChatColor.GRAY + "you get from other players.",
                        " ",
                        ChatColor.GRAY + "Includes:",
                        ChatColor.GREEN + "✔ " + ChatColor.GRAY + "Death Messages",
                        ChatColor.GREEN + "✔ " + ChatColor.GRAY + "Guesting Invites",
                        ChatColor.GREEN + "✔ " + ChatColor.GRAY + "Guesting Notification",
                        ChatColor.GREEN + "✔ " + ChatColor.GRAY + "Co-op Invites",
                        ChatColor.GREEN + "✔ " + ChatColor.GRAY + "Co-op Travel Notification",
                        ChatColor.GREEN + "✔ " + ChatColor.GRAY + "Bid Notification",
                        ChatColor.GREEN + "✔ " + ChatColor.GRAY + "Outbids Notification",
                        ChatColor.GREEN + "✔ " + ChatColor.GRAY + "Fill Notification",
                        " ",
                        ChatColor.YELLOW + "Click for settings!");
            }
        });

        // Island
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {

            }

            @Override
            public int getSlot() {
                return 15;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Island Settings", Material.REDSTONE_COMPARATOR ,(short) 0,1,
                        ChatColor.GRAY + "Edit SkyBlock Setting regarding",
                        ChatColor.GRAY + "your island.",
                        " ",
                        ChatColor.YELLOW + "Click for settings!");
            }
        });

        // Double Drop
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {

            }

            @Override
            public int getSlot() {
                return 30;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Double Tap to Drop", Material.DIAMOND_SWORD ,(short) 0,1,
                        ChatColor.GRAY + "Double tap to drop button to",
                        ChatColor.GRAY + "drop certain items.");
            }
        });

        // Profile Viewer
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {

            }

            @Override
            public int getSlot() {
                return 32;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullStack(ChatColor.GREEN + "Profile Viewer", player.getName(), 1,
                        ChatColor.GRAY + "View player's profile on",
                        ChatColor.GRAY + "right click.");
            }
        });
    }
}
