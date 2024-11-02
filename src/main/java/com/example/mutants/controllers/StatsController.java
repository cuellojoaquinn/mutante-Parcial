package com.example.mutants.controllers;

import com.example.mutants.entities.Stats;
import com.example.mutants.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping
    public ResponseEntity<Stats> getStats() {
        Stats stats = statsService.getStats();
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }
}