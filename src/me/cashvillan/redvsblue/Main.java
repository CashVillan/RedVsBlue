package me.cashvillan.redvsblue;

import java.io.File;

import me.cashvillan.redvsblue.commands.*;
import me.cashvillan.redvsblue.listeners.*;
import me.cashvillan.redvsblue.handlers.Scheduler;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	static Main plugin;
	
	private final GameStats GameStats = new GameStats();
	private final PlayerModifier PlayerModifier = new PlayerModifier();
	private final PlayerStats PlayerStats = new PlayerStats();
	private final TeamModifiers TeamModifiers = new TeamModifiers();

	public void onEnable() {
		plugin = this;
		FileManager.loadplayersConfig();
		registerEvents();
		registerCommands();
		Scheduler.waitingforPlayers();
		if (!new File(this.getDataFolder() + "config.yml").exists()) saveDefaultConfig(); else saveConfig();
	}
	
	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.GameStats, this);
		pm.registerEvents(this.PlayerModifier, this);
		pm.registerEvents(this.PlayerStats, this);
		pm.registerEvents(this.TeamModifiers, this);

	}
	
	public void registerCommands() {
		getCommand("team").setExecutor(new Team());
		getCommand("lobby").setExecutor(new Lobby());
		getCommand("game").setExecutor(new Game());
	}
	
	public static Main getInstance() {
		return plugin;
	}
}