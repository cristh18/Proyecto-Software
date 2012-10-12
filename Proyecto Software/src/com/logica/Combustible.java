package com.logica;

public class Combustible {
	private int idCombustible;
	private String nombreCombustible;
	
	public Combustible() {
		this.idCombustible = 0;
		this.nombreCombustible = "";
	}

	public Combustible(int idCombustible, String nombreCombustible) {
		this.idCombustible = idCombustible;
		this.nombreCombustible = nombreCombustible;
	}
	
	public int getIdCombustible() {
		return idCombustible;
	}

	public void setIdCombustible(int idCombustible) {
		this.idCombustible = idCombustible;
	}

	public String getNombreCombustible() {
		return nombreCombustible;
	}

	public void setNombreCombustible(String nombreCombustible) {
		this.nombreCombustible = nombreCombustible;
	}	
}
