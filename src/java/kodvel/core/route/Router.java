/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodvel.core.route;

import java.util.HashMap;
import kodvel.core.controller.Controller;

/**
 * Store all users route information
 * 
 * @author Md. Rezve Hasan
 * @since 0.0.1
 */
public class Router {
    private static HashMap<String, RouteModel> httpGetRouteList;
    private static HashMap<String, RouteModel> httpPostRouteList;
    private static HashMap<String, RouteModel> httpPutRouteList;
    private static HashMap<String, RouteModel> httpPatchRouteList;
    private static HashMap<String, RouteModel> httpDeleteRouteList;
    
    /**
     * This constructor is only called once from system class.
     * Initialize HashMaps.
     */
    public Router() {
        initRouteList();
    }
    
    /**
     * Initialize HashMaps.
     */
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
    
    /**
     * Map a GET request to the URL pattern and bind with controller and method.
     * 
     * Controller and method will be invoked when user requests for this URL pattern.
     * This is the place for binding URL and controller.
     * 
     * @param urlPattern String the URL for mapping
     * @param controller Controller Which controllers method should be called
     * @param methodName String method name of controller
     */
    public static void get(String urlPattern, Controller controller, String methodName) {
        httpGetRouteList.put(urlPattern, new RouteModel(controller,methodName));
    }
    
    /**
     * Map a POST request to the URL pattern and bind with controller and method.
     * 
     * Controller and method will be invoked when user requests for this URL pattern.
     * This is the place for binding URL and controller.
     * 
     * @param urlPattern String the URL for mapping
     * @param controller Controller Which controllers method should be called
     * @param methodName String method name of controller
     */
    public static void post(String urlPattern, Controller controller, String methodName) {
        httpPostRouteList.put(urlPattern, new RouteModel(controller,methodName));
    }
    
    /**
     * Map a PUT request to the URL pattern and bind with controller and method.
     * 
     * Controller and method will be invoked when user requests for this URL pattern.
     * This is the place for binding URL and controller.
     * 
     * @param urlPattern String the URL for mapping
     * @param controller Controller Which controllers method should be called
     * @param methodName String method name of controller
     */
    public static void put(String urlPattern, Controller controller, String methodName) {
        httpPutRouteList.put(urlPattern, new RouteModel(controller,methodName));
    }
    
    /**
     * Map a PATCH request to the URL pattern and bind with controller and method.
     * 
     * Controller and method will be invoked when user requests for this URL pattern.
     * This is the place for binding URL and controller.
     * 
     * @param urlPattern String the URL for mapping
     * @param controller Controller Which controllers method should be called
     * @param methodName String method name of controller
     */
    public static void patch(String urlPattern, Controller controller, String methodName) {
        httpPatchRouteList.put(urlPattern, new RouteModel(controller,methodName));
    }
    
    /**
     * Map a DELETE request to the URL pattern and bind with controller and method.
     * 
     * Controller and method will be invoked when user requests for this URL pattern.
     * This is the place for binding URL and controller.
     * 
     * @param urlPattern String the URL for mapping
     * @param controller Controller Which controllers method should be called
     * @param methodName String method name of controller
     */
    public static void delete(String urlPattern, Controller controller, String methodName) {
        httpDeleteRouteList.put(urlPattern, new RouteModel(controller,methodName));
    }
    
    /**
     * Get all routes.
     * 
     * All the routes packed with HTTP method name.
     * 
     * @return HashMap all routes packed with HTTP method
     */
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
