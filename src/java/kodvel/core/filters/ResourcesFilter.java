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

/**
 *
 * @author rezve
 */
@WebFilter("/*")
public class ResourcesFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getRequestURI().substring(req.getContextPath().length());
       // String path = req.getServletPath();
        System.out.println("DO FIlter path: "+ path);
        if (path.startsWith("/resources/")) {
            chain.doFilter(request, response); // Goes to default servlet.
        } else {
            request.getRequestDispatcher("/app/" + path).forward(request, response); // Goes to your controller.
        }

    }

    @Override
    public void destroy() {
        
    }
    
}
