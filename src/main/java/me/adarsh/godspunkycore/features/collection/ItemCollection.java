package me.adarsh.godspunkycore.features.collection;

import lombok.Getter;
import me.adarsh.godspunkycore.features.item.SMaterial;
import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
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
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(5000),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(50000));

    public static final ItemCollection CARROT = new ItemCollection("Carrot",
            ItemCollectionCategory.FARMING,
            SMaterial.CARROT_ITEM,
            (short) 0,
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(5000),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(50000));

    public static final ItemCollection COCOA_BEANS = new ItemCollection("Cocoa Beans",
            ItemCollectionCategory.FARMING,
            SMaterial.COCOA_BEANS,
            (short) 3,
            new ItemCollectionRewards(75),
            new ItemCollectionRewards(200),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(2000),
            new ItemCollectionRewards(5000),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(20000),
            new ItemCollectionRewards(50000),
            new ItemCollectionRewards(100000));

    public static final ItemCollection FEATHER = new ItemCollection("Feather",
            ItemCollectionCategory.FARMING,
            SMaterial.FEATHER,
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

    public static final ItemCollection LEATHER = new ItemCollection("Leather",
            ItemCollectionCategory.FARMING,
            SMaterial.LEATHER,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(5000),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(50000),
            new ItemCollectionRewards(100000));

    public static final ItemCollection MELON = new ItemCollection("Melon",
            ItemCollectionCategory.FARMING,
            SMaterial.MELON,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(15000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(50000),
            new ItemCollectionRewards(100000));

    public static final ItemCollection MUTTON = new ItemCollection("Mutton",
            ItemCollectionCategory.FARMING,
            SMaterial.MUTTON,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(15000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(50000),
            new ItemCollectionRewards(100000));

    public static final ItemCollection NETHER_WARTS = new ItemCollection("Nether Warts",
            ItemCollectionCategory.FARMING,
            SMaterial.NETHER_WARTS,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(15000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(50000),
            new ItemCollectionRewards(100000));

    public static final ItemCollection POTATO = new ItemCollection("Potato",
            ItemCollectionCategory.FARMING,
            SMaterial.POTATO_ITEM,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(15000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(50000),
            new ItemCollectionRewards(100000));

    public static final ItemCollection PUMPKIN = new ItemCollection("Pumpkin",
            ItemCollectionCategory.FARMING,
            SMaterial.PUMPKIN,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(15000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(50000),
            new ItemCollectionRewards(100000));

    public static final ItemCollection RAW_CHICKEN = new ItemCollection("Raw Chicken",
            ItemCollectionCategory.FARMING,
            SMaterial.RAW_CHICKEN,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(15000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(50000),
            new ItemCollectionRewards(100000));

    public static final ItemCollection SUGAR_CANE = new ItemCollection("Sugar Cane",
            ItemCollectionCategory.FARMING,
            SMaterial.SUGAR_CANE,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(15000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(50000),
            new ItemCollectionRewards(100000));

    public static final ItemCollection SEEDS = new ItemCollection("Seeds",
            ItemCollectionCategory.FARMING,
            SMaterial.SEEDS,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(500),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(15000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(50000),
            new ItemCollectionRewards(100000));

    // Mining
    public static final ItemCollection COBBLESTONE = new ItemCollection("Cobblestone",
            ItemCollectionCategory.MINING,
            SMaterial.COBBLESTONE,
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

    public static final ItemCollection COAL = new ItemCollection("Coal",
            ItemCollectionCategory.MINING,
            SMaterial.COAL,
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

    public static final ItemCollection IRON_INGOT = new ItemCollection("Iron Ingot",
            ItemCollectionCategory.MINING,
            SMaterial.IRON_INGOT,
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

    public static final ItemCollection GOLD_INGOT = new ItemCollection("Gold Ingot",
            ItemCollectionCategory.MINING,
            SMaterial.GOLD_INGOT,
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

    public static final ItemCollection DIAMOND = new ItemCollection("Diamond",
            ItemCollectionCategory.MINING,
            SMaterial.DIAMOND,
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

    public static final ItemCollection LAPIS_LAZULI = new ItemCollection("Lapis Lazuli",
            ItemCollectionCategory.MINING,
            SMaterial.LAPIS_LAZULI,
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

    public static final ItemCollection EMERALD = new ItemCollection("Emerald",
            ItemCollectionCategory.MINING,
            SMaterial.EMERALD,
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

    public static final ItemCollection REDSTONE= new ItemCollection("Redstone",
            ItemCollectionCategory.MINING,
            SMaterial.REDSTONE,
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

    public static final ItemCollection NETHER_QUARTZ = new ItemCollection("Nether Quartz",
            ItemCollectionCategory.MINING,
            SMaterial.NETHER_QUARTZ_ORE,
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

    public static final ItemCollection OBSIDIAN = new ItemCollection("Obsidian",
            ItemCollectionCategory.MINING,
            SMaterial.OBSIDIAN,
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

    public static final ItemCollection GLOWSTONE_DUST = new ItemCollection("Glowstone Dust",
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

    public static final ItemCollection GRAVEL = new ItemCollection("Gravel",
            ItemCollectionCategory.MINING,
            SMaterial.GRAVEL,
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

    public static final ItemCollection ICE = new ItemCollection("Ice",
            ItemCollectionCategory.MINING,
            SMaterial.ICE,
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

    public static final ItemCollection NETHERRACK = new ItemCollection("Netherrack",
            ItemCollectionCategory.MINING,
            SMaterial.NETHERRACK,
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

    public static final ItemCollection SAND = new ItemCollection("Sand",
            ItemCollectionCategory.MINING,
            SMaterial.SAND,
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

    public static final ItemCollection END_STONE = new ItemCollection("End Stone",
            ItemCollectionCategory.MINING,
            SMaterial.END_STONE,
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

    public static final ItemCollection RED_SAND = new ItemCollection("Red Sand",
            ItemCollectionCategory.MINING,
            SMaterial.RED_SAND,
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
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(5000),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(50000),
            new ItemCollectionRewards(100000));

    public static final ItemCollection BLAZE_ROD = new ItemCollection("Blaze Rod",
            ItemCollectionCategory.COMBAT,
            SMaterial.BLAZE_ROD,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(5000),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(50000));

    public static final ItemCollection BONE = new ItemCollection("Bones",
            ItemCollectionCategory.COMBAT,
            SMaterial.BONE,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(100),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(5000),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(50000),
            new ItemCollectionRewards(150000));

    public static final ItemCollection ENDER_PEARL = new ItemCollection("Ender Pearl",
            ItemCollectionCategory.COMBAT,
            SMaterial.ENDER_PEARL,
            (short) 0,
            new ItemCollectionRewards(50),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(5000),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(15000),
            new ItemCollectionRewards(25000),
            new ItemCollectionRewards(50000));

    public static final ItemCollection GHAST_TEAR = new ItemCollection("Ghast Tear",
            ItemCollectionCategory.COMBAT,
            SMaterial.GHAST_TEAR,
            (short) 0,
            new ItemCollectionRewards(20),
            new ItemCollectionRewards(250),
            new ItemCollectionRewards(1000),
            new ItemCollectionRewards(2500),
            new ItemCollectionRewards(5000),
            new ItemCollectionRewards(10000),
            new ItemCollectionRewards(25000));

    public static final ItemCollection STRING = new ItemCollection("String",
            ItemCollectionCategory.COMBAT,
            SMaterial.STRING,
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

    public static final ItemCollection GUNPOWDER = new ItemCollection("Gunpowder",
            ItemCollectionCategory.COMBAT,
            SMaterial.GUNPOWDER,
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