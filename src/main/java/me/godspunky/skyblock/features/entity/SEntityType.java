package me.godspunky.skyblock.features.entity;

import lombok.Getter;
import me.godspunky.skyblock.features.entity.caverns.*;
import me.godspunky.skyblock.features.entity.den.*;
import me.godspunky.skyblock.features.entity.dungeon.CryptDreadlord;
import me.godspunky.skyblock.features.entity.dungeon.TankZombie;
import me.godspunky.skyblock.features.entity.dungeon.Undead;
import me.godspunky.skyblock.features.entity.dungeon.UndeadSkeleton;
import me.godspunky.skyblock.features.entity.dungeon.bosses.*;
import me.godspunky.skyblock.features.entity.dungeon.minibosses.AngryArchaeologist;
import me.godspunky.skyblock.features.entity.dungeon.minibosses.KingMidas;
import me.godspunky.skyblock.features.entity.dungeon.minibosses.LostAdventurer;
import me.godspunky.skyblock.features.entity.dungeon.minibosses.ShadowAssassin;
import me.godspunky.skyblock.features.entity.end.*;
import me.godspunky.skyblock.features.entity.insentient.WheatCrystal;
import me.godspunky.skyblock.features.entity.nether.LargeMagmaCube;
import me.godspunky.skyblock.features.entity.nether.MediumMagmaCube;
import me.godspunky.skyblock.features.entity.nether.SmallMagmaCube;
import me.godspunky.skyblock.features.entity.nether.WitherSkeleton;
import me.godspunky.skyblock.features.entity.nms.*;
import me.godspunky.skyblock.features.entity.skeleton.HighLevelSkeleton;
import me.godspunky.skyblock.features.entity.wolf.*;
import me.godspunky.skyblock.features.entity.zombie.*;
import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.EntityTypes;
import org.bukkit.entity.EntityType;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public enum SEntityType {
    ZEALOT(EntityType.ENDERMAN, Zealot.class),
    ENDER_CHEST_ZEALOT(EntityType.ENDERMAN, Zealot.EnderChestZealot.class),
    SPECIAL_ZEALOT(EntityType.ENDERMAN, Zealot.SpecialZealot.class),
    PROTECTOR_DRAGON(EntityType.ENDER_DRAGON, ProtectorDragon.class),
    OLD_DRAGON(EntityType.ENDER_DRAGON, OldDragon.class),
    WISE_DRAGON(EntityType.ENDER_DRAGON, WiseDragon.class),
    UNSTABLE_DRAGON(EntityType.ENDER_DRAGON, UnstableDragon.class),
    WATCHER_BONZO(EntityType.ZOMBIE, WatcherBonzo.class),
    YOUNG_DRAGON(EntityType.ENDER_DRAGON, YoungDragon.class),
    STRONG_DRAGON(EntityType.ENDER_DRAGON, StrongDragon.class),
    SUPERIOR_DRAGON(EntityType.ENDER_DRAGON, SuperiorDragon.class),
    REVENANT_HORROR(EntityType.ZOMBIE, RevenantHorror.class, true),
    REVENANT_SYCOPHANT(EntityType.ZOMBIE, RevenantSycophant.class),
    REVENANT_CHAMPION(EntityType.ZOMBIE, RevenantChampion.class),
    DEFORMED_REVENANT(EntityType.ZOMBIE, DeformedRevenant.class),
    SVEN_PACKMASTER(EntityType.WOLF, SvenPackmaster.class, true),
    SVEN_PUP(EntityType.WOLF, SvenPup.class, true),
    SVEN_FOLLOWER(EntityType.WOLF, SvenFollower.class),
    PACK_ENFORCER(EntityType.WOLF, PackEnforcer.class),
    SVEN_ALPHA(EntityType.WOLF, SvenAlpha.class),
    TARANTULA_BROODFATHER(EntityType.SPIDER, TarantulaBroodfather.class),
    TOP_CAVE_SPIDER(EntityType.CAVE_SPIDER, TarantulaBroodfather.TopCaveSpider.class),
    TARANTULA_VERMIN(EntityType.SPIDER, TarantulaVermin.class),
    TARANTULA_BEAST(EntityType.SPIDER, TarantulaBeast.class),
    MUTANT_TARANTULA(EntityType.SPIDER, MutantTarantula.class),
    WATCHER(EntityType.SKELETON, Watcher.class),
    OBSIDIAN_DEFENDER(EntityType.SKELETON, ObsidianDefender.class),
    VELOCITY_ARMOR_STAND(EntityType.ARMOR_STAND, VelocityArmorStand.class),
    UNCOLLIDABLE_ARMOR_STAND(EntityType.ARMOR_STAND, UncollidableArmorStand.class),
    WHEAT_CRYSTAL(EntityType.ARMOR_STAND, WheatCrystal.class),
    LAPIS_ZOMBIE(EntityType.ZOMBIE, LapisZombie.class),
    PIGMAN(EntityType.PIG_ZOMBIE, Pigman.class),
    SMALL_SLIME(EntityType.SLIME, SmallSlime.class),
    MEDIUM_SLIME(EntityType.SLIME, MediumSlime.class),
    LARGE_SLIME(EntityType.SLIME, LargeSlime.class),
    DIAMOND_ZOMBIE(EntityType.ZOMBIE, DiamondZombie.class),
    DIAMOND_SKELETON(EntityType.SKELETON, DiamondSkeleton.class),
    ENCHANTED_DIAMOND_ZOMBIE(EntityType.ZOMBIE, EnchantedDiamondZombie.class),
    ENCHANTED_DIAMOND_SKELETON(EntityType.SKELETON, EnchantedDiamondSkeleton.class),
    WEAK_ENDERMAN(EntityType.ENDERMAN, WeakEnderman.class),
    ENDERMAN(EntityType.ENDERMAN, Enderman.class),
    STRONG_ENDERMAN(EntityType.ENDERMAN, StrongEnderman.class),
    SPLITTER_SPIDER(EntityType.SPIDER, SplitterSpider.class),
    SILVERFISH(EntityType.SILVERFISH, Silverfish.class),
    SPIDER_JOCKEY(EntityType.SPIDER, SpiderJockey.class),
    JOCKEY_SKELETON(EntityType.SKELETON, SpiderJockey.JockeySkeleton.class),
    CAVE_SPIDER(EntityType.CAVE_SPIDER, CaveSpider.class),
    BROOD_MOTHER(EntityType.SPIDER, BroodMother.class),
    DASHER_SPIDER(EntityType.SPIDER, DasherSpider.class),
    WEAVER_SPIDER(EntityType.SPIDER, WeaverSpider.class),
    VORACIOUS_SPIDER(EntityType.SPIDER, VoraciousSpider.class),
    ZOMBIE(EntityType.ZOMBIE, Zombie.class),
    ZOMBIE_VILLAGER(EntityType.ZOMBIE, ZombieVillager.class),
    CRYPT_GHOUL(EntityType.ZOMBIE, CryptGhoul.class),
    GOLDEN_GHOUL(EntityType.ZOMBIE, GoldenGhoul.class),
    WOLF(EntityType.WOLF, Wolf.class),
    OLD_WOLF(EntityType.WOLF, OldWolf.class),
    PACK_SPIRIT(EntityType.WOLF, PackSpirit.class),
    HOWLING_SPIRIT(EntityType.WOLF, HowlingSpirit.class),
    SOUL_OF_THE_ALPHA(EntityType.WOLF, SoulOfTheAlpha.class),
    SPIDERS_DEN_SKELETON(EntityType.SKELETON, SpidersDenSkeleton.class),
    HIGH_LEVEL_SKELETON(EntityType.SKELETON, HighLevelSkeleton.class),
    SPIDERS_DEN_SLIME(EntityType.SLIME, SpidersDenSlime.class),
    SNEAKY_CREEPER(EntityType.CREEPER, SneakyCreeper.class),
    WITHER_SKELETON(EntityType.SKELETON, WitherSkeleton.class),
    SMALL_MAGMA_CUBE(EntityType.MAGMA_CUBE, SmallMagmaCube.class),
    MEDIUM_MAGMA_CUBE(EntityType.MAGMA_CUBE, MediumMagmaCube.class),
    LARGE_MAGMA_CUBE(EntityType.MAGMA_CUBE, LargeMagmaCube.class),
    BONZO_PHASE_1(EntityType.ZOMBIE, BonzoPhase1.class),
    BONZO_PHASE_2(EntityType.ZOMBIE, BonzoPhase2.class),
    SCARF(EntityType.ZOMBIE , Scarf.class),
    THE_PROFESSOR(EntityType.ZOMBIE , TheProfessor.class),
    THORN(EntityType.GHAST , Thorn.class),
    LIVID(EntityType.ZOMBIE , Livid.class),
    SADAN(EntityType.ZOMBIE , Sadan.class),
    MAXOR(EntityType.WITHER , Maxor.class),
    STROM(EntityType.WITHER , Strom.class),
    GOLDAR(EntityType.WITHER , Golder.class),
    NECRON(EntityType.WITHER , Necron.class),
    LOST_ADVENTURER(EntityType.ZOMBIE, LostAdventurer.class),
    ANGRY_ARCHAEOLOGIST(EntityType.ZOMBIE, AngryArchaeologist.class),
    SHADOW_ASSASSIN(EntityType.ZOMBIE, ShadowAssassin.class),
    KING_MIDAS(EntityType.ZOMBIE, KingMidas.class),
    UNDEAD(EntityType.ZOMBIE, Undead.class),
    TANK_ZOMBIE(EntityType.ZOMBIE, TankZombie.class),
    CRYPT_DREADLORD(EntityType.ZOMBIE, CryptDreadlord.class),
    UNDEAD_SKELETON(EntityType.SKELETON, UndeadSkeleton.class),
    ;

    @Getter
    private final EntityType craftType;
    @Getter
    private final Class<?> clazz;
    @Getter
    private final boolean specific;

    SEntityType(EntityType craftType, Class<?> clazz, boolean specific) {
        this.craftType = craftType;
        this.clazz = clazz;
        this.specific = specific;
        if (EntityInsentient.class.isAssignableFrom(clazz))
            registerEntity(name(), craftType.getTypeId(), (Class<? extends EntityInsentient>) clazz);
    }

    SEntityType(EntityType craftType, Class<?> clazz) {
        this(craftType, clazz, false);
    }

    public EntityStatistics getStatistics() {
        Object generic = getGenericInstance();
        if (generic instanceof EntityStatistics)
            return (EntityStatistics) generic;
        return null;
    }

    public EntityFunction getFunction() {
        Object generic = getGenericInstance();
        if (generic instanceof EntityFunction)
            return (EntityFunction) generic;
        return null;
    }

    public Object instance(Object... params) {
        try {
            Class<?>[] paramTypes = new Class[params.length];
            for (int i = 0; i < paramTypes.length; i++)
                paramTypes[i] = params[i].getClass();
            return clazz.getConstructor(paramTypes).newInstance(params);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Object getGenericInstance() {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void registerEntity(String name, int id, Class<? extends EntityInsentient> clazz) {
        try {
            List<Map<?, ?>> dataMap = new ArrayList<>();
            for (Field f : EntityTypes.class.getDeclaredFields()) {
                if (f.getType().getSimpleName().equals(Map.class.getSimpleName())) {
                    f.setAccessible(true);
                    dataMap.add((Map<?, ?>) f.get(null));
                }
            }

            if (dataMap.get(2).containsKey(id)) {
                dataMap.get(0).remove(name);
                dataMap.get(2).remove(id);
            }

            Method method = EntityTypes.class.getDeclaredMethod("a", Class.class, String.class, int.class);
            method.setAccessible(true);
            method.invoke(null, clazz, name, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SEntityType getEntityType(String name) {
        return valueOf(name.toUpperCase());
    }
}