package net.plommer.EnderRankup;

import java.util.ArrayList;

import net.plommer.EnderRankup.Commands.*;
import net.plommer.EnderRankup.Configs.GenerateConfigs;

import org.bukkit.plugin.java.JavaPlugin;

public class EnderRankup extends JavaPlugin {

	public ArrayList<BaseCommand> commands = new ArrayList<BaseCommand>();
	
	public void onEnable() {
		if(getServer().getPluginManager().getPlugin("Vault") == null) {
			getLogger().info("Vault was not found... EnderRankup has been disabled!");
			getServer().getPluginManager().disablePlugin(this);
		} else {
			getLogger().info("Vault was found, enderrankup can now run normally!");
			new SetupVault(this);
			//ranks config
			GenerateConfigs rankup = new GenerateConfigs(this, "ranks");
			rankup.setup();
			setUpCommands();
		}
	}
	
	public void onDisable() {
		
	}
	
	private void setUpCommands() {
		getCommand("rankup").setExecutor(new CommandHandler(this));
		commands.add(new TestCommand());
	}
	
}
