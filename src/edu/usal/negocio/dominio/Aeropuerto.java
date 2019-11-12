package edu.usal.negocio.dominio;

public class Aeropuerto {

	private int idAeropuerto;
	private String codigoAeropuerto;
	private String Ciudad;
	private Provincia provincia;
	private Pais pais;
	
	
	public Aeropuerto() {}
	
	public Aeropuerto(int idAeropuerto, String codigoAeropuerto, String ciudad, Provincia provincia, Pais pais) {
		super();
		this.idAeropuerto = idAeropuerto;
		this.codigoAeropuerto = codigoAeropuerto;
		Ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
	}
	
	public int getIdAeropuerto() {
		return idAeropuerto;
	}

	public void setIdAeropuerto(int idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
	}
	
	public String getCodigoAeropuerto() {
		return codigoAeropuerto;
	}

	public void setCodigoAeropuerto(String codigoAeropuerto) {
		this.codigoAeropuerto = codigoAeropuerto;
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
}
