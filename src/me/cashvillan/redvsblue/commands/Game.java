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
			if (args.length == 0) {
				p.sendMessage(ChatColor.GRAY + "Game State: " + ChatColor.valueOf(me.cashvillan.redvsblue.handlers.Game.getStatusColor().toUpperCase()) + me.cashvillan.redvsblue.handlers.Game.getStatus());
				p.sendMessage(ChatColor.RED + "Red " + ChatColor.GRAY + "Team: " + ChatColor.YELLOW + redTeam);
				p.sendMessage(ChatColor.BLUE + "Blue " + ChatColor.GRAY + "Team: " + ChatColor.YELLOW + blueTeam);
				if (me.cashvillan.redvsblue.handlers.Game.status == true) {
					p.sendMessage(ChatColor.RED + "Red " + ChatColor.GRAY + "Team Kills: " + ChatColor.RED + Teams.redKills);
					p.sendMessage(ChatColor.BLUE + "Blue " + ChatColor.GRAY + "Team Kills: " + ChatColor.BLUE + Teams.blueDeaths);
					p.sendMessage(ChatColor.RED + "Red " + ChatColor.GRAY + "Team Deaths: " + ChatColor.RED + Teams.redKills);
					p.sendMessage(ChatColor.BLUE + "Blue " + ChatColor.GRAY + "Team Deaths: " + ChatColor.BLUE + Teams.blueDeaths);
				}
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("start")) {
					if (me.cashvillan.redvsblue.handlers.Game.status == true) {
						p.sendMessage(ChatColor.RED + "Game already started!");
					}
					else if (me.cashvillan.redvsblue.handlers.Game.status == false) {
						me.cashvillan.redvsblue.handlers.Game.start();
					}
				}
				if (args[0].equalsIgnoreCase("stop")) {
					if(me.cashvillan.redvsblue.handlers.Game.status == false) {
						p.sendMessage(ChatColor.RED + "Game already stopped!");
					}
					else if (me.cashvillan.redvsblue.handlers.Game.status == true) {
						me.cashvillan.redvsblue.handlers.Game.stop();
						p.sendMessage(ChatColor.RED + "Game has been stopped!");
					}
				}
			}
		}
		
		
		return false;
	}
	
	

}
