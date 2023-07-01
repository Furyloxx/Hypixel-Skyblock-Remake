package me.adarsh.godspunkycore.features.wardrobe.DataManager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

import me.adarsh.godspunkycore.Skyblock;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class Page2Data {
	private Skyblock plugin;
	private FileConfiguration dataPage2 = null;
	private File Page2 = null;
	
	public Page2Data(Skyblock plugin) {
		this.plugin = plugin;
		saveDefaultConfig();
	}
	
	public void ReloadConfig() {
		if (this.Page2 == null)
			this.Page2 = new File("plugins/GodSpunkySkyblockCore/data/Page 2.yml");
		
		
		this.dataPage2 = YamlConfiguration.loadConfiguration(this.Page2);
		
		InputStream defaultStream = this.plugin.getResource("data/Page 2.yml");
		if (defaultStream != null) {
			YamlConfiguration defaultCongfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
			this.dataPage2.setDefaults(defaultCongfig);
		}
	}
	
	public FileConfiguration getConfig() {
		if (this.dataPage2 == null)
			ReloadConfig();
		
		return this.dataPage2;
	}
	
	public void saveConfig() {
		if (this.dataPage2 == null || this.Page2 == null) 
			return;
		
		try {
			this.getConfig().save(this.Page2);
		} catch (IOException e) {
			plugin.getLogger().log(Level.SEVERE, "Could not save Data to " + this.Page2, e);
		}
	}
	
	public void saveDefaultConfig() {
		if (this.dataPage2 == null)
			this.Page2 = new File("plugins/GodSpunkySkyblockCore/data/Page 2.yml");
		
		if (!this.Page2.exists()) {
			this.plugin.saveResource("data/Page 2.yml", false);
		}
	}
}
