package edu.usal.negocio.dominio;

import java.awt.List;

public class LineaAerea {

	private String NombreAerolinea;
	private List Alianza;
	private Vuelo vuelos;
	
	public LineaAerea() {}
	
	public LineaAerea(String nombreAerolinea, List alianza, Vuelo vuelos) {
		super();
		NombreAerolinea = nombreAerolinea;
		Alianza = alianza;
		this.vuelos = vuelos;
	}
	public String getNombreAerolinea() {
		return NombreAerolinea;
	}
	public void setNombreAerolinea(String nombreAerolinea) {
		NombreAerolinea = nombreAerolinea;
	}
	public List getAlianza() {
		return Alianza;
	}
	public void setAlianza(List alianza) {
		Alianza = alianza;
	}
	public Vuelo getVuelos() {
		return vuelos;
	}
	public void setVuelos(Vuelo vuelos) {
		this.vuelos = vuelos;
	}
	
}
