package com.logica;

public class Imagen {
	private int idImagen;
	private byte []imagen;
	private Carro idCarroImagen;
	
	public Imagen(byte[] imagen, Carro idCarroImagen) {
		this.idImagen = 0;
		this.imagen = imagen;
		this.idCarroImagen = idCarroImagen;
	}
	
	public Imagen() {
		this.idImagen = 0;
		this.imagen = null;
		this.idCarroImagen = null;
	}

	public int getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(int idImagen) {
		this.idImagen = idImagen;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public Carro getIdCarroImagen() {
		return idCarroImagen;
	}

	public void setIdCarroImagen(Carro idCarroImagen) {
		this.idCarroImagen = idCarroImagen;
	}
	
}
