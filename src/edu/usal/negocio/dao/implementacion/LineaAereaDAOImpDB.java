package edu.usal.negocio.dao.implementacion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dominio.Alianza;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.util.PropertiesUtil;

public abstract class LineaAereaDAOImpDB implements LineaAereaDAO 	{

	private static Connection getConnection() throws SQLException {
		
		Connection DBCon = null;
		
		try {
			 Class.forName(PropertiesUtil.getSqlDriver());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		DBCon = DriverManager.getConnection(PropertiesUtil.getSqlPath(), PropertiesUtil.getSqlUser(), PropertiesUtil.getSqlPwd());
		return DBCon;
		
	} // Cierre de getConnection 
	
	public List<LineaAerea> obtenerLineaAerea() {
		
		Connection DBCon = null;
		Statement stm = null;
		ResultSet rsLineaAerea = null;
		PreparedStatement psAlianza = null;
		ResultSet rsAlianza = null;
		
		try {
			
			DBCon = getConnection();
			stm = DBCon.createStatement();
			rsLineaAerea = stm.executeQuery("SELECT * from lineasAereas"); // lineasAereas corresponde con la tabla de la BD aerolinea
			psAlianza = DBCon.prepareStatement("SELECT * from alianza WHERE nombre_alianza =?"); // Esta tabla aun no está en la BD.
			List <LineaAerea> aerolineas = new ArrayList<LineaAerea>();
			
			while (rsLineaAerea.next()) {
				LineaAerea aerolinea = new LineaAerea();
				aerolinea.setNombreAerolinea(rsLineaAerea.getString("nombre"));
				aerolinea.setCodigo(rsLineaAerea.getString("codigo"));
				
				psAlianza.setString(1, rsLineaAerea.getString("Alianza_id"));
				rsAlianza = psAlianza.executeQuery();
				rsAlianza.next();
				
				Alianza alianza = new Alianza();
				alianza.setNombre(rsAlianza.getString("Nombre_Alianza"));
				aerolinea.setAlianza(alianza);
				
				aerolineas.add(aerolinea);
				
			} // cierre del while
			return aerolineas;
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(!stm.isClosed()) {
					stm.close();
				}
				if (!DBCon.isClosed())
					DBCon.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		} // Cierre de finally
		return null;
		
	} // Cierre del método obtenerLineaAerea
	
	
	
	public void altaLineaAerea(LineaAerea lineaaerea) {
		
		Connection DBCon = null;
		PreparedStatement psLineaAerea = null;
		
		try {
			
			DBCon = getConnection();
			psLineaAerea = DBCon.prepareStatement("INSERT INTO LineasAereas (nombre_aerolinea,alianza,id_aerolinea) VALUE(?,?,?)");
			psLineaAerea.setString(1,lineaaerea.getNombreAerolinea());
			psLineaAerea.setString(2, lineaaerea.getAlianza().getNombre());
			psLineaAerea.setString(3, lineaaerea.getCodigo());
			
			int fila = psLineaAerea.executeUpdate();
			System.out.println("Fila modificada "+ fila);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
		    e.printStackTrace();
		}finally {
			try {
				if(!psLineaAerea.isClosed())
					psLineaAerea.close();
				
				if (!DBCon.isClosed())
					DBCon.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}  // Cierre de finally
	} // Cierre AltaLineaAerea
	
	
	
	public void bajaLineaAerea(LineaAerea BajarLineaAerea) {
		Connection DBCon = null;
		PreparedStatement psLineaAerea = null;
		
		try {
			
			DBCon = getConnection();
			psLineaAerea = DBCon.prepareStatement("DELETE FROM LineasAereas WHERE nombre_aerolinea");
			
			psLineaAerea.setString(1,BajarLineaAerea.getNombreAerolinea());
				
			int fila = psLineaAerea.executeUpdate();
		
			System.out.println("Fila modificada "+ fila);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
		    e.printStackTrace();
		}finally {
			try {
				if(!psLineaAerea.isClosed())
					psLineaAerea.close();
				
				if (!DBCon.isClosed())
					DBCon.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}  // Cierre de finally
		
		
	}
	
}
