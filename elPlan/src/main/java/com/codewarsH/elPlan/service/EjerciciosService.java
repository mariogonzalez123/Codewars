package com.codewarsH.elPlan.service;

import java.util.List;

import com.codewarsH.elPlan.model.Ejercicios;

public interface EjerciciosService {
	List<Ejercicios> listar();
	Ejercicios listarId(int id);
	Ejercicios add(Ejercicios e);
	Ejercicios edit(Ejercicios e);
	boolean remove(int id);

}
