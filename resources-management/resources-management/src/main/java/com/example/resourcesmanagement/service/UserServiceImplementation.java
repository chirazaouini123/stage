package com.example.resourcesmanagement.service;

import com.example.resourcesmanagement.entity.User;
import com.example.resourcesmanagement.exceptions.ResourcesNotFoundException;
import com.example.resourcesmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User AddUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new ResourcesNotFoundException("User doesn't exist with id:"+id));
    }

    @Override
    public User updateUserAccount(Long id, User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User user1=findUserById(id);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setAddress(user.getAddress());
        user1.setRoles(user.getRoles());
        user1.setAge(user.getAge());
        user1.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user1);
    }

    @Override
    public Map<String, Boolean> deleteUser(Long id) {
        User user=findUserById(id);
        userRepository.delete(user);
        Map<String,Boolean> response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return response;
    }
}
