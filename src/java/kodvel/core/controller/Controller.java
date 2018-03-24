/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodvel.core.controller;

import app.controllers.Home;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *
 * @author rezve
 */
public class Controller {
    protected static void view(String file, ServletRequest req, ServletResponse res) {
        RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/views/"+file+".jsp");
        
        try {  
            dispatcher.forward(req, res);
        } catch (ServletException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
