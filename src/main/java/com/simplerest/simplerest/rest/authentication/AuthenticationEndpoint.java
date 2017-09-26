package com.simplerest.simplerest.rest.authentication;


import com.simplerest.simplerest.rest.authentication.service.AuthenticationService;
import com.simplerest.simplerest.rest.entity.EmployeeEntity;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/asfasdasdasdasdasdasdasd")
public class AuthenticationEndpoint {

    @Inject
    AuthenticationService authenticationService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getLoginTest(){
        System.out.println("######## In Login ####");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void authenticate(EmployeeEntity employee){
        boolean authenticated = authenticationService.authenticate(employee.getUsername(), employee.getPassword());
        System.out.println(authenticated);
    }
}
