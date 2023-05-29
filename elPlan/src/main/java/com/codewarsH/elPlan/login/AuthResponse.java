package com.codewarsH.elPlan.login;

public class AuthResponse {
	private String nombre;
	private String accessToken;

	public AuthResponse() { }
	
	public AuthResponse(String nombre, String accessToken) {
		this.nombre = nombre;
		this.accessToken = accessToken;
	}

	public String getUsername() {
		return nombre;
	}

	public void setUsername(String nombre) {
		this.nombre = nombre;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}
