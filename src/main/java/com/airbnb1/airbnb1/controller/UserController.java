package com.airbnb1.airbnb1.controller;


import com.airbnb1.airbnb1.dto.UserDto;
import com.airbnb1.airbnb1.entity.UserEntity;
import com.airbnb1.airbnb1.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody UserDto userDto){
        UserEntity user = userService.addUser(userDto);
        if(user!=null){
            return new ResponseEntity<>("Registration Successful", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Something went Wrong",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
