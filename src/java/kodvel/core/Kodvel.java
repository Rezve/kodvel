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
import javax.servlet.http.HttpServletRequest;
import kodvel.core.route.RouteModel;
import kodvel.core.route.Router;
import kodvel.interfaces.Route.BaseRouter;

/**
 *
 * @author rezve
 */
public class Kodvel {
    private static Kodvel kodvel;
    private static HashMap<String, HashMap<String, RouteModel>> routeList;
    private final BaseRouter baseRouter;
    private Router router;
    
    public Kodvel() {
        router = new Router();
        baseRouter = new Web();
        baseRouter.registerRouter();
        
        routeList = (HashMap<String, HashMap<String, RouteModel>>) Router.getAllRouteList();
        
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
        String requestMethod = getRequestType(req);
        
        if(hasRoute(requestMethod, url)){
            RouteModel routeModel = routeList.get(requestMethod).get(url) ; 
            loadClass(routeModel, req, res);
        }else{
            System.err.println("Invalid URL (No route set for : '"+ url+"')");
        }
    }
    
    private boolean hasRoute(String requestMethod, String url) {
        return routeList.containsKey(requestMethod) && routeList.get(requestMethod).containsKey(url);
    }
    
    private String getRequestType(ServletRequest request) {
        HttpServletRequest httpRequest = (HttpServletRequest) request;        
        return httpRequest.getMethod();
    }
    
    private void loadClass(RouteModel route, ServletRequest req, ServletResponse res) {
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
