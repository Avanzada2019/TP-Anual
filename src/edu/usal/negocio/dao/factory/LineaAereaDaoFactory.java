package edu.usal.negocio.dao.factory;

import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dao.implementacion.LineaAereaDAOImpStream;
import edu.usal.negocio.dao.implementacion.LineaAereaDAOImpString;

public class LineaAereaDaoFactory {

	public static LineaAereaDAO obtenerrAerolineaDAO(String tipo)
	{
		if("String".equals(tipo))
			return new LineaAereaDAOImpString();
		if("Stream".equals(tipo))
			return new LineaAereaDAOImpStream();
		return null;
	}
	
	
	
}
