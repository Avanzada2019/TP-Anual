package edu.usal.negocio.dao.factory;

import edu.usal.negocio.dao.implementacion.ClienteDAOImpDB;
import edu.usal.negocio.dao.interfaces.ClienteDAO;

public class ClienteDAOFactoryDB {
	
	public static ClienteDAO obtenerClienteDAO(String tipo)
	{
		if("DataBase".equals(tipo)){
			return new ClienteDAOImpDB();
		}
		return null;
	}
}