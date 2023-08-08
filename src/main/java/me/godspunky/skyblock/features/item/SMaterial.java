package me.godspunky.skyblock.features.item;

import lombok.Getter;
import me.godspunky.skyblock.features.entity.SEntityType;
import me.godspunky.skyblock.features.item.accessory.*;
import me.godspunky.skyblock.features.item.armor.ArmorSet;
import me.godspunky.skyblock.features.item.armor.BigBounceBoots;
import me.godspunky.skyblock.features.item.armor.ObsidianChestplate;
import me.godspunky.skyblock.features.item.armor.SpidersBoots;
import me.godspunky.skyblock.features.item.armor.angler.*;
import me.godspunky.skyblock.features.item.armor.batperson.*;
import me.godspunky.skyblock.features.item.armor.blaze.*;
import me.godspunky.skyblock.features.item.armor.cactus.*;
import me.godspunky.skyblock.features.item.armor.cheaptuxedo.CheapTuxedoBoots;
import me.godspunky.skyblock.features.item.armor.cheaptuxedo.CheapTuxedoChestplate;
import me.godspunky.skyblock.features.item.armor.cheaptuxedo.CheapTuxedoLeggings;
import me.godspunky.skyblock.features.item.armor.crystal.CrystalBoots;
import me.godspunky.skyblock.features.item.armor.crystal.CrystalChestplate;
import me.godspunky.skyblock.features.item.armor.crystal.CrystalHelmet;
import me.godspunky.skyblock.features.item.armor.crystal.CrystalLeggings;
import me.godspunky.skyblock.features.item.armor.eleganttuxedo.ElegantTuxedoBoots;
import me.godspunky.skyblock.features.item.armor.eleganttuxedo.ElegantTuxedoChestplate;
import me.godspunky.skyblock.features.item.armor.eleganttuxedo.ElegantTuxedoLeggings;
import me.godspunky.skyblock.features.item.armor.emerald.EmeraldBoots;
import me.godspunky.skyblock.features.item.armor.emerald.EmeraldChestplate;
import me.godspunky.skyblock.features.item.armor.emerald.EmeraldHelmet;
import me.godspunky.skyblock.features.item.armor.emerald.EmeraldLeggings;
import me.godspunky.skyblock.features.item.armor.ender.*;
import me.godspunky.skyblock.features.item.armor.fancytuxedo.FancyTuxedoBoots;
import me.godspunky.skyblock.features.item.armor.fancytuxedo.FancyTuxedoChestplate;
import me.godspunky.skyblock.features.item.armor.fancytuxedo.FancyTuxedoLeggings;
import me.godspunky.skyblock.features.item.armor.farm.*;
import me.godspunky.skyblock.features.item.armor.flamebreaker.*;
import me.godspunky.skyblock.features.item.armor.glacite.*;
import me.godspunky.skyblock.features.item.armor.goblin.*;
import me.godspunky.skyblock.features.item.armor.golem.*;
import me.godspunky.skyblock.features.item.armor.growth.*;
import me.godspunky.skyblock.features.item.armor.hardened.HardenedDiamondBoots;
import me.godspunky.skyblock.features.item.armor.hardened.HardenedDiamondChestplate;
import me.godspunky.skyblock.features.item.armor.hardened.HardenedDiamondHelmet;
import me.godspunky.skyblock.features.item.armor.hardened.HardenedDiamondLeggings;
import me.godspunky.skyblock.features.item.armor.lapis.*;
import me.godspunky.skyblock.features.item.armor.leaflet.*;
import me.godspunky.skyblock.features.item.armor.magma.MagmaBoots;
import me.godspunky.skyblock.features.item.armor.magma.MagmaChestplate;
import me.godspunky.skyblock.features.item.armor.magma.MagmaHelmet;
import me.godspunky.skyblock.features.item.armor.magma.MagmaLeggings;
import me.godspunky.skyblock.features.item.armor.mastiff.MastiffBoots;
import me.godspunky.skyblock.features.item.armor.mastiff.MastiffChestplate;
import me.godspunky.skyblock.features.item.armor.mastiff.MastiffHelmet;
import me.godspunky.skyblock.features.item.armor.mastiff.MastiffLeggings;
import me.godspunky.skyblock.features.item.armor.miner.*;
import me.godspunky.skyblock.features.item.armor.mushroom.*;
import me.godspunky.skyblock.features.item.armor.necron.NecronBoots;
import me.godspunky.skyblock.features.item.armor.necron.NecronChestplate;
import me.godspunky.skyblock.features.item.armor.necron.NecronHelmet;
import me.godspunky.skyblock.features.item.armor.necron.NecronLeggings;
import me.godspunky.skyblock.features.item.armor.packarmor.*;
import me.godspunky.skyblock.features.item.armor.pumpkin.*;
import me.godspunky.skyblock.features.item.armor.revenant.RevenantBoots;
import me.godspunky.skyblock.features.item.armor.revenant.RevenantChestplate;
import me.godspunky.skyblock.features.item.armor.revenant.RevenantLeggings;
import me.godspunky.skyblock.features.item.armor.rosetta.RosettaBoots;
import me.godspunky.skyblock.features.item.armor.rosetta.RosettaChestplate;
import me.godspunky.skyblock.features.item.armor.rosetta.RosettaHelmet;
import me.godspunky.skyblock.features.item.armor.rosetta.RosettaLeggings;
import me.godspunky.skyblock.features.item.armor.shadowassassin.ShadowAssassinBoots;
import me.godspunky.skyblock.features.item.armor.shadowassassin.ShadowAssassinChestplate;
import me.godspunky.skyblock.features.item.armor.shadowassassin.ShadowAssassinHelmet;
import me.godspunky.skyblock.features.item.armor.shadowassassin.ShadowAssassinLeggings;
import me.godspunky.skyblock.features.item.armor.sharkscale.*;
import me.godspunky.skyblock.features.item.armor.silverhunter.SilverHunterBoots;
import me.godspunky.skyblock.features.item.armor.silverhunter.SilverHunterChestplate;
import me.godspunky.skyblock.features.item.armor.silverhunter.SilverHunterHelmet;
import me.godspunky.skyblock.features.item.armor.silverhunter.SilverHunterLeggings;
import me.godspunky.skyblock.features.item.armor.snow.*;
import me.godspunky.skyblock.features.item.armor.speedster.*;
import me.godspunky.skyblock.features.item.armor.sponge.*;
import me.godspunky.skyblock.features.item.armor.spooky.SpookyBoots;
import me.godspunky.skyblock.features.item.armor.spooky.SpookyChestplate;
import me.godspunky.skyblock.features.item.armor.spooky.SpookyHelmet;
import me.godspunky.skyblock.features.item.armor.spooky.SpookyLeggings;
import me.godspunky.skyblock.features.item.armor.tarantula.TarantulaBoots;
import me.godspunky.skyblock.features.item.armor.tarantula.TarantulaChestplate;
import me.godspunky.skyblock.features.item.armor.tarantula.TarantulaHelmet;
import me.godspunky.skyblock.features.item.armor.tarantula.TarantulaLeggings;
import me.godspunky.skyblock.features.item.armor.terror.TerrorBoots;
import me.godspunky.skyblock.features.item.armor.terror.TerrorChestplate;
import me.godspunky.skyblock.features.item.armor.terror.TerrorHelmet;
import me.godspunky.skyblock.features.item.armor.terror.TerrorLeggings;
import me.godspunky.skyblock.features.item.armor.vanilla.chainmail.ChainmailBoots;
import me.godspunky.skyblock.features.item.armor.vanilla.chainmail.ChainmailChestplate;
import me.godspunky.skyblock.features.item.armor.vanilla.chainmail.ChainmailHelmet;
import me.godspunky.skyblock.features.item.armor.vanilla.chainmail.ChainmailLeggings;
import me.godspunky.skyblock.features.item.armor.vanilla.diamond.DiamondBoots;
import me.godspunky.skyblock.features.item.armor.vanilla.diamond.DiamondChestplate;
import me.godspunky.skyblock.features.item.armor.vanilla.diamond.DiamondHelmet;
import me.godspunky.skyblock.features.item.armor.vanilla.diamond.DiamondLeggings;
import me.godspunky.skyblock.features.item.armor.vanilla.golden.GoldenBoots;
import me.godspunky.skyblock.features.item.armor.vanilla.golden.GoldenChestplate;
import me.godspunky.skyblock.features.item.armor.vanilla.golden.GoldenHelmet;
import me.godspunky.skyblock.features.item.armor.vanilla.golden.GoldenLeggings;
import me.godspunky.skyblock.features.item.armor.vanilla.iron.IronBoots;
import me.godspunky.skyblock.features.item.armor.vanilla.iron.IronChestplate;
import me.godspunky.skyblock.features.item.armor.vanilla.iron.IronHelmet;
import me.godspunky.skyblock.features.item.armor.vanilla.iron.IronLeggings;
import me.godspunky.skyblock.features.item.armor.vanilla.leather.LeatherBoots;
import me.godspunky.skyblock.features.item.armor.vanilla.leather.LeatherChestplate;
import me.godspunky.skyblock.features.item.armor.vanilla.leather.LeatherHelmet;
import me.godspunky.skyblock.features.item.armor.vanilla.leather.LeatherLeggings;
import me.godspunky.skyblock.features.item.armor.werewolf.*;
import me.godspunky.skyblock.features.item.armor.zombie.ZombieBoots;
import me.godspunky.skyblock.features.item.armor.zombie.ZombieChestplate;
import me.godspunky.skyblock.features.item.armor.zombie.ZombieLeggings;
import me.godspunky.skyblock.features.item.axe.vanilla.*;
import me.godspunky.skyblock.features.item.axe.vanilla.axe.PromisingAxe;
import me.godspunky.skyblock.features.item.axe.vanilla.axe.RookieAxe;
import me.godspunky.skyblock.features.item.bow.Bow;
import me.godspunky.skyblock.features.item.bow.bows.*;
import me.godspunky.skyblock.features.item.dragon.old.*;
import me.godspunky.skyblock.features.item.dragon.protector.*;
import me.godspunky.skyblock.features.item.dragon.strong.*;
import me.godspunky.skyblock.features.item.dragon.superior.*;
import me.godspunky.skyblock.features.item.dragon.unstable.*;
import me.godspunky.skyblock.features.item.dragon.wise.*;
import me.godspunky.skyblock.features.item.dragon.young.*;
import me.godspunky.skyblock.features.item.enchanted.Woodandfish.*;
import me.godspunky.skyblock.features.item.enchanted.combat.*;
import me.godspunky.skyblock.features.item.enchanted.farming.*;
import me.godspunky.skyblock.features.item.enchanted.mining.*;
import me.godspunky.skyblock.features.item.enchanting.EnchantedBook;
import me.godspunky.skyblock.features.item.entity.*;
import me.godspunky.skyblock.features.item.entity.Bonzo.BonzoMask;
import me.godspunky.skyblock.features.item.exclusive.TestItem;
import me.godspunky.skyblock.features.item.exclusive.WheatCrystal;
import me.godspunky.skyblock.features.item.farming.*;
import me.godspunky.skyblock.features.item.foraging.*;
import me.godspunky.skyblock.features.item.hoe.vanilla.*;
import me.godspunky.skyblock.features.item.hoe.vanilla.hoe.RookieHoe;
import me.godspunky.skyblock.features.item.mining.*;
import me.godspunky.skyblock.features.item.minions.Compactor;
import me.godspunky.skyblock.features.item.minions.SuperCompactor3000;
import me.godspunky.skyblock.features.item.oddities.*;
import me.godspunky.skyblock.features.item.orb.*;
import me.godspunky.skyblock.features.item.pet.EndermanPet;
import me.godspunky.skyblock.features.item.pet.GungaPet;
import me.godspunky.skyblock.features.item.pickaxe.vanilla.*;
import me.godspunky.skyblock.features.item.pickaxe.vanilla.pickaxe.PromisingPickaxe;
import me.godspunky.skyblock.features.item.pickaxe.vanilla.pickaxe.RookiePickaxe;
import me.godspunky.skyblock.features.item.revenant.*;
import me.godspunky.skyblock.features.item.rune.*;
import me.godspunky.skyblock.features.item.shovel.vanilla.*;
import me.godspunky.skyblock.features.item.storage.*;
import me.godspunky.skyblock.features.item.sven.*;
import me.godspunky.skyblock.features.item.tarantula.*;
import me.godspunky.skyblock.features.item.weapon.*;
import me.godspunky.skyblock.features.item.weapon.vanilla.*;
import me.godspunky.skyblock.util.SUtil;
import org.bukkit.Material;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SMaterial {
    // Standard Weapons
    HYPERION(Material.IRON_SWORD, Hyperion.class),
    DAGGER(Material.IRON_SWORD, Dagger.class),
    ASPECT_OF_THE_END(Material.DIAMOND_SWORD, AspectOfTheEnd.class),
    LEAPING_SWORD(Material.GOLD_SWORD, LeapingSword.class),
    ASPECT_OF_THE_DRAGONS(Material.DIAMOND_SWORD, AspectOfTheDragons.class),
    ASPECT_OF_THE_JERRY(Material.WOOD_SWORD, AspectOfTheJerry.class),
    ROGUE_SWORD(Material.GOLD_SWORD, RogueSword.class),
    EMERALD_BLADE(Material.EMERALD, EmeraldBlade.class),
    GOLEM_SWORD(Material.IRON_SWORD, GolemSword.class),
    SPIDER_SWORD(Material.IRON_SWORD, SpiderSword.class),
    UNDEAD_SWORD(Material.IRON_SWORD, UndeadSword.class),
    CLEAVER_SWORD(Material.GOLD_SWORD, CleaverSword.class),
    END_SWORD(Material.DIAMOND_SWORD, EndSword.class),
    FLAMING_SWORD(Material.IRON_SWORD, FlamingSword.class),
    SILVER_FANG(Material.GHAST_TEAR, SilverFang.class),
    EDIBLE_MACE(Material.MUTTON, EdibleMace.class),
    FROZEN_SCYTHE(Material.IRON_HOE, FrozenScythe.class),
    RAIDER_AXE(Material.IRON_AXE, RaiderAxe.class),
    ZOMBIE_SWORD(Material.IRON_SWORD, ZombieSword.class),
    DREADLORD_SWORD(Material.IRON_SWORD, DreadlordSword.class),
    BONZO_STAFF(Material.BLAZE_ROD, BonzoStaff.class),
    SUPER_CLEAVER(Material.GOLD_SWORD, SuperCleaver.class),
    EMBER_ROD(Material.BLAZE_ROD, EmberRod.class),
    INK_WAND(Material.STICK, InkWand.class),
    REAPER_FALCHION(Material.DIAMOND_SWORD, ReaperFalchion.class),
    ZOMBIE_KNIGHT_SWORD(Material.IRON_SWORD, ZmobieKnightSword.class),
    HYPER_CLEAVER(Material.GOLD_SWORD, HyperCleaver.class),
    GIANT_CLEAVER(Material.GOLD_SWORD, GiantCleaver.class),
    SPIRIT_SWORD(Material.IRON_SWORD, SpiritSword.class),
    FEL_SWORD(Material.STONE_SWORD, FelSword.class),
    ASPECT_OF_THE_VOID(Material.DIAMOND_SPADE, AspectOfTheVoid.class),
    JERRY_CHINE_GUN(Material.GOLD_BARDING, JerryChineGun.class),
    MIDAS_SWORD(Material.GOLD_SWORD, MidasSword.class),
    MIDAS_STAFF(Material.GOLD_SPADE, MidasStaff.class),
    YETI_SWORD(Material.IRON_SWORD, YetiSword.class),
    GIANT_SWORD(Material.IRON_SWORD, GiantSword.class),
    SPIRIT_SCEPTRE(Material.RED_ROSE, SpiritSceptre.class),
    SOUL_WHIP(Material.FISHING_ROD, SoulWhip.class),
    VOIDWALKER_KATANA(Material.IRON_SWORD, VoidwalkerKatana.class),
    VALKYIRE(Material.IRON_SWORD, Valkyrie.class),
    SHADOW_FURY(Material.DIAMOND_SWORD, ShadowFury.class),
    LIVID_DAGGER(Material.IRON_SWORD, LividDagger.class),

    // Terror Armor
    TERROR_HELMET(Material.SKULL_ITEM, TerrorHelmet.class),
    TERROR_CHESTPLATE(Material.LEATHER_CHESTPLATE, TerrorChestplate.class),
    TERROR_LEGGINGS(Material.LEATHER_LEGGINGS, TerrorLeggings.class),
    TERROR_BOOTS(Material.LEATHER_BOOTS, TerrorBoots.class),

    // Necron's Armor
    NECRON_HELMET(Material.SKULL_ITEM, NecronHelmet.class),
    NECRON_CHESTPLATE(Material.LEATHER_CHESTPLATE, NecronChestplate.class),
    NECRON_LEGGINGS(Material.LEATHER_LEGGINGS, NecronLeggings.class),
    NECRON_BOOTS(Material.LEATHER_BOOTS, NecronBoots.class),

    // Cactus Armor
    CACTUS_BOOTS(Material.LEATHER_BOOTS, CactusArmorBoots.class),
    CACTUS_LEGGINGS(Material.LEATHER_LEGGINGS, CactusArmorLeggings.class),
    CACTUS_CHESTPLATE(Material.LEATHER_CHESTPLATE, CactusArmorChestplate.class),
    CACTUS_HELMET(Material.LEATHER_HELMET, CactusArmorHelmet.class),

    // Rosetta's Armor
    ROSETTA_BOOTS(Material.DIAMOND_BOOTS, RosettaBoots.class),
    ROSETTA_CHESTPLATE(Material.DIAMOND_CHESTPLATE, RosettaChestplate.class),
    ROSETTA_HELMET(Material.DIAMOND_HELMET, RosettaHelmet.class),
    ROSETTA_LEGGINGS(Material.DIAMOND_LEGGINGS, RosettaLeggings.class),

    // Golem Armor
    GOLEM_BOOTS(Material.IRON_BOOTS, GolemArmorBoots.class),
    GOLEM_LEGGINGS(Material.IRON_LEGGINGS, GolemArmorLeggings.class),
    GOLEM_CHESTPLATE(Material.IRON_CHESTPLATE, GolemArmorChestplate.class),
    GOLEM_HELMET(Material.IRON_HELMET, GolemArmorHelmet.class),

    // Growth Armor
    GROWTH_HELMET(Material.LEATHER_HELMET, GrowthHelmet.class),
    GROWTH_CHESTPLATE(Material.LEATHER_CHESTPLATE, GrowthChestplate.class),
    GROWTH_LEGGINGS(Material.LEATHER_LEGGINGS, GrowthLeggings.class),
    GROWTH_BOOTS(Material.LEATHER_BOOTS, GrowthBoots.class),

    // Goblin Armor
    GOBLIN_HELMET(Material.SKULL_ITEM, GoblinHelmet.class),
    GOBLIN_CHESTPLATE(Material.LEATHER_CHESTPLATE, GoblinChestplate.class),
    GOBLIN_LEGGINGS(Material.LEATHER_LEGGINGS, GoblinLeggings.class),
    GOBLIN_BOOTS(Material.LEATHER_BOOTS, GoblinBoots.class),

    // Silver Hunter Armor
    SILVER_HUNTER_HELMET(Material.IRON_HELMET, SilverHunterHelmet.class),
    SILVER_HUNTER_CHESTPLATE(Material.IRON_CHESTPLATE, SilverHunterChestplate.class),
    SILVER_HUNTER_LEGGINGS(Material.IRON_LEGGINGS, SilverHunterLeggings.class),
    SILVER_HUNTER_BOOTS(Material.IRON_BOOTS, SilverHunterBoots.class),

    // Magma Armor
    MAGMA_HELMET(Material.LEATHER_HELMET, MagmaHelmet.class),
    MAGMA_CHESTPLATE(Material.LEATHER_CHESTPLATE, MagmaChestplate.class),
    MAGMA_LEGGINGS(Material.LEATHER_LEGGINGS, MagmaLeggings.class),
    MAGMA_BOOTS(Material.LEATHER_BOOTS, MagmaBoots.class),

    // Crystal Armor
    CRYSTAL_HELMET(Material.LEATHER_HELMET, CrystalHelmet.class),
    CRYSTAL_CHESTPLATE(Material.LEATHER_CHESTPLATE, CrystalChestplate.class),
    CRYSTAL_LEGGINGS(Material.LEATHER_LEGGINGS, CrystalLeggings.class),
    CRYSTAL_BOOTS(Material.LEATHER_BOOTS, CrystalBoots.class),

    // Zombie Armor
    ZOMBIE_CHESTPLATE(Material.DIAMOND_CHESTPLATE, ZombieChestplate.class),
    ZOMBIE_BOOTS(Material.DIAMOND_BOOTS, ZombieBoots.class),
    ZOMBIE_LEGGINGS(Material.DIAMOND_LEGGINGS, ZombieLeggings.class),

    // Blaze Armor
    BLAZE_HELMET(Material.SKULL_ITEM, BlazeHelmet.class),
    BLAZE_CHESTPLATE(Material.LEATHER_CHESTPLATE, BlazeChestplate.class),
    BLAZE_LEGGINGS(Material.LEATHER_LEGGINGS, BlazeLeggings.class),
    BLAZE_BOOTS(Material.LEATHER_BOOTS, BlazeBoots.class),

    // Speedster Armor
    SPEEDSTER_HELMET(Material.LEATHER_HELMET, SpeedsterHelmet.class),
    SPEEDSTER_CHESTPLATE(Material.LEATHER_CHESTPLATE, SpeedsterChestplate.class),
    SPEEDSTER_LEGGINGS(Material.LEATHER_LEGGINGS, SpeedsterLeggings.class),
    SPEEDSTER_BOOTS(Material.LEATHER_BOOTS, SpeedsterBoots.class),

    // Sponge Armor
    SPONGE_HELMET(Material.SKULL_ITEM, SpongeHelmet.class),
    SPONGE_CHESTPLATE(Material.LEATHER_CHESTPLATE, SpongeChestplate.class),
    SPONGE_LEGGINGS(Material.LEATHER_LEGGINGS, SpongeLeggings.class),
    SPONGE_BOOTS(Material.LEATHER_BOOTS, SpongeBoots.class),

    // Tarantula Armor
    TARANTULA_HELMET(Material.LEATHER_HELMET, TarantulaHelmet.class),
    TARANTULA_CHESTPLATE(Material.LEATHER_CHESTPLATE, TarantulaChestplate.class),
    TARANTULA_LEGGINGS(Material.LEATHER_LEGGINGS, TarantulaLeggings.class),
    TARANTULA_BOOTS(Material.LEATHER_BOOTS, TarantulaBoots.class),

    //Revenant Armor
    REVENANT_CHESTPLATE(Material.DIAMOND_CHESTPLATE, RevenantChestplate.class),
    REVENANT_LEGGINGS(Material.DIAMOND_LEGGINGS, RevenantLeggings.class),
    REVENANT_BOOTS(Material.DIAMOND_BOOTS, RevenantBoots.class),

    // Snow Suit Armor
    SNOW_SUIT_HELMET(Material.SKULL_ITEM, SnowSuitHelmet.class),
    SNOW_SUIT_CHESTPLATE(Material.LEATHER_CHESTPLATE, SnowSuitChestplate.class),
    SNOW_SUIT_LEGGINGS(Material.LEATHER_LEGGINGS, SnowSuitLeggings.class),
    SNOW_SUIT_BOOTS(Material.LEATHER_BOOTS, SnowSuitBoots.class),

    // Flamebreaker Armor
    FLAMEBREAKER_HELMET(Material.CHAINMAIL_HELMET, FlamebreakerHelmet.class),
    FLAMEBREAKER_CHESTPLATE(Material.CHAINMAIL_CHESTPLATE, FlamebreakerChestplate.class),
    FLAMEBREAKER_LEGGINGS(Material.CHAINMAIL_LEGGINGS, FlamebreakerLeggings.class),
    FLAMEBREAKER_BOOTS(Material.CHAINMAIL_BOOTS, Flamebreakerboots.class),

    // Pack Armor
    PACK_HELMET(Material.LEATHER_HELMET, PackHelmet.class),
    PACK_CHESTPLATE(Material.LEATHER_CHESTPLATE, PackChestpate.class),
    PACK_LEGGINGS(Material.IRON_LEGGINGS, Packleggings.class),
    PACK_BOOTS(Material.IRON_BOOTS, PackBoots.class),

    // Emerald Armor
    EMERALD_HELMET(Material.LEATHER_HELMET, EmeraldHelmet.class),
    EMERALD_CHESTPLATE(Material.LEATHER_CHESTPLATE, EmeraldChestplate.class),
    EMERALD_LEGGINGS(Material.LEATHER_LEGGINGS, EmeraldLeggings.class),
    EMERALD_BOOTS(Material.LEATHER_BOOTS, EmeraldBoots.class),

    // Cheap Tuxedo
    CHEAP_TUXEDO_CHESTPLATE(Material.LEATHER_CHESTPLATE, CheapTuxedoChestplate.class),
    CHEAP_TUXEDO_LEGGINGS(Material.LEATHER_LEGGINGS, CheapTuxedoLeggings.class),
    CHEAP_TUXEDO_BOOTS(Material.LEATHER_BOOTS, CheapTuxedoBoots.class),

    // Elegant Tuxedo
    ELEGANT_TUXEDO_CHESTPLATE(Material.LEATHER_CHESTPLATE, ElegantTuxedoChestplate.class),
    ELEGANT_TUXEDO_LEGGINGS(Material.LEATHER_LEGGINGS, ElegantTuxedoLeggings.class),
    ELEGANT_TUXEDO_BOOTS(Material.LEATHER_BOOTS, ElegantTuxedoBoots.class),

    // Mastiff Armor
    MASTIFF_HELMET(Material.SKULL_ITEM, MastiffHelmet.class),
    MASTIFF_CHESTPLATE(Material.GOLD_CHESTPLATE, MastiffChestplate.class),
    MASTIFF_LEGGINGS(Material.DIAMOND_LEGGINGS, MastiffLeggings.class),
    MASTIFF_BOOTS(Material.DIAMOND_BOOTS, MastiffBoots.class),

    // Spooky Armor
    SPOOKY_HELMET(Material.SKULL_ITEM, SpookyHelmet.class),
    SPOOKY_CHESTPLATE(Material.LEATHER_CHESTPLATE, SpookyChestplate.class),
    SPOOKY_LEGGINGS(Material.LEATHER_LEGGINGS, SpookyLeggings.class),
    SPOOKY_BOOTS(Material.LEATHER_BOOTS, SpookyBoots.class),

    // Glacite Armor
    GLACITE_HELMET(Material.PACKED_ICE, GlaciteHelmet.class),
    GLACITE_CHESTPLATE(Material.LEATHER_CHESTPLATE, GlaciteChestplate.class),
    GLACITE_LEGGINGS(Material.LEATHER_LEGGINGS, GlaciteLeggings.class),
    GLACITE_BOOTS(Material.LEATHER_BOOTS, GlaciteBoots.class),

    // Shark Scale Armor
    SHARK_SCALE_HELMET(Material.SKULL_ITEM, SharkScaleHelmet.class),
    SHARK_SCALE_CHESTPLATE(Material.LEATHER_CHESTPLATE, SharkScaleChestplate.class),
    SHARK_SCALE_LEGGINGS(Material.LEATHER_LEGGINGS, SharkScaleleggings.class),
    SHARK_SCALE_BOOTS(Material.LEATHER_BOOTS, SharkScaleBoots.class),

    // BatPerson Armor
    BAT_PERSON_HELMET(Material.SKULL_ITEM, BatpersonHelmet.class),
    BAT_PERSON_CHESTPLATE(Material.LEATHER_CHESTPLATE, BatpersonChestplate.class),
    BAT_PERSON_LEGGINGS(Material.LEATHER_LEGGINGS, BatpersonLeggings.class),
    BAT_PERSON_BOOTS(Material.LEATHER_BOOTS, BatpersonBoots.class),

    // Werewolf Armor
    WEREWOLF_HELMET(Material.SKULL_ITEM, WerewolfHelmet.class),
    WEREWOLF_CHESTPLATE(Material.LEATHER_CHESTPLATE, WerewolfChestplate.class),
    WEREWOLF_LEGGINGS(Material.LEATHER_LEGGINGS, WerewolfLeggings.class),
    WEREWOLF_BOOTS(Material.LEATHER_BOOTS, WerewolfBoots.class),

    // Fancy Tuxedo Armor
    FANCY_TUXEDO_CHESTPLATE(Material.LEATHER_CHESTPLATE, FancyTuxedoChestplate.class),
    FANCY_TUXEDO_LEGGINGS(Material.LEATHER_LEGGINGS, FancyTuxedoLeggings.class),
    FANCY_TUXEDO_BOOTS(Material.LEATHER_BOOTS, FancyTuxedoBoots.class),

    // Dragon Assets
    SUMMONING_EYE(Material.SKULL_ITEM, SummoningEye.class),
    SLEEPING_EYE(Material.SKULL_ITEM, SleepingEye.class),
    REMNANT_OF_THE_EYE(Material.SKULL_ITEM, RemnantOfTheEye.class),
    SUMMONING_FRAME(Material.ENDER_PORTAL_FRAME, SummoningFrame.class),
    // Unspecific Armor
    OBSIDIAN_CHESTPLATE(Material.LEATHER_CHESTPLATE, ObsidianChestplate.class),
    SPIDERS_BOOTS(Material.IRON_BOOTS, SpidersBoots.class),
    BIG_BOUNCE_BOOTS(Material.LEATHER_BOOTS, BigBounceBoots.class),
    // Wise Dragon Armor
    WISE_DRAGON_HELMET(Material.SKULL_ITEM, WiseDragonHelmet.class),
    WISE_DRAGON_CHESTPLATE(Material.LEATHER_CHESTPLATE, WiseDragonChestplate.class),
    WISE_DRAGON_LEGGINGS(Material.LEATHER_LEGGINGS, WiseDragonLeggings.class),
    WISE_DRAGON_BOOTS(Material.LEATHER_BOOTS, WiseDragonBoots.class),
    WISE_DRAGON_FRAGMENT(Material.SKULL_ITEM, WiseDragonFragment.class),
    // Young Dragon Armor
    YOUNG_DRAGON_HELMET(Material.SKULL_ITEM, YoungDragonHelmet.class),
    YOUNG_DRAGON_CHESTPLATE(Material.LEATHER_CHESTPLATE, YoungDragonChestplate.class),
    YOUNG_DRAGON_LEGGINGS(Material.LEATHER_LEGGINGS, YoungDragonLeggings.class),
    YOUNG_DRAGON_BOOTS(Material.LEATHER_BOOTS, YoungDragonBoots.class),
    YOUNG_DRAGON_FRAGMENT(Material.SKULL_ITEM, YoungDragonFragment.class),
    // Superior Dragon Armor
    SUPERIOR_DRAGON_HELMET(Material.SKULL_ITEM, SuperiorDragonHelmet.class),
    SUPERIOR_DRAGON_CHESTPLATE(Material.LEATHER_CHESTPLATE, SuperiorDragonChestplate.class),
    SUPERIOR_DRAGON_LEGGINGS(Material.LEATHER_LEGGINGS, SuperiorDragonLeggings.class),
    SUPERIOR_DRAGON_BOOTS(Material.LEATHER_BOOTS, SuperiorDragonBoots.class),
    SUPERIOR_DRAGON_FRAGMENT(Material.SKULL_ITEM, SuperiorDragonFragment.class),
    // Unstable Dragon Armor
    UNSTABLE_DRAGON_HELMET(Material.SKULL_ITEM, UnstableDragonHelmet.class),
    UNSTABLE_DRAGON_CHESTPLATE(Material.LEATHER_CHESTPLATE, UnstableDragonChestplate.class),
    UNSTABLE_DRAGON_LEGGINGS(Material.LEATHER_LEGGINGS, UnstableDragonLeggings.class),
    UNSTABLE_DRAGON_BOOTS(Material.LEATHER_BOOTS, UnstableDragonBoots.class),
    UNSTABLE_DRAGON_FRAGMENT(Material.SKULL_ITEM, UnstableDragonFragment.class),
    // Strong Dragon Armor
    STRONG_DRAGON_HELMET(Material.SKULL_ITEM, StrongDragonHelmet.class),
    STRONG_DRAGON_CHESTPLATE(Material.LEATHER_CHESTPLATE, StrongDragonChestplate.class),
    STRONG_DRAGON_LEGGINGS(Material.LEATHER_LEGGINGS, StrongDragonLeggings.class),
    STRONG_DRAGON_BOOTS(Material.LEATHER_BOOTS, StrongDragonBoots.class),
    STRONG_DRAGON_FRAGMENT(Material.SKULL_ITEM, StrongDragonFragment.class),
    // Old Dragon Armor
    OLD_DRAGON_HELMET(Material.SKULL_ITEM, OldDragonHelmet.class),
    OLD_DRAGON_CHESTPLATE(Material.LEATHER_CHESTPLATE, OldDragonChestplate.class),
    OLD_DRAGON_LEGGINGS(Material.LEATHER_LEGGINGS, OldDragonLeggings.class),
    OLD_DRAGON_BOOTS(Material.LEATHER_BOOTS, OldDragonBoots.class),
    OLD_DRAGON_FRAGMENT(Material.SKULL_ITEM, OldDragonFragment.class),
    // Protector Dragon Armor
    PROTECTOR_DRAGON_HELMET(Material.SKULL_ITEM, ProtectorDragonHelmet.class),
    PROTECTOR_DRAGON_CHESTPLATE(Material.LEATHER_CHESTPLATE, ProtectorDragonChestplate.class),
    PROTECTOR_DRAGON_LEGGINGS(Material.LEATHER_LEGGINGS, ProtectorDragonLeggings.class),
    PROTECTOR_DRAGON_BOOTS(Material.LEATHER_BOOTS, ProtectorDragonBoots.class),
    PROTECTOR_DRAGON_FRAGMENT(Material.SKULL_ITEM, ProtectorDragonFragment.class),
    //Shadow Assassin Armor
    SHADOW_ASSASSIN_HELMET(Material.SKULL_ITEM, ShadowAssassinHelmet.class),
    SHADOW_ASSASSIN_CHESTPLATE(Material.LEATHER_CHESTPLATE, ShadowAssassinChestplate.class),
    SHADOW_ASSASSIN_LEGGINGS(Material.LEATHER_LEGGINGS, ShadowAssassinLeggings.class),
    SHADOW_ASSASSIN_BOOTS(Material.LEATHER_BOOTS, ShadowAssassinBoots.class),
    // Ender Armor
    ENDER_ARMOR_HELMET(Material.SKULL_ITEM, EnderArmorHelmet.class),
    ENDER_ARMOR_CHESTPLATE(Material.CHAINMAIL_CHESTPLATE, EnderArmorChestplate.class),
    ENDER_ARMOR_LEGGINGS(Material.CHAINMAIL_LEGGINGS, EnderArmorLeggings.class),
    ENDER_ARMOR_BOOTS(Material.CHAINMAIL_BOOTS, EnderArmorBoots.class),

    // Lapis Armor
    LAPIS_ARMOR_HELMET(Material.SEA_LANTERN, LapisArmorHelmet.class),
    LAPIS_ARMOR_CHESTPLATE(Material.LEATHER_CHESTPLATE, LapisArmorChestplate.class),
    LAPIS_ARMOR_LEGGINGS(Material.LEATHER_LEGGINGS, LapisArmorLeggings.class),
    LAPIS_ARMOR_BOOTS(Material.LEATHER_BOOTS, LapisArmorBoots.class),
    // Pumpkin Armor
    PUMPKIN_ARMOR_HELMET(Material.LEATHER_HELMET, PumpkinArmorHelmet.class),
    PUMPKIN_ARMOR_CHESTPLATE(Material.LEATHER_CHESTPLATE, PumpkinArmorChestplate.class),
    PUMPKIN_ARMOR_LEGGINGS(Material.LEATHER_LEGGINGS, PumpkinArmorLeggings.class),
    PUMPKIN_ARMOR_BOOTS(Material.LEATHER_BOOTS, PumpkinArmorBoots.class),
    // Farm Suit
    FARM_SUIT_HELMET(Material.LEATHER_HELMET, FarmSuitHelmet.class),
    FARM_SUIT_CHESTPLATE(Material.LEATHER_CHESTPLATE, FarmSuitChestplate.class),
    FARM_SUIT_LEGGINGS(Material.LEATHER_LEGGINGS, FarmSuitLeggings.class),
    FARM_SUIT_BOOTS(Material.LEATHER_BOOTS, FarmSuitBoots.class),
    // Mushroom Armor
    MUSHROOM_HELMET(Material.LEATHER_HELMET, MushroomHelmet.class),
    MUSHROOM_CHESTPLATE(Material.LEATHER_CHESTPLATE, MushroomChestplate.class),
    MUSHROOM_LEGGINGS(Material.LEATHER_LEGGINGS, MushroomLeggings.class),
    MUSHROOM_BOOTS(Material.LEATHER_BOOTS, MushroomBoots.class),
    // Angler Armor
    ANGLER_HELMET(Material.DIAMOND_HELMET, AnglerHelmet.class),
    ANGLER_CHESTPLATE(Material.LEATHER_CHESTPLATE, AnglerChestplate.class),
    ANGLER_LEGGINGS(Material.LEATHER_LEGGINGS, AnglerLeggings.class),
    ANGLER_BOOTS(Material.LEATHER_BOOTS, AnglerBoots.class),
    // Leaflet Armor
    LEAFLET_HELMET(Material.LEAVES, LeafletHelmet.class),
    LEAFLET_CHESTPLATE(Material.LEATHER_CHESTPLATE, LeafletChestplate.class),
    LEAFLET_LEGGINGS(Material.LEATHER_LEGGINGS, LeafletLeggings.class),
    LEAFLET_BOOTS(Material.LEATHER_BOOTS, LeafletBoots.class),


    // Miner Armor
    MINER_HELMET(Material.DIAMOND_HELMET, MinerHelmet.class),
    MINER_CHESTPLATE(Material.DIAMOND_CHESTPLATE, MinerChestplate.class),
    MINER_LEGGINGS(Material.DIAMOND_LEGGINGS, MinerLeggings.class),
    MINER_BOOTS(Material.DIAMOND_BOOTS, MinerBoots.class),
    // Hardened Diamond Armor
    HARDENED_DIAMOND_HELMET(Material.DIAMOND_HELMET, HardenedDiamondHelmet.class),
    HARDENED_DIAMOND_CHESTPLATE(Material.DIAMOND_CHESTPLATE, HardenedDiamondChestplate.class),
    HARDENED_DIAMOND_LEGGINGS(Material.DIAMOND_LEGGINGS, HardenedDiamondLeggings.class),
    HARDENED_DIAMOND_BOOTS(Material.DIAMOND_BOOTS, HardenedDiamondBoots.class),
    // Accessories
    SUPERSPEED_TALISMAN(Material.SKULL_ITEM, SuperspeedTalisman.class),
    ZOMBIE_TALISMAN(Material.SKULL_ITEM, ZombieTalisman.class),
    SKELETON_TALISMAN(Material.SKULL_ITEM, SkeletonTalisman.class),
    VILLAGE_AFFINITY_TALISMAN(Material.SKULL_ITEM, VillageAffinity.class),
    MINE_AFFINITY_TALISMAN(Material.SKULL_ITEM, MineAffinity.class),
    Intimidation_Talisman(Material.SKULL_ITEM, IntimidationTalisman.class),
    Scavenger_Talisman(Material.SKULL_ITEM, ScavengerTalisman.class),
    BLANK_TALISMAN(Material.SKULL_ITEM, BlankTalisman.class),
    AUTO_RECOMBOBULATOR(Material.SKULL_ITEM, AutoRecombobulator.class),
    PERFECT_TALISMAN(Material.SKULL_ITEM, PerfectTalisman.class),
    INFINITE_CRIT_TALISMAN(Material.SKULL_ITEM, InfiniteCritTalisman.class),
    PIGGY_BANK(Material.SKULL_ITEM, PiggyBank.class),
    CRACKED_PIGGY_BANK(Material.SKULL_ITEM, CrackedPiggyBank.class),
    BROKEN_PIGGY_BANK(Material.SKULL_ITEM, BrokenPiggyBank.class),
    TARANTULA_TALISMAN(Material.SKULL_ITEM, TarantulaTalisman.class),
    FARMING_TALISMAN(Material.SKULL_ITEM, FarmingTalisman.class),
    SPEED_TALISMAN(Material.SKULL_ITEM, SpeedTalisman.class),
    SPEED_RING(Material.SKULL_ITEM, SpeedRing.class),
    SPEED_ARTIFACT(Material.SKULL_ITEM, SpeedArtifact.class),
    WOOD_AFFINITY_TALISMAN(Material.SKULL_ITEM, WoodAffinityTalisman.class),

    //
    FAIRY_SOUL(Material.SKULL_ITEM,FairySoul.class),

    // Minions Upgrade
    COMPACTOR(Material.DROPPER, Compactor.class),
    SUPER_COMPACTOR_3000(Material.DROPPER, SuperCompactor3000.class),

    // Enchanted Items
    ENCHANTED_BREAD(Material.BREAD, EnchantedBread.class),
    ENCHANTED_HAY_BALE(Material.HAY_BLOCK, EnchantedHayBale.class),
    ENCHANTED_WHEAT_SEED(Material.SEEDS, EnchantedSeed.class),
    ENCHANTED_CARROT(Material.CARROT_ITEM, EnchantedCarrot.class),
    ENCHANTED_CARROT_ON_A_STICK(Material.CARROT_STICK, EnchantedCarrotOnStick.class),
    ENCHANTED_GOLDEN_CARROT(Material.GOLDEN_CARROT, EncahntedGoldenCarrot.class),
    ENCHANTED_POTATO(Material.POTATO_ITEM, EnchantedPotato.class),
    ENCHANTED_BAKED_POTATO(Material.BAKED_POTATO, EnchantedBakedPotato.class),
    ENCHANTED_PUMPKIN(Material.PUMPKIN, EnchantedPumpkin.class),
    ENCHANTED_MELON(Material.MELON, EncahntedMelon.class),
    ENCHANTED_GLISTERING_MELON(Material.SPECKLED_MELON, EnchantedGlisteringMelon.class),
    ENCHANTED_MELON_BLOCK(Material.MELON_BLOCK, EnchantedMelonBlock.class),
    ENCHANTED_RED_MUSHROOM(Material.RED_MUSHROOM, EnchantedRedMushroom.class),
    ENCHANTED_RED_MUSHROOM_BLOCK(Material.HUGE_MUSHROOM_2, EnchantedRedMushroomBlock.class),
    ENCHANTED_BROWN_MUSHROOM(Material.BROWN_MUSHROOM, EnchantedBrownMushroom.class),
    ENCHANTED_BROWN_MUSHROOM_BLOCK(Material.HUGE_MUSHROOM_1, EnchantedBronwMushroomBlock.class),
    ENCHANTED_COCOA_BEANS(Material.COCOA, EnchantedCocoaBean.class),
    ENCHANTED_COOKIE(Material.COOKIE, EnchantedCookie.class),
    ENCHANTED_CACTUS(Material.CACTUS, EnchantedCactus.class),
    ENCHANTED_SUGAR(Material.SUGAR, EnchantedSugar.class),
    ENCHANTED_PAPER(Material.PAPER, EnchantedPaper.class),
    ENCHANTED_SUGARCANE(Material.SUGAR_CANE, EnchantedSugarCane.class),
    ENCHANTED_LEATHER(Material.LEATHER, EnchantedLeather.class),
    ENCHANTED_RAW_BEEF(Material.RAW_BEEF, EnchantedRawBeef.class),
    ENCHANTED_RAW_PORK(Material.PORK, EnchantedRawPork.class),
    ENCHANTED_GRILLED_PORK(Material.GRILLED_PORK, EnchantedGrilledPork.class),
    ENCHANTED_RAW_CHICKEN(Material.RAW_CHICKEN,EnchantedRawChicken.class),
    ENCHANTED_CAKE(Material.CAKE, EnchantedCake.class),
    ENCHANTED_FEATHER(Material.FEATHER, EnchantedFeather.class),
    ENCHANTED_MUTTON(Material.MUTTON, EnchantedMutton.class),
    ENCHANTED_COOKED_MUTTON(Material.COOKED_MUTTON, EnchantedCookedMutton.class),
    ENCHANTED_RAW_RABBIT(Material.RABBIT, EnchantedRawRabbit.class),
    ENCHANTED_RABBIT_HIDE(Material.RABBIT_HIDE, EnchantedRabbitHide.class),
    ENCHANTED_RABBIT_FOOT(Material.RABBIT_FOOT, EnchantedRabbitFoot.class),
    ENCHANTED_NETHER_WART(Material.NETHER_STALK, EnchantedNetherWart.class),
    ENCHANTED_COBBLESTONE(Material.COBBLESTONE, EnchantedCobblestone.class),
    ENCHANTED_COAL(Material.COAL, EnchantedCoal.class),
    ENCHANTED_COAL_BLOCK(Material.COAL_BLOCK, EnchantedCoalBlock.class),
    ENCHANTED_CHARCOAL(Material.COAL, EnchantedCharcoal.class, (short) 1),
    ENCHANTED_IRON(Material.IRON_INGOT, EnchantedIron.class),
    ENCHANTED_IRON_BLOCK(Material.IRON_BLOCK, EnchantedIronBlock.class),
    ENCHANTED_GOLD(Material.GOLD_INGOT, EnchantedGold.class),
    ENCHANTED_GOLD_BLOCK(Material.GOLD_BLOCK, EnchantedGoldBlock.class),
    ENCHANTED_DIAMOND(Material.DIAMOND, EnchantedDiamond.class),
    ENCHANTED_DIAMOND_BLOCK(Material.DIAMOND_BLOCK, EnchantedDiamondBlock.class),
    ENCHANTED_LAPIS_LAZULI(Material.INK_SACK, EnchantedLapis.class, (short)4 ),
    ENCHANTED_LAPIS_LAZULI_BLOCK(Material.LAPIS_BLOCK, EnchantedLapisBlock.class),
    ENCHANTED_EMERALD(Material.EMERALD, EnchantedEmerald.class),
    ENCHANTED_EMERALD_BLOCK(Material.EMERALD_BLOCK, EnchantedEmeraldBlock.class),
    ENCHANTED_REDSTONE(Material.REDSTONE, EnchantedRedstone.class),
    ENCHANTED_REDSTONE_BLOCK(Material.REDSTONE_BLOCK, EnchantedRedstoneBlock.class),
    ENCHANTED_QUARTZ(Material.QUARTZ, EnchantedQuartz.class),
    ENCHANTED_QUARTZ_BLOCK(Material.QUARTZ_BLOCK, EnchantedQuartzBlock.class),
    ENCHANTED_OBSIDIAN(Material.OBSIDIAN, EnchantedObsidian.class),
    ENCHANTED_GLOWSTONE_DUST(Material.GLOWSTONE_DUST, EnchantedGlowstoneDust.class),
    ENCHANTED_GLOWSTONE(Material.GLOWSTONE, EnchantedGlowstone.class),
    ENCHANTED_REDSTONE_LAMP(Material.REDSTONE_LAMP_OFF, EnchantedRedstoneLamp.class),
    ENCHANTED_FLINT(Material.FLINT, EnchantedFlint.class),
    ENCHANTED_ICE(Material.ICE, EnchantedIce.class),
    ENCHANTED_PACKED_ICE(Material.PACKED_ICE, EnchantedPackedIce.class),
    ENCHANTED_NETHERRACK(Material.NETHERRACK, EnchantedNetherrack.class),
    ENCHANTED_SAND(Material.SAND, EnchantedSand.class),
    ENCHANTED_RED_SAND(Material.SAND, EnchantedRedSand.class, (short) 1),
    ENCHANTED_END_STONE(Material.ENDER_STONE, EnchantedEndStone.class),
    ENCHANTED_SNOW_BLOCK(Material.SNOW_BLOCK, EnchantedSnowBlock.class),
    ENCHANTED_MYCELIUM(Material.MYCEL, EnchantedMyceliun.class),
    ENCHANTED_ROTTEN_FLESH(Material.ROTTEN_FLESH, EnchantedRottenFlesh.class),
    ENCHANTED_ENDER_PEARL(Material.ENDER_PEARL, EnchantedEnderPearl.class),
    ENCHANTED_BONE(Material.BONE, EnchantedBone.class),
    ENCHANTED_BONE_MEAL(Material.INK_SACK, EnchantedBoneMeal.class, (short) 15),
    ENCHANTED_STRING(Material.STRING, EnchantedString.class),
    ENCHANTED_SPIDER_EYE(Material.SPIDER_EYE,EnchantedSpiderEye.class),
    ENCHANTED_FERMENTED_SPIDER_EYE(Material.FERMENTED_SPIDER_EYE, EnchantedFermentedEye.class),
    ENCHANTED_GUNPOWDER(Material.SULPHUR, EnchantedGunpowder.class),
    ENCHANTED_FIREWORK_ROCKET(Material.FIREWORK, EnchantedFireworkRocket.class),
    ENCHANTED_EYE_OF_ENDER(Material.EYE_OF_ENDER, EnchantedEyeOfEnder.class),
    ENCHANTED_GHAST_TEAR(Material.GHAST_TEAR, EnchantedGhastTear.class),
    ENCHANTED_SLIMEBALL(Material.SLIME_BALL, EnchantedSlimeball.class),
    ENCHANTED_SLIME_BLOCK(Material.SLIME_BLOCK, EnchantedSlimeBlock.class),
    ENCHANTED_MAGMA_CREAM(Material.MAGMA_CREAM, EnchantedMagmaCream.class),
    ENCHANTED_BLAZE_POWDER(Material.BLAZE_POWDER, EnchantedBlazePowder.class),
    ENCHANTED_BLAZE_ROD(Material.BLAZE_ROD, EnchantedBlazeRod.class),
    ENCHANTED_OAK_WOOD(Material.LOG, EnchantedOakWood.class),
    ENCHANTED_SPRUCE_WOOD(Material.LOG, EnchantedSpruceWood.class, (short) 1),
    ENCHANTED_BIRCH_WOOD(Material.LOG, EnchantedBirchWood.class, (short) 2),
    ENCHANTED_JUNGLE_WOOD(Material.LOG, EnchantedJungleWood.class, (short) 3),
    ENCHANTED_ACACIA_WOOD(Material.LOG_2, EnchantedAcaciaWood.class),
    ENCHANTED_DARK_OAK_WOOD(Material.LOG_2, EnchantedDarkOakWood.class, (short) 1),

    // Bows
    END_STONE_BOW(Material.BOW, EndStoneBow.class),
    MOSQUITO_BOW(Material.BOW, MosquitoBow.class),
    HURRICANE_BOW(Material.BOW, HurricaneBow.class),
    ARTISANAL_SHORTBOW(Material.BOW, ArtisanalShortbow.class),

    RUNAAN_BOW(Material.BOW, RunaanBow.class),

    // Special
    WHITE_GIFT(Material.SKULL_ITEM, WhiteGift.class),
    EXTERMINATOR(Material.IRON_SWORD, Exterminator.class),
    TEST_ITEM(Material.SKULL_ITEM, TestItem.class),
    BAG_OF_COINS(Material.SKULL_ITEM, BagOfCoins.class),
    SKYBLOCK_MENU(Material.NETHER_STAR, SkyBlockMenu.class),
    QUIVER_ARROW(Material.ARROW, QuiverArrow.class),
    GRAPPLING_HOOK(Material.FISHING_ROD, GrapplingHook.class),
    LAUNCHER(Material.SLIME_BLOCK, Launcher.class),
    TELEPORTER_LAUNCHER(Material.SLIME_BLOCK, TeleporterLauncher.class),
    BOUNCER(Material.SLIME_BLOCK, Bouncer.class),
    WATER_BOTTLE(Material.POTION, WaterBottle.class),
    MADDOX_BATPHONE(Material.SKULL_ITEM, MaddoxBatphone.class),
    // Entity Drops
    CRYSTAL_FRAGMENT(Material.QUARTZ, CrystalFragment.class),
    GOLDEN_POWDER(Material.GLOWSTONE_DUST, GoldenPowder.class),
    WEAK_WOLF_CATALYST(Material.BONE, WeakWolfCatalyst.class),
    // Entity Items
    REVENANT_HORROR_HEAD(Material.SKULL_ITEM, RevenantHorrorHead.class),
    BONZO_MASK(Material.SKULL_ITEM, BonzoMask.class),
    // Power Orbs
    RADIANT_POWER_ORB(Material.SKULL_ITEM, RadiantPowerOrb.class),
    MANA_FLUX_POWER_ORB(Material.SKULL_ITEM, ManaFluxPowerOrb.class),
    OVERFLUX_POWER_ORB(Material.SKULL_ITEM, OverfluxPowerOrb.class),
    PLASMAFLUX_POWER_ORB(Material.SKULL_ITEM, PlasmafluxPowerOrb.class),
    // Floating Crystal Items
    WHEAT_CRYSTAL(Material.SKULL_ITEM, WheatCrystal.class),
    // Enchanting & Reforging
    ENCHANTED_BOOK(Material.ENCHANTED_BOOK, EnchantedBook.class, true),
    RECOMBOBULATOR_3000(Material.SKULL_ITEM, Recombobulator3000.class),

    // Storage
    SMALL_BACKPACK(Material.SKULL_ITEM, SmallBackpack.class),
    MEDIUM_BACKPACK(Material.SKULL_ITEM, MediumBackpack.class),
    LARGE_BACKPACK(Material.SKULL_ITEM, LargeBackpack.class),
    GREATER_BACKPACK(Material.SKULL_ITEM, GreaterBackpack.class),
    JUMBO_BACKPACK(Material.SKULL_ITEM, JumboBackpack.class),
    // Revenant Horror
    REVENANT_FLESH(Material.ROTTEN_FLESH, RevenantFlesh.class),
    FOUL_FLESH(Material.COAL, FoulFlesh.class, (short) 1),
    UNDEAD_CATALYST(Material.SKULL_ITEM, UndeadCatalyst.class),
    BEHEADED_HORROR(Material.SKULL_ITEM, BeheadedHorror.class),
    REVENANT_CATALYST(Material.SKULL_ITEM, RevenantCatalyst.class),
    SCYTHE_BLADE(Material.DIAMOND, ScytheBlade.class),
    // Tarantula Broodfather
    TARANTULA_WEB(Material.STRING, TarantulaWeb.class),
    TOXIC_ARROW_POISON(Material.INK_SACK, ToxicArrowPoison.class, (short) 10),
    SPIDER_CATALYST(Material.SKULL_ITEM, SpiderCatalyst.class),
    FLY_SWATTER(Material.GOLD_SPADE, FlySwatter.class),
    DIGESTED_MOSQUITO(Material.ROTTEN_FLESH, DigestedMosquito.class),
    // Sven Packmaster
    WOLF_TOOTH(Material.GHAST_TEAR, WolfTooth.class),
    HAMSTER_WHEEL(Material.TRAP_DOOR, HamsterWheel.class),
    RED_CLAW_EGG(Material.MONSTER_EGG, RedClawEgg.class, (short) 96),
    OVERFLUX_CAPACITOR(Material.QUARTZ, OverfluxCapacitor.class),
    GRIZZLY_BAIT(Material.RAW_FISH, GrizzlyBait.class, (short) 1),
    // Runes
    PESTILENCE_RUNE(Material.SKULL_ITEM, PestilenceRune.class),
    SNAKE_RUNE(Material.SKULL_ITEM, SnakeRune.class),
    BITE_RUNE(Material.SKULL_ITEM, BiteRune.class),
    SPIRIT_RUNE(Material.SKULL_ITEM, SpiritRune.class),
    COUTURE_RUNE(Material.SKULL_ITEM, CoutureRune.class),
    // Pets
    ENDERMAN_PET(Material.SKULL_ITEM, EndermanPet.class),
    GUNGA_PET(Material.SKULL_ITEM, GungaPet.class),
    // Craft Materials
    AIR(Material.AIR),
    STONE(Material.STONE, Stone.class, true),
    GRASS_BLOCK(Material.GRASS),
    DIRT(Material.DIRT),
    COBBLESTONE(Material.COBBLESTONE, Cobblestone.class, true),
    OAK_WOOD_PLANKS(Material.WOOD),
    SAPLING(Material.SAPLING),
    BEDROCK(Material.BEDROCK, Bedrock.class, true),
    WATER(Material.WATER),
    STATIONARY_WATER(Material.STATIONARY_WATER),
    LAVA(Material.LAVA),
    STATIONARY_LAVA(Material.STATIONARY_LAVA),
    SAND(Material.SAND, Sand.class, true),
    GRAVEL(Material.GRAVEL, Gravel.class, true),
    GOLD_ORE(Material.GOLD_ORE, GoldOre.class, true),
    IRON_ORE(Material.IRON_ORE, IronOre.class, true),
    COAL_ORE(Material.COAL_ORE, CoalOre.class, true),
    OAK_WOOD(Material.LOG, OakWood.class, true),
    LEAVES(Material.LEAVES),
    SPONGE(Material.SPONGE),
    GLASS(Material.GLASS),
    LAPIS_LAZULI_ORE(Material.LAPIS_ORE, LapisLazuliOre.class, true),
    LAPIS_BLOCK(Material.LAPIS_BLOCK),
    DISPENSER(Material.DISPENSER),
    SANDSTONE(Material.SANDSTONE),
    NOTE_BLOCK(Material.NOTE_BLOCK),
    BED_BLOCK(Material.BED_BLOCK),
    POWERED_RAIL(Material.POWERED_RAIL),
    DETECTOR_RAIL(Material.DETECTOR_RAIL),
    PISTON_STICKY_BASE(Material.PISTON_STICKY_BASE),
    WEB(Material.WEB),
    LONG_GRASS(Material.LONG_GRASS),
    DEAD_BUSH(Material.DEAD_BUSH),
    PISTON_BASE(Material.PISTON_BASE),
    PISTON_EXTENSION(Material.PISTON_EXTENSION),
    WOOL(Material.WOOL),
    PISTON_MOVING_PIECE(Material.PISTON_MOVING_PIECE),
    YELLOW_FLOWER(Material.YELLOW_FLOWER),
    RED_ROSE(Material.RED_ROSE),
    BROWN_MUSHROOM(Material.BROWN_MUSHROOM, BrownMushroom.class, true),
    RED_MUSHROOM(Material.RED_MUSHROOM, RedMushroom.class, true),
    GOLD_BLOCK(Material.GOLD_BLOCK),
    IRON_BLOCK(Material.IRON_BLOCK),
    DOUBLE_STEP(Material.DOUBLE_STEP),
    STEP(Material.STEP),
    BRICK(Material.BRICK),
    TNT(Material.TNT),
    BOOKSHELF(Material.BOOKSHELF),
    MOSSY_COBBLESTONE(Material.MOSSY_COBBLESTONE),
    OBSIDIAN(Material.OBSIDIAN, Obsidian.class, true),
    TORCH(Material.TORCH),
    FIRE(Material.FIRE),
    MOB_SPAWNER(Material.MOB_SPAWNER),
    WOOD_STAIRS(Material.WOOD_STAIRS),
    CHEST(Material.CHEST),
    REDSTONE_WIRE(Material.REDSTONE_WIRE),
    DIAMOND_ORE(Material.DIAMOND_ORE, DiamondOre.class, true),
    DIAMOND_BLOCK(Material.DIAMOND_BLOCK, DiamondBlock.class, true),
    CRAFTING_TABLE(Material.WORKBENCH),
    WHEAT_SEEDS(Material.CROPS, WheatSeeds.class, true),
    SOIL(Material.SOIL),
    FURNACE(Material.FURNACE),
    BURNING_FURNACE(Material.BURNING_FURNACE),
    SIGN_POST(Material.SIGN_POST),
    WOODEN_DOOR(Material.WOODEN_DOOR),
    LADDER(Material.LADDER),
    RAILS(Material.RAILS),
    COBBLESTONE_STAIRS(Material.COBBLESTONE_STAIRS),
    WALL_SIGN(Material.WALL_SIGN),
    LEVER(Material.LEVER),
    STONE_PLATE(Material.STONE_PLATE),
    IRON_DOOR_BLOCK(Material.IRON_DOOR_BLOCK),
    WOOD_PLATE(Material.WOOD_PLATE),
    REDSTONE_ORE(Material.REDSTONE_ORE, RedstoneOre.class, true),
    GLOWING_REDSTONE_ORE(Material.GLOWING_REDSTONE_ORE),
    REDSTONE_TORCH_OFF(Material.REDSTONE_TORCH_OFF),
    REDSTONE_TORCH_ON(Material.REDSTONE_TORCH_ON),
    STONE_BUTTON(Material.STONE_BUTTON),
    SNOW(Material.SNOW),
    ICE(Material.ICE, Ice.class, true),
    SNOW_BLOCK(Material.SNOW_BLOCK),
    CACTUS(Material.CACTUS, Cactus.class, true),
    CLAY(Material.CLAY),
    SUGAR_CANE_BLOCK(Material.SUGAR_CANE_BLOCK, SugarCane.class, true),
    JUKEBOX(Material.JUKEBOX),
    FENCE(Material.FENCE),
    PUMPKIN(Material.PUMPKIN, Pumpkin.class, true),
    NETHERRACK(Material.NETHERRACK, Netherrack.class, true),
    SOUL_SAND(Material.SOUL_SAND),
    GLOWSTONE(Material.GLOWSTONE, Glowstone.class, true),
    PORTAL(Material.PORTAL),
    JACK_O_LANTERN(Material.JACK_O_LANTERN),
    CAKE_BLOCK(Material.CAKE_BLOCK),
    DIODE_BLOCK_OFF(Material.DIODE_BLOCK_OFF),
    DIODE_BLOCK_ON(Material.DIODE_BLOCK_ON),
    STAINED_GLASS(Material.STAINED_GLASS),
    TRAP_DOOR(Material.TRAP_DOOR),
    MONSTER_EGGS(Material.MONSTER_EGGS),
    SMOOTH_BRICK(Material.SMOOTH_BRICK),
    HUGE_MUSHROOM_1(Material.HUGE_MUSHROOM_1),
    HUGE_MUSHROOM_2(Material.HUGE_MUSHROOM_2),
    IRON_FENCE(Material.IRON_FENCE),
    THIN_GLASS(Material.THIN_GLASS),
    MELON_BLOCK(Material.MELON_BLOCK, Melon.class, true),
    PUMPKIN_STEM(Material.PUMPKIN_STEM),
    MELON_STEM(Material.MELON_STEM),
    VINE(Material.VINE),
    FENCE_GATE(Material.FENCE_GATE),
    BRICK_STAIRS(Material.BRICK_STAIRS),
    SMOOTH_STAIRS(Material.SMOOTH_STAIRS),
    MYCEL(Material.MYCEL),
    WATER_LILY(Material.WATER_LILY),
    NETHER_BRICK(Material.NETHER_BRICK),
    NETHER_FENCE(Material.NETHER_FENCE),
    NETHER_BRICK_STAIRS(Material.NETHER_BRICK_STAIRS),
    NETHER_WARTS(Material.NETHER_STALK),
    ENCHANTMENT_TABLE(Material.ENCHANTMENT_TABLE),
    BREWING_STAND(Material.BREWING_STAND),
    CAULDRON(Material.CAULDRON),
    END_PORTAL(Material.ENDER_PORTAL),
    END_PORTAL_FRAME(Material.ENDER_PORTAL_FRAME),
    END_STONE(Material.ENDER_STONE, EndStone.class, true),
    DRAGON_EGG(Material.DRAGON_EGG),
    REDSTONE_LAMP_OFF(Material.REDSTONE_LAMP_OFF),
    REDSTONE_LAMP_ON(Material.REDSTONE_LAMP_ON),
    WOOD_DOUBLE_STEP(Material.WOOD_DOUBLE_STEP),
    WOOD_STEP(Material.WOOD_STEP),
    COCOA(Material.COCOA, CocoaBeans.class, true),
    SANDSTONE_STAIRS(Material.SANDSTONE_STAIRS),
    EMERALD_ORE(Material.EMERALD_ORE, EmeraldOre.class, true),
    ENDER_CHEST(Material.ENDER_CHEST),
    TRIPWIRE_HOOK(Material.TRIPWIRE_HOOK),
    TRIPWIRE(Material.TRIPWIRE),
    EMERALD_BLOCK(Material.EMERALD_BLOCK),
    SPRUCE_WOOD_STAIRS(Material.SPRUCE_WOOD_STAIRS),
    BIRCH_WOOD_STAIRS(Material.BIRCH_WOOD_STAIRS),
    JUNGLE_WOOD_STAIRS(Material.JUNGLE_WOOD_STAIRS),
    COMMAND(Material.COMMAND),
    BEACON(Material.BEACON),
    COBBLE_WALL(Material.COBBLE_WALL),
    FLOWER_POT(Material.FLOWER_POT),
    CARROT(Material.CARROT, Carrot.class, true),
    POTATO(Material.POTATO, Potato.class, true),
    WOOD_BUTTON(Material.WOOD_BUTTON),
    SKULL(Material.SKULL),
    ANVIL(Material.ANVIL),
    TRAPPED_CHEST(Material.TRAPPED_CHEST),
    GOLD_PLATE(Material.GOLD_PLATE),
    IRON_PLATE(Material.IRON_PLATE),
    REDSTONE_COMPARATOR_OFF(Material.REDSTONE_COMPARATOR_OFF),
    REDSTONE_COMPARATOR_ON(Material.REDSTONE_COMPARATOR_ON),
    DAYLIGHT_DETECTOR(Material.DAYLIGHT_DETECTOR),
    REDSTONE_BLOCK(Material.REDSTONE_BLOCK),
    NETHER_QUARTZ_ORE(Material.QUARTZ_ORE, NetherQuartzOre.class, true),
    HOPPER(Material.HOPPER),
    QUARTZ_BLOCK(Material.QUARTZ_BLOCK),
    QUARTZ_STAIRS(Material.QUARTZ_STAIRS),
    ACTIVATOR_RAIL(Material.ACTIVATOR_RAIL),
    DROPPER(Material.DROPPER),
    STAINED_CLAY(Material.STAINED_CLAY),
    STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE),
    LEAVES_2(Material.LEAVES_2),
    ACACIA_WOOD(Material.LOG_2, AcaciaWood.class, true),
    ACACIA_STAIRS(Material.ACACIA_STAIRS),
    DARK_OAK_STAIRS(Material.DARK_OAK_STAIRS),
    SLIME_BLOCK(Material.SLIME_BLOCK),
    BARRIER(Material.BARRIER),
    IRON_TRAPDOOR(Material.IRON_TRAPDOOR),
    PRISMARINE(Material.PRISMARINE),
    SEA_LANTERN(Material.SEA_LANTERN),
    HAY_BLOCK(Material.HAY_BLOCK),
    CARPET(Material.CARPET),
    HARD_CLAY(Material.HARD_CLAY),
    COAL_BLOCK(Material.COAL_BLOCK),
    PACKED_ICE(Material.PACKED_ICE),
    DOUBLE_PLANT(Material.DOUBLE_PLANT),
    STANDING_BANNER(Material.STANDING_BANNER),
    WALL_BANNER(Material.WALL_BANNER),
    DAYLIGHT_DETECTOR_INVERTED(Material.DAYLIGHT_DETECTOR_INVERTED),
    RED_SANDSTONE(Material.RED_SANDSTONE),
    RED_SANDSTONE_STAIRS(Material.RED_SANDSTONE_STAIRS),
    DOUBLE_STONE_SLAB2(Material.DOUBLE_STONE_SLAB2),
    STONE_SLAB2(Material.STONE_SLAB2),
    SPRUCE_FENCE_GATE(Material.SPRUCE_FENCE_GATE),
    BIRCH_FENCE_GATE(Material.BIRCH_FENCE_GATE),
    JUNGLE_FENCE_GATE(Material.JUNGLE_FENCE_GATE),
    DARK_OAK_FENCE_GATE(Material.DARK_OAK_FENCE_GATE),
    ACACIA_FENCE_GATE(Material.ACACIA_FENCE_GATE),
    SPRUCE_FENCE(Material.SPRUCE_FENCE),
    BIRCH_FENCE(Material.BIRCH_FENCE),
    JUNGLE_FENCE(Material.JUNGLE_FENCE),
    DARK_OAK_FENCE(Material.DARK_OAK_FENCE),
    ACACIA_FENCE(Material.ACACIA_FENCE),
    SPRUCE_DOOR(Material.SPRUCE_DOOR),
    BIRCH_DOOR(Material.BIRCH_DOOR),
    JUNGLE_DOOR(Material.JUNGLE_DOOR),
    ACACIA_DOOR(Material.ACACIA_DOOR),
    DARK_OAK_DOOR(Material.DARK_OAK_DOOR),
    IRON_SHOVEL(Material.IRON_SPADE, IronShovel.class, true),
    IRON_PICKAXE(Material.IRON_PICKAXE, IronPickaxe.class, true),
    IRON_AXE(Material.IRON_AXE, IronAxe.class, true),
    ROOKIE_AXE(Material.STONE_AXE, RookieAxe.class),
    PROMISING_AXE(Material.IRON_AXE, PromisingAxe.class),
    FLINT_AND_STEEL(Material.FLINT_AND_STEEL),
    APPLE(Material.APPLE),
    BOW(Material.BOW, Bow.class, true),
    ARROW(Material.ARROW),
    COAL(Material.COAL, Coal.class),
    DIAMOND(Material.DIAMOND),
    IRON_INGOT(Material.IRON_INGOT),
    GOLD_INGOT(Material.GOLD_INGOT),
    IRON_SWORD(Material.IRON_SWORD, IronSword.class, true),
    WOOD_SWORD(Material.WOOD_SWORD, WoodenSword.class, true),
    WOOD_SHOVEL(Material.WOOD_SPADE, WoodenShovel.class, true),
    WOOD_PICKAXE(Material.WOOD_PICKAXE, WoodenPickaxe.class, true),
    WOOD_AXE(Material.WOOD_AXE, WoodenAxe.class, true),
    STONE_SWORD(Material.STONE_SWORD, StoneSword.class, true),
    STONE_SHOVEL(Material.STONE_SPADE, StoneShovel.class, true),
    STONE_PICKAXE(Material.STONE_PICKAXE, StonePickaxe.class, true),
    ROOKIE_PICKAXE(Material.STONE_PICKAXE, RookiePickaxe.class),
    PROMISING_PICKAXE(Material.IRON_PICKAXE, PromisingPickaxe.class),
    STONE_AXE(Material.STONE_AXE, StoneAxe.class, true),
    DIAMOND_SWORD(Material.DIAMOND_SWORD, DiamondSword.class, true),
    DIAMOND_SHOVEL(Material.DIAMOND_SPADE, DiamondShovel.class, true),
    DIAMOND_PICKAXE(Material.DIAMOND_PICKAXE, DiamondPickaxe.class, true),
    DIAMOND_AXE(Material.DIAMOND_AXE, DiamondAxe.class, true),
    STICK(Material.STICK),
    BOWL(Material.BOWL),
    MUSHROOM_SOUP(Material.MUSHROOM_SOUP),
    GOLD_SWORD(Material.GOLD_SWORD, GoldenSword.class, true),
    GOLD_SHOVEL(Material.GOLD_SPADE, GoldenShovel.class, true),
    GOLD_PICKAXE(Material.GOLD_PICKAXE, GoldenPickaxe.class, true),
    GOLD_AXE(Material.GOLD_AXE, GoldenAxe.class, true),
    STRING(Material.STRING),
    FEATHER(Material.FEATHER),
    GUNPOWDER(Material.SULPHUR),
    WOOD_HOE(Material.WOOD_HOE, WoodenHoe.class, true),
    STONE_HOE(Material.STONE_HOE, StoneHoe.class, true),
    IRON_HOE(Material.IRON_HOE, IronHoe.class, true),
    DIAMOND_HOE(Material.DIAMOND_HOE, DiamondHoe.class, true),
    GOLD_HOE(Material.GOLD_HOE, GoldenHoe.class, true),
    ROOKIE_HOE(Material.STONE_HOE, RookieHoe.class),
    SEEDS(Material.SEEDS),
    WHEAT(Material.WHEAT),
    BREAD(Material.BREAD),
    LEATHER_HELMET(Material.LEATHER_HELMET, LeatherHelmet.class, true),
    LEATHER_CHESTPLATE(Material.LEATHER_CHESTPLATE, LeatherChestplate.class, true),
    LEATHER_LEGGINGS(Material.LEATHER_LEGGINGS, LeatherLeggings.class, true),
    LEATHER_BOOTS(Material.LEATHER_BOOTS, LeatherBoots.class, true),
    CHAINMAIL_HELMET(Material.CHAINMAIL_HELMET, ChainmailHelmet.class, true),
    CHAINMAIL_CHESTPLATE(Material.CHAINMAIL_CHESTPLATE, ChainmailChestplate.class, true),
    CHAINMAIL_LEGGINGS(Material.CHAINMAIL_LEGGINGS, ChainmailLeggings.class, true),
    CHAINMAIL_BOOTS(Material.CHAINMAIL_BOOTS, ChainmailBoots.class, true),
    IRON_HELMET(Material.IRON_HELMET, IronHelmet.class, true),
    IRON_CHESTPLATE(Material.IRON_CHESTPLATE, IronChestplate.class, true),
    IRON_LEGGINGS(Material.IRON_LEGGINGS, IronLeggings.class, true),
    IRON_BOOTS(Material.IRON_BOOTS, IronBoots.class, true),
    DIAMOND_HELMET(Material.DIAMOND_HELMET, DiamondHelmet.class, true),
    DIAMOND_CHESTPLATE(Material.DIAMOND_CHESTPLATE, DiamondChestplate.class, true),
    DIAMOND_LEGGINGS(Material.DIAMOND_LEGGINGS, DiamondLeggings.class, true),
    DIAMOND_BOOTS(Material.DIAMOND_BOOTS, DiamondBoots.class, true),
    GOLDEN_HELMET(Material.GOLD_HELMET, GoldenHelmet.class, true),
    GOLDEN_CHESTPLATE(Material.GOLD_CHESTPLATE, GoldenChestplate.class, true),
    GOLDEN_LEGGINGS(Material.GOLD_LEGGINGS, GoldenLeggings.class, true),
    GOLDEN_BOOTS(Material.GOLD_BOOTS, GoldenBoots.class, true),
    FLINT(Material.FLINT),
    PORK(Material.PORK),
    GRILLED_PORK(Material.GRILLED_PORK),
    PAINTING(Material.PAINTING),
    GOLDEN_APPLE(Material.GOLDEN_APPLE),
    SIGN(Material.SIGN),
    WOOD_DOOR(Material.WOOD_DOOR),
    BUCKET(Material.BUCKET),
    WATER_BUCKET(Material.WATER_BUCKET),
    LAVA_BUCKET(Material.LAVA_BUCKET),
    MINECART(Material.MINECART),
    SADDLE(Material.SADDLE),
    IRON_DOOR(Material.IRON_DOOR),
    REDSTONE(Material.REDSTONE),
    SNOW_BALL(Material.SNOW_BALL),
    BOAT(Material.BOAT),
    LEATHER(Material.LEATHER),
    MILK_BUCKET(Material.MILK_BUCKET),
    CLAY_BRICK(Material.CLAY_BRICK),
    CLAY_BALL(Material.CLAY_BALL),
    SUGAR_CANE(Material.SUGAR_CANE),
    PAPER(Material.PAPER),
    BOOK(Material.BOOK),
    SLIME_BALL(Material.SLIME_BALL),
    STORAGE_MINECART(Material.STORAGE_MINECART),
    POWERED_MINECART(Material.POWERED_MINECART),
    EGG(Material.EGG),
    COMPASS(Material.COMPASS),
    FISHING_ROD(Material.FISHING_ROD),
    WATCH(Material.WATCH),
    GLOWSTONE_DUST(Material.GLOWSTONE_DUST),
    RAW_FISH(Material.RAW_FISH),
    COOKED_FISH(Material.COOKED_FISH),
    INK_SACK(Material.INK_SACK),
    BONE(Material.BONE),
    SUGAR(Material.SUGAR),
    CAKE(Material.CAKE),
    BED(Material.BED),
    DIODE(Material.DIODE),
    COOKIE(Material.COOKIE),
    MAP(Material.MAP),
    SHEARS(Material.SHEARS),
    MELON(Material.MELON),
    PUMPKIN_SEEDS(Material.PUMPKIN_SEEDS),
    MELON_SEEDS(Material.MELON_SEEDS),
    RAW_BEEF(Material.RAW_BEEF),
    COOKED_BEEF(Material.COOKED_BEEF),
    RAW_CHICKEN(Material.RAW_CHICKEN),
    COOKED_CHICKEN(Material.COOKED_CHICKEN),
    ROTTEN_FLESH(Material.ROTTEN_FLESH),
    ENDER_PEARL(Material.ENDER_PEARL),
    BLAZE_ROD(Material.BLAZE_ROD),
    GHAST_TEAR(Material.GHAST_TEAR),
    GOLD_NUGGET(Material.GOLD_NUGGET),
    NETHER_STALK(Material.NETHER_STALK),
    GLASS_BOTTLE(Material.GLASS_BOTTLE),
    SPIDER_EYE(Material.SPIDER_EYE),
    FERMENTED_SPIDER_EYE(Material.FERMENTED_SPIDER_EYE),
    BLAZE_POWDER(Material.BLAZE_POWDER),
    MAGMA_CREAM(Material.MAGMA_CREAM),
    BREWING_STAND_ITEM(Material.BREWING_STAND_ITEM),
    CAULDRON_ITEM(Material.CAULDRON_ITEM),
    EYE_OF_ENDER(Material.EYE_OF_ENDER),
    SPECKLED_MELON(Material.SPECKLED_MELON),
    MONSTER_EGG(Material.MONSTER_EGG),
    EXP_BOTTLE(Material.EXP_BOTTLE),
    FIREBALL(Material.FIREBALL),
    BOOK_AND_QUILL(Material.BOOK_AND_QUILL),
    WRITTEN_BOOK(Material.WRITTEN_BOOK),
    EMERALD(Material.EMERALD),
    ITEM_FRAME(Material.ITEM_FRAME),
    FLOWER_POT_ITEM(Material.FLOWER_POT_ITEM),
    CARROT_ITEM(Material.CARROT_ITEM),
    POTATO_ITEM(Material.POTATO_ITEM),
    BAKED_POTATO(Material.BAKED_POTATO),
    POISONOUS_POTATO(Material.POISONOUS_POTATO),
    EMPTY_MAP(Material.EMPTY_MAP),
    GOLDEN_CARROT(Material.GOLDEN_CARROT),
    SKULL_ITEM(Material.SKULL_ITEM),
    CARROT_STICK(Material.CARROT_STICK),
    NETHER_STAR(Material.NETHER_STAR),
    PUMPKIN_PIE(Material.PUMPKIN_PIE),
    FIREWORK(Material.FIREWORK),
    FIREWORK_CHARGE(Material.FIREWORK_CHARGE),
    REDSTONE_COMPARATOR(Material.REDSTONE_COMPARATOR),
    NETHER_BRICK_ITEM(Material.NETHER_BRICK_ITEM),
    QUARTZ(Material.QUARTZ),
    EXPLOSIVE_MINECART(Material.EXPLOSIVE_MINECART),
    HOPPER_MINECART(Material.HOPPER_MINECART),
    PRISMARINE_SHARD(Material.PRISMARINE_SHARD),
    PRISMARINE_CRYSTALS(Material.PRISMARINE_CRYSTALS),
    RABBIT(Material.RABBIT),
    COOKED_RABBIT(Material.COOKED_RABBIT),
    RABBIT_STEW(Material.RABBIT_STEW),
    RABBIT_FOOT(Material.RABBIT_FOOT),
    RABBIT_HIDE(Material.RABBIT_HIDE),
    ARMOR_STAND(Material.ARMOR_STAND),
    IRON_BARDING(Material.IRON_BARDING),
    GOLD_BARDING(Material.GOLD_BARDING),
    DIAMOND_BARDING(Material.DIAMOND_BARDING),
    LEASH(Material.LEASH),
    NAME_TAG(Material.NAME_TAG),
    COMMAND_MINECART(Material.COMMAND_MINECART),
    MUTTON(Material.MUTTON),
    COOKED_MUTTON(Material.COOKED_MUTTON),
    BANNER(Material.BANNER),
    SPRUCE_DOOR_ITEM(Material.SPRUCE_DOOR_ITEM),
    BIRCH_DOOR_ITEM(Material.BIRCH_DOOR_ITEM),
    JUNGLE_DOOR_ITEM(Material.JUNGLE_DOOR_ITEM),
    ACACIA_DOOR_ITEM(Material.ACACIA_DOOR_ITEM),
    DARK_OAK_DOOR_ITEM(Material.DARK_OAK_DOOR_ITEM),
    GOLD_RECORD(Material.GOLD_RECORD),
    GREEN_RECORD(Material.GREEN_RECORD),
    RECORD_3(Material.RECORD_3),
    RECORD_4(Material.RECORD_4),
    RECORD_5(Material.RECORD_5),
    RECORD_6(Material.RECORD_6),
    RECORD_7(Material.RECORD_7),
    RECORD_8(Material.RECORD_8),
    RECORD_9(Material.RECORD_9),
    RECORD_10(Material.RECORD_10),
    RECORD_11(Material.RECORD_11),
    RECORD_12(Material.RECORD_12),
    // Craft Material Variants
    SLIGHTLY_DAMAGED_ANVIL(Material.ANVIL, (short) 1, "Slightly Damaged Anvil"),
    VERY_DAMAGED_ANVIL(Material.ANVIL, (short) 2, "Very Damaged Anvil"),
    RED_BANNER(Material.BANNER, (short) 1, "Red Banner"),
    GREEN_BANNER(Material.BANNER, (short) 2, "Green Banner"),
    BROWN_BANNER(Material.BANNER, (short) 3, "Brown Banner"),
    BLUE_BANNER(Material.BANNER, (short) 4, "Blue Banner"),
    PURPLE_BANNER(Material.BANNER, (short) 5, "Purple Banner"),
    CYAN_BANNER(Material.BANNER, (short) 6, "Cyan Banner"),
    LIGHT_GRAY_BANNER(Material.BANNER, (short) 7, "Light Gray Banner"),
    GRAY_BANNER(Material.BANNER, (short) 8, "Gray Banner"),
    PINK_BANNER(Material.BANNER, (short) 9, "Pink Banner"),
    LIME_BANNER(Material.BANNER, (short) 10, "Lime Banner"),
    YELLOW_BANNER(Material.BANNER, (short) 11, "Yellow Banner"),
    LIGHT_BLUE_BANNER(Material.BANNER, (short) 12, "Light Blue Banner"),
    MAGENTA_BANNER(Material.BANNER, (short) 13, "Magenta Banner"),
    ORANGE_BANNER(Material.BANNER, (short) 14, "Orange Banner"),
    ORANGE_CARPET(Material.CARPET, (short) 1, "Orange Carpet"),
    MAGENTA_CARPET(Material.CARPET, (short) 2, "Magenta Carpet"),
    LIGHT_BLUE_CARPET(Material.CARPET, (short) 3, "Light Blue Carpet"),
    YELLOW_CARPET(Material.CARPET, (short) 4, "Yellow Carpet"),
    LIME_CARPET(Material.CARPET, (short) 5, "Lime Carpet"),
    PINK_CARPET(Material.CARPET, (short) 6, "Pink Carpet"),
    GRAY_CARPET(Material.CARPET, (short) 7, "Gray Carpet"),
    LIGHT_GRAY_CARPET(Material.CARPET, (short) 8, "Light Gray Carpet"),
    CYAN_CARPET(Material.CARPET, (short) 9, "Cyan Carpet"),
    PURPLE_CARPET(Material.CARPET, (short) 10, "Purple Carpet"),
    BLUE_CARPET(Material.CARPET, (short) 11, "Blue Carpet"),
    BROWN_CARPET(Material.CARPET, (short) 12, "Brown Carpet"),
    GREEN_CARPET(Material.CARPET, (short) 13, "Green Carpet"),
    RED_CARPET(Material.CARPET, (short) 14, "Red Carpet"),
    BLACK_CARPET(Material.CARPET, (short) 15, "Black Carpet"),
    CHARCOAL(Material.COAL, (short) 1, "Charcoal"),
    MOSSY_COBBLESTONE_WALL(Material.COBBLE_WALL, (short) 1, "Mossy Cobblestone Wall"),
    COOKED_SALMON(Material.COOKED_FISH, (short) 1, "Cooked Salmon"),
    COARSE_DIRT(Material.DIRT, (short) 1, "Coarse Dirt"),
    PODZOL(Material.DIRT, (short) 2, "Podzol"),
    GOLDEN_HORSE_ARMOR(Material.GOLD_BARDING, (short) 0, "Golden Horse Armor"),
    LILAC(Material.DOUBLE_PLANT, (short) 1, "Lilac"),
    DOUBLE_TALLGRASS(Material.DOUBLE_PLANT, (short) 2, "Double Tallgrass"),
    LARGE_FERN(Material.DOUBLE_PLANT, (short) 3, "Large Fern"),
    ROSE_BUSH(Material.DOUBLE_PLANT, (short) 4, "Rose Bush"),
    PEONY(Material.DOUBLE_PLANT, (short) 5, "Peony"),
    RED_DYE(Material.INK_SACK, (short) 1, "Red Dye"),
    GREEN_DYE(Material.INK_SACK, (short) 2, "Green Dye"),
    COCOA_BEANS(Material.INK_SACK, (short) 3, "Cocoa Beans"),
    LAPIS_LAZULI(Material.INK_SACK, (short) 4, "Lapis Lazuli"),
    PURPLE_DYE(Material.INK_SACK, (short) 5, "Purple Dye"),
    CYAN_DYE(Material.INK_SACK, (short) 6, "Cyan Dye"),
    LIGHT_GRAY_DYE(Material.INK_SACK, (short) 7, "Light Gray Dye"),
    GRAY_DYE(Material.INK_SACK, (short) 8, "Gray Dye"),
    PINK_DYE(Material.INK_SACK, (short) 9, "Pink Dye"),
    LIME_DYE(Material.INK_SACK, (short) 10, "Lime Dye"),
    YELLOW_DYE(Material.INK_SACK, (short) 11, "Yellow Dye"),
    LIGHT_BLUE_DYE(Material.INK_SACK, (short) 12, "Light Blue Dye"),
    MAGENTA_DYE(Material.INK_SACK, (short) 13, "Magenta Dye"),
    ORANGE_DYE(Material.INK_SACK, (short) 14, "Orange Dye"),
    BONE_MEAL(Material.INK_SACK, (short) 15, "Bone Meal"),
    RAW_SALMON(Material.RAW_FISH, (short) 1, "Raw Salmon"),
    TROPICAL_FISH(Material.RAW_FISH, (short) 2, "Tropical Fish"),
    PUFFERFISH(Material.RAW_FISH, (short) 3, "Pufferfish"),
    ENCHANTED_GOLDEN_APPLE(Material.GOLDEN_APPLE, (short) 1, "Enchanted Golden Apple"),
    SPRUCE_LEAVES(Material.LEAVES, (short) 1, "Spruce Leaves"),
    BIRCH_LEAVES(Material.LEAVES, (short) 2, "Birch Leaves"),
    JUNGLE_LEAVES(Material.LEAVES, (short) 3, "Jungle Leaves"),
    DARK_OAK_LEAVES(Material.LEAVES_2, (short) 1, "Dark Oak Leaves"),
    SPRUCE_WOOD(Material.LOG, (short) 1, SpruceWood.class, true),
    BIRCH_WOOD(Material.LOG, (short) 2, BirchWood.class, true),
    JUNGLE_WOOD(Material.LOG, (short) 3, JungleWood.class, true),
    DARK_OAK_WOOD(Material.LOG_2, (short) 1, DarkOakWood.class, true),
    COBBLESTONE_MONSTER_EGG(Material.MONSTER_EGGS, (short) 1, "Cobblestone Monster Egg"),
    STONE_BRICK_MONSTER_EGG(Material.MONSTER_EGGS, (short) 2, "Stone Brick Monster Egg"),
    MOSSY_STONE_BRICK_MONSTER_EGG(Material.MONSTER_EGGS, (short) 3, "Mossy Stone Brick Monster Egg"),
    CRACKED_STONE_BRICK_MONSTER_EGG(Material.MONSTER_EGGS, (short) 4, "Cracked Stone Brick Monster Egg"),
    CHISELED_STONE_BRICK_MONSTER_EGG(Material.MONSTER_EGGS, (short) 5, "Chiseled Stone Brick Monster Egg"),
    SPRUCE_WOOD_PLANKS(Material.WOOD, (short) 1, "Spruce Wood Planks"),
    BIRCH_WOOD_PLANKS(Material.WOOD, (short) 2, "Birch Wood Planks"),
    JUNGLE_WOOD_PLANKS(Material.WOOD, (short) 3, "Jungle Wood Planks"),
    ACACIA_WOOD_PLANKS(Material.WOOD, (short) 4, "Acacia Wood Planks"),
    DARK_OAK_WOOD_PLANKS(Material.WOOD, (short) 5, "Dark Oak Wood Planks"),
    PRISMARINE_BRICKS(Material.PRISMARINE, (short) 1, "Prismarine Bricks"),
    DARK_PRISMARINE(Material.PRISMARINE, (short) 2, "Dark Prismarine"),
    CHISELED_QUARTZ_BLOCK(Material.QUARTZ_BLOCK, (short) 1, "Chiseled Quartz Block"),
    PILLAR_QUARTZ_BLOCK(Material.QUARTZ_BLOCK, (short) 2, "Pillar Quartz Block"),
    BLUE_ORCHID(Material.RED_ROSE, (short) 1, "Blue Orchid"),
    ALLIUM(Material.RED_ROSE, (short) 2, "Allium"),
    AZURE_BLUET(Material.RED_ROSE, (short) 3, "Azure Bluet"),
    RED_TULIP(Material.RED_ROSE, (short) 4, "Red Tulip"),
    ORANGE_TULIP(Material.RED_ROSE, (short) 5, "Orange Tulip"),
    WHITE_TULIP(Material.RED_ROSE, (short) 6, "White Tulip"),
    PINK_TULIP(Material.RED_ROSE, (short) 7, "Pink Tulip"),
    OXEYE_DAISY(Material.RED_ROSE, (short) 8, "Oxeye Daisy"),
    CHISELED_RED_SANDSTONE(Material.RED_SANDSTONE, (short) 1, "Chiseled Red Sandstone"),
    PILLAR_RED_SANDSTONE(Material.RED_SANDSTONE, (short) 2, "Pillar Red Sandstone"),
    RED_SAND(Material.SAND, (short) 1, "Red Sand"),
    CHISELED_SANDSTONE(Material.SANDSTONE, (short) 1, "Chiseled Sandstone"),
    SMOOTH_SANDSTONE(Material.SANDSTONE, (short) 2, "Smooth Sandstone"),
    SPRUCE_SAPLING(Material.SAPLING, (short) 1, "Spruce Sapling"),
    BIRCH_SAPLING(Material.SAPLING, (short) 2, "Birch Sapling"),
    JUNGLE_SAPLING(Material.SAPLING, (short) 3, "Jungle Sapling"),
    ACACIA_SAPLING(Material.SAPLING, (short) 4, "Acacia Sapling"),
    DARK_OAK_SAPLING(Material.SAPLING, (short) 5, "Dark Oak Sapling"),
    WITHER_SKELETON_SKULL(Material.SKULL_ITEM, (short) 1, "Wither Skeleton Skull"),
    ZOMBIE_HEAD(Material.SKULL_ITEM, (short) 2, "Zombie Head"),
    HEAD(Material.SKULL_ITEM, (short) 3, "Head"),
    CREEPER_HEAD(Material.SKULL_ITEM, (short) 4, "Creeper Head"),
    CREEPER_SPAWN_EGG(Material.MONSTER_EGG, (short) 50, "Spawn Creeper"),
    SKELETON_SPAWN_EGG(Material.MONSTER_EGG, (short) 51, "Spawn Skeleton"),
    SPIDER_SPAWN_EGG(Material.MONSTER_EGG, (short) 52, "Spawn Spider"),
    ZOMBIE_SPAWN_EGG(Material.MONSTER_EGG, (short) 54, "Spawn Zombie"),
    SLIME_SPAWN_EGG(Material.MONSTER_EGG, (short) 55, "Spawn Slime"),
    GHAST_SPAWN_EGG(Material.MONSTER_EGG, (short) 56, "Spawn Ghast"),
    ZOMBIE_PIGMAN_SPAWN_EGG(Material.MONSTER_EGG, (short) 57, "Spawn Zombie Pigman"),
    ENDERMAN_SPAWN_EGG(Material.MONSTER_EGG, (short) 58, "Spawn Enderman"),
    CAVE_SPIDER_SPAWN_EGG(Material.MONSTER_EGG, (short) 59, "Spawn Cave Spider"),
    SILVERFISH_SPAWN_EGG(Material.MONSTER_EGG, (short) 60, "Spawn Silverfish"),
    BLAZE_SPAWN_EGG(Material.MONSTER_EGG, (short) 61, "Spawn Blaze"),
    MAGMA_CUBE_SPAWN_EGG(Material.MONSTER_EGG, (short) 62, "Spawn Magma Cube"),
    BAT_SPAWN_EGG(Material.MONSTER_EGG, (short) 65, "Spawn Bat"),
    WITCH_SPAWN_EGG(Material.MONSTER_EGG, (short) 66, "Spawn Witch"),
    ENDERMITE_SPAWN_EGG(Material.MONSTER_EGG, (short) 67, "Spawn Endermite"),
    GUARDIAN_SPAWN_EGG(Material.MONSTER_EGG, (short) 68, "Spawn Guardian"),
    PIG_SPAWN_EGG(Material.MONSTER_EGG, (short) 90, "Spawn Pig"),
    SHEEP_SPAWN_EGG(Material.MONSTER_EGG, (short) 91, "Spawn Sheep"),
    COW_SPAWN_EGG(Material.MONSTER_EGG, (short) 92, "Spawn Cow"),
    CHICKEN_SPAWN_EGG(Material.MONSTER_EGG, (short) 93, "Spawn Chicken"),
    SQUID_SPAWN_EGG(Material.MONSTER_EGG, (short) 94, "Spawn Squid"),
    WOLF_SPAWN_EGG(Material.MONSTER_EGG, (short) 95, "Spawn Wolf"),
    MOOSHROOM_SPAWN_EGG(Material.MONSTER_EGG, (short) 96, "Spawn Mooshroom"),
    OCELOT_SPAWN_EGG(Material.MONSTER_EGG, (short) 98, "Spawn Ocelot"),
    HORSE_SPAWN_EGG(Material.MONSTER_EGG, (short) 100, "Spawn Horse"),
    RABBIT_SPAWN_EGG(Material.MONSTER_EGG, (short) 101, "Spawn Rabbit"),
    VILLAGER_SPAWN_EGG(Material.MONSTER_EGG, (short) 120, "Spawn Villager"),
    WET_SPONGE(Material.SPONGE, (short) 1, "Wet Sponge"),
    ORANGE_STAINED_GLASS(Material.STAINED_GLASS, (short) 1, "Orange Stained Glass"),
    MAGENTA_STAINED_GLASS(Material.STAINED_GLASS, (short) 2, "Magenta Stained Glass"),
    LIGHT_BLUE_STAINED_GLASS(Material.STAINED_GLASS, (short) 3, "Light Blue Stained Glass"),
    YELLOW_STAINED_GLASS(Material.STAINED_GLASS, (short) 4, "Yellow Stained Glass"),
    LIME_STAINED_GLASS(Material.STAINED_GLASS, (short) 5, "Lime Stained Glass"),
    PINK_STAINED_GLASS(Material.STAINED_GLASS, (short) 6, "Pink Stained Glass"),
    GRAY_STAINED_GLASS(Material.STAINED_GLASS, (short) 7, "Gray Stained Glass"),
    LIGHT_GRAY_STAINED_GLASS(Material.STAINED_GLASS, (short) 8, "Light Gray Stained Glass"),
    CYAN_STAINED_GLASS(Material.STAINED_GLASS, (short) 9, "Cyan Stained Glass"),
    PURPLE_STAINED_GLASS(Material.STAINED_GLASS, (short) 10, "Purple Stained Glass"),
    BLUE_STAINED_GLASS(Material.STAINED_GLASS, (short) 11, "Blue Stained Glass"),
    BROWN_STAINED_GLASS(Material.STAINED_GLASS, (short) 12, "Brown Stained Glass"),
    GREEN_STAINED_GLASS(Material.STAINED_GLASS, (short) 13, "Green Stained Glass"),
    RED_STAINED_GLASS(Material.STAINED_GLASS, (short) 14, "Red Stained Glass"),
    BLACK_STAINED_GLASS(Material.STAINED_GLASS, (short) 15, "Black Stained Glass"),
    ORANGE_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 1, "Orange Stained Glass Pane"),
    MAGENTA_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 2, "Magenta Stained Glass Pane"),
    LIGHT_BLUE_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 3, "Light Blue Stained Glass Pane"),
    YELLOW_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 4, "Yellow Stained Glass Pane"),
    LIME_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 5, "Lime Stained Glass Pane"),
    PINK_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 6, "Pink Stained Glass Pane"),
    GRAY_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 7, "Gray Stained Glass Pane"),
    LIGHT_GRAY_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 8, "Light Gray Stained Glass Pane"),
    CYAN_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 9, "Cyan Stained Glass Pane"),
    PURPLE_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 10, "Purple Stained Glass Pane"),
    BLUE_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 11, "Blue Stained Glass Pane"),
    BROWN_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 12, "Brown Stained Glass Pane"),
    GREEN_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 13, "Green Stained Glass Pane"),
    RED_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 14, "Red Stained Glass Pane"),
    BLACK_STAINED_GLASS_PANE(Material.STAINED_GLASS_PANE, (short) 15, "Black Stained Glass Pane"),
    ORANGE_STAINED_CLAY(Material.STAINED_CLAY, (short) 1, "Orange Stained Clay"),
    MAGENTA_STAINED_CLAY(Material.STAINED_CLAY, (short) 2, "Magenta Stained Clay"),
    LIGHT_BLUE_STAINED_CLAY(Material.STAINED_CLAY, (short) 3, "Light Blue Stained Clay"),
    YELLOW_STAINED_CLAY(Material.STAINED_CLAY, (short) 4, "Yellow Stained Clay"),
    LIME_STAINED_CLAY(Material.STAINED_CLAY, (short) 5, "Lime Stained Clay"),
    PINK_STAINED_CLAY(Material.STAINED_CLAY, (short) 6, "Pink Stained Clay"),
    GRAY_STAINED_CLAY(Material.STAINED_CLAY, (short) 7, "Gray Stained Clay"),
    LIGHT_GRAY_STAINED_CLAY(Material.STAINED_CLAY, (short) 8, "Light Gray Stained Clay"),
    CYAN_STAINED_CLAY(Material.STAINED_CLAY, (short) 9, "Cyan Stained Clay"),
    PURPLE_STAINED_CLAY(Material.STAINED_CLAY, (short) 10, "Purple Stained Clay"),
    BLUE_STAINED_CLAY(Material.STAINED_CLAY, (short) 11, "Blue Stained Clay"),
    BROWN_STAINED_CLAY(Material.STAINED_CLAY, (short) 12, "Brown Stained Clay"),
    GREEN_STAINED_CLAY(Material.STAINED_CLAY, (short) 13, "Green Stained Clay"),
    RED_STAINED_CLAY(Material.STAINED_CLAY, (short) 14, "Red Stained Clay"),
    BLACK_STAINED_CLAY(Material.STAINED_CLAY, (short) 15, "Black Stained Clay"),
    GRANITE(Material.STONE, (short) 1, "Granite"),
    POLISHED_GRANITE(Material.STONE, (short) 2, "Polished Granite"),
    DIORITE(Material.STONE, (short) 3, "Diorite"),
    POLISHED_DIORITE(Material.STONE, (short) 4, "Polished Diorite"),
    ANDESITE(Material.STONE, (short) 5, "Andesite"),
    POLISHED_ANDESITE(Material.STONE, (short) 6, "Polished Andesite"),
    SANDSTONE_SLAB(Material.STEP, (short) 1, "Sandstone Slab"),
    COBBLESTONE_SLAB(Material.STEP, (short) 3, "Cobblestone Slab"),
    BRICK_SLAB(Material.STEP, (short) 4, "Brick Slab"),
    STONE_BRICK_SLAB(Material.STEP, (short) 5, "Stone Brick Slab"),
    NETHER_BRICK_SLAB(Material.STEP, (short) 6, "Nether Brick Slab"),
    QUARTZ_SLAB(Material.STEP, (short) 7, "Quartz Slab"),
    MOSSY_STONE_BRICKS(Material.SMOOTH_BRICK, (short) 1, "Mossy Stone Bricks"),
    CRACKED_STONE_BRICKS(Material.SMOOTH_BRICK, (short) 2, "Cracked Stone Bricks"),
    CHISELED_STONE_BRICKS(Material.SMOOTH_BRICK, (short) 3, "Chiseled Stone Bricks"),
    GRASS(Material.LONG_GRASS, (short) 1, "Grass"),
    FERN(Material.LONG_GRASS, (short) 2, "Fern"),
    SPRUCE_WOOD_SLAB(Material.WOOD_STEP, (short) 1, "Spruce Wood Slab"),
    BIRCH_WOOD_SLAB(Material.WOOD_STEP, (short) 2, "Birch Wood Slab"),
    JUNGLE_WOOD_SLAB(Material.WOOD_STEP, (short) 3, "Jungle Wood Slab"),
    ACACIA_WOOD_SLAB(Material.WOOD_STEP, (short) 4, "Acacia Wood Slab"),
    DARK_OAK_WOOD_SLAB(Material.WOOD_STEP, (short) 5, "Dark Oak Wood Slab"),
    ORANGE_WOOL(Material.WOOL, (short) 1, "Orange Wool"),
    MAGENTA_WOOL(Material.WOOL, (short) 2, "Magenta Wool"),
    LIGHT_BLUE_WOOL(Material.WOOL, (short) 3, "Light Blue Wool"),
    YELLOW_WOOL(Material.WOOL, (short) 4, "Yellow Wool"),
    LIME_WOOL(Material.WOOL, (short) 5, "Lime Wool"),
    PINK_WOOL(Material.WOOL, (short) 6, "Pink Wool"),
    GRAY_WOOL(Material.WOOL, (short) 7, "Gray Wool"),
    LIGHT_GRAY_WOOL(Material.WOOL, (short) 8, "Light Gray Wool"),
    CYAN_WOOL(Material.WOOL, (short) 9, "Cyan Wool"),
    PURPLE_WOOL(Material.WOOL, (short) 10, "Purple Wool"),
    BLUE_WOOL(Material.WOOL, (short) 11, "Blue Wool"),
    BROWN_WOOL(Material.WOOL, (short) 12, "Brown Wool"),
    GREEN_WOOL(Material.WOOL, (short) 13, "Green Wool"),
    RED_WOOL(Material.WOOL, (short) 14, "Red Wool"),
    BLACK_WOOL(Material.WOOL, (short) 15, "Black Wool"),
    BONZO_BALLOON_1(Material.SKULL_ITEM, BS1.class),
    BONZO_BALLOON_2(Material.SKULL_ITEM, BS2.class),
    BONZO_BALLOON_3(Material.SKULL_ITEM, BS3.class),
    BONZO_BALLOON_4(Material.SKULL_ITEM, BS4.class),
    BONZO_BALLOON_5(Material.SKULL_ITEM, BS5.class),
    BONZO_BALLOON_6(Material.SKULL_ITEM, BS6.class),
    BONZO_BALLOON_7(Material.SKULL_ITEM, BS7.class),
    BONZO_BALLOON_8(Material.SKULL_ITEM, BS8.class),
    BONZO_BALLOON_9(Material.SKULL_ITEM, BS9.class),

    GOD_POT(Material.SKULL_ITEM, GodPot.class);

    private static final List<ArmorSet> CACHED_SETS = new ArrayList<>();

    public static YoungDragonSet YOUNG_DRAGON_SET = registerArmorSet(YoungDragonSet.class);
    public static SuperiorDragonSet SUPERIOR_DRAGON_SET = registerArmorSet(SuperiorDragonSet.class);
    public static WiseDragonSet WISE_DRAGON_SET = registerArmorSet(WiseDragonSet.class);
    public static UnstableDragonSet UNSTABLE_DRAGON_SET = registerArmorSet(UnstableDragonSet.class);
    public static StrongDragonSet STRONG_DRAGON_SET = registerArmorSet(StrongDragonSet.class);
    public static OldDragonSet OLD_DRAGON_SET = registerArmorSet(OldDragonSet.class);
    public static ProtectorDragonSet PROTECTOR_DRAGON_SET = registerArmorSet(ProtectorDragonSet.class);
    public static LapisArmorSet LAPIS_ARMOR_SET = registerArmorSet(LapisArmorSet.class);
    public static MinerSet MINER_SET = registerArmorSet(MinerSet.class);
    public static MushroomSet MUSHROOM_SET = registerArmorSet(MushroomSet.class);
    public static PumpkinSet PUMPKIN_SET = registerArmorSet(PumpkinSet.class);
    public static BlazeSet BLAZE_SET = registerArmorSet(BlazeSet.class);
    public static FarmSet FARM_SET = registerArmorSet(FarmSet.class);
    public static AnglerSet ANGLER_SET = registerArmorSet(AnglerSet.class);
    public static CactusSet CACTUS_SET = registerArmorSet(CactusSet.class);
    public static LeafletSet LEAFLET_SET = registerArmorSet(LeafletSet.class);
    public static GolemSet GOLEM_SET = registerArmorSet(GolemSet.class);
    public static GrowthSet GROWTH_SET = registerArmorSet(GrowthSet.class);
    public static GoblinSet GOBLIN_SET = registerArmorSet(GoblinSet.class);
    public static SpeedsterSet SPEEDSTER_SET = registerArmorSet(SpeedsterSet.class);
    public static SpongeSet SPONGE_SET = registerArmorSet(SpongeSet.class);
    public static SnowSuitSet SNOW_SET = registerArmorSet(SnowSuitSet.class);
    public static GlaciteSet GLACITE_SET = registerArmorSet(GlaciteSet.class);
    public static SharkScaleSet SHARKSCALE_SET = registerArmorSet(SharkScaleSet.class);
    public static FlamebreakerSet FLAMEBREAKER_SET = registerArmorSet(FlamebreakerSet.class);
    public static PackSet PACK_SET = registerArmorSet(PackSet.class);
    public static BatPersonSet BATPERSON_SET = registerArmorSet(BatPersonSet.class);
    public static WereWolfSet WERE_WOLF_SET = registerArmorSet(WereWolfSet.class);
    public static EnderSet ender_set = registerArmorSet(EnderSet.class);

    @Getter
    private final Material craftMaterial;
    @Getter
    private final short data;
    private final Class<?> clazz;
    @Getter
    private final boolean craft;
    @Getter
    private final String baseName;

    SMaterial(Material craftMaterial, short data, Class<?> clazz, boolean craft, String baseName) {
        this.craftMaterial = craftMaterial;
        this.data = data;
        this.clazz = clazz;
        this.craft = craft;
        this.baseName = baseName;
    }

    SMaterial(Material craftMaterial, short data, Class<?> clazz, boolean craft) {
        this(craftMaterial, data, clazz, craft, null);
    }

    SMaterial(Material craftMaterial, Class<?> clazz, boolean craft) {
        this(craftMaterial, (short) 0, clazz, craft);
    }

    SMaterial(Material craftMaterial, Class<?> clazz) {
        this(craftMaterial, clazz, false);
    }

    SMaterial(Material craftMaterial, Class<?> clazz, short data) {
        this(craftMaterial, data, clazz, false);
    }

    SMaterial(Material craftMaterial, short data, String baseName) {
        this(craftMaterial, data, null, true, baseName);
    }

    SMaterial(Material craftMaterial) {
        this(craftMaterial, null, true);
    }

    public static SMaterial getMaterial(String name) {
        try {
            return valueOf(name.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }

    public static SMaterial getSpecEquivalent(Material material, short data) {
        if (material == Material.LOG || material == Material.LOG_2 || material == Material.LEAVES || material == Material.LEAVES_2)
            data %= 4;
        List<SMaterial> results = Arrays.stream(values())
                .filter((m) -> m.craft && m.getCraftMaterial() == material)
                .collect(Collectors.toList());
        for (SMaterial result : results) {
            if (result.data == data)
                return result;
        }
        if (results.isEmpty())
            return null;
        return results.get(0);
    }

    public static <T extends ArmorSet> T registerArmorSet(Class<? extends ArmorSet> set) {
        try {
            ArmorSet s = set.newInstance();
            CACHED_SETS.add(s);
            return (T) s;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArmorSet findArmorSet(SMaterial helmet, SMaterial chestplate, SMaterial leggings, SMaterial boots) {
        List<ArmorSet> subList = CACHED_SETS.stream().filter(s ->
                s.getHelmet().equals(helmet.getStatistics().getClass()) &&
                        s.getChestplate().equals(chestplate.getStatistics().getClass()) &&
                        s.getLeggings().equals(leggings.getStatistics().getClass()) &&
                        s.getBoots().equals(boots.getStatistics().getClass())).collect(Collectors.toList());
        if (subList.size() == 0) return null;
        return subList.get(0);
    }

    public static ArmorSet findArmorSet(SMaterial piece) {
        List<ArmorSet> subList = CACHED_SETS.stream().filter(s ->
                s.getHelmet().equals(piece.getStatistics().getClass()) ||
                        s.getChestplate().equals(piece.getStatistics().getClass()) ||
                        s.getLeggings().equals(piece.getStatistics().getClass()) ||
                        s.getBoots().equals(piece.getStatistics().getClass())).collect(Collectors.toList());
        if (subList.size() == 0) return null;
        return subList.get(0);
    }

    public MaterialFunction getFunction() {
        Object generic = getGenericInstance();
        if (generic instanceof MaterialFunction)
            return (MaterialFunction) generic;
        return null;
    }

    public MaterialStatistics getStatistics() {
        if (!hasClass()) {
            return new MaterialStatistics() {
                @Override
                public String getDisplayName() {
                    return null;
                }

                @Override
                public Rarity getRarity() {
                    return Rarity.COMMON;
                }

                @Override
                public String getLore() {
                    return null;
                }

                @Override
                public GenericItemType getType() {
                    return SUtil.getItemType(craftMaterial);
                }
            };
        }
        Object generic = getGenericInstance();
        if (generic instanceof MaterialStatistics)
            return (MaterialStatistics) generic;
        return null;
    }

    public String getDisplayName(short variant) {
        if (hasClass())
            return getStatistics().getDisplayName();
        return SUtil.getMaterialDisplayName(craftMaterial, variant);
    }

    public TickingMaterial getTickingInstance() {
        Object generic = getGenericInstance();
        if (generic instanceof TickingMaterial)
            return (TickingMaterial) generic;
        return null;
    }

    public PlayerBoostStatistics getBoostStatistics() {
        MaterialStatistics statistics = getStatistics();
        if (!(statistics instanceof PlayerBoostStatistics)) return null;
        return (PlayerBoostStatistics) statistics;
    }

    public SkullStatistics getSkullStatistics() {
        MaterialStatistics statistics = getStatistics();
        if (!(statistics instanceof SkullStatistics)) return null;
        return (SkullStatistics) statistics;
    }

    public Ability getAbility() {
        if (!hasClass()) return null;
        Object generic = getGenericInstance();
        if (generic instanceof Ability)
            return (Ability) generic;
        return null;
    }

    public OrbBuff getOrbBuff() {
        if (!hasClass()) return null;
        Object generic = getGenericInstance();
        if (generic instanceof OrbBuff)
            return (OrbBuff) generic;
        return null;
    }

    public ItemData getItemData() {
        if (!hasClass()) return null;
        Object generic = getGenericInstance();
        if (generic instanceof ItemData)
            return (ItemData) generic;
        return null;
    }

    public Object getGenericInstance() {
        if (clazz == null) return null;
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
        }
        return null;
    }

    public boolean hasClass() {
        return clazz != null;
    }

    public static ArmorSet getIncompleteArmorSet(PlayerInventory inventory) {
        SItem helmet = SItem.find(inventory.getHelmet());
        SItem chestplate = SItem.find(inventory.getChestplate());
        SItem leggings = SItem.find(inventory.getLeggings());
        SItem boots = SItem.find(inventory.getBoots());
        for (ArmorSet set : CACHED_SETS) {
            if (set.getHelmet() != null && helmet != null && helmet.getType().getStatistics().getClass() == set.getHelmet())
                return set;
            if (set.getChestplate() != null && chestplate != null && chestplate.getType().getStatistics().getClass() == set.getChestplate())
                return set;
            if (set.getLeggings() != null && leggings != null && leggings.getType().getStatistics().getClass() == set.getLeggings())
                return set;
            if (set.getBoots() != null && boots != null && boots.getType().getStatistics().getClass() == set.getBoots())
                return set;
        }
        return null;
    }

    public enum VagueEntityMaterial {
        HELMET,
        CHESTPLATE,
        LEGGINGS,
        BOOTS,
        FRAGMENT;

        public SMaterial getEntityArmorPiece(SEntityType type) {
            return getMaterial(type.name() + "_" + this.name());
        }
    }
}