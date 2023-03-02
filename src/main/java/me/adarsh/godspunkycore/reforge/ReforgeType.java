package me.adarsh.godspunkycore.reforge;

import lombok.Getter;
import me.adarsh.godspunkycore.reforge.armor.*;
import me.adarsh.godspunkycore.reforge.ranged_weapon.RapidReforge;
import me.adarsh.godspunkycore.reforge.weapon.*;

public enum ReforgeType {
    SPICY(SpicyReforge.class),
    FIERCE(FierceReforge.class),
    HEROIC(HeroicReforge.class),
    ODD(OddReforge.class),
    RAPID(RapidReforge.class),
    EPIC(EpicReforge.class),
    FAIR(FairReforge.class),
    GENTLE(GentleReforge.class),
    LEGENDARY(LegendaryReforge.class),
    SHARP(SharpReforge.class),
    CLEAN(CleanReforge.class),
    HEAVY(HeavyReforge.class),
    LIGHT(LightReforge.class),
    MYTHIC(MythicReforge.class),
    PURE(PureReforge.class),
    SMART(SmartReforge.class),
    TITANIC(TitanicReforge.class),
    WISE(WiseReforge.class);


    private final Class<? extends Reforge> clazz;
    @Getter
    private final boolean accessible;

    ReforgeType(Class<? extends Reforge> clazz, boolean accessible) {
        this.clazz = clazz;
        this.accessible = accessible;
    }

    ReforgeType(Class<? extends Reforge> clazz) {
        this(clazz, true);
    }

    public Reforge getReforge() {
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ReforgeType getReforgeType(String name) {
        return valueOf(name.toUpperCase());
    }

    public static ReforgeType getByClass(Class<? extends Reforge> clazz) {
        for (ReforgeType type : values()) {
            if (type.clazz == clazz)
                return type;
        }
        return null;
    }
}