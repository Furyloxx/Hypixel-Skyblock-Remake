package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.listener.PlayerProfileListener;
import me.adarsh.godspunkycore.user.PlayerStatistics;
import me.adarsh.godspunkycore.user.PlayerUtils;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class OtherPlayerProfile extends GUI {
    PlayerProfileListener listener = new PlayerProfileListener();
    String playerName = listener.name;
    public OtherPlayerProfile() {
        super("'s Profile", 54);
    }
    @Override
    public void onOpen(GUIOpenEvent e) {
        fill(BLACK_STAINED_GLASS_PANE);

        Player player = e.getPlayer();

        User user = User.getUser(player.getUniqueId());
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId());
        set(GUIClickableItem.getCloseItem(49));

        // HELD ITEM
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 1;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.YELLOW + "Held Item", Material.STAINED_GLASS_PANE, (short) 0, 1,
                        ChatColor.RED + "Empty!");
            }
        });

        // HELMET
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 10;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.YELLOW + "Helmet", Material.STAINED_GLASS_PANE, (short) 0, 1,
                        ChatColor.RED + "Empty!");
            }
        });

        // CHESTPLATE
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 19;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.YELLOW + "Chestplate", Material.STAINED_GLASS_PANE, (short) 0, 1,
                        ChatColor.RED + "Empty!");
            }
        });

        // LEGGINGS
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 28;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.YELLOW + "Leggings", Material.STAINED_GLASS_PANE, (short) 0, 1,
                        ChatColor.RED + "Empty!");
            }
        });

        // BOOTS
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 37;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.YELLOW + "Boots", Material.STAINED_GLASS_PANE, (short) 0, 1,
                        ChatColor.RED + "Empty!");
            }
        });

        // PET
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 46;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.YELLOW + "Pet", Material.STAINED_GLASS_PANE, (short) 0, 1,
                        ChatColor.RED + "Empty!");
            }
        });

        // VISIT ISLAND
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
                return SUtil.getStack(ChatColor.GREEN + "Visit Island", Material.FEATHER, (short) 0, 1,
                        ChatColor.YELLOW + "Click to visit!");
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
                return SUtil.getSkullStack(ChatColor.GREEN + playerName, playerName, 1,
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
    }
}
