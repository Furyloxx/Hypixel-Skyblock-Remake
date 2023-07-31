package me.godspunky.skyblock.gui;

import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;
import me.godspunky.skyblock.util.SUtil;

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

                    SUtil.toShopItem(SMaterial.WHEAT, 3 , 10L , 6L),
                    SUtil.toShopItem(SMaterial.CARROT_ITEM, 3 , 10L , 3L),
                    SUtil.toShopItem(SMaterial.POTATO_ITEM, 3 , 10L , 3L),
                    SUtil.toShopItem(SMaterial.MELON, 10 , 4L , 2L),
                    SUtil.toShopItem(SMaterial.SUGAR_CANE, 3 , 10L , 4L),
                    SUtil.toShopItem(SMaterial.PUMPKIN, 1 , 25L , 10L),
                    SUtil.toShopItem(SMaterial.COCOA_BEANS, 1 , 5L , 3L),
                    SUtil.toShopItem(SMaterial.RED_MUSHROOM, 1 , 12L , 10L),
                    SUtil.toShopItem(SMaterial.BROWN_MUSHROOM, 1 , 12L , 10L),
                    SUtil.toShopItem(SMaterial.SAND, 2 , 4L , 2L),
                    SUtil.toShopItem(SMaterial.CACTUS, 1 , 10L , 3L),
                    SUtil.toShopItem(SMaterial.ROOKIE_HOE, 1 , 10L , 3L),

            };

    public FarmMerchantGUI(int page) {
        super("Farm Merchant", page, ITEMS);
    }

    public FarmMerchantGUI() {
        this(1);
    }
}