package org.stormdev.mc.universaltime;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class UniversalTime extends JavaPlugin {
	@EventHandler
	public void onEnable(){
		//Make sure servers run at roughly the same time of day
		long ticksSinceEpoch = (long) (System.currentTimeMillis() / 50L);
		long ticks = ticksSinceEpoch % 24000;
        for(World w:Bukkit.getServer().getWorlds()){
        	w.setTime(ticks);
        }
        
        getLogger().info("All worlds have had their time changed to "+ticks+" ticks!");
	}
}
