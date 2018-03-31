# Kodvel

The aim of this project is to provide a simple MVC structure to organize your Servlet applications.

### Features:
1. Controllers support multiple methods to handle multiple requests.Like `Post` class can have `index` method for showing all post, `view` for viewing a single post, `edit` for edit post form, `store` for saving post by POST request.
2. Easy route for binding URL patterns to Controller and method.

## Getting Started

### Prerequisites

- JDK 8
- NetBeans IDE 8.2 or leter

### Installing

1. Clone the project into your machine or download as a zip.
    ```
    git clone https://github.com/rezve/kodvel.git
    cd kodvel
    ```
 2. Open the project with NetBeans IDE
 3. Run the project. A welcome page will open in your default browser.

### Project Structure

```
  ├── Web Pages               
  │   ├── WEB-INF             
  │   │   ├── views           # define your views in this folder (JSP files)
  │   │   └── web.xml         
  │   └── resources           # static resources (css,js,image, etc)
  │
  ├── Source Packages         
  │   ├── app                 
  │   │   ├── config          # project configuration
  │   │   ├── controllers     # all the controller classes
  │   │   ├── models          # all models (Beans)
  │   │   └── routes          # register your routes here
  │   └── Kodvel              # system files
  └── ...
```

## Quick start
**Step 1:**
Let's start by creating a simple JSP view in `view/blog` folder
```html
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blog</title>
    </head>
    <body>
        <h1>List of Posts</h1>
     </body>
</html>
```

**Setp 2:** 
	Now, Create a controller class inside `app/controllers` folder. This will serve our views.
 
 ```java
 public class Blog extends Controller{
      public void index(HttpServletRequest req, HttpServletResponse res) {
          req.setAttribute("posts", posts);
          view("blog/posts", req, res);
      }
      
    public void create(HttpServletRequest req, HttpServletResponse res) {
        view("blog/create", req, res);
    }
      ...
 }
 ```
**NOTE:** All methods (those are used for handling user request) inside a controller must have this two argument. 

We have completed our first controller. Now register it to receive user request.

**Step 3:** Define a route in `app/routes/web.java`

```java
public void registerRouter() {   
	...
	Router.get("/blog", new Blog(), "index");
        Router.get("/blog/create", new Blog(), "create");
}
```
here we registered our `index` method for handling all the request for `/blog` and `create` method for `/blog/create` url.

Done! Lets visit [http://localhost:8080/kodvel/blog](http://localhost:8080/kodvel/blog)

You will see your views in the browser.

	List of Posts

So here is the flow: 
1. Create your views (JSP) with html/css design and data passed from the controller.
2. Create a model for holding data.
3. Create a controller to fetch data from DB and process other logic and pass the data to view.

### Documentation
* [Application life cycle]()
* [Controller]()
* [Routing]()
* [View]()
* [Model]()
* [Static assets]()
* [Form Validation]()
* [Database]()
* [Configuration]()
* [Filter]()

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## TODO LSIT
* Utility function for base URL
* Form validation
* Database support
* Simple database helper method
* Completing this Documentation.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/rezve/kodvel/tags). 

## Authors

* **Md. Rezve Hasan** - *Initial work* - [github](https://github.com/rezve)

See also the list of [contributors](https://github.com/rezve/kodvel/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Name and routing style of this project inspired by [laravel](https://github.com/laravel/laravel)

