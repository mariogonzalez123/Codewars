package com.codewarsH.elPlan.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codewarsH.elPlan.model.Publicidad;
import com.codewarsH.elPlan.repositorio.PubliRepository;

@Service
public class PubliServiceImplement implements PubliService{
	
	@Autowired
	private PubliRepository repositorio;


	@Override
	@Transactional(readOnly = true)
	public List<Publicidad> listarPubli() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Publicidad listarPubliId(int id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id);
	}

	@Override
	public Publicidad add(Publicidad e) {
		// TODO Auto-generated method stub
		return repositorio.save(e);
	}

	@Override
	@Transactional
	public Publicidad edit(Publicidad e) {
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

	@Override
	public Publicidad randomPubli() {
		List<Publicidad> publicidad=listarPubli();
		Random random= new Random();
		return publicidad.get(random.nextInt(publicidad.size()));
	}


	

}
