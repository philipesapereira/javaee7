package br.com.philipe.seguranca;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

@Provider
@ProcessoRequire
@Priority(Priorities.AUTHORIZATION)
public class ProcessoRequireFilter implements ContainerRequestFilter {

	@Context
	ResourceInfo resourceInfo;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		String codProcesso = resourceInfo.getResourceClass().getAnnotation(ProcessoRequire.class).value().value;
		System.out.println("processo identificado: " + codProcesso);
	}

}
