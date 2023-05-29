package com.codewarsH.elPlan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codewarsH.elPlan.model.Ocultos;
import com.codewarsH.elPlan.repositorio.TestRepository;

@Service
public class TestServiceImplement implements TestService{
	
	@Autowired
	private TestRepository repositorio;


	@Override
	@Transactional(readOnly = true)
	public List<Ocultos> listarOcultos() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Ocultos listarOcultosId(int id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Ocultos add(Ocultos e) {
		// TODO Auto-generated method stub
		return repositorio.save(e);
	}

	@Override
	@Transactional
	public Ocultos edit(Ocultos e) {
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
