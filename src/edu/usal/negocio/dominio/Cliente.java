package edu.usal.negocio.dominio;

import java.util.Calendar;

public class Cliente {

	private String Nombre;
	private String Apellido;
	private String DNI;
	private Pasaporte pasaporte;
	private String CUIT_CUIL;
	private Calendar FechaDeNacimiento;
	private String Email;
	private Telefono telefono;
	private PasajeroFrecuente pasajerofrecuente;
	private Direccion direccion;
	
	public Cliente() {}
	
	public Cliente(String nombre, String apellido, String dNI, Pasaporte pasaporte, String cUIT_CUIL,
			Calendar fechaDeNacimiento, String email, Telefono telefono, PasajeroFrecuente pasajerofrecuente,
			Direccion direccion) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		DNI = dNI;
		this.pasaporte = pasaporte;
		CUIT_CUIL = cUIT_CUIL;
		FechaDeNacimiento = fechaDeNacimiento;
		Email = email;
		this.telefono = telefono;
		this.pasajerofrecuente = pasajerofrecuente;
		this.direccion = direccion;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public Pasaporte getPasaporte() {
		return pasaporte;
	}
	public void setPasaporte(Pasaporte pasaporte) {
		this.pasaporte = pasaporte;
	}
	public String getCUIT_CUIL() {
		return CUIT_CUIL;
	}
	public void setCUIT_CUIL(String cUIT_CUIL) {
		CUIT_CUIL = cUIT_CUIL;
	}
	public Calendar getFechaDeNacimiento() {
		return FechaDeNacimiento;
	}
	public void setFechaDeNacimiento(Calendar fechaDeNacimiento) {
		FechaDeNacimiento = fechaDeNacimiento;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public Telefono getTelefono() {
		return telefono;
	}
	public void setTelefono(Telefono telefono) {
		this.telefono = telefono;
	}
	public PasajeroFrecuente getPasajerofrecuente() {
		return pasajerofrecuente;
	}
	public void setPasajerofrecuente(PasajeroFrecuente pasajerofrecuente) {
		this.pasajerofrecuente = pasajerofrecuente;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
}
