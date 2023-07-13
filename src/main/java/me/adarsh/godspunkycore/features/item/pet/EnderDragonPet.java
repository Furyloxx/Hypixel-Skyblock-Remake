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

public class EnderDragonPet extends Pet {
    public List<PetAbility> getPetAbilities(SItem instance) {
        RarityValue<Double> enderianMul = new RarityValue(Double.valueOf(0.1D), Double.valueOf(0.2D), Double.valueOf(0.2D), Double.valueOf(0.3D), Double.valueOf(0.3D), Double.valueOf(0.3D));
        RarityValue<Double> savvyMul = new RarityValue(Double.valueOf(0.0D), Double.valueOf(0.0D), Double.valueOf(0.4D), Double.valueOf(0.5D), Double.valueOf(0.5D), Double.valueOf(0.5D));
        int level = getLevel(instance);
        final BigDecimal endstrike = (new BigDecimal(level * 0.25D)).setScale(1, RoundingMode.HALF_EVEN);
        final BigDecimal aotd1 = (new BigDecimal(level * 0.5D)).setScale(1, RoundingMode.HALF_EVEN);
        final BigDecimal aotd2 = (new BigDecimal(level * 0.3D)).setScale(1, RoundingMode.HALF_EVEN);
        final BigDecimal buffstat = (new BigDecimal(level * 0.1D)).setScale(2, RoundingMode.HALF_EVEN);
        List<PetAbility> abilities = new ArrayList<>(Collections.singletonList(new PetAbility() {
            public String getName() {
                return "End Strike";
            }

            public List<String> getDescription(SItem instance) {
                return Arrays.asList(new String[] { "Deal +" + ChatColor.GREEN + "%" + ChatColor.GRAY + " more damage to", "end mobs." });
            }
        }));
        if (instance.getRarity().isAtLeast(Rarity.EPIC))
            abilities.add(new PetAbility() {
                public String getName() {
                    return "One with the Dragons";
                }

                public List<String> getDescription(SItem instance) {
                    return Arrays.asList(new String[] { "Buffs the Aspect of the", "Dragons sword by "  + ChatColor.RED + " ❁", "" + ChatColor.RED + "Damage" + ChatColor.GRAY + " and " + ChatColor.RED + " ❁ Strength" });
                }
            });
        if (instance.getRarity().isAtLeast(Rarity.LEGENDARY))
            abilities.add(new PetAbility() {
                public String getName() {
                    return "Superior";
                }

                public List<String> getDescription(SItem instance) {
                    return Arrays.asList(new String[] { "Increases most stats by " + ChatColor.GREEN + "%" });
                }
            });
        return abilities;
    }

    public Skill getSkill() {
        return (Skill) CombatSkill.INSTANCE;
    }

    public String getURL() {
        return "aec3ff563290b13ff3bcc36898af7eaa988b6cc18dc254147f58374afe9b21b9";
    }

    public String getDisplayName() {
        return "Ender Dragon";
    }

    public GenericItemType getType() {
        return GenericItemType.PET;
    }

    public double getPerCritDamage() {
        return 0.005D;
    }

    public double getPerStrength() {
        return 0.5D;
    }

    public double getPerCritChance() {
        return 0.001D;
    }

    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    public void particleBelowA(Player p, Location l) {
        p.spigot().playEffect(l, Effect.LARGE_SMOKE, 21, 0, 0.1F, 0.0F, 0.1F, 0.01F, 1, 30);
        p.spigot().playEffect(l, Effect.WITCH_MAGIC, 0, 1, 1.0F, 1.0F, 1.0F, 0.0F, 0, 64);
    }
}

