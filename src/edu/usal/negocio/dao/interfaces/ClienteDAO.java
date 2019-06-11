package edu.usal.negocio.dao.interfaces;

import java.util.List;

import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.LineaAerea;

public interface ClienteDAO {

	
	public List<LineaAerea> obtenerCliente();
	public void grabarCliente(List<Cliente> Cliente);
	public void borrarCliente(List<Cliente> Cliente);
	
}
