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
		System.out.println("Set Prova - Alexis");
		
	}
	
	/*
	 * Método que muestra la información del Documento XML
	 */
	private static void getDocument() {
		try {
			FileInputStream fis = new FileInputStream(new File("src\\config\\cv_config.xml"));
			readDocument(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void readDocument(FileInputStream fis) {
		int content;
		try {
			while((content = fis.read()) != -1) {
				System.out.print((char) content);
			}
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
