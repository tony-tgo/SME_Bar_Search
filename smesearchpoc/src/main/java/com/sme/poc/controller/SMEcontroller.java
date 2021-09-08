package com.sme.poc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.sme.poc.model.SMEs;

import com.sme.poc.repository.SMERepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class SMEcontroller {

    private static final Logger logger = LoggerFactory.getLogger(SMEcontroller.class);

    @Autowired
    SMERepository smeRepository;

    // @GetMapping("/smebar")
    // public List<SMEs> findallSMEs() {

    // // List<SMEs> smes = new ArrayList<SMEs>();
    // return smeRepository.findAll();
    // }
    @GetMapping("/smebar")
    public ResponseEntity<List<SMEs>> getAllSMEs(@RequestParam(required = false) String name) {
        try {
            List<SMEs> smes = new ArrayList<SMEs>();
            if (name == null) {
                // smes::add = s-> sme.add(s)
                smeRepository.findAll().forEach(smes::add);
            } else
                smeRepository.findByNameContaining(name).forEach(smes::add);

            if (smes.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(smes, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/smebar/{keyword}")
    public ResponseEntity<List<SMEs>> findbySkills(@PathVariable("keyword") String keyword) {
        try {
            List<SMEs> smekeys = new ArrayList<SMEs>();
            smeRepository.findBySkillsOrJobTitleOrClientEngagement(keyword,keyword, keyword).forEach(smekeys::add);
            // smeRepository.findBySkillsContaining((List<String>)ss->ss.forEach(s?s==skill:s!=skill));
            // Query.query(Criteria.where("name").is(name)), SMEs.class
            if (smekeys.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(smekeys, HttpStatus.OK);
        } catch (Exception e) {
            logger.info(e + "this is not working");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/smebar")
    public ResponseEntity<SMEs> createSME(@RequestBody SMEs sme) {
        try {
            SMEs _sme = smeRepository
                    .save(new SMEs(sme.getName(), sme.getJobTitle(), sme.getSkills(), sme.getClientEngagement()));
            return new ResponseEntity<>(_sme, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
