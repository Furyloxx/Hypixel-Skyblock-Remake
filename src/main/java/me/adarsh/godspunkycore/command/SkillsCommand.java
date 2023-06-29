package me.adarsh.godspunkycore.command;

import me.adarsh.godspunkycore.features.ranks.PlayerRank;
import me.adarsh.godspunkycore.features.skill.Skill;
import org.bukkit.command.ConsoleCommandSender;

@CommandParameters(description = "Shows your skills.", aliases = "skill", permission = PlayerRank.ADMIN)
public class SkillsCommand extends SCommand {
    @Override
    public void run(CommandSource sender, String[] args) {
        if (args.length != 0) throw new CommandArgumentException();
        if (sender instanceof ConsoleCommandSender)
            throw new CommandFailException("Console senders cannot use this command!");
        send("Skills:");
        for (Skill skill : Skill.getSkills())
            send(" - " + skill.getName() + ": LVL " + Skill.getLevel(sender.getUser().getSkillXP(skill), skill.hasSixtyLevels()) + ", " + sender.getUser().getSkillXP(skill) + " XP");
    }
}
