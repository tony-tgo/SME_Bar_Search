package com.sme.poc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sme.poc.model.SMEs;

public interface SMERepository extends MongoRepository<SMEs,String>{

    List<SMEs> findByNameContaining(String name);
    List<SMEs> findBySkillsOrJobTitleOrClientEngagement(String skills, String jobTitle, String clientEngagement);
    
    // List<SMEs> findByJob_titleContaining(String job_title);
    // List<SMEs> findBySkills(Array skills);
    // List<SMEs> findbyName(String name);

}
