package com.simplerest.simplerest.rest;


import com.simplerest.simplerest.rest.entity.EmployeeEntity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/employee")
public class EmployeeResource {

    @Inject
    PersistenceHelper helper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmployeeEntity> getAllEmployees() {
        EntityManager em = helper.getEntityManager();
        return em.createNamedQuery("EmployeeEntity.findAll", EmployeeEntity.class).getResultList();
//        try {
//
//        } finally {
//            em.close();
//        }

    }
}
