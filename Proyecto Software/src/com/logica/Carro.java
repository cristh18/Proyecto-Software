package com.logica;

import java.util.Date;

public class Carro {
	private int codigoCarro;
	private String placaCarro;
	private int cilindrajeCarro;
	private int anioCarro;
	private int precioCarro;
	private Persona idPropietarioPersona;
	private Color idColorCarro;
	private Vidrio idVidrioCarro;
	private Combustible idCombustibleCarro;
	private Direccion idDireccionCarro;
	private Transmision idTransmisionCarro;
	private TipoCarro idTipoCarroCarro;
	private Modelo idModeloCarro;
	private Date fechaIngresoCarro;
	private Date fechaVentaCarro;
	private int estadoCarro;
	
	public Carro() {
		this.codigoCarro = 0;
		this.placaCarro = "";
		this.cilindrajeCarro = 0;
		this.anioCarro = 0;
		this.precioCarro = 0;
		this.idPropietarioPersona = new Persona();
		this.idColorCarro = new Color();
		this.idVidrioCarro = new Vidrio();
		this.idCombustibleCarro = new Combustible();
		this.idDireccionCarro = new Direccion();
		this.idTransmisionCarro = new Transmision();
		this.idTipoCarroCarro = new TipoCarro();
		this.idModeloCarro = new Modelo();
		this.fechaIngresoCarro = new Date();
		this.fechaVentaCarro = null;
		this.estadoCarro = 0;
	}

	public Carro(String placaCarro, int cilindrajeCarro, int anioCarro,
			int precioCarro, Persona idPropietarioPersona, Color idColorCarro, 
			Vidrio idVidrioCarro, Combustible idCombustibleCarro,
			Direccion idDireccionCarro, Transmision idTransmisionCarro, 
			TipoCarro idTipoCarroCarro, Modelo idModeloCarro,
			int estadoCarro, Date fechaIngresoCarro) {
		codigoCarro = 0;
		this.placaCarro = placaCarro;
		this.cilindrajeCarro = cilindrajeCarro;
		this.anioCarro = anioCarro;
		this.precioCarro = precioCarro;
		this.idPropietarioPersona = idPropietarioPersona;
		this.idColorCarro = idColorCarro;
		this.idVidrioCarro = idVidrioCarro;
		this.idCombustibleCarro = idCombustibleCarro;
		this.idDireccionCarro = idDireccionCarro;
		this.idTransmisionCarro = idTransmisionCarro;
		this.idTipoCarroCarro = idTipoCarroCarro;
		this.idModeloCarro = idModeloCarro;
		this.estadoCarro = estadoCarro;
		this.fechaIngresoCarro = fechaIngresoCarro;
		this.fechaVentaCarro = null;
	}

	public String getPlacaCarro() {
		return placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}

	public int getCilindrajeCarro() {
		return cilindrajeCarro;
	}

	public void setCilindrajeCarro(int cilindrajeCarro) {
		this.cilindrajeCarro = cilindrajeCarro;
	}

	public int getAnioCarro() {
		return anioCarro;
	}

	public void setAnioCarro(int anioCarro) {
		this.anioCarro = anioCarro;
	}

	public Persona getIdPropietarioPersona() {
		return idPropietarioPersona;
	}

	public void setIdPropietarioPersona(Persona idPropietarioPersona) {
		this.idPropietarioPersona = idPropietarioPersona;
	}
	
	public int getPrecioCarro() {
		return precioCarro;
	}

	public void setPrecioCarro(int precioCarro) {
		this.precioCarro = precioCarro;
	}

	public Color getIdColorCarro() {
		return idColorCarro;
	}

	public void setIdColorCarro(Color idColorCarro) {
		this.idColorCarro = idColorCarro;
	}

	public Vidrio getIdVidrioCarro() {
		return idVidrioCarro;
	}

	public void setIdVidrioCarro(Vidrio idVidrioCarro) {
		this.idVidrioCarro = idVidrioCarro;
	}

	public Combustible getIdCombustibleCarro() {
		return idCombustibleCarro;
	}

	public void setIdCombustibleCarro(Combustible idCombustibleCarro) {
		this.idCombustibleCarro = idCombustibleCarro;
	}

	public Transmision getIdTransmisionCarro() {
		return idTransmisionCarro;
	}

	public void setIdTransmisionCarro(Transmision idTransmisionCarro) {
		this.idTransmisionCarro = idTransmisionCarro;
	}

	public TipoCarro getIdTipoCarroCarro() {
		return idTipoCarroCarro;
	}

	public void setIdTipoCarroCarro(TipoCarro idTipoCarroCarro) {
		this.idTipoCarroCarro = idTipoCarroCarro;
	}

	public int getEstadoCarro() {
		return estadoCarro;
	}

	public void setEstadoCarro(int estadoCarro) {
		this.estadoCarro = estadoCarro;
	}

	public Direccion getIdDireccionCarro() {
		return idDireccionCarro;
	}

	public void setIdDireccionCarro(Direccion idDireccionCarro) {
		this.idDireccionCarro = idDireccionCarro;
	}

	public Modelo getIdModeloCarro() {
		return idModeloCarro;
	}

	public void setIdModeloCarro(Modelo idModeloCarro) {
		this.idModeloCarro = idModeloCarro;
	}

	public int getCodigoCarro() {
		return codigoCarro;
	}

	public void setCodigoCarro(int codigoCarro) {
		this.codigoCarro = codigoCarro;
	}

	public Date getFechaIngresoCarro() {
		return fechaIngresoCarro;
	}

	public void setFechaIngresoCarro(Date fechaIngresoCarro) {
		this.fechaIngresoCarro = fechaIngresoCarro;
	}

	public Date getFechaVentaCarro() {
		return fechaVentaCarro;
	}

	public void setFechaVentaCarro(Date fechaVentaCarro) {
		this.fechaVentaCarro = fechaVentaCarro;
	}
}
