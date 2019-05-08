package edu.usal.negocio.dominio;

import java.util.Calendar;

public class Venta {
	
	private Cliente cliente;
	private Vuelo vuelo;
	private LineaAerea Aerolinea;
	private Calendar FechaVenta;
	private String FormaPago;
	
	public Venta() {}
	
	public Venta(Cliente cliente, Vuelo vuelo, LineaAerea aerolinea, Calendar fechaVenta, String formaPago) {
		super();
		this.cliente = cliente;
		this.vuelo = vuelo;
		Aerolinea = aerolinea;
		FechaVenta = fechaVenta;
		FormaPago = formaPago;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Vuelo getVuelo() {
		return vuelo;
	}
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	public LineaAerea getAerolinea() {
		return Aerolinea;
	}
	public void setAerolinea(LineaAerea aerolinea) {
		Aerolinea = aerolinea;
	}
	public Calendar getFechaVenta() {
		return FechaVenta;
	}
	public void setFechaVenta(Calendar fechaVenta) {
		FechaVenta = fechaVenta;
	}
	public String getFormaPago() {
		return FormaPago;
	}
	public void setFormaPago(String formaPago) {
		FormaPago = formaPago;
	}

}
