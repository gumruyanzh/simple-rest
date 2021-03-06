package com.simplerest.simplerest.rest.api;


import com.simplerest.simplerest.rest.service.EmployeeService;
import com.simplerest.simplerest.rest.service.EmployeeServiceImpl;
import com.simplerest.simplerest.rest.entity.EmployeeEntity;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/employee")
public class EmployeeResource {

    @Inject
    EmployeeService employeeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GET
    @Path(("/{id}"))
    @Produces(MediaType.APPLICATION_JSON)
    public EmployeeEntity findById(@PathParam("id") int id){
        return employeeService.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addEmployee(EmployeeEntity employeeEntity){
        employeeService.addNewEmployee(employeeEntity);
    }
}
