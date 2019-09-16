package edu.usal.negocio.dominio;

import java.awt.List;

public class LineaAerea {

	private String NombreAerolinea;
	private Alianza alianza;
	private Vuelo vuelos;
	private String codigo; 
	
	public LineaAerea() {}
	
	public LineaAerea(String nombreAerolinea, Alianza alianza, Vuelo vuelos, String codigo) {
		super();
		NombreAerolinea = nombreAerolinea;
		this.alianza = alianza;
		this.vuelos = vuelos;
		this.codigo = codigo;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombreAerolinea() {
		return NombreAerolinea;
	}
	public void setNombreAerolinea(String nombreAerolinea) {
		NombreAerolinea = nombreAerolinea;
	}
	public Alianza getAlianza() {
		return alianza;
	}
	public void setAlianza(Alianza alianza) {
		this.alianza = alianza;
	}
	public Vuelo getVuelos() {
		return vuelos;
	}
	public void setVuelos(Vuelo vuelos) {
		this.vuelos = vuelos;
	}
	
}
