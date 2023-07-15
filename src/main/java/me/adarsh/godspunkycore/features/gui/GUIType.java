package me.adarsh.godspunkycore.features.gui;

import me.adarsh.godspunkycore.util.SUtil;

public enum GUIType {
    CRAFTING_TABLE(CraftingTableGUI.class),
    ITEM_BROWSE(ItemBrowserGUI.class),
    ANVIL(AnvilGUI.class),
    REFORGE_ANVIL(ReforgeAnvilGUI.class),
    BANKER(BankerGUI.class),
    BANKER_DEPOSIT(DepositGUI.class),
    BANKER_WITHDRAWAL(WithdrawalGUI.class),
    SKYBLOCK_MENU(SkyBlockMenuGUI.class),
    SKYBLOCK_PROFILE(SkyBlockProfileGUI.class),
    QUIVER(QuiverGUI.class),
    LIFT(LiftGUI.class),
    SLAYER(SlayerGUI.class),
    REVENANT_HORROR(RevenantHorrorGUI.class),
    TARANTULA_BROODFATHER(TarantulaBroodfatherGUI.class),
    SVEN_PACKMASTER(SvenPackmasterGUI.class),
    COLLECTION_MENU(CollectionMenuGUI.class),
    SKILL_MENU(SkillMenuGUI.class),
    PETS(PetsGUI.class),
    FARM_MERCHANT(FarmMerchantGUI.class),
    ACTIVE_EFFECTS(ActiveEffectsGUI.class),
    AUCTION_HOUSE(AuctionHouseGUI.class),
    AUCTIONS_BROWSER(AuctionsBrowserGUI.class),
    CREATE_AUCTION(CreateAuctionGUI.class),
    AUCTION_CONFIRM(AuctionConfirmGUI.class),
    MANAGE_AUCTIONS(ManageAuctionsGUI.class),
    FAST_TRAVEL(FastTravelGUI.class),
    FAST_TRAVEL_2(FastTravelGUI_2.class),
    YOUR_BIDS(YourBidsGUI.class),
    SETTING(SettingGUI.class),
    COOKIE_INFO(CookieInfoGUI.class),
    POTION_BAG(PotionBagGui.class),
    ACCESSORY_BAG(AccessoryBagGUI.class),
    STORAGE(StorageGUI.class),
    QUEST(QuestGUI.class),
    CALENDAR(CalendarGUI.class),
    TRADE(TradeGUI.class),
    CATACOMB(CatacombsGUI.class),
    CATACOMB_RULE(CatacombsGUI.class),
    ProfileManagementGUI(ProfileManagementGUI.class),
    PROFILE_VIEWER(ProfileViewerGUI.class),
    TRASH(TrashGUI.class),
    COOKIE_CONFIRM(CookieConfirmGUI.class),
    BOOSTER_COOKIE_SHOP(BoosterCookieShop.class),
    ;

    private final Class<? extends GUI> gui;

    GUIType(Class<? extends GUI> gui) {
        this.gui = gui;
    }

    public GUI getGUI() {
        try {
            return gui.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GUI getGUI(Object... params) {
        return SUtil.instance(GUI.class, params);
    }

    public static GUI getGUI(String title) {
        for (GUIType type : values()) {
            if (type.getGUI().getTitle().contains(title))
                return type.getGUI();
        }
        return null;
    }
}