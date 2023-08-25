package me.godspunky.skyblock.features.launchpads;


import org.bukkit.Location;


public class PadGenerator {


    private String start;


    private String end;

     Location startLocation;

    Location endLocation;


     Location teleportLocation;


    private int phase;

    public PadGenerator(String start, String end) {
        this.start = start;
        this.end = end;
        this.phase = 1;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public void setTeleportLocation(Location teleportLocation) {
        this.teleportLocation = teleportLocation;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public Location getTeleportLocation() {
        return teleportLocation;
    }

    public int getPhase() {
        return phase;
    }
}
