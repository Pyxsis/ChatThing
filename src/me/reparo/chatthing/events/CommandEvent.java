package me.reparo.chatthing.events;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.reparo.chatthing.Util;

public class CommandEvent implements Listener {
	
	@EventHandler
	public void chat(PlayerCommandPreprocessEvent e) {
		/*
		 * Chat lock
		 */
		if(Util.chatlocked && !e.getPlayer().hasPermission("chatthing.chatlock.bypass") && Util.isEnabled("chatlock")) {
			for(String command : Util.chatlockcommands) {
				if(e.getMessage().startsWith(command)) {
					e.setCancelled(true);
					e.getPlayer().sendMessage(Util.chatlockenablederrormessage(e.getPlayer()));
				}
			}
		}
	}
	
}
