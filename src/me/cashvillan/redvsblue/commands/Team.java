package me.cashvillan.redvsblue.commands;

import me.cashvillan.redvsblue.handlers.Teams;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Team implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		String redTeam = "";

		for (String s : Teams.red) {
			redTeam += s + " - ";
		}

		String blueTeam = "";

		for (String s : Teams.blue) {
			blueTeam += s + " - ";
		}

		if (!(sender instanceof Player)) {
			return true;
		}

		if (cmd.getName().equalsIgnoreCase("team")) {
			if (args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Commands:");
				sender.sendMessage("[/team <team>] View a team.");
				sender.sendMessage("[/team setspawn <team>] Add spawns.");
				sender.sendMessage("[/team add <player> <team>] Change teams.");

			} else {
				if (args[0].equalsIgnoreCase("red")) {
					if (redTeam == "") {
						sender.sendMessage(ChatColor.RED + "Team empty.");
					} else {
						sender.sendMessage(ChatColor.valueOf(args[0].toUpperCase()) + args[0] + " team members:");
						sender.sendMessage(redTeam);
					}

				} else if (args[0].equalsIgnoreCase("blue")) {
					if (blueTeam == "") {
						sender.sendMessage(ChatColor.RED + "Team empty.");
					} else {
						sender.sendMessage(ChatColor.valueOf(args[0].toUpperCase()) + args[0] + " team members:");
						sender.sendMessage(blueTeam);
					}

				} else if (args[0].equalsIgnoreCase("add")) {
					if (args.length == 3) {
						String target = args[1];
						String team = args[2];

						Teams.addPlayer(target, team);
						sender.sendMessage(target + " has been added to team "
								+ team);

					} else {
						sender.sendMessage(ChatColor.RED
								+ "Usage: /team add <player> <team>");
					}
				}
				else if (args[0].equalsIgnoreCase("addspawn")) {
						if (args.length == 2) {
							String team = args[2];
							Location loc = ((Player) sender).getLocation();
							
							Teams.addSpawn(team, loc);
							
							sender.sendMessage(ChatColor.valueOf(team.toUpperCase()) + team + " spawn added!");
							
					} else {
						sender.sendMessage(ChatColor.RED + "Usage: /team addspawn <team>");
					}
				}
			}
		}
		return false;
	}

}