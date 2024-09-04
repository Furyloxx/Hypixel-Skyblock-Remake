package me.godspunky.skyblock.features.item.accessory;

import me.godspunky.skyblock.features.item.*;
import java.util.List;
import java.util.Arrays;

public class SlothHatOfCelebration implements AccessoryStatistics
{
    @Override
    public String getDisplayName() {
        return "Sloth Hat of Celebration";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.SPECIAL;
    }

    @Override
    public double getBaseMagicFind() {
        return 0.01;
    }

    @Override
    public List<String> getListLore() {
        return (List<String>)Arrays.asList((Object[])new String[] { Sputnik.trans4("&6Ability: Party Time", "&7Gain &b+1 Intelligence&7 while", "&7on your head for each SkyBlock", "&7year you've been playing.") });
    }

    @Override
    public String getURL() {
        return "70bfaf5ab3f817fbed7263fc1c150b571f01b2f7ef17bc579610a495bc4cfee9";
    }
}
