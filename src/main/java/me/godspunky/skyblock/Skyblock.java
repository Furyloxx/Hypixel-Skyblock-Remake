package me.godspunky.skyblock;

import lombok.SneakyThrows;
import me.godspunky.skyblock.command.*;
import me.godspunky.skyblock.config.Config;
import me.godspunky.skyblock.features.Dungeon.DungeonGenerator;
import me.godspunky.skyblock.features.auction.AuctionBid;
import me.godspunky.skyblock.features.auction.AuctionEscrow;
import me.godspunky.skyblock.features.auction.AuctionItem;
import me.godspunky.skyblock.features.entity.EntityPopulator;
import me.godspunky.skyblock.features.entity.EntitySpawner;
import me.godspunky.skyblock.features.entity.SEntityType;
import me.godspunky.skyblock.features.entity.StaticDragonManager;
import me.godspunky.skyblock.features.gift.GiftListener;
import me.godspunky.skyblock.features.item.ItemListener;
import me.godspunky.skyblock.features.item.SItem;
import me.godspunky.skyblock.features.item.SMaterial;
import me.godspunky.skyblock.features.item.pet.Pet;
import me.godspunky.skyblock.features.launchpads.LaunchPadHandler;
import me.godspunky.skyblock.features.partyandfriends.command.ChatCommand;
import me.godspunky.skyblock.features.partyandfriends.command.PartyCommand;
import me.godspunky.skyblock.features.partyandfriends.listener.ChatListener;
import me.godspunky.skyblock.features.partyandfriends.party.PartyManager;
import me.godspunky.skyblock.features.ranks.GodspunkyPlayer;
import me.godspunky.skyblock.features.ranks.PlayerChatListener;
import me.godspunky.skyblock.features.ranks.PlayerJoinQuitListener;
import me.godspunky.skyblock.features.ranks.SetRankCommand;
import me.godspunky.skyblock.features.region.Region;
import me.godspunky.skyblock.features.region.RegionType;
import me.godspunky.skyblock.features.slayer.SlayerQuest;
import me.godspunky.skyblock.features.wardrobe.Command.WardrobeCommand;
import me.godspunky.skyblock.features.wardrobe.Command.WardrobeTabCompleter;
import me.godspunky.skyblock.features.wardrobe.DataManager.Page1Data;
import me.godspunky.skyblock.features.wardrobe.DataManager.Page2Data;
import me.godspunky.skyblock.features.wardrobe.GUI.WardrobeGUI;
import me.godspunky.skyblock.features.wardrobe.Listener.CheckPlayerGUIListener;
import me.godspunky.skyblock.features.wardrobe.Listener.WardrobeListener;
import me.godspunky.skyblock.gui.GUIListener;
import me.godspunky.skyblock.gui.ProfileViewerGUI;
import me.godspunky.skyblock.listener.*;
import me.godspunky.skyblock.sql.SQLDatabase;
import me.godspunky.skyblock.sql.SQLRegionData;
import me.godspunky.skyblock.sql.SQLWorldData;
import me.godspunky.skyblock.user.AuctionSettings;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandMap;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

public final class Skyblock extends JavaPlugin {

    private static Skyblock plugin;
    public static Page1Data Page_1;
    public static Page2Data Page_2;
    private LaunchPadHandler launchPadHandler;

    public static Skyblock getPlugin() {
        return plugin;
    }
    public Config config;
    public Config heads;
    public Config blocks;
    public Config spawners;
    public Config launchpads;
    public CommandMap commandMap;
    public SQLDatabase sql;
    public SQLRegionData regionData;
    public SQLWorldData worldData;
    public CommandLoader cl;

    public Repeater repeater;

    private static PartyManager partyManager;

    public enum ChatTypes {
        ALL_CHAT,
        PARTY_CHAT,
        REPLY_CHAT,
        NO_CHAT
    }

    // todo Minions
    @Override
    public void onLoad() {
        SLog.info("Loading Bukkit-serializable classes...");
        loadSerializableClasses();
    }

