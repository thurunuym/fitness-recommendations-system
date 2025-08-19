package com.fitness.userservice.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RegisterRequest {
    
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    

}
