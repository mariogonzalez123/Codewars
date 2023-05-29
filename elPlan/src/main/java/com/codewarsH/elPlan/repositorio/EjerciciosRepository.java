package com.codewarsH.elPlan.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewarsH.elPlan.model.Ejercicios;

public interface EjerciciosRepository extends JpaRepository<Ejercicios, Integer>{
	List<Ejercicios> findAll();
	Ejercicios findById(int id);
	Ejercicios save(Ejercicios e);
	void delete(Ejercicios e);
	
	

}
