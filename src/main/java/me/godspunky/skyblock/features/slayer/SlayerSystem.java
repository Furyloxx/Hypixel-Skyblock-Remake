package me.godspunky.skyblock.features.slayer;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.user.User;
import me.godspunky.skyblock.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class SlayerSystem {

    private static final Map<Player, SlayerQuest> activeQuests = new HashMap<>();

    public static void startQuest(Player player, SlayerBossType bossType) {
        User user = User.getUser(player.getUniqueId());
        if (user == null) return;

        if (activeQuests.containsKey(player)) {
            player.sendMessage(ChatColor.RED + "You already have an active Slayer quest!");
            return;
        }

        if (user.getCoins() < bossType.getCost()) {
            player.sendMessage(ChatColor.RED + "You don't have enough coins to start this quest!");
            return;
        }

        user.subCoins(bossType.getCost());
        SlayerQuest quest = new SlayerQuest(bossType, System.currentTimeMillis());
        activeQuests.put(player, quest);
        user.setSlayerQuest(quest);

        player.sendMessage(ChatColor.GREEN + "Slayer quest started! Kill " + bossType.getType().getName() + "s to spawn the boss.");

        new BukkitRunnable() {
            @Override
            public void run() {
                if (!activeQuests.containsKey(player)) {
                    this.cancel();
                    return;
                }

                SlayerQuest currentQuest = activeQuests.get(player);
                if (currentQuest.getXp() >= bossType.getSpawnXP()) {
                    spawnBoss(player, currentQuest);
                    this.cancel();
                }
            }
        }.runTaskTimer(Skyblock.getPlugin(), 20L, 20L);
    }

    public static void addSlayerXP(Player player, double xp) {
        if (!activeQuests.containsKey(player)) return;

        SlayerQuest quest = activeQuests.get(player);
        quest.setXp(quest.getXp() + xp);

        double progress = (quest.getXp() / quest.getType().getSpawnXP()) * 100;
        player.sendMessage(ChatColor.YELLOW + "Slayer XP: " + ChatColor.WHITE + SUtil.roundTo(quest.getXp(), 1) + "/" + quest.getType().getSpawnXP() + " (" + SUtil.roundTo(progress, 1) + "%)");
    }

    private static void spawnBoss(Player player, SlayerQuest quest) {
        SlayerBossType bossType = quest.getType();
        // Logic to spawn the boss entity
        // This would involve creating a custom entity with the boss's attributes

        player.sendMessage(ChatColor.RED + "The " + bossType.getDisplayName() + " has spawned!");
        SlayerQuest.playBossSpawn(player.getLocation(), player);
    }

    public static void killBoss(Player player, SlayerBossType bossType) {
        if (!activeQuests.containsKey(player)) return;

        SlayerQuest quest = activeQuests.get(player);
        if (quest.getType() != bossType) return;

        User user = User.getUser(player.getUniqueId());
        if (user == null) return;

        quest.setKilled(System.currentTimeMillis());
        user.setSlayerXP(bossType.getType(), user.getSlayerXP(bossType.getType()) + bossType.getRewardXP());

        player.sendMessage(ChatColor.GREEN + "You killed the " + bossType.getDisplayName() + " and gained " + bossType.getRewardXP() + " Slayer XP!");

        // Logic for boss drops would go here

        activeQuests.remove(player);
        user.setSlayerQuest(null);
    }

    public static boolean hasActiveQuest(Player player) {
        return activeQuests.containsKey(player);
    }

    public static SlayerQuest getActiveQuest(Player player) {
        return activeQuests.get(player);
    }
}
