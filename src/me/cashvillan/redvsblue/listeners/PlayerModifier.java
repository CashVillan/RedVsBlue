package me.cashvillan.redvsblue.listeners;

import me.cashvillan.redvsblue.handlers.Teams;
import me.cashvillan.redvsblue.utils.ScoreboardUtils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerModifier implements Listener {
	
	@EventHandler
	public static void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		ScoreboardUtils.startScoreboard(p);
		event.setJoinMessage(ChatColor.GRAY + p.getName() + ChatColor.GOLD + " has joined! " + ChatColor.GRAY + "(" + ChatColor.GOLD + Bukkit.getOnlinePlayers().size() + ChatColor.GRAY + "/" + ChatColor.GOLD + Bukkit.getMaxPlayers() + ChatColor.GRAY + ")");
	}
	
	@EventHandler
	public static void onPlayerChat(AsyncPlayerChatEvent event) {
		Player p = event.getPlayer();
		event.setFormat(ChatColor.valueOf(Teams.team(p).toUpperCase()) + Teams.team(p) + ChatColor.GOLD + " %s" + ChatColor.GRAY + ":" + " %s");
	}
}