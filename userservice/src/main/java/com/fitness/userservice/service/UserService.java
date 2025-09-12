package com.fitness.userservice.service;

import org.springframework.stereotype.Service;

import com.fitness.userservice.Repository.UserRepository;
import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.model.User;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor 
@Slf4j
public class UserService {

    private UserRepository repository;
    
    public UserResponse register(RegisterRequest request){
        
        if(repository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email already exists");        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        
        // Save the user to the repository
        User savedUser = repository.save(user);
        
        // Convert saved user to UserResponse (does not contain password)
        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());
        
        return response;
    }



    public UserResponse getUserProfile(String userId){
        User user = repository.findById(userId)
        .orElseThrow(()-> new RuntimeException("User not found"));

        UserResponse res= new UserResponse();
        res.setId(user.getId());
        res.setEmail(user.getEmail());
        res.setFirstName(user.getFirstName());
        res.setLastName(user.getLastName());
        res.setCreatedAt(user.getCreatedAt());  
        res.setUpdatedAt(user.getUpdatedAt());

        return res;

    }



    public Boolean existByUser(String userId) {
        log.info("Calling user validation API for userId: {}", userId);
        return repository.existsById(userId);
    }


    
    
}
