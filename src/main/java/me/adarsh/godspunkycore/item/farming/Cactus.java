package me.adarsh.godspunkycore.item.farming;

import me.adarsh.godspunkycore.item.ExperienceRewardStatistics;
import me.adarsh.godspunkycore.item.GenericItemType;
import me.adarsh.godspunkycore.item.MaterialFunction;
import me.adarsh.godspunkycore.item.Rarity;
import me.adarsh.godspunkycore.skill.FarmingSkill;
import me.adarsh.godspunkycore.skill.Skill;

public class Cactus implements ExperienceRewardStatistics, MaterialFunction
{
    @Override
    public double getRewardXP()
    {
        return 2.0;
    }

    @Override
    public Skill getRewardedSkill()
    {
        return FarmingSkill.INSTANCE;
    }

    @Override
    public String getDisplayName()
    {
        return "Cactus";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ITEM;
    }
}