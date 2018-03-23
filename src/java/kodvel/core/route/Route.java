/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodvel.core.route;

import kodvel.core.Controller;

/**
 *
 * @author rezve
 */
public class Route {
    private String method;
    private String httpMethod;
    private Controller controller;
    
    public Route(Controller controller, String method, String httpMethod) {
        this.controller = controller;
        this.method = method;
        this.httpMethod = httpMethod;
    }
    
    public Controller getController() {
        return this.controller;
    }
    
    public String getMethod() {
        return this.method;
    }
    
    public String gethttpMethod() {
        return this.httpMethod;
    }
}
