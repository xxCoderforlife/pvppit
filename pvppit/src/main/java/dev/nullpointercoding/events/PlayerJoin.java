package dev.nullpointercoding.events;

import java.io.File;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import dev.nullpointercoding.Main;
import dev.nullpointercoding.utils.ConfigurationHandler;
import dev.nullpointercoding.utils.Messages;

/**
 * PlayerJoin.java
 * 
 * 
 * 
 * @author NullpointerCoding (@xxCoderforlife)
 * @version 1.0
 */
public class PlayerJoin implements Listener{

    private Main plugin;
    private Messages m = new Messages();
    private ConfigurationHandler cH = new ConfigurationHandler("config");

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player p = (Player) e.getPlayer();

        p.sendMessage(cH.getConfig("config").getString("PVP-Pit.Message"));

    }
    
}
