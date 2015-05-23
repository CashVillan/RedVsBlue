package me.cashvillan.redvsblue.utils;

import me.cashvillan.redvsblue.handlers.Game;
import me.cashvillan.redvsblue.handlers.Teams;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class ScoreboardUtils {

	public static void startScoreboard(Player player) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();

		Objective o = board.registerNewObjective("test", "dummy");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);

		o.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "RED" + ChatColor.WHITE + "" + ChatColor.BOLD +  "VS" + ChatColor.BLUE + "" + ChatColor.BOLD + "BLUE");
		
		if (Game.status == true) {
			Integer red = Teams.red.size();
			Integer blue = Teams.blue.size();
			
			Score line1 = o.getScore(ChatColor.GOLD + "" + ChatColor.BOLD + "SCORE " + ChatColor.RED + "" + Teams.redKills + ChatColor.GRAY + "/" + ChatColor.BLUE + "" + Teams.blueKills);
			line1.setScore(-1);
			Score line2 = o.getScore(ChatColor.GOLD + "" + ChatColor.BOLD + "PLAYERS " + ChatColor.RED + "" + red + ChatColor.GRAY + "/" + ChatColor.BLUE + "" + blue);
			line2.setScore(-2);
		} else if (Game.status == false) {
			Score line1 = o.getScore(ChatColor.RED + "" + "Waiting on Players");
			line1.setScore(-1);
		}
		player.setScoreboard(board);
	}
	
	public static int secondstoTicks(Integer seconds) {
		Integer secondsToTicks = seconds * 20;
		return secondsToTicks;
	}
}