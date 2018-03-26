/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kodvel.core.controller.Controller;

/**
 *
 * @author rezve
 */
public class Blog extends Controller{
    public Blog() {
        System.out.println("Blog constructor called");
    }
    
    public void index(HttpServletRequest req, HttpServletResponse res) {
        view("blog/posts", req, res);
    }
    
    public void create(HttpServletRequest req, HttpServletResponse res) {
        view("blog/create", req, res);
    }
    
    public void store(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        String title = req.getParameter("title");
        String body = req.getParameter("body");
        
        res.setContentType("text/html");
        out.println("You enterend: ");
        out.println("Title: "+ title + "<br>");
        out.println("Body: "+ body + "<br>");
        out.println("<a href=\"blog\" >Back</a>");
    }
}
