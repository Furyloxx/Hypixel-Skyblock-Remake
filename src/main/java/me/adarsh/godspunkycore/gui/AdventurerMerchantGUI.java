package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.util.SUtil;

public class AdventurerMerchantGUI extends ShopGUI {
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

                    SUtil.toShopItem(SMaterial.ROTTEN_FLESH, 1 , 8L , 2L),
                    SUtil.toShopItem(SMaterial.BONE, 1 , 8L , 2L),
                    SUtil.toShopItem(SMaterial.STRING, 1 , 10L , 3L),
                    SUtil.toShopItem(SMaterial.SLIME_BALL, 1 , 14L , 5L),
                    SUtil.toShopItem(SMaterial.GUNPOWDER, 1 , 10L , 4L),

                    // TODO : MAKE TALISMAN AND ADD HERE

            };

    public AdventurerMerchantGUI(int page) {
        super("Adventurer", page, ITEMS);
    }

    public AdventurerMerchantGUI() {
        this(1);
    }
}