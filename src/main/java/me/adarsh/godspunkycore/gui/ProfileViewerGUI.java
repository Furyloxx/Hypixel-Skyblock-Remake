package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import me.adarsh.godspunkycore.util.Sputnik;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class ProfileViewerGUI extends GUI {
    public PlayerInteractEntityEvent eEvent;
    public Player p;


    public ProfileViewerGUI(Player player) {
        super(player.getName() + "'s Profile", 54);
        this.p = player;
    }

    public void onOpen(GUIOpenEvent e) {
        if (e.getPlayer().getType().equals(EntityType.FAKE_PLAYER)){
            e.setCancelled(true);
        }
        if (this.p == null)
            return;
        fill(BLACK_STAINED_GLASS_PANE);
        final Player player = e.getPlayer();
        final User user = User.getUser(this.p.getUniqueId());
        set(GUIClickableItem.getCloseItem(22));
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 22;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullStack(ChatColor.GREEN + "",player.getDisplayName(), 1,
                        ChatColor.RED + "❤ Health ",
                        ChatColor.GREEN + "❈ Defense",
                        ChatColor.RED + "❂ Strength",
                        ChatColor.WHITE + "✦ Speed",
                        ChatColor.BLUE + "☣ Crit Chance",
                        ChatColor.BLUE + "☠ Crit Damage",
                        ChatColor.AQUA + "✎ Intelligence",
                        ChatColor.GOLD + "N/A Skill Avg.");
            }
        });
        set(new GUIItem() {
            public int getSlot() {
                return 1;
            }

            public ItemStack getItem() {
                if (ProfileViewerGUI.this.p.getItemInHand() != null &&
                        ProfileViewerGUI.this.p.getItemInHand().getType() != Material.AIR)
                    return ProfileViewerGUI.this.p.getItemInHand();
                List<String> lore = new ArrayList<>();
                ItemStack gst = SUtil.createColoredStainedGlassPane((short)0, Sputnik.trans("&eHeld Item"));
                lore.add(ChatColor.RED + "Empty");
                ItemMeta met = gst.getItemMeta();
                met.setLore(lore);
                gst.setItemMeta(met);
                return gst;
            }
        });
        set(new GUIItem() {
            public int getSlot() {
                return 10;
            }

            public ItemStack getItem() {
                if (ProfileViewerGUI.this.p.getInventory().getHelmet() != null)
                    return ProfileViewerGUI.this.p.getInventory().getHelmet();
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.RED + "Empty");
                ItemStack gst = SUtil.createColoredStainedGlassPane((short)0, Sputnik.trans("&eHelmet"));
                ItemMeta met = gst.getItemMeta();
                met.setLore(lore);
                gst.setItemMeta(met);
                return gst;
            }
        });
        set(new GUIItem() {
            public int getSlot() {
                return 19;
            }

            public ItemStack getItem() {
                if (ProfileViewerGUI.this.p.getInventory().getChestplate() != null)
                    return ProfileViewerGUI.this.p.getInventory().getChestplate();
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.RED + "Empty");
                ItemStack gst = SUtil.createColoredStainedGlassPane((short)0, Sputnik.trans("&eChestplate"));
                ItemMeta met = gst.getItemMeta();
                met.setLore(lore);
                gst.setItemMeta(met);
                return gst;
            }
        });
        set(new GUIItem() {
            public int getSlot() {
                return 28;
            }

            public ItemStack getItem() {
                if (ProfileViewerGUI.this.p.getInventory().getLeggings() != null)
                    return ProfileViewerGUI.this.p.getInventory().getLeggings();
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.RED + "Empty");
                ItemStack gst = SUtil.createColoredStainedGlassPane((short)0, Sputnik.trans("&eLeggings"));
                ItemMeta met = gst.getItemMeta();
                met.setLore(lore);
                gst.setItemMeta(met);
                return gst;
            }
        });
        set(new GUIItem() {
            public int getSlot() {
                return 37;
            }

            public ItemStack getItem() {
                if (ProfileViewerGUI.this.p.getInventory().getBoots() != null)
                    return ProfileViewerGUI.this.p.getInventory().getBoots();
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.RED + "Empty");
                ItemStack gst = SUtil.createColoredStainedGlassPane((short)0, Sputnik.trans("&eBoots"));
                ItemMeta met = gst.getItemMeta();
                met.setLore(lore);
                gst.setItemMeta(met);
                return gst;
            }
        });
        set(new GUIClickableItem() {
            public void run(InventoryClickEvent e) {
                ((Player)e.getWhoClicked()).closeInventory();
                ((Player)e.getWhoClicked()).chat("/trade " + ProfileViewerGUI.this.p.getName());
            }

            public int getSlot() {
                return 16;
            }

            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Trade Request", Material.EMERALD, (short)0, 1, new String[] { ChatColor.YELLOW + "Send a trade request" });
            }
        });
        set(new GUIClickableItem() {
            public void run(InventoryClickEvent e) {
                ((Player)e.getWhoClicked()).sendMessage(ChatColor.RED + "Not available!");
            }

            public int getSlot() {
                return 15;
            }

            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Visit Island", Material.FEATHER, (short)0, 1, new String[] { ChatColor.RED + "Not available!" });
            }
        });
        set(new GUIClickableItem() {
            public void run(InventoryClickEvent e) {
                ((Player)e.getWhoClicked()).sendMessage(ChatColor.RED + "Coming at a later date.");
            }

            public int getSlot() {
                return 25;
            }

            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.YELLOW + "Unfinished!", Material.DIAMOND, (short)0, 1, new String[] { ChatColor.RED + "Not available!" });
            }
        });
        if (player.hasPermission("system.viewinv"))
            set(new GUIClickableItem() {
                public void run(InventoryClickEvent e) {
                    ((Player)e.getWhoClicked()).chat("/openinv " + ProfileViewerGUI.this.p.getName());
                }

                public int getSlot() {
                    return 50;
                }

                public ItemStack getItem() {
                    return SUtil.getStack(ChatColor.GREEN + "Open Player Inventory", Material.CHEST, (short)0, 1, ChatColor.YELLOW + "Click to view " + p.getName() + "'s", ChatColor.YELLOW + "inventory.");
                }
            });
        (new BukkitRunnable() {
            public void run() {
                if (ProfileViewerGUI.this != GUI.GUI_MAP.get(player.getUniqueId()))
                    return;
                if (!ProfileViewerGUI.this.p.isOnline())
                    return;
                (new ProfileViewerGUI(ProfileViewerGUI.this.p)).open(player);
            }
        }).runTaskLater(Skyblock.getPlugin(), 40L);
    }
}
