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
				cliente.setFechanac(rsCliente.getDate("fecha_nacimiento"));
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
					pasaporte.setFechaemision(rsPasaporte.getDate("fecha_emision"));
					pasaporte.setFechavencimiento(rsPasaporte.getDate("fecha_vencimiento"));
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
			con = getConnection();
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
			cliente.setFechanac(rsCliente.getDate("fecha_nacimiento"));
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
				pasaporte.setFechaemision(rsPasaporte.getDate("fecha_emision"));
				pasaporte.setFechavencimiento(rsPasaporte.getDate("fecha_vencimiento"));
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
			psPasaporte.setString(1, Cliente.getPasaporte().getNumeroPasaporte());
			psPasaporte.setString(2, Cliente.getPasaporte().getAutoridadEmision());
			java.sql.Date sql1 = new  java.sql.Date(Cliente.getPasaporte().getFechaemision().getTime());
			psPasaporte.setDate(3, sql1);
			java.sql.Date sql2 = new  java.sql.Date(Cliente.getPasaporte().getFechavencimiento().getTime());
			psPasaporte.setDate(4, sql2);
			psPasaporte.setString(5, Cliente.getPasaporte().getPaisEmision().getId());
			
			filas = psPasaporte.executeUpdate();
			System.out.println("Filas afectadas Pasaporte: " + filas);
			
			
			psCliente=con.prepareStatement("INSERT INTO cliente (dni, nombre, apellido, id_pasaporte, cuit_cuil, fecha_nacimiento, email, personal, celular, laboral, id_pasajero_frecuente, calle, altura, codigo_postal, id_provincia, id_pais, ciudad)"+
			"VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
			
/*------------------------------------------------------------------------------------------------------------------------------------------------------
			psCliente.setString(1,Cliente.getDNI());
			psCliente.setString(2,Cliente.getNombre());
			psCliente.setString(3,Cliente.getApellido());
			psCliente.setString(4,Cliente.getPasaporte().getNumeroPasaporte());
			psCliente.setString(5,Cliente.getCUIT_CUIL());
			java.sql.Date sql3 = new  java.sql.Date(cliente.getFechaDeNacimiento().getTime());
			psCliente.setDate(6, sql3);
			psCliente.setString(7, Cliente.getEmail());
			psCliente.setString(8, Cliente.getTelefono().getNumeroPersonal());
			psCliente.setString(9, Cliente.getTelefono().getNumeroCelular());
			psCliente.setString(10, Cliente.getTelefono().getNumeroLaboral());
			psCliente.setString(11, Cliente.getPasajeroFrecuente().getNumero());
			psCliente.setString(12, Cliente.getDireccion().getCalle());
			psCliente.setString(13, Cliente.getDireccion().getAltura());
			psCliente.setString(14, Cliente.getDireccion().getCodigoPostal());
			psCliente.setString(15, Cliente.getDireccion().getProvincia().getId());
			psCliente.setString(16, Cliente.getDireccion().getPais().getId());
			psCliente.setString(17, Cliente.getDireccion().getCiudad());
			
PIDE QUE TODOS LOS ATRIBUTOS SEAN ESTATICOS-----------------------------------------------------------------------------------------------------------*/	
			
		
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

	}

	@Override
	public void modificarCliente(Cliente modificarCliente) throws FileNotFoundException, IOException {
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = getConnection();
			ps=con.prepareStatement("UPDATE cliente SET nombre = ?, apellido = ?, cuit_cuil = ?, fecha_nacimiento = ?, email = ?, personal = ?, celular = ?, laboral = ?, calle = ?, altura = ?, codigo_postal = ?, id_provincia = ?, id_pais = ?, ciudad = ? WHERE dni = ?");
			
			
/*--------------------------------------------------------------------------------------------------------------------------------------			
			ps.setString(1,	Cliente.getNombre());
			ps.setString(2,	Cliente.getApellido());
			ps.setString(3,	Cliente.getCUIT_CUIL());
			java.sql.Date sql1 = new  java.sql.Date(Cliente.getFechanac().getTime());
			ps.setDate(4,	sql1);
			ps.setString(5, Cliente.getEmail());
			ps.setString(6, Cliente.getTelefono().getNumeroPersonal());
			ps.setString(7, Cliente.getTelefono().getNumeroCelular());
			ps.setString(8, Cliente.getTelefono().getNumeroLaboral());
			ps.setString(9, Cliente.getDireccion().getCalle());
			ps.setString(10, Cliente.getDireccion().getAltura());
			ps.setString(11, Cliente.getDireccion().getCodigoPostal());
			ps.setString(12, Cliente.getDireccion().getProvincia().getId());
			ps.setString(13, Cliente.getDireccion().getPais().getId());
			ps.setString(14, Cliente.getDireccion().getCiudad());
			ps.setString(15,Cliente.getDNI());
		
PIDE TODOS LOS ATRIBUTOS ESTATICOS -----------------------------------------------------------------------------------------------------*/			
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

	
	@Override
	public void eliminarCliente(Cliente eliminarCliente) throws FileNotFoundException, IOException {
		Connection con = null;
		PreparedStatement psCliente = null;
		PreparedStatement psPasaporte = null;
		int filas = 0;
		try{
			con = getConnection();
			psCliente=con.prepareStatement("DELETE FROM cliente WHERE dni = ?");
			psCliente.setString(1, Cliente.getDNI()); 
			filas = psCliente.executeUpdate();
			System.out.println("Filas Clientes afectadas: " + filas);
			
			psPasaporte=con.prepareStatement("DELETE FROM pasaporte WHERE nro_pasaporte = ?");
			psPasaporte.setString(1, Cliente.getPasaporte().getNumeroPasaporte());
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
}
