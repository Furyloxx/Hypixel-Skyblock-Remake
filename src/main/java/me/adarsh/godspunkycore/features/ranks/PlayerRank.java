package me.adarsh.godspunkycore.features.ranks;

public enum PlayerRank {
    DEFAULT("skyblock.player", "&7", 1),
    VIP("skyblock.vip", "&a[VIP]", 2),
    VIPPLUS("skyblock.vipp", "&a[VIP&6+&a]", 3),
    MVP("skyblock.mvp", "&b[MVP]", 4),
    MVPPLUS("skyblock.mvpp", "&b[MVP&c+&b]", 5),
    MVPPLUSPLUS("skyblock.mvppp", "&6[MVP&c++&6]", 6),
    YOUTUBE("skyblock.yt", "&c[&fYOUTUBE&c]", 7),
    BETA("skyblock.beta", "&d[BT]", 8),
    SPECIAL("skyblock.special", "&e[SPECIAL]", 9),
    JRHELPER("skyblock.jrhelper", "&9[JR HELPER]", 10),
    HELPER("skyblock.helper", "&9[HELPER]", 11),
    MOD("skyblock.mod", "&2[MOD]", 12),
    GAMEMASTER("skyblock.gm", "&2[GM]", 13),
    BUILD("skyblock.build", "&3[BUILD TEAM]", 14),
    ADMIN("skyblock.admin", "&c[ADMIN]", 15),
    OWNER("skyblock.owner", "&c[OWNER]", 16);

    private final String permission;
    private final String prefix;
    private final int level;

    PlayerRank(String permission, String prefix, int level) {
        this.permission = permission;
        this.prefix = prefix;
        this.level = level;
    }

    public String getPermission() {
        return permission;
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
        return this.level >= HELPER.level;
    }

    public boolean isDefaultPermission() {
        return isAboveOrEqual(DEFAULT);
    }


}
