package me.godspunky.skyblock.gui;

import me.godspunky.skyblock.features.item.*;
import me.godspunky.skyblock.util.SUtil;
import me.godspunky.skyblock.util.Sputnik;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class RecipeBookGUI
        extends GUI {
    private static final int[] CRAFT_SLOTS = new int[]{10, 11, 12, 19, 20, 21, 28, 29, 30};
    private final SItem targetItem;

    public RecipeBookGUI(SItem sitem) {
        super(ChatColor.stripColor(sitem.getFullName() + " Recipe"), 54);
        this.targetItem = sitem;
    }

    @Override
    public void onOpen(GUIOpenEvent e) {
        Player player = e.getPlayer();
        this.fill(BLACK_STAINED_GLASS_PANE);
        this.set(GUIClickableItem.getCloseItem(49));
        this.set(23, SUtil.getStack(Sputnik.trans("&aCrafting Table"), Material.WORKBENCH, (short) 0, 1, Arrays.asList(Sputnik.trans("&7Craft this recipe by using a"), Sputnik.trans("&7Crafting Table"))));
        this.set(25, this.targetItem.getStack());
        this.set(GUIClickableItem.createGUIOpenerItem(GUIType.RECIPE_BOOK, player, ChatColor.GREEN + "Go Back", 48, Material.ARROW, ChatColor.GRAY + "To Recipe Book"));
        int z = 0;
        for (ShapedRecipe sr : ShapedRecipe.CACHED_RECIPES) {
            if (sr.getResult().getType() != this.targetItem.getType()) continue;
            MaterialQuantifiable[][] lr = sr.toMQ2DArray();
            for (int i = 0; i < 3; ++i) {
                for (int j = 0; j < 3; ++j) {
                    if (lr[i][j] == null) {
                        this.set(CRAFT_SLOTS[z], null);
                    } else if (lr[i][j].getMaterial() != SMaterial.AIR) {
                        ItemStack is = SItem.of(lr[i][j].getMaterial()).getStack();
                        is.setAmount(lr[i][j].getAmount());
                        this.set(CRAFT_SLOTS[z], is);
                    } else {
                        this.set(CRAFT_SLOTS[z], null);
                    }
                    ++z;
                }
            }
        }
        for (ShapelessRecipe shapelessRecipe : ShapelessRecipe.CACHED_RECIPES){
            if (shapelessRecipe.getResult().getType() != this.targetItem.getType()) continue;
            for (MaterialQuantifiable lr : shapelessRecipe.getIngredientList()){
                if (lr == null) continue;
                ItemStack is = SItem.of(lr.getMaterial()).getStack();
                if (is == null) continue;
                is.setAmount(lr.getAmount());
                if (z >= CRAFT_SLOTS.length) continue;
                this.set(CRAFT_SLOTS[z], is);
                ++z;
            }
        }
    }
}

