package me.godspunky.skyblock.gui;

import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;
import me.godspunky.skyblock.util.SUtil;

public class LibrarianMerchantGUI extends ShopGUI {
    private static final SItem[] ITEMS = new SItem[]
            {
                    /*
                     * | --------------------------------------------------------------- |
                     * | this method is used to add items to Merchants                   !
                     * | : SUtil.toShopItem(SItem.of(SMaterial.WHEAT), 3 , 100L , 10L)   |
                     * |  in this example :                                              !
                     * |  args[0] = for items                                            |
                     * |  args[1] = for amount of item                                   !
                     * |  args[2] = for buy price                                        |
                     * |  args[3] = for sell price                                       !
                     * | ----------------------------------------------------------------A|
                     */

                    SUtil.toShopItem(SMaterial.EXP_BOTTLE, 1 , 30L , 5L),
                    SUtil.toShopItem(SMaterial.BOOK, 1 , 20L , 2L),
            };

    public LibrarianMerchantGUI(int page) {
        super("Librarian", page, ITEMS);
    }

    public LibrarianMerchantGUI() {
        this(1);
    }
}
