package com.logica;

public class Modelo {
	private int idModelo;
	private String nombreModelo;
	private Marca idMarcaModelo;
	
	public Modelo() {
		this.idModelo = 0;
		this.nombreModelo = "";
		this.idMarcaModelo = new Marca();
	}
	
	public Modelo(String nombreModelo, Marca idMarcaModelo) {
		this.idModelo = 0;
		this.nombreModelo = nombreModelo;
		this.idMarcaModelo = idMarcaModelo;
	}

	public int getIdModelo() {
		return idModelo;
	}

	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}

	public String getNombreModelo() {
		return nombreModelo;
	}

	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}

	public Marca getIdMarcaModelo() {
		return idMarcaModelo;
	}

	public void setIdMarcaModelo(Marca idMarcaModelo) {
		this.idMarcaModelo = idMarcaModelo;
	}
}
