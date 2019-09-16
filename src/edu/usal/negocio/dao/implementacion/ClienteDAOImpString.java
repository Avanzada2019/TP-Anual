package edu.usal.negocio.dao.implementacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.util.PropertiesUtil;

public class ClienteDAOImpString implements ClienteDAO {

	public List<Cliente> ObtenerClientes(){
	   List<Cliente> cliente = new ArrayList<Cliente>();
	   String lineaActual = null;
	   
			try
			{
				File file = new File(PropertiesUtil.obtenerPathClienteStream());
				Scanner archivoEntrada = new Scanner(file);
				while(archivoEntrada.hasNextLine())
				{
					Cliente oCliente = new Cliente();
					lineaActual = archivoEntrada.nextLine();
					String linea[] =  lineaActual.split(";");
					oCliente.setNombre(linea[0]);
					
					cliente.add(oCliente);
				}
				archivoEntrada.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return cliente;
	}
		
	
	public void grabarCliente(List<Cliente> Cliente) {
		
		
	}
	
	public void borrarCliente(List<Cliente> Cliente) {
		
	}


	@Override
	public List<Cliente> obtenerClientes() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Cliente obtenerCliente() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void registrarCliente(Cliente registrarCliente) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void modificarCliente(Cliente modificarCliente) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void eliminarCliente(Cliente eliminarCliente) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
