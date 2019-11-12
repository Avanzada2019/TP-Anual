package edu.usal.negocio.dominio;


public class PasajeroFrecuente {
	
	private int idPasajeroFrecuente;
	private Alianza Alianza;
	private LineaAerea Aerolinea;
	private String Numero;
	private String Categoria;
	
	public PasajeroFrecuente() {}
	
	public PasajeroFrecuente(int idPasajeroFrecuente, Alianza alianza, LineaAerea aerolinea, String numero, String categoria) {
		super();
		this.idPasajeroFrecuente = idPasajeroFrecuente;
		Alianza = alianza;
		Aerolinea = aerolinea;
		Numero = numero;
		Categoria = categoria;
	}
	
	public int getId_pasajeroFrecuente() {
		return idPasajeroFrecuente;
	}

	public void setId_pasajeroFrecuente(int idPasajeroFrecuente) {
		this.idPasajeroFrecuente = idPasajeroFrecuente;
	}

	public Alianza getAlianza() {
		return Alianza;
	}
	public void setAlianza(Alianza alianza) {
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
