package com.simplerest.simplerest.rest;


import com.simplerest.simplerest.rest.entity.EmployeeEntity;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class EmployeeService {

    @PersistenceContext(name = "primary")
    private EntityManager em;

    public List<EmployeeEntity> getAllEmployees(){
        return em.createNamedQuery("EmployeeEntity.findAll", EmployeeEntity.class).getResultList();
    }

    @Transactional
    void addNewEmployee(EmployeeEntity employeeEntity){
        em.merge(employeeEntity);
    }

    EmployeeEntity findById(int id){
        return em.find(EmployeeEntity.class, id);
    }

    EmployeeEntity updateEmployee(EmployeeEntity employeeEntity){
        return em.merge(employeeEntity);
    }
}
