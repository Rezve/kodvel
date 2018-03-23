/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodvel.core;

import app.controllers.Home;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author rezve
 */
public class Loader extends HttpServlet{
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
       
        //get kodvel instance
        //route the request
        
        
        
        
        
        Home home = new Home();
//        
       System.out.println("Base Controller: service");
       try {
            Method m = home.getClass().getDeclaredMethod("index", ServletRequest.class, ServletResponse.class);
            Object[] argument = new Object[2];
            argument[0] = req;
            argument[1] = res;
            
            m.invoke(home, argument);
            //String path = req.get();
            // System.out.println(path);
            
            //RequestDispatcher dispatcher=req.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
            //dispatcher.forward(req, res);  
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
}
