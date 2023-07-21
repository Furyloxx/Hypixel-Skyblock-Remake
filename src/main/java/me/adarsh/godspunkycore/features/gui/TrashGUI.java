package me.adarsh.godspunkycore.features.gui;

import me.adarsh.godspunkycore.util.SUtil;
import me.adarsh.godspunkycore.util.Sputnik;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class TrashGUI extends GUI
{
    public TrashGUI(final String query, final int page) {
        super("Trash Bin", 54);
        this.border(TrashGUI.BLACK_STAINED_GLASS_PANE);
        this.set(new GUIClickableItem() {
            @Override
            public void run(final InventoryClickEvent e) {
                GUIType.TRASH.getGUI().open((Player)e.getWhoClicked());
                ((Player)e.getWhoClicked()).sendMessage(ChatColor.YELLOW + "All your items inside the Trash Bin have been wiped!");
                ((Player)e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.ANVIL_USE, 1.0f, 2.0f);
            }

            @Override
            public int getSlot() {
                return 49;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(Sputnik.trans("&cEmpty the Trash"), Material.CAULDRON_ITEM, (short)0, 1, ChatColor.GRAY + "WARNING! This action cannot", ChatColor.GRAY + "be undone, so check carefully before", ChatColor.GRAY + "proceed this action.", "", ChatColor.YELLOW + "Click to empty!");
            }
        });
        this.set(new GUIClickableItem() {
            @Override
            public void run(final InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 4;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(Sputnik.trans("&aTrash Bin"), Material.BOOK_AND_QUILL, (short)0, 1, ChatColor.GRAY + "This is where you put your", ChatColor.GRAY + "unnecessary items, click Empty", ChatColor.GRAY + "the Trash or press ESC to clear", ChatColor.GRAY + "everything in this GUI. That action", ChatColor.RED + "cannot be undone!");
            }
        });
    }

    public TrashGUI(final String query) {
        this(query, 1);
    }

    public TrashGUI(final int page) {
        this("", page);
    }

    public TrashGUI() {
        this(1);
    }
}
