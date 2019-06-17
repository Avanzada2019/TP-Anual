package edu.usal.negocio.dao.factory;

import java.util.stream.Stream;

import edu.usal.negocio.dao.implementacion.VentasDAOImpStream;
import edu.usal.negocio.dao.interfaces.VentaDAO;

public class VentasDAOFactory {
	public static VentaDAO obtenerVentaDAO(Stream tipo)
	{
		if("Stream".equals(tipo))
			return new VentasDAOImpStream();
		return null;
	}
}