package com.example.mutants.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

import static com.example.mutants.entities.MutantException.mutantException;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mutant extends Base{

    @Column
    private String[] dna;

    public static String[] createDna(int size){
        String[] dna = new String[size];
        char[] acgt = new char[] { 'A', 'C', 'G', 'T'};


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                Random random = new Random();
                int index = random.nextInt(4);

                if(dna[i] == null){
                    dna[i] = String.valueOf(acgt[index]);
                }else{
                    dna[i] = dna[i]+acgt[index];
                }

            }
        }
        return dna;
    }

    // Búsqueda horizontal
    public static List<String> busquedaHorizontal(String[] dna) {
        List<String> positions = new ArrayList<>();
        int size = dna.length;
        int cant = 4;
        int moves= size-cant+1;
        Set<String> letrasEncontradas = new HashSet<>();

        for (int x = 0; x < size; x++) {
            for (int i = 0; i < moves; i++) { // se debe cambiar moves por size - cant
                char inicio = dna[x].charAt(i);
                boolean seq = true;

                for (int j = 1; j < cant; j++) {
                    if (inicio != dna[x].charAt(i + j)) {
                        seq = false;
                        break;
                    }
                }
                if (seq) {
                    if (letrasEncontradas.contains(String.valueOf(inicio))) {
                        return new ArrayList<>();
                    }else{
                        letrasEncontradas.add(String.valueOf(inicio));
                        positions.add("Horizontal Fila: " + x + " Posición: " + i + " Letter: " + inicio);
                    }
                }
            }
        }
        return positions;
    }

    // Búsqueda vertical
    public static List<String> busquedaVertical(String[] dna) {
        List<String> positions = new ArrayList<>();
        int size = dna.length;
        int cant = 4;
        int moves = size-cant+1;
        Set<String> letrasEncontradas = new HashSet<>();

        for (int y = 0; y < size; y++) {
            for (int i = 0; i < moves; i++) {
                char inicio = dna[i].charAt(y);
                boolean seq = true;

                for (int k = 1; k < cant; k++) {
                    if (inicio != dna[i + k].charAt(y)) {
                        seq = false;
                        break;
                    }
                }

                if (seq) {
                    if (letrasEncontradas.contains(String.valueOf(inicio))) {
                        return new ArrayList<>();
                    }else{
                        letrasEncontradas.add(String.valueOf(inicio));
                        positions.add("Vertical Columna: " + y + " Posición: " + i + " Letter: " + inicio);
                    }
                }
            }
        }
        return positions;
    }

    // Búsqueda oblicua
    public static List<String> busquedaOblicua(String[] dna) {
        List<String> positions = new ArrayList<>();
        int size = dna.length;
        int cant = 4;
        int moves = size-cant+1;
        Set<String> letrasEncontradas = new HashSet<>();

        for (int j = 0; j < moves; j++) {
            for (int i = 0; i < moves; i++) {
                char inicio = dna[i].charAt(j);
                boolean seq = true;

                for (int k = 1;  k < cant; k++) {
                    if (inicio != dna[i + k].charAt(j+k)) {
                        seq = false;
                        break;
                    }
                }

                if (seq) {
                    if (letrasEncontradas.contains(String.valueOf(inicio))) {
                        return new ArrayList<>();
                    }else{
                        letrasEncontradas.add(String.valueOf(inicio));
                        positions.add("Oblicua ID: " + i + " Posición: " + j + " Letter: " + inicio);
                    }
                }
            }
        }
        return positions;
    }

    // Búsqueda oblicua de derecha a izquierda
    public static List<String> busquedaOblicuaDI(String[] dna) {
        List<String> positions = new ArrayList<>();
        int size = dna.length;
        int cant = 4;
        int moves = size - cant + 1; // Cuántas posiciones puedes mover
        Set<String> letrasEncontradas = new HashSet<>();

        // Recorrer las filas
        for (int i = 0; i < moves; i++) {
            // Recorrer las columnas desde cant - 1 hasta el final
            for (int j = cant - 1; j < size; j++) {
                char inicio = dna[i].charAt(j); // Obtener la letra inicial
                boolean seq = true;

                // Comparar las siguientes posiciones en diagonal (derecha a izquierda)
                for (int k = 1; k < cant; k++) {
                    if (inicio != dna[i + k].charAt(j - k)) { // Mover hacia abajo y a la izquierda
                        seq = false;
                        break;
                    }
                }

                // Si se encuentra una secuencia
                if (seq) {
                    // Verificar si la secuencia ya fue encontrada
                    if (letrasEncontradas.contains(String.valueOf(inicio))) {
                        return new ArrayList<>();
                    } else {
                        letrasEncontradas.add(String.valueOf(inicio));
                        positions.add("Oblicua DI: " + i + " Posición: " + j + " Letter: " + inicio);
                    }
                }
            }
        }
        return positions; // Retorna las posiciones encontradas
    }

    public static boolean isMutant(String[] dna) {

        mutantException(dna);

        List<String> horizontal = busquedaHorizontal(dna);
        List<String> vertical = busquedaVertical(dna);
        List<String> oblicuoID = busquedaOblicua(dna);
        List<String> oblicuoDI = busquedaOblicuaDI(dna);

        return horizontal.size() + vertical.size() + oblicuoID.size() + oblicuoDI.size() > 1;
    }
}
