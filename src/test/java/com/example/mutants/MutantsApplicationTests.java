package com.example.mutants;

import com.example.mutants.entities.Mutant;
import com.example.mutants.services.MutantService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class MutantsApplicationTests {

	@Autowired
	public MutantService servicio;

	//Aca debajo estan los test propuestos por el profe

	@Test
	void arrayVacio() {
		// Array vacío
		String[] dna = {};

		// Espera IllegalArgumentException
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Mutant.isMutant(dna);
		});

		// Verifica el mensaje de la excepción
		assertEquals("El array está vacío.", exception.getMessage());
	}

	@Test
	void arrayNxM() {
		// Array no cuadrado (NxM)
		String[] dna = {"ATGC", "AAGT", "TCGG", "TGC", "CGTA"};

		// Espera IllegalArgumentException
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Mutant.isMutant(dna);
		});

		// Verifica el mensaje de la excepción
		assertEquals("El array debe ser cuadrado (NxN).", exception.getMessage());
	}

	@Test
	public void arrayNumeros(){
		String[] dna = {
				"5555",
				"5555",
				"5555",
				"5555"
		};
		assertThrows(IllegalArgumentException.class,()->{servicio.isMutant(dna);});
	}

	@Test
	public void recibirNull(){
		assertThrows(NullPointerException.class,()->{servicio.isMutant(null);});
	}

	@Test
	public void arrayOtrasLetras(){
		String[] dna = {
				"BBBB",
				"HHHH",
				"BBBB",
				"HHHH"
		};
		assertThrows(IllegalArgumentException.class,()->{servicio.isMutant(dna);});
	}

	@Test
	public void prueba1() throws Exception {
		String[] dna = {
				"AAAA",
				"CCCC",
				"TCAG",
				"GGTC"
		};
		Assumptions.assumeTrue(servicio.isMutant(dna));
	}

	@Test
	public void prueba2() throws Exception {
		String[] dna = {
				"AAAT",
				"AACC",
				"AAAC",
				"CGGG"
		};
		Assumptions.assumeFalse(servicio.isMutant(dna));
	}

	@Test
	public void prueba3() throws Exception {
		String[] dna = {
				"TGAC",
				"AGCC",
				"TGAC",
				"GGTC"
		};
		Assumptions.assumeTrue(servicio.isMutant(dna));
	}

	@Test
	public void prueba4() throws Exception {
		String[] dna = {
				"AAAA",
				"AAAA",
				"AAAA",
				"AAAA"
		};
		Assumptions.assumeTrue(servicio.isMutant(dna));
	}

	@Test
	public void prueba5() throws Exception {
		String[] dna = {
				"TGAC",
				"ATCC",
				"TAAG",
				"GGTC"
		};
		Assumptions.assumeFalse(servicio.isMutant(dna));
	}

	@Test
	public void prueba6() throws Exception {
		String[] dna = {
				"TCGGGTGAT",
				"TGATCCTTT",
				"TACGAGTGA",
				"AAATGTACG",
				"ACGAGTGCT",
				"AGACACATG",
				"GAATTCCAA",
				"ACTACGACC",
				"TGAGTATCC"
		};
		Assumptions.assumeTrue(servicio.isMutant(dna));
	}

	@Test
	public void prueba7() throws Exception {
		String[] dna = {
				"TTTTTTTTT",
				"TTTTTTTTT",
				"TTTTTTTTT",
				"TTTTTTTTT",
				"CCGACCAGT",
				"GGCACTCCA",
				"AGGACACTA",
				"CAAAGGCAT",
				"GCAGTCCCC"
		};
		Assumptions.assumeTrue(servicio.isMutant(dna));
	}
}
