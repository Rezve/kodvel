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
 * Load the system and do routing
 * 
 * This servlet works as a front controller and loaded on startup.
 * The only instance of our system is created here.
 * @author Md. Rezve Hasan
 * @since 0.0.1
 */
@WebServlet(value = "/app/*", loadOnStartup = 1)
public class Loader extends HttpServlet{
    /**
     * Create system instance
     * 
     * This method is executed when the server starts.
     * @throws ServletException 
     */
    @Override
    public void init() throws ServletException {
        Kodvel kodvel = new Kodvel();
        System.out.println("----------System Initialized----------");
    }
    
    /**
     * Front controller
     * 
     * Get all the request passed from RequestFilter.
     * RequestFilter added 'app/' to the requested URL.We remove it here and 
     * pass to systems doRoute method with actual request URL.
     * 
     * @param req users request
     * @param res users response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //route the request
        HttpServletRequest request = (HttpServletRequest) req;
        String path = request.getRequestURI().substring(request.getContextPath().length());
        //remove 'app/' from path
        Kodvel.getInstance().doRoute(path.substring(4),  (HttpServletRequest)req, (HttpServletResponse)res);
    }
}
