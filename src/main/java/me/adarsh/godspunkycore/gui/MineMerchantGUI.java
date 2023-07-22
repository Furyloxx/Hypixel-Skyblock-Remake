package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.util.SUtil;

public class MineMerchantGUI extends ShopGUI {
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

                    SUtil.toShopItem(SMaterial.COAL, 2 , 4L , 2L),
                    SUtil.toShopItem(SMaterial.IRON_INGOT, 4 , 5L , 3L),
                    SUtil.toShopItem(SMaterial.GOLD_INGOT, 4 , 5L , 4L),
                    SUtil.toShopItem(SMaterial.ROOKIE_PICKAXE, 1 , 12L , 6L),
                    SUtil.toShopItem(SMaterial.PROMISING_PICKAXE, 1 , 35L , 15L),
                    SUtil.toShopItem(SMaterial.GOLD_PICKAXE, 1 , 20L , 10L),
                    SUtil.toShopItem(SMaterial.TORCH, 32 , 1L , 1L),
                    SUtil.toShopItem(SMaterial.GRAVEL, 2 , 8L , 4L),
                    SUtil.toShopItem(SMaterial.COBBLESTONE, 1 , 3L , 1L),
                    SUtil.toShopItem(SMaterial.STONE, 2 , 2L , 1L),
            };

    public MineMerchantGUI(int page) {
        super("Mine Merchant", page, ITEMS);
    }

    public MineMerchantGUI() {
        this(1);
    }
}

