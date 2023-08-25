package me.godspunky.skyblock.features.launchpads;

import lombok.Getter;

import lombok.Setter;
import org.bukkit.Location;

@Getter
public class PadGenerator {

    @Setter
    private String start;

    @Setter
    private String end;
    @Setter
    private Location startLocation;
    @Setter
    private Location endLocation;

    @Setter
    private Location teleportLocation;


    @Setter
    private int phase;

    public PadGenerator(String start, String end) {
        this.start = start;
        this.end = end;
        this.phase = 1;
    }
}
