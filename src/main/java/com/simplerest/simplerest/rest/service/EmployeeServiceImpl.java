package com.simplerest.simplerest.rest.service;


import com.simplerest.simplerest.rest.entity.EmployeeEntity;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class EmployeeServiceImpl implements EmployeeService {

    @PersistenceContext(name = "primary")
    private EntityManager em;

    public List<EmployeeEntity> getAllEmployees(){
        return em.createNamedQuery("EmployeeEntity.findAll", EmployeeEntity.class).getResultList();
    }

    @Transactional
    public void addNewEmployee(EmployeeEntity employeeEntity){
        em.merge(employeeEntity);
    }

    public EmployeeEntity findById(int id){
        return em.find(EmployeeEntity.class, id);
    }

    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity){
        return em.merge(employeeEntity);
    }
}
