package me.cashvillan.redvsblue.commands;

import me.cashvillan.redvsblue.handlers.Teams;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Game implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		String redTeam = "";

		for (String s : Teams.red) {
			if (Teams.red.size() == 1) {
				redTeam += s + "";
			} else {
				redTeam += s + " ";
			}
		}

		String blueTeam = "";

		for (String s : Teams.blue) {
			if (Teams.blue.size() == 1) {
				blueTeam += s + "";
			} else {
				blueTeam += s + " ";
			}
		}
		if (!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("game")) {
			p.sendMessage(ChatColor.GRAY + "Game State: " + ChatColor.valueOf(me.cashvillan.redvsblue.handlers.Game.getStatusColor().toUpperCase()) + me.cashvillan.redvsblue.handlers.Game.getStatus());
			p.sendMessage(ChatColor.RED + "Red " + ChatColor.GRAY + "Team: " + ChatColor.YELLOW + redTeam);
			p.sendMessage(ChatColor.BLUE + "Blue " + ChatColor.GRAY + "Team: " + ChatColor.YELLOW + blueTeam);
		}
		
		return false;
	}

}
