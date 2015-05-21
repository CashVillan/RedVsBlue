package me.cashvillan.redvsblue;

import java.io.File;

import me.cashvillan.redvsblue.commands.Lobby;
import me.cashvillan.redvsblue.commands.Team;
import me.cashvillan.redvsblue.handlers.Scheduler;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	static Main plugin;
	
	private final me.cashvillan.redvsblue.listeners.PlayerModifier PlayerModifier = new me.cashvillan.redvsblue.listeners.PlayerModifier();

	public void onEnable() {
		plugin = this;
		registerEvents();
		registerCommands();
		Scheduler.waitingforPlayers();
		if (!new File(this.getDataFolder() + "config.yml").exists()) saveDefaultConfig(); else saveConfig();
	}
	
	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.PlayerModifier, this);
	}
	
	public void registerCommands() {
		getCommand("team").setExecutor(new Team());
		getCommand("lobby").setExecutor(new Lobby());
	}
	
	public static Main getInstance() {
		return plugin;
	}
	
}