package edu.usal.negocio.dominio;

public class Pais {

	private int idPais;
	private String nombre;
	
	public Pais() {}
	
	public Pais(String id, String nombre) {
		this.idPais = idPais;
		this.nombre = nombre;
	}

	public int getId() {
		return idPais;
	}

	public void setId(int idPais) {
		this.idPais = idPais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
