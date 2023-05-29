
package com.codewarsH.elPlan.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewarsH.elPlan.controller.EjecutarYCompilar.ExcepcionNuestra;
import com.codewarsH.elPlan.model.Ejercicios;
import com.codewarsH.elPlan.model.Ocultos;
import com.codewarsH.elPlan.model.Publicidad;
import com.codewarsH.elPlan.repositorio.PubliRepository;
import com.codewarsH.elPlan.service.EjerciciosService;
import com.codewarsH.elPlan.service.PubliService;
import com.codewarsH.elPlan.service.TestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping
public class Controlador {

	@Autowired
	EjerciciosService service;

	@GetMapping("/ejercicios")
	public List<Ejercicios> listar() {
		return service.listar();
	}

	@GetMapping("/ejercicios/{id}")
	public String listarId(@PathVariable int id) throws IOException {
		final StringBuilder sb = new StringBuilder();
		final Path rutaActual = Paths.get("");
		final String ruta = rutaActual.toAbsolutePath().toString();
		final Ejercicios pls = service.listarId(id);
		final String texto = pls.getTest_visibles();
		pls.setTest_visibles(texto);
		final Publicidad p = Publiservice.randomPubli();
		// String json = "{ \"id\": \"" + id + "\" , \"titulo\": \"" + pls.getTitulo() +
		// "\" , \"descripcion\": \"" + pls.getDescripcion() + "\",\"test_visibles\":
		// \"" + pls.getTest_visibles() + "\" , \n\"solucion\": \""+
		// pls.getDescripcion() + "\", \"titulo_publicidad\": \"" + p.getTitulo() +
		// "\",\n \"descripcion_publicidad\":\"" + p.getDescripcion() + "\"}";;
		sb.append(pls.toString());
		final String filtrado = EncontrarPalabras(p.toString(), ruta);
		sb.append(filtrado);
		final JsonObject convertedObject = new Gson().fromJson(sb.toString(), JsonObject.class);

		p.setContador(p.getContador() + 1);
		Publiservice.edit(p);

		return convertedObject.toString();

	}

	@PostMapping("/ejercicios/sol")
	public String solEjercicio(@RequestBody String solucion) throws IOException {

		final JsonObject convert = parseJson(solucion, 1);

		try {
			return new EjecutarYCompilar().pasarPrueba(convert);
		} catch (final ExcepcionNuestra e) {
			return e.getMessage();
		}
	}

	@Autowired
	TestService testservice;

	@GetMapping("/tests")
	public List<Ocultos> listarOcultos() {
		return testservice.listarOcultos();
	}

	@GetMapping("/tests/{id}")
	public Ocultos listarOcultosId(@PathVariable int id) {
		return testservice.listarOcultosId(id);
	}

	@PostMapping("/tests/sol")
	public String testEjercicio(@RequestBody String solucion) throws IOException, ExcepcionNuestra {
		final JsonObject convert = parseJson(solucion, 2);

		// metodo de esta gente
		try {
			return new EjecutarYCompilar().pasarPrueba(convert);
		} catch (final ExcepcionNuestra e) {
			return e.getMessage();
		}
	}

	@Autowired
	PubliService Publiservice;
	@Autowired
	PubliRepository repo;

	@GetMapping("/publi/{id}")
	public Publicidad listarPubliId(@PathVariable int id) {
		return Publiservice.listarPubliId(id);
	}

	@PostMapping("/publi/nueva")
	public ResponseEntity nuevaPubli(@RequestBody @Valid String publicidad) throws JsonMappingException, JsonProcessingException {
		
	    
		ObjectMapper mapper = new ObjectMapper();
		Publicidad p=mapper.readValue(publicidad, Publicidad.class);
		repo.save(p);
		URI publiURI= URI.create("/publi/nueva/" + p.getId());
		return ResponseEntity.created(publiURI).body(p);
		
	}

//	@PostMapping("/publi/cont/{id}")
//	public void contPubli(@PathVariable int id){
//
//		int cont=Publiservice.listarPubliId(id).getContador()+1;
//		Publicidad publi= Publiservice.listarPubliId(id);
//		publi.setContador(cont);
//		Publiservice.edit(publi);
//
//
//
//	}

	public JsonObject parseJson(String solucion, int tipotest) {
		final JsonObject convertedObject = new Gson().fromJson(solucion, JsonObject.class);

		final int id = convertedObject.get("id").getAsInt();
		final Ejercicios e = service.listarId(id);
		if (e == null) {
			return null;
		}
		final Ocultos ocultos = testservice.listarOcultosId(id);
		if (ocultos == null) {
			return null;
		}
		final String codigo = convertedObject.get("codigo").getAsString().replaceAll("\"", "\\\\\"");


		String test = "";
		switch (tipotest) {
		case 1:
			test = e.getTest_visibles();
			break;
		case 2:
			test = ocultos.getTest_ocultos().replaceAll("\"", "\\\\\"");
			break;

		default:
			break;
		}
		final String json = "{ \"codigo\": \"" + codigo + "\", \"test\": \"" + test + "\" }";
		final JsonObject convert = new Gson().fromJson(json, JsonObject.class);

		return convert;

	}

	public static String EncontrarPalabras(String frase, String ruta) throws IOException {
		final BufferedReader abc = new BufferedReader(new FileReader(ruta + "\\PalabrasCensuradas.txt"));
		final List<String> lines = new ArrayList<String>();

		String line;
		while ((line = abc.readLine()) != null) {
			lines.add(line);
		}
		abc.close();
		String modificar = frase;
		for (final String p : lines) {
			if (modificar.contains(p)) {
				final StringBuilder cambiar = new StringBuilder();
				for (int i = 0; i < p.length(); i++) {
					cambiar.append("*");
				}
				final StringBuilder replacement = new StringBuilder(cambiar);
				modificar = modificar.replace(p, replacement);
			}
		}
		return modificar;
	}

}
