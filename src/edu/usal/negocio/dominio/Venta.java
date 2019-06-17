package edu.usal.negocio.dominio;

import java.util.Calendar;
 
public class Venta {
	//Creado borrador: necesitamos un id que se cree automáticamente
	private String idVenta;
	//
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
	// GET Y SET DE idVenta
	public String getidVenta() {
		return idVenta;
	}
	public void setidVenta(String idVenta) {
		this.idVenta = idVenta;
	}
	//
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
