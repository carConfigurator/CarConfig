package config.testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import config.ConfigurationLoader;

public class ReadConfigTEST {
	
	public static void main(String[] args) {
		//Llamada al método de prueba de lectura del XML
		getDocument();
		
	}
	
	/*
	 * Método que muestra la información del Documento XML
	 */
	public static void getDocument() {
		try {
			FileInputStream fis = new FileInputStream(new File("cv_config.xml"));
			int content;
			while((content = fis.read()) != -1) {
				System.out.print((char) content);
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
