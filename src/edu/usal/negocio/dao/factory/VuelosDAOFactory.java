package edu.usal.negocio.dao.factory;

import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dao.implementacion.VueloDAOImpStream;

public class VuelosDAOFactory {

	public static VueloDAO obtenerVueloDAO(String tipo)
	{
		if("Stream".equals(tipo))
			return new VueloDAOImpStream();
		return null;
	}
	
	
	
}