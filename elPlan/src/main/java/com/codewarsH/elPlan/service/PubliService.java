package com.codewarsH.elPlan.service;

import java.util.List;

import com.codewarsH.elPlan.model.Publicidad;

public interface PubliService {
	List<Publicidad> listarPubli();
	Publicidad listarPubliId(int id);
	Publicidad randomPubli();
	Publicidad add(Publicidad e);
	Publicidad edit(Publicidad e);
	boolean remove(int id);

}
