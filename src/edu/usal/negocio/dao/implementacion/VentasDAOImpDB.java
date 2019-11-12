package edu.usal.negocio.dao.implementacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.usal.negocio.dao.interfaces.VentaDAO;
import edu.usal.negocio.dominio.Aeropuerto;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Venta;
import edu.usal.negocio.dominio.Vuelo;

public class VentasDAOImpDB implements VentaDAO{

	public List<Venta> obtenerVentas() throws SQLException{
		ResultSet rsVenta = null;
		
		ArrayList<Venta> venta = new ArrayList<Venta>();
		
		try (Connection conexion = Connect.getConnection();
	         Statement statement = conexion.createStatement();) {
		
			String selectSql = ("SELECT V.id_venta as id_venta, V.fec_hs_venta as fec_hs_venta, V.forma_pago as forma_pago, "+
					"C.id_cliente as id_cliente, C.nombre as nombre , C.apellido as apellido, C.dni as dni, C.cuit_cuil as cuit_cuil, C.fecha_nacimiento as fecha_nacimiento, C.email as email, "+
					"Vu.id_vuelo as id_vuelo, Vu.nro_vuelo as nro_vuelo, Vu.cant_asientos as cant_asientos, Vu.fec_hs_salida as fec_hs_salida, Vu.fec_hs_llegada as fec_hs_llegada, Vu.tiempo_vuelo as tiempo_vuelo, Vu.id_aeropuerto_salida as id_aeropuerto_salida, Vu.id_aeropuerto_llegada as id_aeropuerto_llegada, "+
					"AER.id_aerolinea as id_aerolinea, AER.nombre_aerolinea as nombre_aerolinea, AER.alianza as alianza, "+
					"A.codigo_aeropuerto as codigo_aeropuerto, A.ciudad as ciudad "+
					"FROM dbo.ventas V "+
					"LEFT JOIN dbo.cliente C ON C.id_cliente = V.id_cliente "+
					"LEFT JOIN dbo.vuelos Vu ON Vu.id_vuelo = V.id_vuelo "+
					"LEFT JOIN dbo.lineasAereas AER ON AER.id_aerolinea = V.id_aerolinea "+
					"LEFT JOIN dbo.aeropuerto A ON A.id_aeropuerto = V.id_aeropuerto");
			rsVenta = statement.executeQuery(selectSql);
						
			while (rsVenta.next()) {
	        	 Venta oVenta = new Venta();
	        	 oVenta.setFechaVenta(rsVenta.getDate("fec_hs_venta"));
	        	 oVenta.setFormaPago(rsVenta.getString("forma_pago"));
	        	 
	        	 Cliente oCliente = new Cliente();
	        	 oCliente.setIdCliente(rsVenta.getInt("id_cliente"));
	        	 oCliente.setNombre(rsVenta.getString("nombre"));
	        	 oCliente.setApellido(rsVenta.getString("apellido"));
	        	 oCliente.setDNI(rsVenta.getString("dni"));
	        	 oCliente.setCUIT_CUIL(rsVenta.getString("cuit_cuil")); 
	        	 oCliente.setFechaDeNacimiento(rsVenta.getDate("fecha_nacimiento"));
				 oCliente.setEmail(rsVenta.getString("email"));
	        
				 oVenta.setCliente(oCliente);
				 
				 Vuelo oVuelo = new Vuelo();
				 oVuelo.setNumeroVuelo(rsVenta.getString("nro_vuelo"));
				 oVuelo.setCantidadAsientos(rsVenta.getInt("cant_asientos"));
				 oVuelo.setFechaSalida(rsVenta.getDate("fec_hs_salida"));
				 oVuelo.setFechaLlegada(rsVenta.getDate("fec_hs_llegada"));
				 oVuelo.setTiempoVuelo(rsVenta.getString("tiempo_vuelo"));
				 Aeropuerto oAeropuerto = new Aeropuerto();
				 oAeropuerto.setCodigoAeropuerto(rsVenta.getString("codigo_aeropuerto"));
				 oAeropuerto.setCiudad(rsVenta.getString("ciudad"));
				 
				 oVuelo.setAeropuertoSalida(oAeropuerto);
				 oVenta.setVuelo(oVuelo);
				 
				 LineaAerea oLineaAerea = new LineaAerea();
				 oLineaAerea.setNombreAerolinea(rsVenta.getString("nombre_aerolinea"));
				 oVenta.setAerolinea(oLineaAerea);
				 
				venta.add(oVenta); 		
			}
		 }
	     catch (SQLException e) {
	    	 e.printStackTrace();
	     }
		return venta;
	}

	public void altaVenta(Venta AltaVenta) throws FileNotFoundException, IOException  {
		
		String insertSqlVenta = ("INSERT INTO dbo.ventas (fec_hs_venta, forma_pago, id_cliente, id_vuelo, id_aerolinea, id_aeropuerto)" +
				"Values (?,?,?,?,?,?)");
		
		
		ResultSet resultSet = null;
		try(Connection connection = Connect.getConnection();
			PreparedStatement psInsertaVenta = connection.prepareStatement(insertSqlVenta, Statement.RETURN_GENERATED_KEYS)){
			
			java.sql.Date fechaVenta = new  java.sql.Date(AltaVenta.getFechaVenta().getTime());
			psInsertaVenta.setDate(1, fechaVenta);	
			psInsertaVenta.setString(2, AltaVenta.getFormaPago());
			psInsertaVenta.setInt(3, AltaVenta.getCliente().getIdCliente());
			psInsertaVenta.setInt(4, AltaVenta.getVuelo().getIdVuelo());
			psInsertaVenta.setInt(5, AltaVenta.getAerolinea().getIdLineaAerea());
			psInsertaVenta.setInt(6, AltaVenta.getAeropuerto().getIdAeropuerto());
			
			psInsertaVenta.execute();
			
			// Obtiene la key autogenerada
         	resultSet = psInsertaVenta.getGeneratedKeys();

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

	public void modificarVenta(Venta ModificarVenta) throws FileNotFoundException, IOException{
		
		String updateSql = "UPDATE Venta SET fec_hs_venta = ?, forma_pago = ? WHERE id_cliente = ?";
		
	//	ResultSet resultSet = null;
		
	    try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://200.41.226.133:1433;databaseName=aerolinea","sa","Usal1234");
	    		PreparedStatement psModificarVenta = connection.prepareStatement(updateSql)){
	    
	    	java.sql.Date fechaVenta = new  java.sql.Date(ModificarVenta.getFechaVenta().getTime());
	    	psModificarVenta.setDate(1,	fechaVenta);
	    	psModificarVenta.setString(2, ModificarVenta.getFormaPago());
	    	
			int filas = psModificarVenta.executeUpdate();
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
	public void bajaVenta(Venta BajarVenta) throws FileNotFoundException, IOException {
		Connection con = null;
		PreparedStatement psVenta = null;
		
		int filas = 0;
		try{
			
			con = Connect.getConnection();
			psVenta=con.prepareStatement("DELETE FROM dbo.ventas WHERE id_cliente = ?");
			
			psVenta.setInt(1, BajarVenta.getCliente().getIdCliente()); 
			filas = psVenta.executeUpdate();
			
			System.out.println("Filas Venta afectadas: " + filas);
						
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(!psVenta.isClosed()) {
					psVenta.close();
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
