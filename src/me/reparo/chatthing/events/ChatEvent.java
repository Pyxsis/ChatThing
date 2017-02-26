package me.reparo.chatthing.events;


import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.reparo.chatthing.ChatThing;
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
		/*
		 *  Chat Delay (anti spam)
		 */
		if(Util.isEnabled("chatdelay") && !e.getPlayer().hasPermission("chatthing.chatdelay.bypass")) {
			if(Util.delayedchat.contains(e.getPlayer())) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(Util.delaystoppingchatmsg(e.getPlayer()));
			} else {
				Util.delayedchat.add(e.getPlayer());
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(ChatThing.ct, new Runnable() {
					public void run() {
						Util.delayedchat.remove(e.getPlayer());
					}
				}, Util.chatdelay*20);
			}
		}
	}
	
}
