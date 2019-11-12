package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import edu.usal.negocio.dominio.Vuelo;

public interface VueloDAO {

//	public List<Vuelo> obtenerVuelo();  // Carga los Vuelos en memoria desde un archivo
		
	public void altaVuelo(Vuelo AltaVuelo) throws FileNotFoundException, IOException;
		
	public void modificarVuelo(Vuelo ModificarVuelo) throws FileNotFoundException, IOException;
			
	public void bajaVuelo(Vuelo BajarVuelo) throws FileNotFoundException, IOException;
		
	public Vuelo obtenerVuelo();
	public List<Vuelo> obtenerVuelos() throws SQLException;
}
