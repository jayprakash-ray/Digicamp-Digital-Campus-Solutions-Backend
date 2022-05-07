package com.digicamp.dao;

import com.digicamp.entity.Role;
import com.digicamp.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserDao extends CrudRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.userId=?1")
    public User findByUserId(String userId);
}