package me.adarsh.godspunkycore;

import lombok.SneakyThrows;
import me.adarsh.godspunkycore.features.auction.AuctionBid;
import me.adarsh.godspunkycore.features.auction.AuctionEscrow;
import me.adarsh.godspunkycore.features.auction.AuctionItem;
import me.adarsh.godspunkycore.command.*;
import me.adarsh.godspunkycore.config.Config;
import me.adarsh.godspunkycore.features.entity.EntityPopulator;
import me.adarsh.godspunkycore.features.entity.EntitySpawner;
import me.adarsh.godspunkycore.features.entity.SEntityType;
import me.adarsh.godspunkycore.features.entity.StaticDragonManager;
import me.adarsh.godspunkycore.gui.GUIListener;
import me.adarsh.godspunkycore.features.item.ItemListener;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.features.item.pet.Pet;
import me.adarsh.godspunkycore.features.launchpads.LaunchPadHandler;
import me.adarsh.godspunkycore.listener.BlockListener;
import me.adarsh.godspunkycore.listener.PlayerListener;
import me.adarsh.godspunkycore.listener.ServerPingListener;
import me.adarsh.godspunkycore.listener.WorldListener;
import me.adarsh.godspunkycore.features.region.Region;
import me.adarsh.godspunkycore.features.region.RegionType;
import me.adarsh.godspunkycore.features.slayer.SlayerQuest;
import me.adarsh.godspunkycore.sql.SQLDatabase;
import me.adarsh.godspunkycore.sql.SQLRegionData;
import me.adarsh.godspunkycore.sql.SQLWorldData;
import me.adarsh.godspunkycore.user.AuctionSettings;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.Groups;
import me.adarsh.godspunkycore.util.SLog;
import me.adarsh.godspunkycore.util.SUtil;
import me.adarsh.godspunkycore.util.SerialNBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandMap;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

public final class Skyblock extends JavaPlugin {
    private static Skyblock plugin;
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

    // todo Minions


    @Override
    public void onLoad() {
        SLog.info("Loading Bukkit-serializable classes...");
        loadSerializableClasses();
    }

    @SneakyThrows
    @Override
    public void onEnable() {
        this.sendMessage("Found Bukkit server v" + Bukkit.getVersion());
        long start = System.currentTimeMillis();
        plugin = this;
        loadymldata();
        loadCommandMap();
        loadDatabase();
        cl = new CommandLoader();
        startServerLoop();
        loadCommands();
        loadListeners();
        registerTraits();
        startEntitySpawners();
        establishRegions();
        loadAuctions();
        synchronizeTime();

        long end = System.currentTimeMillis();
        this.sendMessage("Successfully enabled Skyblock in " + SUtil.getTimeDifferenceAndColor(start, end) + ChatColor.WHITE + ".");
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
    }

