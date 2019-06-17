package edu.usal.negocio.dao.factory;

import edu.usal.negocio.dao.implementacion.VentasDAOImpStream;
import edu.usal.negocio.dao.interfaces.VentaDAO;

public class VentasDAOFactory {
	public static VentaDAO obtenerVentaDAO(String tipo)
	{
		if("String".equals(tipo))
			return new VentasDAOImpStream();
		return null;
	}
}