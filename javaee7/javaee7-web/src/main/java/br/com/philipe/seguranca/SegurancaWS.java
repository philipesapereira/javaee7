package br.com.philipe.seguranca;

import java.io.Serializable;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/seguranca")
public class SegurancaWS implements Serializable {

	private static final long serialVersionUID = -6923655748224035954L;

	@Inject
	private  ISegurancaService segurancaService;
	
	@Inject
	private UserSession userSession;
	
	@POST
    @Path("/login")
    public Response login(@Context HttpServletRequest request, UserLogin login) throws AuthException {
		
		User logado = segurancaService.login(login);
		String token = JWTUtil.create(new Gson().toJson(logado));
		
		userSession.setUser(logado);
		
        return Response.ok().entity(token).build();
    }
	
	@GET
	@Path("/userDetail")
	@JWTTokenNeeded
	public Response getUser(@HeaderParam(HttpHeaders.AUTHORIZATION) String token) {
		
		Jws<Claims> jws = JWTUtil.decode(token);
		User user = new Gson().fromJson(jws.getBody().getSubject(), User.class);
		
		return Response.ok().entity(user).build();
	}
	
	@GET
	@Path("/listarProcessos")
	@JWTTokenNeeded
	public Response listarProcessos() throws AuthException {
		
		return Response.ok().entity(this.userSession.listarProcessosAutorizados()).build();
	}
	
	
}
