package edu.usal.negocio.dao.factory;

import edu.usal.negocio.dao.implementacion.ClienteDAOImpString;
import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.implementacion.ClienteDAOImpStream;

public class ClienteDAOFactory {

	public static ClienteDAO obtenerAerolineaDAO(String tipo)
	{
		if("String".equals(tipo))
			return new ClienteDAOImpString();
		if("Stream".equals(tipo))
			return new ClienteDAOImpStream();
		return null;
	}
	
}
