package me.godspunky.skyblock.npc;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SkyblockNPCManager {
    private static final Set<SkyblockNPC> SKYBLOCK_NPCS = ConcurrentHashMap.newKeySet();

    public static void registerNPC(SkyblockNPC skyblockNPC){
        if (skyblockNPC != null) {
            SKYBLOCK_NPCS.add(skyblockNPC);
        }
    }

    public static Set<SkyblockNPC> getNPCS(){
        return Collections.unmodifiableSet(SKYBLOCK_NPCS);
    }
}