package com.rest.restAPI.app.controller;

import com.rest.restAPI.app.mapping.User;
import com.rest.restAPI.app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/users/get-user")
    public List<User> getUser(){
        return userRepo.findAll();
    }

    /*@RequestMapping("/api")
    @GetMapping({"/id"})
    public ResponseEntity<User> getUsers (@PathVariable int id){
        User user = userRepo.findById(id)
                .orElseThrow(()-> new Exceptions("User not found with ID:"+id));
        return ResponseEntity.ok(user);
    }*/

    @PostMapping(params = "/users/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody User user){
        userRepo.save(user);
        return "User added successfully";
    }
}
