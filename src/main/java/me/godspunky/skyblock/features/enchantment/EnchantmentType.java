package me.godspunky.skyblock.features.enchantment;

import me.godspunky.skyblock.features.item.SpecificItemType;
import me.godspunky.skyblock.util.Sputnik;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;

import java.util.*;

public class EnchantmentType {
    private static final Map<String, EnchantmentType> ENCHANTMENT_TYPE_CACHE = new HashMap<>();

    public static final EnchantmentType SHARPNESS = new EnchantmentType("Sharpness", "sharpness", "Increases damage dealt by " + ChatColor.GREEN + "%s%", SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.AXE);

    public static final EnchantmentType LIFE_STEAL = new EnchantmentType("Life Steal", "life_steal", "Heals for " + ChatColor.GREEN + "%s%" + ChatColor.GRAY + " of your max health each time you hit a mob.", SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.AXE);

    public static final EnchantmentType EXECUTE = new EnchantmentType("Execute", "execute", "Increases damage by " + ChatColor.GREEN + "%s%" +
            Sputnik.trans(" &7for each percent of Health missing on your target. "), SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.AXE);

    public static final EnchantmentType FIRE_ASPECT = new EnchantmentType("Fire Aspect", "fire_aspect", "Gives whoever this weapon hits %s seconds of fire.", SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.AXE);

    public static final EnchantmentType PROTECTION = new EnchantmentType("Protection", "protection", "Grants " + ChatColor.GREEN + "+%s ❈ Defense" + ChatColor.GRAY + ".", SpecificItemType.HELMET, SpecificItemType.CHESTPLATE, SpecificItemType.LEGGINGS, SpecificItemType.BOOTS);

    public static final EnchantmentType GROWTH = new EnchantmentType("Growth", "growth", "Grants " + ChatColor.GREEN + "+%s " + ChatColor.RED + "❤ " + ChatColor.RED + "Health" + ChatColor.GRAY + ".", SpecificItemType.HELMET, SpecificItemType.CHESTPLATE, SpecificItemType.LEGGINGS, SpecificItemType.BOOTS);

    public static final EnchantmentType AIMING = new EnchantmentType("Aiming", "aiming", "Arrows home towards nearby mobs if they are within %s blocks.", SpecificItemType.BOW);

    public static final EnchantmentType POWER = new EnchantmentType("Power", "power", "Increases bow damage by " + ChatColor.GREEN + "%s%", SpecificItemType.BOW);

    public static final EnchantmentType FLAME = new EnchantmentType("Flame", "flame", "Arrow ignites target for 3 seconds, dealing 5 damage every second.", SpecificItemType.BOW);

    public static final EnchantmentType ENDER_SLAYER = new EnchantmentType("Ender Slayer", "ender_slayer", "Increases damage dealt to Ender Dragons and Endermen by " + ChatColor.GREEN + "%s% " + ChatColor.GRAY + "", SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.AXE);

    public static final EnchantmentType DRAGON_HUNTER = new EnchantmentType("Dragon Hunter", "dragon_hunter", "Increases damage dealt to Ender Dragons by " + ChatColor.GREEN + "%s% " + ChatColor.GRAY + "", SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.AXE, SpecificItemType.BOW);

    public static final EnchantmentType TURBO_GEM = new EnchantmentType("Turbo-Gem", "turbo_gem", "Grants " + ChatColor.AQUA + "%s" + ChatColor.GRAY + " extra Bits while killing mobs. Doesn't apply for" + ChatColor.YELLOW + " magic abilities", SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.AXE, SpecificItemType.BOW);

    public static final EnchantmentType EFFICIENCY = new EnchantmentType("Efficiency", "efficiency", "Reduces the time in takes to mine.", Enchantment.DIG_SPEED, SpecificItemType.AXE, SpecificItemType.PICKAXE, SpecificItemType.SHOVEL);

    public static final EnchantmentType KNOCKBACK = new EnchantmentType("Knockback", "knockback",
            Sputnik.trans("Increases knockback by &a%s&7 blocks."), Enchantment.KNOCKBACK, SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.AXE);

    public static final EnchantmentType AQUA_INFINITY = new EnchantmentType("Aqua Infinity", "aqua_infinity",
            Sputnik.trans("Increases underwater mining rate to normal level mining rate."), Enchantment.WATER_WORKER, SpecificItemType.HELMET);

    public static final EnchantmentType VAMPIRISM = new EnchantmentType("Vampirism", "vampirism",
            Sputnik.trans("Heals for &a%s% &7of your missing Health per level whenever you kill an enemy."), SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.AXE);

    public static final EnchantmentType FIRST_STRIKE = new EnchantmentType("First Strike", "first_strike",
            Sputnik.trans("Increases the first melee damage dealt to a mob by &a%s%"), SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.AXE);

    public static final EnchantmentType VICIOUS = new EnchantmentType("Vicious", "vicious",
            Sputnik.trans("Grant &c+%s⫽ Ferocity"), SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.AXE, SpecificItemType.BOW);

    public static final EnchantmentType SMITE = new EnchantmentType("Smite", "smite", "Increases damage dealt to Zombies, Zombie Pigmen, Withers, Wither Skeletons, and Skeletons by " + ChatColor.GREEN + "%s% " + ChatColor.GRAY + "", SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.AXE);

