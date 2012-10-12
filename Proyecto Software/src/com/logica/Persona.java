package com.logica;

import java.util.Date;

public class Persona {
	private String cedulaPersona;
	private String nombrePersona;
	private String apellidoPersona;
	private String telefonoPersona;
	private String direccionPersona;
	private String correoPersona;
	private int tipoPersona;
	private String contraseniaPersona;
	private int estadoPersona;
	private int tipoCliente;
	private Date fechaIngresoPersona;
	private Date fechaCancelacionPersona;
	private int salarioPersona;
	
	public Persona() {
		this.cedulaPersona = "";
		this.nombrePersona = "";
		this.apellidoPersona = "";
		this.telefonoPersona = "";
		this.direccionPersona = "";
		this.correoPersona = "";
		this.tipoPersona = 0;
		this.contraseniaPersona = "";
		this.estadoPersona = 0;
		this.tipoCliente = 0;
		this.fechaIngresoPersona = new Date();
		this.fechaCancelacionPersona = null;
		this.salarioPersona = 0;
	}
	
	public Persona(String cedulaPersona, String nombrePersona,
			String apellidoPersona, String telefonoPersona,
			String direccionPersona, String correoPersona, 
			int tipoPersona, String contraseniaPersona, 
			int estadoPersona, int tipoCliente, Date fechaIngresoPersona,
			int salarioPersona) {
		this.cedulaPersona = cedulaPersona;
		this.nombrePersona = nombrePersona;
		this.apellidoPersona = apellidoPersona;
		this.telefonoPersona = telefonoPersona;
		this.direccionPersona = direccionPersona;
		this.correoPersona = correoPersona;
		this.tipoPersona = tipoPersona;
		this.contraseniaPersona = contraseniaPersona;
		this.estadoPersona = estadoPersona;
		this.tipoCliente = tipoCliente;
		this.fechaIngresoPersona = fechaIngresoPersona;
		this.fechaCancelacionPersona = null;
		this.salarioPersona = salarioPersona;
	}
	
	public String getCedulaPersona() {
		return cedulaPersona;
	}
	public void setCedulaPersona(String cedulaPersona) {
		this.cedulaPersona = cedulaPersona;
	}
	public String getNombrePersona() {
		return nombrePersona;
	}
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	public String getApellidoPersona() {
		return apellidoPersona;
	}
	public void setApellidoPersona(String apellidoPersona) {
		this.apellidoPersona = apellidoPersona;
	}
	public String getTelefonoPersona() {
		return telefonoPersona;
	}
	public void setTelefonoPersona(String telefonoPersona) {
		this.telefonoPersona = telefonoPersona;
	}
	public String getDireccionPersona() {
		return direccionPersona;
	}
	public void setDireccionPersona(String direccionPersona) {
		this.direccionPersona = direccionPersona;
	}
	public String getCorreoPersona() {
		return correoPersona;
	}
	public void setCorreoPersona(String correoPersona) {
		this.correoPersona = correoPersona;
	}
	public int getTipoPersona() {
		return tipoPersona;
	}
	public void setTipoPersona(int tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getContraseniaPersona() {
		return contraseniaPersona;
	}

	public void setContraseniaPersona(String contraseniaPersona) {
		this.contraseniaPersona = contraseniaPersona;
	}

	public int getEstadoPersona() {
		return estadoPersona;
	}

	public void setEstadoPersona(int estadoPersona) {
		this.estadoPersona = estadoPersona;
	}

	public int getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(int tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Date getFechaIngresoPersona() {
		return fechaIngresoPersona;
	}

	public void setFechaIngresoPersona(Date fechaIngresoPersona) {
		this.fechaIngresoPersona = fechaIngresoPersona;
	}

	public Date getFechaCancelacionPersona() {
		return fechaCancelacionPersona;
	}

	public void setFechaCancelacionPersona(Date fechaCancelacionPersona) {
		this.fechaCancelacionPersona = fechaCancelacionPersona;
	}

	public int getSalarioPersona() {
		return salarioPersona;
	}

	public void setSalarioPersona(int salarioPersona) {
		this.salarioPersona = salarioPersona;
	}
}