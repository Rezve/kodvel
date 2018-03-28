/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.PostModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kodvel.core.controller.Controller;

/**
 * Blog controller
 * 
 * @author Md. Rezve Hasan
 * @since 0.0.1
 */
public class Blog extends Controller{
    private static ArrayList<PostModel> posts;
    
    public Blog() {
        if(posts == null) {
           posts = new ArrayList<>();
            System.out.println("post list initialized");
        }
    }
    
    /**
     * Show all the posts
     * 
     * @param req user request
     * @param res user response
     */
    public void index(HttpServletRequest req, HttpServletResponse res) {
        req.setAttribute("posts", posts);
        view("blog/posts", req, res);
    }
    
    /**
     * Create post form
     * 
     * @param req user request
     * @param res user response
     */
    public void create(HttpServletRequest req, HttpServletResponse res) {
        view("blog/create", req, res);
    }
    
    /**
     * Show user submitted data
     * 
     * @param req user request
     * @param res user response
     * @throws IOException 
     */
    public void store(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        String title = req.getParameter("title");
        String body = req.getParameter("body");
        
        if(!title.isEmpty() && !body.isEmpty()) {
            PostModel post = new PostModel();
            post.setTitle(title);
            post.setBody(body);
            posts.add(post);
        }
        
        res.setContentType("text/html");
        out.println("You enterend: ");
        out.println("Title: "+ title + "<br>");
        out.println("Body: "+ body + "<br>");
        out.println("<h1> Post Saved successfully </h1><br>");
        out.println("<a href=\"../blog\" >Back</a>");
    }
}
