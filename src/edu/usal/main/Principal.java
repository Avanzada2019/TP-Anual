package edu.usal.main;
import edu.usal.util.*;


public class Principal {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Update de Matias*******");
		
		
		int opcionDeMenu=0;
		
		do {
			
			opcionDeMenu= IOGeneral.leerInt(null, null);
			
		}while (opcionDeMenu!= 0);
		
		do{
			
			switch (opcionDeMenu) {
				case 1: // Gestion de Lineas Aereas
						
						
					
						break;
	
				case 2: // Gestion de Clientes
					    
					    break;
				case 3: // Gestion de Ventas
					    
								
					    break;
				case 4: // Otras Gestiones****
										
					    break;
				case 5:
					   System.out.println("Ha salido del sistema...");
					   System.in.read(); // Queda esperando a que se presione una tecla.
					   break;
			} // Fin del switch
			
	
		}while (opcionDeMenu!=6);  // Fin del menu General
		

   } //Cierre del Main

	
	
	
} // Cierre del Principal.
