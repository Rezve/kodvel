/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodvel.core;

import app.routes.Web;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
        
        if(kodvel == null) {
            kodvel = this;
        }
    }
    
    public static Kodvel getInstance() {
        if(kodvel == null) {
            kodvel = new Kodvel();
        }
        return kodvel;
    }
    
    public void doRoute(String url, ServletRequest req, ServletResponse res) {
        if( routeList.containsKey(url) ) {
            loadClass(routeList.get(url), req, res);
        }else{
            //404 page
            System.err.println("Invalid URL (No route set for : '"+ url+"')");
        }
    }
    
    private void loadClass(Route route, ServletRequest req, ServletResponse res) {
        try {
            Method method = route.getController().getClass().getDeclaredMethod(route.getMethod(), ServletRequest.class, ServletResponse.class);
            Object[] argument = new Object[2];
            argument[0] = req;
            argument[1] = res;
            method.invoke(route.getController(), argument);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(Kodvel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
