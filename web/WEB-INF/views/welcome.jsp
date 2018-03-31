<%-- 
    Document   : home
    Created on : Mar 16, 2018, 12:46:48 PM
    Author     : Md. Rezve Hasan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>kodvel</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300" rel="stylesheet">     
    <!-- Custom styles for this template -->
    <link href="resources/css/cover.css" rel="stylesheet">
  </head>

  <body class="text-center">

    <div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
      <header class="masthead mb-auto">
        <div class="inner">
          <h3 class="masthead-brand">Kodvel</h3>
          <nav class="nav nav-masthead justify-content-center">
            <a class="nav-link active" href="${pageContext.request.contextPath}/">Home</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/blog/create">Create</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/blog">List</a>
          </nav>
        </div>
      </header>

      <main role="main" class="inner cover">
        <h1 class="cover-heading">Welcome to kodvel</h1>
        <p class="lead">Everythings seems working ;) Let's build something awesome!</p>
        <p class="lead">
            <a href="https://github.com/Rezve/kodvel#documentation" target="_blank" class="btn btn-sm btn-secondary">Documentation</a>
        </p>
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
