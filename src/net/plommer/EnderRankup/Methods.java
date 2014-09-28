package net.plommer.EnderRankup;

import net.plommer.EnderRankup.Configs.Config;
import net.plommer.EnderRankup.Utils.Utils;

import org.bukkit.entity.Player;

public class Methods {
	
	private static String nextRank(Player player) {
		String currentRank = SetupVault.permission.getPrimaryGroup(player);
		Object[] c = Config.rc.toArray();
		String newRank = null;
		for(int i = 0; i < c.length; i++) {
			if(!currentRank.equals(c[i].toString())) continue;
			if(i + 2 > c.length) return null;
			newRank =  c[i+1].toString();
		}
		return newRank;
	}
	
	public static boolean rankup(Player player) {
		String nextRank = nextRank(player);
		double worth = Config.ranksFile.getDouble("ranks." + nextRank);
		double money = SetupVault.economy.getBalance(player);
		if(nextRank == null) {
			Utils.sendMessage(player, "&cYou are already in the latest rank!");
			return false;
		}
		if(worth > money) {
			Utils.sendMessage(player, "&cYou don't have enough money to buy that rank!");
			return false;
		}
		SetupVault.economy.depositPlayer(player, worth);
		SetupVault.permission.playerRemoveGroup(player, SetupVault.permission.getPrimaryGroup(player));
		SetupVault.permission.playerAddGroup(player, nextRank);
		Utils
		return true;
	}
	
}
