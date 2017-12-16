package de.tutorial.main;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.tutorial.commands.backCommand;
import de.tutorial.commands.vanishCommand;
import de.tutorial.listeners.backListeners;
import de.tutorial.listeners.vanishListeners;

public class Main extends JavaPlugin {
	
	// Initialisierung der ArrayList "vanish".
	// ArrayList: Eine Liste in der Werte eingetragen werden können, wie z.B. ein Spieler.
	public static ArrayList<Player> vanish = new ArrayList<>();
	
	// Initialisierung der HashMap "lastLocation".
	// HashMap: Eine Liste in der je zwei zueinandergehörige Werte eingetragen werden können, wie z.B. ein Spieler und seine Position.
	public static HashMap<Player, Location> lastLocation = new HashMap<>();
	
	@Override
	public void onEnable() {
		getCommand("vanish").setExecutor(new vanishCommand());
		getCommand("back").setExecutor(new backCommand());
		
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new vanishListeners(), this);
		pm.registerEvents(new backListeners(), this);
	}
	
}
