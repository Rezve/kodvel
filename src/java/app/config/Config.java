/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.config;

import java.util.HashMap;

/**
 *
 * @author rezve
 */
public class Config {
    private static HashMap<String, Object> config = new HashMap<>();
    
    public Config() {
        if(config.isEmpty())
            setConfig();
    }
    private void setConfig() {
        
        
        /**
         * Supported static assets
         * 
         * Separated by comma. 
         * Example: jsp,html,css,js
         */
        config.put("static_assets", "jsp,html,css,js");
        
        /**
         * Define project environment
         * 
         * Example: production | development
         */
        config.put("environment", "development"); 
    }

    public static Object getConfig(String key) {
        return config.get(key);
    } 
}
