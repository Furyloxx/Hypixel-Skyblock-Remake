package me.godspunky.skyblock.features.slayer;

import lombok.Getter;
import me.godspunky.skyblock.features.entity.SEntityType;
import me.godspunky.skyblock.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class SlayerBossType {
    private static final List<SlayerBossType> TYPES = new ArrayList<>();

    private static final SlayerAbility LIFE_DRAIN = new SlayerAbility(ChatColor.RED + "Life Drain",
            "Drains health every few seconds.");
    private static final SlayerAbility PESTILENCE = new SlayerAbility(ChatColor.GREEN + "Pestilence",
            "Deals AOE damage every second,", "shredding armor by 25%.");
    private static final SlayerAbility ENRAGE = new SlayerAbility(ChatColor.RED + "Enrage",
            "Gets real mad once in a while.");

    private static final SlayerAbility COMBAT_JUMP = new SlayerAbility(ChatColor.YELLOW + "Combat Jump",
            "The spider will often attempt to", "jump behind you.");
    private static final SlayerAbility NOXIOUS = new SlayerAbility(ChatColor.RED + "Noxious",
            "Deals AOE damage every second,", "reducing your healing by 50%.");

    private static final SlayerAbility AGILE = new SlayerAbility(ChatColor.GREEN + "Agile",
            "The wolf is small and fast, making", "it hard to hit.");
    private static final SlayerAbility TRUE_DAMAGE = new SlayerAbility(ChatColor.WHITE + "True Damage",
            "Ignores your defense. Very painful.");
    private static final SlayerAbility CALL_THE_PUPS = new SlayerAbility(ChatColor.AQUA + "Call the pups!",
            "At 50% health, calls its deadly pack", "of pups.");

    public static final SlayerBossType REVENANT_HORROR_I = new SlayerBossType("revenant_horror_i", "Revenant Horror", SEntityType.REVENANT_HORROR, 1,
            "Beginner", SlayerMobType.ZOMBIE, 500, 15, 5, 5, 100, LIFE_DRAIN);
    public static final SlayerBossType REVENANT_HORROR_II = new SlayerBossType("revenant_horror_ii",
            "Revenant Horror", SEntityType.REVENANT_HORROR, 2, "Strong", SlayerMobType.ZOMBIE,
            20000, 50, 25, 25, 2000, LIFE_DRAIN, PESTILENCE);
    public static final SlayerBossType REVENANT_HORROR_III = new SlayerBossType("revenant_horror_iii",
            "Revenant Horror", SEntityType.REVENANT_HORROR, 3, "Challenging", SlayerMobType.ZOMBIE, 400000, 300,
            100, 100, 10000, LIFE_DRAIN, PESTILENCE, ENRAGE);
    public static final SlayerBossType REVENANT_HORROR_IV = new SlayerBossType("revenant_horror_iv",
            "Revenant Horror", SEntityType.REVENANT_HORROR, 4, "Deadly", SlayerMobType.ZOMBIE, 1500000,
            1000, 500, 500, 50000, LIFE_DRAIN, PESTILENCE, ENRAGE);

    public static final SlayerBossType TARANTULA_BROODFATHER_I = new SlayerBossType("tarantula_broodfather_i", "Tarantula Broodfather",
            SEntityType.TARANTULA_BROODFATHER, 1, "Beginner", SlayerMobType.SPIDER, 750,
            35, 5, 5, 100, COMBAT_JUMP);
    public static final SlayerBossType TARANTULA_BROODFATHER_II = new SlayerBossType("tarantula_broodfather_ii", "Tarantula Broodfather",
            SEntityType.TARANTULA_BROODFATHER, 2, "Strong", SlayerMobType.SPIDER, 30000,
            110, 25, 25, 2000, COMBAT_JUMP, NOXIOUS);
    public static final SlayerBossType TARANTULA_BROODFATHER_III = new SlayerBossType("tarantula_broodfather_iii", "Tarantula Broodfather",
            SEntityType.TARANTULA_BROODFATHER, 3, "Challenging", SlayerMobType.SPIDER, 900000,
            525, 100, 100, 10000, COMBAT_JUMP, NOXIOUS);
    public static final SlayerBossType TARANTULA_BROODFATHER_IV = new SlayerBossType("tarantula_broodfather_iv", "Tarantula Broodfather",
            SEntityType.TARANTULA_BROODFATHER, 4, "Debilitating", SlayerMobType.SPIDER, 2400000,
            1325, 500, 500, 50000, COMBAT_JUMP, NOXIOUS);

    public static final SlayerBossType SVEN_PACKMASTER_I = new SlayerBossType("sven_packmaster_i",
            "Sven Packmaster", SEntityType.SVEN_PACKMASTER, 1, "Beginner", SlayerMobType.WOLF, 2000, 60, 5, 5,
            100, AGILE);
    public static final SlayerBossType SVEN_PACKMASTER_II = new SlayerBossType("sven_packmaster_ii",
            "Sven Packmaster", SEntityType.SVEN_PACKMASTER, 2, "Strong", SlayerMobType.WOLF, 40000,
            200, 10, 25, 25, 2000, AGILE, TRUE_DAMAGE);
    public static final SlayerBossType SVEN_PACKMASTER_III = new SlayerBossType("sven_packmaster_iii",
            "Sven Packmaster", SEntityType.SVEN_PACKMASTER, 3, "Challenging", SlayerMobType.WOLF, 750000,
            450, 50, 100, 100, 10000, AGILE, TRUE_DAMAGE, CALL_THE_PUPS);
    public static final SlayerBossType SVEN_PACKMASTER_IV = new SlayerBossType("sven_packmaster_iv",
            "Sven Packmaster", SEntityType.SVEN_PACKMASTER, 4, "Truly Painful", SlayerMobType.WOLF, 2000000,
            1100, 200, 500, 500, 50000, AGILE, TRUE_DAMAGE, CALL_THE_PUPS);

    private final String namespace;
    private final String name;
    private final SEntityType specType;
    private final int tier;
    private final String description;
    private final SlayerMobType type;
    private final int health;
    private final int dps;
    private final int tdps;
    private final int rewardXP;
    private final int spawnXP;
    private final int cost;
    private final List<SlayerAbility> abilities;

    SlayerBossType(String namespace, String name, SEntityType specType, int tier, String description, SlayerMobType type, int health, int dps, int tdps, int rewardXP, int spawnXP, int cost, SlayerAbility... abilities) {
        this.namespace = namespace;
        this.name = name;
        this.specType = specType;
        this.tier = tier;
        this.description = description;
        this.type = type;
        this.health = health;
        this.dps = dps;
        this.tdps = tdps;
        this.rewardXP = rewardXP;
        this.spawnXP = spawnXP;
        this.cost = cost;
        this.abilities = Arrays.asList(abilities);
        TYPES.add(this);
    }

    SlayerBossType(String namespace, String name, SEntityType specType, int tier, String description, SlayerMobType type, int health, int dps, int rewardXP, int spawnXP, int cost, SlayerAbility... abilities) {
        this(namespace, name, specType, tier, description, type, health, dps, 0, rewardXP, spawnXP, cost, abilities);
    }

    public static ChatColor getColorForTier(int tier) {
        switch (tier) {
            case 2:
                return ChatColor.YELLOW;
            case 3:
                return ChatColor.RED;
            case 4:
                return ChatColor.DARK_RED;
            case 5:
                return ChatColor.DARK_PURPLE;
            default:
                return ChatColor.GREEN;
        }
    }

    public static int staticGetXPReqForLevel(int level, EntityType type) {
        switch (type) {
            case ZOMBIE:
                return SUtil.getOrDefault(Arrays.asList(5, 15, 200, 1000, 5000, 20000, 100000, 400000, 1000000), level - 1, 1000000);
            case SPIDER:
                return SUtil.getOrDefault(Arrays.asList(5, 25, 200, 1000, 5000, 20000, 100000, 400000, 1000000), level - 1, 1000000);
            case WOLF:
                return SUtil.getOrDefault(Arrays.asList(10, 30, 250, 1500, 5000, 20000, 100000, 400000, 1000000), level - 1, 1000000);
            case ENDERMAN:
                return SUtil.getOrDefault(Arrays.asList(10, 30, 250, 1500, 5000, 20000, 100000, 400000, 1000000), level - 1, 1000000);
            default:
                return 1000000;
        }
    }

    public int getXPReqForLevel(int level) {
        return staticGetXPReqForLevel(level, type.getEntityType());
    }

    public static SlayerBossType getByNamespace(String namespace) {
        return TYPES.stream()
                .filter(type -> type.namespace.equalsIgnoreCase(namespace))
                .findFirst()
                .orElse(null);
    }

    public String getDisplayName() {
        return getColorForTier(tier) + name + " " + SUtil.toRomanNumeral(tier);
    }

    public List<String> asLore(boolean affordable) {
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_GRAY + description);
        lore.add("");
        lore.add(ChatColor.GRAY + "Health: " + ChatColor.RED + SUtil.commaify(health) + "❤");
        lore.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + SUtil.commaify(dps) + ChatColor.GRAY + " per second");
        if (tdps != 0)
            lore.add(ChatColor.GRAY + "True Damage: " + ChatColor.WHITE + SUtil.commaify(tdps) + ChatColor.GRAY + " per second");
        for (SlayerAbility ability : abilities) {
            lore.add("");
            lore.add(ability.getName());
            for (String line : ability.getDescription())
                lore.add(ChatColor.GRAY + line);
        }
        lore.add("");
        lore.add(ChatColor.GRAY + "Reward: " + ChatColor.LIGHT_PURPLE + rewardXP + " " + type.getName() + " Slayer XP");
        lore.add(ChatColor.DARK_GRAY + "  + Boss drops");
        lore.add("");
        lore.add(ChatColor.GRAY + "Cost to start: " + ChatColor.GOLD + SUtil.commaify(cost) + " coins");
        lore.add("");
        lore.add(affordable ? ChatColor.YELLOW + "Click to slay!" : ChatColor.RED + "Cannot afford quest!");
        return lore;
    }

    public List<String> asHiddenLore(boolean affordable) {
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.DARK_GRAY + description);
        lore.add("");
        lore.add(ChatColor.GRAY + "Health: " + ChatColor.DARK_GRAY + "???");
        lore.add(ChatColor.GRAY + "Damage: " + ChatColor.DARK_GRAY + "???");
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "???");
        lore.add("");
        lore.add(ChatColor.GRAY + "Reward: " + ChatColor.LIGHT_PURPLE + rewardXP + " " + type.getName() + " Slayer XP");
        lore.add(ChatColor.DARK_GRAY + "  + Boss drops");
        lore.add("");
        lore.add(ChatColor.GRAY + "Cost to start: " + ChatColor.GOLD + SUtil.commaify(cost) + " coins");
        lore.add("");
        lore.add(affordable ? ChatColor.YELLOW + "Click to slay!" : ChatColor.RED + "Cannot afford quest!");
        return lore;
    }

    public enum SlayerMobType {
        ZOMBIE,
        SPIDER,
        WOLF;

        public String getName() {
            return name().charAt(0) + name().substring(1).toLowerCase();
        }

        public String getPluralName() {
            return getName() + (this == WOLF ? "ves" : "s");
        }

        public EntityType getEntityType() {
            return EntityType.valueOf(name());
        }

        public Material getIcon() {
            switch (this) {
                case ZOMBIE:
                    return Material.ROTTEN_FLESH;
                case SPIDER:
                    return Material.WEB;
                case WOLF:
                    return Material.MUTTON;
                default:
                    return Material.AIR;
            }
        }

        public int getLevelForXP(int xp) {
            int[] thresholds = {5, 15, 200, 1000, 5000, 20000, 100000, 400000, 1000000};
            for (int i = 0; i < thresholds.length; i++) {
                if (xp < thresholds[i]) {
                    return i;
                }
            }
            return 9;
        }
    }

    @Getter
    private static class SlayerAbility {
        private final String name;
        private final String[] description;

        public SlayerAbility(String name, String... description) {
            this.name = name;
            this.description = description;
        }
    }
}