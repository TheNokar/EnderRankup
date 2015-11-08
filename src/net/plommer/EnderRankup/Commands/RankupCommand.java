package net.plommer.EnderRankup.Commands;

import net.plommer.EnderRankup.Methods;

public class RankupCommand extends BaseCommand {
	
	public RankupCommand() {
		bePlayer = true;
		name = "";
		argLength = 0;
		usage = "Rankup";
		permission = "rankup";
	}
	
	@Override
	public boolean execute() {
		Methods.rankup(player, plugin);
		return false;
	}
}
