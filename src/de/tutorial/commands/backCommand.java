package de.tutorial.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.tutorial.main.Main;

public class backCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		// Abfrage, ob der Spieler einen Eintrag in der HashMap lastLocation hat.
		if(Main.lastLocation.containsKey(p)) {
			// Teleportiert den Spieler an seine gespeicherte Position.
			p.teleport(Main.lastLocation.get(p));
			// Entfernt den Eintrag über den Spieler.
			Main.lastLocation.remove(p);
		}else {
			p.sendMessage("§cEs ist keine letzte Position gespeichert!");
		}
		return true;
	}
}
