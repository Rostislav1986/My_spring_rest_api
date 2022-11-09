
package com.example.my_spring_rest_api.dao;


import com.example.my_spring_rest_api.models.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void updateUser(User user);

    void removeUser(Long id);

    User findUserById(Long id);

    User findUserByUsername(String username);

    List<User> getUserList();

}

