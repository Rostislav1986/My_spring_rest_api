package com.example.my_spring_rest_api.init;

import com.example.my_spring_rest_api.models.Role;
import com.example.my_spring_rest_api.models.User;
import com.example.my_spring_rest_api.services.RoleService;
import com.example.my_spring_rest_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;
@Component
public class Util implements ApplicationRunner {
    private final RoleService roleService;
    private final UserService userService;
    @Autowired
    public Util(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
    }
    @PostConstruct
    private void dataBaseInit() {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        Set<Role> adminSet = new HashSet<>();
        Set<Role> userSet = new HashSet<>();

        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        adminSet.add(roleAdmin);
        adminSet.add(roleUser);
        userSet.add(roleUser);


        User admin = new User("admin","admin","admin@mail.ru",23,adminSet);
        User user1 = new User("user","user","user@mail.ru",33,userSet);
        userService.addUser(user1);
        userService.addUser(admin);
    }
}
