package dev.nullpointercoding.utils;

/**
 * Setup.java
 * 
 * 
 * @author NullpointerCoding (@xxCoderforlife)
 * @version 1.0
 */
public class Setup {

    private ConfigurationHandler cH = new ConfigurationHandler(null);
    public Setup() {
        cH.loadAllFilesOnDisk();
    }
}
