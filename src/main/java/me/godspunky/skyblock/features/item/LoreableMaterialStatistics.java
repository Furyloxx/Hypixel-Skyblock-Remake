package me.godspunky.skyblock.features.item;

import java.util.List;

public interface LoreableMaterialStatistics extends MaterialStatistics {
    List<String> getCustomLore(SItem instance);
}
