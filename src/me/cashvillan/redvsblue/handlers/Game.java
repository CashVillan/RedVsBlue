package me.cashvillan.redvsblue.handlers;

import java.util.ArrayList;

import me.cashvillan.redvsblue.Main;
import me.cashvillan.redvsblue.utils.LocationUtils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;

public class Game {
	
	static Main plugin;
	
	public static ArrayList<String> status = new ArrayList<String>();
	
	public static void start() {
		Bukkit.broadcastMessage(ChatColor.GOLD + "Game now starting!");
		status.clear();
		status.add("true");
		for(int x = 0; x < Teams.red.size(); x = x + 1) {
			Bukkit.broadcastMessage("There are more than " + x + " on team red. Teleporting player " + x + " (" + Teams.red.get(x) + ") to a spawn...");
			Bukkit.getPlayer(Teams.red.get(x)).teleport(Teams.getSpawns("red").get(x));
		}
	}
	
	public static void stop() {
		
	}
	
	public static void setLobby(Location loc) {
			Main.getInstance().getConfig().set("lobby", new LocationUtils(loc.getBlock().getLocation()).toString());
			Main.getInstance().saveConfig();
	}
	
	public static Location getLobby() {
		String lobby = Main.getInstance().getConfig().getString("lobby");

		return new LocationUtils(lobby).toLocation().add(0.5, 0, 0.5);
	}
	
	public static String getStatus() {
		String getStatus = "";
		if (status.contains("true")) {
			getStatus = "Started!";
		}
		if (status.contains("false")) {
			getStatus = "Waiting.";
		}
		return getStatus;
	}
	
	public static String getStatusColor() {
		String getStatusColor = "";
		if (getStatus().contains("Started!")) {
			getStatusColor = "GREEN";
		}
		if (getStatus().contains("Waiting.")) {
			getStatusColor = "RED";
		}
		
		return getStatusColor;
		
	}
}
