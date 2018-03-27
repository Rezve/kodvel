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
 *
 * @author rezve
 */
public class DoRouting {
    private static HashMap<String, HashMap<String, RouteModel>> routeList;
    
    public DoRouting() {
        routeList = (HashMap<String, HashMap<String, RouteModel>>) Router.getAllRouteList();
    }
    
    public void start(String url, HttpServletRequest request, HttpServletResponse response) {
        String requestMethod = getRequestType(request);
        
        if(hasRoute(requestMethod, url)){
            RouteModel routeModel = routeList.get(requestMethod).get(url) ; 
            loadClass(routeModel, (HttpServletRequest)request, (HttpServletResponse)response);
        }else{
            Errors.message((HttpServletResponse) response, new ErrorBody("404 Not found!", "No route is set for : '"+ url + "' path", null));
            System.err.println("Invalid URL (No route set for : '"+ url+"')");
        }
    }
    
    private boolean hasRoute(String requestMethod, String url) {
        return routeList.containsKey(requestMethod) && routeList.get(requestMethod).containsKey(url);
    }
    
    private String getRequestType(HttpServletRequest request) {
        return request.getMethod();
    }
    
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
            Logger.getLogger(Kodvel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Errors.message(response, new ErrorBody("No Such Method '"+route.getMethod()+"'", "The method name you specified for routing is not found in "+route.getController().getClass()+"", ex));
        } catch (SecurityException ex) {
            Logger.getLogger(Kodvel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
