package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import modelo.Libro;

class LibroTest {
	

	@Test
	public void testAbrirLibro() {
		Libro libro = new Libro();
		File li2 = new File("juegotronos.txt");
		assertNotNull(libro.abrirLibro(li2));
	}

	@Test
	public void testValidarRuta() {
		Libro libro = new Libro();
		assertFalse(libro.validarLibro("no existe"));
		assertTrue(libro.validarLibro("juegotronos.txt"));
	}

}
