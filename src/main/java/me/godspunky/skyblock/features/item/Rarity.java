package me.godspunky.skyblock.features.item;

import lombok.Getter;
import org.bukkit.ChatColor;

public enum Rarity {
    COMMON(ChatColor.WHITE),
    UNCOMMON(ChatColor.GREEN),
    RARE(ChatColor.BLUE),
    EPIC(ChatColor.DARK_PURPLE),
    LEGENDARY(ChatColor.GOLD),
    MYTHIC(ChatColor.LIGHT_PURPLE),
    SUPREME(ChatColor.DARK_RED),
    SPECIAL(ChatColor.RED),
    VERY_SPECIAL(ChatColor.RED),
    DIVINE(ChatColor.AQUA),
    EXCLUSIVE(ChatColor.GRAY),
    ADMIN(ChatColor.DARK_RED);

    @Getter
    private final ChatColor color;

    Rarity(ChatColor color) {
        this.color = color;
    }

    public Rarity upgrade() {
        int nextOrdinal = this.ordinal() + 1;
        if (nextOrdinal < values().length) {
            return values()[nextOrdinal];
        }
        return this;
    }

    public Rarity downgrade() {
        int prevOrdinal = this.ordinal() - 1;
        if (prevOrdinal >= 0) {
            return values()[prevOrdinal];
        }
        return this;
    }

    public boolean isAtLeast(Rarity rarity) {
        return this.ordinal() >= rarity.ordinal();
    }

    public String getDisplay() {
        return color + "" + ChatColor.BOLD + name().replace("_", " ");
    }

    public String getBoldedColor() {
        return "" + color + ChatColor.BOLD;
    }

    public static Rarity getRarity(String string) {
        try {
            return Rarity.valueOf(string.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return null;
        }
    }
}
