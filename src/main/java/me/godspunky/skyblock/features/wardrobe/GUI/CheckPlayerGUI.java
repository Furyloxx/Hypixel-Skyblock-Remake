package me.godspunky.skyblock.features.wardrobe.GUI;

import me.godspunky.skyblock.Skyblock;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CheckPlayerGUI {

	public static String Ver = Bukkit.getServer().getVersion();
	
	public static String PlayerName = "";
	public static String Path = "";
	public static String CheckPage1Name = "";
	public static String CheckPage2Name = "";
	public static Inventory CheckPage1;
	public static Inventory CheckPage2;
	public static boolean onOpen = false;
	public static Player CheckPlayerMain = null;
	
	public static boolean CheckName(String PlayerCurrentName) {
		PlayerName = PlayerCurrentName;
		for(String path : Skyblock.Page_1.getConfig().getConfigurationSection("").getKeys(false)) {
			if (Skyblock.Page_1.getConfig().getString(path + ".name").contains(PlayerCurrentName)) {
				Path = path;
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public static void CheckGUI1(Player p) {
		Player CheckPlayer = Bukkit.getPlayer(Path);
		if (CheckPlayer == null) {
			for(Player CheckPlayer2 : Bukkit.getOnlinePlayers()) {
				if (CheckPlayer2.getUniqueId().toString().contains(Path)) {
					CheckPlayer = CheckPlayer2;
					CheckPlayerMain = CheckPlayer;
					break;
				}
			}
		}
		if (CheckPlayer.getOpenInventory() != null && (CheckPlayer.getOpenInventory().getTitle().equals(WardrobeGUI.Page1Name) || CheckPlayer.getOpenInventory().getTitle().equals(WardrobeGUI.Page2Name))) {
			p.getInventory().addItem(p.getItemOnCursor());
			p.setItemOnCursor(null);
			CheckPlayer.closeInventory();
		}
		onOpen = true;
		String Name = PlayerName + "'s Wardrobe (1/2)";
		WardrobeGUI.Page1Name = Name;
		Inventory CheckWardrobePage1 = Bukkit.createInventory(p, 54, Name);
		CheckPage1Name = Name;
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
			CheckWardrobePage1.setItem(i, Background);
		}
	// Create Change Page Button
		WardrobeGUI.Page1 = CheckWardrobePage1;
	// Create Base Background
		WardrobeGUI.CreateBaseBackground(CheckWardrobePage1);
	// Create AvailableSlot
		WardrobeGUI.CreateAvaiableSlotBackground(CheckWardrobePage1, Name, CheckPlayer);
		
		p.openInventory(CheckWardrobePage1);
	}
	
	@SuppressWarnings("deprecation")
	public static void CheckGUI2(Player p) {
		Player CheckPlayer = Bukkit.getPlayer(Path);
		if (CheckPlayer == null) {
			for(Player CheckPlayer2 : Bukkit.getOnlinePlayers()) {
				if (CheckPlayer2.getUniqueId().toString().contains(Path)) {
					CheckPlayer = CheckPlayer2;
					CheckPlayerMain = CheckPlayer;
					break;
				}
			}
		}
		if (CheckPlayer.getOpenInventory() != null && (CheckPlayer.getOpenInventory().getTitle().equals(WardrobeGUI.Page1Name) || CheckPlayer.getOpenInventory().getTitle().equals(WardrobeGUI.Page2Name))) {
			p.getInventory().addItem(p.getItemOnCursor());
			p.setItemOnCursor(null);
			CheckPlayer.closeInventory();
		}
		onOpen = true;
		String Name = PlayerName + "'s Wardrobe (2/2)";
		WardrobeGUI.Page1Name = Name;
		Inventory CheckWardrobePage2 = Bukkit.createInventory(p, 54, Name);
		CheckPage2Name = Name;
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
			CheckWardrobePage2.setItem(i, Background);
		}
	// Create Change Page Button
		WardrobeGUI.Page2 = CheckWardrobePage2;
	// Create Base Background
		WardrobeGUI.CreateBaseBackground(CheckWardrobePage2);
	// Create AvailableSlot
		WardrobeGUI.CreateAvaiableSlotBackground(CheckWardrobePage2, Name, CheckPlayer);
		
		p.openInventory(CheckWardrobePage2);
	}
}
