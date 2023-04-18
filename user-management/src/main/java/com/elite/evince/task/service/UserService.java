package com.elite.evince.task.service;


import com.elite.evince.task.entity.User;
import com.elite.evince.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User Not Found With Id "+id));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user, int id){
        var updatedUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found With Id " + id));
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setMobile(user.getMobile());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setDateOfBirth(user.getDateOfBirth());
        updatedUser.setPassword(user.getPassword());

        return userRepository.save(updatedUser);
    }

    public void deleteUser(int id) {
        var user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found With Id " + id));
        userRepository.delete(user);
    }
}
