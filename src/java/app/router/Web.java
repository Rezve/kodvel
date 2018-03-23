/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.router;

import app.controllers.Home;
import java.util.HashMap;
import kodvel.core.route.Route;
import kodvel.interfaces.Route.Router;

/**
 *
 * @author rezve
 */
public class Web implements Router{

    @Override
    public HashMap<String, Route> getRouteList() {
        HashMap<String, Route> route = new HashMap<String, Route>();
        
        route.put("/", new Route(new Home(), "index", "get"));
        
        return route;
    }
    
}
