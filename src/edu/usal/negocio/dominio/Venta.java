package edu.usal.negocio.dominio;

import java.util.Date;
 
public class Venta {
	//Creado borrador: necesitamos un id que se cree automáticamente
	private long idVenta;
	//
	private Cliente cliente;
	private Vuelo vuelo;
	private LineaAerea Aerolinea;
	private Date FechaVenta;
	private String FormaPago;
	 
	public Venta() {}
	
	public Venta(long idVenta, Cliente cliente, Vuelo vuelo, LineaAerea aerolinea, Date fechaVenta, String formaPago) {
		super();
		idVenta = idVenta;
		this.cliente = cliente;
		this.vuelo = vuelo;
		Aerolinea = aerolinea;
		FechaVenta = fechaVenta;
		FormaPago = formaPago;
	}
	// GET Y SET DE idVenta
	public long getidVenta() {
		return idVenta;
	}
	public void setidVenta(long idVenta) {
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
	public Date getFechaVenta() {
		return FechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		FechaVenta = fechaVenta;
	}
	public String getFormaPago() {
		return FormaPago;
	}
	public void setFormaPago(String formaPago) {
		FormaPago = formaPago;
	}

}
