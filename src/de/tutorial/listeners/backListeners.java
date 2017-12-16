package de.tutorial.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

import de.tutorial.main.Main;

public class backListeners implements Listener {
	
	@EventHandler
	public void onTeleport(PlayerTeleportEvent e) {
		Player p = (Player) e.getPlayer();
		
		// Abfrage, ob der Teleportgrund KEIN Command war.
		if(e.getCause() != TeleportCause.COMMAND) {
			// Fügt der HashMap einen Eintrag über den Spieler und seine Position hinzu.
			Main.lastLocation.put(p, e.getFrom());
			p.sendMessage("§eZurück mit /back");
		}
	}
	
	@EventHandler
	public void onDeath(PlayerDeathEvent e) {
		Player p = (Player) e.getEntity();
		
		// Fügt der HashMap einen Eintrag über den Spieler und seine Position hinzu.
		Main.lastLocation.put(p, p.getLocation());
	}
	
	@EventHandler
	public void onRespawn(PlayerRespawnEvent e) {
		Player p = (Player) e.getPlayer();
		
		p.sendMessage("§eZurück mit /back");
	}
	
}
