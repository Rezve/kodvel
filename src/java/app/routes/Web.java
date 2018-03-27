/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.routes;

import app.controllers.Blog;
import app.controllers.WelcomeController;
import kodvel.interfaces.Route.BaseRouter;
import kodvel.core.route.Router;
/**
 * Register routes
 * 
 * @author Md. Rezve Hasan
 * @since 0.0.1
 */
public class Web implements BaseRouter{
    /**
     * Register your routes here.
     * 
     * Your controller and method will be invoked when user request for the specified URL.
     * Currently supported HTTP methods are GET,POST,PUT,PATCH,DELETE
     */
    @Override
    public void registerRouter() {
        Router.get("/", new WelcomeController(), "welcome");
        
        Router.get("/blog", new Blog(), "index");
        Router.get("/blog/create", new Blog(), "create");
        Router.post("/blog/store", new Blog(), "store");
    }
    
}
