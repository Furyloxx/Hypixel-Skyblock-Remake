package me.godspunky.skyblock.features.item.farming;

import me.godspunky.skyblock.features.item.ExperienceRewardStatistics;
import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.skill.FarmingSkill;
import me.godspunky.skyblock.features.skill.Skill;

public class Pumpkin implements ExperienceRewardStatistics, MaterialFunction {
    @Override
    public double getRewardXP() {
        return 4.5;
    }

    @Override
    public Skill getRewardedSkill() {
        return FarmingSkill.INSTANCE;
    }

    @Override
    public String getDisplayName() {
        return "Melon";
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