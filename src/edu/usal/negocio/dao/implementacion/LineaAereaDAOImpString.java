package edu.usal.negocio.dao.implementacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dominio.Alianza;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.util.PropertiesUtil;

public class LineaAereaDAOImpString implements LineaAereaDAO{

	
	@Override
	public List<LineaAerea> obtenerLineaAerea()
	{
		List<LineaAerea> aerolineas = new ArrayList<LineaAerea>();
		try
		{
			File file = new File(PropertiesUtil.obtenerPathAerolineasString());
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine())
			{
				aerolineas.add(stringToAerolinea(scanner.nextLine()));
			}
			scanner.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return aerolineas;
	}
	
	private LineaAerea stringToAerolinea(String strAerolinea)
	{
		String[] datosAerolinea = strAerolinea.split(";");
		LineaAerea aerolinea = new LineaAerea();
		aerolinea.setNombreAerolinea(datosAerolinea[0]);
		Alianza alianza = new Alianza();
		alianza.setNombre(datosAerolinea[1]);
		//aerolinea.setAlianza(alianza);
		return aerolinea;
	}

	
	public void modificarLineaAerea(List<LineaAerea> LineaAerea) {
		
		
	}
	
	
	public void grabarLineaAerea(List<LineaAerea> aerolineas)
	{
		// TODO Auto-generated method stub
		
	}
	
	public void bajaLineaAerea(List<LineaAerea> LineaAerea) {
		
		
	}
	
	public void altaLineaAerea(List<LineaAerea> LineaAerea) {
		
	}

	@Override
	public void altaLineaAerea(LineaAerea AltalineaAerea) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarLineaAerea(LineaAerea ModificarlineaAerea) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bajaLineaAerea(LineaAerea BajarLineaAerea) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
	}
	
}
