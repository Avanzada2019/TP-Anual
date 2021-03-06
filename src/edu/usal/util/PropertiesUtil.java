package edu.usal.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class PropertiesUtil {
	
	private static Properties properties = new Properties();
	private static PropertiesUtil objeto = null;
	 
	private PropertiesUtil() throws FileNotFoundException , IOException
	{
		properties.load(new FileReader("config.properties"));
	}
	public static PropertiesUtil getInstance() throws FileNotFoundException, IOException
	{
		if (objeto == null)
			objeto = new PropertiesUtil();
		return objeto;
	}

	public static String obtenerPathAerolineasStream() throws IOException, FileNotFoundException{
		Properties properties = new Properties();
		properties.load(new FileReader("config.properties"));
		return properties.getProperty("pathLineasAereasStream");
	}

	public static String obtenerPathClienteStream() throws IOException, FileNotFoundException{
		Properties properties = new Properties();
		properties.load(new FileReader("config.properties"));
		return properties.getProperty("pathClientesStream");
	}
	
	public static String obtenerPathAeropuertosStream() throws IOException, FileNotFoundException{
		Properties properties = new Properties();
		properties.load(new FileReader("config.properties"));
		return properties.getProperty("pathAeropuertosStream");
	}
	
	public static String obtenerPathVentasStream() throws IOException, FileNotFoundException{
		Properties properties = new Properties();
		properties.load(new FileReader("config.properties"));
		return properties.getProperty("pathVentasStream");
	}
	
	public static String obtenerPathVueloStream() throws IOException, FileNotFoundException{
		Properties properties = new Properties();
		properties.load(new FileReader("config.properties"));
		return properties.getProperty("pathVueloStream");
	}
	
	/* Se crea metodo para la aerolinea en caso que sea del tipo string */
	public static String obtenerPathAerolineasString() throws IOException, FileNotFoundException{
		Properties properties = new Properties();
		properties.load(new FileReader("config.properties"));
		return properties.getProperty("pathLineasAereasString");
	}
	
	
	public static String getSqlPath()
	{
		return properties.getProperty("sqlPath");
	}
	
	public static String getSqlUser()
	{
		return properties.getProperty("sqlUser");
	}
	
	public static String getSqlPwd()
	{
		return properties.getProperty("sqlPwd");
	}
	public static String getSqlDriver()
	{
		return properties.getProperty("sqlDriver");
	}
	
	


}
