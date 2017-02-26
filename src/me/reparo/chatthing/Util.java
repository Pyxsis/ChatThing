package me.reparo.chatthing;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Util {
	/*
	 * Configuration file
	 */
	static FileConfiguration getConfig() {
		return ChatThing.ct.getConfig();
	}
	
	
	/*
	 * Colour // variables
	 */
	public static String colour(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
	public static String colour(CommandSender sender, String s) {
		if(sender instanceof Player) { return ChatColor.translateAlternateColorCodes('&', s)
					.replace("%sendername", sender.getName())
					.replace("%senderdisplay", ((Player) sender).getDisplayName());
		} else { return ChatColor.translateAlternateColorCodes('&', s)
					.replace("%sendername", sender.getName())
					.replace("%senderdisplay", sender.getName()); 
		}
		
	}
	
	
	/*
	 * Chat lock
	 */
	public static boolean chatlocked;
	public static List<String> chatlockcommands = getConfig().getStringList("Chat lock blocked commands");
	public static String chatlockenabledbroadcast(CommandSender sender) { return colour(sender, getConfig().getString("Chat lock enabled broadcast")); }
	public static String chatlockdisabledbroadcast(CommandSender sender) { return colour(sender, getConfig().getString("Chat lock disabled broadcast")); }
	public static String chatlockenablederrormessage(CommandSender sender) { return colour(sender, getConfig().getString("Chat lock enabled error message")); }
	
		
	/*
	 * Chat clear 
	 */
	public static String spamchatwith(CommandSender sender) { return colour(sender, getConfig().getString("Spam chat with")); }
	public static String chathasbeencleared(CommandSender sender) { return colour(sender, getConfig().getString("Chat has been cleared")); }
	public static int spamchat = getConfig().getInt("Spam chat");

		
	/*
	 * Permission handling
	 */
	public static boolean hasPermission(CommandSender sender, String permission) {
		if(sender.hasPermission(permission)) {
			return true;
		} else {
			sender.sendMessage(colour(sender, getConfig().getString("No permission"))); 
			return false;
		}
	}
	
	
	/*
	 * Enabled or disabled feature
	 */
	public static boolean isEnabled(String feature) {
		if(feature.equalsIgnoreCase("commandspy")) {
			return getConfig().getBoolean("Enable commandspy");
		} else if(feature.equalsIgnoreCase("chatclear")) {
			return getConfig().getBoolean("Enable chatclear");
		} else if(feature.equalsIgnoreCase("chatlock")) {
			return getConfig().getBoolean("Enable chatlock");
		} else {
			return false;
		}
	}
	
	
}
