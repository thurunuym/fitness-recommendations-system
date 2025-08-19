package com.fitness.userservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.model.User;
import com.fitness.userservice.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/users")
@AllArgsConstructor

public class UserController {

    private UserService userService;

    @GetMapping("/{userId}")
        public ResponseEntity<UserResponse> getUserProfile(@PathVariable String userId){
        return  ResponseEntity.ok(userService.getUserProfile(userId));
        }

    @PostMapping("/register")
        public ResponseEntity<UserResponse> register(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.ok(userService.register(request));
}


}



//@RequestBody → Take the JSON from the request and turn it into a RegisterRequest object.