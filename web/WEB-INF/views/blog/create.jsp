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
        <title>Create Post</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300" rel="stylesheet">     
        <!-- Custom styles for this template -->
        <link href="${pageContext.request.contextPath}/resources/css/cover.css" rel="stylesheet">
    </head>
    <body>
        <div class="container d-flex h-50 p-3 mx-auto flex-column">
            <header class="masthead mb-auto">
              <div class="inner">
                <h3 class="masthead-brand">Create Post</h3>
                <nav class="nav nav-masthead justify-content-center">
                  <a class="nav-link active" href="${pageContext.request.contextPath}/">Home</a>
                  <a class="nav-link" href="${pageContext.request.contextPath}/blog/create">Create</a>
                  <a class="nav-link" href="${pageContext.request.contextPath}/blog">List</a>
                </nav>
              </div>
            </header>
            <main role="main" class="cover inner" style="padding-top: 50px;">
                <form action="store" class="form-control" method="post">
                    <input placeholder="Title" class="form-control" type="text" name="title" /> </br>
                    <textarea placeholder="Post body" class="form-control" rows="10" cols="32" name="body"></textarea> <br>
                    <input type="submit" class="btn btn-dark" value="Save" />
                </form>
                 
            </main>
         </div>
        
        
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/resources/js/jquery-slim.min.js"><\/script>')</script>
        <script src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    </body>
</html>
