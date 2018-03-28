<%-- 
    Document   : posts
    Created on : Mar 25, 2018, 8:14:59 PM
    Author     : Md. Rezve Hasan
--%>

<%@page import="app.models.PostModel"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog</title>
    </head>
    <body>
        <h1>List of Posts</h1>
        
        <ul>
            <li><a href="blog/create">create</a></li>
            <li><a href="blog">List</a></li>
        </ul>
        <hr>
        <% 
            ArrayList<PostModel> posts = (ArrayList)request.getAttribute("posts");
        %>
        
        <c:forEach  items="${posts}" var="post">
            Title: ${post.title} <br>
            Body: ${post.body} <br><br>
        </c:forEach>
    </body>
</html>
