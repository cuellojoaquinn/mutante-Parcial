package com.example.mutants.controllers;

import com.example.mutants.entities.Base;
import com.example.mutants.entities.Mutant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.awt.print.Pageable;
import java.io.Serializable;

public interface BaseController <E extends Base,ID extends Serializable>{
    public ResponseEntity<?> isMutant(@RequestBody Mutant dna);
    public ResponseEntity<?> save(@RequestBody E entity);
}
