package net.dylanhansch.specgrabber.command;

import net.dylanhansch.specgrabber.SpecGrabber;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CpuCommand implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private final SpecGrabber plugin;
	
	public CpuCommand(SpecGrabber plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		sender.sendMessage(ChatColor.GOLD + "Available processors (cores): " + ChatColor.RESET + Runtime.getRuntime().availableProcessors());
		return true;
	}
}
