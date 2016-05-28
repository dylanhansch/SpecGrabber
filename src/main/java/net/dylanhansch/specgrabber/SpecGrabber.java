package net.dylanhansch.specgrabber;

import net.dylanhansch.specgrabber.command.*;

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
		getCommand("java").setExecutor(new JavaCommand(this));
		getCommand("os").setExecutor(new OsCommand(this));
		getCommand("top").setExecutor(new TopCommand(this));
	}
}
