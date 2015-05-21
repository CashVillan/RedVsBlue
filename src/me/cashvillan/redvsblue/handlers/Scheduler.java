package me.cashvillan.redvsblue.handlers;

import me.cashvillan.redvsblue.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Scheduler {
	
	public static void waitingforPlayers() {
		new BukkitRunnable() {
			public void run() {
				Bukkit.broadcastMessage("§b§lWaiting for Players");
				if (Bukkit.getOnlinePlayers().size() > 0) {
					this.cancel();
					Game.start();

					for (Player player : Bukkit.getOnlinePlayers()) {
						Teams.addPlayersToTeams(player);
					}
				}
			}
		}.runTaskTimer(Main.getInstance(), 0, 100);
	}
}
