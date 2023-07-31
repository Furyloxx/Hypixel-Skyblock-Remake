package me.godspunky.skyblock.gui;

import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;
import me.godspunky.skyblock.util.SUtil;

public class FishMerchantGUI extends ShopGUI {
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

                    SUtil.toShopItem(SMaterial.FISHING_ROD, 1 , 100L , 40L),
                    SUtil.toShopItem(SMaterial.RAW_FISH, 1 , 20L , 6L),
                    SUtil.toShopItem(SMaterial.RAW_SALMON, 1 , 30L , 10L),
                    SUtil.toShopItem(SMaterial.PUFFERFISH, 1 , 40L , 15L),
            };

    public FishMerchantGUI(int page) {
        super("Fish Merchant", page, ITEMS);
    }

    public FishMerchantGUI() {
        this(1);
    }
}