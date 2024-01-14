package com.sky.rest.webservices.restfulwebservices.users;

import com.sky.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    UserDaoService service;
    @GetMapping("/users")
    public List<User> retrieveUsers(){
        return service.findAllUsers();
    }
    @GetMapping("/users/{userId}")
    public User findOne(@PathVariable int userId){
        User user = service.findOne(userId);
        if(user == null){
            throw new UserNotFoundException("Id did not found");
        }
      return user;
    }
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
        int savedUserId = service.saveUser(user);
    URI location  = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(savedUserId)
                .toUriString());
        return ResponseEntity.created(location).build();
    }
}
