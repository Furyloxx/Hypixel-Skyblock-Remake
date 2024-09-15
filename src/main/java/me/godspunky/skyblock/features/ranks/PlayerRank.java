package me.godspunky.skyblock.features.ranks;

public enum PlayerRank {
    DEFAULT("&7", 1),
    VIP("&a[VIP]", 2),
    VIPPLUS("&a[VIP&6+&a]", 3),
    MVP("&b[MVP]", 4),
    MVPPLUS("&b[MVP&c+&b]", 5),
    MVPPLUSPLUS("&6[MVP&c++&6]", 6),
    YOUTUBE("&c[&fYOUTUBE&c]", 7),
    BT("&d[BT]", 8),
    JR_HELPER("&9[JR HELPER]", 9),
    HELPER("&9[HELPER]", 10),
    MOD("&2[MOD]", 11),
    GM("&2[GM]", 12),
    ADMIN("&c[ADMIN]", 13),
    OWNER("&c[OWNER]", 14);


    private final String prefix;
    private final int level;

    PlayerRank( String prefix, int level) {
        this.prefix = prefix;
        this.level = level;
    }


    public String getPrefix() {
        return prefix;
    }

    public int getLevel() {
        return level;
    }

    public boolean isBelowOrEqual(PlayerRank rank) {
        return this.level <= rank.level;
    }

    public boolean isAboveOrEqual(PlayerRank rank) {
        return this.level >= rank.level;
    }


    public static PlayerRank getRankOrDefault(int level) {
        for (PlayerRank rank : PlayerRank.values()) {
            if (rank.level == level) {
                return rank;
            }
        }
        return DEFAULT;
    }

    public boolean hasRank(PlayerRank requiredRank) {
        return this.level >= requiredRank.level;
    }

    public boolean isStaff() {
        return this.level >= JR_HELPER.level;
    }

    public boolean isDefaultPermission() {
        return this == DEFAULT;
    }

    public String getFormattedRank() {
        return prefix;
    }


}
