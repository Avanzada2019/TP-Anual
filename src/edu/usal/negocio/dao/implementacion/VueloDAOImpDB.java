package edu.usal.negocio.dao.implementacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dao.interfaces.VueloDAO;
import edu.usal.negocio.dominio.Aeropuerto;
import edu.usal.negocio.dominio.Vuelo;

public class VueloDAOImpDB implements VueloDAO {

	public List<Vuelo> obtenerVuelos() throws SQLException{
		ResultSet rsVuelo = null;
		
		ArrayList<Vuelo> vuelo = new ArrayList<Vuelo>();
		
		try (Connection conexion = Connect.getConnection();
	         Statement statement = conexion.createStatement();) {
		
			String selectSql = ("SELECT Vu.id_vuelo as id_vuelo,  Vu.nro_vuelo as nro_vuelo, Vu.cant_asientos as cant_asientos, Vu.fec_hs_salida as fec_hs_salida, Vu.fec_hs_llegada as fec_hs_llegada, Vu.tiempo_vuelo as tiempo_vuelo, Vu.id_aeropuerto_salida as id_aeropuerto_salida, Vu.id_aeropuerto_llegada as id_aeropuerto_llegada " + 
								"FROM dbo.vuelos Vu");
			rsVuelo = statement.executeQuery(selectSql);
						
			while (rsVuelo.next()) {
				 
				 Vuelo oVuelo = new Vuelo();
				 oVuelo.setNumeroVuelo(rsVuelo.getString("nro_vuelo"));
				 oVuelo.setCantidadAsientos(rsVuelo.getInt("cant_asientos"));
				 oVuelo.setFechaSalida(rsVuelo.getDate("fec_hs_salida"));
				 oVuelo.setFechaLlegada(rsVuelo.getDate("fec_hs_llegada"));
				 oVuelo.setTiempoVuelo(rsVuelo.getString("tiempo_vuelo"));
				 
				 Aeropuerto oAeropuertoSalida = new Aeropuerto();
				 oAeropuertoSalida.setCodigoAeropuerto(rsVuelo.getString("codigo_aeropuerto"));
				 oAeropuertoSalida.setCiudad(rsVuelo.getString("ciudad"));
				 oVuelo.setAeropuertoSalida(oAeropuertoSalida);
				 
				 Aeropuerto oAeropuertoLlegada = new Aeropuerto();
				 oAeropuertoLlegada.setCodigoAeropuerto(rsVuelo.getString("codigo_aeropuerto"));
				 oAeropuertoLlegada.setCiudad(rsVuelo.getString("ciudad"));
				 oVuelo.setAeropuertoSalida(oAeropuertoLlegada);
				 
				 vuelo.add(oVuelo); 		
			}
		 }
	     catch (SQLException e) {
	    	 e.printStackTrace();
	     }
		return vuelo;
	}
	
	
	@Override
	public Vuelo obtenerVuelo() {
		
		Connection con = null;
		PreparedStatement psVuelo = null;
		ResultSet rsVuelo = null;
		try{
			con = Connect.getConnection();
			psVuelo = con.prepareStatement("SELECT Vu.id_vuelo as id_vuelo, Vu.nro_vuelo as nro_vuelo, Vu.cant_asientos as cant_asientos, Vu.fec_hs_salida as fec_hs_salida, Vu.fec_hs_llegada as fec_hs_llegada, Vu.tiempo_vuelo as tiempo_vuelo, Vu.id_aeropuerto_salida as id_aeropuerto_salida, Vu.id_aeropuerto_llegada as id_aeropuerto_llegada, " + 
								"Alleg.codigo_aeropuerto as codigo_aeropuerto_llegada, Alleg.ciudad as ciudad_llegada, " + 
								"Asal.codigo_aeropuerto as codigo_aeropuerto_salida, Asal.ciudad as ciudad_salida " + 
								"FROM dbo.vuelos Vu " + 
								"INNER JOIN dbo.aeropuerto Alleg ON Alleg.id_aeropuerto = Vu.id_aeropuerto_llegada " + 
								"INNER JOIN dbo.aeropuerto Asal ON Asal.id_aeropuerto = Vu.id_aeropuerto_salida " +
								"WHERE nro_vuelo = ?");
			
			Vuelo vuelo = new Vuelo();
			
			psVuelo.setString(1, rsVuelo.getString("nro_vuelo"));
			rsVuelo = psVuelo.executeQuery();
			
			rsVuelo.next();
			
			vuelo.setNumeroVuelo(rsVuelo.getString("nro_vuelo"));
			vuelo.setCantidadAsientos(rsVuelo.getInt("cant_asientos"));
			vuelo.setFechaSalida(rsVuelo.getDate("fec_hs_salida"));
			vuelo.setFechaLlegada(rsVuelo.getDate("fec_hs_llegada"));
			vuelo.setTiempoVuelo(rsVuelo.getString("tiempo_vuelo"));
			
			Aeropuerto aeropuertoSalida = new Aeropuerto();
			aeropuertoSalida.setCodigoAeropuerto("codigo_aeropuerto_salida");
			aeropuertoSalida.setCiudad(rsVuelo.getString("ciudad_salida"));
			vuelo.setAeropuertoSalida(aeropuertoSalida);
			
			Aeropuerto aeropuertoLlegada = new Aeropuerto();
			aeropuertoLlegada.setCodigoAeropuerto("codigo_aeropuerto_llegada");
			aeropuertoLlegada.setCiudad(rsVuelo.getString("ciudad_llegada"));
			vuelo.setAeropuertoLlegada(aeropuertoLlegada);
				
			return vuelo;
			
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
				if(psVuelo != null && !psVuelo.isClosed()){
					psVuelo.close();
				}
				if(!con.isClosed()){
					con.close();
				}
				}catch (SQLException e) {
					e.printStackTrace();
				}	
			}
	}
	

	public void altaVuelo(Vuelo AltaVuelo) throws FileNotFoundException, IOException {
			
			String insertSqlVuelo = ("INSERT INTO dbo.vuelos (nro_vuelo, cant_asientos, fec_hs_salida, fec_hs_llegada, tiempo_vuelo, aeropuerto_salida_id, aeropuerto_llegada_id)" +
					"Values (?,?,?,?,?,?,?)");
			
			ResultSet resultSet = null;
			try(Connection connection = Connect.getConnection();
				PreparedStatement psInsertaVuelo = connection.prepareStatement(insertSqlVuelo, Statement.RETURN_GENERATED_KEYS)){
				
				psInsertaVuelo.setString(1, AltaVuelo.getNumeroVuelo());
				psInsertaVuelo.setInt(2, AltaVuelo.getCantidadAsientos());
				java.sql.Date fechaSalida = new  java.sql.Date(AltaVuelo.getFechaSalida().getTime());
				psInsertaVuelo.setDate(3, fechaSalida);	
				java.sql.Date fechaLlegada = new  java.sql.Date(AltaVuelo.getFechaLlegada().getTime());
				psInsertaVuelo.setDate(4, fechaLlegada);	
				psInsertaVuelo.setString(5, AltaVuelo.getTiempoVuelo());
				psInsertaVuelo.setInt(6, AltaVuelo.getAeropuertoSalida().getIdAeropuerto());
				psInsertaVuelo.setInt(7, AltaVuelo.getAeropuertoLlegada().getIdAeropuerto());
				
				psInsertaVuelo.execute();
				
				// Obtiene la key autogenerada
	         	resultSet = psInsertaVuelo.getGeneratedKeys();
	
	         	// Mostrar el id generado...
	         	while (resultSet.next()) {
	         		System.out.println("Lectura: " + resultSet.getString(1));
	         	}
			}catch (SQLException e) {
		    	e.printStackTrace();
		    }
		    catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public void modificarVuelo(Vuelo ModificarVuelo) throws FileNotFoundException, IOException{
			
			String updateSql = "UPDATE dbo.vuelos SET nro_vuelo = ?, cant_asientos = ?, fec_hs_salida = ?, fec_hs_llegada = ?, tiempo_vuelo = ?, aeropuerto_salida_id = ?, aeropuerto_llegada_id = ? WHERE nro_vuelo = ?";
//			ResultSet rsVuelo = null;
		    try (Connection connection = Connect.getConnection();
		    		PreparedStatement psModificarVuelo = connection.prepareStatement(updateSql)){
		    
		    	psModificarVuelo.setString(1, ModificarVuelo.getNumeroVuelo());
//		    	rsVuelo = psModificarVuelo.executeQuery();
//		    	if(rsVuelo.next()) {
		    	psModificarVuelo.setInt(2, ModificarVuelo.getCantidadAsientos());
		    	java.sql.Date fechaSalida = new  java.sql.Date(ModificarVuelo.getFechaSalida().getTime());
		    	psModificarVuelo.setDate(3,	fechaSalida);
		    	java.sql.Date fechaLlegada = new  java.sql.Date(ModificarVuelo.getFechaLlegada().getTime());
		    	psModificarVuelo.setDate(4,	fechaLlegada);
		    	psModificarVuelo.setString(5, ModificarVuelo.getTiempoVuelo());
		    	psModificarVuelo.setInt(6, ModificarVuelo.getAeropuertoSalida().getIdAeropuerto());
		    	psModificarVuelo.setInt(7, ModificarVuelo.getAeropuertoLlegada().getIdAeropuerto());
//		    	}
				int filas = psModificarVuelo.executeUpdate();
				System.out.println("Filas afectadas: " + filas);
		    }
		    // Handle any errors that may have occurred.
		    catch (SQLException e) {
		        e.printStackTrace();
		    }
			catch (Exception e) {
				e.printStackTrace();
			}    
		}
	
	@Override
	public void bajaVuelo(Vuelo BajarVuelo) throws FileNotFoundException, IOException {
		Connection con = null;
		PreparedStatement psVuelo = null;
		
		int filas = 0;
		try{
			
			con = Connect.getConnection();
			psVuelo=con.prepareStatement("DELETE FROM dbo.vuelos WHERE nro_vuelo = ?");
			
			psVuelo.setString(1, BajarVuelo.getNumeroVuelo()); 
			filas = psVuelo.executeUpdate();
			
			System.out.println("Filas Vuelo afectadas: " + filas);
						
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(!psVuelo.isClosed()) {
					psVuelo.close();
				}
				if(!con.isClosed()){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

}
