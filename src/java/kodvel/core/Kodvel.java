/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodvel.core;

import app.router.Web;
import java.util.HashMap;
import kodvel.core.route.Route;
import kodvel.interfaces.Route.Router;

/**
 *
 * @author rezve
 */
public class Kodvel {
    private static Kodvel kodvel;
    private static HashMap<String, Route> routeList;
    private final Router router;
    
    public Kodvel() {
        router = new Web();
        routeList = (HashMap<String, Route>) router.getRouteList();
    }
    
    public static Kodvel getInstance() {
        if(kodvel == null) {
            kodvel = new Kodvel();
        }
        return kodvel;
    }

    
}
