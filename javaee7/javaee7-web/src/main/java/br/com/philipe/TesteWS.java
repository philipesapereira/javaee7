package br.com.philipe;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/teste")
public class TesteWS {

	@Inject
	private ITesteService testeService;
	
	@GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity(testeService.getMensagem()).build();
    }
}