    @SneakyThrows
    @Override
    public void onEnable() {
        this.sendMessage(SUtil.getRandomVisibleColor() + "Found Bukkit server v" + Bukkit.getVersion());
        long start = System.currentTimeMillis();
        plugin = this;

        partyManager = new PartyManager();
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        // Wardrobe data
        Page_1 = new Page1Data(this);
        Page_1.saveDefaultConfig();
        Page_2 = new Page2Data(this);
        Page_2.saveDefaultConfig();
        // Register Command and Tabcompleter
        new WardrobeCommand(this);
        this.getCommand("wardrobe").setTabCompleter(new WardrobeTabCompleter());
        new WardrobeListener(this);
        new CheckPlayerGUIListener(this);
        loadymldata();
        loadIslandWorld();
        loadDungeonWorld();
        loadCommandMap();
        loadDatabase();
        cl = new CommandLoader();
        startServerLoop();
        loadCommands();
        loadListeners();
        registerTraits();
        startEntitySpawners();
        buildRecepies();
        establishRegions();
        loadItems();
        loadAuctions();
        synchronizeTime();
        this.getCommand("setrank").setExecutor(new SetRankCommand());
        getServer().getPluginManager().registerEvents(new PlayerChatListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinQuitListener(), this);
        getServer().getPluginManager().registerEvents(new GiftListener(), this);

        long end = System.currentTimeMillis();
        this.sendMessage(SUtil.getRandomVisibleColor() + "Successfully enabled Skyblock in " + SUtil.getTimeDifferenceAndColor(start, end) + ChatColor.WHITE + ".");
    }

    @Override
    public void onDisable() {
        SLog.info("Killing all non-human entities...");
        for (World world : Bukkit.getWorlds()) {
            for (Entity entity : world.getEntities()) {
                if (entity instanceof HumanEntity) continue;
                entity.remove();
            }
        }
        DungeonGenerator generator = new DungeonGenerator();
        generator.deleteAllDungeons();
        for(Player p : Bukkit.getOnlinePlayers()) {
            if (p.getOpenInventory() != null && (p.getOpenInventory().getTitle().equals(WardrobeGUI.Page1Name) || p.getOpenInventory().getTitle().equals(WardrobeGUI.Page2Name) || p.getOpenInventory().getTitle().contains("'s Wardrobe (1/2)") || p.getOpenInventory().getTitle().contains("'s Wardrobe (2/2)"))) {
                if (p.getItemOnCursor() != null) {
                    p.getInventory().addItem(p.getItemOnCursor());
                    p.setItemOnCursor(null);
                }
                p.closeInventory();
            }
        }
        SLog.info("Stopping server loop...");
        repeater.stop();
        SLog.info("Stopping entity spawners...");
        EntitySpawner.stopSpawnerTask();
        SLog.info("Ending dragon fight... (if one is currently active)");
        StaticDragonManager.endFight();
        SLog.info("Saving calendar time...");
        SkyBlockCalendar.saveElapsed();
        SLog.info("Saving user data...");
        for (User user : User.getCachedUsers())
            user.save();
        SLog.info("Saving auction data...");
        for (AuctionItem item : AuctionItem.getAuctions())
            item.save();
        plugin = null;
        SLog.info("Disabled " + this.getDescription().getFullName());
        GodspunkyPlayer.savePlayers();
    }

    public static PartyManager getPartyManager() {
        return partyManager;
    }




