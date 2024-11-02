package com.example.mutants.services;

import com.example.mutants.entities.Stats;
import com.example.mutants.repositories.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class StatsServiceImpl implements StatsService {

    @Autowired
    private StatsRepository statsRepository;

    @Override
    @Transactional
    public Stats getStats() {
        // Si no existe un registro de estadísticas, crear uno con valores iniciales
        return statsRepository.findById(1L).orElseGet(() -> {
            Stats newStats = new Stats();
            newStats.setCountMutantDna(0);
            newStats.setCountHumanDna(0);
            return statsRepository.save(newStats);
        });
    }

    @Override
    @Transactional
    public void incrementMutantCount() {
        Stats stats = getStats();
        stats.setCountMutantDna(stats.getCountMutantDna() + 1);
        statsRepository.save(stats);
    }

    @Override
    @Transactional
    public void incrementHumanCount() {
        Stats stats = getStats();
        stats.setCountHumanDna(stats.getCountHumanDna() + 1);
        statsRepository.save(stats);
    }
}

