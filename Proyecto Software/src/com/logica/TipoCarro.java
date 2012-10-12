package com.logica;

public class TipoCarro {
	private int idTipoCarro;
	private String nombreTipoCarro;
	
	public TipoCarro() {
		this.idTipoCarro = 0;
		this.nombreTipoCarro = "";
	}

	public TipoCarro(int idTipoCarro, String nombreTipoCarro) {
		this.idTipoCarro = idTipoCarro;
		this.nombreTipoCarro = nombreTipoCarro;
	}

	public int getIdTipoCarro() {
		return idTipoCarro;
	}

	public void setIdTipoCarro(int idTipoCarro) {
		this.idTipoCarro = idTipoCarro;
	}

	public String getNombreTipoCarro() {
		return nombreTipoCarro;
	}

	public void setNombreTipoCarro(String nombreTipoCarro) {
		this.nombreTipoCarro = nombreTipoCarro;
	}
}
