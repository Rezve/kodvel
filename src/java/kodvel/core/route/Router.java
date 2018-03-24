/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodvel.core.route;

import java.util.HashMap;
import kodvel.core.controller.Controller;

/**
 *
 * @author rezve
 */
public class Router {
    private static HashMap<String, RouteModel> httpGetRouteList;
    private static HashMap<String, RouteModel> httpPostRouteList;
    private static HashMap<String, RouteModel> httpPutRouteList;
    private static HashMap<String, RouteModel> httpPatchRouteList;
    private static HashMap<String, RouteModel> httpDeleteRouteList;
    
    public Router() {
        initRouteList();
    }
    
    private void initRouteList() {
        if(httpGetRouteList == null) {
            httpGetRouteList = new HashMap<>();
        }
        if(httpPostRouteList == null) {
            httpPostRouteList = new HashMap<>();
        }
        if(httpPutRouteList == null) {
            httpPutRouteList = new HashMap<>();
        }
        if(httpPatchRouteList == null) {
            httpPatchRouteList = new HashMap<>();
        }
        if(httpDeleteRouteList == null) {
            httpDeleteRouteList = new HashMap<>();
        }
    }
    
    public static void get(String urlPattern, Controller controller, String methodName) {
        httpGetRouteList.put(urlPattern, new RouteModel(controller,methodName));
    }
    
    public static void post(String urlPattern, Controller controller, String methodName) {
        httpPostRouteList.put(urlPattern, new RouteModel(controller,methodName));
    }
    
    public static void put(String urlPattern, Controller controller, String methodName) {
        httpPutRouteList.put(urlPattern, new RouteModel(controller,methodName));
    }
    
    public static void patch(String urlPattern, Controller controller, String methodName) {
        httpPatchRouteList.put(urlPattern, new RouteModel(controller,methodName));
    }
    
    public static void delete(String urlPattern, Controller controller, String methodName) {
        httpDeleteRouteList.put(urlPattern, new RouteModel(controller,methodName));
    }
    
    public static HashMap<String, RouteModel> getHttpRouteList() {
        return httpGetRouteList;
    }
    
    public static HashMap<String, HashMap<String, RouteModel>> getAllRouteList() {
        HashMap<String, HashMap<String, RouteModel>> list = new HashMap<>();
        list.put("GET", httpGetRouteList);
        list.put("POST", httpPostRouteList);
        list.put("PUT", httpPutRouteList);
        list.put("PATCH", httpPatchRouteList);
        list.put("DELETE", httpDeleteRouteList);
        return list;
    }
}
