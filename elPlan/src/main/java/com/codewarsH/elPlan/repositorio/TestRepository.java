package com.codewarsH.elPlan.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewarsH.elPlan.model.Ocultos;

public interface TestRepository extends JpaRepository<Ocultos,Integer>{
	List<Ocultos> findAll();
	Ocultos findById(int id);
	Ocultos save(Ocultos e);
	void delete(Ocultos e);
	
	

}
