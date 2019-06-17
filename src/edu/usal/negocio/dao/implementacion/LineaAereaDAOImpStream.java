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

import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.util.PropertiesUtil;

public class LineaAereaDAOImpStream implements LineaAereaDAO{


	@Override
	public List<LineaAerea> obtenerLineaAerea(){
	
		List<LineaAerea> aerolineas = new ArrayList<LineaAerea>();
		try
		{
			FileInputStream fis = new FileInputStream(new File(PropertiesUtil.obtenerPathAerolineasStream()));
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			try
			{
					aerolineas = (List<LineaAerea>) ois.readObject();	
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
	} // Cierre de obtenerLineaAerea

	
	@Override
	public void modificarLineaAerea(LineaAerea modificarLineaAerea) throws FileNotFoundException, IOException {
				
		List <LineaAerea> listado = obtenerLineaAerea();
		
		for(LineaAerea la : listado)
		{
			
			if (la.getNombreAerolinea().equals(modificarLineaAerea.getNombreAerolinea()))
			{
				la.setNombreAerolinea(modificarLineaAerea.getNombreAerolinea());
				
				
			}
		}
		
		FileOutputStream ArchivoDeSalida = new FileOutputStream(PropertiesUtil.obtenerPathAerolineasStream());
		ObjectOutputStream oArchivoDeSalida = new ObjectOutputStream(ArchivoDeSalida);
		
		oArchivoDeSalida.writeObject(listado);
		oArchivoDeSalida.close(); 
		
	
	}  // Cierre de modificarLineaAerea
	
	public void bajaLineaAerea(LineaAerea BajarLineaAerea) throws FileNotFoundException, IOException{
		
		List <LineaAerea> listadoLineaAerea = obtenerLineaAerea(); // Cargo la todas las lineas en listadoLineaAerea
		
		listadoLineaAerea.removeIf(p->p.getNombreAerolinea().equals(BajarLineaAerea.getNombreAerolinea()));
		
		FileOutputStream ArchivoDeSalida = new FileOutputStream(PropertiesUtil.obtenerPathAerolineasStream());
		ObjectOutputStream oArchivoDeSalida = new ObjectOutputStream(ArchivoDeSalida);
		
		oArchivoDeSalida.writeObject(listadoLineaAerea);
		oArchivoDeSalida.close();
		
		// oArchivoDeSalida = es el Objeto ArchivoDeSalida
		
	}  // Cierre BajaLineaAerea


	@Override
	public void altaLineaAerea(LineaAerea AltalineaAerea) throws FileNotFoundException, IOException {
		
		List <LineaAerea> listadoLineaAerea = new ArrayList<LineaAerea>();
		
		try
		{
			
			
			FileInputStream archivoDeEntrada = new FileInputStream(PropertiesUtil.obtenerPathAerolineasStream());
			ObjectInputStream oArchivoDeEntrada = new ObjectInputStream(archivoDeEntrada);
			
			listadoLineaAerea = (List <LineaAerea>) oArchivoDeEntrada.readObject();
			oArchivoDeEntrada.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}			
				
		FileOutputStream ArchivoDeSalida =  new FileOutputStream(PropertiesUtil.obtenerPathAerolineasStream());
		ObjectOutputStream oArchivoDeSalida = new ObjectOutputStream(ArchivoDeSalida);
		
		listadoLineaAerea.add(AltalineaAerea);
        
		oArchivoDeSalida.writeObject(listadoLineaAerea);
		oArchivoDeSalida.close();
		
	};  // Cierre altaLineaAerea
	
	
	
	
	
	
}
