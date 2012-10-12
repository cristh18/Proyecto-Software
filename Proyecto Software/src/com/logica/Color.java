package com.logica;

public class Color {
	private int idColor;
	private String nombreColor;

	public Color() {
		this.idColor = 0;
		this.nombreColor = "";
	}

	public Color(int idColor, String nombreColor) {
		this.idColor = idColor;
		this.nombreColor = nombreColor;
	}
	public int getIdColor() {
		return idColor;
	}
	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}
	public String getNombreColor() {
		return nombreColor;
	}
	public void setNombreColor(String nombreColor) {
		this.nombreColor = nombreColor;
	}

}
