package me.adarsh.godspunkycore.features.gui;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.pet.Pet;
import me.adarsh.godspunkycore.user.PlayerStatistics;
import me.adarsh.godspunkycore.user.PlayerUtils;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class ProfileViewerGUI extends GUI {
    public Player p;

    public ProfileViewerGUI(Player player) {
        super(player.getName() + "'s Profile", 54);
        this.p = player;
    }

    @Override
    public void onOpen(GUIOpenEvent e) {
        fill(BLACK_STAINED_GLASS_PANE);

        Player player = e.getPlayer();
        User user = User.getUser(player.getUniqueId());
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId());
        set(GUIClickableItem.getCloseItem(49));

        // HELD ITEM
        set(new GUIItem() {
            public int getSlot() {
                return 1;
            }

            public ItemStack getItem() {
                if (ProfileViewerGUI.this.p.getItemInHand() != null &&
                        ProfileViewerGUI.this.p.getItemInHand().getType() != Material.AIR)
                    return ProfileViewerGUI.this.p.getItemInHand();
                List<String> lore = new ArrayList<>();
                ItemStack gst = SUtil.createColoredStainedGlassPane((short)0, ChatColor.YELLOW+"&eHeld Item");
                lore.add(ChatColor.RED + "Empty");
                ItemMeta met = gst.getItemMeta();
                met.setLore(lore);
                gst.setItemMeta(met);
                return gst;
            }
        });


        // HELMET
        set(new GUIItem() {
            public int getSlot() {
                return 10;
            }

            public ItemStack getItem() {
                if (ProfileViewerGUI.this.p.getInventory().getHelmet() != null)
                    return ProfileViewerGUI.this.p.getInventory().getHelmet();
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.RED + "Empty");
                ItemStack gst = SUtil.createColoredStainedGlassPane((short)0, ChatColor.YELLOW+"&eHelmet");
                ItemMeta met = gst.getItemMeta();
                met.setLore(lore);
                gst.setItemMeta(met);
                return gst;
            }
        });

        // CHESTPLATE
        set(new GUIItem() {
            public int getSlot() {
                return 19;
            }

            public ItemStack getItem() {
                if (ProfileViewerGUI.this.p.getInventory().getChestplate() != null)
                    return ProfileViewerGUI.this.p.getInventory().getChestplate();
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.RED + "Empty");
                ItemStack gst = SUtil.createColoredStainedGlassPane((short)0, ChatColor.YELLOW+"&eChestplate");
                ItemMeta met = gst.getItemMeta();
                met.setLore(lore);
                gst.setItemMeta(met);
                return gst;
            }
        });

        // LEGGINGS
        set(new GUIItem() {
            public int getSlot() {
                return 28;
            }

            public ItemStack getItem() {
                if (ProfileViewerGUI.this.p.getInventory().getLeggings() != null)
                    return ProfileViewerGUI.this.p.getInventory().getLeggings();
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.RED + "Empty");
                ItemStack gst = SUtil.createColoredStainedGlassPane((short)0, ChatColor.YELLOW+"&eLeggings");
                ItemMeta met = gst.getItemMeta();
                met.setLore(lore);
                gst.setItemMeta(met);
                return gst;
            }
        });

        // BOOTS
        set(new GUIItem() {
            public int getSlot() {
                return 37;
            }

            public ItemStack getItem() {
                if (ProfileViewerGUI.this.p.getInventory().getBoots() != null)
                    return ProfileViewerGUI.this.p.getInventory().getBoots();
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.RED + "Empty");
                ItemStack gst = SUtil.createColoredStainedGlassPane((short)0, ChatColor.YELLOW+"&eBoots");
                ItemMeta met = gst.getItemMeta();
                met.setLore(lore);
                gst.setItemMeta(met);
                return gst;
            }
        });

        // PET
        set(new GUIItem() {
            public int getSlot() {
                return 46;
            }

            public ItemStack getItem() {
                if (user.getActivePet() != null) {
                    Pet.PetItem pet = user.getActivePet();
                    SItem item = SItem.of(pet.getType());
                    item.setRarity(pet.getRarity());
                    item.setDataDouble("xp", pet.getXp());
                    item.getData().setBoolean("equipped", true);
                    item.update();
                    ItemStack petstack = item.getStack();
                    ItemMeta meta = petstack.getItemMeta();
                    List<String> newlore = item.getStack().getItemMeta().getLore();
                    newlore.add(" ");
                    newlore.add(item.getRarity().getBoldedColor() + item.getRarity().getDisplay());
                    meta.setLore(newlore);
                    petstack.setItemMeta(meta);
                    return petstack;
                }
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.RED + "Empty");
                ItemStack gst = SUtil.createColoredStainedGlassPane((short)0, ChatColor.YELLOW+"&ePets");
                ItemMeta met = gst.getItemMeta();
                met.setLore(lore);
                gst.setItemMeta(met);
                return gst;
            }
        });

        // VISIT ISLAND
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

        // TRADE REQUEST
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 16;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN + "Trade Request", Material.EMERALD, (short) 0, 1,
                        ChatColor.YELLOW + "Send a trade request!");
            }
        });

        // PROFILE
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
        (new BukkitRunnable() {
            public void run() {
                if (ProfileViewerGUI.this != GUI.GUI_MAP.get(player.getUniqueId()))
                    return;
                if (!ProfileViewerGUI.this.p.isOnline())
                    return;
                (new ProfileViewerGUI(ProfileViewerGUI.this.p)).open(player);
            }
        }).runTaskLater((Plugin) Skyblock.getPlugin(), 40L);
    }
}
