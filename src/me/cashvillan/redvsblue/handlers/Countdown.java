package me.cashvillan.redvsblue.handlers;

import me.cashvillan.redvsblue.Main;

import org.bukkit.Bukkit;

public class Countdown implements Runnable {
	Main plugin;
	private int ticks;
	
	public Countdown(Main instance, int ticks) {
		plugin = instance;
		this.ticks = ticks;
	}
	
	public void run() {
		@SuppressWarnings("unused")
		int counter = 0;
		if ((this.ticks % 10) == 0 && ticks > 10) {
			this.ticks--;
			counter = ticks + 1;
			Bukkit.getServer().broadcastMessage(ticks + " seconds left!");
		} else if (ticks == 10) {
			this.ticks--;
			counter = ticks + 1;
		} else if (ticks < 10) {
			this.ticks--;
			counter = ticks + 1;
			Bukkit.getServer().broadcastMessage(ticks + " ");
		}
	}
}
