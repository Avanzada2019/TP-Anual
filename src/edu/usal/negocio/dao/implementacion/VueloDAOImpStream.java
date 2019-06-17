package edu.usal.negocio.dao.implementacion;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.util.PropertiesUtil;

public class VueloDAOImpStream implements VueloDAO{

	@Override
	public List<Vuelo> obtenerVuelo(){
	
		List<Vuelo> aerolineas = new ArrayList<Vuelo>();
		try
		{
			FileInputStream fis = new FileInputStream(new File(PropertiesUtil.obtenerPathAerolineasStream()));
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			try
			{
					aerolineas = (List<Vuelo>) ois.readObject();	
			} 
			catch (EOFException e) { }
			ois.close();
		}
		catch (EOFException e) { }
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return aerolineas;
	} 
	// Cierre de obtenerVuelo

	
	@Override
	public void modificarVuelo(Vuelo modificarVuelo) throws FileNotFoundException, IOException {
				
		List <Vuelo> listado = obtenerVuelo();
		
		for(Vuelo la : listado)
		{
			
			if (la.getNombreAerolinea().equals(modificarVuelo.getNombreAerolinea()))
			{
				la.setNombreAerolinea(modificarVuelo.getNombreAerolinea());
				
				
			}
		}
		
		FileOutputStream ArchivoDeSalida = new FileOutputStream(PropertiesUtil.obtenerPathAerolineasStream());
		ObjectOutputStream oArchivoDeSalida = new ObjectOutputStream(ArchivoDeSalida);
		
		oArchivoDeSalida.writeObject(listado);
		oArchivoDeSalida.close(); 
		
	
	}  // Cierre de modificarVuelo
	
public void bajaVuelo(Vuelo BajarVuelo) throws FileNotFoundException, IOException{
		
		List <Vuelo> listadoVuelo = obtenerVuelo(); // Cargo la todas las lineas en listadoVuelo
		
		for (Vuelo l : listadoVuelo) {
		   if (l.getNombreAerolinea().equals(BajarVuelo.getNombreAerolinea())) {
			   
			   l.setNombreAerolinea(BajarVuelo.getNombreAerolinea());
			   l.setAlianza(BajarVuelo.getAlianza());
			   l.setVuelos(BajarVuelo.getVuelos());
		   }
		}
		
		FileOutputStream ArchivoDeSalida = new FileOutputStream(PropertiesUtil.obtenerPathAerolineasStream());
		ObjectOutputStream oArchivoDeSalida = new ObjectOutputStream(ArchivoDeSalida);
		
		oArchivoDeSalida.writeObject(listadoVuelo);
		oArchivoDeSalida.close();
		
		// oArchivoDeSalida = es el Objeto ArchivoDeSalida
		
	}  // Cierre Baja Vuelo


	@Override
	public void altaVuelo(Vuelo AltaVuelo) throws FileNotFoundException, IOException {
		
		List <Vuelo> listadoVuelo = new ArrayList<Vuelo>();
		
		try
		{
			
			
			FileInputStream archivoDeEntrada = new FileInputStream(PropertiesUtil.obtenerPathAerolineasStream());
			ObjectInputStream oArchivoDeEntrada = new ObjectInputStream(archivoDeEntrada);
			
			listadoVuelo = (List <Vuelo>) oArchivoDeEntrada.readObject();
			
			
			listadoVuelo = (List <Vuelo>) oArchivoDeEntrada.readObject();
			oArchivoDeEntrada.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}			
				
		FileOutputStream ArchivoDeSalida =  new FileOutputStream(PropertiesUtil.obtenerPathAerolineasStream());
		ObjectOutputStream oArchivoDeSalida = new ObjectOutputStream(ArchivoDeSalida);
		
		listadoVuelo.add(AltaVuelo);
        
		oArchivoDeSalida.writeObject(listadoVuelo);
		oArchivoDeSalida.close();
		
	};  // Cierre alta Vuelo
	
	
	
	
	
	
}
