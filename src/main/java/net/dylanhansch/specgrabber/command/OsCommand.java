package net.dylanhansch.specgrabber.command;

import net.dylanhansch.specgrabber.SpecGrabber;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class OsCommand implements CommandExecutor {
	@SuppressWarnings("unused")
	private final SpecGrabber plugin;
	
	public OsCommand(SpecGrabber plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		sender.sendMessage(ChatColor.GOLD + "OS Architecture: " + ChatColor.RESET + System.getProperty("os.arch"));
		sender.sendMessage(ChatColor.GOLD + "OS Name: " + ChatColor.RESET + System.getProperty("os.name"));
		sender.sendMessage(ChatColor.GOLD + "OS Version: " + ChatColor.RESET + System.getProperty("os.version"));
		return true;
	}
}
