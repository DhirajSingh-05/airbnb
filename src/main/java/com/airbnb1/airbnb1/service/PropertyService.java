package com.airbnb1.airbnb1.service;

import com.airbnb1.airbnb1.dto.LoginDto;
import com.airbnb1.airbnb1.dto.PropertyUserDto;
import com.airbnb1.airbnb1.entity.PropertyUser;
import com.airbnb1.airbnb1.repository.PropertyUserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PropertyService {

    private PropertyUserRepository propertyUserRepository;

    public PropertyService(PropertyUserRepository propertyUserRepository) {
        this.propertyUserRepository = propertyUserRepository;
    }

    public PropertyUser addUser(PropertyUserDto propertyUserDto){
        PropertyUser propertyUser = new PropertyUser();
        propertyUser.setFirstName(propertyUserDto.getFirstName());
        propertyUser.setLastName(propertyUserDto.getLastName());
        propertyUser.setUserName(propertyUserDto.getUserName());
        propertyUser.setEmail(propertyUserDto.getEmail());
        propertyUser.setPassword(BCrypt.hashpw(propertyUserDto.getPassword(),BCrypt.gensalt(10)));
        propertyUser.setUserRole(propertyUserDto.getUserRole());
        PropertyUser saved = propertyUserRepository.save(propertyUser);

        return saved;
    }

    public void verifyLogin(LoginDto loginDto) {
        Optional<PropertyUser> byUserName = propertyUserRepository.findByUserName(loginDto.getUsername());


    }
}
