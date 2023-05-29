package com.codewarsH.elPlan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codewarsH.elPlan.model.Ejercicios;
import com.codewarsH.elPlan.repositorio.EjerciciosRepository;

@Service
public class EjerciciosServiceImplement implements EjerciciosService{
	
	@Autowired
	private EjerciciosRepository repositorio;


	@Override
	@Transactional(readOnly = true)
	public List<Ejercicios> listar() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Ejercicios listarId(int id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Ejercicios add(Ejercicios e) {
		// TODO Auto-generated method stub
		return repositorio.save(e);
	}

	@Override
	@Transactional
	public Ejercicios edit(Ejercicios e) {
		// TODO Auto-generated method stub
		return repositorio.save(e);
	}


	@Override
	@Transactional
	public boolean remove(int id) {
		 if (repositorio.existsById(id)) {
			 repositorio.deleteById(id);
	            return true;
	        } else {
	            return false;
	        }
	}

	

}
