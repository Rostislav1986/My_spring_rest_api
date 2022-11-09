
package com.example.my_spring_rest_api.dao;
import com.example.my_spring_rest_api.models.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;

@Repository
public class RoleDaoImpl implements  RoleDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Set<Role> getAllRoles() {
        return new HashSet<>(entityManager.createQuery("select r from Role r", Role.class)
                .getResultList());
    }


    @Override
    public Role getRoleByName(String name) {
        return entityManager.createQuery("SELECT r FROM Role r WHERE r.rolename = :name", Role.class)
                .setParameter("name", name).getSingleResult();
    }


    public Set<Role> getRolesByName(Set<Role> roles){
        Set<Role> userRoles = new HashSet<>();
        for (Role role : roles) {
            userRoles.add(getRoleByName(role.getRolename()));
        }
        return userRoles;
    }
}

