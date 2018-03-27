/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import javax.servlet.http.HttpServletRequest;
import kodvel.core.controller.Controller;
import javax.servlet.http.HttpServletResponse;

/**
 * Welcome controller
 * 
 * Default controller registered with '/' path in Router.
 * @author Md. Rezve Hasan
 * @since 0.0.1
 */
public class WelcomeController extends  Controller {
    /**
     * Load view from directory 'WEB-INF/views/'
     * 
     * @param req user request
     * @param res user response
     */
    public void welcome(HttpServletRequest req, HttpServletResponse res){
        view("welcome", req,res);
    }
}
