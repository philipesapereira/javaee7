package br.com.philipe;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.philipe.seguranca.EProcessos;
import br.com.philipe.seguranca.JWTTokenNeeded;
import br.com.philipe.seguranca.ProcessoRequire;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/teste")
@JWTTokenNeeded
@ProcessoRequire(EProcessos.TESTE)
public class TesteWS {

	@Inject
	private ITesteService testeService;
	
	@GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity(testeService.getMensagem()).build();
    }
}
