/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.routes;

import app.controllers.Home;
import kodvel.interfaces.Route.BaseRouter;
import kodvel.core.route.Router;
/**
 *
 * @author rezve
 */
public class Web implements BaseRouter{

    @Override
    public void registerRouter() {
        Router.get("/", new Home(), "index");
        Router.post("/", new Home(), "documentation");
        Router.put("/", new Home(), "documentation");
        Router.patch("/", new Home(), "documentation");
        Router.delete("/", new Home(), "documentation");
    }
    
}
