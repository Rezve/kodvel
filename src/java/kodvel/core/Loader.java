/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodvel.core;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rezve
 */
@WebServlet(value = "/app/*", loadOnStartup = 1)
public class Loader extends HttpServlet{

    @Override
    public void init() throws ServletException {
        //create system instance
        Kodvel kodvel = new Kodvel();
        System.out.println("----------System Initialized----------");
    }
    
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //route the request
        HttpServletRequest request = (HttpServletRequest) req;
        //String path = request.getServletPath();
        String path = request.getRequestURI().substring(request.getContextPath().length());
        //System.out.println("Path: "+ path);
        
        //remove 'app/' from path
        Kodvel.getInstance().doRoute(path.substring(4),  (HttpServletRequest)req, (HttpServletResponse)res);
    
        HttpServletRequest httpRequest = (HttpServletRequest) request;        
    }
    
    
}
