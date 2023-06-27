package me.adarsh.godspunkycore.features.item.farming;

import me.adarsh.godspunkycore.features.item.ExperienceRewardStatistics;
import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.skill.FarmingSkill;
import me.adarsh.godspunkycore.features.skill.Skill;

public class WheatSeeds implements ExperienceRewardStatistics, MaterialFunction {
    @Override
    public double getRewardXP() {
        return 1.0;
    }

    @Override
    public Skill getRewardedSkill() {
        return FarmingSkill.INSTANCE;
    }

    @Override
    public String getDisplayName() {
        return "Wheat Seeds";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }
}