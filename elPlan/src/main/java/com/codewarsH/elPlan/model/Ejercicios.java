package com.codewarsH.elPlan.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ejercicios")
public class Ejercicios {
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String titulo;
	@Column
	private String descripcion;
	@Column
	private String test_visibles;
	@Column
	private String solucion;
	
	
	@Override
	public String toString() {
		return "{ \"id\": \"" + id + "\" , \"titulo\": \"" + titulo + "\"  , \"descripcion\": \"" + descripcion + "\",\"test_visibles\": \"" + test_visibles + "\" , \n\"solucion\": \""+ solucion + "\",";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ejercicios other = (Ejercicios) obj;
		return id == other.id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTest_visibles() {
		return test_visibles;
	}
	public void setTest_visibles(String test_visibles) {
		this.test_visibles = test_visibles;
	}
	
	public String getSolucion() {
		return solucion;
	}
	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}

}
