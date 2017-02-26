package me.reparo.chatthing.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.reparo.chatthing.Util;

public class ChatClear implements CommandExecutor {
	
	 
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("chatclear")) {
			if(Util.hasPermission(s, "chatthing.chatclear")) {
				if(Util.isEnabled("chatclear")) {
					for (int x = 0; x < Util.spamchat; x++){
					    Bukkit.broadcastMessage(Util.spamchatwith(s));
					}
					Bukkit.broadcastMessage(Util.chathasbeencleared(s));	
				} else {
					s.sendMessage("That feature is disabled by your administrators.");
				}
			}
		}
		
		
		
		return true;
	}
	
}