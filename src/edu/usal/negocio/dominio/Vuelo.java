package edu.usal.negocio.dominio;

import java.awt.List;
import java.util.Calendar;

public class Vuelo {

	private long NumeroVuelo;
	private int CantidadAsientos;
	private Aeropuerto AeropuertoSalida;
	private Aeropuerto AeropuertoLlegada;
	private Calendar FechaSalida;
	private Calendar FechaLlegada;
	private String TiempoVuelo;
	
	public Vuelo() {}
	
	public Vuelo(List numeroVuelo, int cantidadAsientos, Aeropuerto aeropuertoSalida, Aeropuerto aeropuertoLlegada,
			Calendar fechaSalida, Calendar fechaLlegada, String tiempoVuelo) {
		super();
		NumeroVuelo = numeroVuelo;
		CantidadAsientos = cantidadAsientos;
		AeropuertoSalida = aeropuertoSalida;
		AeropuertoLlegada = aeropuertoLlegada;
		FechaSalida = fechaSalida;
		FechaLlegada = fechaLlegada;
		TiempoVuelo = tiempoVuelo;
	}
	public List getNumeroVuelo() {
		return NumeroVuelo;
	}
	public void setNumeroVuelo(List numeroVuelo) {
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
	public Calendar getFechaSalida() {
		return FechaSalida;
	}
	public void setFechaSalida(Calendar fechaSalida) {
		FechaSalida = fechaSalida;
	}
	public Calendar getFechaLlegada() {
		return FechaLlegada;
	}
	public void setFechaLlegada(Calendar fechaLlegada) {
		FechaLlegada = fechaLlegada;
	}
	public String getTiempoVuelo() {
		return TiempoVuelo;
	}
	public void setTiempoVuelo(String tiempoVuelo) {
		TiempoVuelo = tiempoVuelo;
	}
	
}
