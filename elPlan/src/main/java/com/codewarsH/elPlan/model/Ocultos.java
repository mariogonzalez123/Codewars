package com.codewarsH.elPlan.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tests")
public class Ocultos {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_ejercicio;
	
	@Column
	private String test_ocultos;
	
	@Override
	public int hashCode() {
		return Objects.hash(id_ejercicio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ocultos other = (Ocultos) obj;
		return id_ejercicio == other.id_ejercicio;
	}

	@Override
	public String toString() {
		return "tests [id_ejercicio=" + id_ejercicio + ", test_ocultos=" + test_ocultos + "]";
	}

	public int getId_ejercicio() {
		return id_ejercicio;
	}

	public void setId_ejercicio(int id_ejercicio) {
		this.id_ejercicio = id_ejercicio;
	}

	public String getTest_ocultos() {
		return test_ocultos;
	}

	public void setTest_ocultos(String test_ocultos) {
		this.test_ocultos = test_ocultos;
	}

	

}
