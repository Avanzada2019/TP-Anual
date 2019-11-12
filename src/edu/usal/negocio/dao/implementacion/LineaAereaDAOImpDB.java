package edu.usal.negocio.dao.implementacion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dao.interfaces.LineaAereaDAO;
import edu.usal.negocio.dominio.Aeropuerto;
import edu.usal.negocio.dominio.Alianza;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Vuelo;
import edu.usal.util.PropertiesUtil;

public  class LineaAereaDAOImpDB implements LineaAereaDAO 	{

	public List<LineaAerea> obtenerLineasAereas() throws SQLException{
		ResultSet rsAerolinea = null;
		
		ArrayList<LineaAerea> aerolinea = new ArrayList<LineaAerea>();
		
		try (Connection conexion = Connect.getConnection();
	         Statement statement = conexion.createStatement();) {
		
			String selectSql = ("SELECT AER.id_aerolinea as id_aerolinea, AER.nombre_aerolinea as nombre_aerolinea, AER.alianza as alianza " + 
								"FROM dbo.lineasAereas AER");
			rsAerolinea = statement.executeQuery(selectSql);
						
			while (rsAerolinea.next()) {
				
				LineaAerea oAerolinea = new LineaAerea();
				oAerolinea.setNombreAerolinea(rsAerolinea.getString("nombre_aerolinea"));
				
				Alianza oAlianza = new Alianza();
				oAlianza.setNombre("alianza");
				oAerolinea.setAlianza(oAlianza);
				 
				aerolinea.add(oAerolinea); 		
			}
		 }
	     catch (SQLException e) {
	    	 e.printStackTrace();
	     }
		return aerolinea;
	}
	
	@Override
	public LineaAerea obtenerLineaAerea() {
		
		Connection con = null;
		PreparedStatement psLineaAerea = null;
		ResultSet rsLineaAerea = null;
		try{
			con = Connect.getConnection();
			psLineaAerea = con.prepareStatement("SELECT AER.id_aerolinea as id_aerolinea, AER.nombre_aerolinea as nombre_aerolinea, AER.alianza as alianza " + 
												"FROM dbo.lineasAereas as AER WHERE nombre_aerolinea = ?");
			
			psLineaAerea.setString(1, rsLineaAerea.getString("nombre_aerolinea"));
			rsLineaAerea = psLineaAerea.executeQuery();
			rsLineaAerea.next();
			
			LineaAerea aerolinea = new LineaAerea();
			aerolinea.setIdLineaAerea(rsLineaAerea.getInt("id_aerolinea"));
			aerolinea.setNombreAerolinea(rsLineaAerea.getString("nombre_aerolinea"));
			
			Alianza alianza = new Alianza();
			alianza.setNombre(rsLineaAerea.getString("alianza"));
			aerolinea.setAlianza(alianza);
				
			return aerolinea;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally{
			try{
				if(psLineaAerea != null && !psLineaAerea.isClosed()){
					psLineaAerea.close();
				}
				if(!con.isClosed()){
					con.close();
				}
				}catch (SQLException e) {
					e.printStackTrace();
				}	
			}
	}
	/*
	@Override
	public List<LineaAerea> obtenerLineaAerea() {
		
		Connection DBCon = null;
		Statement stm = null;
		ResultSet rsLineaAerea = null;
		PreparedStatement psAlianza = null;
		ResultSet rsAlianza = null;
		
		try {
			
			DBCon = Connect.getConnection();
			stm = DBCon.createStatement();
			rsLineaAerea = stm.executeQuery("SELECT * from lineasAereas"); // lineasAereas corresponde con la tabla de la BD aerolinea
			psAlianza = DBCon.prepareStatement("SELECT * from alianza WHERE nombre_alianza =?"); // Esta tabla aun no esta en la BD.
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
		
	} // Cierre del metodo obtenerLineaAerea
	*/

	
	@Override
	public void altaLineaAerea(LineaAerea lineaaerea) {
		
		Connection DBCon = null;
		PreparedStatement psLineaAerea = null;
		
		try {
			
			DBCon = Connect.getConnection();
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
	
	
	@Override
	public void bajaLineaAerea(LineaAerea BajarLineaAerea) {
		Connection DBCon = null;
		PreparedStatement psLineaAerea = null;
		
		try {
			
			DBCon = Connect.getConnection();
			psLineaAerea = DBCon.prepareStatement("DELETE FROM lineasAereas WHERE nombre_aerolinea = ?");
			
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
	}  // Cierre de BajarLineaAerea
	
	
	
	@Override
	public void modificarLineaAerea(LineaAerea modificarLineaAerea) throws FileNotFoundException, IOException {
				
		Connection DBCon = null;
		PreparedStatement psLineaAerea = null;
//		ResultSet rsLineaAerea = null;
		try{
			DBCon = Connect.getConnection();
			psLineaAerea=DBCon.prepareStatement("UPDATE lineasAereas SET nombre_aerolinea = ?, alianza = ? WHERE nombre_aerolinea = ?");
			
//			psLineaAerea.setString(1, modificarLineaAerea.getNombreAerolinea());
//			rsLineaAerea = psLineaAerea.executeQuery();
//			if(rsLineaAerea.next()) {
				psLineaAerea.setString(1, modificarLineaAerea.getNombreAerolinea());
				psLineaAerea.setString(2, modificarLineaAerea.getAlianza().getNombre());
//			}
//			psLineaAerea.setString(2, modificarLineaAerea.getAlianza().getNombre());
			
			int filas = psLineaAerea.executeUpdate();
			
			System.out.println("Filas afectadas: " + filas);
			
		}catch(SQLException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(!psLineaAerea.isClosed()){
					psLineaAerea.close();
				}
				if(!DBCon.isClosed()){
					DBCon.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}  // Cierre de modificarLineaAerea
	
}
