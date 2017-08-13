/**
 * FUJITSU CONFIDENTIAL
 * Copyright 2010 FUJITSU LIMITED All rights reserved.
 */
package com.yaotao.rest.resource;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

@Provider
public class RequestFilter implements ContainerRequestFilter {

	protected Logger log = Logger.getLogger(this.getClass());

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		log.info("receive a request from client");
		/*
		 * int READ_BYTE_NUMBER = 16;
		 * 
		 * String bodyString = "";
		 * 
		 * byte[] b = new byte[READ_BYTE_NUMBER]; InputStream stream =
		 * requestContext.getEntityStream();
		 * 
		 * int len = 0; while ((len = stream.read(b)) != -1) { String res = "";
		 * 
		 * if (len != READ_BYTE_NUMBER) { byte[] c = new byte[len];
		 * System.arraycopy(b, 0, c, 0, len); res = new String(c); } else { res
		 * = new String(b); }
		 * 
		 * bodyString += res; } log.info("body is: " + bodyString);
		 */
		log.info("method is: " + requestContext.getMethod());
		log.info("uri is: " + requestContext.getUriInfo().getRequestUri().toString());
		log.info("baseuri is: " + requestContext.getUriInfo().getBaseUri().toString());
		log.info("path is: " + requestContext.getUriInfo().getPath());
		log.info("query is: " + requestContext.getUriInfo().getRequestUri().getQuery());
		log.info("Content-type is: " + requestContext.getHeaderString("Content-type"));
		log.info("Accept is: " + requestContext.getHeaderString("Accept"));
	}
}
