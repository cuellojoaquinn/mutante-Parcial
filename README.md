# Examen Mercadolibre

Este proyecto tiene como objetivo detectar si un humano es mutante basándose en su secuencia de ADN.

## Descripción

La aplicación recibe como entrada un array de Strings que representan las filas de una tabla de ADN (NxN). Las letras de los Strings solo pueden ser A, T, C o G, que representan las bases nitrogenadas del ADN. Se considera que un humano es mutante si se encuentran más de una secuencia de cuatro letras iguales en forma oblicua, horizontal o vertical.

# URL de la API
La API está disponible en el siguiente enlace:

https://mutante-parcial.onrender.com

# Método Principal

El método principal a implementar es:

```java
boolean isMutant(String[] dna);
```

## Ejemplo de uso 

```java
String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
boolean result = isMutant(dna); // Devuelve true
```

# Tecnologías Utilizadas

Java (para la implementación del algoritmo)
Spring Boot (para la API REST)
Render (para el hospedaje de la API)

# Ejecución
Para ejecutar la API:

1. Clona este repositorio.
2. Configura tu entorno de desarrollo con las dependencias necesarias (Java, Spring Boot, etc.).
3. Ejecuta la aplicación.

