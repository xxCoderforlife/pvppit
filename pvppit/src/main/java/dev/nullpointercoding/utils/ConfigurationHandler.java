package dev.nullpointercoding.utils;

import java.io.File;

import javax.annotation.Nullable;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import dev.nullpointercoding.Main;

/**
 * ConfigurationHandler.java
 * 
 * 
 * @author NullpointerCoding (@xxCoderforlife)
 * @version 1.0
 */
public class ConfigurationHandler {
    
    private File configFile;
    private FileConfiguration config;
    private Main plugin;
    private File dataFolder = plugin.getDataFolder();
    private Messages m = new Messages();


    /**
     * Enter the name of the file you want to use.
     *
     * @param fileName
     */
    @Nullable
    public ConfigurationHandler(String fileName) {
        configFile = new File(dataFolder, fileName + ".yml");
    }


    public void loadAllFilesOnDisk(){
        checkForFileInJar();
        for(File f : dataFolder.listFiles()){
            if(f.getName().endsWith(".yml")){
                loadFile(f);
                m.sendHexMessageAsConsole("&#4b3ac5 What Dog?");
            }
        }

    }

    private void loadFile(File f) {
        config = YamlConfiguration.loadConfiguration(f);
    }


    /**
     * Loads the config file.
     */
    public void checkForFileInJar(){
        if(!(configFile.exists())){
            configFile.getParentFile().mkdirs();
            plugin.saveResource(dataFolder + File.separator + configFile.getName() + ".yml", false);
            loadCondfig();
        }else{
            loadCondfig();
        }
    }

    public YamlConfiguration getConfig(String s){
        for(File f : dataFolder.listFiles()){
            if(f.getName().equals(s + ".yml")){
                configFile = f;
            }
            m.sendHexMessageAsConsole("#" + s + " Is not file#");
            return null;
        }
        return (YamlConfiguration) config;
    }

    private void loadCondfig(){
        config = new YamlConfiguration();
        try{
            config.load(configFile);
        }catch(Exception e){

        }
    }

    public void saveConfig(){
        try{
            config.save(configFile);
        }catch(Exception e){

        }
    }
}
