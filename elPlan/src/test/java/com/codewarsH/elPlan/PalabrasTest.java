package com.codewarsH.elPlan;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import com.codewarsH.elPlan.controller.Controlador;

class PalabrasTest {

	final Path rutaActual = Paths.get("");
	final String ruta = rutaActual.toAbsolutePath().toString();

	@Test
	void test1() throws IOException {
		final Controlador pa = new Controlador();
		assertEquals("****", pa.EncontrarPalabras("puto", ruta));
		assertEquals("****", pa.EncontrarPalabras("puta", ruta));
		assertEquals("****", pa.EncontrarPalabras("cani", ruta));
		assertEquals("****", pa.EncontrarPalabras("fuck", ruta));
		assertEquals("****", pa.EncontrarPalabras("niga", ruta));
		assertEquals("**********", pa.EncontrarPalabras("malfollada", ruta));
		assertEquals("*****", pa.EncontrarPalabras("nigga", ruta));
		assertEquals("******", pa.EncontrarPalabras("fucker", ruta));
		assertEquals("**********", pa.EncontrarPalabras("pusilanime", ruta));
		assertEquals("mother ******", pa.EncontrarPalabras("mother fucker", ruta));
		assertEquals("hijo de ****", pa.EncontrarPalabras("hijo de puta", ruta));
		assertEquals("***********", pa.EncontrarPalabras("soplapollas", ruta));
		assertEquals("**********", pa.EncontrarPalabras("gilipollas", ruta));
		assertEquals("***********", pa.EncontrarPalabras("perroflauta", ruta));
		assertEquals("***********", pa.EncontrarPalabras("asaltacunas", ruta));
		assertFalse(false, pa.EncontrarPalabras("maximo", ruta));
		assertFalse(false, pa.EncontrarPalabras("cabezon", ruta));
		assertFalse(false, pa.EncontrarPalabras("capullo", ruta));
		assertFalse(false, pa.EncontrarPalabras("lerdo", ruta));
		assertFalse(false, pa.EncontrarPalabras("tonto", ruta));
		assertFalse(false, pa.EncontrarPalabras("follada", ruta));

	}

}
