package me.godspunky.skyblock.features.slayer;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SlayerSystem {

    public enum SlayerType {
        ZOMBIE, SPIDER, WOLF, ENDERMAN, VAMPIRE, BLAZE
    }

    public static class SlayerBoss {
        private String name;
        private int health;
        private int damage;
        private int tier;
        private int xpReward;
        private Map<String, Double> drops;

        public SlayerBoss(String name, int health, int damage, int tier, int xpReward) {
            this.name = name;
            this.health = health;
            this.damage = damage;
            this.tier = tier;
            this.xpReward = xpReward;
            this.drops = new HashMap<>();
        }

        public void addDrop(String itemName, double chance) {
            drops.put(itemName, chance);
        }

        public Map<String, Integer> rollDrops() {
            Map<String, Integer> loot = new HashMap<>();
            Random rand = new Random();

            for (Map.Entry<String, Double> entry : drops.entrySet()) {
                if (rand.nextDouble() < entry.getValue()) {
                    loot.put(entry.getKey(), 1);
                }
            }

            return loot;
        }
    }

    public static class SlayerQuest {
        private SlayerType type;
        private int tier;
        private int combatXpRequired;
        private int cost;
        private SlayerBoss boss;

        public SlayerQuest(SlayerType type, int tier, int combatXpRequired, int cost, SlayerBoss boss) {
            this.type = type;
            this.tier = tier;
            this.combatXpRequired = combatXpRequired;
            this.cost = cost;
            this.boss = boss;
        }

        public boolean canStart(Player player) {
            return player.getCoins() >= cost;
        }

        public void start(Player player) {
            if (canStart(player)) {
                player.removeCoins(cost);
                player.setActiveQuest(this);
            }
        }

        public boolean isComplete(Player player) {
            return player.getCombatXpGained() >= combatXpRequired;
        }

        public void complete(Player player) {
            if (isComplete(player)) {
                player.addSlayerXp(type, boss.xpReward);
                Map<String, Integer> loot = boss.rollDrops();
                player.addItems(loot);
            }
        }
    }

    public static class Player {
        private int coins;
        private Map<SlayerType, Integer> slayerXp;
        private SlayerQuest activeQuest;
        private int combatXpGained;
        private Map<String, Integer> inventory;

        public Player(int coins) {
            this.coins = coins;
            this.slayerXp = new HashMap<>();
            for (SlayerType type : SlayerType.values()) {
                slayerXp.put(type, 0);
            }
            this.inventory = new HashMap<>();
        }

        public void removeCoins(int amount) {
            coins -= amount;
        }

        public void setActiveQuest(SlayerQuest quest) {
            activeQuest = quest;
            combatXpGained = 0;
        }

        public void addSlayerXp(SlayerType type, int amount) {
            slayerXp.put(type, slayerXp.get(type) + amount);
        }

        public void addItems(Map<String, Integer> items) {
            for (Map.Entry<String, Integer> entry : items.entrySet()) {
                inventory.put(entry.getKey(), inventory.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }

        public int getCoins() { return coins; }

        public int getCombatXpGained() { return combatXpGained; }

        public void addCombatXp(int amount) { combatXpGained += amount; }
    }
}

