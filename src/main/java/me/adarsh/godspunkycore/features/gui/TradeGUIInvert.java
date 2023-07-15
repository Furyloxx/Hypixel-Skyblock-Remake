package me.adarsh.godspunkycore.features.gui;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.Untradeable;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import me.adarsh.godspunkycore.util.Sputnik;
import net.milkbowl.vault.economy.Economy;
import net.minecraft.server.v1_8_R3.NBTBase;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.NBTTagLong;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TradeGUIInvert extends GUI
{
    private int[] ls;
    private int[] rs;
    private UUID tradeUUID;

    public void fillFrom(final Inventory i, final int startFromSlot, final int height, final ItemStack stacc) {
        i.setItem(startFromSlot, stacc);
        i.setItem(startFromSlot + 9, stacc);
        i.setItem(startFromSlot + 9 + 9, stacc);
        i.setItem(startFromSlot + 9 + 9 + 9, stacc);
        i.setItem(startFromSlot + 9 + 9 + 9 + 9, stacc);
    }

    public TradeGUIInvert() {
        this(UUID.randomUUID());
    }

    public TradeGUIInvert(final UUID uuid) {
        super("You                  " + TradeGUI.player1.get(uuid).getName(), 45);
        this.ls = new int[] { 0, 1, 2, 3, 9, 10, 11, 12, 18, 19, 20, 21, 27, 28, 29, 30 };
        this.rs = new int[] { 5, 6, 7, 8, 14, 15, 16, 17, 23, 24, 25, 26, 32, 33, 34, 35 };
        this.tradeUUID = uuid;
        if (!TradeGUI.itemOfferP1.containsKey(uuid) && TradeGUI.itemOfferP1.get(uuid) == null) {
            TradeGUI.itemOfferP1.put(uuid, new ArrayList<ItemStack>());
        }
        if (!TradeGUI.itemOfferP2.containsKey(uuid) && TradeGUI.itemOfferP2.get(uuid) == null) {
            TradeGUI.itemOfferP2.put(uuid, new ArrayList<ItemStack>());
        }
    }

    @Override
    public void onOpen(final GUIOpenEvent e) {
        final Player player = e.getPlayer();
        final Inventory i = e.getInventory();
        final ItemStack stk = SUtil.getSingleLoreStack(ChatColor.GRAY + "\u21e6 Your stuff", Material.STAINED_GLASS_PANE, (short)0, 1, ChatColor.GRAY + "Their stuff \u21e8");
        stk.setDurability((short)7);
        this.fillFrom(i, 4, 5, stk);
        TradeMenu.tradeP2Ready.put(this.tradeUUID, false);
        new BukkitRunnable() {
            public void run() {
                if (TradeGUIInvert.this != GUI.GUI_MAP.get(player.getUniqueId())) {
                    this.cancel();
                    return;
                }
                if (TradeMenu.tradeP2Countdown.containsKey(TradeGUIInvert.this.tradeUUID) && TradeMenu.tradeP2Countdown.get(TradeGUIInvert.this.tradeUUID) > 0) {
                    TradeMenu.tradeP2Countdown.put(TradeGUIInvert.this.tradeUUID, TradeMenu.tradeP2Countdown.get(TradeGUIInvert.this.tradeUUID) - 1);
                }
            }
        }.runTaskTimer((Plugin) Skyblock.getPlugin(), 0L, 20L);
        this.set(new GUIClickableItem() {
            @Override
            public void run(final InventoryClickEvent e) {
                if (TradeMenu.tradeP2Countdown.containsKey(TradeGUIInvert.this.tradeUUID) && TradeMenu.tradeP2Countdown.get(TradeGUIInvert.this.tradeUUID) <= 0 && (TradeGUI.itemOfferP1.get(TradeGUIInvert.this.tradeUUID).size() > 0 || TradeGUI.itemOfferP2.get(TradeGUIInvert.this.tradeUUID).size() > 0) && !TradeMenu.tradeP2Ready.get(TradeGUIInvert.this.tradeUUID)) {
                    TradeMenu.tradeP2Ready.put(TradeGUIInvert.this.tradeUUID, true);
                    TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID).playSound(TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID).getLocation(), Sound.VILLAGER_YES, 1.0f, 1.0f);
                    TradeGUI.player1.get(TradeGUIInvert.this.tradeUUID).playSound(TradeGUI.player1.get(TradeGUIInvert.this.tradeUUID).getLocation(), Sound.VILLAGER_YES, 1.0f, 1.0f);
                }
            }

            @Override
            public int getSlot() {
                return 39;
            }

            @Override
            public ItemStack getItem() {
                final ItemStack stack = SUtil.getStack(Sputnik.trans("&aTrading!"), Material.STAINED_CLAY, (short)13, 1, ChatColor.GRAY + "Click an item in your", ChatColor.GRAY + "inventory to offer it for", ChatColor.GRAY + "trade.");
                return stack;
            }
        });
        this.set(new GUIClickableItem() {
            @Override
            public void run(final InventoryClickEvent e) {
            }

            @Override
            public int getSlot() {
                return 41;
            }

            @Override
            public ItemStack getItem() {
                final ItemStack stack = SUtil.getStack(Sputnik.trans("&eNew deal"), Material.INK_SACK, (short)8, 1, ChatColor.GRAY + "Trading with " + TradeGUI.player1.get(TradeGUIInvert.this.tradeUUID).getName());
                return stack;
            }
        });
        new BukkitRunnable() {
            public void run() {
                if (TradeGUIInvert.this != GUI.GUI_MAP.get(player.getUniqueId())) {
                    this.cancel();
                    return;
                }
                if (TradeMenu.tradeP1Ready.containsKey(TradeGUIInvert.this.tradeUUID) && TradeMenu.tradeP2Countdown.containsKey(TradeGUIInvert.this.tradeUUID)) {
                    if (TradeMenu.tradeP1Ready.get(TradeGUIInvert.this.tradeUUID)) {
                        i.setItem(41, SUtil.getStack(Sputnik.trans("&aOther player confirmed!"), Material.INK_SACK, (short)10, 1, ChatColor.GRAY + "Trading with " + TradeGUI.player1.get(TradeGUIInvert.this.tradeUUID).getName() + ".", ChatColor.GRAY + "Waiting for you to confirm..."));
                    }
                    else if (TradeMenu.tradeP2Countdown.get(TradeGUIInvert.this.tradeUUID) > 0 && !TradeMenu.tradeP2Ready.get(TradeGUIInvert.this.tradeUUID)) {
                        i.setItem(41, SUtil.getStack(Sputnik.trans("&eDeal timer..."), Material.INK_SACK, (short)8, 1, ChatColor.GRAY + "Trading with " + TradeGUI.player1.get(TradeGUIInvert.this.tradeUUID).getName() + ".", ChatColor.GRAY + "The trade changed recently."));
                    }
                    else if (TradeMenu.tradeP2Ready.get(TradeGUIInvert.this.tradeUUID)) {
                        i.setItem(41, SUtil.getStack(Sputnik.trans("&ePending their confirm."), Material.INK_SACK, (short)8, 1, ChatColor.GRAY + "Trading with " + TradeGUI.player1.get(TradeGUIInvert.this.tradeUUID).getName() + ".", ChatColor.GRAY + "Waiting for them to confirm."));
                    }
                    else {
                        i.setItem(41, SUtil.getStack(Sputnik.trans("&eNew deal"), Material.INK_SACK, (short)8, 1, ChatColor.GRAY + "Trading with " + TradeGUI.player1.get(TradeGUIInvert.this.tradeUUID).getName() + "."));
                    }
                }
                if (TradeMenu.tradeP2Countdown.containsKey(TradeGUIInvert.this.tradeUUID)) {
                    if (TradeMenu.tradeP2Countdown.get(TradeGUIInvert.this.tradeUUID) > 0) {
                        i.setItem(39, SUtil.getStack(Sputnik.trans("&eDeal timer! &7(&e" + TradeMenu.tradeP2Countdown.get(TradeGUIInvert.this.tradeUUID) + "&7)"), Material.STAINED_CLAY, (short)4, TradeMenu.tradeP2Countdown.get(TradeGUIInvert.this.tradeUUID), ChatColor.GRAY + "The trade recently changed.", ChatColor.GRAY + "Please review it before", ChatColor.GRAY + "accepting."));
                        TradeMenu.tradeP2Ready.put(TradeGUIInvert.this.tradeUUID, false);
                    }
                    else if (TradeMenu.tradeP2Ready.get(TradeGUIInvert.this.tradeUUID)) {
                        i.setItem(39, SUtil.getStack(Sputnik.trans("&aDeal accepted!"), Material.STAINED_CLAY, (short)13, 1, ChatColor.GRAY + "You accepted the trade.", ChatColor.GRAY + "wait for the other party to", ChatColor.GRAY + "accept."));
                    }
                    else if (TradeGUI.itemOfferP1.get(TradeGUIInvert.this.tradeUUID).size() <= 0 && TradeGUI.itemOfferP2.get(TradeGUIInvert.this.tradeUUID).size() <= 0) {
                        i.setItem(39, SUtil.getStack(Sputnik.trans("&aTrading!"), Material.STAINED_CLAY, (short)13, 1, ChatColor.GRAY + "Click an item in your", ChatColor.GRAY + "inventory to offer it for", ChatColor.GRAY + "trade."));
                    }
                    else if (TradeGUI.itemOfferP1.get(TradeGUIInvert.this.tradeUUID).size() <= 0 && !TradeMenu.tradeP2Ready.get(TradeGUIInvert.this.tradeUUID)) {
                        i.setItem(39, SUtil.getStack(Sputnik.trans("&eWarning!"), Material.STAINED_CLAY, (short)1, 1, ChatColor.GRAY + "You are offering items", ChatColor.GRAY + "without getting anything in", ChatColor.GRAY + "return.", " ", ChatColor.YELLOW + "Click to accept anyway!"));
                    }
                    else if (TradeGUI.itemOfferP2.get(TradeGUIInvert.this.tradeUUID).size() <= 0) {
                        i.setItem(39, SUtil.getStack(Sputnik.trans("&bGift!"), Material.STAINED_CLAY, (short)11, 1, ChatColor.GRAY + "You are receiving items", ChatColor.GRAY + "without offering anything in", ChatColor.GRAY + "return.", " ", ChatColor.YELLOW + "Click to accept!"));
                    }
                    else if (TradeGUI.itemOfferP1.get(TradeGUIInvert.this.tradeUUID).size() > 0 && TradeGUI.itemOfferP2.get(TradeGUIInvert.this.tradeUUID).size() > 0) {
                        i.setItem(39, SUtil.getStack(Sputnik.trans("&eDeal!"), Material.STAINED_CLAY, (short)5, 1, ChatColor.GRAY + "All trades are final and", ChatColor.GRAY + "cannot be reverted.", " ", ChatColor.GREEN + "Make sure to review the", ChatColor.GREEN + "trade before accepting", " ", ChatColor.YELLOW + "Click to accept the trade!"));
                    }
                }
                final List<ItemStack> stl1 = TradeGUI.itemOfferP1.get(TradeGUIInvert.this.tradeUUID);
                final List<ItemStack> stl2 = TradeGUI.itemOfferP2.get(TradeGUIInvert.this.tradeUUID);
                final ItemStack stk = SUtil.getSingleLoreStack(ChatColor.GRAY + "\u21e6 Your stuff", Material.STAINED_GLASS_PANE, (short)0, 1, ChatColor.GRAY + "Their stuff \u21e8");
                stk.setDurability((short)7);
                TradeGUIInvert.this.fillFrom(i, 4, 5, stk);
                int a = -1;
                for (final int slot : TradeGUIInvert.this.rs) {
                    if (a < stl1.size() - 1) {
                        ++a;
                        if (SItem.find(stl1.get(a)) != null) {
                            i.setItem(slot, User.getUser(TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID).getUniqueId()).updateItemBoost(SItem.find(stl1.get(a))));
                        }
                        else {
                            i.setItem(slot, (ItemStack)stl1.get(a));
                        }
                    }
                    else {
                        i.setItem(slot, (ItemStack)null);
                    }
                }
                int b = -1;
                for (final int slot2 : TradeGUIInvert.this.ls) {
                    if (b < stl2.size() - 1) {
                        ++b;
                        if (SItem.find(stl2.get(b)) != null) {
                            i.setItem(slot2, User.getUser(TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID).getUniqueId()).updateItemBoost(SItem.find(stl2.get(b))));
                        }
                        else {
                            i.setItem(slot2, (ItemStack)stl2.get(b));
                        }
                    }
                    else {
                        i.setItem(slot2, (ItemStack)null);
                    }
                }
            }
        }.runTaskTimer((Plugin)Skyblock.getPlugin(), 0L, 1L);
        this.set(new GUISignItem() {
            @Override
            public GUI onSignClose(final String query, final Player target) {
                if (target != TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID)) {
                    return null;
                }
                if (query == "$canc") {
                    return new TradeGUI(TradeGUIInvert.this.tradeUUID);
                }
                try {
                    final Economy econ = Skyblock.getEconomy();
                    final long add = Long.parseLong(query);
                    final double cur = econ.getBalance((OfflinePlayer)TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID));
                    if (add <= 0L) {
                        TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID).playSound(TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID).getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, -4.0f);
                        player.sendMessage(ChatColor.RED + "Couldn't validate this Bits amount!");
                        return new TradeGUIInvert(TradeGUIInvert.this.tradeUUID);
                    }
                    if (add > cur) {
                        TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID).playSound(TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID).getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, -4.0f);
                        player.sendMessage(ChatColor.RED + "You don't have that much Bits for this.");
                        return new TradeGUIInvert(TradeGUIInvert.this.tradeUUID);
                    }
                    if (add > 640000L) {
                        TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID).playSound(TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID).getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, -4.0f);
                        player.sendMessage(ChatColor.RED + "You cannot transfer more than 640,000 Bits at once!");
                        return new TradeGUIInvert(TradeGUIInvert.this.tradeUUID);
                    }
                    if (TradeGUI.itemOfferP2.get(TradeGUIInvert.this.tradeUUID).size() < 16) {
                        if (econ.withdrawPlayer((OfflinePlayer)TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID), (double)add).transactionSuccess()) {
                            TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID).playSound(TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID).getLocation(), Sound.VILLAGER_HAGGLE, 1.0f, 1.0f);
                            TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID).playSound(TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID).getLocation(), Sound.VILLAGER_HAGGLE, 1.0f, 1.0f);
                            final long stackamount = Math.min(64L, Math.max(10000L, add) / 10000L);
                            ItemStack coinsStack = SUtil.getSkullURLStack(ChatColor.AQUA + Sputnik.formatFull((float)add) + " Bits", "7b951fed6a7b2cbc2036916dec7a46c4a56481564d14f945b6ebc03382766d3b", (int)stackamount, ChatColor.GRAY + "Lump-sum amount");
                            final net.minecraft.server.v1_8_R3.ItemStack tagStack = CraftItemStack.asNMSCopy(coinsStack);
                            final NBTTagCompound tagCompound = tagStack.hasTag() ? tagStack.getTag() : new NBTTagCompound();
                            tagCompound.set("data_bits", (NBTBase)new NBTTagLong(add));
                            tagStack.setTag(tagCompound);
                            coinsStack = CraftItemStack.asBukkitCopy(tagStack);
                            TradeGUI.itemOfferP2.get(TradeGUIInvert.this.tradeUUID).add(coinsStack);
                            TradeMenu.tradeP1Countdown.put(TradeGUIInvert.this.tradeUUID, 3);
                            TradeMenu.tradeP2Countdown.put(TradeGUIInvert.this.tradeUUID, 3);
                        }
                        else {
                            TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID).playSound(TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID).getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, -4.0f);
                            player.sendMessage(ChatColor.RED + "An unexpected error occured while attempting to access the economy!");
                        }
                    }
                    return new TradeGUIInvert(TradeGUIInvert.this.tradeUUID);
                }
                catch (NumberFormatException ex) {
                    player.sendMessage(ChatColor.RED + "Couldn't parse this Bits amount!");
                    TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID).playSound(TradeGUI.player2.get(TradeGUIInvert.this.tradeUUID).getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, -4.0f);
                    return new TradeGUIInvert(TradeGUIInvert.this.tradeUUID);
                }
            }

            @Override
            public void run(final InventoryClickEvent e) {
                player.playSound(player.getLocation(), Sound.CLICK, 1.0f, 1.0f);
            }

            @Override
            public int getSlot() {
                return 36;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getSkullURLStack(ChatColor.AQUA + "Bits transaction", "7b951fed6a7b2cbc2036916dec7a46c4a56481564d14f945b6ebc03382766d3b", 1, ChatColor.GRAY + " ", ChatColor.YELLOW + "Click to add bits!");
            }

            @Override
            public UUID inti() {
                return TradeGUIInvert.this.tradeUUID;
            }
        });
    }

    @Override
    public void onClose(final InventoryCloseEvent e) {
        ((Player)e.getPlayer()).playSound(((Player)e.getPlayer()).getLocation(), Sound.VILLAGER_HAGGLE, 1.0f, 1.0f);
        TradeMenu.triggerCloseEvent(this.tradeUUID, false, (Player)e.getPlayer());
        GUIListener.QUERY_MAP.remove(e.getPlayer().getUniqueId());
        GUIListener.QUERY_MAPPING.remove(e.getPlayer().getUniqueId());
    }

    @Override
    public void onBottomClick(final InventoryClickEvent e) {
        if (e.getSlot() < 0) {
            e.setCancelled(true);
            return;
        }
        ItemStack cs = null;
        if (TradeGUI.player2.get(this.tradeUUID).getInventory().getItem(e.getSlot()) != null) {
            cs = TradeGUI.player2.get(this.tradeUUID).getInventory().getItem(e.getSlot());
        }
        if (cs != null) {
            final SItem sItem = SItem.find(cs);
            if (sItem != null && SItem.isSpecItem(cs)) {
                if (!(sItem.getType().getGenericInstance() instanceof Untradeable)) {
                    if (TradeGUI.itemOfferP2.get(this.tradeUUID).size() < 16) {
                        TradeGUI.player1.get(this.tradeUUID).playSound(TradeGUI.player1.get(this.tradeUUID).getLocation(), Sound.VILLAGER_HAGGLE, 1.0f, 1.0f);
                        TradeGUI.player2.get(this.tradeUUID).playSound(TradeGUI.player2.get(this.tradeUUID).getLocation(), Sound.VILLAGER_HAGGLE, 1.0f, 1.0f);
                        TradeGUI.itemOfferP2.get(this.tradeUUID).add(cs);
                        TradeGUI.player2.get(this.tradeUUID).getInventory().setItem(e.getSlot(), (ItemStack)null);
                        TradeMenu.tradeP2Countdown.put(this.tradeUUID, 3);
                        TradeMenu.tradeP1Countdown.put(this.tradeUUID, 3);
                    }
                    else {
                        TradeGUI.player2.get(this.tradeUUID).sendMessage(Sputnik.trans("&c&lIT'S FULL! &7Your trade window is full!"));
                        TradeGUI.player2.get(this.tradeUUID).playSound(TradeGUI.player2.get(this.tradeUUID).getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
                        TradeGUI.player2.get(this.tradeUUID).playSound(TradeGUI.player2.get(this.tradeUUID).getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, -4.0f);
                    }
                }
                else {
                    TradeGUI.player2.get(this.tradeUUID).sendMessage(Sputnik.trans("&cYou cannot trade this item!"));
                    TradeGUI.player2.get(this.tradeUUID).playSound(TradeGUI.player2.get(this.tradeUUID).getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, -4.0f);
                }
            }
            else {
                TradeGUI.player2.get(this.tradeUUID).sendMessage(Sputnik.trans("&cYou cannot trade this item!"));
                TradeGUI.player2.get(this.tradeUUID).playSound(TradeGUI.player2.get(this.tradeUUID).getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, -4.0f);
            }
        }
    }

    @Override
    public void onTopClick(final InventoryClickEvent e) {
        if (TradeGUI.itemOfferP2.get(this.tradeUUID).contains(e.getInventory().getItem(e.getSlot())) && TradeGUI.isContain(this.ls, e.getSlot())) {
            TradeGUI.player2.get(this.tradeUUID).playSound(TradeGUI.player2.get(this.tradeUUID).getLocation(), Sound.VILLAGER_IDLE, 1.0f, 1.0f);
            TradeGUI.itemOfferP2.get(this.tradeUUID).remove(e.getInventory().getItem(e.getSlot()));
            final ItemStack stack = e.getInventory().getItem(e.getSlot());
            final net.minecraft.server.v1_8_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(stack);
            if (!nmsStack.getTag().hasKey("data_bits")) {
                Sputnik.smartGiveItem(stack, TradeGUI.player2.get(this.tradeUUID));
            }
            else {
                final Economy econ = Skyblock.getEconomy();
                econ.depositPlayer((OfflinePlayer)TradeGUI.player2.get(this.tradeUUID), (double)nmsStack.getTag().getLong("data_bits"));
            }
            TradeMenu.tradeP2Countdown.put(this.tradeUUID, 3);
            TradeMenu.tradeP1Countdown.put(this.tradeUUID, 3);
        }
    }
}
