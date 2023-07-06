package me.adarsh.godspunkycore.features.wardrobe.GUI;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.wardrobe.Work.GUIWork;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class WardrobeGUI {

	public static String Ver = Bukkit.getServer().getVersion();
	
	public static Inventory Page1;
	public static Inventory Page2;
	public static String Page1Name = "";
	public static String Page2Name = "";

// Create GUI
	@SuppressWarnings("deprecation")
	public static void CreateWardrobePage1(Player p) {
		String Name = ChatColor.translateAlternateColorCodes('&', Skyblock.getPlugin().getConfig().getString("Title")) + " (1/2)";
		Inventory WardrobePage1 = Bukkit.createInventory(p, 54, Name);
		Page1Name = Name;
	// Create Background
		ItemStack Background = new ItemStack(Material.DIRT);
		ItemMeta BackgroundMeta = Background.getItemMeta();
		if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
			String Mat = "STAINED_GLASS_PANE";
			Background.setType(Material.valueOf(Mat));
			Background.setDurability((short) 15);
		}
		else if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
			String Mat = "BLACK_STAINED_GLASS_PANE";
			Background.setType(Material.valueOf(Mat));
		}
		BackgroundMeta.setDisplayName(" ");
		Background.setItemMeta(BackgroundMeta);
		for (int i = 45; i <= 53; i++) {
			WardrobePage1.setItem(i, Background);
		}
	// Create Go Back and Close Button
		CreateGoBackAndCloseButton(WardrobePage1);
	// Create Change Page Button
		Page1 = WardrobePage1;
		CreateNextAndPreviousButton(WardrobePage1);
	// Create Base Background
		CreateBaseBackground(WardrobePage1);
	// Create AvailableSlot
		CreateAvaiableSlotBackground(WardrobePage1, Name, p);
	// Check Button
		for (int i = 36; i <= 44; i++) {
			String ButtonCheck = "";
			if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
				ButtonCheck = WardrobePage1.getItem(i).getData().toString();
			}
			if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
				ButtonCheck = WardrobePage1.getItem(i).getType().toString();
			}
			if (ButtonCheck.contains("PINK_DYE") || ButtonCheck.contains("PINK DYE")) {
				String CheckSlot1 = WardrobePage1.getItem(i-36).getType().toString();
				String CheckSlot2 = WardrobePage1.getItem(i-27).getType().toString();
				String CheckSlot3 = WardrobePage1.getItem(i-18).getType().toString();
				String CheckSlot4 = WardrobePage1.getItem(i-9).getType().toString();
				if (CheckSlot1.contains("STAINED_GLASS_PANE") && CheckSlot2.contains("STAINED_GLASS_PANE") && CheckSlot3.contains("STAINED_GLASS_PANE") && CheckSlot4.contains("STAINED_GLASS_PANE")) {
					WardrobePage1.setItem(i, WardrobeGUI.CreateEmptyButton(i-36, WardrobePage1, Name));
				}
			} else if (ButtonCheck.contains("LIME_DYE") || ButtonCheck.contains("LIME DYE")) {
				GUIWork.CheckArmor(p, WardrobePage1, i, Name);
			}
		}
	// Check euipped slot page 2
		if (Skyblock.Page_2.getConfig().getConfigurationSection(p.getUniqueId().toString()) != null) {
			for (String Path : Skyblock.Page_2.getConfig().getConfigurationSection(p.getUniqueId().toString()).getKeys(false)) {
				if (Path.contains("name")) continue;
				if (Skyblock.Page_2.getConfig().getString(p.getUniqueId().toString() + "." + Path + ".Button").contains("Equipped")) {
					ItemStack Helmet = p.getInventory().getHelmet();
					ItemStack Chestplate = p.getInventory().getChestplate();
					ItemStack Leggings = p.getInventory().getLeggings();
					ItemStack Boots = p.getInventory().getBoots();
					if (Helmet != null) {
						Skyblock.Page_2.getConfig().set(p.getUniqueId().toString() + "." + Path + ".Helmet", Helmet);
					} else {
						Skyblock.Page_2.getConfig().set(p.getUniqueId().toString() + "." + Path + ".Helmet", "none");
					}
					if (Chestplate != null) {
						Skyblock.Page_2.getConfig().set(p.getUniqueId().toString() + "." + Path + ".Chestplate", Chestplate);
					} else {
						Skyblock.Page_2.getConfig().set(p.getUniqueId().toString() + "." + Path + ".Chestplate", "none");
					}
					if (Leggings != null) {
						Skyblock.Page_2.getConfig().set(p.getUniqueId().toString() + "." + Path + ".Leggings", Leggings);
					} else {
						Skyblock.Page_2.getConfig().set(p.getUniqueId().toString() + "." + Path + ".Leggings", "none");
					}
					if (Boots != null) {
						Skyblock.Page_2.getConfig().set(p.getUniqueId().toString() + "." + Path + ".Boots", Boots);
					} else {
						Skyblock.Page_2.getConfig().set(p.getUniqueId().toString() + "." + Path + ".Boots", "none");
					}
					Skyblock.Page_2.saveConfig();
					Skyblock.Page_2.ReloadConfig();
				}
			}
		}
	// open Wardrobe for player
		p.openInventory(WardrobePage1);
	}
	@SuppressWarnings("deprecation")
	public static void CreateWardrobePage2(Player p) {
		String Name = ChatColor.translateAlternateColorCodes('&', Skyblock.getPlugin().getConfig().getString("Title")) + " (2/2)";
		Inventory WardrobePage2 = Bukkit.createInventory(p, 54, Name);
		Page2Name = Name;
	// Create Background
		ItemStack Background = new ItemStack(Material.DIRT);
		ItemMeta BackgroundMeta = Background.getItemMeta();
		if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
			String Mat = "STAINED_GLASS_PANE";
			Background.setType(Material.valueOf(Mat));
			Background.setDurability((short) 15);
		}
		else if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
			String Mat = "BLACK_STAINED_GLASS_PANE";
			Background.setType(Material.valueOf(Mat));
		}
		BackgroundMeta.setDisplayName(" ");
		Background.setItemMeta(BackgroundMeta);
		for (int i = 45; i <= 53; i++) {
			WardrobePage2.setItem(i, Background);
		}
	// Create Go Back and Close Button
		CreateGoBackAndCloseButton(WardrobePage2);
	// Create Change Page Button
		Page2 = WardrobePage2;
		CreateNextAndPreviousButton(WardrobePage2);
	// Create Base Background
		CreateBaseBackground(WardrobePage2);
	// Create AvailableSlot
		CreateAvaiableSlotBackground(WardrobePage2, Name, p);
	// Check Button
		for (int i = 36; i <= 44; i++) {
			String ButtonCheck = "";
			if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
				ButtonCheck = WardrobePage2.getItem(i).getData().toString();
			}
			if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
				ButtonCheck = WardrobePage2.getItem(i).getType().toString();
			}
			if (ButtonCheck .contains("PINK_DYE") || ButtonCheck .contains("PINK DYE")) {
				String CheckSlot1 = WardrobePage2.getItem(i-36).getType().toString();
				String CheckSlot2 = WardrobePage2.getItem(i-27).getType().toString();
				String CheckSlot3 = WardrobePage2.getItem(i-18).getType().toString();
				String CheckSlot4 = WardrobePage2.getItem(i-9).getType().toString();
				if (CheckSlot1.contains("STAINED_GLASS_PANE") && CheckSlot2.contains("STAINED_GLASS_PANE") && CheckSlot3.contains("STAINED_GLASS_PANE") && CheckSlot4.contains("STAINED_GLASS_PANE")) {
					WardrobePage2.setItem(i, WardrobeGUI.CreateEmptyButton(i-36, WardrobePage2, Name));
				}
			} else if (ButtonCheck .contains("LIME_DYE") || ButtonCheck .contains("LIME DYE")) {
				GUIWork.CheckArmor(p, WardrobePage2, i, Name);
			}
		}
	// open Wardrobe for player
		p.openInventory(WardrobePage2);
	}

	
	
	
	
	
	
	
