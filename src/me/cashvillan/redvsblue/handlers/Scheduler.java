package me.cashvillan.redvsblue.handlers;

import me.cashvillan.redvsblue.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Scheduler {
	
	public static void waitingforPlayers() {
		new BukkitRunnable() {
			public void run() {
				int onlineplayers = Bukkit.getOnlinePlayers().size();
				int maxplayers = Bukkit.getMaxPlayers();
				Bukkit.broadcastMessage(ChatColor.GOLD + "Waiting on " + ChatColor.YELLOW + "" + (maxplayers - onlineplayers) + ChatColor.GOLD + " more players!");
				Game.status.clear();
				Game.status.add("false");
				if (Bukkit.getOnlinePlayers().size() == 1) {
					this.cancel();
					Game.start();

					for (Player player : Bukkit.getOnlinePlayers()) {
						Teams.addPlayersToTeams(player);
					}
				}
			}
		}.runTaskTimer(Main.getInstance(), 0, 200);
	}
}