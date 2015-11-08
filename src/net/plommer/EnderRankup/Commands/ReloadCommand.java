package net.plommer.EnderRankup.Commands;

import net.plommer.EnderRankup.EnderRankup;
import net.plommer.EnderRankup.Utils.Utils;

public class ReloadCommand extends BaseCommand {

	public ReloadCommand() {
		bePlayer = false;
		name = "reload:r:rel";
		argLength = 0;
		usage = "reload";
		permission = "reload";
	}
	
	@Override
	public boolean execute() {
		EnderRankup.config.reload();
		EnderRankup.ranks.reload();
		Utils.sendMessage(sender, "&bEnderRankup &ehas been reloaded!");
		return false;
	}
	
}
