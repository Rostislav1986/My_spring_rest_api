package com.example.my_spring_rest_api.services;

import com.example.my_spring_rest_api.dao.RoleDao;
import com.example.my_spring_rest_api.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;
    @Autowired
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }


    @Override
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Override
    public Set<Role> getRolesByName(Set<Role> roles) {
        Set<Role> userRoles = new HashSet<>();
        for (Role role : roles) {
            userRoles.add(getRoleByName(role.getRolename()));
        }
        return userRoles;
    }

    @Override
    public Set<Role> getAllRoles() {
        return new HashSet<>(roleDao.getAllRoles());
    }
}
