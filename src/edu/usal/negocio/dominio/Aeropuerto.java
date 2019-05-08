package edu.usal.negocio.dominio;

import java.awt.List;

public class Aeropuerto {

	private String IDAeropuerto;
	private String Ciudad;
	private List Provincia;
	private List Pais;
	
	
	public Aeropuerto() {}
	
	public Aeropuerto(String iDAeropuerto, String ciudad, List provincia, List pais) {
		super();
		IDAeropuerto = iDAeropuerto;
		Ciudad = ciudad;
		Provincia = provincia;
		Pais = pais;
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
	public List getProvincia() {
		return Provincia;
	}
	public void setProvincia(List provincia) {
		Provincia = provincia;
	}
	public List getPais() {
		return Pais;
	}
	public void setPais(List pais) {
		Pais = pais;
	}
}
