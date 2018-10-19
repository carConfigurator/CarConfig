package config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class ConfigurationLoader {
	
	private static ConfigurationLoader configLoad;
	
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	private Document document;
	
	private String language,language_default,postfix_language_file_name,version,language_files_path,car_configuration_path,car_configuration_file_name,employee_list,employee_version,employee_password,specifications_file_path;
	
	private ConfigurationLoader() {
		this.factory = DocumentBuilderFactory.newInstance();
		try {
			this.builder = factory.newDocumentBuilder();
			this.document = builder.parse(new File("src\\config\\cv_config.xml"));
		} catch (ParserConfigurationException e) {
			System.out.println("[ERROR] - No se ha podido parsear la configuraci�n. M�s informaci�n del error: " + e);
		} catch (SAXException e) {
			System.out.println("[ERROR] - No se ha podido parsear el archivo XML. M�s informaci�n del error: " + e);
		} catch (IOException e) {
			System.out.println("[ERROR] - Error de E/S. M�s informaci�n del error: " + e);
		}
	}
	
	public static ConfigurationLoader getConfigurationLoaderInstance() {
		if(configLoad == null) {
			System.out.println("[INFO] - Generando instancia...");
			return configLoad = new ConfigurationLoader();
		}else {
			System.out.println("[INFO] - Ya existe una instancia");
			return null;
		}
	}
}
