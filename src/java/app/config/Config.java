/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.config;

import java.util.HashMap;

/**
 * Set configurations
 * 
 * @author Md. Rezve Hasan
 * @since 0.0.1
 */
public class Config {
    private static HashMap<String, Object> config = new HashMap<>();
    
    public Config() {
        if(config.isEmpty())
            setConfig();
    }
    private void setConfig() {
           
        /**
         * Define project environment
         * 
         * Example: production | development
         */
        config.put("environment", "development"); 
    }
    
    /**
     * Get the value from configuration key
     * 
     * @param key String key name
     * @return Object value set by the user
     */
    public static Object getConfig(String key) {
        return config.get(key);
    } 
}
