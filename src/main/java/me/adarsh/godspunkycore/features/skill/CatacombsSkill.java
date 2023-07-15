package me.adarsh.godspunkycore.features.skill;

import me.adarsh.godspunkycore.user.User;
import me.adarsh.godspunkycore.util.SUtil;
import me.adarsh.godspunkycore.util.Sputnik;

import java.util.Arrays;
import java.util.List;

public class CatacombsSkill extends Skill
{
    public static final CatacombsSkill INSTANCE;

    @Override
    public String getName() {
        return "The Catacombs";
    }

    @Override
    public String getAlternativeName() {
        return "{skip}";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("Complete this dungeon to earn", "experience and unlock new", "rewards!");
    }

    @Override
    public List<String> getLevelUpInformation(final int level, final int lastLevel, final boolean showOld) {
        return Arrays.asList(Sputnik.trans("&7Level " + SUtil.toRomanNumeral(level) + ": &7Increasing the stats"), Sputnik.trans("&7of your Dungeon items by"), Sputnik.trans("&c" + level * 5 + "% &7while in &cThe"), Sputnik.trans("&cCatacombs&7."));
    }

    @Override
    public boolean hasSixtyLevels() {
        return false;
    }

    @Override
    public void onSkillUpdate(final User user, final double previousXP) {
        super.onSkillUpdate(user, previousXP);
    }

    static {
        INSTANCE = new CatacombsSkill();
    }
}
