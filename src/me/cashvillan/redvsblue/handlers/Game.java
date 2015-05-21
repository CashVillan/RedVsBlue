package me.cashvillan.redvsblue.handlers;

import java.util.ArrayList;
import java.util.List;

import me.cashvillan.redvsblue.Main;
import me.cashvillan.redvsblue.utils.LocationUtils;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Game {
	
	public static ArrayList<String> status = new ArrayList<String>();
	
	public static void start() {
		Bukkit.broadcastMessage("§6§lGame Starting!");
		status.add("true");
		
		for(int x = 0; x < Teams.red.size(); x = x + 1) {
			Bukkit.broadcastMessage("There are more than " + x + " on team red. Teleporting player " + x + " (" + Teams.red.get(x) + ") to a spawn...");
			Bukkit.getPlayer(Teams.red.get(x)).teleport(Teams.getSpawns("red").get(x));
		}
	}
	
	public static void setLobby(Location loc) {
			List<String> lobbyloc = Main.getInstance().getConfig().getStringList(lobby);
			lobbyloc.add(new LocationUtils(loc.getBlock().getLocation()).toString());
			Main.getInstance().getConfig().set(loc, lobbyloc);
			Main.getInstance().saveConfig();
	}
	
	public static List<Location> getLobby() {
		String lobby = null;
		List<String> lobbyLocs = Main.getInstance().getConfig().getStringList(lobby);
		List<Location> lobbyLocsLocations = new ArrayList<Location>();
		
		for(String locString : lobbyLocs) {
			lobbyLocsLocations.add(new LocationUtils(locString).toLocation().add(0.5, 0, 0.5));
		}
		
		return lobbyLocsLocations;
	}
}
