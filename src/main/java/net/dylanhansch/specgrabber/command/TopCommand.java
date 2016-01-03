package net.dylanhansch.specgrabber.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;

import net.dylanhansch.specgrabber.SpecGrabber;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/*
 * Kudos to @cmastudios for this code snippet.
 * Can be found at https://github.com/cmastudios/WHChat/
 */

public class TopCommand implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private final SpecGrabber plugin;
	
	public TopCommand(SpecGrabber plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		int pid = Integer.parseInt(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);
		try{
			Process p = Runtime.getRuntime().exec("top -n 1 -b -p " + pid);
			BufferedReader pin = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while((line = pin.readLine()) != null){
				sender.sendMessage(line);
			}
		}catch(IOException e){
			sender.sendMessage(ChatColor.RED + "Error: " + e.getLocalizedMessage());
		}
		return true;
	}
}