// Create Base background
	@SuppressWarnings("deprecation")
	public static void CreateBaseBackground(Inventory inv) {
		if (inv == Page1) {
			ItemStack Background = new ItemStack(Material.DIRT);
			ItemMeta BackgroundMeta = Background.getItemMeta();
			if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
				String Mat = "STAINED_GLASS_PANE";
				Background.setType(Material.valueOf(Mat));
				Background.setDurability((short) 15);
			}
			else if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
				String Mat = "BLACK_STAINED_GLASS_PANE";
				Background.setType(Material.valueOf(Mat));
			}
			for (int i = 0; i <= 44; i++) {
				if (i >= 0 && i <= 8) {
					String Name = Skyblock.getPlugin().getConfig().getString("Locked-Slot.Helmet-Slot.Name").replace("%Slot%", Integer.toString(i+1));
					BackgroundMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Name));
					List<String> BackgroundLore = new ArrayList<String>();
					for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Locked-Slot.Helmet-Slot.Lore")) {
						if (i+1 == 1)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-1.Require-Prefix"));
						if (i+1 == 2)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-2.Require-Prefix"));
						if (i+1 == 3)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-3.Require-Prefix"));
						if (i+1 == 4)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-4.Require-Prefix"));
						if (i+1 == 5)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-5.Require-Prefix"));
						if (i+1 == 6)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-6.Require-Prefix"));
						if (i+1 == 7)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-7.Require-Prefix"));
						if (i+1 == 8)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-8.Require-Prefix"));
						if (i+1 == 9)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-9.Require-Prefix"));
						BackgroundLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
					}
					BackgroundMeta.setLore(BackgroundLore);
					Background.setItemMeta(BackgroundMeta);
					inv.setItem(i, Background);
				} else if (i >= 9 && i <= 17) {
					String Name = Skyblock.getPlugin().getConfig().getString("Locked-Slot.Chestplate-Slot.Name").replace("%Slot%", Integer.toString(i-8));
					BackgroundMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Name));
					List<String> BackgroundLore = new ArrayList<String>();
					for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Locked-Slot.Chestplate-Slot.Lore")) {
						if (i-8 == 1)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-1.Require-Prefix"));
						if (i-8 == 2)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-2.Require-Prefix"));
						if (i-8 == 3)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-3.Require-Prefix"));
						if (i-8 == 4)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-4.Require-Prefix"));
						if (i-8 == 5)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-5.Require-Prefix"));
						if (i-8 == 6)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-6.Require-Prefix"));
						if (i-8 == 7)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-7.Require-Prefix"));
						if (i-8 == 8)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-8.Require-Prefix"));
						if (i-8 == 9)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-9.Require-Prefix"));
						BackgroundLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
					}
					BackgroundMeta.setLore(BackgroundLore);
					Background.setItemMeta(BackgroundMeta);
					inv.setItem(i, Background);
				} else if (i >= 18 && i <= 26) {
					String Name = Skyblock.getPlugin().getConfig().getString("Locked-Slot.Leggings-Slot.Name").replace("%Slot%", Integer.toString(i-17));
					BackgroundMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Name));
					List<String> BackgroundLore = new ArrayList<String>();
					for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Locked-Slot.Leggings-Slot.Lore")) {
						if (i-17 == 1)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-1.Require-Prefix"));
						if (i-17 == 2)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-2.Require-Prefix"));
						if (i-17 == 3)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-3.Require-Prefix"));
						if (i-17 == 4)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-4.Require-Prefix"));
						if (i-17 == 5)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-5.Require-Prefix"));
						if (i-17 == 6)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-6.Require-Prefix"));
						if (i-17 == 7)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-7.Require-Prefix"));
						if (i-17 == 8)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-8.Require-Prefix"));
						if (i-17 == 9)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-9.Require-Prefix"));
						BackgroundLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
					}
					BackgroundMeta.setLore(BackgroundLore);
					Background.setItemMeta(BackgroundMeta);
					inv.setItem(i, Background);
				} else if (i >= 27 && i <= 35) {
					String Name = Skyblock.getPlugin().getConfig().getString("Locked-Slot.Boots-Slot.Name").replace("%Slot%", Integer.toString(i-26));
					BackgroundMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Name));
					List<String> BackgroundLore = new ArrayList<String>();
					for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Locked-Slot.Boots-Slot.Lore")) {
						if (i-26 == 1)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-1.Require-Prefix"));
						if (i-26 == 2)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-2.Require-Prefix"));
						if (i-26 == 3)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-3.Require-Prefix"));
						if (i-26 == 4)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-4.Require-Prefix"));
						if (i-26 == 5)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-5.Require-Prefix"));
						if (i-26 == 6)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-6.Require-Prefix"));
						if (i-26 == 7)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-7.Require-Prefix"));
						if (i-26 == 8)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-8.Require-Prefix"));
						if (i-26 == 9)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-9.Require-Prefix"));
						BackgroundLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
					}
					BackgroundMeta.setLore(BackgroundLore);
					Background.setItemMeta(BackgroundMeta);
					inv.setItem(i, Background);
				} else if (i >= 36 && i <= 44) {
					ItemStack Button = new ItemStack(Material.DIRT);
					ItemMeta ButtonMeta = Button.getItemMeta();
					if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
						String Mat = "INK_SACK";
						Button.setType(Material.valueOf(Mat));
						Button.setDurability((short) 1);
					}
					if (Ver.contains("1.13")) {
						String Mat = "ROSE_RED";
						Button.setType(Material.valueOf(Mat)); 
					}
					if (Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
						String Mat = "RED_DYE";
						Button.setType(Material.valueOf(Mat)); 
					}
					String Name = Skyblock.getPlugin().getConfig().getString("Locked-Slot.Locked-Button.Name").replace("%Slot%", Integer.toString(i-35));
					ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Name));
					List<String> ButtonLore = new ArrayList<String>();
					for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Locked-Slot.Locked-Button.Lore")) {
						if (i-35 == 1)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-1.Require-Prefix"));
						if (i-35 == 2)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-2.Require-Prefix"));
						if (i-35 == 3)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-3.Require-Prefix"));
						if (i-35 == 4)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-4.Require-Prefix"));
						if (i-35 == 5)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-5.Require-Prefix"));
						if (i-35 == 6)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-6.Require-Prefix"));
						if (i-35 == 7)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-7.Require-Prefix"));
						if (i-35 == 8)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-8.Require-Prefix"));
						if (i-35 == 9)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-9.Require-Prefix"));
						ButtonLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
					}
					ButtonMeta.setLore(ButtonLore);
					Button.setItemMeta(ButtonMeta);
					inv.setItem(i, Button);
				}
			}
		} else if (inv == Page2) {
			ItemStack Background = new ItemStack(Material.DIRT);
			ItemMeta BackgroundMeta = Background.getItemMeta();
			if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
				String Mat = "STAINED_GLASS_PANE";
				Background.setType(Material.valueOf(Mat));
				Background.setDurability((short) 15);
			}
			else if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
				String Mat = "BLACK_STAINED_GLASS_PANE";
				Background.setType(Material.valueOf(Mat));
			}
			for (int i = 0; i <= 44; i++) {
				if (i >= 0 && i <= 8) {
					String Name = Skyblock.getPlugin().getConfig().getString("Locked-Slot.Helmet-Slot.Name").replace("%Slot%", Integer.toString(i+10));
					BackgroundMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Name));
					List<String> BackgroundLore = new ArrayList<String>();
					for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Locked-Slot.Helmet-Slot.Lore")) {
						if (i+10 == 10)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-10.Require-Prefix"));
						if (i+10 == 11)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-11.Require-Prefix"));
						if (i+10 == 12)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-12.Require-Prefix"));
						if (i+10 == 13)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-13.Require-Prefix"));
						if (i+10 == 14)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-14.Require-Prefix"));
						if (i+10 == 15)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-15.Require-Prefix"));
						if (i+10 == 16)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-16.Require-Prefix"));
						if (i+10 == 17)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-17.Require-Prefix"));
						if (i+10 == 18)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-18.Require-Prefix"));
						BackgroundLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
					}
					BackgroundMeta.setLore(BackgroundLore);
					Background.setItemMeta(BackgroundMeta);
					inv.setItem(i, Background);
				} else if (i >= 9 && i <= 17) {
					String Name = Skyblock.getPlugin().getConfig().getString("Locked-Slot.Chestplate-Slot.Name").replace("%Slot%", Integer.toString(i+1));
					BackgroundMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Name));
					List<String> BackgroundLore = new ArrayList<String>();
					for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Locked-Slot.Chestplate-Slot.Lore")) {
						if (i+1 == 10)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-10.Require-Prefix"));
						if (i+1 == 11)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-11.Require-Prefix"));
						if (i+1 == 12)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-12.Require-Prefix"));
						if (i+1 == 13)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-13.Require-Prefix"));
						if (i+1 == 14)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-14.Require-Prefix"));
						if (i+1 == 15)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-15.Require-Prefix"));
						if (i+1 == 16)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-16.Require-Prefix"));
						if (i+1 == 17)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-17.Require-Prefix"));
						if (i+1 == 18)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-18.Require-Prefix"));
						BackgroundLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
					}
					BackgroundMeta.setLore(BackgroundLore);
					Background.setItemMeta(BackgroundMeta);
					inv.setItem(i, Background);
				} else if (i >= 18 && i <= 26) {
					String Name = Skyblock.getPlugin().getConfig().getString("Locked-Slot.Leggings-Slot.Name").replace("%Slot%", Integer.toString(i-8));
					BackgroundMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Name));
					List<String> BackgroundLore = new ArrayList<String>();
					for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Locked-Slot.Leggings-Slot.Lore")) {
						if (i-8 == 10)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-10.Require-Prefix"));
						if (i-8 == 11)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-11.Require-Prefix"));
						if (i-8 == 12)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-12.Require-Prefix"));
						if (i-8 == 13)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-13.Require-Prefix"));
						if (i-8 == 14)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-14.Require-Prefix"));
						if (i-8 == 15)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-15.Require-Prefix"));
						if (i-8 == 16)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-16.Require-Prefix"));
						if (i-8 == 17)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-17.Require-Prefix"));
						if (i-8 == 18)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-18.Require-Prefix"));
						BackgroundLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
					}
					BackgroundMeta.setLore(BackgroundLore);
					Background.setItemMeta(BackgroundMeta);
					inv.setItem(i, Background);
				} else if (i >= 27 && i <= 35) {
					String Name = Skyblock.getPlugin().getConfig().getString("Locked-Slot.Boots-Slot.Name").replace("%Slot%", Integer.toString(i-17));
					BackgroundMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Name));
					List<String> BackgroundLore = new ArrayList<String>();
					for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Locked-Slot.Boots-Slot.Lore")) {
						if (i-17 == 10)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-10.Require-Prefix"));
						if (i-17 == 11)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-11.Require-Prefix"));
						if (i-17 == 12)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-12.Require-Prefix"));
						if (i-17 == 13)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-13.Require-Prefix"));
						if (i-17 == 14)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-14.Require-Prefix"));
						if (i-17 == 15)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-15.Require-Prefix"));
						if (i-17 == 16)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-16.Require-Prefix"));
						if (i-17 == 17)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-17.Require-Prefix"));
						if (i-17 == 18)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-18.Require-Prefix"));
						BackgroundLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
					}
					BackgroundMeta.setLore(BackgroundLore);
					Background.setItemMeta(BackgroundMeta);
					inv.setItem(i, Background);
				} else if (i >= 36 && i <= 44) {
					ItemStack Button = new ItemStack(Material.DIRT);
					ItemMeta ButtonMeta = Button.getItemMeta();
					if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
						String Mat = "INK_SACK";
						Button.setType(Material.valueOf(Mat));
						Button.setDurability((short) 1);
					}
					if (Ver.contains("1.13")) {
						String Mat = "ROSE_RED";
						Button.setType(Material.valueOf(Mat)); 
					}
					if (Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
						String Mat = "RED_DYE";
						Button.setType(Material.valueOf(Mat)); 
					}
					String Name = Skyblock.getPlugin().getConfig().getString("Locked-Slot.Locked-Button.Name").replace("%Slot%", Integer.toString(i-26));
					ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Name));
					List<String> ButtonLore = new ArrayList<String>();
					for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Locked-Slot.Locked-Button.Lore")) {
						if (i-26 == 10)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-10.Require-Prefix"));
						if (i-26 == 11)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-11.Require-Prefix"));
						if (i-26 == 12)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-12.Require-Prefix"));
						if (i-26 == 13)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-13.Require-Prefix"));
						if (i-26 == 14)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-14.Require-Prefix"));
						if (i-26 == 15)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-15.Require-Prefix"));
						if (i-26 == 16)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-16.Require-Prefix"));
						if (i-26 == 17)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-17.Require-Prefix"));
						if (i-26 == 18)
							Lore = Lore.replace("%Permission_Require_Prefix%", Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-18.Require-Prefix"));
						ButtonLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
					}
					ButtonMeta.setLore(ButtonLore);
					Button.setItemMeta(ButtonMeta);
					inv.setItem(i, Button);
				}
			}
		}
	}

	
	
	
	
	
	
	
	
