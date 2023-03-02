package me.adarsh.godspunkycore.item;

import me.adarsh.godspunkycore.skill.Skill;

public interface ExperienceRewardStatistics extends MaterialStatistics {
    double getRewardXP();

    Skill getRewardedSkill();
}
