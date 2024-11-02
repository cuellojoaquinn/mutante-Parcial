package com.example.mutants.services;

import com.example.mutants.entities.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface BaseService<E extends Base, ID extends Serializable> {
    public E save(E entity) throws Exception;
}
