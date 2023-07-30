package me.adarsh.godspunkycore.features.enchantment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.adarsh.godspunkycore.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

public class Enchantment implements ConfigurationSerializable {
    private final EnchantmentType type;

    private final int level;

    public EnchantmentType getType() {
        return this.type;
    }

    public int getLevel() {
        return this.level;
    }

    public Enchantment(EnchantmentType type, int level) {
        this.type = type;
        this.level = level;
    }

    public String toString() {
        return this.type.getName() + " " + ((this.level <= 3000) ? SUtil.toRomanNumeral(this.level) : SUtil.commaify(this.level));
    }

    public String getDisplayName() {
        return (!this.type.isUltimate() ? ChatColor.BLUE : ("" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD)) + toString();
    }

    public String toIdentifiableString() {
        return this.type.getNamespace() + "." + this.level;
    }

    public String getDescription() {
        if (this.type == EnchantmentType.SHARPNESS)
            return this.type.getDescription(new Object[] { Integer.valueOf(5 * this.level) });
        if (this.type == EnchantmentType.FIRE_ASPECT)
            return this.type.getDescription(new Object[] { Integer.valueOf(2 + this.level) });
        if (this.type == EnchantmentType.GROWTH)
            return this.type.getDescription(new Object[] { Integer.valueOf(15 * this.level) });
        if (this.type == EnchantmentType.AIMING)
            return this.type.getDescription(new Object[] { Integer.valueOf(2 * this.level) });
        if (this.type == EnchantmentType.POWER || this.type == EnchantmentType.SMITE || this.type == EnchantmentType.BANE_OF_ARTHROPODS || this.type == EnchantmentType.DRAGON_HUNTER)
            return this.type.getDescription(new Object[] { Integer.valueOf(8 * this.level) });
        if (this.type == EnchantmentType.ULTIMATE_WISE || this.type == EnchantmentType.CRITICAL)
            return this.type.getDescription(new Object[] { Integer.valueOf(10 * this.level) });
        if (this.type == EnchantmentType.KNOCKBACK)
            return this.type.getDescription(new Object[] { Integer.valueOf(3 * this.level) });
        if (this.type == EnchantmentType.VAMPIRISM)
            return this.type.getDescription(this.level);
        if (this.type == EnchantmentType.FIRST_STRIKE)
            return this.type.getDescription(this.level * 25);
        if (this.type == EnchantmentType.VICIOUS)
            return this.type.getDescription(new Object[] { Integer.valueOf(this.level) });
        if (this.type == EnchantmentType.TURBO_GEM)
            return this.type.getDescription(new Object[] { Integer.valueOf(this.level) });
        if (this.type == EnchantmentType.CHIMERA)
            return this.type.getDescription(new Object[] { Integer.valueOf(this.level * 20) });
        if (this.type == EnchantmentType.HARVESTING)
            return this.type.getDescription(new Object[] { SUtil.commaify(12.5D * this.level) });
        if (this.type == EnchantmentType.PROTECTION)
            return this.type.getDescription(new Object[] { Integer.valueOf(3 * this.level) });
        if (this.type == EnchantmentType.ENDER_SLAYER)
            return this.type.getDescription(new Object[] { Integer.valueOf(12 * this.level) });
        if (this.type == EnchantmentType.FATAL_TEMPO)
            return this.type.getDescription(new Object[] { Integer.valueOf(5 * this.level) });
        if (this.type == EnchantmentType.LEGION)
            return this.type.getDescription(new Object[] { Double.valueOf(Math.round(0.07D * this.level * 100.0D) / 100.0D) });
        if (this.type == EnchantmentType.SOUL_EATER)
            return this.type.getDescription(new Object[] { Integer.valueOf(2 * this.level) });
        if (this.type == EnchantmentType.ONE_FOR_ALL)
            return this.type.getDescription(new Object[] { Integer.valueOf(210 * this.level) });
        if (this.type == EnchantmentType.EXECUTE)
            return this.type.getDescription(new Object[] { Double.valueOf(Math.round(0.2D * this.level * 100.0D) / 100.0D) });
        if (this.type == EnchantmentType.LIFE_STEAL)
            return this.type.getDescription(new Object[] { Double.valueOf(Math.round(0.5D * this.level * 100.0D) / 100.0D) });
        return this.type.getDescription(new Object[0]);
    }

    public static Enchantment getByIdentifiable(String identifiable) {
        String[] spl = identifiable.split("\\.");
        return new Enchantment(EnchantmentType.getByNamespace(spl[0]), Integer.parseInt(spl[1]));
    }

    public boolean equalsType(Enchantment enchantment) {
        return enchantment.type.equals(this.type);
    }

    public boolean equals(Object o) {
        if (!(o instanceof Enchantment))
            return false;
        Enchantment enchantment = (Enchantment)o;
        return (enchantment.level == this.level && enchantment.type.equals(this.type));
    }

    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("type", this.type.getNamespace());
        map.put("level", Integer.valueOf(this.level));
        return null;
    }

    public static List<Enchantment> ultimateEnchantsListFromList(List<Enchantment> list) {
        List<Enchantment> filteredList_ultimate = new ArrayList<>();
        for (Enchantment enchantment : list) {
            if (enchantment.getDisplayName().contains(ChatColor.LIGHT_PURPLE.toString()))
                filteredList_ultimate.add(enchantment);
        }
        return filteredList_ultimate;
    }

    public static List<Enchantment> normalEnchantsListFromList(List<Enchantment> list) {
        List<Enchantment> filteredList_normal = new ArrayList<>();
        for (Enchantment enchantment : list) {
            if (!enchantment.getDisplayName().contains(ChatColor.LIGHT_PURPLE.toString()))
                filteredList_normal.add(enchantment);
        }
        return filteredList_normal;
    }
}