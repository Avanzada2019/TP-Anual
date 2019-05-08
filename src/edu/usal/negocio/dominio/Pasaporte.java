package edu.usal.negocio.dominio;

import java.util.Calendar;

public class Pasaporte {
	
	private String NumeroPasaporte;
	private String PaisEmision;
	private String AutoridadEmision;
	private Calendar FechaEmision;
	private Calendar FechaVencimiento;
	
	public Pasaporte() {}
	
	public Pasaporte(String numeroPasaporte, String paisEmision, String autoridadEmision, Calendar fechaEmision,
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
	public String getPaisEmision() {
		return PaisEmision;
	}
	public void setPaisEmision(String paisEmision) {
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

}
