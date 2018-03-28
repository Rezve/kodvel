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
 * Handle all the system error.
 * 
 * Depending on environment configuration it shows the error message to browser or
 * console.
 * 
 * TODO: Save errors to log file
 * @author Md. Rezve Hasan
 * @since 0.0.1
 */
public class Errors {
    /**
     * Write error message to browser or console.
     * 
     * @param response user response
     * @param errorBody ErrorBody error message details
     */
    public static void message(HttpServletResponse response, ErrorBody errorBody) {
        if(true) {
            sendErrorsToBrowser(response, errorBody);
        }else{
            sendToConsole(errorBody);
        }
    }
    
    /**
     * Styling the error message before send to browser
     * 
     * @param response user response
     * @param errorBody ErrorBody error message details
     */
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
    /**
     * Styling the error message before send to console
     * 
     * @param errorBody ErrorBody error message details
     */
    private static void sendToConsole(ErrorBody errorBody) {
        System.err.println("------------------------------------");
        System.err.println(">> "+ errorBody.getTitle() + " <<");
        System.err.println("> "+ errorBody.getMessage()+ " <");
        System.err.println("> "+ errorBody.getException().getMessage()+ " <");
        Logger.getLogger(Errors.class.getName()).log(Level.SEVERE, null, errorBody.getException().getCause());
        System.err.println("------------------------------------");
    }
    
    /**
     * Save the error message to log file
     * 
     * @param errorBody ErrorBody error message details
     */
    private static void saveErrorsToLog(ErrorBody errorBody) {
        
    }
}
