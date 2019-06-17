package edu.usal.negocio.dao.implementacion;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.util.PropertiesUtil;

public class VueloDAOImpStream implements VueloDAO {

	@Override
	public List<Vuelo> obtenerVuelo() {

		List<Vuelo> Vuelo = new ArrayList<Vuelo>();
		try
		{
			FileInputStream fis = new FileInputStream(new File(PropertiesUtil.obtenerPathVueloStream()));
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			try
			{
				Vuelo = (List<Vuelo>) ois.readObject();	
			} 
			catch (EOFException e) { }
			ois.close();
		}
		catch (EOFException e) { }
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return Vuelo;
	}
	
	//Fin Listar Vuelo

	@Override
	public void altaVuelo(Vuelo AltaVuelo) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarVuelo(Vuelo ModificarVuelo) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void bajaVuelo(Vuelo BajarVuelo) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub

	}
		
}
