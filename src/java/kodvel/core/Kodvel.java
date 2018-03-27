/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodvel.core;

import app.config.Config;
import app.routes.Web;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kodvel.core.route.DoRouting;
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
    private BaseRouter baseRouter;
    private Router router;
    private DoRouting doRouting;
    private Config config;
    public Kodvel() {
        if(kodvel == null) {
            kodvel = this;
            initSystem();
        }
    }
    
    private void initSystem() {
        config = new Config();
        router = new Router();
        doRouting = new DoRouting();
        baseRouter = new Web();
        baseRouter.registerRouter();
        
        routeList = (HashMap<String, HashMap<String, RouteModel>>) Router.getAllRouteList();
    }
    
    public static Kodvel getInstance() {
        if(kodvel == null) {
            kodvel = new Kodvel();
        }
        return kodvel;
    }
    
    public void doRoute(String url, HttpServletRequest request, HttpServletResponse response) {
        doRouting.start(url, request, response);
    }  
}
