package com.example.resourcesmanagement.controller;

import com.example.resourcesmanagement.entity.User;
import com.example.resourcesmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users= userService.findAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/users")
    @PreAuthorize("hasRole('ROLE_ADMIN')")

    public ResponseEntity<User> createUser(@RequestBody User user){
         BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User user1=userService.AddUser(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUserAcount(@PathVariable Long id, @RequestBody User user){
        User user1=userService.updateUserAccount(id,user);

        return new ResponseEntity<>(user1,HttpStatus.OK);
    }

}
