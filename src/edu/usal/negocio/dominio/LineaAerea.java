package edu.usal.negocio.dominio;

import java.awt.List;

public class LineaAerea {
	
	private int idLineaAerea;
	
	private String NombreAerolinea;
	private Alianza alianza;
	private Vuelo vuelos;
	private String codigo; 
	
	public LineaAerea() {}
	
	public LineaAerea(int idLineaAerea, String nombreAerolinea, Alianza alianza, Vuelo vuelos, String codigo) {
		super();
		this.idLineaAerea = idLineaAerea;
		NombreAerolinea = nombreAerolinea;
		this.alianza = alianza;
		this.vuelos = vuelos;
		this.codigo = codigo;
	}
	
	
	
	public int getIdLineaAerea() {
		return idLineaAerea;
	}

	public void setIdLineaAerea(int idLineaAerea) {
		this.idLineaAerea = idLineaAerea;
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
