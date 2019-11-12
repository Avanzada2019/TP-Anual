package edu.usal.negocio.dominio;

public class Telefono {
	
	private int idTelefono;
	private String NumeroPersonal;
	private String NumeroCelular;
	private String NumeroLaboral;
	
	public Telefono() {}
	
	public Telefono(int idTelefono, String numeroPersonal, String numeroCelular, String numeroLaboral) {
		super();
		this.idTelefono = idTelefono;
		NumeroPersonal = numeroPersonal;
		NumeroCelular = numeroCelular;
		NumeroLaboral = numeroLaboral;
	}
	
	public int getId_telefono() {
		return idTelefono;
	}

	public void setId_telefono(int idTelefono) {
		this.idTelefono = idTelefono;
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
