package edu.usal.negocio.dominio;

import java.awt.List;

public class Direccion {
	
	private int idDireccion;
	private String Calle;
	private String Altura;
	private String Ciudad;
	private Provincia provincia;
	private Pais pais;
	private String CodigoPostal;
	
	public Direccion() {}
	public Direccion(int idDireccion, String calle, String altura, String ciudad, Provincia provincia, Pais pais, String codigoPostal) {
		super();
		this.idDireccion = idDireccion;
		Calle = calle;
		Altura = altura;
		Ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
		CodigoPostal = codigoPostal;
	}
	
	public int getId_direccion() {
		return idDireccion;
	}
	public void setId_direccion(int idDireccion) {
		this.idDireccion = idDireccion;
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
	public String getCodigoPostal() {
		return CodigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		CodigoPostal = codigoPostal;
	}

}
