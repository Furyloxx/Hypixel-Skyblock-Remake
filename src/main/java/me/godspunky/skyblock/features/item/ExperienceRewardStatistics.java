package me.godspunky.skyblock.features.item;

import me.godspunky.skyblock.features.skill.Skill;

public interface ExperienceRewardStatistics extends MaterialStatistics {
    double getRewardXP();

    Skill getRewardedSkill();
}
