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
        <!-- Bootstrap core CSS -->
        <link href="resources/css/bootstrap.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300" rel="stylesheet">     
        <!-- Custom styles for this template -->
        <link href="resources/css/cover.css" rel="stylesheet">
    </head>
    <body>
        <div class="container d-flex h-100 p-3 mx-auto flex-column">
            <header class="masthead mb-auto">
              <div class="inner">
                <h3 class="masthead-brand">Blog</h3>
                <nav class="nav nav-masthead justify-content-center">
                  <a class="nav-link active" href="${pageContext.request.contextPath}/">Home</a>
                  <a class="nav-link" href="${pageContext.request.contextPath}/blog/create">Create</a>
                  <a class="nav-link" href="${pageContext.request.contextPath}/blog">List</a>
                </nav>
              </div>
            </header>
            
            <% 
                
                ArrayList<PostModel> posts = (ArrayList)request.getAttribute("posts");
            %>
            <main role="main" class="inner cover">
                <c:if test="${sessionScope.message != null}">
                    <div class="alert alert-success"><c:out value="${sessionScope.message}" /></div>
                </c:if>
                
                <c:remove var="message" scope="session" />
                <c:forEach  items="${posts}" var="post">
                    <h1 class="cover-heading">${post.title}</h1>
                    <p class="lead">${post.body}</p>
                </c:forEach>
                <c:if test="${posts.size() == 0}">
                    There are no posts found. <b><a href="blog/create">Create new post</a></b>
                </c:if>
            </main>

            <footer class="mastfoot mt-auto">
              <div class="inner">
                <p>Template by <a href="https://twitter.com/mdo">@mdo</a>.</p>
              </div>
            </footer>
          </div>
         <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script>window.jQuery || document.write('<script src="resources/js/jquery-slim.min.js"><\/script>')</script>
        <script src="resources/js/popper.min.js"></script>
        <script src="resources/js/bootstrap.min.js"></script>
    </body>
</html>
