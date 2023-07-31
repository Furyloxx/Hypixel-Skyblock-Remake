package me.godspunky.skyblock.features.item.mining;

import me.godspunky.skyblock.features.item.ExperienceRewardStatistics;
import me.godspunky.skyblock.features.item.GenericItemType;
import me.godspunky.skyblock.features.item.MaterialFunction;
import me.godspunky.skyblock.features.item.Rarity;
import me.godspunky.skyblock.features.skill.MiningSkill;
import me.godspunky.skyblock.features.skill.Skill;

public class EmeraldOre implements ExperienceRewardStatistics, MaterialFunction {
    @Override
    public double getRewardXP() {
        return 9.0;
    }

    @Override
    public Skill getRewardedSkill() {
        return MiningSkill.INSTANCE;
    }

    @Override
    public String getDisplayName() {
        return "Emerald Ore";
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