package com.airbnb1.airbnb1.service;

import com.airbnb1.airbnb1.dto.LoginDto;
import com.airbnb1.airbnb1.dto.UserDto;
import com.airbnb1.airbnb1.entity.UserEntity;
import com.airbnb1.airbnb1.entity.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity addUser(UserDto userDto){
        UserEntity user = new UserEntity();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(BCrypt.hashpw(userDto.getPassword(),BCrypt.gensalt(10)));
        user.setUserRole(userDto.getUserRole());
        UserEntity saved = userRepository.save(user);
        return saved;
    }


    public Boolean verifyLogin(LoginDto loginDto){
        Optional<UserEntity> byUserName = userRepository.findByUserName(loginDto.getUsername());
        if(byUserName.isPresent()){
            UserEntity user = byUserName.get();
            return BCrypt.checkpw(loginDto.getPassword(),user.getPassword());
        }

        return false;
    }
}