// Create available slot
	public static void CreateAvaiableSlotBackground(Inventory inv, String Name, Player p) {
		if (inv == Page1) {
			for (int i = 0; i <= 8; i++) {
				if (p.hasPermission(Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-" + Integer.toString(i+1) + ".Permission"))) {
					int CheckAmount = 0;
					if (Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Helmet") == null) {
						inv.setItem(i, Background(i, Page1, Name));
						CheckAmount++;
					} else {
						inv.setItem(i, Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Helmet"));
					}
					if (Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Chestplate") == null) {
						inv.setItem(i+9, Background(i+9, Page1, Name));
						CheckAmount++;
					} else {
						inv.setItem(i+9, Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Chestplate"));
					}
					if (Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Leggings") == null) {
						inv.setItem(i+18, Background(i+18, Page1, Name));
						CheckAmount++;
					} else {
						inv.setItem(i+18, Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Leggings"));
					}
					if (Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Boots") == null) {
						inv.setItem(i+27, Background(i+27, Page1, Name));
						CheckAmount++;
					} else {
						inv.setItem(i+27, Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Boots"));
					}
					if (CheckAmount == 4) {
						inv.setItem(i+36, CreateEmptyButton(i, Page1, Name));
					}
					if (Skyblock.Page_1.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Button") != null && Skyblock.Page_1.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Button").contains("Ready")) {
						inv.setItem(i+36, CreateReadyButton(i, Page1, Name));
					} else if (Skyblock.Page_1.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Button") != null && Skyblock.Page_1.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Button").contains("Equipped")) {
						inv.setItem(i+36, CreateEquippedButton(i, Page1, Name));
					}
				} else {
					for (int j = i+11; j <= 18; j++) {
						if (p.hasPermission(Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-" + (j) + ".Permission"))) {
							int CheckAmount = 0;
							for (int x = i; x <= 8; x++) {
								if (Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (x+1) + ".Helmet") == null) {
									inv.setItem(x, Background(x, Page1, Name));
									CheckAmount++;
								} else {
									inv.setItem(x, Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (x+1) + ".Helmet"));
								}
								if (Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (x+1) + ".Chestplate") == null) {
									inv.setItem(x+9, Background(x+9, Page1, Name));
									CheckAmount++;
								} else {
									inv.setItem(x+9, Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (x+1) + ".Chestplate"));
								}
								if (Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (x+1) + ".Leggings") == null) {
									inv.setItem(x+18, Background(x+18, Page1, Name));
									CheckAmount++;
								} else {
									inv.setItem(x+18, Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (x+1) + ".Leggings"));
								}
								if (Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (x+1) + ".Boots") == null) {
									inv.setItem(x+27, Background(x+27, Page1, Name));
									CheckAmount++;
								} else {
									inv.setItem(x+27, Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (x+1) + ".Boots"));
								}
								if (CheckAmount == 4) {
									inv.setItem(i+36, CreateEmptyButton(i, Page1, Name));
								}
								if (Skyblock.Page_1.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Button") != null && Skyblock.Page_1.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Button").contains("Ready")) {
									inv.setItem(i+36, CreateReadyButton(i, Page1, Name));
								} else if (Skyblock.Page_1.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Button") != null && Skyblock.Page_1.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Button").contains("Equipped")) {
									inv.setItem(i+36, CreateEquippedButton(i, Page1, Name));
								}
							}
							return;
						}
					}
					for (int j = i+1; j <= 9; j++) { 
						if (p.hasPermission(Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-" + Integer.toString(j) + ".Permission"))) {
							int CheckAmount = 0;
							if (Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Helmet") == null) {
								inv.setItem(i, Background(i, Page1, Name));
								CheckAmount++;
							} else {
								inv.setItem(i, Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Helmet"));
							}
							if (Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Chestplate") == null) {
								inv.setItem(i+9, Background(i+9, Page1, Name));
								CheckAmount++;
							} else {
								inv.setItem(i+9, Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Chestplate"));
							}
							if (Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Leggings") == null) {
								inv.setItem(i+18, Background(i+18, Page1, Name));
								CheckAmount++;
							} else {
								inv.setItem(i+18, Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Leggings"));
							}
							if (Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Boots") == null) {
								inv.setItem(i+27, Background(i+27, Page1, Name));
								CheckAmount++;
							} else {
								inv.setItem(i+27, Skyblock.Page_1.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Boots"));
							}
							if (CheckAmount == 4) {
								inv.setItem(i+36, CreateEmptyButton(i, Page1, Name));
							}
							if (Skyblock.Page_1.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Button") != null && Skyblock.Page_1.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Button").contains("Ready")) {
								inv.setItem(i+36, CreateReadyButton(i, Page1, Name));
							} else if (Skyblock.Page_1.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Button") != null && Skyblock.Page_1.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+1) + ".Button").contains("Equipped")) {
								inv.setItem(i+36, CreateEquippedButton(i, Page1, Name));
							}
						}
					}
				}
			}
		} else if (inv == Page2) {
			for (int i = 0; i <= 8; i++) {
				if (p.hasPermission(Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-" + (i+10) + ".Permission"))) {
					int CheckAmount = 0;
					if (Skyblock.Page_2.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Helmet") == null) {
						inv.setItem(i, Background(i, Page2, Name));
						CheckAmount++;
					} else {
						inv.setItem(i, Skyblock.Page_2.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Helmet"));
					}
					if (Skyblock.Page_2.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Chestplate") == null) {
						inv.setItem(i+9, Background(i+9, Page2, Name));
						CheckAmount++;
					} else {
						inv.setItem(i+9, Skyblock.Page_2.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Chestplate"));
					}
					if (Skyblock.Page_2.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Leggings") == null) {
						inv.setItem(i+18, Background(i+18, Page2, Name));
						CheckAmount++;
					} else {
						inv.setItem(i+18, Skyblock.Page_2.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Leggings"));
					}
					if (Skyblock.Page_2.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Boots") == null) {
						inv.setItem(i+27, Background(i+27, Page2, Name));
						CheckAmount++;
					} else {
						inv.setItem(i+27, Skyblock.Page_2.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Boots"));
					}
					if (CheckAmount == 4) {
						inv.setItem(i+36, CreateEmptyButton(i, Page2, Name));
					}
					if (Skyblock.Page_2.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Button") != null && Skyblock.Page_2.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Button").contains("Ready")) {
						inv.setItem(i+36, CreateReadyButton(i, Page2, Name));
					} else if (Skyblock.Page_2.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Button") != null && Skyblock.Page_2.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Button").contains("Equipped")) {
						inv.setItem(i+36, CreateEquippedButton(i, Page2, Name));
					}
				} else {
					for (int j = i+11; j <= 18; j++) {
						if (p.hasPermission(Skyblock.getPlugin().getConfig().getString("Slot-Permission.Slot-" + (j) + ".Permission"))) {
							int CheckAmount = 0;
							if (Skyblock.Page_2.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Helmet") == null) {
								inv.setItem(i, Background(i, Page2, Name));
								CheckAmount++;
							} else {
								inv.setItem(i, Skyblock.Page_2.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Helmet"));
							}
							if (Skyblock.Page_2.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Chestplate") == null) {
								inv.setItem(i+9, Background(i+9, Page2, Name));
								CheckAmount++;
							} else {
								inv.setItem(i+9, Skyblock.Page_2.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Chestplate"));
							}
							if (Skyblock.Page_2.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Leggings") == null) {
								inv.setItem(i+18, Background(i+18, Page2, Name));
								CheckAmount++;
							} else {
								inv.setItem(i+18, Skyblock.Page_2.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Leggings"));
							}
							if (Skyblock.Page_2.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Boots") == null) {
								inv.setItem(i+27, Background(i+27, Page2, Name));
								CheckAmount++;
							} else {
								inv.setItem(i+27, Skyblock.Page_2.getConfig().getItemStack(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Boots"));
							}
							if (CheckAmount == 4) {
								inv.setItem(i+36, CreateEmptyButton(i, Page2, Name));
							}
							if (Skyblock.Page_2.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Button") != null && Skyblock.Page_2.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Button").contains("Ready")) {
								inv.setItem(i+36, CreateReadyButton(i, Page2, Name));
							} else if (Skyblock.Page_2.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Button") != null && Skyblock.Page_2.getConfig().getString(p.getUniqueId().toString() + ".Slot-" + (i+10) + ".Button").contains("Equipped")) {
								inv.setItem(i+36, CreateEquippedButton(i, Page2, Name));
							}
						}
					}
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static ItemStack Background(int Slot, Inventory inv, String Title) {
		ItemStack AvailableBackground = new ItemStack(Material.DIRT);
		ItemMeta AvailableBackgroundMeta = AvailableBackground.getItemMeta();
		String Mat = "";
		if (Slot == 0 || Slot - 9 == 0 || Slot - 18 == 0 || Slot - 27 == 0) {
			if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
				Mat = "STAINED_GLASS_PANE";
				AvailableBackground.setType(Material.valueOf(Mat));
				AvailableBackground.setDurability((short) 14);
			} else if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
				Mat = "RED_STAINED_GLASS_PANE";
				AvailableBackground.setType(Material.valueOf(Mat));
			}
		} else if (Slot == 1 || Slot - 9 == 1 || Slot - 18 == 1  || Slot - 27 == 1) {
			if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
				Mat = "STAINED_GLASS_PANE";
				AvailableBackground.setType(Material.valueOf(Mat));
				AvailableBackground.setDurability((short) 1);
			}
			if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
				Mat = "ORANGE_STAINED_GLASS_PANE";
				AvailableBackground.setType(Material.valueOf(Mat));
			}
		} else if (Slot == 2 || Slot - 9 == 2 || Slot - 18 == 2 || Slot - 27 == 2) {
			if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
				Mat = "STAINED_GLASS_PANE";
				AvailableBackground.setType(Material.valueOf(Mat));
				AvailableBackground.setDurability((short) 4);
			}
			if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
				Mat = "YELLOW_STAINED_GLASS_PANE";
				AvailableBackground.setType(Material.valueOf(Mat));
			}
		} else if (Slot == 3 || Slot - 9 == 3 || Slot - 18 == 3 || Slot - 27 == 3) {
			if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
				Mat = "STAINED_GLASS_PANE";
				AvailableBackground.setType(Material.valueOf(Mat));
				AvailableBackground.setDurability((short) 5);
			}
			if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
				Mat = "LIME_STAINED_GLASS_PANE";
				AvailableBackground.setType(Material.valueOf(Mat));
			}
		} else if (Slot == 4 || Slot - 9 == 4 || Slot - 18 == 4 || Slot - 27 == 4) {
			if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
				Mat = "STAINED_GLASS_PANE";
				AvailableBackground.setType(Material.valueOf(Mat));
				AvailableBackground.setDurability((short) 13);
			}
			if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
				Mat = "GREEN_STAINED_GLASS_PANE";
				AvailableBackground.setType(Material.valueOf(Mat));
			}
		} else if (Slot == 5 || Slot - 9 == 5 || Slot - 18 == 5 || Slot - 27 == 5) {
			if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
				Mat = "STAINED_GLASS_PANE";
				AvailableBackground.setType(Material.valueOf(Mat));
				AvailableBackground.setDurability((short) 4);
			}
			if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
				Mat = "LIGHT_BLUE_STAINED_GLASS_PANE";
				AvailableBackground.setType(Material.valueOf(Mat));
			}
		} else if (Slot == 6 || Slot - 9 == 6 || Slot - 18 == 6 || Slot - 27 == 6) {
			if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
				Mat = "STAINED_GLASS_PANE";
				AvailableBackground.setType(Material.valueOf(Mat));
				AvailableBackground.setDurability((short) 11);
			}
			if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
				Mat = "BLUE_STAINED_GLASS_PANE";
				AvailableBackground.setType(Material.valueOf(Mat));
			}
		} else if (Slot == 7 || Slot - 9 == 7 || Slot - 18 == 7 || Slot - 27 == 7) {
			if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
				Mat = "STAINED_GLASS_PANE";
				AvailableBackground.setType(Material.valueOf(Mat));
				AvailableBackground.setDurability((short) 2);
			}
			if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
				Mat = "MAGENTA_STAINED_GLASS_PANE";
				AvailableBackground.setType(Material.valueOf(Mat));
			}
		} else if (Slot == 8 || Slot - 9 == 8 || Slot - 18 == 8 || Slot - 27 == 8) {
			if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
				Mat = "STAINED_GLASS_PANE";
				AvailableBackground.setType(Material.valueOf(Mat));
				AvailableBackground.setDurability((short) 10);
			}
			if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
				Mat = "PURPLE_STAINED_GLASS_PANE";
				AvailableBackground.setType(Material.valueOf(Mat));
			}
		}
		List<String> AvailableBackgroundLore = new ArrayList<String>();
		if (Slot >= 0 && Slot <= 8) {
			String Name = "";
			if (Title.equals(WardrobeGUI.Page1Name)) {
				Name = Skyblock.getPlugin().getConfig().getString("Availabel-Slot.Helmet-Slot.Name").replace("%Slot%", Integer.toString(Slot+1));
			} else if (Title.equals(WardrobeGUI.Page2Name)) {
				Name = Skyblock.getPlugin().getConfig().getString("Availabel-Slot.Helmet-Slot.Name").replace("%Slot%", Integer.toString(Slot+10));
			}
			AvailableBackgroundMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Name));
			for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Availabel-Slot.Helmet-Slot.Lore")) {
				AvailableBackgroundLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
			}
		} else if (Slot >= 9 && Slot <= 17) {
			String Name = "";
			if (Title.equals(WardrobeGUI.Page1Name)) {
				Name = Skyblock.getPlugin().getConfig().getString("Availabel-Slot.Chestplate-Slot.Name").replace("%Slot%", Integer.toString(Slot-8));
			} else if (Title.equals(WardrobeGUI.Page2Name)) {
				Name = Skyblock.getPlugin().getConfig().getString("Availabel-Slot.Chestplate-Slot.Name").replace("%Slot%", Integer.toString(Slot+1));
			}
			AvailableBackgroundMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Name));
			for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Availabel-Slot.Chestplate-Slot.Lore")) {
				AvailableBackgroundLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
			}
		} else if (Slot >= 18 && Slot <= 26) {
			String Name = "";
			if (Title.equals(WardrobeGUI.Page1Name)) {
				Name = Skyblock.getPlugin().getConfig().getString("Availabel-Slot.Leggings-Slot.Name").replace("%Slot%", Integer.toString(Slot-17));
			} else if (Title.equals(WardrobeGUI.Page2Name)) {
				Name = Skyblock.getPlugin().getConfig().getString("Availabel-Slot.Leggings-Slot.Name").replace("%Slot%", Integer.toString(Slot-8));
			}
			AvailableBackgroundMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Name));
			for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Availabel-Slot.Leggings-Slot.Lore")) {
				AvailableBackgroundLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
			}
		} else if (Slot >= 27 && Slot <= 35) {
			String Name = "";
			if (Title.equals(WardrobeGUI.Page1Name)) {
				Name = Skyblock.getPlugin().getConfig().getString("Availabel-Slot.Boots-Slot.Name").replace("%Slot%", Integer.toString(Slot-26));
			} else if (Title.equals(WardrobeGUI.Page2Name)) {
				Name = Skyblock.getPlugin().getConfig().getString("Availabel-Slot.Boots-Slot.Name").replace("%Slot%", Integer.toString(Slot-17));
			}
			AvailableBackgroundMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Name));
			for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Availabel-Slot.Boots-Slot.Lore")) {
				AvailableBackgroundLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
			}
		}
		AvailableBackgroundMeta.setLore(AvailableBackgroundLore);
		AvailableBackground.setItemMeta(AvailableBackgroundMeta);
		return AvailableBackground;
	}
	
	@SuppressWarnings("deprecation")
	public static ItemStack CreateEmptyButton(int Slot, Inventory inv, String Title) {
		ItemStack Button = new ItemStack(Material.DIRT);
		ItemMeta ButtonMeta = Button.getItemMeta();
		if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
			String Mat = "INK_SACK";
			Button.setType(Material.valueOf(Mat));
			Button.setDurability((short) 8);
		}
		if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
			String Mat = "GRAY_DYE";
			Button.setType(Material.valueOf(Mat));
		}
		String Name = "";
		if (Title.contains(WardrobeGUI.Page1Name)) {
			Name = Skyblock.getPlugin().getConfig().getString("Availabel-Slot.Empty-Slot-Button.Name").replace("%Slot%", Integer.toString(Slot+1));
		} else if (Title.contains(WardrobeGUI.Page2Name)) {
			Name = Skyblock.getPlugin().getConfig().getString("Availabel-Slot.Empty-Slot-Button.Name").replace("%Slot%", Integer.toString(Slot+10));
		}
		ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Name));
		List<String> ButtonLore = new ArrayList<String>();
		for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Availabel-Slot.Empty-Slot-Button.Lore")) {
			ButtonLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
		}
		ButtonMeta.setLore(ButtonLore);
		Button.setItemMeta(ButtonMeta);
		return Button;
	}
	@SuppressWarnings("deprecation")
	public static ItemStack CreateReadyButton(int Slot, Inventory inv, String Title) {
		ItemStack Button = new ItemStack(Material.DIRT);
		ItemMeta ButtonMeta = Button.getItemMeta();
		if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
			String Mat = "INK_SACK";
			Button.setType(Material.valueOf(Mat));
			Button.setDurability((short) 9);
		}
		if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
			String Mat = "PINK_DYE";
			Button.setType(Material.valueOf(Mat));
		}
		String Name = "";
		if (Title.contains(WardrobeGUI.Page1Name)) {
			Name = Skyblock.getPlugin().getConfig().getString("Availabel-Slot.Ready-Button.Name").replace("%Slot%", Integer.toString(Slot+1));
		} else if (Title.contains(WardrobeGUI.Page2Name)) {
			Name = Skyblock.getPlugin().getConfig().getString("Availabel-Slot.Ready-Button.Name").replace("%Slot%", Integer.toString(Slot+10));
		}
		ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Name));
		List<String> ButtonLore = new ArrayList<String>();
		for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Availabel-Slot.Ready-Button.Lore")) {
			ButtonLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
		}
		ButtonMeta.setLore(ButtonLore);
		Button.setItemMeta(ButtonMeta);
		return Button;
	}
	@SuppressWarnings("deprecation")
	public static ItemStack CreateEquippedButton(int Slot, Inventory inv, String Title) {
		ItemStack Button = new ItemStack(Material.DIRT);
		ItemMeta ButtonMeta = Button.getItemMeta();
		if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
			String Mat = "INK_SACK";
			Button.setType(Material.valueOf(Mat));
			Button.setDurability((short) 10);
		}
		if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
			String Mat = "LIME_DYE";
			Button.setType(Material.valueOf(Mat));
		}
		String Name = "";
		if (Title.contains(WardrobeGUI.Page1Name)) {
			Name = Skyblock.getPlugin().getConfig().getString("Availabel-Slot.Equipped-Button.Name").replace("%Slot%", Integer.toString(Slot+1));
		} else if (Title.contains(WardrobeGUI.Page2Name)) {
			Name = Skyblock.getPlugin().getConfig().getString("Availabel-Slot.Equipped-Button.Name").replace("%Slot%", Integer.toString(Slot+10));
		}
		ButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Name));
		List<String> ButtonLore = new ArrayList<String>();
		for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Availabel-Slot.Equipped-Button.Lore")) {
			ButtonLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
		}
		ButtonMeta.setLore(ButtonLore);
		Button.setItemMeta(ButtonMeta);
		return Button;
	}
	
	
	
	
	
	
	
