package com.can.springbootmongodb.service;

import com.can.springbootmongodb.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User updateUser(User user,String userId);
    List<User> getAll();
    void deleteUser(String userId);
    User getUserById(String userId);
}
