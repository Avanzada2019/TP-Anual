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
import java.util.Calendar;
import java.util.List;

import edu.usal.negocio.dao.interfaces.VentaDAO;
import edu.usal.negocio.dominio.Venta;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.util.PropertiesUtil;

public class VentasDAOImpStream implements VentaDAO {
 
	@Override
	public List<Venta> obtenerVenta() {
		List<Venta> ventas = new ArrayList<Venta>();
		try
		{
			FileInputStream fis = new FileInputStream(new File(PropertiesUtil.obtenerPathVentasStream()));
			ObjectInputStream ois = new ObjectInputStream(fis);
			  
			try
			{
					ventas = (List<Venta>) ois.readObject();	
			} 
			catch (EOFException e) { }
			ois.close();
		}
		catch (EOFException e) { }
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return ventas;
	}

	@Override
	public void altaVenta(Venta AltaVenta) throws FileNotFoundException, IOException {
		
		List <Venta> listadoVenta = new ArrayList<Venta>();
				
		try
		{
			FileInputStream archivoDeEntrada = new FileInputStream(PropertiesUtil.obtenerPathVentasStream());
			ObjectInputStream oArchivoDeEntrada = new ObjectInputStream(archivoDeEntrada);
					
			listadoVenta = (List <Venta>) oArchivoDeEntrada.readObject();
				
					
			listadoVenta = (List <Venta>) oArchivoDeEntrada.readObject();
			oArchivoDeEntrada.close();
					
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}			
						
		FileOutputStream ArchivoDeSalida =  new FileOutputStream(PropertiesUtil.obtenerPathVentasStream());
		ObjectOutputStream oArchivoDeSalida = new ObjectOutputStream(ArchivoDeSalida);
				
		listadoVenta.add(AltaVenta);
		        
		oArchivoDeSalida.writeObject(listadoVenta);
		oArchivoDeSalida.close();

	}

	@Override
	public void modificarVenta(Venta ModificarVenta) throws FileNotFoundException, IOException {
		
		List <Venta> listadoVenta = obtenerVenta();
		
			for(Venta v : listadoVenta)
			{	
	//		if v.getidVenta().equals(ModificarVenta.getidVenta());
				if (String.valueOf(v.getidVenta()).equals(String.valueOf(ModificarVenta.getidVenta())))

				{
					v.setVuelo(ModificarVenta.getVuelo());
				}
			}
		
			FileOutputStream ArchivoDeSalida = new FileOutputStream(PropertiesUtil.obtenerPathVentasStream());
			ObjectOutputStream oArchivoDeSalida = new ObjectOutputStream(ArchivoDeSalida);
		
			oArchivoDeSalida.writeObject(listadoVenta);
			oArchivoDeSalida.close(); 
		
	}

	@Override
	public void bajaVenta(Venta BajarVenta) throws FileNotFoundException, IOException {
		
		List <Venta> listadoVenta = obtenerVenta(); 	
		listadoVenta.removeIf(v -> (String.valueOf(v.getidVenta()).equals(String.valueOf(BajarVenta.getidVenta()))));

		FileOutputStream ArchivoDeSalida = new FileOutputStream(PropertiesUtil.obtenerPathVentasStream());
		ObjectOutputStream oArchivoDeSalida = new ObjectOutputStream(ArchivoDeSalida);
				
		oArchivoDeSalida.writeObject(listadoVenta);
		oArchivoDeSalida.close(); 
	}

	
}
