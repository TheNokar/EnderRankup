package net.plommer.EnderRankup.Listeners;

import net.plommer.EnderRankup.Methods;
import net.plommer.EnderRankup.Configs.Config;
import net.plommer.EnderRankup.Utils.Utils;

import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SignListener implements Listener {

	private JavaPlugin plugin;
	public SignListener(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void signChange(SignChangeEvent event) {
		if(event.getPlayer().hasPermission(Config.permission_node + ".sign")) {
			if(event.getLine(0).equalsIgnoreCase("[rankup]")) {
				event.setLine(0, Utils.buildString("&7[&6RankUp&7]"));
				event.setLine(1, Utils.buildString("&eRight click"));
				event.setLine(2, Utils.buildString("&eme to rankup!"));
			}
		}
	}

	@EventHandler
	public void signInteract(PlayerInteractEvent event) {
		if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(event.getClickedBlock().getState() instanceof Sign) {
				Sign sign = (Sign)event.getClickedBlock().getState();
				if(sign.getLine(0).equals(Utils.buildString("&7[&6RankUp&7]")) && event.getPlayer().hasPermission(Config.permission_node + ".rankup")) {
					Methods.rankup(event.getPlayer(), plugin);
				}
			}
		}
	}
	
	@EventHandler
	public void blockBreak(BlockBreakEvent event) {
		if(event.getBlock().getState() instanceof Sign) {
			Sign sign = (Sign)event.getBlock().getState();
			if(sign.getLine(0).equals(Utils.buildString("&7[&6RankUp&7]"))) {
				event.setCancelled(!event.getPlayer().hasPermission(Config.permission_node + ".sign"));
			}
		}
	}
	
}
