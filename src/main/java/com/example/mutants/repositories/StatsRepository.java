package com.example.mutants.repositories;

import com.example.mutants.entities.Mutant;
import com.example.mutants.entities.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Long> {
}
