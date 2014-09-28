package net.plommer.EnderRankup.Configs;

import java.util.Set;

import net.plommer.EnderRankup.EnderRankup;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
	
	//Permissions
	public static String permission_node = "enderrankup";
	
	//Get Ranks
	public static FileConfiguration ranksFile = EnderRankup.ranks.getCustomConfig();
	public static Set<String> rc = ranksFile.getConfigurationSection("ranks").getKeys(false);
	
	//Messages
	public static FileConfiguration configFile = EnderRankup.config.getCustomConfig();
	public static String not_enough_money = configFile.getString("messages.not_enough_money");
	public static String latest_rank = configFile.getString("messages.latest_rank");
	public static String rank_complete = configFile.getString("messages.rank_complete");
	
}
