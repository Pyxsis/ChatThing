package me.reparo.chatthing;


import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.reparo.chatthing.commands.ChatClear;
import me.reparo.chatthing.commands.ChatLock;
import me.reparo.chatthing.events.ChatEvent;
import me.reparo.chatthing.events.CommandEvent;

public class ChatThing extends JavaPlugin implements Listener {
	
	public static ChatThing ct;
	 
	@Override
	public void onEnable() {
		ct = this;
		Util.chatlocked = false;
		saveDefaultConfig();
		registerCommands();
		registerEvents();
	}

	  private void registerCommands() {
		  getCommand("chatlock").setExecutor(new ChatLock());
		  getCommand("chatclear").setExecutor(new ChatClear());
	  }
	  
	  private void registerEvents() {
		  Bukkit.getServer().getPluginManager().registerEvents(new ChatEvent(), this);
		  Bukkit.getServer().getPluginManager().registerEvents(new CommandEvent(), this);
	  }
	  
}