    public void loadymldata(){
        this.sendMessage("Loading YAML Data...");
        long start = System.currentTimeMillis();

        config = new Config("config.yml");
        heads = new Config("heads.yml");
        blocks = new Config("blocks.yml");
        spawners = new Config("spawners.yml");
        launchpads = new Config("launchpads.yml");

        this.sendMessage("Successfully loaded YAML Data ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    public void startServerLoop(){
        this.sendMessage("Starting Server Loop...");
        long start = System.currentTimeMillis();

        repeater = new Repeater();

        this.sendMessage("Successfully Started Loop [" + SUtil.getTimeDifferenceAndColor(start, System.currentTimeMillis()) + ChatColor.WHITE + "]");
    }


    private void loadCommands() {
        this.sendMessage("Registering commands...");
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

        this.sendMessage("Successfully registered commands [" + SUtil.getTimeDifferenceAndColor(start, System.currentTimeMillis()) + ChatColor.WHITE + "]");
    }

    public void registerLaunchPads() {
        this.launchPadHandler = new LaunchPadHandler();
    }

    public void loadListeners() {
        this.sendMessage("Loading Listeners...");
        long start = System.currentTimeMillis();

        new BlockListener();
        new PlayerListener(plugin);
        new ServerPingListener();
        new ItemListener();
        new GUIListener();
        new WorldListener();

        this.sendMessage("Successfully loaded listeners ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    public void loadDatabase(){
        this.sendMessage("Loading SQL Database...");
        long start = System.currentTimeMillis();

        sql = new SQLDatabase();
        regionData = new SQLRegionData();
        worldData = new SQLWorldData();

        this.sendMessage("Successfully loaded SQL Database ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    public void loadCommandMap(){
        this.sendMessage("Loading Command Maps...");
        long start = System.currentTimeMillis();

        try {
            Field f = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            f.setAccessible(true);
            commandMap = (CommandMap) f.get(Bukkit.getServer());
            this.sendMessage("Successfully loaded Command Maps ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
            this.sendMessage("CANNOT LOAD COMMAND MAPS U FKIN.......");
        }

    }

    public void registerTraits() {
        this.sendMessage("Registering Traits...");
        long start = System.currentTimeMillis();

        // Nothing is here. We can add later

        this.sendMessage("Successfully registered Traits ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    public void startEntitySpawners(){
        this.sendMessage("Starting Entity Spawners...");
        long start = System.currentTimeMillis();

        EntitySpawner.startSpawnerTask();

        this.sendMessage("Successfully started Entity Spawners ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    public void establishRegions(){
        this.sendMessage("Establishing player regions...");
        long start = System.currentTimeMillis();

        Region.cacheRegions();

        this.sendMessage("Successfully Established Player Regions ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    public void loadAuctions(){
        this.sendMessage("Loading Auctions...");
        long start = System.currentTimeMillis();

        AuctionItem.loadAuctionsFromDisk();

        this.sendMessage("Successfully Loaded Auctions ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    public void synchronizeTime(){
        this.sendMessage("Synchronizing world time with calendar time and removing world entities...");
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

        this.sendMessage("Successfully Synchronized world time with calendar time and removed world entities ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    @SneakyThrows
    public void loadItems(){
        this.sendMessage("Loading Items...");
        long start = System.currentTimeMillis();

        Class.forName("me.adarsh.godspunkycore.features.item.SMaterial"); // ensuring materials are loaded prior to this
        for (SMaterial material : SMaterial.values()) {
            if (material.hasClass())
                material.getStatistics().load();
        }

        this.sendMessage("Successfully Loaded Items ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
    }

    public void buildRecepies(){
        this.sendMessage("Building Recepies...");
        long start = System.currentTimeMillis();

        for (Iterator<Recipe> iter = Bukkit.recipeIterator(); iter.hasNext(); ) {
            Recipe recipe = iter.next();
            if (recipe.getResult() == null)
                continue;
            Material result = recipe.getResult().getType();
            if (recipe instanceof ShapedRecipe) {
                ShapedRecipe shaped = (ShapedRecipe) recipe;
                me.adarsh.godspunkycore.features.item.ShapedRecipe specShaped = new me.adarsh.godspunkycore.features.item.ShapedRecipe(SItem.convert(shaped.getResult()),
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
                me.adarsh.godspunkycore.features.item.ShapelessRecipe specShapeless = new me.adarsh.godspunkycore.features.item.ShapelessRecipe(SItem.convert(shapeless.getResult()),
                        Groups.EXCHANGEABLE_RECIPE_RESULTS.contains(result));
                for (ItemStack stack : shapeless.getIngredientList())
                    specShapeless.add(SMaterial.getSpecEquivalent(stack.getType(), stack.getDurability()), stack.getAmount());
            }
        }

        this.sendMessage("Successfully Built Recepies ["+SUtil.getTimeDifferenceAndColor(start,System.currentTimeMillis()) + ChatColor.WHITE+"]");
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

    public LaunchPadHandler getLaunchPadHandler() {
        return new LaunchPadHandler();
    }

    public String getPrefix() {
        return ChatColor.translateAlternateColorCodes('&', "&7[&3Sky&bBlock&7] &f");
    }
    public String getVersion() {
        return this.getDescription().getVersion();
    }
    public void sendMessage(String message) {
        Bukkit.getConsoleSender().sendMessage(getPrefix() + ChatColor.translateAlternateColorCodes('&', message) + ChatColor.RESET + " ");
    }
}
