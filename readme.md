# Kodvel

Simple servlet MVC framework

The aim of this project is provide a simple MVC structure to organize your servlet applications and a cleaner way to define routes.It also allows you to define multiple methods in a single controller to handles multiple requests.


## Getting Started


### Prerequisites

- JDK 8
- NetBeans IDE 8.2 or leter

### Installing

1. Open terminal and type.
    ```
    git clone https://github.com/rezve/kodvel.git KodvelBlog
    cd KodvelBlog
    ```
 2. Open the project with NetBeans IDE
 3. Run the project. A welcome page will open in your default browser.

### Overview

**Model–view–controller (MVC)** is an architectural pattern commonly used for developing user interfaces that divides an application into three interconnected parts.This is done to separate internal representations of information from the ways information is presented to and accepted from the user. The MVC design pattern decouples these major components allowing for efficient code reuse and parallel development.

#### Components
* The **model** is the central component of the pattern. It expresses the application's behavior in terms of the problem domain, independent of the user interface.[6] It directly manages the data, logic and rules of the application.
* A **view** can be any output representation of information, such as a chart or a diagram. Multiple views of the same information are possible, such as a bar chart for management and a tabular view for accountants.
* The third part or section, the **controller**, accepts input and converts it to commands for the model or view.

[--From Wikipedia](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller)

### Project Structure

```
	├── Web Pages          		
    │   ├── WEB-INF          	
    │   │	├── views          	# define your views in this folder (JSP files)
    │   │	└── web.xml        	
    │   └── resources        	# static resources (css,js,image, etc)
	│
	├── Source Packages    		
    │   └── app	          		
    │   	├── config      	# project configuration
    │   	├── controllers 	# all the controller classes
	│		├── models      	# all models (Beans)
    │   	└── routes      	# register your routes here
    │   
    └── ...

```


### Documentation

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

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## TODO LSIT

* [Done] Serving static assets
* Use config file for environment
* Form validation
* [Done] Useful error message 
* [Done] Commenting in the code
* Database support
* Simple database helper method
* Complete Documentation


## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/rezve/kodvel/tags). 

## Authors

* **Md. Rezve Hasan** - *Initial work* - [github](https://github.com/rezve)

See also the list of [contributors](https://github.com/rezve/kodvel/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Name of this project inspired by [laravel](https://github.com/laravel/laravel)

