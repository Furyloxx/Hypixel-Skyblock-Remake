package me.godspunky.skyblock.features.collection;

import lombok.Getter;
import me.godspunky.skyblock.features.item.SMaterial;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Getter
public class ItemCollection {
    private static final Map<String, ItemCollection> COLLECTION_MAP = new HashMap<>();

    // FARMING

    public static final ItemCollection WHEAT = new ItemCollection("Wheat",
            ItemCollectionCategory.FARMING,
            SMaterial.WHEAT,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Wheat Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Enchanted Book (Harvesting V)", ChatColor.GREEN)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Farm Suit Helmet", ChatColor.GRAY), new ItemCollectionUpgradeReward("Farm Suit Chestplate", ChatColor.GRAY),new ItemCollectionUpgradeReward("Farm Suit Leggings", ChatColor.GRAY), new ItemCollectionUpgradeReward("Farm Suit Boots", ChatColor.GRAY)),
            new ItemCollectionRewards(500, new ItemCollectionUpgradeReward("Farming Talisman", ChatColor.GRAY)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Bread", ChatColor.GRAY)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Farming Island", ChatColor.GRAY)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Enchanted Hay Bale", ChatColor.GREEN), new ItemCollectionUpgradeReward("Small Agronomy Sack Recipe", ChatColor.GREEN)),
            new ItemCollectionRewards(15000, new ItemCollectionUpgradeReward("Medium Agronomy Sack", ChatColor.BLUE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Farm Armor Helmet", ChatColor.BLUE), new ItemCollectionUpgradeReward("Farm Armor Chestplate", ChatColor.BLUE),new ItemCollectionUpgradeReward("Farm Armor Leggings", ChatColor.BLUE), new ItemCollectionUpgradeReward("Farm Armor Boots", ChatColor.BLUE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Large Agronomy", ChatColor.DARK_PURPLE)),
            new ItemCollectionRewards(100000, new ItemCollectionUpgradeReward("Tightly-Tied Hay Bale", ChatColor.BLUE), new ItemCollectionUpgradeReward("Enchanted Large Agronomy Sack", ChatColor.DARK_PURPLE)));

    public static final ItemCollection CACTUS = new ItemCollection("Cactus",
            ItemCollectionCategory.FARMING,
            SMaterial.CACTUS,
            (short) 0,
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Cactus Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Cactus Helmet", ChatColor.WHITE), new ItemCollectionUpgradeReward("Cactus Chestplate", ChatColor.WHITE), new ItemCollectionUpgradeReward("Cactus leggings", ChatColor.WHITE), new ItemCollectionUpgradeReward("Cactus Boots", ChatColor.WHITE)),
            new ItemCollectionRewards(500, new ItemCollectionUpgradeReward("Resistance Potion", ChatColor.GREEN)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Cactus Green ", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Desert Island", ChatColor.WHITE)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Enchanted Book (Piercing I)", ChatColor.WHITE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Enchanted Book (Thorns II)", ChatColor.WHITE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Enchanted Cuctus", ChatColor.BLUE)),
            new ItemCollectionRewards(50000));

    public static final ItemCollection CARROT = new ItemCollection("Carrot",
            ItemCollectionCategory.FARMING,
            SMaterial.CARROT_ITEM,
            (short) 0,
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Carrot Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Simple Carrot Candy", ChatColor.GREEN)),
            new ItemCollectionRewards(500, new ItemCollectionUpgradeReward("Carrot Bait", ChatColor.WHITE)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Carrot", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Enchanted Carrot on a Stick", ChatColor.GREEN)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Great Carrot Candy", ChatColor.BLUE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Enchanted Golden Carrot", ChatColor.GREEN)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Superb Carrot Candy", ChatColor.DARK_PURPLE)),
            new ItemCollectionRewards(50000));

    public static final ItemCollection COCOA_BEANS = new ItemCollection("Cocoa Beans",
            ItemCollectionCategory.FARMING,
            SMaterial.COCOA_BEANS,
            (short) 3,
            new ItemCollectionRewards(75, new ItemCollectionUpgradeReward("Cocoa Beans Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(200),
            new ItemCollectionRewards(500, new ItemCollectionUpgradeReward("Portal to Mushroom Island", ChatColor.WHITE)),
            new ItemCollectionRewards(2000, new ItemCollectionUpgradeReward("Enchanted Cocoa Bean", ChatColor.GREEN)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Travel Scroll to Mushroom Island", ChatColor.BLUE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Enchanted Cookie", ChatColor.BLUE)),
            new ItemCollectionRewards(20000, new ItemCollectionUpgradeReward("Adrenaline Potion", ChatColor.RED)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Enchanted Book (Replenish I)", ChatColor.BLUE)),
            new ItemCollectionRewards(100000));

    public static final ItemCollection FEATHER = new ItemCollection("Feather",
            ItemCollectionCategory.FARMING,
            SMaterial.FEATHER,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Enchanted Book (Projectile Protection IV)", ChatColor.WHITE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Enchanted Book (Feather Falling IV)", ChatColor.WHITE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Archery Potion", ChatColor.AQUA)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Feather Talisman", ChatColor.WHITE)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Enchanted Feather", ChatColor.GREEN)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Enchanted Book (Drogon Tracer IV)", ChatColor.WHITE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Feather Ring", ChatColor.GREEN)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Enchanted Book (Snipe II)", ChatColor.WHITE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Feather Artifact", ChatColor.BLUE)));

    public static final ItemCollection LEATHER = new ItemCollection("Leather",
            ItemCollectionCategory.FARMING,
            SMaterial.LEATHER,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Cow Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Cow Head", ChatColor.WHITE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Small Backpack", ChatColor.GREEN)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Raw Beef", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Medium Backpack", ChatColor.BLUE)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Enchanted Leather", ChatColor.GREEN)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Saddle", ChatColor.GREEN)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Large Backpack", ChatColor.DARK_PURPLE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Mystery Horse Pet", ChatColor.BLUE)),
            new ItemCollectionRewards(100000, new ItemCollectionUpgradeReward("Greater Backpack", ChatColor.DARK_PURPLE)));

    public static final ItemCollection MELON = new ItemCollection("Melon",
            ItemCollectionCategory.FARMING,
            SMaterial.MELON,
            (short) 0,
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Melon Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1200),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Enchanted Melon", ChatColor.GREEN)),
            new ItemCollectionRewards(15000, new ItemCollectionUpgradeReward("Enchanted Glistering Melon", ChatColor.BLUE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Enchanted melon Block", ChatColor.BLUE)),
            new ItemCollectionRewards(50000),
            new ItemCollectionRewards(100000),
            new ItemCollectionRewards(250000, new ItemCollectionUpgradeReward("Melon Helmet", ChatColor.GREEN), new ItemCollectionUpgradeReward("Melon Chestplate", ChatColor.GREEN), new ItemCollectionUpgradeReward("Melon Leggings", ChatColor.GREEN), new ItemCollectionUpgradeReward("Melon Boots", ChatColor.GREEN)));

    public static final ItemCollection MUTTON = new ItemCollection("Mutton",
            ItemCollectionCategory.FARMING,
            SMaterial.MUTTON,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Sheep Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Mana Potion", ChatColor.BLUE)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Enchanted Mutton", ChatColor.GREEN), new ItemCollectionUpgradeReward("Small Husbandry Sack", ChatColor.GREEN)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Enchanted Book (Rainbow I)", ChatColor.WHITE)),
            new ItemCollectionRewards(15000, new ItemCollectionUpgradeReward("Mystery Sheep Pet", ChatColor.BLUE), new ItemCollectionUpgradeReward("Medium Husbandry Sack", ChatColor.GREEN)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Enchanted Cooked Mutton", ChatColor.BLUE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Large Husbandry Sack", ChatColor.DARK_PURPLE)),
            new ItemCollectionRewards(100000, new ItemCollectionUpgradeReward("Large Enchanted Husbandry Sack", ChatColor.DARK_PURPLE)));

    public static final ItemCollection NETHER_WARTS = new ItemCollection("Nether Warts",
            ItemCollectionCategory.FARMING,
            SMaterial.NETHER_WARTS,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Nether Wart Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Small Potion Bag", ChatColor.GREEN)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Potion Affinity Talisman", ChatColor.WHITE)),
            new ItemCollectionRewards(500, new ItemCollectionUpgradeReward("Enchanted Nether Wart", ChatColor.GREEN)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Medium Potion Bag Upgrade", ChatColor.GREEN)),
            new ItemCollectionRewards(5000),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Potion Affinity Ring", ChatColor.GREEN)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Large Potion Bag Upgrade", ChatColor.GREEN)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Potion Affinity Artifact", ChatColor.BLUE)),
            new ItemCollectionRewards(75000, new ItemCollectionUpgradeReward("Giant Potion Bag Upgrade", ChatColor.GREEN)),
            new ItemCollectionRewards(100000, new ItemCollectionUpgradeReward("Mutant Nether Wart", ChatColor.BLUE)));

    public static final ItemCollection POTATO = new ItemCollection("Potato",
            ItemCollectionCategory.FARMING,
            SMaterial.POTATO_ITEM,
            (short) 0,
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Potato Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(200, new ItemCollectionUpgradeReward("Portal to the Barn", ChatColor.WHITE)),
            new ItemCollectionRewards(500, new ItemCollectionUpgradeReward("Vaccine Talisman", ChatColor.WHITE)),
            new ItemCollectionRewards(1800, new ItemCollectionUpgradeReward("Enchanted Potato", ChatColor.GREEN)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Venomous Potion", ChatColor.DARK_PURPLE)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Travel Scroll to the Barn", ChatColor.BLUE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Enchanted Baked Potato", ChatColor.GREEN)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Hot Potato Book", ChatColor.DARK_PURPLE)),
            new ItemCollectionRewards(10000));

    public static final ItemCollection PUMPKIN = new ItemCollection("Pumpkin",
            ItemCollectionCategory.FARMING,
            SMaterial.PUMPKIN,
            (short) 0,
            new ItemCollectionRewards(40, new ItemCollectionUpgradeReward("Pumpkin Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Pumpkin Helmet", ChatColor.WHITE), new ItemCollectionUpgradeReward("Pumpkin Chestplate", ChatColor.WHITE), new ItemCollectionUpgradeReward("Pumpkin Leggings", ChatColor.WHITE), new ItemCollectionUpgradeReward("Pumpkin Boots", ChatColor.WHITE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Enchanted Pumpkin", ChatColor.GREEN)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Book (Cubism IV)", ChatColor.WHITE)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Training Dummy", ChatColor.GREEN)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Farmer Orb", ChatColor.GREEN)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Lantern Helmet", ChatColor.GREEN)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Farm Crystal", ChatColor.BLUE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Farmer Boots", ChatColor.GREEN)),
            new ItemCollectionRewards(100000, new ItemCollectionUpgradeReward("Polished Pumpkin", ChatColor.BLUE)),
            new ItemCollectionRewards(250000, new ItemCollectionUpgradeReward("Rancher's Boots", ChatColor.DARK_PURPLE)));

    public static final ItemCollection RAW_CHICKEN = new ItemCollection("Raw Chicken",
            ItemCollectionCategory.FARMING,
            SMaterial.RAW_CHICKEN,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Chicken Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Bridge Egg", ChatColor.WHITE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Chicken head", ChatColor.WHITE)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Raw Chicken", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Enchanted Egg", ChatColor.BLUE)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Mystery Chicken Pet", ChatColor.BLUE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Enchanted Cake", ChatColor.GREEN)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Agility potion", ChatColor.DARK_PURPLE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Super Enchanted Egg", ChatColor.BLUE)),
            new ItemCollectionRewards(100000, new ItemCollectionUpgradeReward("Omega Enchanted Egg", ChatColor.DARK_PURPLE)));

    public static final ItemCollection SUGAR_CANE = new ItemCollection("Sugar Cane",
            ItemCollectionCategory.FARMING,
            SMaterial.SUGAR_CANE,
            (short) 0,
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Sugar Cane Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Speed Talisman", ChatColor.WHITE)),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Sugar", ChatColor.GREEN)),
            new ItemCollectionRewards(2000, new ItemCollectionUpgradeReward("Enchanted Paper", ChatColor.GREEN), new ItemCollectionUpgradeReward("Speed Ring", ChatColor.GREEN)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Enchanted Bookshelf", ChatColor.GREEN)),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(20000, new ItemCollectionUpgradeReward("Enchanted Sugar Cane", ChatColor.BLUE), new ItemCollectionUpgradeReward("Speed Artifact", ChatColor.BLUE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Speedster helmet", ChatColor.DARK_PURPLE), new ItemCollectionUpgradeReward("Speedster Chestplate", ChatColor.DARK_PURPLE), new ItemCollectionUpgradeReward("Speedster Leggings", ChatColor.DARK_PURPLE), new ItemCollectionUpgradeReward("Speedster Boots", ChatColor.DARK_PURPLE)));

    public static final ItemCollection SEEDS = new ItemCollection("Seeds",
            ItemCollectionCategory.FARMING,
            SMaterial.SEEDS,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Dirt Trade", ChatColor.WHITE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Clay", ChatColor.WHITE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("long Grass", ChatColor.WHITE), new ItemCollectionUpgradeReward("Enchanted Seeds", ChatColor.GREEN)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Fern", ChatColor.WHITE)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Dead Bush", ChatColor.WHITE)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Double Tallgrass", ChatColor.WHITE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Box of Seeds", ChatColor.BLUE)));

    // Mining
    public static final ItemCollection COBBLESTONE = new ItemCollection("Cobblestone",
            ItemCollectionCategory.MINING,
            SMaterial.COBBLESTONE,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Cobblestone Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Stone Platform", ChatColor.WHITE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Auto Smelter", ChatColor.WHITE)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Cobblestone", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Compactor", ChatColor.GREEN)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Mystery Silver Pet", ChatColor.BLUE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Miner's Outfit helmet", ChatColor.GREEN), new ItemCollectionUpgradeReward("Miner's Outfit Chestplate", ChatColor.GREEN), new ItemCollectionUpgradeReward("Miner's Outfit Leggings", ChatColor.GREEN), new ItemCollectionUpgradeReward("Miner's Outfit Boots", ChatColor.GREEN)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Hyper Furnace", ChatColor.GREEN)),
            new ItemCollectionRewards(40000, new ItemCollectionUpgradeReward("Haste Ring", ChatColor.BLUE)),
            new ItemCollectionRewards(70000, new ItemCollectionUpgradeReward("Super Compactor 3000", ChatColor.BLUE)));

    public static final ItemCollection COAL = new ItemCollection("Coal",
            ItemCollectionCategory.MINING,
            SMaterial.COAL,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Coal Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Enchanted Book (Smelting Touch I)", ChatColor.WHITE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Haste Potion", ChatColor.YELLOW)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Coal", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Enchanted Charcoal", ChatColor.GREEN), new ItemCollectionUpgradeReward("Small Mining Sack", ChatColor.GREEN)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Travel Scroll to the Gold Mine", ChatColor.BLUE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Enchanted Block of Coal", ChatColor.BLUE), new ItemCollectionUpgradeReward("Medium Mining Sack", ChatColor.GREEN)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Enchanted Lava Bucket", ChatColor.DARK_PURPLE)),
            new ItemCollectionRewards(40000, new ItemCollectionUpgradeReward("Mystery Wither Skeleton Pet", ChatColor.BLUE), new ItemCollectionUpgradeReward("Large Mining Sack", ChatColor.DARK_PURPLE)),
            new ItemCollectionRewards(70000, new ItemCollectionUpgradeReward("Large Enchanted Mining Sack", ChatColor.DARK_PURPLE)));

    public static final ItemCollection IRON_INGOT = new ItemCollection("Iron Ingot",
            ItemCollectionCategory.MINING,
            SMaterial.IRON_INGOT,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Iron Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Golem Hat", ChatColor.WHITE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Enchanted Book (Protection IV)", ChatColor.WHITE)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Tron", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Budget Hopper", ChatColor.GREEN)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Golem Armor Helmet", ChatColor.BLUE), new ItemCollectionUpgradeReward("Golem Armor Chestplate", ChatColor.BLUE), new ItemCollectionUpgradeReward("Golem Armor Leggings", ChatColor.BLUE), new ItemCollectionUpgradeReward("GolemArmor Boots", ChatColor.BLUE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Enchanted Iron Block", ChatColor.BLUE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Golem Sword", ChatColor.BLUE)),
            new ItemCollectionRewards(100000, new ItemCollectionUpgradeReward("Enchanted Hopper", ChatColor.BLUE), new ItemCollectionUpgradeReward("Personal Deletor 4000", ChatColor.GREEN)),
            new ItemCollectionRewards(20000, new ItemCollectionUpgradeReward("Personal Deletor 6000", ChatColor.DARK_PURPLE)));

    public static final ItemCollection GOLD_INGOT = new ItemCollection("Gold Ingot",
            ItemCollectionCategory.MINING,
            SMaterial.GOLD_INGOT,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Gold Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Cleaver", ChatColor.GREEN)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Enchanted Book (Looting II)", ChatColor.WHITE)),
            new ItemCollectionRewards(500, new ItemCollectionUpgradeReward("Portal to the Gold Mine", ChatColor.WHITE)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Gold", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Absorption Potion", ChatColor.GOLD)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Enchanted Book (Scavenger II)", ChatColor.WHITE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Enchanted Gold Block", ChatColor.BLUE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Enchanted Book (Fortune II)", ChatColor.WHITE)));

    public static final ItemCollection DIAMOND = new ItemCollection("Diamond",
            ItemCollectionCategory.MINING,
            SMaterial.DIAMOND,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Diamond Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Enchanted Book (Execute IV)", ChatColor.WHITE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Portal to the Deep Caverns", ChatColor.WHITE)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Diamond", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Enchanted Book (Critical IV)", ChatColor.WHITE)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Diamond Spreading", ChatColor.BLUE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Hardened Diamond Helmet", ChatColor.BLUE), new ItemCollectionUpgradeReward("Hardened Diamond Chestplate", ChatColor.BLUE), new ItemCollectionUpgradeReward("Hardened Diamond Leggings", ChatColor.BLUE), new ItemCollectionUpgradeReward("Harden Diamond Boots", ChatColor.BLUE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Enchanted Diamond Block", ChatColor.BLUE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Perfect Helmet - Tier I", ChatColor.BLUE), new ItemCollectionUpgradeReward("Perfect Chestplate - Tier I", ChatColor.BLUE), new ItemCollectionUpgradeReward("Perfect Leggings - Tier I", ChatColor.BLUE), new ItemCollectionUpgradeReward("Perfect Boots - Tier I", ChatColor.BLUE)));

    public static final ItemCollection LAPIS_LAZULI = new ItemCollection("Lapis Lazuli",
            ItemCollectionCategory.MINING,
            SMaterial.LAPIS_LAZULI,
            (short) 0,
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Lapis Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(500, new ItemCollectionUpgradeReward("Experience Bottle", ChatColor.WHITE)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Book (Experience II)", ChatColor.WHITE)),
            new ItemCollectionRewards(2000, new ItemCollectionUpgradeReward("Enchanted Lapis Lazuli", ChatColor.GREEN)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Grand Experience Bottle", ChatColor.GREEN)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Experience Potion", ChatColor.BLUE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Enchanted Lapis Block", ChatColor.BLUE)),
            new ItemCollectionRewards(100000, new ItemCollectionUpgradeReward("Titanic Experience Bottle", ChatColor.BLUE)),
            new ItemCollectionRewards(15000, new ItemCollectionUpgradeReward("Experience Artifact", ChatColor.DARK_PURPLE)));

    public static final ItemCollection EMERALD = new ItemCollection("Emerald",
            ItemCollectionCategory.MINING,
            SMaterial.EMERALD,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Emerald Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Talisman of Coins", ChatColor.WHITE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Magnetic Talisman", ChatColor.GREEN)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Emerald", ChatColor.GREEN)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Emerald Ring", ChatColor.GREEN)),
            new ItemCollectionRewards(15000, new ItemCollectionUpgradeReward("Personal Bank", ChatColor.GREEN)),
            new ItemCollectionRewards(30000, new ItemCollectionUpgradeReward("Enchanted Emerald Block", ChatColor.BLUE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Emerald Blade", ChatColor.DARK_PURPLE)),
            new ItemCollectionRewards(100000, new ItemCollectionUpgradeReward("Emerald Armor Helmet", ChatColor.DARK_PURPLE), new ItemCollectionUpgradeReward("Emerald Armor Chestplate", ChatColor.DARK_PURPLE), new ItemCollectionUpgradeReward("Emerald Armor Leggings", ChatColor.DARK_PURPLE), new ItemCollectionUpgradeReward("Emerald Armor Boots", ChatColor.DARK_PURPLE)));

    public static final ItemCollection REDSTONE= new ItemCollection("Redstone",
            ItemCollectionCategory.MINING,
            SMaterial.REDSTONE,
            (short) 0,
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Redstone Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Small Accessory Bag", ChatColor.GREEN)),
            new ItemCollectionRewards(750, new ItemCollectionUpgradeReward("Enchanted Book (Efficiency II)", ChatColor.WHITE)),
            new ItemCollectionRewards(1500, new ItemCollectionUpgradeReward("Enchanted Redstone", ChatColor.GREEN)),
            new ItemCollectionRewards(3000, new ItemCollectionUpgradeReward("Weather Stick", ChatColor.GREEN)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Medium Accessory Bag Upgrade", ChatColor.GREEN)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Travel Scroll to Deep Caverns", ChatColor.BLUE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Enchanted Redstone Block", ChatColor.BLUE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Large Accessory Bag Upgrade", ChatColor.GREEN), new ItemCollectionUpgradeReward("Personal Compactor 4000", ChatColor.GREEN)),
            new ItemCollectionRewards(200000, new ItemCollectionUpgradeReward("Greater Accessory Bag Upgrade", ChatColor.GREEN)),
            new ItemCollectionRewards(400000, new ItemCollectionUpgradeReward("Giant Accessory Bag Upgrade", ChatColor.GREEN), new ItemCollectionUpgradeReward("Personal Compactor 5000", ChatColor.BLUE)),
            new ItemCollectionRewards(600000, new ItemCollectionUpgradeReward("Massive Accessory Bag Upgrade", ChatColor.GREEN)),
            new ItemCollectionRewards(800000, new ItemCollectionUpgradeReward("Humongous Accessory Bag Upgrade", ChatColor.GREEN), new ItemCollectionUpgradeReward("Personal Compactor 6000", ChatColor.DARK_PURPLE)),
            new ItemCollectionRewards(1000000, new ItemCollectionUpgradeReward("Colossal Accessory Bag Upgrade", ChatColor.GREEN), new ItemCollectionUpgradeReward("Personal Compactor 7000", ChatColor.GOLD)),
            new ItemCollectionRewards(1200000, new ItemCollectionUpgradeReward("Titanic Accessory Bag Upgrade", ChatColor.GREEN)),
            new ItemCollectionRewards(1400000, new ItemCollectionUpgradeReward("Preposterous Accessory Bag Upgrade", ChatColor.GREEN)));

    public static final ItemCollection NETHER_QUARTZ = new ItemCollection("Nether Quartz",
            ItemCollectionCategory.MINING,
            SMaterial.NETHER_QUARTZ_ORE,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Quartz Mininon", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Night Saver", ChatColor.GREEN)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Day Saver", ChatColor.GREEN)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchnated Quartz", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Minion Expander", ChatColor.BLUE)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Enchanted Quartz Block", ChatColor.BLUE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Night Cystal", ChatColor.BLUE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Day Crystal", ChatColor.BLUE)),
            new ItemCollectionRewards(40000, new ItemCollectionUpgradeReward("Solar Panel", ChatColor.GREEN)));

    public static final ItemCollection OBSIDIAN = new ItemCollection("Obsidian",
            ItemCollectionCategory.MINING,
            SMaterial.OBSIDIAN,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Obsidian Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Enchanted Book (Lethality IV)", ChatColor.WHITE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Gravity Talisman", ChatColor.GREEN)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Obsidian", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Coming Soon", ChatColor.RED)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Stun Potion", ChatColor.DARK_GRAY)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Coming Soon", ChatColor.RED)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Treecapitator", ChatColor.DARK_PURPLE)),
            new ItemCollectionRewards(40000, new ItemCollectionUpgradeReward("Obsidian Tablet", ChatColor.BLUE)),
            new ItemCollectionRewards(70000, new ItemCollectionUpgradeReward("Reforge Anvil", ChatColor.DARK_PURPLE)));

    public static final ItemCollection GLOWSTONE_DUST = new ItemCollection("Glowstone Dust",
            ItemCollectionCategory.MINING,
            SMaterial.GLOWSTONE_DUST,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Glowstone Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Portal to the Crimson Isle", ChatColor.WHITE)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Glowstone Dust", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Travel Scroll to the Crimson Isle", ChatColor.BLUE)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Enchanted Glowstone", ChatColor.GREEN)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Enchanted Redstone Lamp", ChatColor.BLUE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Vanquished Glowstone Gauntlet", ChatColor.DARK_PURPLE)));

    public static final ItemCollection GRAVEL = new ItemCollection("Gravel",
            ItemCollectionCategory.MINING,
            SMaterial.GRAVEL,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Gravel Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Flint Shovel", ChatColor.WHITE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Portal to the Spider's Den", ChatColor.WHITE)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Book (Sharpness IV)", ChatColor.WHITE)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Enchanted Flint", ChatColor.GREEN)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Enchanted Book (First Strike III)", ChatColor.WHITE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Critical Potion", ChatColor.DARK_RED)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Travel Scrook to Spider's Den", ChatColor.BLUE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("", ChatColor.BLUE)));

    public static final ItemCollection ICE = new ItemCollection("Ice",
            ItemCollectionCategory.MINING,
            SMaterial.ICE,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Ice Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Enchanted Book (Frost Walker I)", ChatColor.WHITE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Packed Ice", ChatColor.WHITE)),
            new ItemCollectionRewards(500, new ItemCollectionUpgradeReward("Enchanted Ice", ChatColor.GREEN)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Magical Water Bucket", ChatColor.WHITE)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Ice Bait", ChatColor.GREEN)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Enchanted Packed Ice", ChatColor.BLUE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Frozen Scythe", ChatColor.BLUE)),
            new ItemCollectionRewards(100000, new ItemCollectionUpgradeReward("Frozen Blaze Helmet", ChatColor.GOLD), new ItemCollectionUpgradeReward("Frozen Blaze Chestplate", ChatColor.GOLD), new ItemCollectionUpgradeReward("Frozen Blaze Leggings", ChatColor.GOLD), new ItemCollectionUpgradeReward("Frozen Blaze Boots", ChatColor.GOLD)),
            new ItemCollectionRewards(250000, new ItemCollectionUpgradeReward("Auger Rod", ChatColor.GOLD)),
            new ItemCollectionRewards(500000, new ItemCollectionUpgradeReward("Glacial Scythe", ChatColor.DARK_PURPLE)));

    public static final ItemCollection NETHERRACK = new ItemCollection("Netherrack",
            ItemCollectionCategory.MINING,
            SMaterial.NETHERRACK,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Nether Wart Island", ChatColor.WHITE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Wounded Potion", ChatColor.DARK_RED)),
            new ItemCollectionRewards(500, new ItemCollectionUpgradeReward("Nether Brick Trade", ChatColor.WHITE)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Netherrack", ChatColor.GREEN)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Magical Lava Bucket", ChatColor.GREEN)));

    public static final ItemCollection SAND = new ItemCollection("Sand",
            ItemCollectionCategory.MINING,
            SMaterial.SAND,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Sand Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Coming Soon", ChatColor.RED)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Soul Sand Trade", ChatColor.WHITE)),
            new ItemCollectionRewards(500, new ItemCollectionUpgradeReward("Desert Biome Stick", ChatColor.WHITE)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Sand", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Burning Potion", ChatColor.GOLD)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Hard Glass", ChatColor.WHITE)));

    public static final ItemCollection END_STONE = new ItemCollection("End Stone",
            ItemCollectionCategory.MINING,
            SMaterial.END_STONE,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("End Stone Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("End Biome Stick", ChatColor.WHITE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Portal to The End", ChatColor.GREEN)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted End Stone", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Silence Block", ChatColor.GREEN)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Haste Block", ChatColor.GREEN)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Mystery Endermite Pet", ChatColor.BLUE)),
            new ItemCollectionRewards(15000, new ItemCollectionUpgradeReward("Travel Scroll to The End", ChatColor.BLUE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Catalyst", ChatColor.BLUE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("End Stone Sword", ChatColor.DARK_PURPLE)));

    public static final ItemCollection MITHRIL = new ItemCollection("Mithril",
            ItemCollectionCategory.MINING,
            SMaterial.GLOWSTONE_DUST,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(5000),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(40000),
            new ItemCollectionRewards(70000));

    public static final ItemCollection HARD_STONE = new ItemCollection("Hard Stone",
            ItemCollectionCategory.MINING,
            SMaterial.STONE,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(5000),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(40000),
            new ItemCollectionRewards(70000));

    public static final ItemCollection GEM_STONE = new ItemCollection("Gem Stone",
            ItemCollectionCategory.MINING,
            SMaterial.EMERALD_BLOCK,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(5000),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(40000),
            new ItemCollectionRewards(70000));

    public static final ItemCollection MYCELIUM = new ItemCollection("Mycelium",
            ItemCollectionCategory.MINING,
            SMaterial.MYCEL,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Mycelum Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(500, new ItemCollectionUpgradeReward("Suspicious Stew", ChatColor.BLUE)),
            new ItemCollectionRewards(750, new ItemCollectionUpgradeReward("Enchanted Mycelium", ChatColor.GREEN)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Mushroom Biome Stick", ChatColor.WHITE)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Mycelium Dust", ChatColor.BLUE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Corrupt Soil", ChatColor.DARK_PURPLE)),
            new ItemCollectionRewards(15000, new ItemCollectionUpgradeReward("Enchanted Mycelium", ChatColor.BLUE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Mystery Mooshroom Cow Pet", ChatColor.BLUE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Shimmering Light Hood", ChatColor.BLUE), new ItemCollectionUpgradeReward("Shimmering Light Tunic", ChatColor.BLUE), new ItemCollectionUpgradeReward("Shimmering Light Trousers", ChatColor.BLUE), new ItemCollectionUpgradeReward("Shimmering Light Slippers", ChatColor.BLUE)),
            new ItemCollectionRewards(100000, new ItemCollectionUpgradeReward("Gauntlet of Contagion", ChatColor.DARK_PURPLE)));

    public static final ItemCollection RED_SAND = new ItemCollection("Red Sand",
            ItemCollectionCategory.MINING,
            SMaterial.RED_SAND,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Red Sand Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(500, new ItemCollectionUpgradeReward("Enchanted Red Sand", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Mesa Biome Stick", ChatColor.WHITE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Enchanted Red Sand Cube", ChatColor.BLUE)),
            new ItemCollectionRewards(15000, new ItemCollectionUpgradeReward("Ancient Cloak", ChatColor.DARK_PURPLE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Mystery Snail Pet", ChatColor.BLUE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Berserker Helmet", ChatColor.DARK_PURPLE), new ItemCollectionUpgradeReward("Berserker Chestplate", ChatColor.DARK_PURPLE), new ItemCollectionUpgradeReward("Berserker Leggings", ChatColor.DARK_PURPLE), new ItemCollectionUpgradeReward("Berserker Boots", ChatColor.DARK_PURPLE)),
            new ItemCollectionRewards(100000, new ItemCollectionUpgradeReward("Everburning Flame", ChatColor.DARK_PURPLE)));

    public static final ItemCollection SULPHUR = new ItemCollection("Sulphur",
            ItemCollectionCategory.MINING,
            SMaterial.GLOWSTONE_DUST,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(5000),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(40000),
            new ItemCollectionRewards(70000));

    // COMBAT
    public static final ItemCollection ROTTEN_FLESH = new ItemCollection("Rotten Flesh",
            ItemCollectionCategory.COMBAT,
            SMaterial.ROTTEN_FLESH,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Zombie Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Zombie Pickaxe", ChatColor.WHITE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Enchanted Book (Smite IV)", ChatColor.WHITE)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Rotten Flesh", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Zombie Hat", ChatColor.WHITE), new ItemCollectionUpgradeReward("Small Combat Sack", ChatColor.GREEN)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Zombie's Heart", ChatColor.BLUE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Zombie Sword", ChatColor.BLUE), new ItemCollectionUpgradeReward("Medium Combat Sack", ChatColor.BLUE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Zombie Chestplate", ChatColor.DARK_PURPLE), new ItemCollectionUpgradeReward("Zombie Leggings", ChatColor.DARK_PURPLE), new ItemCollectionUpgradeReward("Zombie Boots", ChatColor.DARK_PURPLE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Mystery Zombie Pet", ChatColor.BLUE), new ItemCollectionUpgradeReward("Large Combat Sack", ChatColor.DARK_PURPLE)),
            new ItemCollectionRewards(100000, new ItemCollectionUpgradeReward("Large Enchanted Combat Sack", ChatColor.DARK_PURPLE)));

    public static final ItemCollection BLAZE_ROD = new ItemCollection("Blaze Rod",
            ItemCollectionCategory.COMBAT,
            SMaterial.BLAZE_ROD,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Blaze Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Enchanted Book (Fire Aspect I)", ChatColor.WHITE)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Blaze Powder", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Fire Talisman", ChatColor.WHITE), new ItemCollectionUpgradeReward("Blaze Belt", ChatColor.BLUE)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Enchanted Book (Flame I)", ChatColor.WHITE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Enchanted Blaze Rod", ChatColor.GREEN), new ItemCollectionUpgradeReward("Blze Wax", ChatColor.BLUE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Blaze Helmet", ChatColor.DARK_PURPLE), new ItemCollectionUpgradeReward("Blaze Chestplate", ChatColor.DARK_PURPLE), new ItemCollectionUpgradeReward("Blaze Leggings", ChatColor.DARK_PURPLE), new ItemCollectionUpgradeReward("Blaze Boots", ChatColor.DARK_GRAY)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Mystery Blaze Pet", ChatColor.BLUE)));

    public static final ItemCollection BONE = new ItemCollection("Bones",
            ItemCollectionCategory.COMBAT,
            SMaterial.BONE,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Skeleton Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Enchanted Bone Meal", ChatColor.WHITE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Enchanted Book (Power IV)", ChatColor.WHITE)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Skeleton Hat", ChatColor.WHITE)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Enchanted Bone", ChatColor.GREEN)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Mystery Skeleton Pet", ChatColor.BLUE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Hurricane Bow", ChatColor.DARK_PURPLE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Skeleton's Helmet", ChatColor.BLUE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Runaan's Bow", ChatColor.GOLD)),
            new ItemCollectionRewards(150000, new ItemCollectionUpgradeReward("Enchanted Bone Block", ChatColor.BLUE)));

    public static final ItemCollection ENDER_PEARL = new ItemCollection("Ender Pearl",
            ItemCollectionCategory.COMBAT,
            SMaterial.ENDER_PEARL,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Enderman Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Enchanted Ender Pearl", ChatColor.GREEN)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Book (Ender Slayer IV)", ChatColor.WHITE)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Small Dragon Sack", ChatColor.GREEN)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Ender Bow", ChatColor.BLUE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Enchanted Eye of Ender", ChatColor.GREEN), new ItemCollectionUpgradeReward("Medium Dragon Sack", ChatColor.BLUE)),
            new ItemCollectionRewards(15000, new ItemCollectionUpgradeReward("Teleport Pad", ChatColor.GREEN), new ItemCollectionUpgradeReward("Absolute Ender Pearl", ChatColor.BLUE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Aspect of the End", ChatColor.BLUE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Saving Grace", ChatColor.BLUE), new ItemCollectionUpgradeReward("Large Dragon Sack", ChatColor.DARK_PURPLE)));

    public static final ItemCollection GHAST_TEAR = new ItemCollection("Ghast Tear",
            ItemCollectionCategory.COMBAT,
            SMaterial.GHAST_TEAR,
            (short) 0,
            new ItemCollectionRewards(20, new ItemCollectionUpgradeReward("Ghast Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Enchanted Book (Giant Killer IV)", ChatColor.WHITE)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Ghast Tear", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Enchanted Book Vampirism IV)", ChatColor.WHITE)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Silver Fang", ChatColor.GREEN)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Meteor Shard", ChatColor.BLUE)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Vanquished Ghast Cloak", ChatColor.DARK_PURPLE)));

    public static final ItemCollection STRING = new ItemCollection("String",
            ItemCollectionCategory.COMBAT,
            SMaterial.STRING,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Spider Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Web", ChatColor.GREEN)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Quiver", ChatColor.GREEN)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted String", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Enchanted ook (Silk Touch I)", ChatColor.WHITE)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Enchanted Book (Infinite Quiver IV)", ChatColor.WHITE), new ItemCollectionUpgradeReward("Large Quiver Upgrade", ChatColor.GREEN)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Grappling Hook", ChatColor.GREEN)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Spider's Boots", ChatColor.BLUE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Mystery Spider Pet", ChatColor.BLUE), new ItemCollectionUpgradeReward("Giant Quiver Upgrade", ChatColor.GREEN)));

    public static final ItemCollection GUNPOWDER = new ItemCollection("Gunpowder",
            ItemCollectionCategory.COMBAT,
            SMaterial.GUNPOWDER,
            (short) 0,
            new ItemCollectionRewards(50, new ItemCollectionUpgradeReward("Creeper Minion", ChatColor.BLUE)),
            new ItemCollectionRewards(100, new ItemCollectionUpgradeReward("Creeper hat", ChatColor.WHITE)),
            new ItemCollectionRewards(250, new ItemCollectionUpgradeReward("Enchanted Book (Blast Protection IV)", ChatColor.WHITE)),
            new ItemCollectionRewards(1000, new ItemCollectionUpgradeReward("Enchanted Gunpowder", ChatColor.GREEN)),
            new ItemCollectionRewards(2500, new ItemCollectionUpgradeReward("Enchanted Book (Thunderlord IV)", ChatColor.WHITE)),
            new ItemCollectionRewards(5000, new ItemCollectionUpgradeReward("Enchanted Firework Rocket", ChatColor.BLUE)),
            new ItemCollectionRewards(10000, new ItemCollectionUpgradeReward("Coming Soon", ChatColor.RED)),
            new ItemCollectionRewards(25000, new ItemCollectionUpgradeReward("Creeper Pants", ChatColor.BLUE)),
            new ItemCollectionRewards(50000, new ItemCollectionUpgradeReward("Explosive Bow", ChatColor.DARK_PURPLE)));

    public static final ItemCollection MAGMA_CREAM = new ItemCollection("Magma Cream",
            ItemCollectionCategory.COMBAT,
            SMaterial.MAGMA_CREAM,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(5000),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(50000));

    public static final ItemCollection SLIME_BALL = new ItemCollection("Slimeball",
            ItemCollectionCategory.COMBAT,
            SMaterial.SLIME_BALL,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(5000),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(50000));

    public static final ItemCollection SPIDER_EYE = new ItemCollection("Spider Eye",
            ItemCollectionCategory.COMBAT,
            SMaterial.SPIDER_EYE,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(5000),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(50000));

    // FORAGING

    public static final ItemCollection OAK_WOOD = new ItemCollection("Oak Wood",
            ItemCollectionCategory.FORAGING,
            SMaterial.OAK_WOOD,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(30000));

    public static final ItemCollection SPRUCE_WOOD = new ItemCollection("Spruce Wood",
            ItemCollectionCategory.FORAGING,
            SMaterial.SPRUCE_WOOD,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(30000));

    public static final ItemCollection BIRCH_WOOD = new ItemCollection("Birch Wood",
            ItemCollectionCategory.FORAGING,
            SMaterial.BIRCH_WOOD,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(30000));

    public static final ItemCollection DARK_OAK_WOOD = new ItemCollection("Dark Oak Wood",
            ItemCollectionCategory.FORAGING,
            SMaterial.DARK_OAK_WOOD,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(30000));

    public static final ItemCollection ACACIA_WOOD = new ItemCollection("Acacia Wood",
            ItemCollectionCategory.FORAGING,
            SMaterial.ACACIA_WOOD,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(30000));

    public static final ItemCollection JUNGLE_WOOD = new ItemCollection("Jungle Wood",
            ItemCollectionCategory.FORAGING,
            SMaterial.JUNGLE_WOOD,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(30000));

    //Fishing

    public static final ItemCollection RAW_FISH = new ItemCollection("Raw Fish",
            ItemCollectionCategory.FISHING,
            SMaterial.RAW_FISH,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(15000),
            new ItemCollectionRewards(30000),
            new ItemCollectionRewards(45000),
            new ItemCollectionRewards(60000));

    public static final ItemCollection CLAY_BALL = new ItemCollection("Clay",
            ItemCollectionCategory.FISHING,
            SMaterial.CLAY_BALL,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500));

    public static final ItemCollection INK_SACK = new ItemCollection("Raw Fish",
            ItemCollectionCategory.FISHING,
            SMaterial.INK_SACK,
            (short) 0,
            new ItemCollectionRewards(20),
            new ItemCollectionRewards(40),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(200),
            new ItemCollectionRewards(400),
            new ItemCollectionRewards(800),
            new ItemCollectionRewards(1500),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(4000));

    public static final ItemCollection WATER_LILY = new ItemCollection("Lily Pad",
            ItemCollectionCategory.FISHING,
            SMaterial.WATER_LILY,
            (short) 0,
            new ItemCollectionRewards(10),
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(200),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1500),
            new ItemCollectionRewards(3000),
            new ItemCollectionRewards(6000),
            new ItemCollectionRewards(10000));

    public static final ItemCollection PRISMARINE_CRYSTAL = new ItemCollection("Prismarine Crystal",
            ItemCollectionCategory.FISHING,
            SMaterial.PRISMARINE_CRYSTALS,
            (short) 0,
            new ItemCollectionRewards(10),
            new ItemCollectionRewards(25),
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(200),
            new ItemCollectionRewards(400),
            new ItemCollectionRewards(800));

    public static final ItemCollection PRISMARINE_SHARD = new ItemCollection("Prismarine Shard",
            ItemCollectionCategory.FISHING,
            SMaterial.PRISMARINE_SHARD,
            (short) 0,
            new ItemCollectionRewards(10),
            new ItemCollectionRewards(25),
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(200),
            new ItemCollectionRewards(400));

    public static final ItemCollection PUFFERFISH = new ItemCollection("Pufferfish",
            ItemCollectionCategory.FISHING,
            SMaterial.PUFFERFISH,
            (short) 0,
            new ItemCollectionRewards(20),
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(150),
            new ItemCollectionRewards(400),
            new ItemCollectionRewards(800),
            new ItemCollectionRewards(2400),
            new ItemCollectionRewards(4800),
            new ItemCollectionRewards(9000),
            new ItemCollectionRewards(18000));

    public static final ItemCollection RAW_SALMON = new ItemCollection("Raw Salmon",
            ItemCollectionCategory.FISHING,
            SMaterial.RAW_SALMON,
            (short) 0,
            new ItemCollectionRewards(20),
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(10000));

    public static final ItemCollection SPONGE = new ItemCollection("Sponge",
            ItemCollectionCategory.FISHING,
            SMaterial.SPONGE,
            (short) 0,
            new ItemCollectionRewards(20),
            new ItemCollectionRewards(40),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(200),
            new ItemCollectionRewards(400),
            new ItemCollectionRewards(800),
            new ItemCollectionRewards(1500),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(4000));


    private final String name;
    private final String identifier;
    private final ItemCollectionCategory category;
    private final SMaterial material;
    private final short data;
    private final List<ItemCollectionRewards> rewards;
    private final boolean temporary; // TODO: remove when rewards are added

    private ItemCollection(String name, ItemCollectionCategory category, SMaterial material, short data, ItemCollectionRewards... rewards) {
        this.name = name;
        this.identifier = name.toLowerCase().replaceAll(" ", "_");
        this.category = category;
        this.material = material;
        this.data = data;
        this.rewards = new ArrayList<>(Arrays.asList(rewards));
        this.temporary = false;
        COLLECTION_MAP.put(identifier, this);
    }

    // more of a temporary constructor until all items are added
    private ItemCollection(String name, ItemCollectionCategory category, SMaterial material, short data, int size) {
        this.name = name;
        this.identifier = name.toLowerCase().replaceAll(" ", "_");
        this.category = category;
        this.material = material;
        this.data = data;
        this.rewards = new ArrayList<>();
        for (int i = 0; i < size; i++)
            rewards.add(null);
        this.temporary = true;
        COLLECTION_MAP.put(identifier, this);
    }

    public static String[] getProgress(Player player, ItemCollectionCategory category) {
        User user = User.getUser(player.getUniqueId());
        AtomicInteger found = new AtomicInteger(), completed = new AtomicInteger();
        Collection<ItemCollection> collections = category != null ? getCategoryCollections(category) : getCollections();
        for (ItemCollection collection : collections) {
            if (user.getCollection(collection) > 0)
                found.incrementAndGet();
            if (user.getCollection(collection) >= collection.getMaxAmount())
                completed.incrementAndGet();
        }
        String title;
        String progress;
        if (collections.size() == found.get()) {
            title = SUtil.createProgressText("Collection Maxed Out", completed.get(), collections.size());
            progress = SUtil.createLineProgressBar(20, ChatColor.DARK_GREEN, completed.get(), collections.size());
        } else {
            title = SUtil.createProgressText("Collection Unlocked", found.get(), collections.size());
            progress = SUtil.createLineProgressBar(20, ChatColor.DARK_GREEN, found.get(), collections.size());
        }
        return new String[]{title, progress};
    }

    public int getMaxAmount() {
        if (rewards.size() == 0 || rewards.get(rewards.size() - 1) == null)
            return 0;
        return rewards.get(rewards.size() - 1).getRequirement();
    }

    public int getTierAmount() {
        return rewards.size();
    }

    public int getTier(int amount) {
        int tier = 0;
        for (ItemCollectionRewards reward : rewards) {
            if (reward == null) continue;
            if (reward.getRequirement() > amount)
                break;
            tier++;
        }
        return tier;
    }

    public int getRequirementForTier(int tier) {
        tier -= 1;
        if (tier < 0 || tier > rewards.size() - 1)
            return -1;
        ItemCollectionRewards reward = rewards.get(tier);
        if (reward == null)
            return -1;
        return reward.getRequirement();
    }

    public ItemCollectionRewards getRewardsFor(int tier) {
        tier -= 1;
        if (tier < 0 || tier > rewards.size())
            return null;
        return rewards.get(tier);
    }

    public static ItemCollection getByIdentifier(String identifier) {
        return COLLECTION_MAP.get(identifier.toLowerCase());
    }

    public static ItemCollection getByMaterial(SMaterial material, short data) {
        for (ItemCollection collection : COLLECTION_MAP.values()) {
            if (collection.material == material && collection.data == data)
                return collection;
        }
        return null;
    }

    public static Map<ItemCollection, Integer> getDefaultCollections() {
        Map<ItemCollection, Integer> collections = new HashMap<>();
        for (ItemCollection collection : COLLECTION_MAP.values())
            collections.put(collection, 0);
        return collections;
    }

    public static Collection<ItemCollection> getCollections() {
        return COLLECTION_MAP.values();
    }

    public static List<ItemCollection> getCategoryCollections(ItemCollectionCategory category) {
        return getCollections().stream().filter(collection -> collection.category == category).collect(Collectors.toList());
    }
}