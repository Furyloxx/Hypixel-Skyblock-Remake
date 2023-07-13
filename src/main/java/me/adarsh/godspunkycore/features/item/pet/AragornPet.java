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

public class AragornPet extends Pet {
    public List<PetAbility> getPetAbilities(SItem instance) {
        int level = getLevel(instance);
        RarityValue<Double> annihCh = new RarityValue(Double.valueOf(10.0D), Double.valueOf(10.0D), Double.valueOf(10.0D), Double.valueOf(8.0D), Double.valueOf(6.0D), Double.valueOf(6.0D));
        RarityValue<Integer> gingaCh = new RarityValue(Integer.valueOf(50), Integer.valueOf(40), Integer.valueOf(30), Integer.valueOf(20), Integer.valueOf(10), Integer.valueOf(10));
        BigDecimal annih = BigDecimal.valueOf(1.0D / (((Double)annihCh.getForRarity(instance.getRarity())).doubleValue() - level * 0.02D)).setScale(1, RoundingMode.HALF_EVEN);
        BigDecimal pig = BigDecimal.valueOf(1.0D / (150.0D - level)).setScale(3, RoundingMode.HALF_EVEN);
        List<PetAbility> abilities = new ArrayList<>(Collections.singletonList(new PetAbility() {
            public String getName() {
                return "Skysim ownerrr";
            }

            public List<String> getDescription(SItem instance) {
                return Arrays.asList(new String[] { ChatColor.GRAY + "yes this is a pet" });
            }
        }));
        return abilities;
    }

    public Skill getSkill() {
        return (Skill) CombatSkill.INSTANCE;
    }

    public String getURL() {
        return "46097f84a73f099c0b1e517fd385c60785c3c7dbdf5667fbb58575ad54a256a6";
    }

    public String getDisplayName() {
        return "Mini-Teriev";
    }

    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    public GenericItemType getType() {
        return GenericItemType.PET;
    }

    public double getPerIntelligence() {
        return -100.0D;
    }

    public double getPerMagicFind() {
        return 0.002D;
    }

    public double getPerStrength() {
        return 1.0D;
    }

    public double getPerDefense() {
        return 1.0D;
    }

    public double getPerCritDamage() {
        return 0.0D;
    }

    public void particleBelowA(Player p, Location l) {
        p.spigot().playEffect(l, Effect.FLAME, 0, 1, 1.0F, 1.0F, 1.0F, 0.0F, 0, 64);
    }
}