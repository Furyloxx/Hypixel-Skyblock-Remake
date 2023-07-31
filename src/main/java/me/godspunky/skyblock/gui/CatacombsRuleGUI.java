package me.godspunky.skyblock.gui;

import me.godspunky.skyblock.user.PlayerStatistics;
import me.godspunky.skyblock.user.PlayerUtils;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class CatacombsRuleGUI extends GUI {
    public CatacombsRuleGUI() {
        super("Dungeons Rules and Tips", 54);
    }

    @Override
    public void onOpen(GUIOpenEvent e) {

        fill(BLACK_STAINED_GLASS_PANE);

        Player player1 = e.getPlayer();

        User user = User.getUser(player1.getUniqueId());
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(player1.getUniqueId());
        set(GUIClickableItem.getCloseItem(49));


        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {
                GUIType.CATACOMB.getGUI().open(player1);
            }

            @Override
            public int getSlot() {
                return 48;
            }

            @Override
            public ItemStack getItem(){
                return SUtil.getStack(ChatColor.GREEN + "Go Back", Material.ARROW, (short) 0, 1,
                        ChatColor.GRAY + "To Catacombs");
            }
        });


        //General Changes
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 10;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN+"General Changes", Material.COMMAND,(short) 0, 1,
                        ChatColor.GRAY+" ⋅ Cannot warp to private island",
                        ChatColor.GRAY+"while in Dungeons.",
                        ChatColor.GRAY+" ⋅ Horses and other mounts cannot",
                        ChatColor.GRAY+"be spawned.",
                        ChatColor.GRAY+" ⋅ Shops inside Dungeons take",
                        ChatColor.GRAY+"directly from your "+ChatColor.RED+"bank"+ChatColor.GRAY+". You",
                        ChatColor.GRAY+"do not have a Coin Purse.",
                        ChatColor.GRAY+" ⋅ Your "+ChatColor.GREEN+"Drop "+ChatColor.GRAY+"key triggers your",
                        ChatColor.GREEN+"Ultimate Class Ability.",
                        ChatColor.GRAY+" ⋅ You gain "+ChatColor.AQUA+"5+1%"+ChatColor.GRAY+"of your",
                        ChatColor.GRAY+"maximum mana back everytime you",
                        ChatColor.GRAY+"hit an enemy with a sword/bow.");
            }
        });

        //Combat Changes
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 12;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN+"Combat Changes", Material.DIAMOND_SWORD,(short) 0, 1,
                        ChatColor.GRAY+" ⋅ Any "+ChatColor.WHITE+"✦ Speed"+ChatColor.GRAY+" above "+ChatColor.GREEN+"100 "+ChatColor.WHITE+"✦",
                        ChatColor.WHITE+"Speed "+ChatColor.GRAY+"is nerfed by "+ChatColor.YELLOW+"66.7%",
                        ChatColor.GRAY+" ⋅ Arrows deal reduced knockback.",
                        ChatColor.GRAY+" ⋅ Damage against bosses is reduced",
                        ChatColor.GRAY+"above certain thresholds");
            }
        });

        //Enchantment Changes
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 14;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN+"Enchantment Changes", Material.ENCHANTMENT_TABLE,(short) 0, 1,
                        ChatColor.GRAY+" ⋅ "+ChatColor.GREEN+"Dragon Tracer"+ChatColor.GRAY+" Enchantment is",
                        ChatColor.GRAY+"disabled",
                        ChatColor.GRAY+" ⋅ "+ChatColor.GREEN+"Telekinesis"+ChatColor.GRAY+"Enchantment is",
                        ChatColor.GRAY+"disabled",
                        ChatColor.GRAY+" ⋅ Healing from the "+ChatColor.GREEN+"Vampirism",
                        ChatColor.GRAY+"Enchantment is nerfed"+ChatColor.YELLOW+"10x");
            }
        });

        //Gear Changes
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 28;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN+"Gear Changes", Material.IRON_CHESTPLATE,(short) 0, 1,
                        ChatColor.GRAY+" ⋅ The "+ChatColor.DARK_PURPLE+"Explosive Bow"+ChatColor.GRAY+" Doesn't",
                        ChatColor.GRAY+"explode on impact.");
            }
        });

        //Death Rule
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 30;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN+"Death Rule", Material.SKULL,(short) 0, 1,
                        ChatColor.GRAY+" ⋅ Dying turns you into a",
                        ChatColor.GREEN+"Ghost"+ ChatColor.GRAY+", granting special",
                        ChatColor.GRAY+"abilities, Ghost can be revived",
                        ChatColor.GRAY+"during the course of a Dungeon.");
            }
        });

        // Tips
        set(new GUIClickableItem() {
            @Override
            public void run(InventoryClickEvent e) {}

            @Override
            public int getSlot() {
                return 32;
            }

            @Override
            public ItemStack getItem() {
                return SUtil.getStack(ChatColor.GREEN+"Tips", Material.SIGN,(short) 0, 1,
                        ChatColor.GRAY+" ⋅ Try to use all "+ChatColor.GREEN+"5 Classes"+ChatColor.GRAY+" in",
                        ChatColor.GRAY+"your party to gain "+ChatColor.GREEN+"Class Bonuses!");
            }
        });
    }
}
