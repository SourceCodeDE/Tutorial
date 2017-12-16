package de.tutorial.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.tutorial.main.Main;

public class vanishListeners implements Listener {
	
	
	// PlayerJoinEvent: wird aufgerufen, sobald ein Spieler den Server betritt.
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = (Player) e.getPlayer();
		
		// Abfrage, ob der Spieler die Permission "Tutorial.Vanish.See" NICHT hat UND NICHT OP ist.
		if (!p.hasPermission("Tutorial.Vanish.See") && !p.isOp()) {
			// for-Schleife die alle Spieler die zur Zeit Online sind durchgeht.
			for (Player all : Bukkit.getOnlinePlayers()) {
				// Abfrage, ob der aktuelle Spieler der for-Schleife in der ArrayList "vanish" enthalten ist.
				if (Main.vanish.contains(all)) {
					// Versteckt den aktuellen Spieler der for-Schleife für den gejointen Spieler.
					p.hidePlayer(all);
				}
			}
		}
	}

}
