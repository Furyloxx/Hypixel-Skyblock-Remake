package me.adarsh.godspunkycore.item;

import java.util.List;

public interface LoreableMaterialStatistics extends MaterialStatistics {
    List<String> getCustomLore(SItem instance);
}
