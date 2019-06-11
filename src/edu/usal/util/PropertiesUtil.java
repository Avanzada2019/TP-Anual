package edu.usal.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
	
	
	public static String obtenerPathAerolineasStream() throws IOException, FileNotFoundException{
		Properties properties = new Properties();
		properties.load(new FileReader("config.properties"));
		
		return properties.getProperty("pathLineasAereasStream");
	}
	
	
	
	
	/* Se crea metodo para la aerolinea en caso que sea del tipo string */
	
	public static String obtenerPathAerolineasString() throws IOException, FileNotFoundException{
		Properties properties = new Properties();
		properties.load(new FileReader("config.properties"));
		
		return properties.getProperty("pathLineasAereasString");
	}
	
	
	public static String obtenerPathCliente() throws IOException, FileNotFoundException{
		Properties properties = new Properties();
		properties.load(new FileReader("config.properties"));
		
		return properties.getProperty("pathClientesString");
	}
	
	
}
