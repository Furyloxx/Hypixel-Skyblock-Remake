package me.adarsh.godspunkycore.features.gui;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.user.PlayerUtils;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import me.adarsh.godspunkycore.util.Sputnik;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class CookieConfirmGUI extends GUI
{
    String[] suffix;
    private int cookieSlot;
    private ItemStack stack;

    public CookieConfirmGUI(final int cookieSlot, final ItemStack stack) {
        super("Consume Booster Cookie?", 27);
        this.suffix = new String[] { "", "&dSweet!", "&dSavory!", "&dDelicious!", "", "&dYummy!", "&dSUPREME!", "", "&dScrumptious!", "", "&dBLYATIFUL!", "&dTasty!", "" };
        this.fill(CookieConfirmGUI.BLACK_STAINED_GLASS_PANE);
        this.cookieSlot = cookieSlot;
        this.stack = stack;
    }

    public CookieConfirmGUI() {
        this(1, null);
    }

    @Override
    public void onOpen(final GUIOpenEvent e) {
        final Player player = e.getPlayer();
        final User user = User.getUser(e.getPlayer().getUniqueId());
        this.set(new GUIClickableItem() {
            @Override
            public void run(final InventoryClickEvent e) {
                if (e.getWhoClicked().getInventory().getItem(CookieConfirmGUI.this.cookieSlot) == null || CookieConfirmGUI.this.stack == null) {
                    ((Player)e.getWhoClicked()).playSound(((Player)e.getWhoClicked()).getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
                    CookieConfirmGUI.this.sendError((Player)e.getWhoClicked());
                    return;
                }
                if (!e.getWhoClicked().getInventory().getItem(CookieConfirmGUI.this.cookieSlot).toString().equalsIgnoreCase(CookieConfirmGUI.this.stack.toString())) {
                    ((Player)e.getWhoClicked()).playSound(((Player)e.getWhoClicked()).getLocation(), Sound.VILLAGER_NO, 1.0f, 1.0f);
                    CookieConfirmGUI.this.sendError((Player)e.getWhoClicked());
                    return;
                }
                ((Player)e.getWhoClicked()).getInventory().setItem(CookieConfirmGUI.this.cookieSlot, (ItemStack)null);
                PlayerUtils.setCookieDurationTicks((Player)e.getWhoClicked(), PlayerUtils.getCookieDurationTicks(player) + 3456000L);
                ((Player)e.getWhoClicked()).sendMessage(Sputnik.trans("&eYou consumed a &6Booster Cookie&e! " + CookieConfirmGUI.this.suffix[SUtil.random(0, CookieConfirmGUI.this.suffix.length - 1)]));
                ((Player)e.getWhoClicked()).closeInventory();
                ((Player)e.getWhoClicked()).playSound(((Player)e.getWhoClicked()).getLocation(), Sound.CLICK, 1.0f, 1.0f);
                CookieConfirmGUI.this.playParticle((Player)e.getWhoClicked());
                user.saveCookie();
            }

            @Override
            public ItemStack getItem() {
                if (PlayerUtils.getCookieDurationTicks(player) <= 0L) {
                    return SUtil.enchant(SUtil.getStack(ChatColor.YELLOW + "Consume Cookie", Material.COOKIE, (short)0, 1, Sputnik.trans("&7Gain the &dCookie Buff&7!"), "", Sputnik.trans("&7Duration: &b2 days&7!"), "", Sputnik.trans("&7Duration after: &b" + SUtil.getFormattedTimeToDay(3456000L))));
                }
                return SUtil.enchant(SUtil.getStack(ChatColor.YELLOW + "Consume Cookie", Material.COOKIE, (short)0, 1, Sputnik.trans("&7Adds &b2 &7days to your"), Sputnik.trans("&dCookie Buff&7!"), "", Sputnik.trans("&7Duration after: &b" + SUtil.getFormattedTimeToDay(PlayerUtils.getCookieDurationTicks(player) + 3456000L))));
            }

            @Override
            public int getSlot() {
                return 11;
            }
        });
        this.set(new GUIClickableItem() {
            @Override
            public void run(final InventoryClickEvent e) {
                e.getWhoClicked().closeInventory();
                ((Player)e.getWhoClicked()).playSound(((Player)e.getWhoClicked()).getLocation(), Sound.CLICK, 1.0f, 1.0f);
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.RED + "Cancel", Material.STAINED_CLAY, (short)14, 1, Sputnik.trans("&7I'm not hungry..."));
            }

            @Override
            public int getSlot() {
                return 15;
            }
        });
    }

    public void sendError(final Player p) {
        p.closeInventory();
        p.sendMessage(ChatColor.RED + "An unexpected error occured while consuming this Booster Cookie! Contact server staff if this happends again.");
    }

    public void playParticle(final Player p) {
        p.getWorld().playSound(p.getLocation(), Sound.EAT, 1.0f, 1.6f);
        SUtil.delay(() -> p.getWorld().playSound(p.getLocation(), Sound.EAT, 1.0f, 1.7f), 3L);
        SUtil.delay(() -> p.getWorld().playSound(p.getLocation(), Sound.EAT, 1.0f, 1.8f), 6L);
        new BukkitRunnable() {
            int count = 0;

            public void run() {
                if (this.count >= 8) {
                    this.cancel();
                    return;
                }
                p.getWorld().playEffect(p.getLocation().add(0.0, 0.5, 0.0), Effect.POTION_SWIRL, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0, 0.5, 0.0), Effect.POTION_SWIRL, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0, 0.5, 0.0), Effect.POTION_SWIRL, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0, 0.5, 0.0), Effect.POTION_SWIRL, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0, 0.5, 0.0), Effect.POTION_SWIRL, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0, 0.5, 0.0), Effect.POTION_SWIRL, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0, 0.5, 0.0), Effect.POTION_SWIRL, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0, 0.5, 0.0), Effect.POTION_SWIRL, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0, 0.5, 0.0), Effect.POTION_SWIRL, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0, 0.5, 0.0), Effect.POTION_SWIRL, 5);
                p.getWorld().spigot().playEffect(p.getLocation(), Effect.FIREWORKS_SPARK, 0, 1, (float)SUtil.random(-1.0, 1.0), 1.0f, (float)SUtil.random(-1.0, 1.0), 0.0f, 1, 100);
                p.getWorld().spigot().playEffect(p.getLocation(), Effect.SPELL, 0, 1, (float)SUtil.random(-1.0, 1.0), 1.0f, (float)SUtil.random(-1.0, 1.0), 0.0f, 1, 100);
                p.getWorld().spigot().playEffect(p.getLocation(), Effect.FIREWORKS_SPARK, 0, 1, (float)SUtil.random(-1.0, 1.0), 1.0f, (float)SUtil.random(-1.0, 1.0), 0.0f, 1, 100);
                p.getWorld().spigot().playEffect(p.getLocation(), Effect.SPELL, 0, 1, (float)SUtil.random(-1.0, 1.0), 1.0f, (float)SUtil.random(-1.0, 1.0), 0.0f, 1, 100);
                p.getWorld().spigot().playEffect(p.getLocation(), Effect.FIREWORKS_SPARK, 0, 1, (float)SUtil.random(-1.0, 1.0), 1.0f, (float)SUtil.random(-1.0, 1.0), 0.0f, 1, 100);
                p.getWorld().spigot().playEffect(p.getLocation(), Effect.SPELL, 0, 1, (float)SUtil.random(-1.0, 1.0), 1.0f, (float)SUtil.random(-1.0, 1.0), 0.0f, 1, 100);
                p.getWorld().spigot().playEffect(p.getLocation(), Effect.FIREWORKS_SPARK, 0, 1, (float)SUtil.random(-1.0, 1.0), 1.0f, (float)SUtil.random(-1.0, 1.0), 0.0f, 1, 100);
                p.getWorld().spigot().playEffect(p.getLocation(), Effect.SPELL, 0, 1, (float)SUtil.random(-1.0, 1.0), 1.0f, (float)SUtil.random(-1.0, 1.0), 0.0f, 1, 100);
                p.getWorld().playEffect(p.getLocation().add(0.0, 0.5, 0.0), Effect.LAVA_POP, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0, 0.5, 0.0), Effect.LAVA_POP, 5);
                ++this.count;
            }
        }.runTaskTimer(Skyblock.getPlugin(), 0L, 1L);
    }
}
