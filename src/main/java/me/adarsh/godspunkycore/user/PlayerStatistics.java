package me.adarsh.godspunkycore.user;

import lombok.Getter;
import lombok.Setter;
import me.adarsh.godspunkycore.GodSpunkySkyblockMain;
import me.adarsh.godspunkycore.features.item.armor.ArmorSet;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class PlayerStatistics {
    private final UUID uuid;
    private final DoublePlayerStatistic maxHealth;
    private final DoublePlayerStatistic defense;
    private final DoublePlayerStatistic strength;
    private final DoublePlayerStatistic speed;
    private final DoublePlayerStatistic critChance;
    private final DoublePlayerStatistic critDamage;
    private final DoublePlayerStatistic magicFind;
    private final DoublePlayerStatistic intelligence;
    private final DoublePlayerStatistic trueDefense;
    @Setter
    private double healthRegenerationPercentBonus;
    @Setter
    private double manaRegenerationPercentBonus;
    @Setter
    private ArmorSet armorSet;
    private Map<Integer, BukkitTask> itemTicker;

    public PlayerStatistics(UUID uuid, DoublePlayerStatistic maxHealth, DoublePlayerStatistic defense,
                            DoublePlayerStatistic strength, DoublePlayerStatistic speed,
                            DoublePlayerStatistic critChance, DoublePlayerStatistic critDamage,
                            DoublePlayerStatistic magicFind,
                            DoublePlayerStatistic intelligence, DoublePlayerStatistic trueDefense,
                            double healthRegenerationPercentBonus,
                            double manaRegenerationPercentBonus, ArmorSet armorSet) {
        this.uuid = uuid;
        this.maxHealth = maxHealth;
        this.defense = defense;
        this.strength = strength;
        this.speed = speed;
        this.critChance = critChance;
        this.critDamage = critDamage;
        this.magicFind = magicFind;
        this.intelligence = intelligence;
        this.trueDefense = trueDefense;
        this.healthRegenerationPercentBonus = healthRegenerationPercentBonus;
        this.manaRegenerationPercentBonus = manaRegenerationPercentBonus;
        this.armorSet = armorSet;
        this.itemTicker = new HashMap<>();
    }

    public void tickItem(int slot, long interval, Runnable runnable) {
        itemTicker.put(slot, new BukkitRunnable() {
            public void run() {
                if (Bukkit.getPlayer(uuid) == null) {
                    cancel();
                    return;
                }
                runnable.run();
            }
        }.runTaskTimer(GodSpunkySkyblockMain.getPlugin(), 0, interval));
    }

    public void cancelTickingItem(int slot) {
        if (itemTicker.containsKey(slot))
            itemTicker.get(slot).cancel();
        itemTicker.remove(slot);
    }

    public void zeroAll(int slot) {
        maxHealth.zero(slot);
        defense.zero(slot);
        strength.zero(slot);
        intelligence.zero(slot);
        speed.zero(slot);
        critChance.zero(slot);
        critDamage.zero(slot);
        magicFind.zero(slot);
        trueDefense.zero(slot);
        cancelTickingItem(slot);
    }

    @Override
    public String toString() {
        return maxHealth.addAll() + ", " + defense.addAll() + ", " + strength.addAll() + ", " + speed.addAll() + ", " + critChance.addAll() + ", " +
                critDamage.addAll() + ", " + magicFind.addAll() + ", " + intelligence.addAll();
    }

    public void boostManaRegeneration(double percent, long ticks) {
        manaRegenerationPercentBonus += percent;
        new BukkitRunnable() {
            public void run() {
                manaRegenerationPercentBonus -= percent;
            }
        }.runTaskLater(GodSpunkySkyblockMain.getPlugin(), ticks);
    }

    public void boostHealthRegeneration(double percent, long ticks) {
        healthRegenerationPercentBonus += percent;
        new BukkitRunnable() {
            public void run() {
                healthRegenerationPercentBonus -= percent;
            }
        }.runTaskLater(GodSpunkySkyblockMain.getPlugin(), ticks);
    }

    public static PlayerStatistics blank(UUID uuid) {
        return new PlayerStatistics(uuid, new DoublePlayerStatistic(100.0), new DoublePlayerStatistic(),
                new DoublePlayerStatistic(), new DoublePlayerStatistic(1.0),
                new DoublePlayerStatistic(0.3), new DoublePlayerStatistic(0.5), new DoublePlayerStatistic(),
                new DoublePlayerStatistic(), new DoublePlayerStatistic(),
                0.0, 0.0, null);
    }
}
