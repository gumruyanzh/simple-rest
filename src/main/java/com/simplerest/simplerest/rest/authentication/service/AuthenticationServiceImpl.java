package com.simplerest.simplerest.rest.authentication.service;

import com.simplerest.simplerest.rest.entity.EmployeeEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class AuthenticationServiceImpl implements AuthenticationService {

    @PersistenceContext(name = "primary")
    private EntityManager em;

    @Override
    public boolean authenticate(String username, String password) {
        try {

            EmployeeEntity employeeEntity = em.createQuery(
                    "SELECT e from EmployeeEntity e WHERE e.username = :username and e.password =:password", EmployeeEntity.class).
                    setParameter("username", username).setParameter("password", password).getSingleResult();

            return true;
        } catch (NoResultException e) {
            return false;
        }

    }
}
