package com.example.mutants.services;

import com.example.mutants.entities.Mutant;
import org.springframework.http.ResponseEntity;

public interface MutantService extends BaseService<Mutant,Long>{
    public boolean isMutant(String[] dna) throws Exception;
}
