package com.logica;

public class Vidrio {
	private int idVidrio;
	private String nombreVidrio;
	
	public Vidrio() {
		this.idVidrio = 0;
		this.nombreVidrio = "";
	}

	public Vidrio(int idVidrio, String nombreVidrio) {
		this.idVidrio = idVidrio;
		this.nombreVidrio = nombreVidrio;
	}

	public int getIdVidrio() {
		return idVidrio;
	}

	public void setIdVidrio(int idVidrio) {
		this.idVidrio = idVidrio;
	}

	public String getNombreVidrio() {
		return nombreVidrio;
	}

	public void setNombreVidrio(String nombreVidrio) {
		this.nombreVidrio = nombreVidrio;
	}
}
