/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import kodvel.core.controller.Controller;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rezve
 */
public class Home extends  Controller {
    public void index(HttpServletRequest req, HttpServletResponse res){
        System.out.println("Home");
        view("welcome", req,res);
    }
    
    public void documentation(HttpServletRequest req, HttpServletResponse res){
        //getServletContext().
        //view("welcome", req,res);
        System.out.println("documentation");
        RequestDispatcher view = req.getRequestDispatcher("index_F.html");
        
                
        try {
            res.sendRedirect("");
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
