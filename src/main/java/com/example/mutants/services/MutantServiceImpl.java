package com.example.mutants.services;

import com.example.mutants.entities.Mutant;
import com.example.mutants.repositories.BaseRepository;
import com.example.mutants.repositories.MutantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutantServiceImpl extends BaseServiceImpl<Mutant, Long> implements MutantService {
    @Autowired
    private MutantRepository mutantRepository;

    @Autowired
    private StatsService statsService; // Inyectamos el servicio de estadísticas

    public MutantServiceImpl(BaseRepository<Mutant, Long> baseRepository){
        super(baseRepository);
    }

    @Override
    public boolean isMutant(String[] dna) throws Exception {
        boolean isMutant = Mutant.isMutant(dna);

        // Actualizar estadísticas según el resultado
        if (isMutant) {
            statsService.incrementMutantCount();
        } else {
            statsService.incrementHumanCount();
        }

        return isMutant;
    }
}
