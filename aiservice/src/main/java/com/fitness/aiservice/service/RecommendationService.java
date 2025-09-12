package com.fitness.aiservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fitness.aiservice.model.Recommendation;
import com.fitness.aiservice.repository.RecommendationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepository repository;
    
    public List<Recommendation> getUserRecommendations(String userId){
        return repository.findByUserId(userId);
    }

    public Recommendation getActivityRecommendations(String activityId){
        return repository.findByActivityId(activityId)
        .orElseThrow(() -> new RuntimeException("No recommendation found for :" +activityId));
    }

}
