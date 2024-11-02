package com.example.mutants.entities;

public class MutantException {

    // Valida un array de strings y maneja los posibles errores
    public static void mutantException(String[] dna) {
        // Verifica que el array no sea nulo
        if (dna == null) {
            throw new NullPointerException("El array es null.");
        }

        // Verifica que el array no esté vacío
        if (dna.length == 0) {
            throw new IllegalArgumentException("El array está vacío.");
        }

        // Verifica que la matriz sea cuadrada (NxN)
        for (String row : dna) {
            if (row == null) {
                throw new IllegalArgumentException("El array contiene valores nulos.");
            }
            if (row.length() != dna.length) {
                throw new IllegalArgumentException("El array debe ser cuadrado (NxN).");
            }
            // Verifica que solo contenga A, C, G, T
            for (char ch : row.toCharArray()) {
                if (ch != 'A' && ch != 'C' && ch != 'G' && ch != 'T') {
                    throw new IllegalArgumentException("El array contiene caracteres no válidos: " + row);
                }
            }
        }
    }
}

