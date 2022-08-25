package dev.nullpointercoding;

import org.bukkit.plugin.java.JavaPlugin;

import dev.nullpointercoding.utils.Setup;

/**
 * Main.java (PVP-Pit Plugin)
 * 
 * 
 * @author NullpointerCoding (@xxCoderforlife)
 * @version 1.0
 */
public class Main extends JavaPlugin{

    private Main instance;
    private Setup su;

    public void onEnable() {
        instance = this;
        su = new Setup();
    }
    public void onDisable() {
    }

    public Main getInstance() {
        return instance;
    }
    
}