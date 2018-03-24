/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodvel.core;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author rezve
 */
public class LoadFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter constructor");
        Kodvel kodvel = new Kodvel();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter is called");
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getServletPath();
        System.out.println("Path: "+ path);
        Kodvel.getInstance().doRoute(path, request, response);
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;        
        System.out.println("normal service called: "+ httpRequest.getMethod());
        //chain.doFilter(request, response);//sends request to next resource  
    }

    @Override
    public void destroy() {
        
    }
    
}
