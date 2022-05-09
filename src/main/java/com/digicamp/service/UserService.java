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
//        System.out.println("User :: "+user);
        Role role = roleDao.findByRoleName(user.getRole().getRoleName());
        user.setRole(role);
        user.setPassword(getEncodedPassword(user.getPassword()));
        if(role==null) throw new APIRequestException("Role cannot be NULL");
        return userDao.save(user);
    }
    public List<User> getAllUsers(){
        List<User> users = (List<User>) userDao.findAll();
        return users;
    }
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
    public User getUserByUserId(String userId){
        return userDao.findByUserId(userId);
    }
}
