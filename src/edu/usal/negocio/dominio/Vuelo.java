package edu.usal.negocio.dominio;

import java.awt.List;
import java.util.Date;

public class Vuelo {

	private String NumeroVuelo;
	private int CantidadAsientos;
	private Aeropuerto AeropuertoSalida;
	private Aeropuerto AeropuertoLlegada;
	private Date FechaSalida;
	private Date FechaLlegada;
	private String TiempoVuelo;
	
	public Vuelo() {}
	
	public Vuelo(String numeroVuelo, int cantidadAsientos, Aeropuerto aeropuertoSalida, Aeropuerto aeropuertoLlegada,
			Date fechaSalida, Date fechaLlegada, String tiempoVuelo) {
		super();
		NumeroVuelo = numeroVuelo;
		CantidadAsientos = cantidadAsientos;
		AeropuertoSalida = aeropuertoSalida;
		AeropuertoLlegada = aeropuertoLlegada;
		FechaSalida = fechaSalida;
		FechaLlegada = fechaLlegada;
		TiempoVuelo = tiempoVuelo;
	}
	public String getNumeroVuelo() {
		return NumeroVuelo;
	}
	public void setNumeroVuelo(String numeroVuelo) {
		NumeroVuelo = numeroVuelo;
	}
	public int getCantidadAsientos() {
		return CantidadAsientos;
	}
	public void setCantidadAsientos(int cantidadAsientos) {
		CantidadAsientos = cantidadAsientos;
	}
	public Aeropuerto getAeropuertoSalida() {
		return AeropuertoSalida;
	}
	public void setAeropuertoSalida(Aeropuerto aeropuertoSalida) {
		AeropuertoSalida = aeropuertoSalida;
	}
	public Aeropuerto getAeropuertoLlegada() {
		return AeropuertoLlegada;
	}
	public void setAeropuertoLlegada(Aeropuerto aeropuertoLlegada) {
		AeropuertoLlegada = aeropuertoLlegada;
	}
	public Date getFechaSalida() {
		return FechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		FechaSalida = fechaSalida;
	}
	public Date getFechaLlegada() {
		return FechaLlegada;
	}
	public void setFechaLlegada(Date fechaLlegada) {
		FechaLlegada = fechaLlegada;
	}
	public String getTiempoVuelo() {
		return TiempoVuelo;
	}
	public void setTiempoVuelo(String tiempoVuelo) {
		TiempoVuelo = tiempoVuelo;
	}
	
}
