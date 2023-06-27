package me.adarsh.godspunkycore.features.item;

import me.adarsh.godspunkycore.features.skill.Skill;

public interface ExperienceRewardStatistics extends MaterialStatistics {
    double getRewardXP();

    Skill getRewardedSkill();
}
