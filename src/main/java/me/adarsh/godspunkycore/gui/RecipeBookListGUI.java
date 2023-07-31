package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.ShapedRecipe;
import me.adarsh.godspunkycore.features.item.ShapelessRecipe;
import me.adarsh.godspunkycore.util.PaginationList;
import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class RecipeBookListGUI extends GUI {
    private static final int[] INTERIOR = new int[]{10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43};

    public RecipeBookListGUI(String query, int page) {
        super("Recipe Book", 54);
        this.border(BLACK_STAINED_GLASS_PANE);
        PaginationList<SItem> pagedMaterials = new PaginationList(28);
        for (ShapedRecipe sr : ShapedRecipe.CACHED_RECIPES) {
            String lc = sr.getResult().getType().toString().toLowerCase();
            pagedMaterials.add(sr.getResult());
        }
        for(ShapelessRecipe slr : ShapelessRecipe.CACHED_RECIPES){
            pagedMaterials.add(slr.getResult());
        }
        if (pagedMaterials.size() == 0) {
            page = 0;
        }
        this.title = "Recipe Book (" + page + "/" + pagedMaterials.getPageCount() + ")";
        final int finalPage = page;
        if (page > 1) {
            this.set(new GUIClickableItem() {

                @Override
                public void run(InventoryClickEvent e) {
                    new RecipeBookListGUI(finalPage - 1).open((Player) e.getWhoClicked());
                    ((Player) e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.NOTE_PIANO, 1.0f, 1.0f);
                }

                @Override
                public int getSlot() {
                    return 45;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.createNamedItemStack(Material.ARROW, ChatColor.GRAY + "Pervious Page");
                }
            });
        }
        if (page != pagedMaterials.getPageCount()) {
            this.set(new GUIClickableItem() {

                @Override
                public void run(InventoryClickEvent e) {
                    new RecipeBookListGUI(finalPage + 1).open((Player) e.getWhoClicked());
                    ((Player) e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.NOTE_PIANO, 1.0f, 1.0f);
                }

                @Override
                public int getSlot() {
                    return 53;
                }

                @Override
                public ItemStack getItem() {
                    return SUtil.createNamedItemStack(Material.ARROW, ChatColor.GRAY + "Next Page");
                }
            });
        }
        this.set(GUIClickableItem.getCloseItem(49));
        List p = pagedMaterials.getPage(page);
        if (p == null) {
            return;
        }
        for (int i = 0; i < p.size(); ++i) {
            final int slot = INTERIOR[i];
            final SItem sItem = (SItem) p.get(i);
            this.set(new GUIClickableItem() {

                @Override
                public void run(InventoryClickEvent e) {
                    Player player = (Player) e.getWhoClicked();
                    player.playSound(player.getLocation(), Sound.NOTE_PLING, 1.0f, 2.0f);
                    new RecipeBookGUI(sItem).open(player);
                }

                @Override
                public int getSlot() {
                    return slot;
                }

                @Override
                public ItemStack getItem() {
                    return sItem.getStack();
                }
            });
        }
    }

    @Override
    public void onOpen(GUIOpenEvent e) {
        Player player = e.getPlayer();
        this.set(GUIClickableItem.createGUIOpenerItem(GUIType.SKYBLOCK_MENU, player, ChatColor.GREEN + "Go Back", 48, Material.ARROW, ChatColor.GRAY + "To SkyBlock Menu"));
    }

    public RecipeBookListGUI(String query) {
        this(query, 1);
    }

    public RecipeBookListGUI(int page) {
        this("", page);
    }

    public RecipeBookListGUI() {
        this(1);
    }
}

