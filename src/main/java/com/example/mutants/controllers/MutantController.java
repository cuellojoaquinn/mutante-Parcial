package com.example.mutants.controllers;


import com.example.mutants.entities.Mutant;
import com.example.mutants.services.MutantServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*") //Brindar acceso o no a nuestra API desde distintos origenes.
@RequestMapping(path = "/mutant") //Path de acceso al recurso
public class MutantController extends BaseControllerImpl<Mutant, MutantServiceImpl>{

    @Override
    @PostMapping("/isMutant")
    public ResponseEntity<?> isMutant(@RequestBody Mutant dna) {
        try {
            // Llamar al servicio para verificar si es mutante
            boolean isMutant = servicio.isMutant(dna.getDna());
            return ResponseEntity.status(isMutant ? HttpStatus.OK : HttpStatus.FORBIDDEN)
                    .body("{\"mutant\":" + isMutant + "}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }
}


