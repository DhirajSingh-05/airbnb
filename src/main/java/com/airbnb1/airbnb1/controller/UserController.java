package com.airbnb1.airbnb1.controller;


import com.airbnb1.airbnb1.dto.LoginDto;
import com.airbnb1.airbnb1.dto.PropertyUserDto;
import com.airbnb1.airbnb1.entity.PropertyUser;
import com.airbnb1.airbnb1.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private PropertyService propertyService;

    public UserController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }


    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody PropertyUserDto propertyUserDto){
        PropertyUser propertyUser = propertyService.addUser(propertyUserDto);
        if(propertyUser!=null){
            return new ResponseEntity<>("Registration is Successful", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Something went Wrong",HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        propertyService.verifyLogin(loginDto)
    }
}
