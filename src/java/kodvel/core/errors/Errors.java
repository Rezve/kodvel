/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodvel.core.errors;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rezve
 */
public class Errors {
    public static void message(HttpServletResponse response, ErrorBody errorBody) {
        if(true) {
            sendErrorsToBrowser(response, errorBody);
        }else{
            sendToConsole(errorBody);
        }
    }
    
    private static void sendErrorsToBrowser(HttpServletResponse response, ErrorBody errorBody) {
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html");
            String execptionMessage = errorBody.getException() != null ? errorBody.getException().toString():"";
            out.println();
            out.println("<html>\n" +
                        "<head><title>Error</title></head>\n" +
                        "<body>\n" +
                        "<div style=\"padding: 20px; border: 10px solid #2d3436;\"> \n"+
                        "<h1 style=\"color: #d63031; background-color:#2d3436; padding:20px;\"><code>"+errorBody.getTitle()+"</code></h1> \n"+
                        "<code style=\"color:purple\" >"+errorBody.getMessage()+"</code>\n" +
                        "<hr />\n" +
                        "<code style=\"color:grey\">"+execptionMessage+"</code>\n" +
                        "\n" +
                        "<p><code style=\"color: #2d3436;\">Version: <a href=\"\">Kodvel</a> <sup>beta 0.0.1</sup></code></p>\n"+
                        "</div> \n"+
                        "</body>\n" +
                        "</html>");
        } catch (IOException ex) {
            Logger.getLogger(Errors.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void sendToConsole(ErrorBody errorBody) {
        System.err.println("------------------------------------");
        System.err.println(">> "+ errorBody.getTitle() + " <<");
        System.err.println("> "+ errorBody.getMessage()+ " <");
        System.err.println("> "+ errorBody.getException().getMessage()+ " <");
        Logger.getLogger(Errors.class.getName()).log(Level.SEVERE, null, errorBody.getException().getCause());
        System.err.println("------------------------------------");
    }
    
    private static void saveErrorsToLog(HttpServletResponse response, ErrorBody errorBody) {
        
    }
}
