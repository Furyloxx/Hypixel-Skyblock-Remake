package me.godspunky.skyblock.features.item.oddities;

import me.godspunky.skyblock.features.item.*;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class WhiteGift implements SkullStatistics, MaterialFunction {

    @Override
    public String getURL() {
        return "a5c6944593820d13d7d47db2abcfcbf683bb74a07e1a982db9f32e0a8b5dc466";
    }

    @Override
    public String getDisplayName() {
        return "White Gift";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public String getLore(){
        return ChatColor.GRAY+"Click a stranger while holding! Both players get the rewards!";
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }

}
