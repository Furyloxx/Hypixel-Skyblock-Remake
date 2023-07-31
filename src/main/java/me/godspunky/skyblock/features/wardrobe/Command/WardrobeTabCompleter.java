package me.godspunky.skyblock.features.wardrobe.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class WardrobeTabCompleter implements TabCompleter {

	List<String> arguments = new ArrayList<String>();
	
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			List<String> result = new ArrayList<String>();
			if (args.length == 1) {
				arguments.clear();
				result.clear();
				arguments.add("reload");
				arguments.add("open");
				arguments.add("reset");
				for (String a : arguments) {
					if (a.toLowerCase().startsWith(args[0].toLowerCase()))
						result.add(a);
				}
				return result;
			} else if (args.length == 2) {
				if (args[0].equalsIgnoreCase("reload")) {
					result.clear();
					return result;
				} else if (args[0].equalsIgnoreCase("open") || args[0].equalsIgnoreCase("reset")) {
					arguments.clear();
					result.clear();
					for(Player player : Bukkit.getOnlinePlayers()) {
						String player1 = player.getName().toString();
						arguments.add(player1);
					}
					for (String a : arguments) {
						if (a.toLowerCase().startsWith(args[1]))
							result.add(a);
					}
					return result;
				} else {
					result.clear();
					return result;
				}
			} else if (args.length == 3) {
				if (args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("open")) {
					result.clear();
					return result;
				} else if (args[0].equalsIgnoreCase("reset")) {
					arguments.clear();
					result.clear();
					arguments.add("page");
					arguments.add("all");
					arguments.add("slot");
					for (String a : arguments) {
						if (a.toLowerCase().startsWith(args[2].toLowerCase()))
							result.add(a);
					}
					return result;
				} else {
					result.clear();
					return result;
				}
			} else if (args.length == 4) {
				if (args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("open")) {
					result.clear();
					return result;
				} else if (args[0].equalsIgnoreCase("reset")) {
					if (args[2].equalsIgnoreCase("page")) {
						arguments.clear();
						result.clear();
						arguments.add("1");
						arguments.add("2");
						for (String a : arguments) {
							if (a.toLowerCase().startsWith(args[3].toLowerCase()))
								result.add(a);
						}
						return result;
					} else if (args[2].equalsIgnoreCase("slot")) {
						arguments.clear();
						result.clear();
						arguments.add("1");
						arguments.add("2");
						arguments.add("3");
						arguments.add("4");
						arguments.add("5");
						arguments.add("6");
						arguments.add("7");
						arguments.add("8");
						arguments.add("9");
						arguments.add("10");
						arguments.add("11");
						arguments.add("12");
						arguments.add("13");
						arguments.add("14");
						arguments.add("15");
						arguments.add("16");
						arguments.add("17");
						arguments.add("18");
						for (String a : arguments) {
							if (a.toLowerCase().startsWith(args[3].toLowerCase()))
								result.add(a);
						}
						return result;
					} else {
						result.clear();
						return result;
					}
				} else {
					result.clear();
					return result;
				}
			} else if (args.length > 4) {
				result.clear();
				return result;
			}
		}
		Player p = (Player) sender;
		List<String> result = new ArrayList<String>();
		if (p.hasPermission("CustomCrafting.Admin")) {
			if (args.length == 1) {
				arguments.clear();
				result.clear();
				arguments.add("reload");
				arguments.add("open");
				arguments.add("reset");
				arguments.add("check");
				arguments.add("allow");
				for (String a : arguments) {
					if (a.toLowerCase().startsWith(args[0].toLowerCase()))
						result.add(a);
				}
				return result;
			} else if (args.length == 2) {
				if (args[0].equalsIgnoreCase("reload")) {
					result.clear();
					return result;
				} else if (args[0].equalsIgnoreCase("open") || args[0].equalsIgnoreCase("reset") || args[0].equalsIgnoreCase("check")) {
					arguments.clear();
					result.clear();
					for(Player player : Bukkit.getOnlinePlayers()) {
						String player1 = player.getName().toString();
						arguments.add(player1);
					}
					for (String a : arguments) {
						if (a.toLowerCase().startsWith(args[1]))
							result.add(a);
					}
					return result;
				} else if (args[0].equalsIgnoreCase("allow")) {
					arguments.clear();
					result.clear();
					arguments.add("helmet");
					arguments.add("chestplate");
					arguments.add("leggings");
					arguments.add("boots");
					for (String a : arguments) {
						if (a.toLowerCase().startsWith(args[1].toLowerCase()))
							result.add(a);
					}
					return result;
				} else {
					result.clear();
					return result;
				}
			} else if (args.length == 3) {
				if (args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("open")) {
					result.clear();
					return result;
				} else if (args[0].equalsIgnoreCase("reset")) {
					arguments.clear();
					result.clear();
					arguments.add("page");
					arguments.add("all");
					arguments.add("slot");
					for (String a : arguments) {
						if (a.toLowerCase().startsWith(args[2].toLowerCase()))
							result.add(a);
					}
					return result;
				} else {
					result.clear();
					return result;
				}
			} else if (args.length == 4) {
				if (args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("open")) {
					result.clear();
					return result;
				} else if (args[0].equalsIgnoreCase("reset")) {
					if (args[2].equalsIgnoreCase("page")) {
						arguments.clear();
						result.clear();
						arguments.add("1");
						arguments.add("2");
						for (String a : arguments) {
							if (a.toLowerCase().startsWith(args[3].toLowerCase()))
								result.add(a);
						}
						return result;
					} else if (args[2].equalsIgnoreCase("slot")) {
						arguments.clear();
						result.clear();
						arguments.add("1");
						arguments.add("2");
						arguments.add("3");
						arguments.add("4");
						arguments.add("5");
						arguments.add("6");
						arguments.add("7");
						arguments.add("8");
						arguments.add("9");
						arguments.add("10");
						arguments.add("11");
						arguments.add("12");
						arguments.add("13");
						arguments.add("14");
						arguments.add("15");
						arguments.add("16");
						arguments.add("17");
						arguments.add("18");
						for (String a : arguments) {
							if (a.toLowerCase().startsWith(args[3].toLowerCase()))
								result.add(a);
						}
						return result;
					} else {
						result.clear();
						return result;
					}
				} else {
					result.clear();
					return result;
				}
			} else if (args.length > 4) {
				result.clear();
				return result;
			}
		}
		return null;
	}
}
