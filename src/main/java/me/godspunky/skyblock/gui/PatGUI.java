package me.godspunky.skyblock.gui;

import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;
import me.godspunky.skyblock.util.SUtil;

public class PatGUI extends ShopGUI {
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
                     * | ----------------------------------------------------------------|
                     */

                    SUtil.toShopItem(SMaterial.FLINT, 10 , 6L , 4L),
                    SUtil.toShopItem(SMaterial.GRAVEL, 15 , 5L , 3L),
            };

    public PatGUI(int page) {
        super("Pat", page, ITEMS);
    }

    public PatGUI() {
        this(1);
    }
}


