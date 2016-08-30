package org.stormdev.mc.universaltime;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class UniversalTime extends JavaPlugin implements CommandExecutor {
	@EventHandler
	public void onEnable(){
		getCommand("timesync").setExecutor(this);
		
		syncWorldTimes();
	}
	
	public void syncWorldTimes(){
		//Make sure servers run at roughly the same time of day
		long ticksSinceEpoch = (long) (System.currentTimeMillis() / 50L);
		long ticks = ticksSinceEpoch % 24000;
        for(World w:Bukkit.getServer().getWorlds()){
        	w.setTime(ticks);
        }
        
        getLogger().info("All worlds have had their time changed to "+ticks+" ticks!");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args){
		syncWorldTimes();
		sender.sendMessage(ChatColor.GRAY+"Synced the world time!");
		return true;
	}
}
