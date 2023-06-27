package me.adarsh.godspunkycore.features.item.mining;

import me.adarsh.godspunkycore.features.item.ExperienceRewardStatistics;
import me.adarsh.godspunkycore.features.item.GenericItemType;
import me.adarsh.godspunkycore.features.item.MaterialFunction;
import me.adarsh.godspunkycore.features.item.Rarity;
import me.adarsh.godspunkycore.features.skill.MiningSkill;
import me.adarsh.godspunkycore.features.skill.Skill;

public class DiamondOre implements ExperienceRewardStatistics, MaterialFunction {
    @Override
    public double getRewardXP() {
        return 10.0;
    }

    @Override
    public Skill getRewardedSkill() {
        return MiningSkill.INSTANCE;
    }

    @Override
    public String getDisplayName() {
        return "Diamond Ore";
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