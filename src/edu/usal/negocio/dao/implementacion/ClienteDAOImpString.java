package edu.usal.negocio.dao.implementacion;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dominio.Alianza;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.util.PropertiesUtil;

public class ClienteDAOImpString implements ClienteDAO {

	public List<Cliente> ObtenerCliente(){
	   List<Cliente> cliente = new ArrayList<Cliente>();
	   String lineaActual = null;
	   
			try
			{
				File file = new File(PropertiesUtil.obtenerPathCliente());
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
	
	
	
	
}
