package com.codewarsH.elPlan;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codewarsH.elPlan.controller.Controlador;
import com.codewarsH.elPlan.model.Ejercicios;
import com.codewarsH.elPlan.model.Ocultos;
import com.codewarsH.elPlan.model.Publicidad;
import com.codewarsH.elPlan.service.EjerciciosService;
import com.codewarsH.elPlan.service.PubliService;
import com.codewarsH.elPlan.service.TestService;


@SpringBootTest
class ElPlanApplicationTests {
	
	@Autowired
	  private EjerciciosService miservicio;
	
	@Autowired
	private TestService ocultosService;
	
	@Autowired
	private PubliService publiService;
	
	
	@InjectMocks
	private Controlador controlador= new Controlador();
	
	@Mock
	private EjerciciosService service;
	
	private Ejercicios e;
	private Ocultos t;
	private Publicidad p;
	
	
	
	@Test
    public void serviceTest() {
      Assertions.assertEquals(4,miservicio.listar().size());
      Assertions.assertEquals(miservicio.listar().get(0).getId(),16);      
     
    }
	
	@Test
    public void ejerciciosTest() {
		e= new Ejercicios();
		 Assertions.assertTrue(miservicio.listar().get(0).equals(miservicio.listarId(16)));
		 Assertions.assertTrue(miservicio.listar().get(0).toString().equals(miservicio.listarId(16).toString()));
		 Assertions.assertFalse(miservicio.listar().get(0).equals(miservicio.listarId(17)));
		 Assertions.assertFalse(miservicio.listar().get(0).equals(e));
		 Assertions.assertTrue(e.equals(e));
		 e=null;
		 Assertions.assertFalse(miservicio.listarId(16).equals(e));
		 
		 e= new Ejercicios();
		 e.setId(0);
		 Assertions.assertEquals(e.getId(),0);
		 
		 String s="";
		 e.setDescripcion(s);
		 e.setSolucion(s);
		 e.setTest_visibles(s);
		 e.setTitulo(s);
		 Assertions.assertEquals(s,e.getDescripcion());
		 Assertions.assertEquals(s,e.getSolucion());
		 Assertions.assertEquals(s,e.getTest_visibles());
		 Assertions.assertEquals(s,e.getTitulo());
	}
	
	@Test
	public void controladorTest() throws Exception {
		
		when(service.listar()).thenReturn(miservicio.listar());
		
		Assertions.assertEquals(controlador.listar(), miservicio.listar());
		Assertions.assertNotEquals(controlador.listar(), new ArrayList<>());
		
	}
	
	
	@Test 
	public void serviceOcultos() {
		 Assertions.assertEquals(4,ocultosService.listarOcultos().size());
	      Assertions.assertEquals(ocultosService.listarOcultos().get(0).getId_ejercicio(),16);      
	}
	
	@Test
    public void TestOcultos() {
		t= new Ocultos();
		 Assertions.assertTrue(ocultosService.listarOcultos().get(0).equals(ocultosService.listarOcultosId(16)));
		 Assertions.assertTrue(ocultosService.listarOcultos().get(0).toString().equals(ocultosService.listarOcultosId(16).toString()));
		 Assertions.assertFalse(ocultosService.listarOcultos().get(0).equals(ocultosService.listarOcultosId(19)));
		 Assertions.assertFalse(ocultosService.listarOcultos().get(0).equals(t));
		 Assertions.assertTrue(t.equals(t));
		 t=null;
		 Assertions.assertFalse(ocultosService.listarOcultosId(16).equals(t));
		 
		 t= new Ocultos();
		 t.setId_ejercicio(0);
		 Assertions.assertEquals(t.getId_ejercicio(),0);
		 
		 String s="";
		
		
		 t.setTest_ocultos(s);
		
		 Assertions.assertEquals(s,t.getTest_ocultos());
	
		
		 
	}
	
	@Test 
	public void servicePubli() {
		 Assertions.assertEquals(1,publiService.listarPubli().size());
	      Assertions.assertEquals(publiService.listarPubli().get(0).getId(),1);      
	}
	
//	@Test
//    public void TestPubli() {
//		p= new Publicidad();
//		 Assertions.assertTrue(publiService.listarPubli().get(0).equals(publiService.listarPubliId(1)));
//		 Assertions.assertTrue(publiService.listarPubli().get(0).toString().equals(publiService.listarPubliId(1).toString()));
//		 Assertions.assertFalse(publiService.listarPubli().get(0).equals(publiService.listarPubliId(2)));
//		 Assertions.assertFalse(publiService.listarPubli().get(0).equals(p));
//		 Assertions.assertTrue(p.equals(p));
//		 p=null;
//		 Assertions.assertFalse(publiService.listarPubliId(16).equals(p));
//		 
//		 p= new Publicidad();
//		 p.setId(0);
//		 Assertions.assertEquals(p.getId(),0);
//		 
//		 String s="";
//		
//		
//		 p.setAnunciante(s);
//		
//		 Assertions.assertEquals(s,p.getAnunciante());
//	
//		
//		 
//	}
	

}
