package me.adarsh.godspunkycore.features.wardrobe.Listener;

import me.adarsh.godspunkycore.Skyblock;
import me.adarsh.godspunkycore.features.wardrobe.GUI.CheckPlayerGUI;
import me.adarsh.godspunkycore.features.wardrobe.GUI.WardrobeGUI;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class CheckPlayerGUIListener implements Listener {

	public Skyblock plugin;
	
	public CheckPlayerGUIListener(Skyblock plugin) {
		this.plugin = plugin;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}
	
	public String Ver = Bukkit.getServer().getVersion();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClose(InventoryCloseEvent e) {
		if (CheckPlayerGUI.onOpen) {
			if (e.getView().getTitle().equals(WardrobeGUI.Page1Name)) {
				Skyblock.Page_1.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".name", CheckPlayerGUI.CheckPlayerMain.getName());
				for (int i = 0; i <= 8; i++) {
					if (e.getInventory().getItem(i).getType().toString().contains("STAINED_GLASS_PANE")) {
						Skyblock.Page_1.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+1) + ".Helmet", "none");
					} else {
						Skyblock.Page_1.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+1) + ".Helmet", e.getInventory().getItem(i));
					}
					if (e.getInventory().getItem(i+9).getType().toString().contains("STAINED_GLASS_PANE")) {
						Skyblock.Page_1.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+1) + ".Chestplate", "none");
					} else {
						Skyblock.Page_1.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+1) + ".Chestplate", e.getInventory().getItem(i+9));
					}
					if (e.getInventory().getItem(i+18).getType().toString().contains("STAINED_GLASS_PANE")) {
						Skyblock.Page_1.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+1) + ".Leggings", "none");
					} else {
						Skyblock.Page_1.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+1) + ".Leggings", e.getInventory().getItem(i+18));
					}
					if (e.getInventory().getItem(i+27).getType().toString().contains("STAINED_GLASS_PANE")) {
						Skyblock.Page_1.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+1) + ".Boots", "none");
					} else {
						Skyblock.Page_1.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+1) + ".Boots", e.getInventory().getItem(i+27));
					}
					String ButtonCheck = "";
					if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
						ButtonCheck = e.getInventory().getItem(i+36).getData().toString();
					}
					if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
						ButtonCheck = e.getInventory().getItem(i+36).getType().toString();
					}
					if (ButtonCheck.contains("LIME_DYE") || ButtonCheck.contains("LIME DYE")) {
						Skyblock.Page_1.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+1) + ".Button", "Equipped");
					} else if (ButtonCheck.contains("GRAY_DYE") || ButtonCheck.contains("GRAY DYE")) {
						Skyblock.Page_1.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+1) + ".Button", "Empty");
					} else if (ButtonCheck.contains("PINK_DYE") || ButtonCheck.contains("PINK DYE")) {
						Skyblock.Page_1.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+1) + ".Button", "Ready");
					} else {
						Skyblock.Page_1.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+1) + ".Button", "Locked");
					}
				}
				Skyblock.Page_1.saveConfig();
				Skyblock.Page_1.ReloadConfig();
			} else if (e.getView().getTitle().equals(WardrobeGUI.Page2Name)) {
				Skyblock.Page_2.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".name", CheckPlayerGUI.CheckPlayerMain.getName());
				for (int i = 0; i <= 8; i++) {
					if (e.getInventory().getItem(i).getType().toString().contains("STAINED_GLASS_PANE")) {
						Skyblock.Page_2.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+10) + ".Helmet", "none");
					} else {
						Skyblock.Page_2.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+10) + ".Helmet", e.getInventory().getItem(i));
					}
					if (e.getInventory().getItem(i+9).getType().toString().contains("STAINED_GLASS_PANE")) {
						Skyblock.Page_2.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+10) + ".Chestplate", "none");
					} else {
						Skyblock.Page_2.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+10) + ".Chestplate", e.getInventory().getItem(i+9));
					}
					if (e.getInventory().getItem(i+18).getType().toString().contains("STAINED_GLASS_PANE")) {
						Skyblock.Page_2.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+10) + ".Leggings", "none");
					} else {
						Skyblock.Page_2.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+10) + ".Leggings", e.getInventory().getItem(i+18));
					}
					if (e.getInventory().getItem(i+27).getType().toString().contains("STAINED_GLASS_PANE")) {
						Skyblock.Page_2.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+10) + ".Boots", "none");
					} else {
						Skyblock.Page_2.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+10) + ".Boots", e.getInventory().getItem(i+27));
					}
					String ButtonCheck = "";
					if (Ver.contains("1.8") || Ver.contains("1.9") || Ver.contains("1.10") || Ver.contains("1.11") || Ver.contains("1.12")) {
						ButtonCheck = e.getInventory().getItem(i+36).getData().toString();
					}
					if (Ver.contains("1.13") || Ver.contains("1.14") || Ver.contains("1.15") || Ver.contains("1.16") || Ver.contains("1.17") || Ver.contains("1.18")) {
						ButtonCheck = e.getInventory().getItem(i+36).getType().toString();
					}
					if (ButtonCheck.contains("LIME_DYE") || ButtonCheck.contains("LIME DYE")) {
						Skyblock.Page_2.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+10) + ".Button", "Equipped");
					} else if (ButtonCheck.contains("GRAY_DYE") || ButtonCheck.contains("GRAY DYE")) {
						Skyblock.Page_2.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+10) + ".Button", "Empty");
					} else if (ButtonCheck.contains("PINK_DYE") || ButtonCheck.contains("PINK DYE")) {
						Skyblock.Page_2.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+10) + ".Button", "Ready");
					} else {
						Skyblock.Page_2.getConfig().set(CheckPlayerGUI.CheckPlayerMain.getUniqueId().toString() + ".Slot-" + (i+10) + ".Button", "Locked");
					}
				}
				Skyblock.Page_2.saveConfig();
				Skyblock.Page_2.ReloadConfig();
			}
			CheckPlayerGUI.onOpen = false;
		}
	}
}
