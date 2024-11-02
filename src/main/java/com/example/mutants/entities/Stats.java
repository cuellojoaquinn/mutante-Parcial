package com.example.mutants.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int countMutantDna;
    private int countHumanDna;

    // Método para calcular la proporción mutante/humano
    public double getRatio() {
        if (countHumanDna == 0) {
            return countMutantDna > 0 ? Double.POSITIVE_INFINITY : 0.0;
        }
        return (double) countMutantDna / (countHumanDna + countMutantDna);
    }
}
