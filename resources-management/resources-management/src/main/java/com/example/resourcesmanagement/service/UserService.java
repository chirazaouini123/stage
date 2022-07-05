package com.example.resourcesmanagement.service;

import com.example.resourcesmanagement.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> findAllUser();
    public User AddUser(User user);
    public User findUserById(Long id);
    public User updateUserAccount(Long id,User user);
    public Map<String,Boolean> deleteUser(Long id);


}
