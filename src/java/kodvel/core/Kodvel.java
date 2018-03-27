/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodvel.core;

import app.config.Config;
import app.routes.Web;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kodvel.core.route.DoRouting;
import kodvel.core.route.Router;
import kodvel.interfaces.Route.BaseRouter;

/**
 *  Main system class
 * 
 * Load configurations, routes
 * @author Md. Rezve Hasan
 * @since 0.0.1
 */
public class Kodvel {
    private static Kodvel kodvel;
    private BaseRouter baseRouter;
    private Router router;
    private DoRouting doRouting;
    private Config config;
    
    /**
     * Create system instance Call initSystem which load routes
     * and required create objects.
     */
    public Kodvel() {
        if(kodvel == null) {
            kodvel = this;
            initSystem();
        }
    }
    
    /**
     * Create objects for routing, register routes from users list.
     * 
     * TODO: load user route file from Config file.
     */
    private void initSystem() {
        config = new Config();
        router = new Router();
        doRouting = new DoRouting();
        baseRouter = new Web();
        baseRouter.registerRouter();
    }
    
    /**
     * Get system instance
     * 
     * @return system instance
     */
    public static Kodvel getInstance() {
        if(kodvel == null) {
            kodvel = new Kodvel();
        }
        return kodvel;
    }
    
    /**
     * Send the request for actual routing.
     * 
     * @param url users requested path
     * @param request user request
     * @param response user response
     */
    public void doRoute(String url, HttpServletRequest request, HttpServletResponse response) {
        doRouting.start(url, request, response);
    }  
}
