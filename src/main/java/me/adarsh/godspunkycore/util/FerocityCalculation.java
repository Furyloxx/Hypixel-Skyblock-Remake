package me.adarsh.godspunkycore.util;

import me.adarsh.godspunkycore.listener.PlayerListener;
import me.adarsh.godspunkycore.user.PlayerStatistics;
import me.adarsh.godspunkycore.user.PlayerUtils;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FerocityCalculation
{
    public static final Map<UUID, Integer> ONE_TYPE_FEROCITY_BONUS_ENDERMAN;

    @Deprecated
    public static void test(final int i) {
    }

    public static Integer ferocityStrikeNext(final int ferocity) {
        if (ferocity == 0) {
            return 0;
        }
        final int feroDiv = Math.round((float)(ferocity / 100)) + 1;
        return feroDiv;
    }

    public static Integer ferocityStrikeCurrent(final int ferocity) {
        if (ferocity < 100) {
            return 0;
        }
        final int feroDiv = Math.round((float)(ferocity / 100));
        return feroDiv;
    }

    public static Double ferocityPercentCurrent(final int ferocity) {
        double returnamount = 0.0;
        final int feroMinus = Math.round((float)(ferocity / 100)) * 100;
        final int feroLater = ferocity - feroMinus;
        if (feroMinus >= 100) {
            returnamount = 100.0;
        }
        else {
            returnamount = ferocity;
        }
        return returnamount;
    }

    public static Double ferocityPercentNext(final int ferocity) {
        final int feroMinus = Math.round((float)(ferocity / 100)) * 100;
        int feroLater = ferocity - feroMinus;
        if (feroLater > 100) {
            feroLater = 0;
        }
        return (double)feroLater;
    }

    public static void activeFerocityTimes(final Player p, final LivingEntity damaged, int finalDamage, final boolean crit) {
        final PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(p.getUniqueId());
        int finalhittime = 0;
        double fer = statistics.getFerocity().addAll();
        int plus_in_calc = 0;
        if (damaged instanceof EnderDragon) {
            final double formula = finalDamage / ((EnderDragon)damaged).getMaxHealth() * 100.0;
            if (formula < 10.0) {
                finalDamage *= 1;
            }
            else if (formula > 10.0 && formula < 15.0) {
                finalDamage -= finalDamage * 90 / 100;
            }
            else if (formula > 15.0 && formula < 20.0) {
                finalDamage -= finalDamage * 99 / 100;
            }
            else if (formula > 20.0 && formula <= 25.0) {
                finalDamage -= (int)(finalDamage * 99.9 / 100.0);
            }
            else if (formula > 25.0) {
                finalDamage *= 0;
            }
            else {
                finalDamage *= 1;
            }
        }
        if (FerocityCalculation.ONE_TYPE_FEROCITY_BONUS_ENDERMAN.containsKey(p.getUniqueId())) {
            plus_in_calc = FerocityCalculation.ONE_TYPE_FEROCITY_BONUS_ENDERMAN.get(p.getUniqueId());
        }
        if (damaged.hasMetadata("VWE")) {
            fer += plus_in_calc;
        }

        final double hittimebase = ferocityPercentNext((int)Math.round(fer));
        finalhittime = ferocityStrikeCurrent((int)Math.round(fer));
        final int chance = SUtil.random(0, 100);
        if (chance <= hittimebase) {
            finalhittime = ferocityStrikeNext((int)Math.round(fer) + 1);
        }
        PlayerListener.ferocityActive(finalhittime, p, finalDamage, (Entity)damaged, crit);
    }

    static {
        ONE_TYPE_FEROCITY_BONUS_ENDERMAN = new HashMap<UUID, Integer>();
    }
}