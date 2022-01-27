package com.example.UserSpringPostgresql.api;

import com.example.UserSpringPostgresql.dao.AssetEntity;
import com.example.UserSpringPostgresql.dao.UserEntity;
import com.example.UserSpringPostgresql.dao.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.event.CaretEvent;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){

        userRepository.save(user);
        System.out.println(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }

}
