package me.adarsh.godspunkycore.features.wardrobe.DataManager;

import me.adarsh.godspunkycore.Skyblock;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class Page1Data {
	private Skyblock plugin;
	private FileConfiguration dataPage1 = null;
	private File Page1 = null;
	
	public Page1Data(Skyblock plugin) {
		this.plugin = plugin;
		saveDefaultConfig();
	}
	
	public void ReloadConfig() {
		if (this.Page1 == null)
			this.Page1 = new File("plugins/GodSpunkySkyblockCore/data/Page 1.yml");
		
		
		this.dataPage1 = YamlConfiguration.loadConfiguration(this.Page1);
		
		InputStream defaultStream = this.plugin.getResource("data/Page 1.yml");
		if (defaultStream != null) {
			YamlConfiguration defaultCongfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
			this.dataPage1.setDefaults(defaultCongfig);
		}
	}
	
	public FileConfiguration getConfig() {
		if (this.dataPage1 == null)
			ReloadConfig();
		
		return this.dataPage1;
	}
	
	public void saveConfig() {
		if (this.dataPage1 == null || this.Page1 == null) 
			return;
		
		try {
			this.getConfig().save(this.Page1);
		} catch (IOException e) {
			plugin.getLogger().log(Level.SEVERE, "Could not save Data to " + this.Page1, e);
		}
	}
	
	public void saveDefaultConfig() {
		if (this.dataPage1 == null)
			this.Page1 = new File("plugins/GodSpunkySkyblockCore/data/Page 1.yml");
		
		if (!this.Page1.exists()) {
			this.plugin.saveResource("data/Page 1.yml", false);
		}
	}
}
