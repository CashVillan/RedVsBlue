package me.cashvillan.redvsblue.commands;

import me.cashvillan.redvsblue.handlers.Game;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Lobby implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		
		if (!(sender instanceof Player)) {
			return true;
		}
		
		if (sender.isOp()) {
			Player p = (Player) sender;
			
			if (cmd.getName().equalsIgnoreCase("lobby")) {
				if (args.length == 0) {
					p.sendMessage(ChatColor.RED + "Commands:");
					p.sendMessage("[/lobby set] Set the lobby.");
					p.sendMessage("[/lobby view] Teleport to lobby.");
				} else {
					Location loc = ((Player) sender).getLocation();
					if (args[0].equalsIgnoreCase("set")) {
						p.sendMessage(ChatColor.GREEN + "Lobby has been set!");
						Game.setLobby(loc);
					}
				}
			}
		}
		
		return false;
		
	}

}
