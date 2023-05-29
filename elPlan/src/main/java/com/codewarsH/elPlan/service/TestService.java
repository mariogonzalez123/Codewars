package com.codewarsH.elPlan.service;

import java.util.List;

import com.codewarsH.elPlan.model.Ocultos;

public interface TestService {
	List<Ocultos> listarOcultos();
	Ocultos listarOcultosId(int id);
	Ocultos add(Ocultos e);
	Ocultos edit(Ocultos e);
	boolean remove(int id);

}
