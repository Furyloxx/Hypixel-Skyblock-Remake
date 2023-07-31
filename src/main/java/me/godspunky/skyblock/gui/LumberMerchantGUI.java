package me.godspunky.skyblock.gui;

import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;
import me.godspunky.skyblock.util.SUtil;

public class LumberMerchantGUI extends ShopGUI {
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

                    SUtil.toShopItem(SMaterial.OAK_WOOD, 5 , 25L , 5L),
                    SUtil.toShopItem(SMaterial.BIRCH_WOOD, 5 , 25L , 5L),
                    SUtil.toShopItem(SMaterial.SPRUCE_WOOD, 5 , 25L , 5L),
                    SUtil.toShopItem(SMaterial.DARK_OAK_WOOD, 5 , 25L , 5L),
                    SUtil.toShopItem(SMaterial.ACACIA_WOOD, 5 , 25L , 5L),
                    SUtil.toShopItem(SMaterial.JUNGLE_WOOD, 5 , 25L , 5L),
                    SUtil.toShopItem(SMaterial.STICK, 32 , 2L , 1L),
                    SUtil.toShopItem(SMaterial.ROOKIE_AXE, 1 , 12L , 6L),
                    SUtil.toShopItem(SMaterial.PROMISING_AXE, 1 , 35L , 15L),
                    SUtil.toShopItem(SMaterial.PODZOL, 1 , 20L , 10L),
                    SUtil.toShopItem(SMaterial.WOOD_SWORD, 1 , 5L , 1L),
                    SUtil.toShopItem(SMaterial.WOOD_PICKAXE, 1 , 5L , 1L),
                    SUtil.toShopItem(SMaterial.WOOD_SHOVEL, 1 , 5L , 1L),
                    SUtil.toShopItem(SMaterial.WOOD_HOE, 1 , 5L , 1L),
                    SUtil.toShopItem(SMaterial.WOOD_AXE, 1 , 5L , 1L),
            };

    public LumberMerchantGUI(int page) {
        super("Lumber Merchant", page, ITEMS);
    }

    public LumberMerchantGUI() {
        this(1);
    }
}