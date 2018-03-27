/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodvel.core.route;

import kodvel.core.controller.Controller;

/**
 *  Store route information
 * 
 * Save method mane and COntroller object.
 * It used for calling the method from controller object.
 * @author Md. Rezve Hasan
 * @since 0.0.1
 */
public class RouteModel {
    private final String method;
    private final Controller controller;
    
    public RouteModel(Controller controller, String method) {
        this.controller = controller;
        this.method = method;
    }
    
    public Controller getController() {
        return this.controller;
    }
    
    public String getMethod() {
        return this.method;
    }
}
