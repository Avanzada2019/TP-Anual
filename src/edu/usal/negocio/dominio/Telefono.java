package edu.usal.negocio.dominio;

public class Telefono {
	
	private String NumeroPersonal;
	private String NumeroCelular;
	private String NumeroLaboral;
	
	public Telefono() {}
	
	public Telefono(String numeroPersonal, String numeroCelular, String numeroLaboral) {
		super();
		NumeroPersonal = numeroPersonal;
		NumeroCelular = numeroCelular;
		NumeroLaboral = numeroLaboral;
	}
	public String getNumeroPersonal() {
		return NumeroPersonal;
	}
	public void setNumeroPersonal(String numeroPersonal) {
		NumeroPersonal = numeroPersonal;
	}
	public String getNumeroCelular() {
		return NumeroCelular;
	}
	public void setNumeroCelular(String numeroCelular) {
		NumeroCelular = numeroCelular;
	}
	public String getNumeroLaboral() {
		return NumeroLaboral;
	}
	public void setNumeroLaboral(String numeroLaboral) {
		NumeroLaboral = numeroLaboral;
	}
	
}