    public void loadymldata(){
        this.sendMessage(SUtil.getRandomVisibleColor() + "Loading YAML Data...");
        long start = System.currentTimeMillis();
        config = new Config("config.yml");
        heads = new Config("heads.yml");
        blocks = new Config("blocks.yml");
        spawners = new Config("spawners.yml");
        launchpads = new Config("launchpads.yml");

        this.sendMessage(SUtil.getRandomVisibleColor() + "Successfully loaded YAML Data ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    public void startServerLoop(){
        this.sendMessage(SUtil.getRandomVisibleColor() +"Starting Server Loop...");
        long start = System.currentTimeMillis();

        repeater = new Repeater();

        this.sendMessage(SUtil.getRandomVisibleColor() + "Successfully Started Loop [" + SUtil.getTimeDifferenceAndColor(start, System.currentTimeMillis()) + ChatColor.WHITE + "]");
    }


    private void loadCommands() {
        this.sendMessage(SUtil.getRandomVisibleColor() + "Registering commands...");
        long start = System.currentTimeMillis();

        cl.register(new RegionCommand());
        cl.register(new VisitCommand());
        cl.register(new PlayEnumSoundCommand());
        cl.register(new PlayEnumEffectCommand());
        cl.register(new SpawnSpecCommand());
        cl.register(new ItemCommand());
        cl.register(new SpecEnchantmentCommand());
        cl.register(new SpecPotionCommand());
        cl.register(new SpecEffectsCommand());
        cl.register(new SpecReforgeCommand());
        cl.register(new ManaCommand());
        cl.register(new CoinsCommand());
        cl.register(new GUICommand());
        cl.register(new ItemBrowseCommand());
        cl.register(new SpecRarityCommand());
        cl.register(new RecombobulateCommand());
        cl.register(new NBTCommand());
        cl.register(new IslandCommand());
        cl.register(new DataCommand());
        cl.register(new SpecTestCommand());
        cl.register(new SoundSequenceCommand());
        cl.register(new BatphoneCommand());
        cl.register(new AbsorptionCommand());
        cl.register(new SkillsCommand());
        cl.register(new CollectionsCommand());
        cl.register(new MaterialDataCommand());
        cl.register(new EntitySpawnersCommand());
        cl.register(new AuctionHouseCommand());
        cl.register(new FarmMerchantCommand());
        cl.register(new LiftCommand());
        cl.register(new ReforgeGUICommand());
        cl.register(new BankCommand());
        cl.register(new ReloadCommand());
        cl.register(new HubCommand());
        cl.register(new ChangeStatsCommand());
        cl.register(new MortCommand());
        this.cl.register(new MembersEnchantCommand());
        cl.register(new SetHubCommand());
        cl.register(new SetDungeonHubCommand());
        cl.register(new PlayerLocationCommand());
        cl.register(new SetMountainCommand());
        cl.register(new ReforgeCommand());
        cl.register(new PartyCommand());
        cl.register(new ChatCommand());
        cl.register(new APICommand());


        this.sendMessage(SUtil.getRandomVisibleColor() + "Successfully registered commands [" + SUtil.getTimeDifferenceAndColor(start, System.currentTimeMillis()) + ChatColor.WHITE + "]");
    }

    public void registerLaunchPads() {
        this.launchPadHandler = new LaunchPadHandler();
    }

    public void loadListeners() {
        this.sendMessage(SUtil.getRandomVisibleColor() + "Loading Listeners...");
        long start = System.currentTimeMillis();

        new BlockListener();
        new PlayerListener(plugin);
        new ServerPingListener();
        new ItemListener();
        new GUIListener();
        new WorldListener();
        new ChatListener();

        this.sendMessage(SUtil.getRandomVisibleColor() + "Successfully loaded listeners ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    public void loadDatabase(){
        this.sendMessage(SUtil.getRandomVisibleColor() + "Loading SQL Database...");
        long start = System.currentTimeMillis();

        sql = new SQLDatabase();
        regionData = new SQLRegionData();
        worldData = new SQLWorldData();

        this.sendMessage(SUtil.getRandomVisibleColor() + "Successfully loaded SQL Database ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    public void loadCommandMap(){
        this.sendMessage(SUtil.getRandomVisibleColor() + "Loading Command Maps...");
        long start = System.currentTimeMillis();

        try {
            Field f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            f.setAccessible(true);
            commandMap = (CommandMap) f.get(Bukkit.getServer());
            this.sendMessage(SUtil.getRandomVisibleColor() + "Successfully loaded Command Maps ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            this.sendMessage(SUtil.getRandomVisibleColor() + "CANNOT LOAD COMMAND MAPS U FKIN.......");
        }

    }

    public void registerTraits() {
        this.sendMessage(SUtil.getRandomVisibleColor() + "Registering Traits...");
        long start = System.currentTimeMillis();


        this.sendMessage(SUtil.getRandomVisibleColor() + "Successfully registered Traits ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    public void startEntitySpawners(){
        this.sendMessage(SUtil.getRandomVisibleColor() + "Starting Entity Spawners...");
        long start = System.currentTimeMillis();

        EntitySpawner.startSpawnerTask();

        this.sendMessage(SUtil.getRandomVisibleColor() + "Successfully started Entity Spawners ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    public void establishRegions(){
        this.sendMessage(SUtil.getRandomVisibleColor() + "Establishing player regions...");
        long start = System.currentTimeMillis();

        Region.cacheRegions();

        this.sendMessage(SUtil.getRandomVisibleColor() + "Successfully Established Player Regions ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    public void loadAuctions(){
        this.sendMessage(SUtil.getRandomVisibleColor() + "Loading Auctions...");
        long start = System.currentTimeMillis();

        AuctionItem.loadAuctionsFromDisk();

        this.sendMessage(SUtil.getRandomVisibleColor() + "Successfully Loaded Auctions ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    public void synchronizeTime(){
        this.sendMessage(SUtil.getRandomVisibleColor() + "Synchronizing world time with calendar time and removing world entities...");
        long start = System.currentTimeMillis();

        for (World world : Bukkit.getWorlds()) {
            for (Entity entity : world.getEntities()) {
                if (entity instanceof HumanEntity) continue;
                entity.remove();
            }
            // Time Validator
            int time = (int) ((SkyBlockCalendar.ELAPSED % 24000) - 6000);
            if (time < 0)
                time += 24000;
            world.setTime(time);
        }

        this.sendMessage(SUtil.getRandomVisibleColor() + "Successfully Synchronized world time with calendar time and removed world entities ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    @SneakyThrows
    public void loadItems(){
        this.sendMessage(SUtil.getRandomVisibleColor() + "Loading Items...");
        long start = System.currentTimeMillis();

        Class.forName("me.godspunky.skyblock.features.item.SMaterial"); // ensuring materials are loaded prior to this
        for (SMaterial material : SMaterial.values()) {
            if (material.hasClass())
                material.getStatistics().load();
        }

        this.sendMessage(SUtil.getRandomVisibleColor() + "Successfully Loaded Items ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    public void buildRecepies(){
        this.sendMessage(SUtil.getRandomVisibleColor() + "Building Recepies...");
        long start = System.currentTimeMillis();

        for (Iterator<Recipe> iter = Bukkit.recipeIterator(); iter.hasNext(); ) {
            Recipe recipe = iter.next();
            if (recipe.getResult() == null)
                continue;
            Material result = recipe.getResult().getType();
            if (recipe instanceof ShapedRecipe) {
                ShapedRecipe shaped = (ShapedRecipe) recipe;
                me.godspunky.skyblock.features.item.ShapedRecipe specShaped = new me.godspunky.skyblock.features.item.ShapedRecipe(SItem.convert(shaped.getResult()),
                        Groups.EXCHANGEABLE_RECIPE_RESULTS.contains(result))
                        .shape(shaped.getShape());
                for (Map.Entry<Character, ItemStack> entry : shaped.getIngredientMap().entrySet()) {
                    if (entry.getValue() == null)
                        continue;
                    ItemStack stack = entry.getValue();
                    specShaped.set(entry.getKey(), SMaterial.getSpecEquivalent(stack.getType(), stack.getDurability()), stack.getAmount());
                }
            }
            if (recipe instanceof ShapelessRecipe) {
                ShapelessRecipe shapeless = (ShapelessRecipe) recipe;
                me.godspunky.skyblock.features.item.ShapelessRecipe specShapeless = new me.godspunky.skyblock.features.item.ShapelessRecipe(SItem.convert(shapeless.getResult()),
                        Groups.EXCHANGEABLE_RECIPE_RESULTS.contains(result));
                for (ItemStack stack : shapeless.getIngredientList())
                    specShapeless.add(SMaterial.getSpecEquivalent(stack.getType(), stack.getDurability()), stack.getAmount());
            }
        }

        this.sendMessage(SUtil.getRandomVisibleColor() + "Successfully Built Recepies ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    private void startPopulators() {
        // Deep Caverns
        new EntityPopulator(5, 10, 200, SEntityType.ENCHANTED_DIAMOND_SKELETON, RegionType.OBSIDIAN_SANCTUARY).start();
        new EntityPopulator(5, 10, 200, SEntityType.ENCHANTED_DIAMOND_ZOMBIE, RegionType.OBSIDIAN_SANCTUARY).start();
        new EntityPopulator(5, 10, 200, SEntityType.DIAMOND_ZOMBIE, RegionType.DIAMOND_RESERVE).start();
        new EntityPopulator(5, 10, 200, SEntityType.DIAMOND_SKELETON, RegionType.DIAMOND_RESERVE).start();
        new EntityPopulator(5, 15, 200, SEntityType.SMALL_SLIME, RegionType.SLIMEHILL).start();
        new EntityPopulator(5, 10, 200, SEntityType.MEDIUM_SLIME, RegionType.SLIMEHILL).start();
        new EntityPopulator(5, 5, 400, SEntityType.LARGE_SLIME, RegionType.SLIMEHILL).start();
        new EntityPopulator(5, 30, 400, SEntityType.PIGMAN, RegionType.PIGMENS_DEN).start();
        new EntityPopulator(5, 30, 400, SEntityType.LAPIS_ZOMBIE, RegionType.LAPIS_QUARRY).start();
        new EntityPopulator(5, 10, 400, SEntityType.SNEAKY_CREEPER, RegionType.GUNPOWDER_MINES).start();

        // The End
        new EntityPopulator(6, 20, 300, SEntityType.WEAK_ENDERMAN, RegionType.THE_END_NEST).start();
        new EntityPopulator(6, 20, 300, SEntityType.ENDERMAN, RegionType.THE_END_NEST).start();
        new EntityPopulator(6, 20, 300, SEntityType.STRONG_ENDERMAN, RegionType.THE_END_NEST).start();
        new EntityPopulator(10, 30, 200, SEntityType.ZEALOT, RegionType.DRAGONS_NEST).start();
        new EntityPopulator(1, 5, 1200, SEntityType.ENDER_CHEST_ZEALOT, RegionType.DRAGONS_NEST).start();
        new EntityPopulator(5, 20, 200, SEntityType.WATCHER, RegionType.DRAGONS_NEST).start();
        new EntityPopulator(5, 10, 200, SEntityType.OBSIDIAN_DEFENDER, RegionType.DRAGONS_NEST).start();

        // Spider's Den
        new EntityPopulator(5, 20, 300, SEntityType.SPLITTER_SPIDER, RegionType.SPIDERS_DEN_HIVE).start();
        new EntityPopulator(5, 20, 300, SEntityType.WEAVER_SPIDER, RegionType.SPIDERS_DEN_HIVE).start();
        new EntityPopulator(5, 20, 300, SEntityType.VORACIOUS_SPIDER, RegionType.SPIDERS_DEN_HIVE).start();
        new EntityPopulator(5, 20, 300, SEntityType.SPIDER_JOCKEY, RegionType.SPIDERS_DEN_HIVE).start();
        new EntityPopulator(5, 20, 300, SEntityType.DASHER_SPIDER, RegionType.SPIDERS_DEN_HIVE).start();

        // Hub
        new EntityPopulator(5, 10, 300, SEntityType.HIGH_LEVEL_SKELETON, RegionType.HIGH_LEVEL, (world) -> world.getTime() >= 13188 && world.getTime() <= 22812).start();
        new EntityPopulator(5, 15, 200, SEntityType.ZOMBIE, RegionType.GRAVEYARD).start();
        new EntityPopulator(5, 15, 200, SEntityType.ZOMBIE_VILLAGER, RegionType.GRAVEYARD).start();
        new EntityPopulator(5, 20, 200, SEntityType.WOLF, RegionType.RUINS).start();
        new EntityPopulator(2, 4, 200, SEntityType.OLD_WOLF, RegionType.RUINS).start();
        new EntityPopulator(5, 30, 200, SEntityType.CRYPT_GHOUL, RegionType.COAL_MINE_CAVES).start();
        new EntityPopulator(1, 1, 200, SEntityType.GOLDEN_GHOUL, RegionType.COAL_MINE_CAVES).start();

        // Howling Cave
        new EntityPopulator(4, 4, 200, SEntityType.SOUL_OF_THE_ALPHA, RegionType.HOWLING_CAVE).start();
        new EntityPopulator(5, 15, 200, SEntityType.HOWLING_SPIRIT, RegionType.HOWLING_CAVE).start();
        new EntityPopulator(5, 15, 200, SEntityType.PACK_SPIRIT, RegionType.HOWLING_CAVE).start();
    }

    private void loadSerializableClasses() {
        ConfigurationSerialization.registerClass(SlayerQuest.class, "SlayerQuest");
        ConfigurationSerialization.registerClass(Pet.PetItem.class, "PetItem");
        ConfigurationSerialization.registerClass(SItem.class, "SItem");
        ConfigurationSerialization.registerClass(AuctionSettings.class, "AuctionSettings");
        ConfigurationSerialization.registerClass(AuctionEscrow.class, "AuctionEscrow");
        ConfigurationSerialization.registerClass(SerialNBTTagCompound.class, "SerialNBTTagCompound");
        ConfigurationSerialization.registerClass(AuctionBid.class, "AuctionBid");
    }
    public void loadIslandWorld() {
        new BlankWorldCreator("islands").createWorld();
    }
    public void loadDungeonWorld(){new BlankWorldCreator("dhub").createWorld();}

    public LaunchPadHandler getLaunchPadHandler() {
        return new LaunchPadHandler();
    }

    public String getPrefix() {
        return ChatColor.translateAlternateColorCodes('&', "&7[&aGodspunky&3Skyblock&bCore&7] &f");
    }
    public void sendMessage(String message) {
        Bukkit.getConsoleSender().sendMessage(getPrefix() + ChatColor.translateAlternateColorCodes('&', message) + ChatColor.RESET + " ");
    }
}
