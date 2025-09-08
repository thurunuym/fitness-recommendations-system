package com.fitness.activityservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration   //tells Spring this class contains bean definitions.
public class WebClientConfig {
    
    @Bean
    @LoadBalanced      // explanation below #1
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public WebClient userServiceWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .baseUrl("http://USER-SERVICE")
                .build();
    }
}



//Beans defined here will be managed by the Spring IoC container 
//and can be injected into other classes using @Autowired or constructor injection.



//#1  @LoadBalanced 
//tells Spring Cloud to wrap this WebClient.Builder with load-balancing and service discovery support (using Eureka service registry)

//That means instead of calling a hardcoded URL like http://localhost:8081, 
//you can call http://USER-SERVICE and Spring Cloud will look up the actual IP/port of 
//USER-SERVICE from Eureka and balance requests across multiple instances if they exist.



//  #2
//Defines a WebClient bean specifically preconfigured for USER-SERVICE.
//It uses the load-balanced WebClient.Builder from above.
//.baseUrl("http://USER-SERVICE") sets the default base URL. 
//Since you’re using service discovery, USER-SERVICE is the service ID registered in Eureka, not a hardcoded IP.
//build() → creates a WebClient instance that you can inject anywhere in activity-service.