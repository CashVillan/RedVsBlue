package me.cashvillan.redvsblue.listeners;

import me.cashvillan.redvsblue.handlers.Teams;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class GameStats implements Listener {
	
	@EventHandler
	public static void onEntityDeath(EntityDeathEvent evt) {
		if (evt instanceof PlayerDeathEvent) {
			PlayerDeathEvent event = (PlayerDeathEvent)evt;
			Player attacker = event.getEntity().getKiller();
			Player victim = event.getEntity().getPlayer();
			
			if (Teams.red.contains(attacker.getName())) {
				Teams.redKills = new Integer(Teams.redKills.intValue() + 1);
				if (Teams.blue.contains(attacker.getName())) {
					Teams.blueKills = new Integer(Teams.blueKills.intValue() + 1);
				}
			}
			if (Teams.red.contains(victim.getName())) {
				Teams.redDeaths = new Integer(Teams.redDeaths.intValue() + 1);
			} else {
				if (Teams.blue.contains(victim.getName())) {
					Teams.blueDeaths = new Integer(Teams.blueDeaths.intValue() + 1);
				}
			}
		}
	}
}
