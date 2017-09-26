package com.simplerest.simplerest.rest;


import com.simplerest.simplerest.rest.jwt.JWTTokenNeeded;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;


@Path("/hello")
public class HelloWorldEndpoint {

	@GET
	@JWTTokenNeeded
	@Produces("text/plain")
	public Response doGet() {
		System.out.println(">>> In controller !!!!!!!");
		return Response.ok("Hello from WildFly Swarm!!!").build();
	}
}