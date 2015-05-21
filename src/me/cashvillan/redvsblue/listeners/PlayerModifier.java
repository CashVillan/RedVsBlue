package me.cashvillan.redvsblue.listeners;

import me.cashvillan.redvsblue.handlers.Game;
import me.cashvillan.redvsblue.handlers.Teams;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerModifier implements Listener {
	
	@EventHandler
	public static void onPlayerJoin(PlayerJoinEvent event) {
		String p = event.getPlayer().getName();
		event.setJoinMessage(ChatColor.GRAY + p + ChatColor.GOLD + " has joined! " + ChatColor.GRAY + "(" + ChatColor.GOLD + Bukkit.getOnlinePlayers().size() + ChatColor.GRAY + "/" + ChatColor.GOLD + Bukkit.getMaxPlayers() + ChatColor.GRAY + ")");
	}
	
	@EventHandler
	public static void onPlayerChat(AsyncPlayerChatEvent event) {
		Player p = event.getPlayer();
		event.setFormat(ChatColor.valueOf(Teams.team(p).toUpperCase()) + Teams.team(p) + ChatColor.GOLD + " %s" + ChatColor.GRAY + ":" + " %s");
	}
	
	@EventHandler
	public static void onPlayerDeath(PlayerDeathEvent event) {
		
		if (Game.status.contains(true)) {
			if (!(event.getEntity() instanceof Player)) {
				return;
			}
			
			Player p = event.getEntity().getPlayer();
			
			if (Teams.red.contains(p)) {
				p.teleport((Location) Teams.getSpawns("red"));
			} else {
				if (Teams.blue.contains(p)) {
					p.teleport((Location) Teams.getSpawns("blue"));
			}
			}
		}
	}
}
