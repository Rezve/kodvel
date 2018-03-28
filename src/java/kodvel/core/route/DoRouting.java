/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodvel.core.route;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kodvel.core.Kodvel;
import kodvel.core.errors.ErrorBody;
import kodvel.core.errors.Errors;

/**
 * Call the user-defined controller and method from the registered router.
 * 
 * @author Md. Rezve Hasan
 * @since 0.0.1
 */
public class DoRouting {
    private static HashMap<String, HashMap<String, RouteModel>> routeList;
    
    /**
     * Load users registered routes.
     */
    public DoRouting() {
        routeList = (HashMap<String, HashMap<String, RouteModel>>) Router.getAllRouteList();
    }
    
    /**
     * Get route list based on request method
     * 
     * For post request, it loads controller name and method that defined for POST
     * requests.
     *  
     * @param url requested URL
     * @param request user request
     * @param response user response
     */
    public void start(String url, HttpServletRequest request, HttpServletResponse response) {
        String requestMethod = getRequestType(request);
        RouteModel routeModel = routeList.get(requestMethod).get(url) ; 
        loadClass(routeModel, (HttpServletRequest)request, (HttpServletResponse)response);
    }
    
    /**
     * If a request path and method has a route defined or not.
     * 
     * @param requestMethod request HTTP method. POST,GET,PUT,PATCH, DELETE 
     * @param url requested URL
     * @return true or false
     */
    public static boolean hasRoute(String requestMethod, String url) {
        return routeList.containsKey(requestMethod) && routeList.get(requestMethod).containsKey(url);
    }
    
    /**
     * Get HTTP request method name.
     * 
     * @param request user request
     * @return String POST|GET|PUT|PATCH|DELETE
     */
    private String getRequestType(HttpServletRequest request) {
        return request.getMethod();
    }
    
    /**
     * Call user defined controller and method.
     * 
     * All the user-defined controller will get two parameters with the method.
     * @param route route information
     * @param request user request
     * @param response user response
     */
    private void loadClass(RouteModel route, HttpServletRequest request, HttpServletResponse response) {
        try {
            Method method = route.getController().getClass().getDeclaredMethod(route.getMethod(), HttpServletRequest.class, HttpServletResponse.class);
            Object[] argument = new Object[2];
            argument[0] =  request;
            argument[1] =  response;
            method.invoke(route.getController(), argument);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Kodvel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Kodvel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            //Logger.getLogger(Kodvel.class.getName()).log(Level.SEVERE, null, ex);
            Errors.message(response, new ErrorBody("Error in your controller", "In this class '"+route.getController().toString()+":"+route.getMethod()+"' "+ex.getCause(), ex));
        } catch (NoSuchMethodException ex) {
            Errors.message(response, new ErrorBody("No Such Method '"+route.getMethod()+"'", "The method name you specified for routing is not found in "+route.getController().getClass()+"", ex));
        } catch (SecurityException ex) {
            Logger.getLogger(Kodvel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
