package edu.usal.negocio.dominio;

import java.util.Date;

public class Pasaporte {
	
	private int idPasaporte;
	private String NumeroPasaporte;
	private Pais PaisEmision;
	private String AutoridadEmision;
	private Date FechaEmision;
	private Date FechaVencimiento;

	public Pasaporte() {}
	
	public Pasaporte(int idPasaporte, String numeroPasaporte, Pais paisEmision, String autoridadEmision, Date fechaEmision,
			Date fechaVencimiento) {
		super();
		this.idPasaporte = idPasaporte;
		NumeroPasaporte = numeroPasaporte;
		PaisEmision = paisEmision;
		AutoridadEmision = autoridadEmision;
		FechaEmision = fechaEmision;
		FechaVencimiento = fechaVencimiento;
	}
	
	public int getId_pasaporte() {
		return idPasaporte;
	}

	public void setId_pasaporte(int idPasaporte) {
		this.idPasaporte = idPasaporte;
	}

	public String getNumeroPasaporte() {
		return NumeroPasaporte;
	}
	public void setNumeroPasaporte(String numeroPasaporte) {
		NumeroPasaporte = numeroPasaporte;
	}
	public Pais getPaisEmision() {
		return PaisEmision;
	}
	public void setPaisEmision(Pais paisEmision) {
		PaisEmision = paisEmision;
	}
	public String getAutoridadEmision() {
		return AutoridadEmision;
	}
	public void setAutoridadEmision(String autoridadEmision) {
		AutoridadEmision = autoridadEmision;
	}
	public Date getFechaEmision() {
		return FechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		FechaEmision = fechaEmision;
	}
	public Date getFechaVencimiento() {
		return FechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		FechaVencimiento = fechaVencimiento;
	}

}
