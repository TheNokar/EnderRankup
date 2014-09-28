package net.plommer.EnderRankup.Configs;

import java.util.Set;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Config {
	
	private static JavaPlugin plugin;
	public Config() {}
	public Config(JavaPlugin plugin) {
		Config.plugin = plugin;
	}
	
	//Permissions
	public static String permission_node = "enderrankup";
	
	//Get Ranks
	public static FileConfiguration ranksFile = new GenerateConfigs(plugin, "ranks").getCustomConfig();
	public static Set<String> rc = ranksFile.getConfigurationSection("ranks").getKeys(false);
	
	//Messages
	
	
}
