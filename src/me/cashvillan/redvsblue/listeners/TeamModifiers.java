package me.cashvillan.redvsblue.listeners;

import me.cashvillan.redvsblue.handlers.Game;
import me.cashvillan.redvsblue.handlers.Teams;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class TeamModifiers implements Listener {
	
	@EventHandler
	public static void onDamage(EntityDamageByEntityEvent event) {
		Entity attacker = event.getDamager();
		Entity victim = event.getEntity();
		if (!(victim instanceof Player)) {
			return;
		}
		if (!(attacker instanceof Player)) {
			return;
		}
		if (victim instanceof Player) {
			if (Teams.red.contains(victim.getName())) {
				if (attacker instanceof Player) {
					if (Teams.red.contains(attacker.getName())) {
						//event.setCancelled(true);
						attacker.sendMessage(ChatColor.RED + "You cannot damage teammates!");
						return;	
					}
				}
			}
		}
	}
	
	@EventHandler
	public static void onPlayerDeath(PlayerDeathEvent event) {
		Player player = event.getEntity();
		
		if (Game.status == true) {
			if (!(event.getEntity() instanceof Player)) {
				Teams.toSpawn(player, Teams.team(player));
				return;
			}
			Player p = event.getEntity().getPlayer();
			
			if (Teams.red.contains(p)) {
				p.teleport((Location) Teams.getSpawns("red")); //wait for mark
			} else {
				if (Teams.blue.contains(p)) {
					p.teleport((Location) Teams.getSpawns("blue")); //wait for mark
			}
			}
		}
	}
}
