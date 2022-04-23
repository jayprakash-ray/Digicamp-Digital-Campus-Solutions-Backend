package com.digicamp.service;

import com.digicamp.dao.UserDao;
import com.digicamp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUserByUserId(Long userId){
        return userDao.findByUserId(userId);
    }
}
