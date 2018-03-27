<%-- 
    Document   : create
    Created on : Mar 25, 2018, 8:20:26 PM
    Author     : Md. Rezve Hasan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create Post</h1>
        <ul>
            <li><a href="${pageContext.request.contextPath}/blog/create">create</a></li>
            <li><a href="${pageContext.request.contextPath}/blog">List</a></li>
        </ul>
        <hr>
        <form action="store" method="post">
            <input placeholder="Title" type="text" name="title" /> </br>
            <textarea placeholder="Post body" rows="10" cols="32" name="body"></textarea> <br>
            <input type="submit" value="Save" />
        </form>
    </body>
</html>
