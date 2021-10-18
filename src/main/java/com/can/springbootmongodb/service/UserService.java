package com.can.springbootmongodb.service;

import com.can.springbootmongodb.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User updateUser(User user,int userId);
    List<User> getAll();
    User deleteUser(int userId);
    User getUserById(int userId);
}
