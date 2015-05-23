package me.cashvillan.redvsblue.listeners;

import me.cashvillan.redvsblue.handlers.Game;
import me.cashvillan.redvsblue.handlers.Teams;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TeamModifiers implements Listener {
	
	@EventHandler
	public static void onDamage(EntityDamageByEntityEvent event) {
		Entity attacker = event.getDamager();
		Entity victim = event.getEntity();

		if (victim instanceof Player) {
			if (Teams.red.contains(victim.getName())) {
				if (attacker instanceof Player) {
					if (Teams.red.contains(attacker.getName())) {
						event.setCancelled(true);
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
			
			if (Teams.red.contains(p.getName())) {
				Teams.toSpawn(p, "red");
			} else {
				if (Teams.blue.contains(p.getName())) {
					Teams.toSpawn(p, "blue");
			}
			}
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		
		if (Game.status == true) {
			Teams.addPlayersToTeams(p);
			
		} else if (Game.status == false) {
			p.teleport(Game.getLobby());
			return;
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player p = event.getPlayer();
		
		Teams.red.remove(p.getName());
		Teams.blue.remove(p.getName());
	}
}