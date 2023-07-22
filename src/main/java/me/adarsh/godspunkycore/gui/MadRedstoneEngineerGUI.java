package me.adarsh.godspunkycore.gui;

import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.util.SUtil;

public class MadRedstoneEngineerGUI extends ShopGUI {
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

                    SUtil.toShopItem(SMaterial.REDSTONE_TORCH_ON, 1 , 2L , 1L),
                    SUtil.toShopItem(SMaterial.REDSTONE, 1 , 4L , 2L),
                    SUtil.toShopItem(SMaterial.DAYLIGHT_DETECTOR, 1 , 18L , 5L),
                    SUtil.toShopItem(SMaterial.WOOD_PLATE, 1 , 2L , 1L),
                    SUtil.toShopItem(SMaterial.STONE_PLATE, 1 , 4L , 2L),
                    SUtil.toShopItem(SMaterial.IRON_PLATE, 1 , 12L , 5L),
                    SUtil.toShopItem(SMaterial.GOLD_PLATE, 1 , 16L , 7L),
                    SUtil.toShopItem(SMaterial.LEVER, 1 , 2L , 1L),
                    SUtil.toShopItem(SMaterial.REDSTONE_COMPARATOR, 1 , 5L , 2L),
                    SUtil.toShopItem(SMaterial.TRIPWIRE_HOOK, 1 , 4L , 2L),
                    SUtil.toShopItem(SMaterial.TNT, 1 , 50L , 20L),
                    SUtil.toShopItem(SMaterial.HOPPER, 1 , 50L , 20L),
            };

    public MadRedstoneEngineerGUI(int page) {
        super("Mad Redstone Engineer", page, ITEMS);
    }

    public MadRedstoneEngineerGUI() {
        this(1);
    }
}
