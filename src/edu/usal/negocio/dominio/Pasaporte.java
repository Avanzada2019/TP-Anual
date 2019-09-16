package edu.usal.negocio.dominio;

import java.util.Calendar;

public class Pasaporte {
	
	private String NumeroPasaporte;
	private Pais PaisEmision;
	private String AutoridadEmision;
	private Calendar FechaEmision= Calendar.getInstance();
	java.util.Date Fechaemision = FechaEmision.getTime();
	private Calendar FechaVencimiento;
	java.util.Date Fechavencimiento = FechaEmision.getTime();
	
	public Pasaporte() {}
	
	public Pasaporte(String numeroPasaporte, Pais paisEmision, String autoridadEmision, Calendar fechaEmision,
			Calendar fechaVencimiento) {
		super();
		NumeroPasaporte = numeroPasaporte;
		PaisEmision = paisEmision;
		AutoridadEmision = autoridadEmision;
		FechaEmision = fechaEmision;
		FechaVencimiento = fechaVencimiento;
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
	public Calendar getFechaEmision() {
		return FechaEmision;
	}
	public void setFechaEmision(Calendar fechaEmision) {
		FechaEmision = fechaEmision;
	}
	public Calendar getFechaVencimiento() {
		return FechaVencimiento;
	}
	public void setFechaVencimiento(Calendar fechaVencimiento) {
		FechaVencimiento = fechaVencimiento;
	}

	public java.util.Date getFechaemision() {
		return Fechaemision;
	}

	public void setFechaemision(java.util.Date fechaemision) {
		Fechaemision = fechaemision;
	}

	public java.util.Date getFechavencimiento() {
		return Fechavencimiento;
	}

	public void setFechavencimiento(java.util.Date fechavencimiento) {
		Fechavencimiento = fechavencimiento;
	}
	
	

}
