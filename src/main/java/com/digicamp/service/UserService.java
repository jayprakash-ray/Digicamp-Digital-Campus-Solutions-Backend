package com.digicamp.service;

import com.digicamp.dao.RoleDao;
import com.digicamp.dao.UserDao;
import com.digicamp.entity.Role;
import com.digicamp.entity.User;
import com.digicamp.exception.APIRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user){
        Role role = roleDao.findByRoleName(user.getRole().getRoleName());
        if(role==null) throw new APIRequestException("Invalid role");
        User user1 = new User();
        user1.setUserId(user.getUserId());
        user1.setPassword(getEncodedPassword(user.getPassword()));
        user1.setRole(role);
        try {
            return userDao.save(user1);
        } catch (Exception e){
            throw new APIRequestException("A user is already registered with ID: " + user1.getUserId());
        }
    }
    public List<User> getAllUsers(){
        List<User> users = (List<User>) userDao.findAll();
        return users;
    }
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
    public User getUserByUserId(Long userId){
        return userDao.findByUserId(userId);
    }
}
