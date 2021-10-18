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
    public User createUser(User user)   {
        if (user.getNationalityId().length() != 11){
            throw new IllegalArgumentException("NationalityId must be 11 digits!");
        }
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, String userId) {
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
    public void deleteUser(String userId) {

        userRepository.deleteById(userId);
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }
}
