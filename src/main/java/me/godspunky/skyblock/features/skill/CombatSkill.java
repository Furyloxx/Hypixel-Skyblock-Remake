package me.godspunky.skyblock.features.skill;

import me.godspunky.skyblock.user.PlayerStatistic;
import me.godspunky.skyblock.user.PlayerStatistics;
import me.godspunky.skyblock.user.PlayerUtils;
import me.godspunky.skyblock.user.User;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public class CombatSkill extends Skill {
    public static final CombatSkill INSTANCE = new CombatSkill();

    @Override
    public String getName() {
        return "Combat";
    }

    @Override
    public String getAlternativeName() {
        return "Warrior";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("Fight mobs and players to earn", "Combat XP!");
    }

    @Override
    public List<String> getLevelUpInformation(int level, int lastLevel, boolean showOld) {
        return Arrays.asList(ChatColor.WHITE + " Deal " + (showOld ? ChatColor.DARK_GRAY + "" + lastLevel * 4 + "➜" : "") +
                        ChatColor.GREEN + level * 4 + "% " + ChatColor.WHITE +
                        "more damage to mobs.",
                ChatColor.DARK_GRAY + "+" + ChatColor.GREEN + "0.5% " + ChatColor.BLUE + "☣ Crit Chance");
    }

    @Override
    public boolean hasSixtyLevels() {
        return false;
    }

    @Override
    public void onSkillUpdate(User user, double previousXP) {
        super.onSkillUpdate(user, previousXP);
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(user.getUuid());
        statistics.zeroAll(PlayerStatistic.COMBAT);
        statistics.getCritChance().set(PlayerStatistic.COMBAT, 0.005 * getLevel(user.getCombatXP(), false));
    }
}