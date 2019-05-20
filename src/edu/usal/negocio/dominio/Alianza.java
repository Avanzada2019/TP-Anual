package edu.usal.negocio.dominio;

import java.io.Serializable;

public class Alianza implements Serializable
{
	private static final long serialVersionUID = -6643822876411954237L;
	private String nombre;
	
	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
}
