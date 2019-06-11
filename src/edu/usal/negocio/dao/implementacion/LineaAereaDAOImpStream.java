package edu.usal.negocio.dao.implementacion;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
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
	public List<LineaAerea> obtenerLineaAereas()
	{
		List<LineaAerea> aerolineas = new ArrayList<LineaAerea>();
		try
		{
			FileInputStream fis = new FileInputStream(new File(PropertiesUtil.obtenerPathAerolineasStream()));
			ObjectInputStream ois = new ObjectInputStream(fis);
			try
			{
				while(true)
				{
					aerolineas.add((LineaAerea)ois.readObject());
				}
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

	public void grabarAerolineas(List<LineaAerea> aerolineas)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(new File(PropertiesUtil.obtenerPathAerolineasStream()));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (LineaAerea aerolinea : aerolineas)
			{
				oos.writeObject(aerolinea);
			}
			oos.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
