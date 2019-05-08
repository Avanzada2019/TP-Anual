package edu.usal.negocio.dominio;

import java.awt.List;

public class Direccion {
	
	private String Calle;
	private String Altura;
	private String Ciudad;
	private List Provincia;
	private List Pais;
	private String CodigoPostal;
	
	public Direccion() {}
	public Direccion(String calle, String altura, String ciudad, List provincia, List pais, String codigoPostal) {
		super();
		Calle = calle;
		Altura = altura;
		Ciudad = ciudad;
		Provincia = provincia;
		Pais = pais;
		CodigoPostal = codigoPostal;
	}
	public String getCalle() {
		return Calle;
	}
	public void setCalle(String calle) {
		Calle = calle;
	}
	public String getAltura() {
		return Altura;
	}
	public void setAltura(String altura) {
		Altura = altura;
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
	public String getCodigoPostal() {
		return CodigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		CodigoPostal = codigoPostal;
	}

}
