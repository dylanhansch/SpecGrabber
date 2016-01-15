package net.dylanhansch.specgrabber;

import net.dylanhansch.specgrabber.command.CpuCommand;
import net.dylanhansch.specgrabber.command.TopCommand;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class SpecGrabber extends JavaPlugin implements Listener {
	
	@Override
	public void onDisable(){
	}
	
	@Override
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		getCommand("cpu").setExecutor(new CpuCommand(this));
		getCommand("top").setExecutor(new TopCommand(this));
	}
	
}
