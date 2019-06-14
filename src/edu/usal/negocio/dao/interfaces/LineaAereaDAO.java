package edu.usal.negocio.dao.interfaces;

import java.util.List;

import edu.usal.negocio.dominio.LineaAerea;

public interface LineaAereaDAO
{
	public List<LineaAerea> obtenerLineaAerea();  // Carga las lineas aereas en memoria desde un archivo
	public void altaLineaAerea(List<LineaAerea> LineaAerea);
	public void modificarLineaAerea(List<LineaAerea> LineaAerea);
	public void grabarLineaAerea(List<LineaAerea> LineaAerea);
	public void bajaLineaAerea(List<LineaAerea> LineaAerea);
	
	
}
