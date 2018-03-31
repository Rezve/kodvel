/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.PostModel;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        //req.setAttribute("message", "Post saved successfully!");
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
        String title = req.getParameter("title");
        String body = req.getParameter("body");
        
        if(!title.isEmpty() && !body.isEmpty()) {
            PostModel post = new PostModel();
            post.setTitle(title);
            post.setBody(body);
            posts.add(post);
            
            
            HttpSession session = req.getSession(false);
            session.setAttribute("message", "Post saved successfully!");
        }
        //req.setAttribute("posts", posts);
        
        //redirect("/kodvel/blog", req, res);
        res.sendRedirect("/kodvel/blog");
    }
}
