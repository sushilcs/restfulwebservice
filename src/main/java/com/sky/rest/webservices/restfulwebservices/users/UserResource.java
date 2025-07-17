package com.sky.rest.webservices.restfulwebservices.users;
import static  org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.sky.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public List<User> findAllUser(){
        return service.findAllUsers();
    }
    @GetMapping("/users/{userId}")
    public EntityModel<User> findOne(@PathVariable int userId){
        User user = service.findOne(userId);
        if(user == null){
            throw new UserNotFoundException("Id did not found");
        }
        //hateoas
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(methodOn(this.getClass()).findAllUser());
      return entityModel.add(link.withRel("all-users"));
    }
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        int savedUserId = service.saveUser(user);
    URI location  = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userId}")
                .buildAndExpand(savedUserId)
                .toUriString());
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{userId}")
    public void deleteById(@PathVariable int userId){
        service.deleteById(userId);
    }


}
