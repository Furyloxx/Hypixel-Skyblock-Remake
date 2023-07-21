package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.util.SUtil;

public class FarmMerchantGUI extends ShopGUI {
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

                   SUtil.toShopItem(SItem.of(SMaterial.WHEAT), 3 , 100L , 10L),
                   SUtil.toShopItem(SItem.of(SMaterial.CARROT_ITEM), 3 , 150L , 20L),

            };

    public FarmMerchantGUI(int page) {
        super("Farm Merchant", page, ITEMS);
    }

    public FarmMerchantGUI() {
        this(1);
    }
}