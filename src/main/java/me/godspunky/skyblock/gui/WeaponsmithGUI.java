package me.godspunky.skyblock.gui;

import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;
import me.godspunky.skyblock.util.SUtil;

public class WeaponsmithGUI extends ShopGUI {
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

                    SUtil.toShopItem(SMaterial.UNDEAD_SWORD, 1 , 100L , 50L),
                    SUtil.toShopItem(SMaterial.END_SWORD, 1 , 150L , 75L),
                    SUtil.toShopItem(SMaterial.SPIDER_SWORD, 1 , 100L , 50L),
                    SUtil.toShopItem(SMaterial.DIAMOND_SWORD, 1 , 60L , 30L),
                    SUtil.toShopItem(SMaterial.BOW, 1 , 25L , 15L),
                    SUtil.toShopItem(SMaterial.ARROW, 12 , 3L , 2L),
                    SUtil.toShopItem(SMaterial.ARTISANAL_SHORTBOW, 1 , 600L , 300L),
            };

    public WeaponsmithGUI(int page) {
        super("Weaponsmith", page, ITEMS);
    }

    public WeaponsmithGUI() {
        this(1);
    }
}
