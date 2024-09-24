package me.godspunky.skyblock.features.item;

import lombok.Getter;

@Getter
public class RarityValue<T> {
    private final T common;
    private final T uncommon;
    private final T rare;
    private final T epic;
    private final T legendary;
    private final T mythic;
    private final T divine;
    private final T special;
    private final T verySpecial;
    private final T admin;
    private final T rest;

    public RarityValue(T common, T uncommon, T rare, T epic, T legendary, T mythic, T divine, T special, T verySpecial, T admin, T rest) {
        this.common = common;
        this.uncommon = uncommon;
        this.rare = rare;
        this.epic = epic;
        this.legendary = legendary;
        this.mythic = mythic;
        this.divine = divine;
        this.special = special;
        this.verySpecial = verySpecial;
        this.admin = admin;
        this.rest = rest;
    }

    public T getForRarity(Rarity rarity) {
        switch (rarity) {
            case COMMON:
                return common;
            case UNCOMMON:
                return uncommon;
            case RARE:
                return rare;
            case EPIC:
                return epic;
            case LEGENDARY:
                return legendary;
            case MYTHIC:
                return mythic;
            case DIVINE:
                return divine;
            case SPECIAL:
                return special;
            case VERY_SPECIAL:
                return verySpecial;
            case ADMIN:
                return admin;
            default:
                return rest;
        }
    }

    public static RarityValue<Integer> zeroInteger() {
        return new RarityValue<>(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public static RarityValue<Double> zeroDouble() {
        return new RarityValue<>(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    }

    public static RarityValue<Integer> singleInteger(Integer i) {
        return new RarityValue<>(i, i, i, i, i, i, i, i, i, i, i);
    }

    public static RarityValue<Double> singleDouble(Double d) {
        return new RarityValue<>(d, d, d, d, d, d, d, d, d, d, d);
    }
}
