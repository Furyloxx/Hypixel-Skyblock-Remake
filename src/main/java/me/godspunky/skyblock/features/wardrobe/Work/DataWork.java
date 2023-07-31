package me.godspunky.skyblock.features.wardrobe.Work;

import me.godspunky.skyblock.Skyblock;
import org.bukkit.entity.Player;

public class DataWork {

	public static boolean ResetAllPlayerWardrobe(Player p) {
		Skyblock.Page_1.getConfig().set(p.getUniqueId().toString(), null);
		Skyblock.Page_2.getConfig().set(p.getUniqueId().toString(), null);
		Skyblock.Page_1.saveConfig();
		Skyblock.Page_2.saveConfig();
		Skyblock.Page_1.ReloadConfig();
		Skyblock.Page_2.ReloadConfig();
		if (Skyblock.Page_1.getConfig().getConfigurationSection(p.getUniqueId().toString()) == null && Skyblock.Page_2.getConfig().getConfigurationSection(p.getUniqueId().toString()) == null) {
			return true;
		}
		return false;
	}
	
	public static boolean ResetPagePlayerWardrobe(Player p, String Page) {
		if (Page.equalsIgnoreCase("1")) {
			Skyblock.Page_1.getConfig().set(p.getUniqueId().toString(), null);
			Skyblock.Page_1.saveConfig();
			Skyblock.Page_1.ReloadConfig();
			if (Skyblock.Page_1.getConfig().getConfigurationSection(p.getUniqueId().toString()) == null) {
				return true;
			} else {
				return false;
			}
		} else if (Page.equalsIgnoreCase("2")) {
			Skyblock.Page_2.getConfig().set(p.getUniqueId().toString(), null);
			Skyblock.Page_2.saveConfig();
			Skyblock.Page_2.ReloadConfig();
			if (Skyblock.Page_2.getConfig().getConfigurationSection(p.getUniqueId().toString()) == null) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public static boolean ResetSlotPlayerWardrobe(Player p, String Slot) {
		String SlotPath = "Slot-" + Slot;
		if (Integer.valueOf(Slot) >= 1 && Integer.valueOf(Slot) <= 9) {
			Skyblock.Page_1.getConfig().set(p.getUniqueId().toString() + ".name", p.getName());
			Skyblock.Page_1.getConfig().set(p.getUniqueId().toString() + "." + SlotPath + ".Helmet", "none");
			Skyblock.Page_1.getConfig().set(p.getUniqueId().toString() + "." + SlotPath + ".Chestplate", "none");
			Skyblock.Page_1.getConfig().set(p.getUniqueId().toString() + "." + SlotPath + ".Leggings", "none");
			Skyblock.Page_1.getConfig().set(p.getUniqueId().toString() + "." + SlotPath + ".Boots", "none");
			Skyblock.Page_1.getConfig().set(p.getUniqueId().toString() + "." + SlotPath + ".Button", "Locked");
			Skyblock.Page_1.saveConfig();
			Skyblock.Page_1.ReloadConfig();
			return true;
		} else if (Integer.valueOf(Slot) >= 10 && Integer.valueOf(Slot) <= 18) {
			Skyblock.Page_2.getConfig().set(p.getUniqueId().toString() + ".name", p.getName());
			Skyblock.Page_2.getConfig().set(p.getUniqueId().toString() + "." + SlotPath + ".Helmet", "none");
			Skyblock.Page_2.getConfig().set(p.getUniqueId().toString() + "." + SlotPath + ".Chestplate", "none");
			Skyblock.Page_2.getConfig().set(p.getUniqueId().toString() + "." + SlotPath + ".Leggings", "none");
			Skyblock.Page_2.getConfig().set(p.getUniqueId().toString() + "." + SlotPath + ".Boots", "none");
			Skyblock.Page_2.getConfig().set(p.getUniqueId().toString() + "." + SlotPath + ".Button", "Locked");
			Skyblock.Page_2.saveConfig();
			Skyblock.Page_2.ReloadConfig();
			return true;
		}
		return false;
	}
}
