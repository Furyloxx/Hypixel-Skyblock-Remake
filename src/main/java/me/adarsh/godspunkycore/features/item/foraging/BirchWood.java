package me.adarsh.godspunkycore.features.item.foraging;

import me.adarsh.godspunkycore.features.item.ExperienceRewardStatistics;
import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.skill.ForagingSkill;
import me.adarsh.godspunkycore.features.skill.Skill;

public class BirchWood implements ExperienceRewardStatistics, MaterialFunction {
    @Override
    public double getRewardXP() {
        return 6.0;
    }

    @Override
    public Skill getRewardedSkill() {
        return ForagingSkill.INSTANCE;
    }

    @Override
    public String getDisplayName() {
        return "Birch Wood";
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