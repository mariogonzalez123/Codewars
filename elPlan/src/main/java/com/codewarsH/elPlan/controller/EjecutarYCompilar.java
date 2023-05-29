package com.codewarsH.elPlan.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.google.gson.JsonObject;

public class EjecutarYCompilar {

	public void Limpiador(String nombreArchivo, String ruta) throws IOException {
		Files.deleteIfExists(Paths.get(ruta + "\\" + nombreArchivo + ".java"));
		Files.deleteIfExists(Paths.get(ruta + "\\" + nombreArchivo + ".class"));

	}

	public void LimpiadorRutaAbsoluta(String ruta) throws IOException {
		Files.deleteIfExists(Paths.get(ruta + ".java"));
		Files.deleteIfExists(Paths.get(ruta + ".class"));

	}

	class ExcepcionNuestra extends Exception {
		public ExcepcionNuestra(String message) {
			super(message);
		}
	}

	public void CrearArchivos(String nombreEjercicio, String nombreTest, String contenidoEjercicio,
			String contenidoTest, String rutaEjercicio, String rutaTest) {
		try {
			final FileWriter myWriter = new FileWriter(nombreEjercicio + ".java");
			myWriter.write(contenidoEjercicio);
			myWriter.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
		try {
			final FileWriter myWriter = new FileWriter(nombreTest + ".java");
			myWriter.write(contenidoTest);
			myWriter.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public void CompilarEjercicio(String ruta, String rutaEjercicio) throws IOException, ExcepcionNuestra {
		final String commandCompilarSolucion[] = { "cmd.exe", "/c",
				"javac -cp " + ruta + "\\junit-jupiter-api-5.9.1.jar;" + ruta + "\\junit-jupiter-5.9.1.jar;" + ruta
						+ "\\apiguardian-api-1.1.2.jar " + rutaEjercicio };
		final ProcessBuilder processBuilderCompilarSolucion = new ProcessBuilder(commandCompilarSolucion);
		final Process processCompilarSolucion = processBuilderCompilarSolucion.start();
		final String error = new String(processCompilarSolucion.getErrorStream().readAllBytes());
		if (!error.isEmpty()) {
			LimpiadorRutaAbsoluta(rutaEjercicio);
			throw new ExcepcionNuestra(error);
		}
	}

	public void CompilarTest(String ruta, String rutaEjercicio, String rutaTest) throws IOException, ExcepcionNuestra {
		final String commandCompilarTest[] = { "cmd.exe", "/c",
				"javac -cp " + ruta + "\\junit-jupiter-api-5.9.1.jar;" + ruta + "\\junit-jupiter-5.9.1.jar;" + ruta
						+ "\\apiguardian-api-1.1.2.jar " + rutaEjercicio + " " + rutaTest };
		final ProcessBuilder processBuilderCompilarTest = new ProcessBuilder(commandCompilarTest);

		final Process processCompilarTest = processBuilderCompilarTest.start();
		final String error = new String(processCompilarTest.getErrorStream().readAllBytes());
		if (!error.isEmpty()) {
			LimpiadorRutaAbsoluta(rutaEjercicio);
			LimpiadorRutaAbsoluta(rutaTest);
			throw new ExcepcionNuestra(error);
		}
	}

	public void MapearTest(String ruta, String nombreArchivoTestsVisibles, String nombreArchivoSolucion)
			throws IOException, ExcepcionNuestra {

		final Process processMapearTest = new ProcessBuilder(new String[] { "cmd.exe", "/c",
				"java -jar " + ruta + "\\junit-platform-console-standalone-1.9.1.jar -cp " + ruta + "\\"
						+ nombreArchivoTestsVisibles + " --scan-classpath" })
				.start();
		final String error = new String(processMapearTest.getErrorStream().readAllBytes());
		if (!error.isEmpty()) {
			Limpiador(nombreArchivoSolucion, ruta);
			Limpiador(nombreArchivoTestsVisibles, ruta);
			throw new ExcepcionNuestra(error);
		}
	}

	public String EjecutarTest(String ruta, String nombreArchivoTestsVisibles, String nombreArchivoSolucion)
			throws IOException, ExcepcionNuestra {

		final Process processEjecutarTest = new ProcessBuilder(new String[] { "cmd.exe", "/c", "java -jar " + ruta
				+ "\\junit-platform-console-standalone-1.9.1.jar -cp . --select-class " + nombreArchivoTestsVisibles })
				.start();
		final String devolver = new String(processEjecutarTest.inputReader().lines().collect(Collectors.joining()));
		final String errorTest = new String(processEjecutarTest.getErrorStream().readAllBytes());
		if (!errorTest.isEmpty()) {
			Limpiador(nombreArchivoSolucion, ruta);
			Limpiador(nombreArchivoTestsVisibles, ruta);
			throw new ExcepcionNuestra(errorTest);
		}

		if (!devolver.contains("0 tests successful")) {
			Limpiador(nombreArchivoSolucion, ruta);
			Limpiador(nombreArchivoTestsVisibles, ruta);
			return "Pasa los tests";
		} else {
			final HashSet resultadosFallidos = new HashSet();
			final StringBuilder stringResultadosFallidos = new StringBuilder();
			final Matcher m = Pattern.compile("((expected:).*?(was:).*?[>])").matcher(devolver);
			while (m.find()) {
				resultadosFallidos.add(m.group());
			}
			final Iterator<Integer> it = resultadosFallidos.iterator();
			while (it.hasNext()) {
				stringResultadosFallidos.append(it.next()).append("\n");
			}
			Limpiador(nombreArchivoSolucion, ruta);
			Limpiador(nombreArchivoTestsVisibles, ruta);
			return stringResultadosFallidos.toString();
		}
	}

	public String pasarPrueba(JsonObject jsonObject) throws IOException, ExcepcionNuestra {
		// getting values form the JSONObject and casting that values into corresponding
		// types
		final String solucion = jsonObject.get("codigo").getAsString();
		final String testsVisibles = jsonObject.get("test").getAsString();

		// Get the class names
		if (!solucion.matches("[\\w\\W]*(public class )[\\w]+[\\w\\W]*")) {
			return "La solución debe tener una clase";
		}
		final String nombreArchivoSolucion = solucion
				.substring(solucion.indexOf("public class ") + 13, solucion.indexOf("{")).trim();
		final String nombreArchivoTestsVisibles = testsVisibles
				.substring(testsVisibles.indexOf("public class ") + 13, testsVisibles.indexOf("{")).trim();
		final Path rutaActual = Paths.get("");
		final String ss = rutaActual.toAbsolutePath().toString();
		final String command1[] = { "cmd.exe", "/c", "set path=" + ss };
		final ProcessBuilder processBuilder1 = new ProcessBuilder(command1);
		processBuilder1.start();
		CrearArchivos(nombreArchivoSolucion, nombreArchivoTestsVisibles, solucion, testsVisibles, ss, ss);

		final String JAVA_FILE_LOCATION = ss + "\\" + nombreArchivoSolucion + ".java";

		// Compilar
		CompilarEjercicio(ss, JAVA_FILE_LOCATION);
		final String JAVA_FILE_LOCATION2 = ss + "\\" + nombreArchivoTestsVisibles + ".java";
		CompilarTest(ss, JAVA_FILE_LOCATION, JAVA_FILE_LOCATION2);
		MapearTest(ss, nombreArchivoTestsVisibles, nombreArchivoSolucion);
		return EjecutarTest(ss, nombreArchivoTestsVisibles, nombreArchivoSolucion);
	}
}
