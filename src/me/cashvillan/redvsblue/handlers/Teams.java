package me.cashvillan.redvsblue.handlers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.cashvillan.redvsblue.Main;
import me.cashvillan.redvsblue.utils.LocationUtils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Teams {
	
	public static ArrayList<String> red = new ArrayList<String>();
	public static ArrayList<String> blue = new ArrayList<String>();

	
	public static String team(Player p) {
		String team = "";
		if (red.contains(p.getName())) {
			team = "Red";
		} else {
			if (blue.contains(p.getName())) {
				team = "Blue";
			}
		}
		return team;
	}

	public static void addPlayersToTeams(Player p) {
		if (red.size() > blue.size()) {
			blue.add(p.getName());;
		} else if (red.size() < blue.size()) {
			red.add(p.getName());
		} else {
			Integer team = new Random().nextInt(2);
			if (team == 1) {
				red.add(p.getName());
			} else {
				blue.add(p.getName());
			}
		}
	}
	
	public static void addPlayer(String player, String team) {
		if(team.toLowerCase().equals("blue")) {
			if(red.contains(player)) {
				blue.remove(player);
			}
			
			blue.add(player);
			
		} else {
			if(blue.contains(player)) {
				blue.remove(player);
			}
			
			red.add(player);
		}
	}
	
	public static void addSpawn(String team, Location loc) {
		List<String> teamLocs = Main.getInstance().getConfig().getStringList(team);
		teamLocs.add(new LocationUtils(loc.getBlock().getLocation()).toString());
		Main.getInstance().getConfig().set(team, teamLocs);
		Main.getInstance().saveConfig();
	}
	
	public static List<Location> getSpawns(String team) {
		List<String> teamLocs = Main.getInstance().getConfig().getStringList(team);
		List<Location> teamLocsLocations = new ArrayList<Location>();
		
		for(String locString : teamLocs) {
			teamLocsLocations.add(new LocationUtils(locString).toLocation().add(0.5, 0, 0.5));
		}
		
		return teamLocsLocations;
	}
	
	public static void toSpawn(Player player, String team) {
		
		String p = player.getName();
		
		if (team.contains(p)) {
		}
	}
}
