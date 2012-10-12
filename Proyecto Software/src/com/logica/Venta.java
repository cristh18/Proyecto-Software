package com.logica;

import java.util.Date;

public class Venta {
	private int idVenta;
	private Date fechaVenta;
	private Persona idClienteVenta;
	private Persona idVendedorVenta;
	private Carro idCarroVenta;
	
	public Venta() {
		this.idVenta = 0;
		this.fechaVenta = new Date();
		this.idClienteVenta = new Persona();
		this.idVendedorVenta = new  Persona();
		this.idCarroVenta = new Carro();
	}

	public Venta(Date fechaVenta, Persona idClienteVenta,
			Persona idVendedorVenta, Carro idCarroVenta) {
		this.fechaVenta = fechaVenta;
		this.idClienteVenta = idClienteVenta;
		this.idVendedorVenta = idVendedorVenta;
		this.idCarroVenta = idCarroVenta;
	}



	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Persona getIdClienteVenta() {
		return idClienteVenta;
	}

	public void setIdClienteVenta(Persona idClienteVenta) {
		this.idClienteVenta = idClienteVenta;
	}

	public Persona getIdVendedorVenta() {
		return idVendedorVenta;
	}

	public void setIdVendedorVenta(Persona idVendedorVenta) {
		this.idVendedorVenta = idVendedorVenta;
	}

	public Carro getIdCarroVenta() {
		return idCarroVenta;
	}

	public void setIdCarroVenta(Carro idCarroVenta) {
		this.idCarroVenta = idCarroVenta;
	}

	public Date getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
}
