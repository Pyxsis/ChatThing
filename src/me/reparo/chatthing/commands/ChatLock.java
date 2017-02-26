package me.reparo.chatthing.commands;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.reparo.chatthing.Util;

public class ChatLock implements CommandExecutor {
	
	 
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("chatlock")) {
			if(Util.hasPermission(s, "chatthing.chatlock")) {
				if(Util.isEnabled("chatlock")) {
					if(Util.chatlocked) {
						Util.chatlocked = false;
						Bukkit.broadcast(Util.chatlockdisabledbroadcast(s), "chatthing.chatlock.broadcasts");
					} else {
						Util.chatlocked = true;
						Bukkit.broadcast(Util.chatlockenabledbroadcast(s), "chatthing.chatlock.broadcasts");
					}	
				} else {
					s.sendMessage("That feature is disabled by your administrators.");
				}
			}
		}
		
		
		
		return true;
	}
	
}
