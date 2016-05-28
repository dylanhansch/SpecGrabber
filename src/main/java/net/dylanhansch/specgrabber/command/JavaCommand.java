package net.dylanhansch.specgrabber.command;

import net.dylanhansch.specgrabber.SpecGrabber;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class JavaCommand implements CommandExecutor {
	@SuppressWarnings("unused")
	private final SpecGrabber plugin;
	
	public JavaCommand(SpecGrabber plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		sender.sendMessage(ChatColor.GOLD + "JRE directory: " + ChatColor.RESET + System.getProperty("java.home"));
		sender.sendMessage(ChatColor.GOLD + "JRE version: " + ChatColor.RESET + System.getProperty("java.version"));
		return true;
	}
}
