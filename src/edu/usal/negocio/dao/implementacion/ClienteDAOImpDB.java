package edu.usal.negocio.dao.implementacion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.usal.negocio.dao.interfaces.ClienteDAO;
import edu.usal.negocio.dominio.LineaAerea;
import edu.usal.negocio.dominio.Cliente;
import edu.usal.negocio.dominio.Direccion;
import edu.usal.negocio.dominio.Pais;
import edu.usal.negocio.dominio.PasajeroFrecuente;
import edu.usal.negocio.dominio.Pasaporte;
import edu.usal.negocio.dominio.Provincia;
import edu.usal.negocio.dominio.Telefono;
import edu.usal.util.PropertiesUtil;

public class ClienteDAOImpDB implements ClienteDAO {
	/*
	private static Connection getConnection() throws SQLException {
		Connection con = null;
		try{
			Class.forName(PropertiesUtil.getSqlDriver());
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		con = DriverManager.getConnection(PropertiesUtil.getSqlPath(),PropertiesUtil.getSqlUser(), PropertiesUtil.getSqlPwd());
		return con;
	}
	
	
	
	
	/* OBTENER CLIENTES QUE TENIAMOS
	 

	public List<Cliente> obtenerClientes(){
		Connection con = null;
		Statement s = null;
		PreparedStatement psPasaporte = null;
		PreparedStatement psPasajeroFrecuente = null;
		ResultSet rsCliente = null;
		ResultSet rsPasaporte = null;
		ResultSet rsPasajeroFrecuente = null;
		try{
			con = getConnection();
			s = con.createStatement();
			rsCliente = s.executeQuery("SELECT * FROM cliente");
			psPasaporte = con.prepareStatement("SELECT * FROM pasaporte WHERE nro_pasaporte = ?");
			psPasajeroFrecuente = con.prepareStatement("SELECT * FROM pasajero_frecuente WHERE numero = ?");
			
			List<Cliente> clientes = new ArrayList<Cliente>();
			
			while(rsCliente.next()) {
				
				Cliente cliente = new Cliente();
				cliente.setNombre(rsCliente.getString("nombre"));
				cliente.setApellido(rsCliente.getString("apellido"));
				cliente.setDNI(rsCliente.getString("dni"));
				cliente.setCUIT_CUIL(rsCliente.getString("cuit"));
				Date fechaNacimiento = rsCliente.getDate("fecha_nacimiento");
				cliente.setFechaDeNacimiento(new java.util.Date(fechaNacimiento.getTime()));
		//		cliente.setFechaDeNacimiento(rsCliente.getDate("fecha_nacimiento"));
				cliente.setEmail(rsCliente.getString("email"));
				
				Telefono telefono = new Telefono();
				telefono.setNumeroPersonal(rsCliente.getString("numero_personal"));
				telefono.setNumeroCelular(rsCliente.getString("numero_celular"));
				telefono.setNumeroLaboral(rsCliente.getString("numero_laboral"));
				cliente.setTelefono(telefono);
				
				Direccion direccion = new Direccion();
				direccion.setCalle(rsCliente.getString("calle"));
				direccion.setAltura(rsCliente.getString("altura"));
				direccion.setCodigoPostal(rsCliente.getString("codigo_postal"));
				direccion.setCiudad(rsCliente.getString("ciudad"));
				
				Pais paisDireccion = new Pais();
				paisDireccion.setNombre(rsCliente.getString("id_pais"));
				direccion.setPais(paisDireccion);

				Provincia provincia = new Provincia();
				provincia.setNombre(rsCliente.getString("id_provincia"));
				direccion.setProvincia(provincia);
				
				cliente.setDireccion(direccion);
				
				psPasaporte.setString(1, rsCliente.getString("id_pasaporte"));
				rsPasaporte = psPasaporte.executeQuery();
				if(rsPasaporte.next()) {
					
					Pasaporte pasaporte = new Pasaporte ();
					pasaporte.setNumeroPasaporte(rsPasaporte.getString("nro_pasaporte"));
					pasaporte.setAutoridadEmision(rsPasaporte.getString("autoridad_emision"));
					Date fechaEmision = rsCliente.getDate("fecha_nacimiento");
					pasaporte.setFechaEmision(new java.util.Date(fechaEmision.getTime()));
					Date fechaVencimiento = rsCliente.getDate("fecha_nacimiento");
					pasaporte.setFechaVencimiento(new java.util.Date(fechaVencimiento.getTime()));
					
					Pais paisPasaporte = new Pais();
					paisPasaporte.setNombre(rsPasaporte.getString("id_pais"));
					cliente.setPasaporte(pasaporte);
				}

				psPasajeroFrecuente.setString(1, rsCliente.getString("id_pasajero_frecuente"));
				rsPasajeroFrecuente = psPasajeroFrecuente.executeQuery();
				if(rsPasajeroFrecuente.next()) {
					PasajeroFrecuente pf = new PasajeroFrecuente();
					pf.setNumero(rsPasajeroFrecuente.getString("numero"));
					pf.setCategoria(rsPasajeroFrecuente.getString("categoria"));
					
					LineaAerea aerolinea = new LineaAerea();
					aerolinea.setNombreAerolinea(rsPasajeroFrecuente.getString("id_aerolinea"));
					pf.setAerolinea(aerolinea);
					cliente.setPasajerofrecuente(pf);
				}
				clientes.add(cliente);
				
			}
			return clientes;
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}
			catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			finally {
				try {
					if(psPasaporte != null && !psPasaporte.isClosed()) {
						psPasaporte.close();
					}
					if(psPasajeroFrecuente != null && !psPasajeroFrecuente.isClosed()) {
						psPasajeroFrecuente.close();
					}
					if(s != null && !s.isClosed()){
						s.close();
					}
					if(con != null && !con.isClosed())
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}	
			}
		}
		*/
	public List<Cliente> obtenerClientes() throws SQLException{
		ResultSet rsCliente = null;
		
		ArrayList<Cliente> cliente = new ArrayList<Cliente>();
		
		try (//Connection connection = DriverManager.getConnection(connectionUrl);
				Connection conexion = Connect.getConnection();
	             Statement statement = conexion.createStatement();) {
		
			String selectSql = ("SELECT C.id_cliente as id_cliente, C.nombre as nombre , C.apellido as apellido, C.dni as dni, C.cuit_cuil as cuit_cuil, C.fecha_nacimiento as fecha_nacimiento, C.email as email,"
					+ " T.personal as personal, T.celular as celular, T.laboral as laboral,"
					+ " D.id_direccion as id_direccion, D.id_pais as id_pais, D.id_provincia as id_provincia, D.id_cliente as id_cliente, D.calle as calle, D.altura as altura, D.ciudad as ciudad, D.codigo_postal as codigo_postal,"
					+ " Pa.id_pais as id_pais, Pa.nombre_pais as nombre_pais,"
					+ " Prov.id_provincia as id_provincia, Prov.nombre_provincia as nombre_provincia,"
					+ " Ppt.id_pasaporte as id_pasaporte, Ppt.nro_pasaporte as nro_pasaporte, Ppt.autoridad_emision as autoridad_emision, Ppt.fecha_emision as fecha_emision, Ppt.fecha_vencimiento as fecha_vencimiento, Ppt.id_pais as id_pais, Ppt.id_cliente as id_cliente,"
					+ " PF.id_pasajero_frecuente as id_pasajero_frecuente, PF.alianza as alianza, PF.numero as numero, PF.categoria as categoria, PF.id_cliente as id_cliente, PF.id_aerolinea as id_aerolinea,"
					+ " AER.id_aerolinea as id_aerolinea, AER.nombre_aerolinea as nombre_aerolinea, AER.alianza as alianza"
					+ " FROM dbo.cliente C "
					+ " LEFT JOIN dbo.telefono T ON C.id_cliente = T.id_cliente"
					+ " LEFT JOIN dbo.direccion D ON C.id_cliente = D.id_cliente"
					+ " LEFT JOIN dbo.pais Pa ON D.id_pais = Pa.id_pais"
					+ " LEFT JOIN dbo.provincia Prov ON D.id_provincia = Prov.id_provincia"
					+ " LEFT JOIN dbo.pasaporte Ppt ON C.id_cliente = Ppt.id_cliente"
					+ " LEFT JOIN dbo.pasajero_frecuente PF ON C.id_cliente = PF.id_cliente"
					+ " LEFT JOIN dbo.lineasAereas AER ON PF.id_aerolinea = AER.id_aerolinea");
			rsCliente = statement.executeQuery(selectSql);
						
			while (rsCliente.next()) {
	        	 Cliente oCliente = new Cliente();
	        	 oCliente.setIdCliente(rsCliente.getInt("id_cliente"));
	        	 oCliente.setNombre(rsCliente.getString("nombre"));
	        	 oCliente.setApellido(rsCliente.getString("apellido"));
	        	 oCliente.setDNI(rsCliente.getString("dni"));
	        	 oCliente.setCUIT_CUIL(rsCliente.getString("cuit_cuil")); 
	        	 oCliente.setFechaDeNacimiento(rsCliente.getDate("fecha_nacimiento"));
				 oCliente.setEmail(rsCliente.getString("email"));
				 
				 Telefono oTelefono = new Telefono();
				 oTelefono.setNumeroPersonal(rsCliente.getString("personal"));
				 oTelefono.setNumeroCelular(rsCliente.getString("celular"));
				 oTelefono.setNumeroLaboral(rsCliente.getString("laboral"));				
				 oCliente.setTelefono(oTelefono);
				 
				 Direccion oDireccion = new Direccion();
				 oDireccion.setCalle(rsCliente.getString("calle"));
				 oDireccion.setAltura(rsCliente.getString("altura"));
				 oDireccion.setCodigoPostal(rsCliente.getString("codigo_postal"));
				 oDireccion.setCiudad(rsCliente.getString("ciudad"));
					
				 Pais oPaisDireccion = new Pais();
				 oPaisDireccion.setNombre(rsCliente.getString("nombre_pais"));
				 oDireccion.setPais(oPaisDireccion);

				 Provincia oProvincia = new Provincia();
				 oProvincia.setNombre(rsCliente.getString("nombre_provincia"));
				 oDireccion.setProvincia(oProvincia);
					
				 oCliente.setDireccion(oDireccion);
				 
				 Pasaporte oPasaporte = new Pasaporte();
				 oPasaporte.setNumeroPasaporte(rsCliente.getString("nro_pasaporte"));
				 oPasaporte.setAutoridadEmision(rsCliente.getString("autoridad_emision")); 
				 oPasaporte.setFechaEmision(rsCliente.getDate("fecha_emision"));
				 oPasaporte.setFechaVencimiento(rsCliente.getDate("fecha_vencimiento"));
				 oCliente.setPasaporte(oPasaporte);
		
				 PasajeroFrecuente oPasajeroFrecuente = new PasajeroFrecuente();
				 oPasajeroFrecuente.setNumero(rsCliente.getString("numero"));
				 oPasajeroFrecuente.setCategoria(rsCliente.getString("categoria"));
				 LineaAerea aerolinea = new LineaAerea();
				 aerolinea.setNombreAerolinea(rsCliente.getString("nombre_aerolinea"));
				 oPasajeroFrecuente.setAerolinea(aerolinea);
				 oCliente.setPasajerofrecuente(oPasajeroFrecuente);
				 
				 
				cliente.add(oCliente); 		
			}
			 
			Iterator<Cliente> iterCliente= cliente.iterator();
			while(iterCliente.hasNext()){
		 			
				Cliente oIterCliente=(Cliente)iterCliente.next();
		 			
		 			
				System.out.println("id_cliente : "+ oIterCliente.getIdCliente());
				System.out.println("Nombre : "+oIterCliente.getNombre());
				System.out.println("Apellido : "+oIterCliente.getApellido());
				System.out.println("DNI : "+oIterCliente.getDNI());
				System.out.println("Fecha Nacimiento : "+oIterCliente.getFechaDeNacimiento());
				System.out.println("Email : "+oIterCliente.getEmail());
		 			
				System.out.println("Datos Telefono : ");
				System.out.println("	-Personal : "+oIterCliente.getTelefono().getNumeroPersonal());
				System.out.println("	-Celular : "+oIterCliente.getTelefono().getNumeroCelular());
				System.out.println("	-Laboral : "+oIterCliente.getTelefono().getNumeroLaboral());
			
				System.out.println("Datos Direccion : ");
				System.out.println("	-Pais : "+oIterCliente.getDireccion().getPais().getNombre());
				System.out.println("	-Provincia : "+oIterCliente.getDireccion().getProvincia().getNombre());
				System.out.println("	-Ciudad : "+oIterCliente.getDireccion().getCiudad());
				System.out.println("	-Direccion : "+oIterCliente.getDireccion().getCalle()+" "+oIterCliente.getDireccion().getAltura());
				System.out.println("	-Codigo postal : "+oIterCliente.getDireccion().getCodigoPostal());
				
				System.out.println("Datos Pasaporte : ");
				System.out.println("	-Numero : "+oIterCliente.getPasaporte().getNumeroPasaporte());
				System.out.println("	-Autoridad de emision : "+oIterCliente.getPasaporte().getAutoridadEmision());
				System.out.println("	-Fecha de emision : "+oIterCliente.getPasaporte().getFechaEmision());
				System.out.println("	-Fecha de vencimiento : "+oIterCliente.getPasaporte().getFechaVencimiento());
				
				System.out.println("Datos de Pasajero Frecuente : ");
				System.out.println("	-Linea aerea : "+oIterCliente.getPasajerofrecuente().getAerolinea().getNombreAerolinea());
				System.out.println("	-Numero : "+oIterCliente.getPasajerofrecuente().getNumero());
				System.out.println("	-Categoria : "+oIterCliente.getPasajerofrecuente().getCategoria());
				System.out.println("------------------------------------------------------");
			}
		 }
	     catch (SQLException e) {
	    	 e.printStackTrace();
	     }
		return cliente;
	}

	
	/* OBTENER CLIENTE POR DNI QUE TENIAMOS
	
	@Override
	public Cliente obtenerCliente() {
		
		Connection con = null;
		PreparedStatement psCliente = null;
		PreparedStatement psPasaporte = null;
		PreparedStatement psPasajeroFrecuente = null;
		ResultSet rsCliente = null;
		ResultSet rsPasaporte = null;
		ResultSet rsPasajeroFrecuente = null;
		try{
			con = Connect.getConnection();
			psCliente = con.prepareStatement("SELECT * FROM cliente WHERE dni = ?");
			psPasaporte = con.prepareStatement("SELECT * FROM pasaporte WHERE nro_pasaporte = ?");
			psPasajeroFrecuente = con.prepareStatement("SELECT * FROM pasajerofrecuente WHERE numero = ?");
			
			Cliente cliente = new Cliente();
			
			psCliente.setString(1, rsCliente.getString("dni"));
			rsCliente = psCliente.executeQuery();
			
			rsCliente.next();
			cliente.setNombre(rsCliente.getString("nombre"));
			cliente.setApellido(rsCliente.getString("apellido"));
			cliente.setDNI(rsCliente.getString("dni"));
			cliente.setCUIT_CUIL(rsCliente.getString("cuit"));
			Date fecha = rsCliente.getDate("fecha_nacimiento");
			cliente.setFechaDeNacimiento(new java.util.Date(fecha.getTime()));
			cliente.setEmail(rsCliente.getString("email"));
				
			Telefono telefono = new Telefono();
			telefono.setNumeroPersonal(rsCliente.getString("numero_personal"));
			telefono.setNumeroCelular(rsCliente.getString("numero_celular"));
			telefono.setNumeroLaboral(rsCliente.getString("numero_laboral"));
			cliente.setTelefono(telefono);
				
			Direccion direccion = new Direccion();
			direccion.setCalle(rsCliente.getString("calle"));
			direccion.setAltura(rsCliente.getString("altura"));
			direccion.setCodigoPostal(rsCliente.getString("codigo_postal"));
			direccion.setCiudad(rsCliente.getString("ciudad"));
				
			Pais paisDireccion = new Pais();
			paisDireccion.setNombre(rsCliente.getString("id_pais"));
			direccion.setPais(paisDireccion);

			Provincia provincia = new Provincia();
			provincia.setNombre(rsCliente.getString("id_provincia"));
			direccion.setProvincia(provincia);
				
			cliente.setDireccion(direccion);
				
			psPasaporte.setString(1, rsCliente.getString("id_pasaporte"));
			rsPasaporte = psPasaporte.executeQuery();
			if(rsPasaporte.next()) {
				
				Pasaporte pasaporte = new Pasaporte ();
				pasaporte.setNumeroPasaporte(rsPasaporte.getString("nro_pasaporte"));
				pasaporte.setAutoridadEmision(rsPasaporte.getString("autoridad_emision"));
				Date fechaEmision = rsCliente.getDate("fecha_nacimiento");
				pasaporte.setFechaEmision(new java.util.Date(fechaEmision.getTime()));	
				Date fechaVencimiento = rsCliente.getDate("fecha_nacimiento");
				pasaporte.setFechaEmision(new java.util.Date(fechaVencimiento.getTime()));
				
				Pais paisPasaporte = new Pais();
				paisPasaporte.setNombre(rsPasaporte.getString("id_pais"));
				cliente.setPasaporte(pasaporte);
			}

			psPasajeroFrecuente.setString(1, rsCliente.getString("id_pasajero_frecuente"));
			rsPasajeroFrecuente = psPasajeroFrecuente.executeQuery();
			if(rsPasajeroFrecuente.next()) {
				PasajeroFrecuente pf = new PasajeroFrecuente();
				pf.setNumero(rsPasajeroFrecuente.getString("numero"));
				pf.setCategoria(rsPasajeroFrecuente.getString("categoria"));
				LineaAerea aerolinea = new LineaAerea();
				aerolinea.setNombreAerolinea(rsPasajeroFrecuente.getString("id_aerolinea"));
				pf.setAerolinea(aerolinea);
				cliente.setPasajerofrecuente(pf);
			}
				
			return cliente;
			
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
				if(psCliente != null && !psCliente.isClosed()){
					psCliente.close();
				}
				if(psPasaporte != null && !psPasaporte.isClosed()) {
					psPasaporte.close();
				}
				if(psPasajeroFrecuente != null && !psPasajeroFrecuente.isClosed()) {
					psPasajeroFrecuente.close();
				}
				if(!con.isClosed()){
					con.close();
				}
				}catch (SQLException e) {
					e.printStackTrace();
				}	
			}
	}
	
	/* REGISTRAR CLIENTE QUE TENIAMOS
	 
	@Override
	public void registrarCliente(Cliente registrarCliente) throws FileNotFoundException, IOException {
		Connection con = null;
		PreparedStatement psCliente = null;
		PreparedStatement psPasaporte = null;
		int filas;
		try{
			con = getConnection();
			///ANTES INSERTAR PASAPORTE!!!
			psPasaporte= con.prepareStatement("INSERT INTO pasaporte (nro_pasaporte, autoridad_emision, fecha_emision, fecha_vencimiento, id_pais) VALUES (?, ?, ?, ?, ?)");
			psPasaporte.setString(1, registrarCliente.getPasaporte().getNumeroPasaporte());
			psPasaporte.setString(2, registrarCliente.getPasaporte().getAutoridadEmision());
			java.sql.Date sql1 = new  java.sql.Date(registrarCliente.getPasaporte().getFechaEmision().getTime());
			psPasaporte.setDate(3, sql1);
			java.sql.Date sql2 = new  java.sql.Date(registrarCliente.getPasaporte().getFechaVencimiento().getTime());
			psPasaporte.setDate(4, sql2);
			psPasaporte.setString(5, registrarCliente.getPasaporte().getPaisEmision().getId());
			
			filas = psPasaporte.executeUpdate();
			System.out.println("Filas afectadas Pasaporte: " + filas);
			
			
			psCliente=con.prepareStatement("INSERT INTO cliente (dni, nombre, apellido, id_pasaporte, cuit_cuil, fecha_nacimiento, email, personal, celular, laboral, id_pasajero_frecuente, calle, altura, codigo_postal, id_provincia, id_pais, ciudad)"+
			"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
			

			psCliente.setString(1,registrarCliente.getDNI());
			psCliente.setString(2,registrarCliente.getNombre());
			psCliente.setString(3,registrarCliente.getApellido());
			psCliente.setString(4,registrarCliente.getPasaporte().getNumeroPasaporte());
			psCliente.setString(5,registrarCliente.getCUIT_CUIL());
			java.sql.Date sql3 = new  java.sql.Date(registrarCliente.getFechaDeNacimiento().getTime());
			psCliente.setDate(6, sql3);
			psCliente.setString(7, registrarCliente.getEmail());
			psCliente.setString(8, registrarCliente.getTelefono().getNumeroPersonal());
			psCliente.setString(9, registrarCliente.getTelefono().getNumeroCelular());
			psCliente.setString(10, registrarCliente.getTelefono().getNumeroLaboral());
			psCliente.setString(11, registrarCliente.getPasajerofrecuente().getNumero());
			psCliente.setString(12, registrarCliente.getDireccion().getCalle());
			psCliente.setString(13, registrarCliente.getDireccion().getAltura());
			psCliente.setString(14, registrarCliente.getDireccion().getCodigoPostal());
			psCliente.setLong(15, registrarCliente.getDireccion().getProvincia().getId());
			psCliente.setString(16, registrarCliente.getDireccion().getPais().getId());
			psCliente.setString(17, registrarCliente.getDireccion().getCiudad());
			
	
			
		
			filas = psCliente.executeUpdate();
			System.out.println("Filas afectadas Clientes: " + filas);
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				if(!psCliente.isClosed()) {
					psCliente.close();
				}
				if(!con.isClosed()){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}*/
	
public void registrarCliente(Cliente registrarCliente) throws FileNotFoundException, IOException {
		
		String insertSqlCliente = ("INSERT INTO dbo.cliente(nombre, apellido, dni, cuit_cuil, fecha_nacimiento, email, id_cliente)" + 
				"Values (?,?,?,?,?,?)");
		
		String insertSqlTelefono = ("INSERT INTO dbo.telefono(id_cliente, personal, celular, laboral, id_telefono)" + 
				"Values (?,?,?,?,?)");
		
		String insertSqlDireccion = ("INSERT INTO dbo.direccion(ciudad, codigo_postal, calle, altura, id_cliente, id_pais, id_provincia, id_direccion" + 
				"Values (?,?,?,?,?,?,?,?)");
		
		String insertSqlPasajeroFrecuente = ("INSERT INTO dbo.pasajero_frecuente(alianza, numero, categoria, id_cliente, id_aerolinea, id_pasajero_frecuente)" +
				"Values (?,?,?,?,?,?)");
		
		ResultSet resultSet = null;
		try(//Connection con = Connect.getConnection();	
			Connection connection = Connect.getConnection();
			PreparedStatement psInsertaCliente = connection.prepareStatement(insertSqlCliente, Statement.RETURN_GENERATED_KEYS);
			PreparedStatement psInsertaTelefono = connection.prepareStatement(insertSqlTelefono, Statement.RETURN_GENERATED_KEYS);
			PreparedStatement psInsertaDireccion = connection.prepareStatement(insertSqlDireccion, Statement.RETURN_GENERATED_KEYS);
			PreparedStatement psInsertaPasajeroFrecuente = connection.prepareStatement(insertSqlPasajeroFrecuente, Statement.RETURN_GENERATED_KEYS)){
			
			
			psInsertaCliente.setString(1, registrarCliente.getNombre());
			psInsertaCliente.setString(2, registrarCliente.getApellido());
			psInsertaCliente.setString(3, registrarCliente.getDNI());
			psInsertaCliente.setString(4, registrarCliente.getCUIT_CUIL());			
			java.sql.Date fechaNacimiento = new  java.sql.Date(registrarCliente.getFechaDeNacimiento().getTime());
			psInsertaCliente.setDate(5, fechaNacimiento);	
			psInsertaCliente.setString(6, registrarCliente.getEmail());
			psInsertaCliente.setInt(7, registrarCliente.getIdCliente());
		
			// Inserta Telefono del Cliente
			psInsertaTelefono.setInt(1, registrarCliente.getIdCliente());
			psInsertaTelefono.setString(2, registrarCliente.getTelefono().getNumeroPersonal());
			psInsertaTelefono.setString(3, registrarCliente.getTelefono().getNumeroCelular());
			psInsertaTelefono.setString(4, registrarCliente.getTelefono().getNumeroLaboral());
			psInsertaTelefono.setInt(5, registrarCliente.getTelefono().getId_telefono());
			// Inserta Direccion del Cliente
			psInsertaDireccion.setString(1, registrarCliente.getDireccion().getCiudad());
			psInsertaDireccion.setString(2, registrarCliente.getDireccion().getCodigoPostal());
			psInsertaDireccion.setString(3, registrarCliente.getDireccion().getCalle());
			psInsertaDireccion.setString(4, registrarCliente.getDireccion().getAltura());
			psInsertaDireccion.setInt(5, registrarCliente.getIdCliente());
			psInsertaDireccion.setInt(6, registrarCliente.getDireccion().getPais().getId());
			psInsertaDireccion.setInt(7, registrarCliente.getDireccion().getProvincia().getId());
			psInsertaDireccion.setInt(8, registrarCliente.getDireccion().getId_direccion());
			
			
			// Inserta Pasajero Frecuente del Cliente
			psInsertaPasajeroFrecuente.setString(1, registrarCliente.getPasajerofrecuente().getAlianza().getNombre());
			psInsertaPasajeroFrecuente.setString(2, registrarCliente.getPasajerofrecuente().getNumero());
			psInsertaPasajeroFrecuente.setString(3, registrarCliente.getPasajerofrecuente().getCategoria());
			psInsertaPasajeroFrecuente.setString(4, registrarCliente.getPasajerofrecuente().getNumero());
			psInsertaPasajeroFrecuente.setInt(5, registrarCliente.getIdCliente());
			psInsertaPasajeroFrecuente.setInt(5, registrarCliente.getPasajerofrecuente().getAerolinea().getIdLineaAerea());
			psInsertaPasajeroFrecuente.setInt(5, registrarCliente.getPasajerofrecuente().getId_pasajeroFrecuente());
			
			
			psInsertaCliente.execute();
			psInsertaTelefono.execute();
			psInsertaDireccion.execute();
			psInsertaPasajeroFrecuente.execute();
			// Obtiene la key autogenerada
         	resultSet = psInsertaCliente.getGeneratedKeys();

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
/* MODIFICAR CLIENTE QUE TENIAMOS
 
	@Override
	public void modificarCliente(Cliente modificarCliente) throws FileNotFoundException, IOException {
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = Connect.getConnection();
			ps=con.prepareStatement("UPDATE cliente SET nombre = ?, apellido = ?, cuit_cuil = ?, fecha_nacimiento = ?, email = ?, personal = ?, celular = ?, laboral = ?, calle = ?, altura = ?, codigo_postal = ?, id_provincia = ?, id_pais = ?, ciudad = ? WHERE dni = ?");
			
		
			ps.setString(1,	modificarCliente.getNombre());
			ps.setString(2,	modificarCliente.getApellido());
			ps.setString(3,	modificarCliente.getCUIT_CUIL());
			java.sql.Date sql1 = new  java.sql.Date(modificarCliente.getFechaDeNacimiento().getTime());
			ps.setDate(4,	sql1);
			ps.setString(5, modificarCliente.getEmail());
			ps.setString(6, modificarCliente.getTelefono().getNumeroPersonal());
			ps.setString(7, modificarCliente.getTelefono().getNumeroCelular());
			ps.setString(8, modificarCliente.getTelefono().getNumeroLaboral());
			ps.setString(9, modificarCliente.getDireccion().getCalle());
			ps.setString(10, modificarCliente.getDireccion().getAltura());
			ps.setString(11, modificarCliente.getDireccion().getCodigoPostal());
			ps.setLong(12, modificarCliente.getDireccion().getProvincia().getId());
			ps.setString(13, modificarCliente.getDireccion().getPais().getId());
			ps.setString(14, modificarCliente.getDireccion().getCiudad());
			ps.setString(15, modificarCliente.getDNI());
		
	
			int filas = ps.executeUpdate();
			System.out.println("Filas afectadas: " + filas);
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(!ps.isClosed()){
					ps.close();
				}
				if(!con.isClosed()){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
*/


	public void modificarCliente(Cliente modificarCliente) throws FileNotFoundException, IOException{
		
		String updateSql = "UPDATE cliente SET nombre = ?, apellido = ?, cuit_cuil = ?, fecha_nacimiento = ?, email = ? WHERE dni = ?";
		
		String updateSqlTelefono = "UPDATE telefono SET personal = ?, celular = ?, laboral =? WHERE id_cliente = ?";
		
		String updateSqlDireccion = "UPDATE direccion SET calle = ?, altura = ?, ciudad = ?, codigo_postal = ?, id_pais = ?, id_provincia = ? WHERE id_cliente = ?";
	//	ResultSet resultSet = null;
		
	    try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://200.41.226.133:1433;databaseName=aerolinea","sa","Usal1234");
	    		PreparedStatement psModificarCliente = connection.prepareStatement(updateSql);
	    		PreparedStatement psModificarTelefono = connection.prepareStatement(updateSqlTelefono);
	    		PreparedStatement psModificarDireccion = connection.prepareStatement(updateSqlDireccion)){
	    
	    //	psModificarCliente.setString(1, "200000000000"); // Cambiar este numero cada vez que ejecuten
	    	psModificarCliente.setString(1, modificarCliente.getNombre());
	    	psModificarCliente.setString(2,	modificarCliente.getApellido());
	    	psModificarCliente.setString(3, modificarCliente.getCUIT_CUIL());
	    	java.sql.Date fechaNacimiento = new  java.sql.Date(modificarCliente.getFechaDeNacimiento().getTime());
	    	psModificarCliente.setDate(4,	fechaNacimiento);
	    	psModificarCliente.setString(5, modificarCliente.getEmail());
	    	psModificarCliente.setString(6, modificarCliente.getDNI());
			
	    	psModificarTelefono.setString(1, modificarCliente.getTelefono().getNumeroPersonal());
	    	psModificarTelefono.setString(2, modificarCliente.getTelefono().getNumeroCelular());
	    	psModificarTelefono.setString(3, modificarCliente.getTelefono().getNumeroLaboral());
			
	    	psModificarDireccion.setString(1, modificarCliente.getDireccion().getCalle());
	    	psModificarDireccion.setString(2, modificarCliente.getDireccion().getAltura());
	    	psModificarDireccion.setString(3, modificarCliente.getDireccion().getCiudad());
	    	psModificarDireccion.setString(4, modificarCliente.getDireccion().getCodigoPostal());
	    	psModificarDireccion.setInt(5, modificarCliente.getDireccion().getPais().getId());
	    	psModificarDireccion.setInt(6, modificarCliente.getDireccion().getProvincia().getId());
	    	
			int filas = psModificarCliente.executeUpdate();
			System.out.println("Filas afectadas: " + filas);
			int filasTelefono = psModificarTelefono.executeUpdate();
			System.out.println("Filas afectadas telefono: " + filasTelefono);
			int filasDireccion = psModificarDireccion.executeUpdate();
			System.out.println("Filas afectadas direccion: " + filasDireccion);
	    }
	    
	    // Handle any errors that may have occurred.
	    catch (SQLException e) {
	        e.printStackTrace();
	    }
		catch (Exception e) {
			e.printStackTrace();
		}    
	}

/* ELIMINAR CLIENTE QUE TENIAMOS
 
	@Override
	public void eliminarCliente(Cliente eliminarCliente) throws FileNotFoundException, IOException {
		Connection con = null;
		PreparedStatement psCliente = null;
		PreparedStatement psPasaporte = null;
		
		int filas = 0;
		try{
			con = Connect.getConnection();
			psCliente=con.prepareStatement("DELETE FROM cliente WHERE dni = ?");
			psCliente.setString(1, eliminarCliente.getDNI()); 
			filas = psCliente.executeUpdate();
			System.out.println("Filas Clientes afectadas: " + filas);
			
			psPasaporte=con.prepareStatement("DELETE FROM pasaporte WHERE nro_pasaporte = ?");
			psPasaporte.setString(1, eliminarCliente.getPasaporte().getNumeroPasaporte());
			filas = psPasaporte.executeUpdate();
			System.out.println("Filas Pasaportes afectadas: " + filas);
			
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(!psCliente.isClosed()) {
					psCliente.close();
				}
				if(!psPasaporte.isClosed()) {
					psCliente.close();
				}
				if(!con.isClosed()){
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	*/
	
	@Override
	public void eliminarCliente(Cliente eliminarCliente) throws FileNotFoundException, IOException {
		Connection con = null;
		PreparedStatement psCliente = null;
		PreparedStatement psPasaporte = null;
		PreparedStatement psTelefono = null;
		PreparedStatement psDireccion = null;
		PreparedStatement psPasajeroFrecuente = null;
		
		int filas = 0;
		try{
			con = Connect.getConnection();
			psCliente=con.prepareStatement("DELETE FROM cliente WHERE dni = ?");
			psCliente.setString(1, eliminarCliente.getDNI()); 
			filas = psCliente.executeUpdate();
			System.out.println("Filas Cliente afectadas: " + filas);
			
			psPasaporte=con.prepareStatement("DELETE FROM pasaporte WHERE nro_pasaporte = ?");
			psPasaporte.setString(1, eliminarCliente.getPasaporte().getNumeroPasaporte());
			filas = psPasaporte.executeUpdate();
			System.out.println("Filas Pasaporte afectadas: " + filas);
			
			psTelefono=con.prepareStatement("DELETE FROM telefono WHERE id_cliente = ?");
			psTelefono.setInt(1, eliminarCliente.getIdCliente());
			filas = psTelefono.executeUpdate();
			System.out.println("Filas Telefono afectadas: " + filas);
			
			psDireccion=con.prepareStatement("DELETE FROM direccion WHERE id_cliente = ?");
			psDireccion.setInt(1, eliminarCliente.getIdCliente());
			filas = psDireccion.executeUpdate();
			System.out.println("Filas Direccion afectadas: " + filas);
			
			psPasajeroFrecuente=con.prepareStatement("DELETE FROM pasajero_frecuente WHERE id_cliente = ?");
			psPasajeroFrecuente.setInt(1, eliminarCliente.getIdCliente());
			filas = psPasajeroFrecuente.executeUpdate();
			System.out.println("Filas Pasajero Frecuente afectadas: " + filas);
						
		}catch(SQLException e){
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(!psCliente.isClosed()) {
					psCliente.close();
				}
				if(!psPasaporte.isClosed()) {
					psCliente.close();
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
