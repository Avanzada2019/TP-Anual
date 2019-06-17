package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.negocio.dominio.Venta;

public interface VentaDAO {

	public List<Venta> obtenerVenta();  // Carga las ventas en memoria desde un archivo
		
	public void altaVenta(Venta AltaVenta) throws FileNotFoundException, IOException;
		
	public void modificarVenta(Venta ModificarVenta) throws FileNotFoundException, IOException;
			
	public void bajaVenta(Venta BajarVenta) throws FileNotFoundException, IOException;
		
}
