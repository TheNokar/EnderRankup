package net.plommer.EnderRankup;

import java.util.ArrayList;

import net.plommer.EnderRankup.Commands.*;
import net.plommer.EnderRankup.Configs.GenerateConfigs;
import net.plommer.EnderRankup.Listeners.SignListener;

import org.bukkit.plugin.java.JavaPlugin;

public class EnderRankup extends JavaPlugin {

	public ArrayList<BaseCommand> commands = new ArrayList<BaseCommand>();
	
	public static GenerateConfigs ranks = null;
	public static GenerateConfigs config = null;
	
	public void onEnable() {
		if(getServer().getPluginManager().getPlugin("Vault") == null) {
			getLogger().info("Vault was not found... EnderRankup has been disabled!");
			getServer().getPluginManager().disablePlugin(this);
		} else {
			getLogger().info("Vault was found, enderrankup can now run normally!");
			new SetupVault(this);
			config = new GenerateConfigs(this, "config");
			config.setup();
			ranks = new GenerateConfigs(this, "ranks");
			ranks.setup();
			setUpCommands();
			getServer().getPluginManager().registerEvents(new SignListener(this), this);
		}
	}
	
	public void onDisable() {
		
	}
	
	private void setUpCommands() {
		getCommand("rankup").setExecutor(new CommandHandler(this));
		commands.add(new RankupCommand()); //Always first
		commands.add(new ReloadCommand());
	}
	
}
