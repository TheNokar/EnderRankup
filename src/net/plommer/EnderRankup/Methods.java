package net.plommer.EnderRankup;

import net.plommer.EnderRankup.Configs.Config;
import net.plommer.EnderRankup.Utils.Utils;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Methods {
	
	private static String nextRank(Player player) {
		String currentRank = SetupVault.permission.getPrimaryGroup(player);
		Object[] c = Config.rc.toArray();
		String newRank = null;
		for(int i = 0; i < c.length; i++) {
			if(!currentRank.equals(c[i].toString())) continue;
			if(i + 2 > c.length) return null;
			newRank =  c[i+1].toString();
			break;
		}
		return newRank;
	}
	
	public static boolean rankup(Player player, JavaPlugin plugin) {
		String nextRank = nextRank(player);
		double worth = Config.ranksFile.getDouble("ranks." + nextRank);
		double money = SetupVault.economy.getBalance(player);
		if(nextRank == null) {
			Utils.sendMessage(player, Config.latest_rank);
			return false;
		}
		if(worth > money) {
			Utils.sendMessage(player, Config.not_enough_money.replace("{needed}", ""+(worth - money)));
			return false;
		}
		SetupVault.economy.withdrawPlayer(player, worth);
		SetupVault.permission.playerRemoveGroup(null, player, SetupVault.permission.getPrimaryGroup(player));
		SetupVault.permission.playerAddGroup(null, player, nextRank);
		System.out.print(Config.rank_complete);
		Utils.broadcastMessage(Config.rank_complete.replace("{rank}", nextRank).replace("{player}", player.getName()));
		return true;
	}
}
