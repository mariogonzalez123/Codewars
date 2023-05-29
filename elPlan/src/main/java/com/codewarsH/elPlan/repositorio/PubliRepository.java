package com.codewarsH.elPlan.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewarsH.elPlan.model.Publicidad;

public interface PubliRepository extends JpaRepository<Publicidad,Integer>{
	List<Publicidad> findAll();
	Publicidad findById(int id);
	Publicidad save(Publicidad e);
	void delete(Publicidad e);
	
	

}
