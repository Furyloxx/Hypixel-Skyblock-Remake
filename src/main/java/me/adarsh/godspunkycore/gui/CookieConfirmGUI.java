package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class CookieConfirmGUI extends GUI {
    String[] suffix = new String[] {
            "", "&dSweet!", "&dSavory!", "&dDelicious!", "", "&dYummy!", "&dSUPREME!", "", "&dScrumptious!", "",
            "&dBLYATIFUL!", "&dTasty!", "" };

    private int cookieSlot;

    private ItemStack stack;

    public CookieConfirmGUI(int cookieSlot, ItemStack stack) {
        super("Consume Booster Cookie?", 27);
        fill(BLACK_STAINED_GLASS_PANE);
        this.cookieSlot = cookieSlot;
        this.stack = stack;
    }

    public CookieConfirmGUI() {
        this(1, (ItemStack)null);
    }

    public void onOpen(GUIOpenEvent e) {
        final Player player = e.getPlayer();
        final User user = User.getUser(e.getPlayer().getUniqueId());
        set(new GUIClickableItem() {
            public void run(InventoryClickEvent e) {
                if (e.getWhoClicked().getInventory().getItem(CookieConfirmGUI.this.cookieSlot) == null || CookieConfirmGUI.this.stack == null) {
                    ((Player)e.getWhoClicked()).playSound(((Player)e.getWhoClicked()).getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
                    return;
                }
                if (!e.getWhoClicked().getInventory().getItem(CookieConfirmGUI.this.cookieSlot).toString().equalsIgnoreCase(CookieConfirmGUI.this.stack.toString())) {
                    ((Player)e.getWhoClicked()).playSound(((Player)e.getWhoClicked()).getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
                    return;
                }
                // TODO: Add Reward
            }

            public int getSlot() {
                return 11;
            }
        });
        set(new GUIClickableItem() {
            public void run(InventoryClickEvent e) {
                e.getWhoClicked().closeInventory();
                ((Player)e.getWhoClicked()).playSound(((Player)e.getWhoClicked()).getLocation(), Sound.CLICK, 1.0F, 1.0F);
            }

            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.RED + "Cancel", Material.STAINED_CLAY, (short)14, 1, new String[] { ChatColor.GRAY+"&7I'm not hungry..."});
            }

            public int getSlot() {
                return 15;
            }
        });
    }

    public void playParticle(final Player p) {
        p.getWorld().playSound(p.getLocation(), Sound.EAT, 1.0F, 1.6F);
        SUtil.delay(() -> p.getWorld().playSound(p.getLocation(), Sound.EAT, 1.0F, 1.7F), 3L);
        SUtil.delay(() -> p.getWorld().playSound(p.getLocation(), Sound.EAT, 1.0F, 1.8F), 6L);
        (new BukkitRunnable() {
            int count = 0;

            public void run() {
                if (this.count >= 8) {
                    cancel();
                    return;
                }
                p.getWorld().playEffect(p.getLocation().add(0.0D, 0.5D, 0.0D), Effect.POTION_SWIRL, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0D, 0.5D, 0.0D), Effect.POTION_SWIRL, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0D, 0.5D, 0.0D), Effect.POTION_SWIRL, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0D, 0.5D, 0.0D), Effect.POTION_SWIRL, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0D, 0.5D, 0.0D), Effect.POTION_SWIRL, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0D, 0.5D, 0.0D), Effect.POTION_SWIRL, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0D, 0.5D, 0.0D), Effect.POTION_SWIRL, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0D, 0.5D, 0.0D), Effect.POTION_SWIRL, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0D, 0.5D, 0.0D), Effect.POTION_SWIRL, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0D, 0.5D, 0.0D), Effect.POTION_SWIRL, 5);
                p.getWorld().spigot().playEffect(p.getLocation(), Effect.FIREWORKS_SPARK, 0, 1,
                        (float) SUtil.random(-1.0D, 1.0D), 1.0F, (float)SUtil.random(-1.0D, 1.0D), 0.0F, 1, 100);
                p.getWorld().spigot().playEffect(p.getLocation(), Effect.SPELL, 0, 1,
                        (float)SUtil.random(-1.0D, 1.0D), 1.0F, (float)SUtil.random(-1.0D, 1.0D), 0.0F, 1, 100);
                p.getWorld().spigot().playEffect(p.getLocation(), Effect.FIREWORKS_SPARK, 0, 1,
                        (float)SUtil.random(-1.0D, 1.0D), 1.0F, (float)SUtil.random(-1.0D, 1.0D), 0.0F, 1, 100);
                p.getWorld().spigot().playEffect(p.getLocation(), Effect.SPELL, 0, 1,
                        (float)SUtil.random(-1.0D, 1.0D), 1.0F, (float)SUtil.random(-1.0D, 1.0D), 0.0F, 1, 100);
                p.getWorld().spigot().playEffect(p.getLocation(), Effect.FIREWORKS_SPARK, 0, 1,
                        (float)SUtil.random(-1.0D, 1.0D), 1.0F, (float)SUtil.random(-1.0D, 1.0D), 0.0F, 1, 100);
                p.getWorld().spigot().playEffect(p.getLocation(), Effect.SPELL, 0, 1,
                        (float)SUtil.random(-1.0D, 1.0D), 1.0F, (float)SUtil.random(-1.0D, 1.0D), 0.0F, 1, 100);
                p.getWorld().spigot().playEffect(p.getLocation(), Effect.FIREWORKS_SPARK, 0, 1,
                        (float)SUtil.random(-1.0D, 1.0D), 1.0F, (float)SUtil.random(-1.0D, 1.0D), 0.0F, 1, 100);
                p.getWorld().spigot().playEffect(p.getLocation(), Effect.SPELL, 0, 1,
                        (float)SUtil.random(-1.0D, 1.0D), 1.0F, (float)SUtil.random(-1.0D, 1.0D), 0.0F, 1, 100);
                p.getWorld().playEffect(p.getLocation().add(0.0D, 0.5D, 0.0D), Effect.LAVA_POP, 5);
                p.getWorld().playEffect(p.getLocation().add(0.0D, 0.5D, 0.0D), Effect.LAVA_POP, 5);
                this.count++;
            }
        }).runTaskTimer((Plugin) Skyblock.getPlugin(), 0L, 1L);
    }
}
