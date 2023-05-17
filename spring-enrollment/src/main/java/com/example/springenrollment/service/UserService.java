package com.example.springenrollment.service;

import com.example.springenrollment.entity.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User update(User user);
    User delete(long id);
    User find(long id);
    List<User> getAll();
}
