package me.cashvillan.redvsblue.listeners;

import me.cashvillan.redvsblue.FileManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerStats implements Listener {
	
	@EventHandler
	public static void onEntityDeath(EntityDeathEvent evt) {
		if (evt instanceof PlayerDeathEvent) {
			PlayerDeathEvent event = (PlayerDeathEvent)evt;
			Player attacker = event.getEntity().getKiller();
			Player victim = event.getEntity().getPlayer();
			
			if (FileManager.hasValue(attacker, "kills")) {
				FileManager.setValue(attacker, "kills", ((Integer) FileManager.getValue(attacker, "kills")) + 1);
			} else {
				FileManager.setValue(attacker, "kills", 1);
			}
			if (FileManager.hasValue(victim, "deaths")) {
				FileManager.setValue(victim, "deaths", ((Integer) FileManager.getValue(victim, "deaths")) + 1);
			} else {
				FileManager.setValue(victim, "deaths", 1);
			}
		}
	}
}
