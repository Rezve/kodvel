/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodvel.core.route;

import kodvel.core.controller.Controller;

/**
 *
 * @author rezve
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
