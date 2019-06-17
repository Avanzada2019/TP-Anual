package edu.usal.negocio.dao.factory;

import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dao.implementacion.VueloDAOImpStream;
import edu.usal.negocio.dao.implementacion.VueloDAOImpString;

public class VuelosDAOFactory {

	public static VueloDAO obtenerVueloDAO(String tipo)
	{
		if("String".equals(tipo))
			return new VueloDAOImpString();
		if("Stream".equals(tipo))
			return new VueloDAOImpStream();
		return null;
	}
	
	
	
}