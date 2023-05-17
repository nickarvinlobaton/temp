package com.example.springenrollment.service.impl;

import com.example.springenrollment.entity.User;
import com.example.springenrollment.repository.UserRepository;
import com.example.springenrollment.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        User existingUser = userRepository.findById(user.getId()).get();
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());

        User updatedUser = userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public User delete(long id) {
        userRepository.deleteById(id);
        return userRepository.findById(id).get();
    }

    @Override
    public User find(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
