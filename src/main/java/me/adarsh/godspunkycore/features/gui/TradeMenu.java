package me.adarsh.godspunkycore.features.gui;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import me.adarsh.godspunkycore.util.Sputnik;
import me.adarsh.godspunkycore.util.TradeUtil;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.OfflinePlayer;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import me.adarsh.godspunkycore.sequence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TradeMenu
{
    public static final Map<UUID, Boolean> tradeClose;
    public static final Map<UUID, Player> tradeClosePlayerName;
    public static final Map<UUID, Integer> tradeP1Countdown;
    public static final Map<UUID, Integer> tradeP2Countdown;
    public static final Map<UUID, Boolean> tradeP1Ready;
    public static final Map<UUID, Boolean> tradeP2Ready;
    public static final Map<UUID, Boolean> successTrade;
    public static final Map<UUID, Boolean> player1TradeUUID;
    public static final Map<UUID, Boolean> player2TradeUUID;
    private Player p1;
    private Player p2;
    private UUID tradeUUID;

    public TradeMenu(final Player player1, final Player player2, final UUID uuid) {
        this.p1 = player1;
        this.p2 = player2;
        this.tradeUUID = uuid;
    }

    public static void triggerCloseEvent(final UUID tradeUUID, final boolean isSuccess, final Player player) {
        if (TradeMenu.tradeClose.containsKey(tradeUUID)) {
            return;
        }
        if (!isSuccess) {
            TradeMenu.tradeClose.put(tradeUUID, isSuccess);
            TradeMenu.tradeClosePlayerName.put(tradeUUID, player);
        }
        else {
            TradeMenu.tradeClose.put(tradeUUID, isSuccess);
            TradeMenu.tradeClosePlayerName.put(tradeUUID, player);
        }
    }

    public void open() {
        if (this.p1.getUniqueId() == this.p2.getUniqueId()) {
            return;
        }
        TradeUtil.trading.put(this.p1.getUniqueId(), true);
        TradeUtil.trading.put(this.p2.getUniqueId(), true);
        TradeGUI.player1.put(this.tradeUUID, this.p1);
        TradeGUI.player2.put(this.tradeUUID, this.p2);
        new TradeGUI(this.tradeUUID).open(this.p1);
        new TradeGUIInvert(this.tradeUUID).open(this.p2);
        new BukkitRunnable() {
            public void run() {
                if (!TradeMenu.this.p1.isOnline() || !TradeMenu.this.p2.isOnline()) {
                    if (!TradeMenu.this.p1.isOnline()) {
                        TradeMenu.triggerCloseEvent(TradeMenu.this.tradeUUID, false, TradeMenu.this.p1);
                    }
                    else if (!TradeMenu.this.p2.isOnline()) {
                        TradeMenu.triggerCloseEvent(TradeMenu.this.tradeUUID, false, TradeMenu.this.p2);
                    }
                }
                if (TradeMenu.tradeClose.containsKey(TradeMenu.this.tradeUUID)) {
                    this.cancel();
                    User.getUser(TradeMenu.this.p1.getUniqueId()).updateInventory();
                    User.getUser(TradeMenu.this.p2.getUniqueId()).updateInventory();
                    if (!TradeMenu.tradeClose.get(TradeMenu.this.tradeUUID)) {
                        if (TradeMenu.tradeClosePlayerName.get(TradeMenu.this.tradeUUID) == TradeMenu.this.p1) {
                            TradeMenu.this.p1.sendMessage(Sputnik.trans("&cYou cancelled the trade!"));
                            TradeMenu.this.p2.sendMessage(Sputnik.trans("&b" + TradeMenu.this.p1.getName() + " &ccancelled the trade!"));
                            TradeMenu.this.p2.closeInventory();
                        }
                        else {
                            TradeMenu.this.p2.sendMessage(Sputnik.trans("&cYou cancelled the trade!"));
                            TradeMenu.this.p1.sendMessage(Sputnik.trans("&b" + TradeMenu.this.p2.getName() + " &ccancelled the trade!"));
                            TradeMenu.this.p1.closeInventory();
                        }
                        TradeMenu.this.clean();
                    }
                    else if (TradeMenu.successTrade.containsKey(TradeMenu.this.tradeUUID)) {
                        if (TradeMenu.successTrade.get(TradeMenu.this.tradeUUID)) {
                            final List<ItemStack> itemlist1 = TradeGUI.itemOfferP1.get(TradeMenu.this.tradeUUID);
                            final List<ItemStack> itemlist2 = TradeGUI.itemOfferP2.get(TradeMenu.this.tradeUUID);
                            TradeGUI.itemOfferP1.put(TradeMenu.this.tradeUUID, itemlist2);
                            TradeGUI.itemOfferP2.put(TradeMenu.this.tradeUUID, itemlist1);
                        }
                        final List<ItemStack> itemlist1 = TradeGUI.itemOfferP1.get(TradeMenu.this.tradeUUID);
                        final List<ItemStack> itemlist2 = TradeGUI.itemOfferP2.get(TradeMenu.this.tradeUUID);
                        final StringBuilder sb1 = new StringBuilder();
                        sb1.append("&6Trade completed with &r" + TradeMenu.this.p2.getDisplayName() + "&6!");
                        for (final ItemStack itemRece : itemlist1) {
                            if (!CraftItemStack.asNMSCopy(itemRece).getTag().hasKey("data_bits")) {
                                sb1.append("\n &a&l+ &8" + itemRece.getAmount() + "x &r" + itemRece.getItemMeta().getDisplayName());
                            }
                            else {
                                sb1.append("\n &a&l+ &8" + itemRece.getItemMeta().getDisplayName());
                            }
                        }
                        for (final ItemStack itemTaken : itemlist2) {
                            if (!CraftItemStack.asNMSCopy(itemTaken).getTag().hasKey("data_bits")) {
                                sb1.append("\n &c&l- &8" + itemTaken.getAmount() + "x &r" + itemTaken.getItemMeta().getDisplayName());
                            }
                            else {
                                sb1.append("\n &c&l- &8" + itemTaken.getItemMeta().getDisplayName());
                            }
                        }
                        TradeMenu.this.p1.sendMessage(Sputnik.trans(sb1.toString()));
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("&6Trade completed with " + TradeMenu.this.p1.getDisplayName() + "&6!");
                        for (final ItemStack itemRece2 : itemlist2) {
                            if (!CraftItemStack.asNMSCopy(itemRece2).getTag().hasKey("data_bits")) {
                                sb2.append("\n &a&l+ &8" + itemRece2.getAmount() + "x &r" + itemRece2.getItemMeta().getDisplayName());
                            }
                            else {
                                sb2.append("\n &a&l+ &8" + itemRece2.getItemMeta().getDisplayName());
                            }
                        }
                        for (final ItemStack itemTaken2 : itemlist1) {
                            if (!CraftItemStack.asNMSCopy(itemTaken2).getTag().hasKey("data_bits")) {
                                sb2.append("\n &c&l- &8" + itemTaken2.getAmount() + "x &r" + itemTaken2.getItemMeta().getDisplayName());
                            }
                            else {
                                sb2.append("\n &c&l- &8" + itemTaken2.getItemMeta().getDisplayName());
                            }
                        }
                        TradeMenu.this.p2.sendMessage(Sputnik.trans(sb2.toString()));
                        SoundSequenceType.TRADE_COMPLETE.play(TradeMenu.this.p1);
                        SoundSequenceType.TRADE_COMPLETE.play(TradeMenu.this.p2);
                        TradeMenu.this.p1.closeInventory();
                        TradeMenu.this.p2.closeInventory();
                        User.getUser(TradeMenu.this.p1.getUniqueId()).updateInventory();
                        User.getUser(TradeMenu.this.p2.getUniqueId()).updateInventory();
                        TradeMenu.this.clean();
                        TradeGUI.itemOfferP1.remove(TradeMenu.this.p1.getUniqueId());
                        TradeGUI.itemOfferP2.remove(TradeMenu.this.p2.getUniqueId());
                    }
                    TradeMenu.this.returnToAllPlayers(TradeMenu.this.p1, TradeMenu.this.p2);
                }
            }
        }.runTaskTimer((Plugin) Skyblock.getPlugin(), 0L, 1L);
    }

    public void clean() {
        SUtil.delay(() -> {
            TradeMenu.player1TradeUUID.remove(this.p1.getUniqueId());
            TradeMenu.player2TradeUUID.remove(this.p2.getUniqueId());
            TradeMenu.tradeClose.remove(this.tradeUUID);
            TradeMenu.tradeClosePlayerName.remove(this.tradeUUID);
            TradeMenu.tradeP1Countdown.remove(this.tradeUUID);
            TradeMenu.tradeP2Countdown.remove(this.tradeUUID);
            TradeMenu.tradeP1Ready.remove(this.tradeUUID);
            TradeMenu.tradeP2Ready.remove(this.tradeUUID);
            TradeGUI.itemOfferP1.remove(this.p1.getUniqueId());
            TradeGUI.itemOfferP2.remove(this.p2.getUniqueId());
            TradeUtil.resetTrade(this.p1);
            TradeUtil.resetTrade(this.p2);
            TradeUtil.trading.put(this.p1.getUniqueId(), false);
            TradeUtil.trading.put(this.p2.getUniqueId(), false);
        }, 2L);
    }

    public void returnToAllPlayers(final Player player1, final Player player2) {
        for (final ItemStack i : TradeGUI.itemOfferP1.get(this.tradeUUID)) {
            final net.minecraft.server.v1_8_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(i);
            if (!nmsStack.getTag().hasKey("data_bits")) {
                Sputnik.smartGiveItem(i, player1);
            }
            else {
                final Economy econ = Skyblock.getEconomy();
                econ.depositPlayer((OfflinePlayer)player1, (double)nmsStack.getTag().getLong("data_bits"));
            }
        }
        for (final ItemStack i : TradeGUI.itemOfferP2.get(this.tradeUUID)) {
            final net.minecraft.server.v1_8_R3.ItemStack nmsStack = CraftItemStack.asNMSCopy(i);
            if (!nmsStack.getTag().hasKey("data_bits")) {
                Sputnik.smartGiveItem(i, player2);
            }
            else {
                final Economy econ = Skyblock.getEconomy();
                econ.depositPlayer((OfflinePlayer)player2, (double)nmsStack.getTag().getLong("data_bits"));
            }
        }
    }

    public Player getP1() {
        return this.p1;
    }

    public Player getP2() {
        return this.p2;
    }

    static {
        tradeClose = new HashMap<UUID, Boolean>();
        tradeClosePlayerName = new HashMap<UUID, Player>();
        tradeP1Countdown = new HashMap<UUID, Integer>();
        tradeP2Countdown = new HashMap<UUID, Integer>();
        tradeP1Ready = new HashMap<UUID, Boolean>();
        tradeP2Ready = new HashMap<UUID, Boolean>();
        successTrade = new HashMap<UUID, Boolean>();
        player1TradeUUID = new HashMap<UUID, Boolean>();
        player2TradeUUID = new HashMap<UUID, Boolean>();
    }
}
