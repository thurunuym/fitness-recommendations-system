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
    }    //template that knows how to create WebClients which can talk to services by name (thanks to @LoadBalanced).

    @Bean
    public WebClient userServiceWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .baseUrl("http://USER-SERVICE")
                .build();
    } //uses the first bean (WebClient.Builder) to create a ready-to-use WebClient.
}







//Marks a method whose return object should be managed by Spring’s IoC container as a bean.

//Ex:
//webClientBuilder() → bean of type WebClient.Builder.
//userServiceWebClient(...) → bean of type WebClient.
//This means later you can @Autowired or use constructor injection to get these objects.



//#1  @LoadBalanced 
//This annotation tells Spring: The WebClient built using this builder should support service discovery.

//That means instead of calling a hardcoded URL like http://localhost:8081, 
//you can call http://USER-SERVICE and Spring Cloud will look up the actual IP/port of 
//USER-SERVICE from Eureka and balance requests across multiple instances if they exist.

//Normally, WebClient expects a real host/port like http://localhost:8081.
//With @LoadBalanced, you can give it a service name like http://USER-SERVICE.

//  #2
//Defines a WebClient bean specifically preconfigured for USER-SERVICE.
//It uses the load-balanced WebClient.Builder from above.
//.baseUrl("http://USER-SERVICE") sets the default base URL. 
//Since you’re using service discovery, USER-SERVICE is the service ID registered in Eureka, not a hardcoded IP.
//build() → creates a WebClient instance that you can inject anywhere in activity-service.


//First bean (WebClient.Builder) = a blueprint for building phones that can dial company extensions (service names).
//Second bean (userServiceWebClient) = a specific phone that is pre-programmed to always call the USER-SERVICE extension.
//UserValidationService = the employee who uses that phone to check if a user exists.