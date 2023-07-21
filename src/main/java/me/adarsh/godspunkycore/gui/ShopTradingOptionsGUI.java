package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;

public class ShopTradingOptionsGUI extends GUI {

    private static final int[] INTERIOR = new int[]{
            10, 11, 12, 13, 14, 15, 16,
            19, 20, 21, 22, 23, 24, 25,
            28, 29, 30, 31, 32, 33, 34,
            37, 38, 39, 40, 41, 42, 43
    };
    private final SItem item;
    private final GUI ret;

    public ShopTradingOptionsGUI(SItem item, GUI ret) {
        super("Shop Trading Options", 54);
        this.item = item;
        this.ret = ret;
    }

    @Override
    public void onOpen(GUIOpenEvent e) {
        Player player = e.getPlayer();
        fill(BLACK_STAINED_GLASS_PANE);
        set(createTrade(item, 20, 1, player));
        set(createTrade(item, 21, 5, player));
        set(createTrade(item, 22, 10, player));
        set(createTrade(item, 23, 32, player));
        set(createTrade(item, 24, 64, player));
        set(GUIClickableItem.createGUIOpenerItem(ret, player, ChatColor.GREEN + "Go Back", 48,
                Material.ARROW, (short) 0, ChatColor.GRAY + "To " + ret.getTitle()));
        set(GUIClickableItem.getCloseItem(49));
    }

    private static GUIClickableItem createTrade(SItem item, int slot, int amount, Player player) {
        User user = User.getUser(player.getUniqueId());
        SItem display = item.clone();
        display.getStack().setAmount(amount);
        ItemMeta meta = display.getStack().getItemMeta();
        if (amount != 1)
            meta.setDisplayName(meta.getDisplayName() + ChatColor.DARK_GRAY + " x" + amount);
        List<String> lore = meta.getLore();
        lore.add(" ");
        lore.add(ChatColor.GRAY + "Cost");
        long price = item.getPrice() * amount;
        lore.add(ChatColor.GOLD + SUtil.commaify(price) + " Coin" + (price != 1 ? "s" : ""));
        lore.add(" ");
        lore.add(ChatColor.YELLOW + "Click to purchase!");
        meta.setLore(lore);
        display.getStack().setItemMeta(meta);
        return new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                if (price > user.getCoins()) {
                    player.sendMessage(ChatColor.RED + "You don't have enough coins!");
                    return;
                }
                Map<Integer, ItemStack> m = player.getInventory().addItem(SUtil.setSItemAmount(item.clone(), amount).getStack());
                if (m.size() != 0) {
                    player.sendMessage(ChatColor.RED + "Free up inventory space to purchase this!");
                    return;
                }
                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1f, 2f);
                user.subCoins(price);
            }

            @Override
            public int getSlot() {
                return slot;
            }

            @Override
            public ItemStack getItem() {
                return display.getStack();
            }
        };
    }
}