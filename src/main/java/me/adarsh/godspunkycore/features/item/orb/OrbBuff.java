package me.adarsh.godspunkycore.features.item.orb;

public interface OrbBuff {
    String getBuffName();

    String getBuffDescription();

    default String getCustomOrbName() {
        return null;
    }
}