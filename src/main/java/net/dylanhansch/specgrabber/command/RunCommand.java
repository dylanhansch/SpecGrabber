package net.dylanhansch.specgrabber.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import net.dylanhansch.specgrabber.SpecGrabber;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RunCommand implements CommandExecutor {
	@SuppressWarnings("unused")
	private final SpecGrabber plugin;
	
	public RunCommand(SpecGrabber plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args){
		if(args.length == 0){
			sender.sendMessage(ChatColor.RED + "Error: Not enough arguments!");
			return false;
		}
		if(args.length >= 1){
			StringBuilder command = new StringBuilder("");
			for (String part : args){
				if(!command.toString().equals(""))
					command.append(" ");
				
				command.append(part);
			}
			
			try{
				Process p = Runtime.getRuntime().exec(command.toString());
				BufferedReader pin = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line;
				while((line = pin.readLine()) != null){
					sender.sendMessage(line);
				}
			}catch(IOException e){
				sender.sendMessage(ChatColor.RED + "Error: " + e.getLocalizedMessage());
			}
		}
		
		return true;
	}
}
