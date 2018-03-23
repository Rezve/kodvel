/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import kodvel.core.Controller;

/**
 *
 * @author rezve
 */
public class Home extends  Controller {
    public void index(ServletRequest req, ServletResponse res){
        System.out.println("Home");
        view("welcome", req,res);
    }
}
