package br.com.philipe.seguranca;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@JWTTokenNeeded
@Priority(Priorities.AUTHENTICATION)
public class JWTTokenNeededFilter implements ContainerRequestFilter {
 
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
 
    	String authorizationHeader = "";
    	String token = "";
    	
    	try {
	        // Get the HTTP Authorization header from the request
	        authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
	 
	        // Extract the token from the HTTP Authorization header
	        token = authorizationHeader.substring("Bearer".length()).trim();
 
            // Validate the token
        	JWTUtil.decode(token);
//            System.out.println("#### valid token : " + token);
 
            requestContext.getHeaders().putSingle(HttpHeaders.AUTHORIZATION, token);
            
        } catch (Exception e) {
//        	System.out.println("#### invalid token : " + token);
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }
}
