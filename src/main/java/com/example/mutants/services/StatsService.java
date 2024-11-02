package com.example.mutants.services;

import com.example.mutants.entities.Stats;

public interface StatsService {
    Stats getStats();
    void incrementMutantCount();
    void incrementHumanCount();
}
