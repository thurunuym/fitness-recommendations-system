package com.fitness.activityservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fitness.activityservice.dto.ActivityResponse;

import com.fitness.activityservice.service.ActivityService;

import com.fitness.activityservice.dto.ActivityRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/activities")
public class ActivityController {

    @Autowired            //Spring finds the ActivityService bean and injects it.
    ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request) {
        
        return ResponseEntity.ok(activityService.trackActivity(request));    
    
    }
    
}