    public static final EnchantmentType BANE_OF_ARTHROPODS = new EnchantmentType("Bane of Arthropods", "bane_of_arthropods", "Increases damage dealt to Cave Spiders, Spiders, and Silverfish by " + ChatColor.GREEN + "%s% " + ChatColor.GRAY + "", SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.AXE);

    public static final EnchantmentType CRITICAL = new EnchantmentType("Critical", "critical", "Increases " + ChatColor.BLUE + "☠ Crit Damage " + ChatColor.GRAY + "by " + ChatColor.GREEN + "%s%" + ChatColor.GRAY + ".", SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.AXE);

    public static final EnchantmentType FATAL_TEMPO = new EnchantmentType("Fatal Tempo", "fatal_tempo",
            Sputnik.trans("&7Attack increases your &c⫽ &cFerocity &7by &c%s% &7per hit, capped at &c200% &7for 3 seconds after your &efirst &eattack &7that triggers the enchantment."), true, SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.AXE);

    public static final EnchantmentType HARVESTING = new EnchantmentType("Harvesting", "harvesting", "Increases the chance for crops to drop double the amount of items by " + ChatColor.GREEN + "%s%" + ChatColor.GRAY + ".", SpecificItemType.HOE);

    public static final EnchantmentType TELEKINESIS = new EnchantmentType("Telekinesis", "telekinesis", "Blocks and mob drops go directly into your inventory.", SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.BOW, SpecificItemType.AXE);

    public static final EnchantmentType ULTIMATE_WISE = new EnchantmentType("Ultimate Wise", "ultimate_wise", "Reduces the Mana Cost of this item's ability by " + ChatColor.GREEN + "%s%" + ChatColor.GRAY + ".", true, SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.SHOVEL, SpecificItemType.SHEARS, SpecificItemType.PICKAXE, SpecificItemType.BOW, SpecificItemType.AXE, SpecificItemType.ROD, SpecificItemType.HOE, SpecificItemType.WAND);

    public static final EnchantmentType SOUL_EATER = new EnchantmentType("Soul Eater", "soul_eater",
            Sputnik.trans("Your weapon gains &c%sx&7 damage of the latest monster killed and applies it on your next hit."), true, SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.AXE, SpecificItemType.BOW);

    public static final EnchantmentType CHIMERA = new EnchantmentType("Chimera", "chimera",
            Sputnik.trans("Copies &a%s% &7of your active pet's stats."), true, SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.AXE, SpecificItemType.BOW);

    public static final EnchantmentType LEGION = new EnchantmentType("Legion", "legion",
            Sputnik.trans("Increases most of your player stats by &e+%s% &7per player per level within &b30 &7blocks of you, up to &a20 &7players."), true, SpecificItemType.HELMET, SpecificItemType.CHESTPLATE, SpecificItemType.LEGGINGS, SpecificItemType.BOOTS);

    public static final EnchantmentType ONE_FOR_ALL = new EnchantmentType("One for All", "one_for_all",
            Sputnik.trans("Removes all other enchants but increases your weapon damage by &a%s%"), true, SpecificItemType.SWORD, SpecificItemType.LONGSWORD, SpecificItemType.AXE);

    private final String name;

    private final String namespace;

    private final String description;

    private final boolean ultimate;

    private final Enchantment vanilla;

    private final List<SpecificItemType> compatibleTypes;

    public String getName() {
        return this.name;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public boolean isUltimate() {
        return this.ultimate;
    }

    public Enchantment getVanilla() {
        return this.vanilla;
    }

    public List<SpecificItemType> getCompatibleTypes() {
        return this.compatibleTypes;
    }

    public EnchantmentType(String name, String namespace, String description, boolean ultimate, Enchantment vanilla, SpecificItemType... compatibleTypes) {
        this.name = name;
        this.namespace = namespace;
        this.description = description;
        this.ultimate = ultimate;
        this.vanilla = vanilla;
        this.compatibleTypes = new ArrayList<>(Arrays.asList(compatibleTypes));
        ENCHANTMENT_TYPE_CACHE.put(namespace, this);
    }

    public EnchantmentType(String name, String namespace, String description, boolean ultimate, SpecificItemType... compatibleTypes) {
        this(name, namespace, description, ultimate, null, compatibleTypes);
    }

    public EnchantmentType(String name, String namespace, String description, Enchantment vanilla, SpecificItemType... compatibleTypes) {
        this(name, namespace, description, false, vanilla, compatibleTypes);
    }

    public EnchantmentType(String name, String namespace, String description, SpecificItemType... compatibleTypes) {
        this(name, namespace, description, false, compatibleTypes);
    }

    public static EnchantmentType getByNamespace(String namespace) {
        return ENCHANTMENT_TYPE_CACHE.get(namespace.toLowerCase());
    }

    public String getDescription(Object... objects) {
        String description = this.description;
        for (Object object : objects)
            description = description.replaceFirst("%s", String.valueOf(object));
        return description;
    }

    public boolean equals(Object o) {
        if (!(o instanceof EnchantmentType))
            return false;
        return ((EnchantmentType)o).namespace.equals(this.namespace);
    }
}