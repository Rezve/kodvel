/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodvel.core.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import kodvel.core.route.DoRouting;

/**
 * Separate file or controller requests
 *  
 * If requested URL is set in routing, then forward it to 
 * Loader class for routing.
 * Otherwise pass the request to servlets default container for handling
 * static resource (CSS,JS,TTF,etc) request.
 * 
 * @author Md. Rezve Hasan
 * @since 0.0.1
 */
@WebFilter("/*")
public class RequestFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}
    
    /**
     * Separate request
     * 
     * If requested path is defined in router then pass the request to Loader
     * Otherwise servlet container handles the request
     * 
     * @param request user request object
     * @param response user response
     * @param chain for forward to next filter
     * @throws IOException
     * @throws ServletException 
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI().substring(req.getContextPath().length());
        System.out.println("Filter called");
        if (DoRouting.hasRoute(req.getMethod(), path)) {
            request.getRequestDispatcher("/app/" + path).forward(request, response); 
        } else {
            chain.doFilter(request, response); 
        }
    }

    @Override
    public void destroy() {
        
    }
    
}
