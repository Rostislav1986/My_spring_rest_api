package com.example.my_spring_rest_api.services;

import com.example.my_spring_rest_api.dao.RoleDao;
import com.example.my_spring_rest_api.dao.UserDao;
import com.example.my_spring_rest_api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private RoleDao roleDao;
    private UserDao userDao;
    private final PasswordEncoder encoder;
   @Autowired
    public UserServiceImpl(RoleDao roleDao, UserDao userDao,PasswordEncoder encoder) {
        this.roleDao = roleDao;
        this.userDao = userDao;
        this.encoder = encoder;

    }
    @Override
    @Transactional
    public void addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        if (!user.getPassword().equals(userDao.findUserById(user.getId()).getPassword())) {
            user.setPassword(encoder.encode(user.getPassword()));
        }
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void removeUser(Long id) {
        userDao.removeUser(id);
    }

    @Override
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<User> getListUsers() {
        return userDao.getUserList();
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        User user = userDao.findUserByUsername(username);
        return user;
    }

}