// Create Button
	public static void CreateGoBackAndCloseButton(Inventory inv) {
		// Go Back button
		if (Skyblock.getPlugin().getConfig().getBoolean("Go-Back-Button.Enable")) {
			ItemStack GoBack = new ItemStack(Material.ARROW);
			ItemMeta GoBackMeta = GoBack.getItemMeta();
			GoBackMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Skyblock.getPlugin().getConfig().getString("Go-Back-Button.Name")));
			List<String> GoBackLore = new ArrayList<String>();
			if (Skyblock.getPlugin().getConfig().getStringList("Go-Back-Button.Lore") != null) {
				for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Go-Back-Button.Lore")) {
					GoBackLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
				}
			}
			GoBackMeta.setLore(GoBackLore);
			GoBack.setItemMeta(GoBackMeta);
			inv.setItem(Skyblock.getPlugin().getConfig().getInt("Go-Back-Button.Slot"), GoBack);
		}
	// Close button
		if (Skyblock.getPlugin().getConfig().getBoolean("Close-Button.Enable")) {
			ItemStack Close = new ItemStack(Material.BARRIER);
			ItemMeta CloseMeta = Close.getItemMeta();
			CloseMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Skyblock.getPlugin().getConfig().getString("Close-Button.Name")));
			List<String> CloseLore = new ArrayList<String>();
			for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Close-Button.Lore")) {
				CloseLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
			}
			CloseMeta.setLore(CloseLore);
			Close.setItemMeta(CloseMeta);
			inv.setItem(Skyblock.getPlugin().getConfig().getInt("Close-Button.Slot"), Close);
		}
	}
	public static void CreateNextAndPreviousButton(Inventory inv) {
		if (inv == Page1) {
			if (Skyblock.getPlugin().getConfig().getBoolean("Next-Page-Button.Enable")) {
				ItemStack NextPage = new ItemStack(Material.ARROW);
				ItemMeta NextPageMeta = NextPage.getItemMeta();
				NextPageMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Skyblock.getPlugin().getConfig().getString("Next-Page-Button.Name")));
				List<String> NextPageLore = new ArrayList<String>();
				if (Skyblock.getPlugin().getConfig().getStringList("Next-Page-Button.Lore") != null) {
					for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Next-Page-Button.Lore")) {
						NextPageLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
					}
				}
				NextPageMeta.setLore(NextPageLore);
				NextPage.setItemMeta(NextPageMeta);
				inv.setItem(Skyblock.getPlugin().getConfig().getInt("Next-Page-Button.Slot"), NextPage);
			}
		} else if (inv == Page2) {
			if (Skyblock.getPlugin().getConfig().getBoolean("Previous-Page-Button.Enable")) {
				ItemStack PreviousPage = new ItemStack(Material.ARROW);
				ItemMeta PreviousPageMeta = PreviousPage.getItemMeta();
				PreviousPageMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', Skyblock.getPlugin().getConfig().getString("Previous-Page-Button.Name")));
				List<String> PreviousPageLore = new ArrayList<String>();
				if (Skyblock.getPlugin().getConfig().getStringList("Previous-Page-Button.Lore") != null) {
					for (String Lore : Skyblock.getPlugin().getConfig().getStringList("Previous-Page-Button.Lore")) {
						PreviousPageLore.add(ChatColor.translateAlternateColorCodes('&', Lore));
					}
				}
				PreviousPageMeta.setLore(PreviousPageLore);
				PreviousPage.setItemMeta(PreviousPageMeta);
				inv.setItem(Skyblock.getPlugin().getConfig().getInt("Previous-Page-Button.Slot"), PreviousPage);
			}
		}
	}
}
