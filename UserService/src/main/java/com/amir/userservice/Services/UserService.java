package com.amir.userservice.Services;

import com.amir.userservice.Entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(Integer userId);

    User deleteUser(Integer userId);

    User updateUser(User user);
}
