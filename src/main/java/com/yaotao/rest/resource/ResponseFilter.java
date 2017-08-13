package com.yaotao.rest.resource;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

@Provider
public class ResponseFilter implements ContainerResponseFilter {

	protected Logger log = Logger.getLogger(this.getClass());

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {

		log.info("send a reponse to client");

		log.info("status is: " + responseContext.getStatusInfo().getStatusCode());
		// log.info("content-length is: " + responseContext.getLength());
	}
}