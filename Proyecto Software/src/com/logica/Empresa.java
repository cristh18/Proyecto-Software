package com.logica;

public class Empresa {
	
	private int codigoEmpresa;
	private String nitEmpresa;
	private String razonSocialEmpresa;
	private String misionEmpresa;
	private String visionEmpresa;
	
	public Empresa(String nitEmpresa, String razonSocialEmpresa,
			String misionEmpresa, String visionEmpresa) {
		codigoEmpresa = 0;
		this.nitEmpresa = nitEmpresa;
		this.razonSocialEmpresa = razonSocialEmpresa;
		this.misionEmpresa = misionEmpresa;
		this.visionEmpresa = visionEmpresa;
	}

	public Empresa() {
		codigoEmpresa = 0;
		this.nitEmpresa = "";
		this.razonSocialEmpresa = "";
		this.misionEmpresa = "";
		this.visionEmpresa = "";
	}

	public int getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(int codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}

	public String getNitEmpresa() {
		return nitEmpresa;
	}

	public void setNitEmpresa(String nitEmpresa) {
		this.nitEmpresa = nitEmpresa;
	}

	public String getRazonSocialEmpresa() {
		return razonSocialEmpresa;
	}

	public void setRazonSocialEmpresa(String razonSocialEmpresa) {
		this.razonSocialEmpresa = razonSocialEmpresa;
	}

	public String getMisionEmpresa() {
		return misionEmpresa;
	}

	public void setMisionEmpresa(String misionEmpresa) {
		this.misionEmpresa = misionEmpresa;
	}

	public String getVisionEmpresa() {
		return visionEmpresa;
	}

	public void setVisionEmpresa(String visionEmpresa) {
		this.visionEmpresa = visionEmpresa;
	}
}
