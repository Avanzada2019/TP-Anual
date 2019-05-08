package edu.usal.negocio.dominio;

import java.awt.List;

public class Aeropuerto {

	private String IDAeropuerto;
	private String Ciudad;
	private Provincia provincia;
	private Pais pais;
	
	
	public Aeropuerto() {}
	
	public Aeropuerto(String iDAeropuerto, String ciudad, Provincia provincia, Pais pais) {
		super();
		IDAeropuerto = iDAeropuerto;
		Ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
	}
	public String getIDAeropuerto() {
		return IDAeropuerto;
	}
	public void setIDAeropuerto(String iDAeropuerto) {
		IDAeropuerto = iDAeropuerto;
	}
	public String getCiudad() {
		return Ciudad;
	}
	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
}
