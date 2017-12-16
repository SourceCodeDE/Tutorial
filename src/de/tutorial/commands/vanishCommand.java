package de.tutorial.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.tutorial.main.Main;

public class vanishCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		// Abfrage, ob der Spieler die Permission "Tutorial.Vanish" hat, und/oder OP ist.
		if(p.hasPermission("Tutorial.Vanish") || p.isOp()) {
			// Abfrage, die prüft, ob der Spieler bereits in der Vanish ArrayList enthalten ist.
			if(!(Main.vanish.contains(p))) {
				// Addet den Spieler zur ArrayList.
				Main.vanish.add(p);
				p.sendMessage("§aDu bist nun Vanish!");
				
				// for-Schleife die alle Spieler die zur Zeit Online sind durchgeht.
				for(Player all : Bukkit.getOnlinePlayers()) {
					// Abfrage, ob der aktuelle Spieler der for-Schleife die Permission "Tutorial.Vanish.See" NICHT hat UND NICHT OP ist.
					if(!all.hasPermission("Tutorial.Vanish.See") && !all.isOp()) {
						// Versteckt Spieler p für den aktuellen Spieler aus der for-Schleife.
						all.hidePlayer(p);
					}
				}
			}else {
				// Entfernt den Spieler aus der ArrayList.
				Main.vanish.remove(p);
				p.sendMessage("§aDu bist nun nicht mehr Vanish!");
				
				// for-Schleife die alle Spieler die zur Zeit Online sind durchgeht.
				for(Player all : Bukkit.getOnlinePlayers()) {
					// Abfrage, ob der aktuelle Spieler der for-Schleife den Spieler p nicht sehen kann.
					if(!all.canSee(p)) {
						// Zeigt Spieler p für den aktuellen Spieler aus der for-Schleife.
						all.hidePlayer(p);
					}
				}
			}
		}else {
			p.sendMessage("§cDazu hast du keine Rechte!");
		}
		return true;
	}
	
}
