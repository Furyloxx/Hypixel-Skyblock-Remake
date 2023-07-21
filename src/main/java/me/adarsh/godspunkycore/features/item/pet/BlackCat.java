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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BlackCat extends Pet {
    public List<PetAbility> getPetAbilities(SItem instance) {
        RarityValue<Double> enderianMul = new RarityValue(Double.valueOf(0.1D), Double.valueOf(0.2D), Double.valueOf(0.2D), Double.valueOf(0.3D), Double.valueOf(0.3D), Double.valueOf(0.3D));
        RarityValue<Double> savvyMul = new RarityValue(Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.4D), Double.valueOf(0.5D), Double.valueOf(0.5D), Double.valueOf(0.5D));
        int level = getLevel(instance);
        final int speed = level * 10 / 10;
        final double petlucc = level * 0.15D * 10.0D / 10.0D;
        final double magicfind = level * 0.15D * 10.0D / 10.0D;
        List<PetAbility> abilities = new ArrayList<>(Collections.singletonList(new PetAbility() {
            public String getName() {
                return "Hunter";
            }

            public List<String> getDescription(SItem instance) {
                return Arrays.asList(new String[] { "Increase your " + ChatColor.WHITE + "✦ Speed " + ChatColor.GRAY + "by "});
            }
        }));
        if (instance.getRarity().isAtLeast(Rarity.LEGENDARY))
            abilities.add(new PetAbility() {
                public String getName() {
                    return "Omen " + ChatColor.RED + ChatColor.BOLD + "COMING SOON!";
                }

                public List<String> getDescription(SItem instance) {
                    return Arrays.asList(new String[] { "Grants " + ChatColor.LIGHT_PURPLE + "+" + " ♣ Pet Luck" });
                }
            });
        if (instance.getRarity().isAtLeast(Rarity.LEGENDARY))
            abilities.add(new PetAbility() {
                public String getName() {
                    return "Supernatural";
                }

                public List<String> getDescription(SItem instance) {
                    return Arrays.asList(new String[] { "Grants " + ChatColor.AQUA + "+" + " ✯ Magic Find" });
                }
            });
        return abilities;
    }

    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    public Skill getSkill() {
        return (Skill) CombatSkill.INSTANCE;
    }

    public String getURL() {
        return "e4b45cbaa19fe3d68c856cd3846c03b5f59de81a480eec921ab4fa3cd81317";
    }

    public String getDisplayName() {
        return "Black Cat";
    }

    public GenericItemType getType() {
        return GenericItemType.PET;
    }

    public double getPerSpeed() {
        return 0.0025D;
    }

    public double getPerIntelligence() {
        return 1.0D;
    }

    public void particleBelowA(Player p, Location l) {
        p.spigot().playEffect(l, Effect.COLOURED_DUST, 0, 1, 0.003921569F, 0.003921569F, 0.003921569F, 1.0F, 0, 64);
        p.spigot().playEffect(l, Effect.COLOURED_DUST, 0, 1, 0.003921569F, 0.003921569F, 0.003921569F, 1.0F, 0, 64);
    }
}

