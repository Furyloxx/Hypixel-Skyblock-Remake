package me.godspunky.skyblock.features.wardrobe.Command;

import me.godspunky.skyblock.Skyblock;
import me.godspunky.skyblock.features.wardrobe.GUI.CheckPlayerGUI;
import me.godspunky.skyblock.features.wardrobe.GUI.WardrobeGUI;
import me.godspunky.skyblock.features.wardrobe.Work.DataWork;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WardrobeCommand implements CommandExecutor{

	public Skyblock plugin;
	
	public WardrobeCommand(Skyblock plugin) {
		this.plugin = plugin;
		plugin.getCommand("wardrobe").setExecutor(this);
	}
	
	// wardrobe
	// wardrobe reload
	// wardrobe open
	// wardrobe open <player>
	// wardrobe reset <player> (page 1, page 2, all, Slot 1, 2,.., 18)
	// wardrobe check <player> (page 1,2)
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			if (args.length == 0) {
				Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Please choose a work to do!");
				return true;
			} else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("reload")) {
					Skyblock.getPlugin().reloadConfig();
					Skyblock.Page_1.ReloadConfig();
					Skyblock.Page_2.ReloadConfig();
					Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] Success reloaded config!");
					return true;
				} else {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) { 
						WardrobeGUI.CreateWardrobePage1(target);
						return true;
					} else {
						Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "That player is not online!");
						return false;
					}
				}
			} else if (args.length == 2) {
				if (args[0].equalsIgnoreCase("open")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) { 
						WardrobeGUI.CreateWardrobePage1(target);
						return true;
					} else {
						Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "That player is not online!");
						return false;
					}
			// Suggestion command to /wardrobe reset command
				} else if (args[0].equalsIgnoreCase("reset")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) { 
						Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Please choose a work to do!");
						return true;
					} else {
						Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "That player is not online!");
						return false;
					}
			// Unknown command
				} else {
					Bukkit.getConsoleSender().sendMessage("Unknown command. Type \"/help\" for help.");
					return false;
				}
			} else if (args.length == 3) {
				if (args[0].equalsIgnoreCase("reset")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) { 
					// Suggestion command to /wardrobe reset command
						if (args[2].equalsIgnoreCase("page") || args[2].equalsIgnoreCase("slot")) {
							Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Please choose a number!");
							return false;
					// Reset all of player Wardrobe
						} else if (args[2].equalsIgnoreCase("all")) {
							if (DataWork.ResetAllPlayerWardrobe(target)) {
								Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] Success reset " + ChatColor.GOLD + args[2] + ChatColor.GREEN + " of " + ChatColor.GOLD + args[1] + "'s" + ChatColor.GREEN + " Wardrobe!");
								return true;
							} else {
								Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Something wrong when execute this command!");
								return false;
							}
						} else {
							Bukkit.getConsoleSender().sendMessage("Unknown command. Type \"/help\" for help.");
							return false;
						}
					} else {
						Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "That player is not online!");
						return false;
					}
				} else {
					Bukkit.getConsoleSender().sendMessage("Unknown command. Type \"/help\" for help.");
					return false;
				}
			} else if (args.length == 4) {
				if (args[0].equalsIgnoreCase("reset")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) { 
					// Reset page of player Wardrobe
						if (args[2].equalsIgnoreCase("page")) {
							if (args[3].equalsIgnoreCase("1") || args[3].equalsIgnoreCase("2")) {
								if (DataWork.ResetPagePlayerWardrobe(target, args[3])) {
									Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] Success reset " + ChatColor.GOLD + args[2] + " " + args[3] + ChatColor.GREEN + " of " + ChatColor.GOLD + args[1] + "'s" + ChatColor.GREEN + " Wardrobe!");
									return true;
								} else {
									Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Something wrong when execute this command!");
									return false;
								}
							} else {
								Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Unknown page!");
								return false;
							}
					// Reset slot of player Wardrobe
						} else if (args[2].equalsIgnoreCase("slot")) {
							String Number = args[3];
							if (Integer.valueOf(Number) >= 1 && Integer.valueOf(Number) <= 18) {
								if (DataWork.ResetSlotPlayerWardrobe(target, Number)) {
									Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] Success reset " + ChatColor.GOLD + args[2] + " " + args[3] + ChatColor.GREEN + " of " + ChatColor.GOLD + args[1] + "'s" + ChatColor.GREEN + " Wardrobe!");
									return true;
								} else {
									Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Something wrong when execute this command!");
								}
							} else {
								Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Unknown slot!");
								return false;
							}
						} else {
							Bukkit.getConsoleSender().sendMessage("Unknown command. Type \"/help\" for help.");
							return false;
						}
					} else {
						Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "That player is not online!");
						return false;
					}
				} else {
					Bukkit.getConsoleSender().sendMessage("Unknown command. Type \"/help\" for help.");
					return false;
				}
			}
		}
	// Open command
		Player p = (Player) sender;
		if (args.length == 0) {
			if (CheckPlayerGUI.onOpen && CheckPlayerGUI.Path.contains(p.getUniqueId().toString())) {
				p.sendMessage(ChatColor.RED + "An admin is opening your wardrobe, please wait!");
				return false;
			}
			WardrobeGUI.CreateWardrobePage1(p);
			return true;
		} else if (p.hasPermission(Skyblock.getPlugin().getConfig().getString("Admin-Permission"))) {
			if (args.length == 1) {
			// Reload command
				if (args[0].equalsIgnoreCase("reload")) {
					Skyblock.getPlugin().reloadConfig();
					Skyblock.Page_1.ReloadConfig();
					Skyblock.Page_2.ReloadConfig();
					p.sendMessage(ChatColor.GREEN + "[Wardrobe] Success reloaded config!");
					return true;
			// Open command
				} else if (args[0].equalsIgnoreCase("open")) {
					WardrobeGUI.CreateWardrobePage1(p);
					return true;
			// Suggestion command for /wardrobe reset command
				} else if (args[0].equalsIgnoreCase("reset") || args[0].equalsIgnoreCase("check")) {
					p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Please enter a player name!");
					return false;
			// Unknown command
				} else {
					p.sendMessage("Unknown command. Type \"/help\" for help.");
					return false;
				}
			} else if (args.length == 2) {
			// Open for player
				if (args[0].equalsIgnoreCase("open")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) { 
						WardrobeGUI.CreateWardrobePage1(target);
						return true;
					} else {
						p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "That player is not online!");
						return false;
					}
			// Suggestion command to /wardrobe reset command
				} else if (args[0].equalsIgnoreCase("reset") || args[0].equalsIgnoreCase("check")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) { 
						p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Please choose a work to do!");
						return true;
					} else {
						p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "That player is not online!");
						return false;
					}
			// Unknown command
				} else {
					p.sendMessage("Unknown command. Type \"/help\" for help.");
					return false;
				}
			} else if (args.length == 3) {
				if (args[0].equalsIgnoreCase("reset")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) {
					// Suggestion command to /wardrobe reset command
						if (args[2].equalsIgnoreCase("page") || args[2].equalsIgnoreCase("slot")) {
							p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Please choose a number!");
							return false;
					// Reset all of player Wardrobe
						} else if (args[2].equalsIgnoreCase("all")) {
							if (DataWork.ResetAllPlayerWardrobe(target)) {
								p.sendMessage(ChatColor.GREEN + "[Wardrobe] Success reset " + ChatColor.GOLD + args[2] + ChatColor.GREEN + " of " + ChatColor.GOLD + args[1] + "'s" + ChatColor.GREEN + " Wardrobe!");
								return true;
							} else {
								p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Something wrong when execute this command!");
								return false;
							}
						} else {
							p.sendMessage("Unknown command. Type \"/help\" for help.");
							return false;
						}
					} else {
						p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "That player is not online!");
						return false;
					}
				} else if (args[0].equalsIgnoreCase("check")) {
					String target = args[1];
						if (args[2].equalsIgnoreCase("1") && CheckPlayerGUI.CheckName(target)) {
							CheckPlayerGUI.CheckGUI1(p);
						} else if (args[2].equalsIgnoreCase("2") && CheckPlayerGUI.CheckName(target)) {
							CheckPlayerGUI.CheckGUI2(p);
						} else {
							p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "The player has not opened the Wardrobe yet");
							return false;
						}
						return true;
				} else {
					p.sendMessage("Unknown command. Type \"/help\" for help.");
					return false;
				}
			} else if (args.length == 4) {
				if (args[0].equalsIgnoreCase("reset")) {
					Player target = Bukkit.getPlayer(args[1]);
					if (target != null) { 
					// Reset page of player Wardrobe
						if (args[2].equalsIgnoreCase("page")) {
							if (args[3].equalsIgnoreCase("1") || args[3].equalsIgnoreCase("2")) {
								if (DataWork.ResetPagePlayerWardrobe(target, args[3])) {
									p.sendMessage(ChatColor.GREEN + "[Wardrobe] Success reset " + ChatColor.GOLD + args[2] + " " + args[3] + ChatColor.GREEN + " of " + ChatColor.GOLD + args[1] + "'s" + ChatColor.GREEN + " Wardrobe!");
									return true;
								} else {
									p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Something wrong when execute this command!");
									return false;
								}
							} else {
								p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Unknown page!");
								return false;
							}
					// Reset slot of player Wardrobe
						} else if (args[2].equalsIgnoreCase("slot")) {
							String Number = args[3];
							if (Integer.valueOf(Number) >= 1 && Integer.valueOf(Number) <= 18) {
								if (DataWork.ResetSlotPlayerWardrobe(target, Number)) {
									p.sendMessage(ChatColor.GREEN + "[Wardrobe] Success reset " + ChatColor.GOLD + args[2] + " " + args[3] + ChatColor.GREEN + " of " + ChatColor.GOLD + args[1] + "'s" + ChatColor.GREEN + " Wardrobe!");
									return true;
								} else {
									p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Something wrong when execute this command!");
								}
							} else {
								p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "Unknown slot!");
								return false;
							}
						} else {
							p.sendMessage("Unknown command. Type \"/help\" for help.");
							return false;
						}
					} else {
						p.sendMessage(ChatColor.GREEN + "[Wardrobe] " + ChatColor.RED + "That player is not online!");
						return false;
					}
				} else {
					p.sendMessage("Unknown command. Type \"/help\" for help.");
					return false;
				}
			} else {
				p.sendMessage("Unknown command. Type \"/help\" for help.");
				return false;
			}
		} else if (args.length == 1) {
			if (args[0].equalsIgnoreCase("open")) {
				WardrobeGUI.CreateWardrobePage1(p);
				return true;
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', Skyblock.getPlugin().getConfig().getString("Wardrobe_Message.Permission_Denied")));
				return false;
			}
		} else {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', Skyblock.getPlugin().getConfig().getString("Wardrobe_Message.Permission_Denied")));
			return false;
		}
		return false;
	}
}
