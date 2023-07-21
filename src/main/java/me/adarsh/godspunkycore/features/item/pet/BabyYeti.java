package me.adarsh.godspunkycore.features.item.pet;

import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.item.RarityValue;
import me.adarsh.godspunkycore.features.item.SItem;
import me.adarsh.godspunkycore.features.skill.CombatSkill;
import me.adarsh.godspunkycore.features.skill.Skill;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class BabyYeti extends Pet {
    public List<PetAbility> getPetAbilities(SItem instance) {
        RarityValue<Double> enderianMul = new RarityValue(Double.valueOf(0.1D), Double.valueOf(0.2D), Double.valueOf(0.2D), Double.valueOf(0.3D), Double.valueOf(0.3D), Double.valueOf(0.3D));
        RarityValue<Double> savvyMul = new RarityValue(Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.4D), Double.valueOf(0.5D), Double.valueOf(0.5D), Double.valueOf(0.5D));
        int level = getLevel(instance);
        final BigDecimal coldbreeze = (new BigDecimal(level * 0.5D)).setScale(1, RoundingMode.HALF_EVEN);
        final BigDecimal yeti1 = (new BigDecimal(level * 1)).setScale(1, RoundingMode.HALF_EVEN);
        BigDecimal yeti2 = (new BigDecimal(level * 1)).setScale(1, RoundingMode.HALF_EVEN);
        final BigDecimal iceshield = (new BigDecimal(level)).setScale(2, RoundingMode.HALF_EVEN);
        List<PetAbility> abilities = new ArrayList<>(Collections.singletonList(new PetAbility() {
            public String getName() {
                return "Cold Breeze";
            }

            public List<String> getDescription(SItem instance) {
                return Arrays.asList(new String[] { "Gives +" + ChatColor.GREEN + ChatColor.RED + " ❁ Strength" + ChatColor.GRAY + " and", ChatColor.BLUE + "☠ Crit Damage" + ChatColor.GRAY + " when near snow" });
            }
        }));
        if (instance.getRarity().isAtLeast(Rarity.EPIC))
            abilities.add(new PetAbility() {
                public String getName() {
                    return "Ice Shield";
                }

                public List<String> getDescription(SItem instance) {
                    return Arrays.asList(new String[] { "Gain " + ChatColor.GREEN + "%" + ChatColor.GRAY + " of your strength", "" + ChatColor.GRAY + "as " + ChatColor.GREEN + "❈ Defense" });
                }
            });
        if (instance.getRarity().isAtLeast(Rarity.LEGENDARY))
            abilities.add(new PetAbility() {
                public String getName() {
                    return "Yeti Fury" + ChatColor.RED + ChatColor.BOLD + " COMING SOON!";
                }

                public List<String> getDescription(SItem instance) {
                    return Arrays.asList(new String[] { "Buffs the Yeti sword  by " + ChatColor.RED + " ❁", "" + ChatColor.RED + "Damage" + ChatColor.GRAY + " and" + ChatColor.AQUA + " ✎", ChatColor.AQUA + "Intelligence" });
                }
            });
        return abilities;
    }

    public Skill getSkill() {
        return (Skill) CombatSkill.INSTANCE;
    }

    public String getURL() {
        return "ab126814fc3fa846dad934c349628a7a1de5b415021a03ef4211d62514d5";
    }

    public String getDisplayName() {
        return "Baby Yeti";
    }

    public GenericItemType getType() {
        return GenericItemType.PET;
    }

    public double getPerStrength() {
        return 0.4D;
    }

    public double getPerIntelligence() {
        return 0.75D;
    }

    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    public void particleBelowA(Player p, Location l) {
        p.spigot().playEffect(l, Effect.COLOURED_DUST, 0, 1, 1.0F, 1.0F, 1.0F, 1.0F, 0, 64);
        p.spigot().playEffect(l, Effect.COLOURED_DUST, 0, 1, 0.1882353F, 0.5411765F, 0.67058825F, 1.0F, 0, 64);
    }
}
