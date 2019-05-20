package edu.usal.negocio.dao.interfaces;

import java.util.List;

import edu.usal.negocio.dominio.LineaAerea;

public interface LineaAereaDAO
{
	public List<LineaAerea> obtenerLineaAereas();
	public void grabarAerolineas(List<LineaAerea> LineaAerea);
	
}
