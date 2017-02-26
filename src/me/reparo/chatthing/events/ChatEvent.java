package me.reparo.chatthing.events;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.reparo.chatthing.Util;

public class ChatEvent implements Listener {
	
	@EventHandler
	public void chat(AsyncPlayerChatEvent e) {
		/*
		 * Chat lock
		 */
		if(Util.chatlocked && !e.getPlayer().hasPermission("chatthing.chatlock.bypass") && Util.isEnabled("chatlock")) {
			e.setCancelled(true);
			e.getPlayer().sendMessage(Util.chatlockenablederrormessage(e.getPlayer()));
		}
	}
	
}
