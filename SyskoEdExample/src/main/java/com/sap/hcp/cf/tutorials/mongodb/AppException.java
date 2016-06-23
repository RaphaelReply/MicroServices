package com.sap.hcp.cf.tutorials.mongodb;

import org.springframework.http.HttpStatus;

/**
 * Custom exception class for provisioning a detailed error message if an API call is not successful. 
 * @author r.witte
 *
 */
public class AppException extends Exception {

    private static final long serialVersionUID = -6350844131765839646L;
    
    private HttpStatus http_status_code; 
    private String message, developerMessage;	
	
    /**
     * Constructor for creation of an AppExection with provision of all parameters.
     * @param http_status_code - the HTTP status code
     * @param message - the message for end users of the API
     * @param developerMessage - a more detailed message for developers 
     */
	public AppException(HttpStatus status, String message,
			String developerMessage) {
		super(message);
		this.http_status_code = status;
		this.message = message;
		this.developerMessage = developerMessage;
	}

	public AppException() { }

    public HttpStatus getHttp_status_code() {
        return http_status_code;
    }

    public void setHttp_status_code( HttpStatus http_status_code ) {
        this.http_status_code = http_status_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage( String message ) {
        this.message = message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage( String developerMessage ) {
        this.developerMessage = developerMessage;
    }
	
}
