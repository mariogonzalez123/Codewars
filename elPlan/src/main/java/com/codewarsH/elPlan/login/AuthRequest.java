package com.codewarsH.elPlan.login;

import javax.validation.constraints.NotNull;

public class AuthRequest {
	@NotNull 
	private String nombre;
	
	@NotNull 
	private String password;

	public String getUsername() {
		return nombre;
	}

	public void setUsername(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
