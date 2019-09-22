package edu.usal.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.negocio.dominio.LineaAerea;

public interface LineaAereaDAO
{
    public List<LineaAerea> obtenerLineaAerea();  // Carga las lineas aereas en memoria desde un archivo
	
	public void altaLineaAerea(LineaAerea AltalineaAerea) throws FileNotFoundException, IOException;
	
	public void modificarLineaAerea(LineaAerea ModificarlineaAerea) throws FileNotFoundException, IOException;
		
	public void bajaLineaAerea(LineaAerea BajarLineaAerea) throws FileNotFoundException, IOException;
	
	
}
