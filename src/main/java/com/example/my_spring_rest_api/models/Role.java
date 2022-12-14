package com.example.my_spring_rest_api.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    private String rolename;

    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }
    public Role(String rolename) {
        this.rolename = rolename;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.rolename = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String name) {
        this.rolename = name;
    }

    @Override
    public String getAuthority() {
        return getRolename();
    }

    @Override
    public String toString() {
        return rolename.replace("ROLE_", "");
    }
}
