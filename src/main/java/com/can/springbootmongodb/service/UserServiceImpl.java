package com.can.springbootmongodb.service;


import com.can.springbootmongodb.exception.UserNotFoundException;
import com.can.springbootmongodb.model.User;
import com.can.springbootmongodb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, int userId) {
        User oldUser = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setEmail(user.getEmail());
        oldUser.setNationalityId(user.getNationalityId());
        oldUser.setDateOfBirth(user.getDateOfBirth());
        return userRepository.save(oldUser);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User deleteUser(int userId) {
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
        return user;
    }

    @Override
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }
}
