package com.example.mutants.entities;

public class MutantException {

    // Valida un array de strings y maneja los posibles errores
    public static void mutantException(String[] array) {
        // Verificar si el array es null
        if (array == null) {
            throw new NullPointerException("El array es null.");
        }

        // Verificar si el array está vacío
        if (array.length == 0) {
            throw new IllegalArgumentException("El array está vacío.");
        }

        // Verificar que los elementos no sean null
        for (String elemento : array) {
            if (elemento == null) {
                throw new IllegalArgumentException("El array contiene valores nulos.");
            }
        }

        // Verificar que cada secuencia contenga solo A, T, C, G
        for (String elemento : array) {
            if (elemento == null) {
                throw new IllegalArgumentException("El array contiene valores nulos.");
            }

            if (!elemento.matches("[ATCG]+")) {
                throw new IllegalArgumentException("El array contiene caracteres no válidos: " + elemento);
            }
        }
    }
}

