package edu.usal.negocio.dominio;

import java.awt.List;

public class PasajeroFrecuente {
	
	private List Alianza;
	private LineaAerea Aerolinea;
	private String Numero;
	private String Categoria;
	
	public PasajeroFrecuente() {}
	
	public PasajeroFrecuente(List alianza, LineaAerea aerolinea, String numero, String categoria) {
		super();
		Alianza = alianza;
		Aerolinea = aerolinea;
		Numero = numero;
		Categoria = categoria;
	}
	public List getAlianza() {
		return Alianza;
	}
	public void setAlianza(List alianza) {
		Alianza = alianza;
	}
	public LineaAerea getAerolinea() {
		return Aerolinea;
	}
	public void setAerolinea(LineaAerea aerolinea2) {
		Aerolinea = aerolinea2;
	}
	public String getNumero() {
		return Numero;
	}
	public void setNumero(String numero) {
		Numero = numero;
	}
	public String getCategoria() {
		return Categoria;
	}
	public void setCategoria(String categoria) {
		Categoria = categoria;
	}

}
