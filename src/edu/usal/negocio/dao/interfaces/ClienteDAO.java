package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
//
import edu.usal.negocio.dominio.Cliente;

public interface ClienteDAO {

	//public List<Cliente> obtenerClientes();
	public Cliente obtenerCliente();
	public List<Cliente> obtenerClientes() throws SQLException;

	public void registrarCliente(Cliente registrarCliente)throws FileNotFoundException, IOException;
	public void modificarCliente(Cliente modificarCliente)throws FileNotFoundException, IOException;
	public void eliminarCliente(Cliente eliminarCliente)throws FileNotFoundException, IOException;
	
}
