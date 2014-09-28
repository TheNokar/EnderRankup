package net.plommer.EnderRankup.Commands;

import net.plommer.EnderRankup.Methods;

public class TestCommand extends BaseCommand {
	
	public TestCommand() {
		bePlayer = true;
		name = "";
		argLength = 0;
		usage = "<Warp name>";
		permission = "ugh";
	}
	
	@Override
	public boolean execute() {
		Methods.rankup(player);
		return false;
	}
}
