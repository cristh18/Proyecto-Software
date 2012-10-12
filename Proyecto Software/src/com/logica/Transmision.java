package com.logica;

public class Transmision {
	private int idTransmision;
	private String nombreTransmision;
	
	public Transmision() {
		this.idTransmision = 0;
		this.nombreTransmision = "";
	}
	
	public Transmision(int idTransmision, String nombreTransmision) {
		super();
		this.idTransmision = idTransmision;
		this.nombreTransmision = nombreTransmision;
	}

	public int getIdTransmision() {
		return idTransmision;
	}

	public void setIdTransmision(int idTransmision) {
		this.idTransmision = idTransmision;
	}

	public String getNombreTransmision() {
		return nombreTransmision;
	}

	public void setNombreTransmision(String nombreTransmision) {
		this.nombreTransmision = nombreTransmision;
	}
}
