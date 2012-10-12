package com.logica;

public class Direccion {
	private int idDireccion;
	private String nombreDireccion;
	
	public Direccion() {
		this.idDireccion = 0;
		this.nombreDireccion = "";
	}

	public Direccion(int idDireccion, String nombreDireccion) {
		super();
		this.idDireccion = idDireccion;
		this.nombreDireccion = nombreDireccion;
	}

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getNombreDireccion() {
		return nombreDireccion;
	}

	public void setNombreDireccion(String nombreDireccion) {
		this.nombreDireccion = nombreDireccion;
	}
}
