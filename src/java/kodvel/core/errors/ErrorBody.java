/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kodvel.core.errors;

/**
 *
 * @author rezve
 */
public class ErrorBody {
    private String title;
    private String message;
    private Exception exception;

    public ErrorBody(String title, String message, Exception exception) {
        this.title = title;
        this.message = message;
        this.exception = exception;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }
    
}
