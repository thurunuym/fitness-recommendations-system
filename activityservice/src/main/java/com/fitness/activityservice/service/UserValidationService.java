package com.fitness.activityservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserValidationService {
    private final WebClient userServiceWebClient;

    public boolean validateUser(String userId){
        log.info("Calling User Validation API for userId: {}", userId);
        try{
            return userServiceWebClient.get()
                .uri("/api/users/{userId}/validate", userId)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
        }catch(WebClientResponseException e){
            if(e.getStatusCode() == HttpStatus.NOT_FOUND)
                throw new RuntimeException("User Not Found" + userId);
            else if(e.getStatusCode() == HttpStatus.BAD_REQUEST)
                throw new RuntimeException("Invalid Request: " + userId);
                        
            }
        
            return false;
    }
}


//This service Ask user-service if this userId is valid. If not, stop right here.

//WebClient userServiceWebClient is the bean you defined earlier in WebClientConfig, 
//pointing to USER-SERVICE through Eureka.

//userServiceWebClient.get() → start an HTTP GET request.

//.uri("/api/users/{userId}/validate", userId) → build the URI with path variable substitution.
//   ex: http://USER-SERVICE/api/users/222222/validate

//.retrieve() → send the request and prepare to extract the response.

//.bodyToMono(Boolean.class) → expect the response body to be a Boolean (true or false).

//.block() → turn the reactive Mono<Boolean> into a normal boolean (synchronous).




//UserValidationService is responsible for asking another microservice (“User Service”) if a user exists or is valid.
//If you mix user validation logic directly into ActivityService, you’re coupling two different responsibilities together. That makes the code harder to maintain and test.