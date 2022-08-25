package dev.nullpointercoding.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;

import net.md_5.bungee.api.ChatColor;

/**
 * Messages.java
 * 
 * 
 * @author NullpointerCoding (@xxCoderforlife)
 * @version 1.0
 */
public class Messages {


    /**
     * Can use '&' as color code {@link org.bukkit.ChatColor}
     * @param s
     * @return String with color codes
     */
    public void sendConsoleMessage(String s) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', s));
    }

    /**
     * Use '#' to start and end the string of color for HEX
     * @param s
     * @return String with HEX colors
     */
    public void sendHexMessageAsConsole(String s) {
        colorize(s);
        Bukkit.getConsoleSender().sendMessage(s);
    }

    public void sendPlayerHexMessage(String s){
        colorize(s);
    }

    private static final Pattern HEX_PATTERN = Pattern.compile("&(#\\w{6})");
    public static String colorize(String str)
    {
        Matcher matcher = HEX_PATTERN.matcher(ChatColor.translateAlternateColorCodes('&', str));
        StringBuffer buffer = new StringBuffer();

        while (matcher.find())
            matcher.appendReplacement(buffer, ChatColor.of(matcher.group(1)).toString());

        return matcher.appendTail(buffer).toString();
    }
}
