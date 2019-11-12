package edu.usal.negocio.dao.implementacion;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.util.PropertiesUtil;

public class ClienteDAOImpStream implements ClienteDAO {

	
	@Override
	public List<Cliente> obtenerClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try
		{
			FileInputStream fis = new FileInputStream(new File(PropertiesUtil.obtenerPathClienteStream()));
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			try
			{
				clientes = (List<Cliente>) ois.readObject();	
			} 
			catch (EOFException e) { }
			ois.close();
		}
		catch (EOFException e) { }
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return clientes;
	} 
	
	



	//
	@Override
	public void registrarCliente(Cliente registrarCliente) throws IOException {
		List <Cliente> listadoClientes = new ArrayList<Cliente>();
		
		try
		{
			FileInputStream archivoDeEntrada = new FileInputStream(PropertiesUtil.obtenerPathClienteStream());
			ObjectInputStream oArchivoDeEntrada = new ObjectInputStream(archivoDeEntrada);
			
			listadoClientes = (List <Cliente>) oArchivoDeEntrada.readObject();
			listadoClientes = (List <Cliente>) oArchivoDeEntrada.readObject();
			oArchivoDeEntrada.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}			
				
		FileOutputStream ArchivoDeSalida =  new FileOutputStream(PropertiesUtil.obtenerPathClienteStream());
		ObjectOutputStream oArchivoDeSalida = new ObjectOutputStream(ArchivoDeSalida);
		
		listadoClientes.add(registrarCliente);
        
		oArchivoDeSalida.writeObject(listadoClientes);
		oArchivoDeSalida.close();
		
	}
	
	@Override
	public void modificarCliente(Cliente modificarCliente) throws IOException {
		List <Cliente> listado = obtenerCliente();
		
		for(Cliente cl : listado)
		{
			
			if (cl.getDNI().equals(modificarCliente.getDNI()))
			{
				cl.setDNI(modificarCliente.getDNI());
				cl.setTelefono(modificarCliente.getTelefono());
			}
		}
		
		FileOutputStream ArchivoDeSalida = new FileOutputStream(PropertiesUtil.obtenerPathClienteStream());
		ObjectOutputStream oArchivoDeSalida = new ObjectOutputStream(ArchivoDeSalida);
		
		oArchivoDeSalida.writeObject(listado);
		oArchivoDeSalida.close(); 

	}


	@Override
	public void eliminarCliente(Cliente eliminarCliente) throws IOException {
			List <Cliente> listado = obtenerCliente();
			listado.removeIf(p -> p.getDNI().equals(eliminarCliente.getDNI()));
			
			FileOutputStream archStrSalida =  new FileOutputStream(PropertiesUtil.obtenerPathClienteStream());
			ObjectOutputStream ObjetoArchStrSalida = new ObjectOutputStream(archStrSalida);
	
			ObjetoArchStrSalida.writeObject(listado);
			ObjetoArchStrSalida.close();
			
	}
	
}

