package com.fitness.activityservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fitness.activityservice.dto.ActivityResponse;

import com.fitness.activityservice.service.ActivityService;

import com.fitness.activityservice.dto.ActivityRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request) {
        
        return ResponseEntity.ok(activityService.trackActivity(request));    
    
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivities(@RequestHeader("X-User-ID") String userId){

            return ResponseEntity.ok(activityService.getUserActivities(userId));
        
        }
    
    
    //It expects a request header named "X-User-ID".
    //The value of that header is captured into the userId parameter.
    //Key: X-User-ID
    //Value: 222222
    //This style is common when the user ID comes from authentication or a gateway, not from the visible URL.
    //Easier to inject from an authentication filter or gateway without exposing in URL


    @GetMapping("/{activityId}")
    public ResponseEntity<ActivityResponse> getActivities(@PathVariable("activityId") String activity){

            return ResponseEntity.ok(activityService.getActivity(activity));
        
        }

    
}
